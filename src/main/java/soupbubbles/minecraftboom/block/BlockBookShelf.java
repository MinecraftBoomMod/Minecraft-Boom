package soupbubbles.minecraftboom.block;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.NonNullList;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import soupbubbles.minecraftboom.block.base.BlockBase;
import soupbubbles.minecraftboom.block.base.IBlockMeta;
import soupbubbles.minecraftboom.reference.Assets;
import soupbubbles.minecraftboom.reference.Names;

public class BlockBookShelf extends BlockBase implements IBlockMeta
{
    public static final PropertyEnum<BlockBookShelf.EnumType> VARIANT = PropertyEnum.<BlockBookShelf.EnumType>create("variant", BlockBookShelf.EnumType.class);

    public BlockBookShelf()
    {
        super(Material.WOOD, Names.BLOCK_BOOKSHELF);
        setDefaultState(blockState.getBaseState().withProperty(VARIANT, BlockBookShelf.EnumType.SPRUCE));
        setHardness(2.0F);
        setResistance(5.0F);
        setSoundType(SoundType.WOOD);
    }

    @Override
    public String getSpecialName(int meta)
    {
        return String.format(Assets.BLOCK_PREFIX, Assets.ASSET_PREFIX, BlockBookShelf.EnumType.byMetadata(meta).getName() + "_" + BASE_NAME);
    }
    
    @Override
    public int damageDropped(IBlockState state)
    {
        return ((BlockBookShelf.EnumType)state.getValue(VARIANT)).getMetadata();
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void getSubBlocks(Item item, CreativeTabs tab, NonNullList<ItemStack> list)
    {
        for (BlockBookShelf.EnumType blockbookshelf$enumtype : BlockBookShelf.EnumType.values())
        {
            list.add(new ItemStack(item, 1, blockbookshelf$enumtype.getMetadata()));
        }
    }

    @Override
    public IBlockState getStateFromMeta(int meta)
    {
        return getDefaultState().withProperty(VARIANT, BlockBookShelf.EnumType.byMetadata(meta));
    }

    @Override
    public MapColor getMapColor(IBlockState state)
    {
        return ((BlockBookShelf.EnumType)state.getValue(VARIANT)).getMapColor();
    }

    @Override
    public int getMetaFromState(IBlockState state)
    {
        return ((BlockBookShelf.EnumType)state.getValue(VARIANT)).getMetadata();
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
    
    public static enum EnumType implements IStringSerializable
    {
        SPRUCE(0, Names.SPRUCE, MapColor.OBSIDIAN),
        BIRCH(1, Names.BIRCH, MapColor.SAND),
        JUNGLE(2, Names.JUNGLE, MapColor.DIRT),
        ACACIA(3, Names.ACACIA, MapColor.ADOBE),
        DARK_OAK(4, Names.DARK_OAK, MapColor.BROWN);

        private static final BlockBookShelf.EnumType[] META_LOOKUP = new BlockBookShelf.EnumType[values().length];
        private final int meta;
        private final String name;
        private final MapColor mapColor;

        private EnumType(int metaIn, String nameIn, MapColor mapColorIn)
        {
            meta = metaIn;
            name = nameIn;
            mapColor = mapColorIn;
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

        public static BlockBookShelf.EnumType byMetadata(int meta)
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

        static
        {
            for (BlockBookShelf.EnumType blockbookshelf$enumtype : values())
            {
                META_LOOKUP[blockbookshelf$enumtype.getMetadata()] = blockbookshelf$enumtype;
            }
        }
    }

}
