package soupbubbles.minecraftboom.handler;

import net.minecraft.block.BlockLeaves;
import net.minecraft.block.BlockOldLeaf;
import net.minecraft.block.BlockPlanks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import soupbubbles.minecraftboom.init.ModItems;

@Mod.EventBusSubscriber
public class BlockEventHandler
{
    @SubscribeEvent
    public void onBlockDropItems(BlockEvent.HarvestDropsEvent event)
    {
        if (event.getState().getBlock() instanceof BlockOldLeaf)
        {
            event.setDropChance(1.0F);

            if (event.getState().getValue(BlockOldLeaf.VARIANT).getMetadata() == BlockPlanks.EnumType.SPRUCE.getMetadata() && event.getWorld().rand.nextFloat() < ConfigurationHandler.pineconeDropRate && ConfigurationHandler.spruceDropsPinecones)
            {
                event.getDrops().add(new ItemStack(ModItems.ITEM_PINECONE));
            }
            
            if (event.getWorld().rand.nextFloat() < ConfigurationHandler.stickDropRate && ConfigurationHandler.leavesDropSticks)
            {
                event.getDrops().add(new ItemStack(Items.STICK));
            }
        }
    }
}
