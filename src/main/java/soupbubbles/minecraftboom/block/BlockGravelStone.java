package soupbubbles.minecraftboom.block;

import java.util.Random;

import net.minecraft.block.material.MapColor;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import soupbubbles.minecraftboom.block.base.BlockBase;
import soupbubbles.minecraftboom.init.ModBlocks;
import soupbubbles.minecraftboom.reference.Assets;
import soupbubbles.minecraftboom.reference.BlockValues;
import soupbubbles.minecraftboom.reference.Names;
import soupbubbles.minecraftboom.util.IBlockMeta;

public class BlockGravelStone extends BlockBase implements IBlockMeta
{
    public static final PropertyEnum<BlockGravelStone.EnumType> VARIANT = PropertyEnum.<BlockGravelStone.EnumType>create(Assets.VARIANT_NAME_VARIANT, BlockGravelStone.EnumType.class);

    public BlockGravelStone()
    {
        super(Names.BLOCK_GRAVEL_STONE);
        setHardness(BlockValues.STONE_HARDNESS);
        setResistance(BlockValues.STONE_RESISTANCE);
    }

    @Override
    public String getSpecialName(int meta)
    {
        return String.format(Assets.BLOCK_PREFIX, Assets.ASSET_PREFIX, BlockGravelStone.EnumType.byMetadata(meta).getUnlocalizedName());
    }

    @Override
    public MapColor getMapColor(IBlockState state, IBlockAccess worldIn, BlockPos pos)
    {
        return state.getValue(VARIANT).getMapColor();
    }

    @Override
    public Item getItemDropped(IBlockState state, Random rand, int fortune)
    {
        return Item.getItemFromBlock(ModBlocks.BLOCK_POLISHED);
    }

    @Override
    public int damageDropped(IBlockState state)
    {
        return state.getValue(VARIANT).getMetadata();
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void getSubBlocks(CreativeTabs tab, NonNullList<ItemStack> list)
    {
        for (BlockGravelStone.EnumType blockpolished$enumtype : BlockGravelStone.EnumType.values())
        {
            list.add(new ItemStack(this, 1, blockpolished$enumtype.getMetadata()));
        }
    }

    @Override
    public IBlockState getStateFromMeta(int meta)
    {
        return getDefaultState().withProperty(VARIANT, BlockGravelStone.EnumType.byMetadata(meta));
    }

    @Override
    public int getMetaFromState(IBlockState state)
    {
        return state.getValue(VARIANT).getMetadata();
    }

    @Override
    protected BlockStateContainer createBlockState()
    {
        return new BlockStateContainer(this, new IProperty[] {VARIANT});
    }

    @Override
    public PropertyEnum getVariants()
    {
        return VARIANT;
    }

    @Override
    public String getVariantName()
    {
        return Assets.VARIANT_NAME_VARIANT;
    }

    public static enum EnumType implements IStringSerializable
    {
        GRAVEL_STONE(0, MapColor.STONE, Names.BLOCK_GRAVEL_STONE),
        FINE_GRAVEL_STONE(1, MapColor.STONE, Names.BLOCK_FINE_GRAVEL_STONE),
        GRAVEL_BRICKS(2, MapColor.STONE, Names.BLOCK_GRAVEL_BRICKS);

        private static final BlockGravelStone.EnumType[] META_LOOKUP = new BlockGravelStone.EnumType[values().length];

        private final int meta;
        private final String name;
        private final String unlocalizedName;
        private final MapColor mapColor;

        private EnumType(int damage, MapColor color, String name)
        {
            this(damage, color, name, name);
        }

        private EnumType(int damage, MapColor color, String blockName, String blockUnlocalizedName)
        {
            meta = damage;
            name = blockName;
            unlocalizedName = blockUnlocalizedName;
            mapColor = color;
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

        public static BlockGravelStone.EnumType byMetadata(int meta)
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
            for (BlockGravelStone.EnumType blockpolished$enumtype : values())
            {
                META_LOOKUP[blockpolished$enumtype.getMetadata()] = blockpolished$enumtype;
            }
        }
    }
}