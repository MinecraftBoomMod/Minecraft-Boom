package soupbubbles.minecraftboom.handler;

import java.util.ArrayList;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.IFuelHandler;
import soupbubbles.minecraftboom.init.ModBlocks;
import soupbubbles.minecraftboom.init.ModItems;

public class FuelHandler implements IFuelHandler
{
    private static final ArrayList<FuelStack> fuelBurnTime = new ArrayList<>();

    @Override
    public int getBurnTime(ItemStack stack)
    {
        for (int i = 0; i < fuelBurnTime.size(); i++)
        {
            if (stack.getItem() == fuelBurnTime.get(i).getStack().getItem())
            {
                return fuelBurnTime.get(i).getBurnTime();
            }
        }

        return 0;
    }

    static
    {
        addFuel(new ItemStack(Items.BLAZE_POWDER), ConfigurationHandler.blazeBurnTime, ConfigurationHandler.blazeFuel);
        addFuel(new ItemStack(ModBlocks.BLOCK_CHARCOAL), ConfigurationHandler.charcoalBlockBurnTime, ConfigurationHandler.charcoalBlockFuel);
        addFuel(new ItemStack(ModItems.ITEM_PINECONE), ConfigurationHandler.pineconeBurnTime, ConfigurationHandler.pineconeFuel);
        addFuel(new ItemStack(ModItems.ITEM_WITHER_BONE), ConfigurationHandler.witherBoneBurnTime, ConfigurationHandler.witherBoneFuel);
        addFuel(new ItemStack(ModBlocks.BLOCK_BLAZE_POWDER), ConfigurationHandler.blazeBlockBurnTime, ConfigurationHandler.blazeBlockFuel);
        addFuel(new ItemStack(ModBlocks.BLOCK_CHARRED_BONE), ConfigurationHandler.witherBoneBlockBurnTime, ConfigurationHandler.witherBoneBlockFuel);
    }

    private static void addFuel(ItemStack stack, int burnTime, boolean enabled)
    {
        if (enabled)
        {
            fuelBurnTime.add(new FuelStack(stack, burnTime));
        }
    }

    private static class FuelStack
    {
        private ItemStack stack;
        private int burnTime;

        public FuelStack(ItemStack itemStack, int burnAmount)
        {
            stack = itemStack;
            burnTime = burnAmount;
        }

        public ItemStack getStack()
        {
            return stack;
        }

        public int getBurnTime()
        {
            return burnTime;
        }
    }
}