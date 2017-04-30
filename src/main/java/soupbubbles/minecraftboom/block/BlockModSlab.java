package soupbubbles.minecraftboom.block;

import java.util.Random;

import net.minecraft.block.BlockSlab;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import soupbubbles.minecraftboom.block.base.BlockSlabBase;
import soupbubbles.minecraftboom.init.ModBlocks;
import soupbubbles.minecraftboom.reference.Assets;
import soupbubbles.minecraftboom.reference.Names;

public abstract class BlockModSlab extends BlockSlabBase
{
    public static final PropertyEnum<BlockModSlab.EnumType> VARIANT = PropertyEnum.<BlockModSlab.EnumType>create("variant", BlockModSlab.EnumType.class);

    public BlockModSlab(String name)
    {
        super(Material.ROCK, name);
        IBlockState iblockstate = blockState.getBaseState();

        if (!isDouble())
        {
            iblockstate = iblockstate.withProperty(HALF, BlockSlab.EnumBlockHalf.BOTTOM);
        }

        setDefaultState(iblockstate.withProperty(VARIANT, BlockModSlab.EnumType.SMOOTH_PRISMARINE));
        setHardness(2.0F);
        setResistance(10.0F);
        setSoundType(SoundType.STONE);
    }

    @Override
    public Item getItemDropped(IBlockState state, Random rand, int fortune)
    {
        return Item.getItemFromBlock(ModBlocks.BLOCK_HALF_SLAB_MOD);
    }

    @Override
    public ItemStack getItem(World worldIn, BlockPos pos, IBlockState state)
    {
        return new ItemStack(ModBlocks.BLOCK_HALF_SLAB_MOD, 1, state.getValue(VARIANT).getMetadata());
    }

    @Override
    public String getUnlocalizedName(int meta)
    {
        return String.format(Assets.BLOCK_PREFIX, Assets.ASSET_PREFIX, BASE_NAME + "_" + BlockModSlab.EnumType.byMetadata(meta).getUnlocalizedName());
    }

    @Override
    public String getSpecialName(int meta)
    {
        return getUnlocalizedName(meta);
    }

    @Override
    public IProperty<?> getVariantProperty()
    {
        return VARIANT;
    }

    @Override
    public Comparable<?> getTypeForItem(ItemStack stack)
    {
        return BlockModSlab.EnumType.byMetadata(stack.getMetadata() & 3);
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void getSubBlocks(Item item, CreativeTabs tab, NonNullList<ItemStack> list)
    {
        if (item != Item.getItemFromBlock(ModBlocks.BLOCK_DOUBLE_SLAB_MOD))
        {
            for (BlockModSlab.EnumType blockstoneslab$enumtype : BlockModSlab.EnumType.values())
            {
                list.add(new ItemStack(item, 1, blockstoneslab$enumtype.getMetadata()));
            }
        }
    }

    @Override
    public IBlockState getStateFromMeta(int meta)
    {
        if (isDouble())
        {
            return getDefaultState().withProperty(VARIANT, BlockModSlab.EnumType.byMetadata(meta));
        }
        else
        {
            return getDefaultState().withProperty(VARIANT, BlockModSlab.EnumType.byMetadata(meta)).withProperty(HALF, meta < 8 ? BlockSlab.EnumBlockHalf.BOTTOM : BlockSlab.EnumBlockHalf.TOP);
        }
    }

    @Override
    public int getMetaFromState(IBlockState state)
    {
        BlockModSlab.EnumType type = state.getValue(VARIANT);

        return type.getMetadata();
    }

    @Override
    public IBlockState getStateForPlacement(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer)
    {
        return isDouble() ? getStateFromMeta(meta) : facing != EnumFacing.DOWN && (facing == EnumFacing.UP || hitY <= 0.5D) ? getStateFromMeta(meta).withProperty(HALF, BlockSlab.EnumBlockHalf.BOTTOM) : getStateFromMeta(meta).withProperty(HALF, BlockSlab.EnumBlockHalf.TOP);
    }

    @Override
    protected BlockStateContainer createBlockState()
    {
        return isDouble() ? new BlockStateContainer(this, new IProperty[] {VARIANT}) : new BlockStateContainer(this, new IProperty[] {HALF, VARIANT});
    }

    @Override
    public int damageDropped(IBlockState state)
    {
        return state.getValue(VARIANT).getMetadata();
    }

    @Override
    public MapColor getMapColor(IBlockState state)
    {
        return state.getValue(VARIANT).getMapColor();
    }

    public static enum EnumType implements IStringSerializable
    {
        SMOOTH_PRISMARINE(0, MapColor.STONE, Names.BLOCK_SMOOTH_PRISMARINE),
        SMOOTH_DARK_PRISMARINE(1, MapColor.STONE, Names.BLOCK_SMOOTH_DARK_PRISMARINE),
        SMOOTH_END_STONE(2, MapColor.STONE, Names.BLOCK_SMOOTH_END_STONE),
        SMOOTH_NETHERRACK(3, MapColor.STONE, Names.BLOCK_SMOOTH_NETHERRACK);

        private static final BlockModSlab.EnumType[] META_LOOKUP = new BlockModSlab.EnumType[values().length];

        private final int meta;
        private final MapColor mapColor;
        private final String name;
        private final String unlocalizedName;

        private EnumType(int damage, MapColor color, String blockName)
        {
            this(damage, color, blockName, blockName);
        }

        private EnumType(int damage, MapColor color, String blockName, String unlocalizedBlockName)
        {
            meta = damage;
            mapColor = color;
            name = blockName;
            unlocalizedName = unlocalizedBlockName;
        }

        public int getMetadata()
        {
            return meta;
        }

        public MapColor getMapColor()
        {
            return mapColor;
        }

        @Override
        public String toString()
        {
            return name;
        }

        public static BlockModSlab.EnumType byMetadata(int meta)
        {
            if (meta < 0 || meta >= META_LOOKUP.length)
            {
                meta = 0;
            }

            return META_LOOKUP[meta];
        }

        @Override
        public String getName()
        {
            return name;
        }

        public String getUnlocalizedName()
        {
            return unlocalizedName;
        }

        static
        {
            for (BlockModSlab.EnumType blockstoneslab$enumtype : values())
            {
                META_LOOKUP[blockstoneslab$enumtype.getMetadata()] = blockstoneslab$enumtype;
            }
        }
    }
}
