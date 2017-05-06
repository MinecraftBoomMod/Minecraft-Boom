package soupbubbles.minecraftboom.handler;

import java.util.ArrayList;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntityFurnace;
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
        fuelBurnTime.add(new FuelStack(new ItemStack(Items.BLAZE_POWDER), 1200));
        fuelBurnTime.add(new FuelStack(new ItemStack(ModItems.ITEM_PINECONE), 300));
        fuelBurnTime.add(new FuelStack(new ItemStack(ModBlocks.BLOCK_CHARCOAL), TileEntityFurnace.getItemBurnTime(new ItemStack(Blocks.COAL_BLOCK))));
        fuelBurnTime.add(new FuelStack(new ItemStack(ModBlocks.BLOCK_BLAZE_POWDER), 12000));
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