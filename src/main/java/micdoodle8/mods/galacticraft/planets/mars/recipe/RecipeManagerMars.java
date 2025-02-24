package micdoodle8.mods.galacticraft.planets.mars.recipe;

import java.util.HashMap;

import galaxyspace.core.register.GSItems;
import micdoodle8.mods.galacticraft.core.blocks.GCBlocks;
import micdoodle8.mods.galacticraft.core.items.GCItems;
import micdoodle8.mods.galacticraft.core.util.ConfigManagerCore;
import micdoodle8.mods.galacticraft.core.util.RecipeUtil;
import micdoodle8.mods.galacticraft.planets.mars.blocks.BlockMachineMars;
import micdoodle8.mods.galacticraft.planets.mars.blocks.MarsBlocks;
import micdoodle8.mods.galacticraft.planets.mars.items.MarsItems;
import micdoodle8.mods.galacticraft.planets.mars.util.MarsUtil;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraftforge.oredict.OreDictionary;

public class RecipeManagerMars
{
    public static void loadRecipes()
    {
        RecipeManagerMars.addUniversalRecipes();
    }

    private static void addUniversalRecipes()
    {
        OreDictionary.registerOre("ingotDesh", new ItemStack(MarsItems.marsItemBasic, 1, 2));
        OreDictionary.registerOre("compressedDesh", new ItemStack(MarsItems.marsItemBasic, 1, 5));
    	Object meteoricIronIngot = ConfigManagerCore.recipesRequireGCAdvancedMetals ? GCItems.meteoricIronIngot : "ingotMeteoricIron";
    	Object deshIngot = ConfigManagerCore.recipesRequireGCAdvancedMetals ? new ItemStack(MarsItems.marsItemBasic, 1, 2) : "ingotDesh";
    	Object deshPlate = ConfigManagerCore.recipesRequireGCAdvancedMetals ? new ItemStack(MarsItems.marsItemBasic, 1, 5) : "compressedDesh";

        RecipeUtil.addRecipe(new ItemStack(MarsItems.deshBoots), new Object[] { "X X", "X X", 'X', new ItemStack(MarsItems.marsItemBasic, 1, 2) });

        RecipeUtil.addRecipe(new ItemStack(MarsBlocks.marsBlock, 1, 8), new Object[] { "XXX", "XXX", "XXX", 'X', deshIngot });

        RecipeUtil.addRecipe(new ItemStack(MarsBlocks.machine, 1, 0), new Object[] { "XWX", "XZX", "WVW", 'V', GCItems.oxygenConcentrator, 'W', deshPlate, 'X', deshIngot, 'Z', new ItemStack(GCItems.canister) });

        RecipeUtil.addRecipe(new ItemStack(MarsBlocks.machine, 1, 4), new Object[] { "XYX", "XZX", "XYX", 'X', deshPlate, 'Y', new ItemStack(MarsItems.marsItemBasic, 1, 3), 'Z', Items.bed });
        //Gas liquefier
        RecipeUtil.addRecipe(new ItemStack(MarsBlocks.machineT2, 1, 0), new Object[] { "TVS", "FWS", "PXO", 'T', new ItemStack(GCItems.oxTankHeavy, 1, GCItems.oxTankHeavy.getMaxDamage()), 'V', GCItems.oxygenVent, 'F', new ItemStack(GCBlocks.oxygenPipe, 1, 0), 'X', new ItemStack(GCItems.basicItem, 1, 10), 'W', new ItemStack(MarsItems.marsItemBasic, 1, 6), 'O', new ItemStack(GCBlocks.oxygenCompressor, 1, 0), 'P', new ItemStack(GCBlocks.oxygenCompressor, 1, 4), 'S', new ItemStack(GCItems.oxTankMedium, 1, GCItems.oxTankMedium.getMaxDamage()) });
        //Methane Synthesizer
        RecipeUtil.addRecipe(new ItemStack(MarsBlocks.machineT2, 1, 4), new Object[] { "TVT", "FWF", "CXO", 'T', new ItemStack(GCItems.oxTankHeavy, 1, GCItems.oxTankHeavy.getMaxDamage()), 'V', GCItems.oxygenVent, 'F', new ItemStack(GCBlocks.oxygenPipe, 1, 0), 'X', new ItemStack(GCItems.basicItem, 1, 10), 'W', new ItemStack(MarsItems.marsItemBasic, 1, 6), 'O', new ItemStack(GCBlocks.oxygenCompressor, 1, 0), 'C', new ItemStack(GCBlocks.machineTiered, 1, 4) });
        //Water Electrolyzer
        RecipeUtil.addRecipe(new ItemStack(MarsBlocks.machineT2, 1, 8), new Object[] { "TVT", "FWF", "BXB", 'T', new ItemStack(GCItems.oxTankHeavy, 1, GCItems.oxTankHeavy.getMaxDamage()), 'V', GCItems.oxygenVent, 'F', new ItemStack(GCBlocks.oxygenPipe, 1, 0), 'X', new ItemStack(GCItems.basicItem, 1, 10), 'W', new ItemStack(MarsItems.marsItemBasic, 1, 6), 'B', new ItemStack(GCItems.basicItem, 1, 6) });
        //Fluid Manipulator - crafting item
        RecipeUtil.addRecipe(new ItemStack(MarsItems.marsItemBasic, 1, 6), new Object[] { "MXM", "SWS", "MXM", 'S', "slimeball", 'X', GCItems.oxygenFan, 'M', meteoricIronIngot, 'W', new ItemStack(GCItems.basicItem, 1, 14) });

        RecipeUtil.addRecipe(new ItemStack(MarsBlocks.hydrogenPipe, 6, 0), new Object[] { "CCC", "   ", "CCC", 'C', "ingotCopper" });

        RecipeUtil.addRecipe(new ItemStack(MarsItems.marsItemBasic, 1, 1), new Object[] { "X", "X", 'X', deshIngot });

        RecipeUtil.addRecipe(new ItemStack(MarsItems.marsItemBasic, 1, 4), new Object[] { "XWX", "XYX", " Z ", 'W', "gemDiamond", 'X', "itemLeather", 'Y', "slimeball", 'Z', "chest" });

        RecipeUtil.addRecipe(new ItemStack(MarsItems.deshSword), new Object[] { "X", "X", "Y", 'X', "compressedDesh", 'Y', new ItemStack(MarsItems.marsItemBasic, 1, 1) });

        RecipeUtil.addRecipe(new ItemStack(MarsItems.deshPickaxe), new Object[] { "XXX", " Y ", " Y ", 'X', "compressedDesh", 'Y', new ItemStack(MarsItems.marsItemBasic, 1, 1) });

        RecipeUtil.addRecipe(new ItemStack(MarsItems.deshSpade), new Object[] { "X", "Y", "Y", 'X', "compressedDesh", 'Y', new ItemStack(MarsItems.marsItemBasic, 1, 1) });

        RecipeUtil.addRecipe(new ItemStack(MarsItems.deshHoe), new Object[] { "XX", "Y ", "Y ", 'X', "compressedDesh", 'Y', new ItemStack(MarsItems.marsItemBasic, 1, 1) });

        RecipeUtil.addRecipe(new ItemStack(MarsItems.deshHoe), new Object[] { "XX", " Y", " Y", 'X', "compressedDesh", 'Y', new ItemStack(MarsItems.marsItemBasic, 1, 1) });

        RecipeUtil.addRecipe(new ItemStack(MarsItems.deshAxe), new Object[] { "XX", "XY", " Y", 'X', "compressedDesh", 'Y', new ItemStack(MarsItems.marsItemBasic, 1, 1) });

        RecipeUtil.addRecipe(new ItemStack(MarsItems.deshAxe), new Object[] { "XX", "YX", "Y ", 'X', "compressedDesh", 'Y', new ItemStack(MarsItems.marsItemBasic, 1, 1) });

        RecipeUtil.addRecipe(new ItemStack(MarsItems.deshHelmet), new Object[] { "XXX", "X X", 'X', "compressedDesh" });

        RecipeUtil.addRecipe(new ItemStack(MarsItems.deshChestplate), new Object[] { "X X", "XXX", "XXX", 'X', "compressedDesh" });

        RecipeUtil.addRecipe(new ItemStack(MarsItems.deshLeggings), new Object[] { "XXX", "X X", "X X", 'X', "compressedDesh" });

        RecipeUtil.addRecipe(new ItemStack(MarsItems.marsItemBasic, 9, 2), new Object[] { "X", 'X', new ItemStack(MarsBlocks.marsBlock, 1, 8) });

		// Mars Cobblestone Stairs
		RecipeUtil.addRecipe(new ItemStack(MarsBlocks.marsCobblestoneStairs, 4), new Object[] { "  X", " XX", "XXX", 'X', new ItemStack(MarsBlocks.marsBlock, 1, 4) });
		RecipeUtil.addRecipe(new ItemStack(MarsBlocks.marsCobblestoneStairs, 4), new Object[] { "X  ", "XX ", "XXX", 'X', new ItemStack(MarsBlocks.marsBlock, 1, 4) });

		// Mars Dungeon Brick Stairs
		RecipeUtil.addRecipe(new ItemStack(MarsBlocks.marsBricksStairs, 4), new Object[] { "  X", " XX", "XXX", 'X', new ItemStack(MarsBlocks.marsBlock, 1, 7) });
		RecipeUtil.addRecipe(new ItemStack(MarsBlocks.marsBricksStairs, 4), new Object[] { "X  ", "XX ", "XXX", 'X', new ItemStack(MarsBlocks.marsBlock, 1, 7) });

		// Slab Block
		RecipeUtil.addRecipe(new ItemStack(GCBlocks.slabGCHalf, 6, 4), new Object[] { "XXX", 'X', new ItemStack(MarsBlocks.marsBlock, 1, 4) });
		RecipeUtil.addRecipe(new ItemStack(GCBlocks.slabGCHalf, 6, 5), new Object[] { "XXX", 'X', new ItemStack(MarsBlocks.marsBlock, 1, 7) });

		// Wall Block
		RecipeUtil.addRecipe(new ItemStack(GCBlocks.wallGC, 6, 4), new Object[] { "XXX", "XXX", 'X', new ItemStack(MarsBlocks.marsBlock, 1, 4) });
		RecipeUtil.addRecipe(new ItemStack(GCBlocks.wallGC, 6, 5), new Object[] { "XXX", "XXX", 'X', new ItemStack(MarsBlocks.marsBlock, 1, 7) });

        CraftingManager.getInstance().addShapelessRecipe(new ItemStack(MarsItems.carbonFragments, 8, 0), new ItemStack(Items.coal, 1, 0));

        CraftingManager.getInstance().addShapelessRecipe(new ItemStack(MarsItems.carbonFragments, 4, 0), new ItemStack(Items.coal, 1, 1));

        // Smelting
        FurnaceRecipes.smelting().func_151394_a(new ItemStack(MarsItems.marsItemBasic, 1, 0), new ItemStack(MarsItems.marsItemBasic, 1, 2), 0.2F);
        FurnaceRecipes.smelting().func_151394_a(new ItemStack(MarsBlocks.marsBlock, 1, 4), new ItemStack(MarsBlocks.marsBlock, 1, 9), 0.0F);
        FurnaceRecipes.smelting().func_151394_a(new ItemStack(MarsBlocks.marsBlock, 1, 0), new ItemStack(GCItems.basicItem, 1, 3), 1.0F);
        FurnaceRecipes.smelting().func_151394_a(new ItemStack(MarsBlocks.marsBlock, 1, 1), new ItemStack(GCItems.basicItem, 1, 4), 1.0F);
        FurnaceRecipes.smelting().func_151394_a(new ItemStack(MarsBlocks.marsBlock, 1, 2), new ItemStack(MarsItems.marsItemBasic, 1, 2), 0.2F);
        FurnaceRecipes.smelting().func_151394_a(new ItemStack(MarsBlocks.marsBlock, 1, 3), new ItemStack(Items.iron_ingot), 0.2F);

        //Handled by Galaxy Space
        // Schematic
        HashMap<Integer, ItemStack> input = new HashMap<Integer, ItemStack>();
        /*input.put(1, new ItemStack(GCItems.partNoseCone));
        input.put(2, new ItemStack(MarsItems.marsItemBasic, 1, 3));
        input.put(3, new ItemStack(MarsItems.marsItemBasic, 1, 3));
        input.put(4, new ItemStack(MarsItems.marsItemBasic, 1, 3));
        input.put(5, new ItemStack(MarsItems.marsItemBasic, 1, 3));
        input.put(6, new ItemStack(MarsItems.marsItemBasic, 1, 3));
        input.put(7, new ItemStack(MarsItems.marsItemBasic, 1, 3));
        input.put(8, new ItemStack(MarsItems.marsItemBasic, 1, 3));
        input.put(9, new ItemStack(MarsItems.marsItemBasic, 1, 3));
        input.put(10, new ItemStack(MarsItems.marsItemBasic, 1, 3));
        input.put(11, new ItemStack(MarsItems.marsItemBasic, 1, 3));
        input.put(12, new ItemStack(GCItems.rocketEngine, 1, 1));
        input.put(13, new ItemStack(GCItems.partFins));
        input.put(14, new ItemStack(GCItems.partFins));
        input.put(15, new ItemStack(GCItems.rocketEngine));
        input.put(16, new ItemStack(GCItems.rocketEngine, 1, 1));
        input.put(17, new ItemStack(GCItems.partFins));
        input.put(18, new ItemStack(GCItems.partFins));
        input.put(19, null);
        input.put(20, null);
        input.put(21, null);
        MarsUtil.addRocketBenchT2Recipe(new ItemStack(MarsItems.spaceship, 1, 0), input);*/

        HashMap<Integer, ItemStack> input2 = new HashMap<Integer, ItemStack>(input);/*
        input2.put(19, new ItemStack("chest"));
        input2.put(20, null);
        input2.put(21, null);
        MarsUtil.addRocketBenchT2Recipe(new ItemStack(MarsItems.spaceship, 1, 1), input2);

        input2 = new HashMap<Integer, ItemStack>(input);
        input2.put(19, null);
        input2.put(20, new ItemStack("chest"));
        input2.put(21, null);
        MarsUtil.addRocketBenchT2Recipe(new ItemStack(MarsItems.spaceship, 1, 1), input2);

        input2 = new HashMap<Integer, ItemStack>(input);
        input2.put(19, null);
        input2.put(20, null);
        input2.put(21, new ItemStack("chest"));
        MarsUtil.addRocketBenchT2Recipe(new ItemStack(MarsItems.spaceship, 1, 1), input2);

        input2 = new HashMap<Integer, ItemStack>(input);
        input2.put(19, new ItemStack("chest"));
        input2.put(20, new ItemStack("chest"));
        input2.put(21, null);
        MarsUtil.addRocketBenchT2Recipe(new ItemStack(MarsItems.spaceship, 1, 2), input2);

        input2 = new HashMap<Integer, ItemStack>(input);
        input2.put(19, new ItemStack("chest"));
        input2.put(20, null);
        input2.put(21, new ItemStack("chest"));
        MarsUtil.addRocketBenchT2Recipe(new ItemStack(MarsItems.spaceship, 1, 2), input2);

        input2 = new HashMap<Integer, ItemStack>(input);
        input2.put(19, null);
        input2.put(20, new ItemStack("chest"));
        input2.put(21, new ItemStack("chest"));
        MarsUtil.addRocketBenchT2Recipe(new ItemStack(MarsItems.spaceship, 1, 2), input2);

        input2 = new HashMap<Integer, ItemStack>(input);
        input2.put(19, new ItemStack("chest"));
        input2.put(20, new ItemStack("chest"));
        input2.put(21, new ItemStack("chest"));
        MarsUtil.addRocketBenchT2Recipe(new ItemStack(MarsItems.spaceship, 1, 3), input2);*/

        //

        input.put(1, new ItemStack(GCItems.basicItem, 1, 14));
		input.put(2, new ItemStack(GSItems.ControlComputer, 1, 101));
		for(int i = 3; i <= 6; i++) {
			input.put(i, new ItemStack(GSItems.RocketParts, 1, 40));
		}
		input.put(7, new ItemStack(GCItems.partNoseCone));
		for(int i = 8; i <= 15; i++) {
			input.put(i, new ItemStack(MarsItems.marsItemBasic, 1, 3));
		}
        input.put(16, new ItemStack(GCItems.rocketEngine));
        for(int i = 17; i <= 20; i++) {
        	input.put(i, new ItemStack(GCItems.partFins));
        }

        input2 = new HashMap<Integer, ItemStack>(input);
        input2.put(21, RecipeUtil.getChestItemStack(1, 3));
        MarsUtil.adCargoRocketRecipe(new ItemStack(MarsItems.spaceship, 1, 11), input2);
        input2 = new HashMap<Integer, ItemStack>(input);
        input2.put(21, RecipeUtil.getChestItemStack(1, 0));
        MarsUtil.adCargoRocketRecipe(new ItemStack(MarsItems.spaceship, 1, 12), input2);
        input2 = new HashMap<Integer, ItemStack>(input);
        input2.put(21, RecipeUtil.getChestItemStack(1, 1));
        MarsUtil.adCargoRocketRecipe(new ItemStack(MarsItems.spaceship, 1, 13), input2);

        RecipeUtil.addRecipe(new ItemStack(MarsBlocks.machine, 1, BlockMachineMars.LAUNCH_CONTROLLER_METADATA), new Object[] { "ZVZ", "YXY", "ZWZ", 'V', new ItemStack(GCItems.basicItem, 1, 19), 'W', new ItemStack(GCBlocks.aluminumWire, 1, 0), 'X', new ItemStack(GCItems.basicItem, 1, 14), 'Y', deshPlate, 'Z', deshIngot });
    }
}
