package soupbubbles.minecraftboom.init;

import java.util.HashSet;
import java.util.Set;
import java.util.function.Function;

import javax.annotation.Nullable;

import net.minecraft.block.Block;
import net.minecraft.block.BlockPrismarine;
import net.minecraft.block.BlockStone;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.fml.common.registry.GameRegistry;
import soupbubbles.minecraftboom.block.BlockModSlabDouble;
import soupbubbles.minecraftboom.block.BlockModSlabHalf;
import soupbubbles.minecraftboom.block.BlockPolished;
import soupbubbles.minecraftboom.block.BlockStairsStone;
import soupbubbles.minecraftboom.block.BlockVanillaSlabDouble;
import soupbubbles.minecraftboom.block.BlockVanillaSlabHalf;
import soupbubbles.minecraftboom.item.base.ItemBlockMeta;
import soupbubbles.minecraftboom.item.base.ItemSlabBase;
import soupbubbles.minecraftboom.reference.Names;

public class ModBlocks
{
    public static final Set<Block> BLOCKS = new HashSet<>();

    public static final BlockPolished BLOCK_POLISHED;

    public static final BlockStairsStone BLOCK_STAIRS_STONE;
    public static final BlockStairsStone BLOCK_STAIRS_SMOOTH_GRANITE;
    public static final BlockStairsStone BLOCK_STAIRS_SMOOTH_DIORITE;
    public static final BlockStairsStone BLOCK_STAIRS_SMOOTH_ANDESITE;
    public static final BlockStairsStone BLOCK_STAIRS_PRISMARINE_BRICKS;
    public static final BlockStairsStone BLOCK_STAIRS_DARK_PRISMARINE;
    public static final BlockStairsStone BLOCK_STAIRS_END_BRICKS;
    public static final BlockStairsStone BLOCK_STAIRS_RED_NETHER_BRICK;

    public static final BlockStairsStone BLOCK_STAIRS_SMOOTH_PRISMARINE;
    public static final BlockStairsStone BLOCK_STAIRS_SMOOTH_DARK_PRISMARINE;
    public static final BlockStairsStone BLOCK_STAIRS_SMOOTH_END_STONE;
    public static final BlockStairsStone BLOCK_STAIRS_SMOOTH_NETHERRACK;

    public static final BlockVanillaSlabHalf BLOCK_HALF_SLAB_VANILLA;
    public static final BlockVanillaSlabDouble BLOCK_DOUBLE_SLAB_VANILLA;
    public static final BlockModSlabHalf BLOCK_HALF_SLAB_MOD;
    public static final BlockModSlabDouble BLOCK_DOUBLE_SLAB_MOD;

