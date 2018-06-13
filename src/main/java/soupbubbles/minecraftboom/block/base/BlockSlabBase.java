package soupbubbles.minecraftboom.block.base;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeModContainer;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import soupbubbles.minecraftboom.creativetab.CreativeTab;
import soupbubbles.minecraftboom.reference.Assets;

public class BlockSlabBase extends Block
{
    public static final PropertyEnum<BlockSlabBase.EnumBlockSlab> TYPE = PropertyEnum.<BlockSlabBase.EnumBlockSlab>create("type", BlockSlabBase.EnumBlockSlab.class);
    protected static final AxisAlignedBB AABB_BOTTOM_HALF = new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.5D, 1.0D);
    protected static final AxisAlignedBB AABB_TOP_HALF = new AxisAlignedBB(0.0D, 0.5D, 0.0D, 1.0D, 1.0D, 1.0D);

    private final IBlockState STATE;
    protected final String BASE_NAME;
    private boolean isVanilla;

    public BlockSlabBase(IBlockState state, String name, boolean vanilla)
    {
        super(state.getMaterial());
        name = "slab_" + name;
        STATE = state;
        setRegistryName(name);
        setUnlocalizedName(name);
        setCreativeTab(CreativeTab.MINECRAFTBOOM_STAIRS_AND_SLABS_TAB);
        setHardness(STATE.getBlockHardness(null, null));
        setResistance(STATE.getBlock().getExplosionResistance(null) * 5.0F);
        setSoundType(STATE.getBlock().getSoundType());
        setLightOpacity(255);

        useNeighborBrightness = true;
        BASE_NAME = name;
        isVanilla = vanilla;
    }

    @Override
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess iBlockAccess, BlockPos pos)
    {
        return isDouble(state) ? FULL_BLOCK_AABB : state.getValue(TYPE) == BlockSlabBase.EnumBlockSlab.TOP ? AABB_TOP_HALF : AABB_BOTTOM_HALF;
    }

    @Override
    public boolean isTopSolid(IBlockState state)
    {
        return ((BlockSlabBase) state.getBlock()).isDouble(state) || state.getValue(TYPE) == BlockSlabBase.EnumBlockSlab.TOP;
    }

    @Override
    public BlockFaceShape getBlockFaceShape(IBlockAccess worldIn, IBlockState state, BlockPos pos, EnumFacing face)
    {
        if (((BlockSlabBase) state.getBlock()).isDouble(state))
        {
            return BlockFaceShape.SOLID;
        }
        else if (face == EnumFacing.UP && state.getValue(TYPE) == BlockSlabBase.EnumBlockSlab.TOP)
        {
            return BlockFaceShape.SOLID;
        }
        else
        {
            return face == EnumFacing.DOWN && state.getValue(TYPE) == BlockSlabBase.EnumBlockSlab.BOTTOM ? BlockFaceShape.SOLID : BlockFaceShape.UNDEFINED;
        }
    }

    @Override
    public boolean doesSideBlockRendering(IBlockState state, IBlockAccess world, BlockPos pos, EnumFacing face)
    {
        if (ForgeModContainer.disableStairSlabCulling)
        {
            return super.doesSideBlockRendering(state, world, pos, face);
        }

        if (state.isOpaqueCube())
        {
            return true;

        }

        EnumBlockSlab side = state.getValue(TYPE);
        return (side == EnumBlockSlab.TOP && face == EnumFacing.UP) || (side == EnumBlockSlab.BOTTOM && face == EnumFacing.DOWN);
    }

    @Override
    public boolean isOpaqueCube(IBlockState state)
    {
        return isDouble(state);
    }

    @Override
    public IBlockState getStateForPlacement(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer)
    {
        IBlockState state = super.getStateFromMeta(meta);

        if (isDouble(state))
        {
            return state.withProperty(TYPE, BlockSlabBase.EnumBlockSlab.DOUBLE);
        }
        else
        {
            return facing != EnumFacing.DOWN && (facing == EnumFacing.UP || hitY <= 0.5D) ? state.withProperty(TYPE, BlockSlabBase.EnumBlockSlab.BOTTOM) : state.withProperty(TYPE, BlockSlabBase.EnumBlockSlab.TOP);
        }
    }

    @SideOnly(Side.CLIENT)
    @Override
    public boolean shouldSideBeRendered(IBlockState state, IBlockAccess iBlockAccess, BlockPos pos, EnumFacing side)
    {
        if (isDouble(state))
        {
            return super.shouldSideBeRendered(state, iBlockAccess, pos, side);
        }
        else if (side != EnumFacing.UP && side != EnumFacing.DOWN && !super.shouldSideBeRendered(state, iBlockAccess, pos, side))
        {
            return false;
        }

        return super.shouldSideBeRendered(state, iBlockAccess, pos, side);
    }

    @Override
    public IBlockState getStateFromMeta(int meta)
    {
        return getDefaultState().withProperty(TYPE, BlockSlabBase.EnumBlockSlab.getStateFromMeta(meta));
    }

    @Override
    public int getMetaFromState(IBlockState state)
    {
        return state.getValue(TYPE).getMeta();
    }

    @Override
    protected BlockStateContainer createBlockState()
    {
        return new BlockStateContainer(this, new IProperty[] {TYPE});
    }

    @Override
    public String getUnlocalizedName()
    {
        return String.format(Assets.BLOCK_PREFIX, Assets.ASSET_PREFIX, BASE_NAME);
    }

    @Override
    protected boolean canSilkHarvest()
    {
        return false;
    }

    @Override
    public int quantityDropped(IBlockState state, int fortune, Random random)
    {
        return isDouble(state) ? 2 : 1;
    }
    
    @Override
    public boolean isFullCube(IBlockState state)
    {
        return isDouble(state);
    }

    public boolean isDouble(IBlockState state)
    {
        return state.getValue(TYPE) == BlockSlabBase.EnumBlockSlab.DOUBLE;
    }

    public IBlockState getSlabBlockState()
    {
        return STATE;
    }

    public boolean isVanilla()
    {
        return isVanilla;
    }

    public static enum EnumBlockSlab implements IStringSerializable
    {
        BOTTOM(0, "bottom"), TOP(1, "top"), DOUBLE(2, "double");

        private final String name;
        private final int meta;

        private EnumBlockSlab(int meta, String name)
        {
            this.name = name;
            this.meta = meta;
        }

        @Override
        public String toString()
        {
            return name;
        }

        @Override
        public String getName()
        {
            return name;
        }

        public int getMeta()
        {
            return meta;
        }

        public static EnumBlockSlab getStateFromMeta(int meta)
        {
            return meta == 0 ? BOTTOM : meta == 1 ? TOP : DOUBLE;
        }
    }
}
