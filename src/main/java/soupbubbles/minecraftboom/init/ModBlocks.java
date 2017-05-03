package soupbubbles.minecraftboom.init;

import java.util.HashSet;
import java.util.Set;

import javax.annotation.Nullable;

import com.google.common.base.Function;

import net.minecraft.block.Block;
import net.minecraft.block.BlockPrismarine;
import net.minecraft.block.BlockRedSandstone;
import net.minecraft.block.BlockSandStone;
import net.minecraft.block.BlockStone;
import net.minecraft.block.BlockStoneBrick;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.fml.common.registry.ExistingSubstitutionException;
import net.minecraftforge.fml.common.registry.GameRegistry;
import soupbubbles.minecraftboom.block.BlockCraftingTable;
import soupbubbles.minecraftboom.block.BlockModSlabDouble;
import soupbubbles.minecraftboom.block.BlockModSlabHalf;
import soupbubbles.minecraftboom.block.BlockPolished;
import soupbubbles.minecraftboom.block.BlockVanillaStoneSlabDouble;
import soupbubbles.minecraftboom.block.BlockVanillaStoneSlabDouble2;
import soupbubbles.minecraftboom.block.BlockVanillaStoneSlabHalf;
import soupbubbles.minecraftboom.block.BlockVanillaStoneSlabHalf2;
import soupbubbles.minecraftboom.block.base.BlockBase;
import soupbubbles.minecraftboom.block.base.BlockColoredBase;
import soupbubbles.minecraftboom.block.base.BlockPillarBase;
import soupbubbles.minecraftboom.block.base.BlockStairBase;
import soupbubbles.minecraftboom.item.base.ItemBlockMeta;
import soupbubbles.minecraftboom.item.base.ItemSlabBase;
import soupbubbles.minecraftboom.reference.Names;
import soupbubbles.minecraftboom.reference.Reference;
import soupbubbles.minecraftboom.tileentity.TileEntityCraftingTable;

public class ModBlocks
{
    public static final Set<Block> BLOCKS = new HashSet<>();

    public static final BlockBase BLOCK_SPRUCE_BOOKSHELF;
    public static final BlockBase BLOCK_JUNGLE_BOOKSHELF;
    public static final BlockBase BLOCK_BIRCH_BOOKSHELF;
    public static final BlockBase BLOCK_DARK_OAK_BOOKSHELF;
    public static final BlockBase BLOCK_ACACIA_BOOKSHELF;

    public static final BlockBase BLOCK_HARDENED_CLAY_BRICKS;
    public static final BlockColoredBase BLOCK_STAINED_CLAY_BRICKS;

    public static final BlockPolished BLOCK_POLISHED;

    public static final BlockPillarBase BLOCK_PILLAR_SMOOTH_GRANITE;
    public static final BlockPillarBase BLOCK_PILLAR_SMOOTH_DIORITE;
    public static final BlockPillarBase BLOCK_PILLAR_SMOOTH_ANDESITE;
    public static final BlockPillarBase BLOCK_PILLAR_SMOOTH_PRISMARINE;
    public static final BlockPillarBase BLOCK_PILLAR_SMOOTH_DARK_PRISMARINE;
    public static final BlockPillarBase BLOCK_PILLAR_SMOOTH_END_STONE;
    public static final BlockPillarBase BLOCK_PILLAR_SMOOTH_NETHERRACK;

    public static final BlockStairBase BLOCK_STAIRS_STONE;
    public static final BlockStairBase BLOCK_STAIRS_SMOOTH_GRANITE;
    public static final BlockStairBase BLOCK_STAIRS_SMOOTH_DIORITE;
    public static final BlockStairBase BLOCK_STAIRS_SMOOTH_ANDESITE;
    public static final BlockStairBase BLOCK_STAIRS_MOSSY_COBBLESTONE;
    public static final BlockStairBase BLOCK_STAIRS_MOSSY_STONEBRICK;
    public static final BlockStairBase BLOCK_STAIRS_CRACKED_STONEBRICK;
    public static final BlockStairBase BLOCK_STAIRS_HARDENED_CLAY;
    public static final BlockStairBase BLOCK_STAIRS_CHISELED_SANDSTONE;
    public static final BlockStairBase BLOCK_STAIRS_SMOOTH_SANDSTONE;
    public static final BlockStairBase BLOCK_STAIRS_CHISELED_RED_SANDSTONE;
    public static final BlockStairBase BLOCK_STAIRS_SMOOTH_RED_SANDSTONE;
    public static final BlockStairBase BLOCK_STAIRS_PRISMARINE_BRICKS;
    public static final BlockStairBase BLOCK_STAIRS_DARK_PRISMARINE;
    public static final BlockStairBase BLOCK_STAIRS_END_BRICKS;
    public static final BlockStairBase BLOCK_STAIRS_RED_NETHER_BRICK;
    public static final BlockStairBase BLOCK_STAIRS_SMOOTH_PRISMARINE;
    public static final BlockStairBase BLOCK_STAIRS_SMOOTH_DARK_PRISMARINE;
    public static final BlockStairBase BLOCK_STAIRS_SMOOTH_END_STONE;
    public static final BlockStairBase BLOCK_STAIRS_SMOOTH_NETHERRACK;

