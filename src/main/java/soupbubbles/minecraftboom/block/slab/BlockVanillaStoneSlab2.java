package soupbubbles.minecraftboom.block.slab;

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
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import soupbubbles.minecraftboom.block.base.BlockSlabBase;
import soupbubbles.minecraftboom.init.ModBlocks;
import soupbubbles.minecraftboom.reference.Assets;
import soupbubbles.minecraftboom.reference.BlockValues;
import soupbubbles.minecraftboom.reference.Names;

public class BlockVanillaStoneSlab2 extends BlockSlabBase
{
    protected static final PropertyEnum<BlockVanillaStoneSlab2.EnumType> VARIANT = PropertyEnum.<BlockVanillaStoneSlab2.EnumType>create(Assets.VARIANT_NAME_VARIANT, BlockVanillaStoneSlab2.EnumType.class);

    protected boolean isDouble;

    public BlockVanillaStoneSlab2(String name, boolean isDouble)
    {
        super(Material.ROCK, name);
        IBlockState iblockstate = blockState.getBaseState();

        if (!isDouble)
        {
            iblockstate = iblockstate.withProperty(HALF, BlockSlab.EnumBlockHalf.BOTTOM);
        }

        setDefaultState(iblockstate.withProperty(VARIANT, BlockVanillaStoneSlab2.EnumType.CHISLED_SANDSTONE));
        setHardness(BlockValues.STONE_HARDNESS);
        setResistance(BlockValues.STONE_RESISTANCE);
        setSoundType(SoundType.STONE);
        this.isDouble = isDouble;
    }

    @Override
    public boolean isDouble()
    {
        return isDouble;
    }
    
    @Override
    public Item getItemDropped(IBlockState state, Random rand, int fortune)
    {
        return Item.getItemFromBlock(ModBlocks.BLOCK_HALF_SLAB_VANILLA_STONE_2);
    }

    @Override
    public ItemStack getItem(World worldIn, BlockPos pos, IBlockState state)
    {
        return new ItemStack(ModBlocks.BLOCK_HALF_SLAB_VANILLA_STONE_2, 1, state.getValue(VARIANT).getMetadata());
    }

    @Override
    public String getUnlocalizedName(int meta)
    {
        return String.format(Assets.BLOCK_PREFIX, Assets.ASSET_PREFIX, BASE_NAME + "_" + BlockVanillaStoneSlab2.EnumType.byMetadata(meta).getUnlocalizedName());
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
        return BlockVanillaStoneSlab2.EnumType.byMetadata(stack.getMetadata() & 7);
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void getSubBlocks(CreativeTabs tab, NonNullList<ItemStack> list)
    {
        if (this != ModBlocks.BLOCK_DOUBLE_SLAB_VANILLA_STONE_2)
        {
            for (BlockVanillaStoneSlab2.EnumType blockstoneslab$enumtype : BlockVanillaStoneSlab2.EnumType.values())
            {
                list.add(new ItemStack(this, 1, blockstoneslab$enumtype.getMetadata()));
            }
        }
    }

    @Override
    public IBlockState getStateFromMeta(int meta)
    {
        IBlockState iblockstate = getDefaultState().withProperty(VARIANT, BlockVanillaStoneSlab2.EnumType.byMetadata(meta & 7));

        if (!isDouble())
        {
            iblockstate = iblockstate.withProperty(HALF, (meta & 8) == 0 ? BlockSlab.EnumBlockHalf.BOTTOM : BlockSlab.EnumBlockHalf.TOP);
        }

        return iblockstate;
    }

    @Override
    public int getMetaFromState(IBlockState state)
    {
        int i = 0;
        i = i | ((BlockVanillaStoneSlab2.EnumType)state.getValue(VARIANT)).getMetadata();

        if (!isDouble() && state.getValue(HALF) == BlockSlab.EnumBlockHalf.TOP)
        {
            i |= 8;
        }

        return i;
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
    public MapColor getMapColor(IBlockState state, IBlockAccess worldIn, BlockPos pos)
    {
        return ((BlockVanillaStoneSlab2.EnumType)state.getValue(VARIANT)).getMapColor();
    }

    @Override
    public PropertyEnum getVariants()
    {
        return VARIANT;
    }
    
    public static enum EnumType implements IStringSerializable
    {
        CHISLED_SANDSTONE(0, MapColor.STONE, Names.CHISELED_SANDSTONE),
        SMOOTH_SANDSTONE(1, MapColor.STONE, Names.SMOOTH_SANDSTONE),
        CHISLED_RED_SANDSTONE(2, MapColor.STONE, Names.CHISELED_RED_SANDSTONE),
        SMOOTH_RED_SANDSTONE(3, MapColor.STONE, Names.SMOOTH_RED_SANDSTONE),
        PRISMARINE_BRICKS(4, MapColor.STONE, Names.PRISMARINE_BRICKS),
        DARK_PRISMARINE(5, MapColor.STONE, Names.DARK_PRISMARINE),
        END_STONE_BRICKS(6, MapColor.STONE, Names.END_BRICKS),
        RED_NETHER_BRICKS(7, MapColor.STONE, Names.RED_NETHER_BRICK);

        private static final BlockVanillaStoneSlab2.EnumType[] META_LOOKUP = new BlockVanillaStoneSlab2.EnumType[values().length];

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

        public static BlockVanillaStoneSlab2.EnumType byMetadata(int meta)
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
            for (BlockVanillaStoneSlab2.EnumType blockstoneslab$enumtype : values())
            {
                META_LOOKUP[blockstoneslab$enumtype.getMetadata()] = blockstoneslab$enumtype;
            }
        }
    }
}