    static
    {
        BLOCK_POLISHED = new BlockPolished();
        registerBlockMeta(BLOCK_POLISHED);

        BLOCK_STAIRS_STONE = registerBlock(new BlockStairsStone(Blocks.STONE.getDefaultState().withProperty(BlockStone.VARIANT, BlockStone.EnumType.STONE), Names.STONE));
        BLOCK_STAIRS_SMOOTH_GRANITE = registerBlock(new BlockStairsStone(Blocks.STONE.getDefaultState().withProperty(BlockStone.VARIANT, BlockStone.EnumType.GRANITE_SMOOTH), Names.SMOOTH_GRANITE));
        BLOCK_STAIRS_SMOOTH_DIORITE = registerBlock(new BlockStairsStone(Blocks.STONE.getDefaultState().withProperty(BlockStone.VARIANT, BlockStone.EnumType.DIORITE_SMOOTH), Names.SMOOTH_DIORITE));
        BLOCK_STAIRS_SMOOTH_ANDESITE = registerBlock(new BlockStairsStone(Blocks.STONE.getDefaultState().withProperty(BlockStone.VARIANT, BlockStone.EnumType.ANDESITE_SMOOTH), Names.SMOOTH_ANDESITE));
        BLOCK_STAIRS_PRISMARINE_BRICKS = registerBlock(new BlockStairsStone(Blocks.PRISMARINE.getDefaultState().withProperty(BlockPrismarine.VARIANT, BlockPrismarine.EnumType.BRICKS), Names.PRISMARINE_BRICKS));
        BLOCK_STAIRS_DARK_PRISMARINE = registerBlock(new BlockStairsStone(Blocks.PRISMARINE.getDefaultState().withProperty(BlockPrismarine.VARIANT, BlockPrismarine.EnumType.DARK), Names.DARK_PRISMARINE));
        BLOCK_STAIRS_END_BRICKS = registerBlock(new BlockStairsStone(Blocks.END_BRICKS.getDefaultState(), Names.END_BRICKS));
        BLOCK_STAIRS_RED_NETHER_BRICK = registerBlock(new BlockStairsStone(Blocks.RED_NETHER_BRICK.getDefaultState(), Names.RED_NETHER_BRICK));

        BLOCK_STAIRS_SMOOTH_PRISMARINE = registerBlock(new BlockStairsStone(BLOCK_POLISHED.getDefaultState().withProperty(BLOCK_POLISHED.getVariants(), BlockPolished.EnumType.SMOOTH_PRISMARINE), Names.BLOCK_SMOOTH_PRISMARINE));
        BLOCK_STAIRS_SMOOTH_DARK_PRISMARINE = registerBlock(new BlockStairsStone(BLOCK_POLISHED.getDefaultState().withProperty(BLOCK_POLISHED.getVariants(), BlockPolished.EnumType.SMOOTH_DARK_PRISMARINE), Names.BLOCK_SMOOTH_DARK_PRISMARINE));
        BLOCK_STAIRS_SMOOTH_END_STONE = registerBlock(new BlockStairsStone(BLOCK_POLISHED.getDefaultState().withProperty(BLOCK_POLISHED.getVariants(), BlockPolished.EnumType.SMOOTH_END_STONE), Names.BLOCK_SMOOTH_END_STONE));
        BLOCK_STAIRS_SMOOTH_NETHERRACK = registerBlock(new BlockStairsStone(BLOCK_POLISHED.getDefaultState().withProperty(BLOCK_POLISHED.getVariants(), BlockPolished.EnumType.SMOOTH_NETHERRACK), Names.BLOCK_SMOOTH_NETHERRACK));

        BLOCK_HALF_SLAB_VANILLA = new BlockVanillaSlabHalf();
        BLOCK_DOUBLE_SLAB_VANILLA = new BlockVanillaSlabDouble();

        registerBlockMeta(BLOCK_HALF_SLAB_VANILLA, new ItemSlabBase(BLOCK_HALF_SLAB_VANILLA, BLOCK_HALF_SLAB_VANILLA, BLOCK_DOUBLE_SLAB_VANILLA));
        registerBlockMeta(BLOCK_DOUBLE_SLAB_VANILLA, new ItemSlabBase(BLOCK_DOUBLE_SLAB_VANILLA, BLOCK_HALF_SLAB_VANILLA, BLOCK_DOUBLE_SLAB_VANILLA));

        BLOCK_HALF_SLAB_MOD = new BlockModSlabHalf();
        BLOCK_DOUBLE_SLAB_MOD = new BlockModSlabDouble();

        registerBlockMeta(BLOCK_HALF_SLAB_MOD, new ItemSlabBase(BLOCK_HALF_SLAB_MOD, BLOCK_HALF_SLAB_MOD, BLOCK_DOUBLE_SLAB_MOD));
        registerBlockMeta(BLOCK_DOUBLE_SLAB_MOD, new ItemSlabBase(BLOCK_DOUBLE_SLAB_MOD, BLOCK_HALF_SLAB_MOD, BLOCK_DOUBLE_SLAB_MOD));
    }

    public static void registerBlocks()
    {
    }

    public static void registerTileEntities()
    {
    }

    protected static <BLOCK extends Block> BLOCK registerBlock(BLOCK block)
    {
        return registerBlock(block, ItemBlock::new);
    }

    protected static <BLOCK extends Block> BLOCK registerBlock(BLOCK block, @Nullable Function<BLOCK, ItemBlock> itemFactory)
    {
        GameRegistry.register(block);

        if (itemFactory != null)
        {
            final ItemBlock itemBlock = itemFactory.apply(block);

            GameRegistry.register(itemBlock.setRegistryName(block.getRegistryName()));
        }

        BLOCKS.add(block);
        return block;
    }

    protected static <BLOCK extends Block> BLOCK registerBlockMeta(BLOCK block)
    {
        return registerBlockMeta(block, new ItemBlockMeta(block));
    }
    
    protected static <BLOCK extends Block> BLOCK registerBlockMeta(BLOCK block, ItemBlockMeta itemBlock)
    {
        GameRegistry.register(block);
        GameRegistry.register(itemBlock);

        BLOCKS.add(block);
        return block;
    }
}
