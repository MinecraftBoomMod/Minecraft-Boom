package soupbubbles.minecraftboom.client.renderer.tileentity;

import net.minecraft.client.renderer.tileentity.TileEntityChestRenderer;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.util.ResourceLocation;
import soupbubbles.minecraftboom.block.base.BlockChestBase;
import soupbubbles.minecraftboom.tileentity.TileEntityChestBase;

public class RenderChest extends TileEntityChestRenderer
{
    private TileEntityChestBase tileEntity;
    
    public void renderTileEntityAt(TileEntityChest te, double x, double y, double z, float partialTicks, int destroyStage)
    {
        tileEntity = (TileEntityChestBase) te;
        BlockChestBase block = (BlockChestBase) te.getBlockType();
        
        super.renderTileEntityAt(te, x, y, z, partialTicks, destroyStage);
    }
    
    @Override
    protected void bindTexture(ResourceLocation location)
    {
        //location = ((BlockChestBase)tileEntity.getBlockType()).getType().getResourceLocation();
        
        super.bindTexture(location);
    }
}
