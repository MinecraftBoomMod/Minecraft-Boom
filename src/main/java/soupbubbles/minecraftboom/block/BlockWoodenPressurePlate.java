package soupbubbles.minecraftboom.block;

import net.minecraft.block.BlockButtonWood;
import net.minecraft.block.BlockPressurePlate;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import soupbubbles.minecraftboom.creativetab.CreativeTab;
import soupbubbles.minecraftboom.reference.Assets;

public class BlockWoodenPressurePlate extends BlockPressurePlate
{
    protected final String BASE_NAME;

    public BlockWoodenPressurePlate(String name)
    {
        super(Material.WOOD, BlockPressurePlate.Sensitivity.EVERYTHING);
        setRegistryName(name);
        setUnlocalizedName(name);
        setHardness(0.5F);
        setSoundType(SoundType.WOOD);
        setCreativeTab(CreativeTab.MINECRAFTBOOM_DECORATION_ITEM_TAB);
        
        BASE_NAME = name;
    }
    
    @Override
    public String getUnlocalizedName()
    {
        return String.format(Assets.BLOCK_PREFIX, Assets.ASSET_PREFIX, BASE_NAME);
    }
}
