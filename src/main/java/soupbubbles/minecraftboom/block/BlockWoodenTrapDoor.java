package soupbubbles.minecraftboom.block;

import net.minecraft.block.BlockTrapDoor;
import net.minecraft.block.material.Material;
import net.minecraft.util.EnumFacing;
import soupbubbles.minecraftboom.creativetab.CreativeTab;
import soupbubbles.minecraftboom.reference.Assets;

public class BlockWoodenTrapDoor extends BlockTrapDoor
{
    protected final String BASE_NAME;

    public BlockWoodenTrapDoor(String name)
    {
        super(Material.WOOD);
        setRegistryName(name);
        setUnlocalizedName(name);
        setCreativeTab(CreativeTab.MINECRAFTBOOM_DECORATION_ITEM_TAB);
        
        BASE_NAME = name;
    }

    @Override
    public String getUnlocalizedName()
    {
        return String.format(Assets.BLOCK_PREFIX, Assets.ASSET_PREFIX, BASE_NAME);
    }
}