    public static final BlockVanillaStoneSlabHalf BLOCK_HALF_SLAB_VANILLA_STONE;
    public static final BlockVanillaStoneSlabDouble BLOCK_DOUBLE_SLAB_VANILLA_STONE;
    public static final BlockVanillaStoneSlabHalf2 BLOCK_HALF_SLAB_VANILLA_STONE_2;
    public static final BlockVanillaStoneSlabDouble2 BLOCK_DOUBLE_SLAB_VANILLA_STONE_2;

    public static final BlockModSlabHalf BLOCK_HALF_SLAB_MOD;
    public static final BlockModSlabDouble BLOCK_DOUBLE_SLAB_MOD;

    public static final Block BLOCK_CRAFTING_TABLE;

    static
    {
        BLOCK_SPRUCE_BOOKSHELF = registerBlock(new BlockBase(Names.BLOCK_SPRUCE_BOOKSHELF));
        BLOCK_JUNGLE_BOOKSHELF = registerBlock(new BlockBase(Names.BLOCK_JUNGLE_BOOKSHELF));
        BLOCK_BIRCH_BOOKSHELF = registerBlock(new BlockBase(Names.BLOCK_BIRCH_BOOKSHELF));
        BLOCK_DARK_OAK_BOOKSHELF = registerBlock(new BlockBase(Names.BLOCK_DARK_OAK_BOOKSHELF));
        BLOCK_ACACIA_BOOKSHELF = registerBlock(new BlockBase(Names.BLOCK_ACACIA_BOOKSHELF));

        BLOCK_HARDENED_CLAY_BRICKS = registerBlock(new BlockBase(Names.BLOCK_HARDENED_CLAY_BRICKS));
        BLOCK_STAINED_CLAY_BRICKS = new BlockColoredBase(Names.BLOCK_STAINED_HARDENED_CLAY_BRICKS);
        registerBlockMeta(BLOCK_STAINED_CLAY_BRICKS, new ItemBlockMeta(BLOCK_STAINED_CLAY_BRICKS, Names.BLOCK_STAINED_HARDENED_CLAY_BRICKS));

        BLOCK_POLISHED = new BlockPolished();
        registerBlockMeta(BLOCK_POLISHED);

        BLOCK_PILLAR_SMOOTH_GRANITE = registerBlock(new BlockPillarBase(Names.BLOCK_PILLAR_SMOOTH_GRANITE));
        BLOCK_PILLAR_SMOOTH_DIORITE = registerBlock(new BlockPillarBase(Names.BLOCK_PILLAR_SMOOTH_DIORITE));
        BLOCK_PILLAR_SMOOTH_ANDESITE = registerBlock(new BlockPillarBase(Names.BLOCK_PILLAR_SMOOTH_ANDESITE));
        BLOCK_PILLAR_SMOOTH_PRISMARINE = registerBlock(new BlockPillarBase(Names.BLOCK_PILLAR_SMOOTH_PRISMARINE));
        BLOCK_PILLAR_SMOOTH_DARK_PRISMARINE = registerBlock(new BlockPillarBase(Names.BLOCK_PILLAR_SMOOTH_DARK_PRISMARINE));
        BLOCK_PILLAR_SMOOTH_END_STONE = registerBlock(new BlockPillarBase(Names.BLOCK_PILLAR_SMOOTH_END_STONE));
        BLOCK_PILLAR_SMOOTH_NETHERRACK = registerBlock(new BlockPillarBase(Names.BLOCK_PILLAR_SMOOTH_NETHERRACK));

        BLOCK_STAIRS_STONE = registerBlock(new BlockStairBase(Blocks.STONE.getDefaultState().withProperty(BlockStone.VARIANT, BlockStone.EnumType.STONE), Names.STONE));
        BLOCK_STAIRS_SMOOTH_GRANITE = registerBlock(new BlockStairBase(Blocks.STONE.getDefaultState().withProperty(BlockStone.VARIANT, BlockStone.EnumType.GRANITE_SMOOTH), Names.SMOOTH_GRANITE));
        BLOCK_STAIRS_SMOOTH_DIORITE = registerBlock(new BlockStairBase(Blocks.STONE.getDefaultState().withProperty(BlockStone.VARIANT, BlockStone.EnumType.DIORITE_SMOOTH), Names.SMOOTH_DIORITE));
        BLOCK_STAIRS_SMOOTH_ANDESITE = registerBlock(new BlockStairBase(Blocks.STONE.getDefaultState().withProperty(BlockStone.VARIANT, BlockStone.EnumType.ANDESITE_SMOOTH), Names.SMOOTH_ANDESITE));
        BLOCK_STAIRS_MOSSY_COBBLESTONE = registerBlock(new BlockStairBase(Blocks.MOSSY_COBBLESTONE.getDefaultState(), Names.MOSSY_COBBLESTONE));
        BLOCK_STAIRS_MOSSY_STONEBRICK = registerBlock(new BlockStairBase(Blocks.STONEBRICK.getDefaultState().withProperty(BlockStoneBrick.VARIANT, BlockStoneBrick.EnumType.CHISELED), Names.MOSSY_STONEBRICK));
        BLOCK_STAIRS_CRACKED_STONEBRICK = registerBlock(new BlockStairBase(Blocks.STONEBRICK.getDefaultState().withProperty(BlockStoneBrick.VARIANT, BlockStoneBrick.EnumType.CRACKED), Names.CRACKED_STONEBRICK));
        BLOCK_STAIRS_HARDENED_CLAY = registerBlock(new BlockStairBase(Blocks.HARDENED_CLAY.getDefaultState(), Names.HARDENED_CLAY));
        BLOCK_STAIRS_CHISELED_SANDSTONE = registerBlock(new BlockStairBase(Blocks.SANDSTONE.getDefaultState().withProperty(BlockSandStone.TYPE, BlockSandStone.EnumType.CHISELED), Names.CHISELED_SANDSTONE));
        BLOCK_STAIRS_SMOOTH_SANDSTONE = registerBlock(new BlockStairBase(Blocks.SANDSTONE.getDefaultState().withProperty(BlockSandStone.TYPE, BlockSandStone.EnumType.SMOOTH), Names.SMOOTH_SANDSTONE));
        BLOCK_STAIRS_CHISELED_RED_SANDSTONE = registerBlock(new BlockStairBase(Blocks.RED_SANDSTONE.getDefaultState().withProperty(BlockRedSandstone.TYPE, BlockRedSandstone.EnumType.CHISELED), Names.CHISELED_RED_SANDSTONE));
        BLOCK_STAIRS_SMOOTH_RED_SANDSTONE = registerBlock(new BlockStairBase(Blocks.RED_SANDSTONE.getDefaultState().withProperty(BlockRedSandstone.TYPE, BlockRedSandstone.EnumType.SMOOTH), Names.SMOOTH_RED_SANDSTONE));
        BLOCK_STAIRS_PRISMARINE_BRICKS = registerBlock(new BlockStairBase(Blocks.PRISMARINE.getDefaultState().withProperty(BlockPrismarine.VARIANT, BlockPrismarine.EnumType.BRICKS), Names.PRISMARINE_BRICKS));
        BLOCK_STAIRS_DARK_PRISMARINE = registerBlock(new BlockStairBase(Blocks.PRISMARINE.getDefaultState().withProperty(BlockPrismarine.VARIANT, BlockPrismarine.EnumType.DARK), Names.DARK_PRISMARINE));
        BLOCK_STAIRS_END_BRICKS = registerBlock(new BlockStairBase(Blocks.END_BRICKS.getDefaultState(), Names.END_BRICKS));
        BLOCK_STAIRS_RED_NETHER_BRICK = registerBlock(new BlockStairBase(Blocks.RED_NETHER_BRICK.getDefaultState(), Names.RED_NETHER_BRICK));
        BLOCK_STAIRS_SMOOTH_PRISMARINE = registerBlock(new BlockStairBase(BLOCK_POLISHED.getDefaultState().withProperty(BLOCK_POLISHED.getVariants(), BlockPolished.EnumType.SMOOTH_PRISMARINE), Names.BLOCK_SMOOTH_PRISMARINE));
        BLOCK_STAIRS_SMOOTH_DARK_PRISMARINE = registerBlock(new BlockStairBase(BLOCK_POLISHED.getDefaultState().withProperty(BLOCK_POLISHED.getVariants(), BlockPolished.EnumType.SMOOTH_DARK_PRISMARINE), Names.BLOCK_SMOOTH_DARK_PRISMARINE));
        BLOCK_STAIRS_SMOOTH_END_STONE = registerBlock(new BlockStairBase(BLOCK_POLISHED.getDefaultState().withProperty(BLOCK_POLISHED.getVariants(), BlockPolished.EnumType.SMOOTH_END_STONE), Names.BLOCK_SMOOTH_END_STONE));
        BLOCK_STAIRS_SMOOTH_NETHERRACK = registerBlock(new BlockStairBase(BLOCK_POLISHED.getDefaultState().withProperty(BLOCK_POLISHED.getVariants(), BlockPolished.EnumType.SMOOTH_NETHERRACK), Names.BLOCK_SMOOTH_NETHERRACK));

        BLOCK_HALF_SLAB_VANILLA_STONE = new BlockVanillaStoneSlabHalf();
        BLOCK_DOUBLE_SLAB_VANILLA_STONE = new BlockVanillaStoneSlabDouble();
        BLOCK_HALF_SLAB_VANILLA_STONE_2 = new BlockVanillaStoneSlabHalf2();
        BLOCK_DOUBLE_SLAB_VANILLA_STONE_2 = new BlockVanillaStoneSlabDouble2();
        BLOCK_HALF_SLAB_MOD = new BlockModSlabHalf();
        BLOCK_DOUBLE_SLAB_MOD = new BlockModSlabDouble();

        registerBlockMeta(BLOCK_HALF_SLAB_VANILLA_STONE, new ItemSlabBase(BLOCK_HALF_SLAB_VANILLA_STONE, BLOCK_HALF_SLAB_VANILLA_STONE, BLOCK_DOUBLE_SLAB_VANILLA_STONE));
        registerBlockMeta(BLOCK_DOUBLE_SLAB_VANILLA_STONE, new ItemSlabBase(BLOCK_DOUBLE_SLAB_VANILLA_STONE, BLOCK_HALF_SLAB_VANILLA_STONE, BLOCK_DOUBLE_SLAB_VANILLA_STONE));
        registerBlockMeta(BLOCK_HALF_SLAB_VANILLA_STONE_2, new ItemSlabBase(BLOCK_HALF_SLAB_VANILLA_STONE_2, BLOCK_HALF_SLAB_VANILLA_STONE_2, BLOCK_DOUBLE_SLAB_VANILLA_STONE_2));
        registerBlockMeta(BLOCK_DOUBLE_SLAB_VANILLA_STONE_2, new ItemSlabBase(BLOCK_DOUBLE_SLAB_VANILLA_STONE_2, BLOCK_HALF_SLAB_VANILLA_STONE_2, BLOCK_DOUBLE_SLAB_VANILLA_STONE_2));
        registerBlockMeta(BLOCK_HALF_SLAB_MOD, new ItemSlabBase(BLOCK_HALF_SLAB_MOD, BLOCK_HALF_SLAB_MOD, BLOCK_DOUBLE_SLAB_MOD));
        registerBlockMeta(BLOCK_DOUBLE_SLAB_MOD, new ItemSlabBase(BLOCK_DOUBLE_SLAB_MOD, BLOCK_HALF_SLAB_MOD, BLOCK_DOUBLE_SLAB_MOD));

        BLOCK_CRAFTING_TABLE = replaceBlock(new BlockCraftingTable(), Names.BLOCK_CRAFTING_TABLE);
    }

    public static void registerBlocks()
    {
    }

    public static void registerTileEntities()
    {
        GameRegistry.registerTileEntity(TileEntityCraftingTable.class, Reference.MOD_ID + ":" + TileEntityCraftingTable.class.getSimpleName());
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
        return registerBlockMeta(block, new ItemBlockMeta(block, ""));
    }

    protected static <BLOCK extends Block> BLOCK registerBlockMeta(BLOCK block, ItemBlockMeta itemBlock)
    {
        GameRegistry.register(block);
        GameRegistry.register(itemBlock);

        BLOCKS.add(block);
        return block;
    }

    protected static Block replaceBlock(Block block, String name)
    {
        if (block.getRegistryName() == null)
        {
            block.setRegistryName(name);
        }
        try
        {
            GameRegistry.addSubstitutionAlias("minecraft:" + name, GameRegistry.Type.BLOCK, block);
            //GameRegistry.addSubstitutionAlias("minecraft:" + name, GameRegistry.Type.ITEM, new ItemBlock(block).setRegistryName(name));
        }
        catch (ExistingSubstitutionException e)
        {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

        return block;
    }
}
