package micdoodle8.mods.galacticraft.core.tile;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import cpw.mods.fml.common.network.NetworkRegistry.TargetPoint;
import cpw.mods.fml.relauncher.Side;
import io.netty.buffer.ByteBuf;
import micdoodle8.mods.galacticraft.core.GalacticraftCore;
import micdoodle8.mods.galacticraft.core.network.IPacketReceiver;
import micdoodle8.mods.galacticraft.core.network.NetworkUtil;
import micdoodle8.mods.galacticraft.core.network.PacketDynamic;
import micdoodle8.mods.galacticraft.core.util.Annotations.NetworkedField;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;

public abstract class TileEntityAdvanced extends TileEntity implements IPacketReceiver
{
    public int ticks = 0;
    private LinkedHashSet<Field> fieldCacheClient;
    private LinkedHashSet<Field> fieldCacheServer;
    private Map<Field, Object> lastSentData = new HashMap<Field, Object>();
    private boolean networkDataChanged = false;

    @Override
    public void updateEntity()
    {
        if (this.ticks == 0)
        {
            this.initiate();

            if (this.isNetworkedTile())
            {
                if (this.fieldCacheClient == null || this.fieldCacheServer == null)
                {
                    this.initFieldCache();
                }

                if (this.worldObj != null && this.worldObj.isRemote && this.fieldCacheClient.size() > 0)
                {
                    //Request any networked information from server on first client update (maybe client just logged on, but server networkdata didn't change recently)
                    GalacticraftCore.packetPipeline.sendToServer(new PacketDynamic(this));
                }
            }
        }

        this.ticks++;

        if (this.isNetworkedTile() && this.ticks % this.getPacketCooldown() == 0)
        {
            if (this.worldObj.isRemote && this.fieldCacheServer.size() > 0)
            {
                PacketDynamic packet = new PacketDynamic(this);
                if (networkDataChanged)
                {
                    GalacticraftCore.packetPipeline.sendToServer(packet);
                }
            }
            else if (!this.worldObj.isRemote && this.fieldCacheClient.size() > 0)
            {
                PacketDynamic packet = new PacketDynamic(this);
                if (networkDataChanged)
                {
                    GalacticraftCore.packetPipeline.sendToAllAround(packet, new TargetPoint(this.worldObj.provider.dimensionId, this.xCoord, this.yCoord, this.zCoord, this.getPacketRange()));
                }
            }
        }
    }

    private void initFieldCache()
    {
        try
        {
            this.fieldCacheClient = new LinkedHashSet<Field>();
            this.fieldCacheServer = new LinkedHashSet<Field>();

            for (Field field : this.getClass().getFields())
            {
                if (field.isAnnotationPresent(NetworkedField.class))
                {
                    NetworkedField f = field.getAnnotation(NetworkedField.class);

                    if (f.targetSide() == Side.CLIENT)
                    {
                        this.fieldCacheClient.add(field);
                    }
                    else
                    {
                        this.fieldCacheServer.add(field);
                    }
                }
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public abstract double getPacketRange();

    public abstract int getPacketCooldown();

    public abstract boolean isNetworkedTile();

    public void addExtraNetworkedData(List<Object> networkedList)
    {

    }

    public void readExtraNetworkedData(ByteBuf dataStream)
    {

    }

    public void initiate()
    {
    }

    @Override
    public void getNetworkedData(ArrayList<Object> sendData)
    {
        Set<Field> fieldList = null;
        boolean changed = false;

        if (this.fieldCacheClient == null || this.fieldCacheServer == null)
        {
            this.initFieldCache();
        }

        if (this.worldObj.isRemote)
        {
            fieldList = this.fieldCacheServer;
        }
        else
        {
            fieldList = this.fieldCacheClient;
        }

        for (Field f : fieldList)
        {
            boolean fieldChanged = false;
            try
            {
                Object data = f.get(this);
                Object lastData = lastSentData.get(f);

                if (!NetworkUtil.fuzzyEquals(lastData, data))
                {
                    fieldChanged = true;
                }

                sendData.add(data);

                if (fieldChanged)
                {
                    lastSentData.put(f, NetworkUtil.cloneNetworkedObject(data));
                }
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }

            changed |= fieldChanged;
        }

        if (changed)
        {
            this.addExtraNetworkedData(sendData);
        }
        else
        {
            ArrayList<Object> prevSendData = new ArrayList<Object>(sendData);

            this.addExtraNetworkedData(sendData);

            if (!prevSendData.equals(sendData))
            {
                changed = true;
            }
        }

        networkDataChanged = changed;
    }

    @Override
    public void decodePacketdata(ByteBuf buffer)
    {
        if (this.fieldCacheClient == null || this.fieldCacheServer == null)
        {
            this.initFieldCache();
        }

        if (this.worldObj.isRemote && this.fieldCacheClient.size() == 0)
        {
            return;
        }
        else if (!this.worldObj.isRemote && this.fieldCacheServer.size() == 0)
        {
            return;
        }

        Set<Field> fieldSet = null;

        if (this.worldObj.isRemote)
        {
            fieldSet = this.fieldCacheClient;
        }
        else
        {
            fieldSet = this.fieldCacheServer;
        }

        for (Field field : fieldSet)
        {
            try
            {
                Object obj = NetworkUtil.getFieldValueFromStream(field, buffer, this.worldObj);
                field.set(this, obj);
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }

        this.readExtraNetworkedData(buffer);
    }

    @Override
    public void handlePacketData(Side side, EntityPlayer player)
    {

    }
}