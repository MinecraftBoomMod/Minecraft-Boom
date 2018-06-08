package soupbubbles.minecraftboom.block;

import net.minecraft.block.BlockFenceGate;
import net.minecraft.block.BlockPlanks;
import net.minecraft.block.SoundType;
import soupbubbles.minecraftboom.creativetab.CreativeTab;
import soupbubbles.minecraftboom.reference.Assets;

public class BlockNetherBrickFenceGate extends BlockFenceGate
{
    protected final String BASE_NAME;
    
    public BlockNetherBrickFenceGate(String name)
    {
        super(BlockPlanks.EnumType.DARK_OAK);
        BASE_NAME = name;
        setRegistryName(BASE_NAME);
        setUnlocalizedName(BASE_NAME);
        setCreativeTab(CreativeTab.MINECRAFTBOOM_TAB);
        setSoundType(SoundType.STONE);
    }

    @Override
    public String getUnlocalizedName()
    {
        return String.format(Assets.BLOCK_PREFIX, Assets.ASSET_PREFIX, BASE_NAME);
    }
}
