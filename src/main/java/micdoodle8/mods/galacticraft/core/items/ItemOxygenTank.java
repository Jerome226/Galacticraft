package micdoodle8.mods.galacticraft.core.items;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import micdoodle8.mods.galacticraft.core.GalacticraftCore;
import micdoodle8.mods.galacticraft.core.proxy.ClientProxyCore;
import micdoodle8.mods.galacticraft.core.util.GCCoreUtil;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ItemOxygenTank extends Item {

	public ItemOxygenTank(int tier, String assetName) {
		super();
		this.setMaxStackSize(1);
		this.setMaxDamage(tier * 1000);
		this.setUnlocalizedName(assetName);
		this.setTextureName(GalacticraftCore.TEXTURE_PREFIX + assetName);
		this.setNoRepair();
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	@SideOnly(Side.CLIENT)
	public void getSubItems(Item item, CreativeTabs tab, List list) {
		list.add(new ItemStack(item, 1, 0));
		list.add(new ItemStack(item, 1, this.getMaxDamage()));
	}

	@Override
	public CreativeTabs getCreativeTab() {
		return GalacticraftCore.galacticraftItemsTab;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public EnumRarity getRarity(ItemStack stack) {
		return ClientProxyCore.galacticraftItem;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public void addInformation(ItemStack stack, EntityPlayer player, List tooltip, boolean advancedTooltips) {
		tooltip.add(GCCoreUtil.translate("gui.tank.oxygenRemaining") + ": " + (stack.getMaxDamage() - stack.getItemDamage()));
	}
}
