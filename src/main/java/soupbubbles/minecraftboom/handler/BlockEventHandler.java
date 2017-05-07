package soupbubbles.minecraftboom.handler;

import net.minecraft.block.BlockLeaves;
import net.minecraft.block.BlockOldLeaf;
import net.minecraft.block.BlockPlanks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import soupbubbles.minecraftboom.init.ModItems;

public class BlockEventHandler
{
    @SubscribeEvent
    public void onBlockDropItems(BlockEvent.HarvestDropsEvent event)
    {
        if (event.getState().getBlock() instanceof BlockLeaves)
        {
            event.setDropChance(1.0F);

            if (event.getState().getValue(BlockOldLeaf.VARIANT) == BlockPlanks.EnumType.SPRUCE && event.getWorld().rand.nextFloat() < 0.02F)
            {
                event.getDrops().add(new ItemStack(ModItems.ITEM_PINECONE));
            }
            
            if (event.getWorld().rand.nextFloat() < 0.2F)
            {
                event.getDrops().add(new ItemStack(Items.STICK));
            }
        }
    }
}
