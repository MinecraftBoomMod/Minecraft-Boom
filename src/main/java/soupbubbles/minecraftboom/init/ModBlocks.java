package soupbubbles.minecraftboom.init;

import java.util.HashSet;
import java.util.Set;

import javax.annotation.Nullable;

import com.google.common.base.Function;

import net.minecraft.block.Block;
import net.minecraft.block.BlockPrismarine;
import net.minecraft.block.BlockRedSandstone;
import net.minecraft.block.BlockSandStone;
import net.minecraft.block.BlockStainedHardenedClay;
import net.minecraft.block.BlockStone;
import net.minecraft.block.BlockStoneBrick;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.common.registry.GameRegistry;
import soupbubbles.minecraftboom.block.BlockBookShelf;
import soupbubbles.minecraftboom.block.BlockDye;
import soupbubbles.minecraftboom.block.BlockFacelessPumpkin;
import soupbubbles.minecraftboom.block.BlockGunpowder;
import soupbubbles.minecraftboom.block.BlockMagmaCream;
import soupbubbles.minecraftboom.block.BlockPolished;
import soupbubbles.minecraftboom.block.BlockRose;
import soupbubbles.minecraftboom.block.BlockSoulGlass;
import soupbubbles.minecraftboom.block.BlockSoulGlassPane;
import soupbubbles.minecraftboom.block.BlockWoodenButton;
import soupbubbles.minecraftboom.block.BlockWoodenLadder;
import soupbubbles.minecraftboom.block.BlockWoodenPressurePlate;
import soupbubbles.minecraftboom.block.BlockWoodenTrapDoor;
import soupbubbles.minecraftboom.block.base.BlockBase;
import soupbubbles.minecraftboom.block.base.BlockColoredBase;
import soupbubbles.minecraftboom.block.base.BlockFallingBase;
import soupbubbles.minecraftboom.block.base.BlockPaneBase;
import soupbubbles.minecraftboom.block.base.BlockPillarBase;
import soupbubbles.minecraftboom.block.base.BlockStairBase;
import soupbubbles.minecraftboom.block.slab.BlockConcreteSlabDouble;
import soupbubbles.minecraftboom.block.slab.BlockConcreteSlabDouble2;
import soupbubbles.minecraftboom.block.slab.BlockConcreteSlabHalf;
import soupbubbles.minecraftboom.block.slab.BlockConcreteSlabHalf2;
import soupbubbles.minecraftboom.block.slab.BlockModSlabDouble;
import soupbubbles.minecraftboom.block.slab.BlockModSlabHalf;
import soupbubbles.minecraftboom.block.slab.BlockTerracottaBricksSlabDouble;
import soupbubbles.minecraftboom.block.slab.BlockTerracottaBricksSlabDouble2;
import soupbubbles.minecraftboom.block.slab.BlockTerracottaBricksSlabHalf;
import soupbubbles.minecraftboom.block.slab.BlockTerracottaBricksSlabHalf2;
import soupbubbles.minecraftboom.block.slab.BlockTerracottaSlabDouble;
import soupbubbles.minecraftboom.block.slab.BlockTerracottaSlabDouble2;
import soupbubbles.minecraftboom.block.slab.BlockTerracottaSlabHalf;
import soupbubbles.minecraftboom.block.slab.BlockTerracottaSlabHalf2;
import soupbubbles.minecraftboom.block.slab.BlockVanillaStoneSlabDouble;
import soupbubbles.minecraftboom.block.slab.BlockVanillaStoneSlabDouble2;
import soupbubbles.minecraftboom.block.slab.BlockVanillaStoneSlabHalf;
import soupbubbles.minecraftboom.block.slab.BlockVanillaStoneSlabHalf2;
import soupbubbles.minecraftboom.item.base.ItemBlockMeta;
import soupbubbles.minecraftboom.item.base.ItemSlabBase;
import soupbubbles.minecraftboom.reference.Assets;
import soupbubbles.minecraftboom.reference.Names;

public class ModBlocks
{
    public static final Set<Block> BLOCKS = new HashSet<>();
    
    public static final Block[] BLOCK_STAIRS_TERRACOTTA_LIST = {ModBlocks.BLOCK_STAIRS_WHITE_TERRACOTTA, ModBlocks.BLOCK_STAIRS_ORANGE_TERRACOTTA, ModBlocks.BLOCK_STAIRS_MAGENTA_TERRACOTTA, ModBlocks.BLOCK_STAIRS_LIGHT_BLUE_TERRACOTTA, ModBlocks.BLOCK_STAIRS_YELLOW_TERRACOTTA, ModBlocks.BLOCK_STAIRS_LIME_TERRACOTTA, ModBlocks.BLOCK_STAIRS_PINK_TERRACOTTA, ModBlocks.BLOCK_STAIRS_GRAY_TERRACOTTA, ModBlocks.BLOCK_STAIRS_LIGHT_GRAY_TERRACOTTA, ModBlocks.BLOCK_STAIRS_CYAN_TERRACOTTA, ModBlocks.BLOCK_STAIRS_PURPLE_TERRACOTTA, ModBlocks.BLOCK_STAIRS_BLUE_TERRACOTTA, ModBlocks.BLOCK_STAIRS_BROWN_TERRACOTTA, ModBlocks.BLOCK_STAIRS_GREEN_TERRACOTTA, ModBlocks.BLOCK_STAIRS_RED_TERRACOTTA, ModBlocks.BLOCK_STAIRS_BLACK_TERRACOTTA};
    public static final Block[] BLOCK_STAIRS_CONCRETE_LIST = {ModBlocks.BLOCK_STAIRS_WHITE_CONCRETE, ModBlocks.BLOCK_STAIRS_ORANGE_CONCRETE, ModBlocks.BLOCK_STAIRS_MAGENTA_CONCRETE, ModBlocks.BLOCK_STAIRS_LIGHT_BLUE_CONCRETE, ModBlocks.BLOCK_STAIRS_YELLOW_CONCRETE, ModBlocks.BLOCK_STAIRS_LIME_CONCRETE, ModBlocks.BLOCK_STAIRS_PINK_CONCRETE, ModBlocks.BLOCK_STAIRS_GRAY_CONCRETE, ModBlocks.BLOCK_STAIRS_LIGHT_GRAY_CONCRETE, ModBlocks.BLOCK_STAIRS_CYAN_CONCRETE, ModBlocks.BLOCK_STAIRS_PURPLE_CONCRETE, ModBlocks.BLOCK_STAIRS_BLUE_CONCRETE, ModBlocks.BLOCK_STAIRS_BROWN_CONCRETE, ModBlocks.BLOCK_STAIRS_GREEN_CONCRETE, ModBlocks.BLOCK_STAIRS_RED_CONCRETE, ModBlocks.BLOCK_STAIRS_BLACK_CONCRETE};
    public static final Block[] BLOCK_STAIRS_TERRACOTTA_BRICKS_LIST = {ModBlocks.BLOCK_STAIRS_WHITE_TERRACOTTA_BRICKS, ModBlocks.BLOCK_STAIRS_ORANGE_TERRACOTTA_BRICKS, ModBlocks.BLOCK_STAIRS_MAGENTA_TERRACOTTA_BRICKS, ModBlocks.BLOCK_STAIRS_LIGHT_BLUE_TERRACOTTA_BRICKS, ModBlocks.BLOCK_STAIRS_YELLOW_TERRACOTTA_BRICKS, ModBlocks.BLOCK_STAIRS_LIME_TERRACOTTA_BRICKS, ModBlocks.BLOCK_STAIRS_PINK_TERRACOTTA_BRICKS, ModBlocks.BLOCK_STAIRS_GRAY_TERRACOTTA_BRICKS, ModBlocks.BLOCK_STAIRS_LIGHT_GRAY_TERRACOTTA_BRICKS, ModBlocks.BLOCK_STAIRS_CYAN_TERRACOTTA_BRICKS, ModBlocks.BLOCK_STAIRS_PURPLE_TERRACOTTA_BRICKS, ModBlocks.BLOCK_STAIRS_BLUE_TERRACOTTA_BRICKS, ModBlocks.BLOCK_STAIRS_BROWN_TERRACOTTA_BRICKS, ModBlocks.BLOCK_STAIRS_GREEN_TERRACOTTA_BRICKS, ModBlocks.BLOCK_STAIRS_RED_TERRACOTTA_BRICKS, ModBlocks.BLOCK_STAIRS_BLACK_TERRACOTTA_BRICKS};

    //Mod Blocks
    public static final Block BLOCK_COBBLESTONE_BRICKS;
    public static final Block BLOCK_MOSSY_COBBLESTONE_BRICKS;
    public static final Block BLOCK_TERRACOTTA_BRICKS;
    public static final Block BLOCK_STAINED_TERRACOTTA_BRICKS;
    public static final Block BLOCK_MAGMA_BRICKS;
    public static final Block BLOCK_POLISHED;
    public static final Block BLOCK_FACELESS_PUMPKIN;

    //Storage Blocks
    public static final Block BLOCK_CHARCOAL;
    public static final Block BLOCK_SUGAR;
    public static final Block BLOCK_SUGAR_CANE;
    public static final Block BLOCK_GUNPOWDER;
    public static final Block BLOCK_BLAZE_POWDER;
    public static final Block BLOCK_MAGMA_CREAM;
    public static final Block BLOCK_PRISMARINE_CRYSTAL;
    public static final Block BLOCK_CHARRED_BONE;
    public static final Block BLOCK_DYE;

    //Glass
    public static final Block BLOCK_SOUL_GLASS;

    //Pillars
    public static final Block BLOCK_PILLAR_GRANITE;
    public static final Block BLOCK_PILLAR_DIORITE;
    public static final Block BLOCK_PILLAR_ANDESITE;
    public static final Block BLOCK_PILLAR_PRISMARINE;
    public static final Block BLOCK_PILLAR_DARK_PRISMARINE;
    public static final Block BLOCK_PILLAR_END_STONE;
    public static final Block BLOCK_PILLAR_NETHERRACK;

    //Stairs
    public static final BlockStairBase BLOCK_STAIRS_STONE;
    public static final BlockStairBase BLOCK_STAIRS_SMOOTH_GRANITE;
    public static final BlockStairBase BLOCK_STAIRS_SMOOTH_DIORITE;
    public static final BlockStairBase BLOCK_STAIRS_SMOOTH_ANDESITE;
    public static final BlockStairBase BLOCK_STAIRS_MOSSY_COBBLESTONE;
    public static final BlockStairBase BLOCK_STAIRS_MOSSY_STONEBRICK;
    public static final BlockStairBase BLOCK_STAIRS_CRACKED_STONEBRICK;
    public static final BlockStairBase BLOCK_STAIRS_CHISLED_STONEBRICK;
    public static final BlockStairBase BLOCK_STAIRS_TERRACOTTA;
    public static final BlockStairBase BLOCK_STAIRS_CHISELED_SANDSTONE;
    public static final BlockStairBase BLOCK_STAIRS_SMOOTH_SANDSTONE;
    public static final BlockStairBase BLOCK_STAIRS_CHISELED_RED_SANDSTONE;
    public static final BlockStairBase BLOCK_STAIRS_SMOOTH_RED_SANDSTONE;
    public static final BlockStairBase BLOCK_STAIRS_PRISMARINE_BRICKS;
    public static final BlockStairBase BLOCK_STAIRS_DARK_PRISMARINE;
    public static final BlockStairBase BLOCK_STAIRS_END_BRICKS;
    public static final BlockStairBase BLOCK_STAIRS_RED_NETHER_BRICK;
    public static final BlockStairBase BLOCK_STAIRS_WHITE_TERRACOTTA;
    public static final BlockStairBase BLOCK_STAIRS_ORANGE_TERRACOTTA;
    public static final BlockStairBase BLOCK_STAIRS_MAGENTA_TERRACOTTA;
    public static final BlockStairBase BLOCK_STAIRS_LIGHT_BLUE_TERRACOTTA;
    public static final BlockStairBase BLOCK_STAIRS_YELLOW_TERRACOTTA;
    public static final BlockStairBase BLOCK_STAIRS_LIME_TERRACOTTA;
    public static final BlockStairBase BLOCK_STAIRS_PINK_TERRACOTTA;
    public static final BlockStairBase BLOCK_STAIRS_GRAY_TERRACOTTA;
    public static final BlockStairBase BLOCK_STAIRS_LIGHT_GRAY_TERRACOTTA;
    public static final BlockStairBase BLOCK_STAIRS_CYAN_TERRACOTTA;
    public static final BlockStairBase BLOCK_STAIRS_PURPLE_TERRACOTTA;
    public static final BlockStairBase BLOCK_STAIRS_BLUE_TERRACOTTA;
    public static final BlockStairBase BLOCK_STAIRS_BROWN_TERRACOTTA;
    public static final BlockStairBase BLOCK_STAIRS_GREEN_TERRACOTTA;
    public static final BlockStairBase BLOCK_STAIRS_RED_TERRACOTTA;
    public static final BlockStairBase BLOCK_STAIRS_BLACK_TERRACOTTA;
    public static final BlockStairBase BLOCK_STAIRS_WHITE_CONCRETE;
    public static final BlockStairBase BLOCK_STAIRS_ORANGE_CONCRETE;
    public static final BlockStairBase BLOCK_STAIRS_MAGENTA_CONCRETE;
    public static final BlockStairBase BLOCK_STAIRS_LIGHT_BLUE_CONCRETE;
    public static final BlockStairBase BLOCK_STAIRS_YELLOW_CONCRETE;
    public static final BlockStairBase BLOCK_STAIRS_LIME_CONCRETE;
    public static final BlockStairBase BLOCK_STAIRS_PINK_CONCRETE;
    public static final BlockStairBase BLOCK_STAIRS_GRAY_CONCRETE;
    public static final BlockStairBase BLOCK_STAIRS_LIGHT_GRAY_CONCRETE;
    public static final BlockStairBase BLOCK_STAIRS_CYAN_CONCRETE;
    public static final BlockStairBase BLOCK_STAIRS_PURPLE_CONCRETE;
    public static final BlockStairBase BLOCK_STAIRS_BLUE_CONCRETE;
    public static final BlockStairBase BLOCK_STAIRS_BROWN_CONCRETE;
    public static final BlockStairBase BLOCK_STAIRS_GREEN_CONCRETE;
    public static final BlockStairBase BLOCK_STAIRS_RED_CONCRETE;
    public static final BlockStairBase BLOCK_STAIRS_BLACK_CONCRETE;
    public static final BlockStairBase BLOCK_STAIRS_COBBLESTONE_BRICKS;
    public static final BlockStairBase BLOCK_STAIRS_MOSSY_COBBLESTONE_BRICKS;
    public static final BlockStairBase BLOCK_STAIRS_TERRACOTTA_BRICKS;
    public static final BlockStairBase BLOCK_STAIRS_MAGMA_BRICKS;
    public static final BlockStairBase BLOCK_STAIRS_SMOOTH_PRISMARINE;
    public static final BlockStairBase BLOCK_STAIRS_SMOOTH_DARK_PRISMARINE;
    public static final BlockStairBase BLOCK_STAIRS_SMOOTH_END_STONE;
    public static final BlockStairBase BLOCK_STAIRS_SMOOTH_NETHERRACK;
    public static final BlockStairBase BLOCK_STAIRS_WHITE_TERRACOTTA_BRICKS;
    public static final BlockStairBase BLOCK_STAIRS_ORANGE_TERRACOTTA_BRICKS;
    public static final BlockStairBase BLOCK_STAIRS_MAGENTA_TERRACOTTA_BRICKS;
    public static final BlockStairBase BLOCK_STAIRS_LIGHT_BLUE_TERRACOTTA_BRICKS;
    public static final BlockStairBase BLOCK_STAIRS_YELLOW_TERRACOTTA_BRICKS;
    public static final BlockStairBase BLOCK_STAIRS_LIME_TERRACOTTA_BRICKS;
    public static final BlockStairBase BLOCK_STAIRS_PINK_TERRACOTTA_BRICKS;
    public static final BlockStairBase BLOCK_STAIRS_GRAY_TERRACOTTA_BRICKS;
    public static final BlockStairBase BLOCK_STAIRS_LIGHT_GRAY_TERRACOTTA_BRICKS;
    public static final BlockStairBase BLOCK_STAIRS_CYAN_TERRACOTTA_BRICKS;
    public static final BlockStairBase BLOCK_STAIRS_PURPLE_TERRACOTTA_BRICKS;
    public static final BlockStairBase BLOCK_STAIRS_BLUE_TERRACOTTA_BRICKS;
    public static final BlockStairBase BLOCK_STAIRS_BROWN_TERRACOTTA_BRICKS;
    public static final BlockStairBase BLOCK_STAIRS_GREEN_TERRACOTTA_BRICKS;
    public static final BlockStairBase BLOCK_STAIRS_RED_TERRACOTTA_BRICKS;
    public static final BlockStairBase BLOCK_STAIRS_BLACK_TERRACOTTA_BRICKS;

    //Slabs
    public static final BlockVanillaStoneSlabHalf BLOCK_HALF_SLAB_VANILLA_STONE;
    public static final BlockVanillaStoneSlabDouble BLOCK_DOUBLE_SLAB_VANILLA_STONE;
    public static final BlockVanillaStoneSlabHalf2 BLOCK_HALF_SLAB_VANILLA_STONE_2;
    public static final BlockVanillaStoneSlabDouble2 BLOCK_DOUBLE_SLAB_VANILLA_STONE_2;
    public static final BlockTerracottaSlabHalf BLOCK_HALF_SLAB_TERRACOTTA;
    public static final BlockTerracottaSlabDouble BLOCK_DOUBLE_SLAB_TERRACOTTA;
    public static final BlockTerracottaSlabHalf2 BLOCK_HALF_SLAB_TERRACOTTA_2;
    public static final BlockTerracottaSlabDouble2 BLOCK_DOUBLE_SLAB_TERRACOTTA_2;
    public static final BlockConcreteSlabHalf BLOCK_HALF_SLAB_CONCRETE;
    public static final BlockConcreteSlabDouble BLOCK_DOUBLE_SLAB_CONCRETE;
    public static final BlockConcreteSlabHalf2 BLOCK_HALF_SLAB_CONCRETE_2;
    public static final BlockConcreteSlabDouble2 BLOCK_DOUBLE_SLAB_CONCRETE_2;
    public static final BlockModSlabHalf BLOCK_HALF_SLAB_MOD;
    public static final BlockModSlabDouble BLOCK_DOUBLE_SLAB_MOD;
    public static final BlockTerracottaBricksSlabHalf BLOCK_HALF_SLAB_TERRACOTTA_BRICKS;
    public static final BlockTerracottaBricksSlabDouble BLOCK_DOUBLE_SLAB_TERRACOTTA_BRICKS;
    public static final BlockTerracottaBricksSlabHalf2 BLOCK_HALF_SLAB_TERRACOTTA_BRICKS_2;
    public static final BlockTerracottaBricksSlabDouble2 BLOCK_DOUBLE_SLAB_TERRACOTTA_BRICKS_2;

    //Wood Variations
    public static final Block BLOCK_BOOKSHELF;

    public static final Block BLOCK_SPRUCE_LADDER;
    public static final Block BLOCK_BIRCH_LADDER;
    public static final Block BLOCK_JUNGLE_LADDER;
    public static final Block BLOCK_ACACIA_LADDER;
    public static final Block BLOCK_DARK_OAK_LADDER;

    public static final Block BLOCK_SPRUCE_TRAP_DOOR;
    public static final Block BLOCK_BIRCH_TRAP_DOOR;
    public static final Block BLOCK_JUNGLE_TRAP_DOOR;
    public static final Block BLOCK_ACACIA_TRAP_DOOR;
    public static final Block BLOCK_DARK_OAK_TRAP_DOOR;

    public static final Block BLOCK_SPRUCE_BUTTON;
    public static final Block BLOCK_BIRCH_BUTTON;
    public static final Block BLOCK_JUNGLE_BUTTON;
    public static final Block BLOCK_ACACIA_BUTTON;
    public static final Block BLOCK_DARK_OAK_BUTTON;

    public static final Block BLOCK_SPRUCE_PRESSURE_PLATE;
    public static final Block BLOCK_BIRCH_PRESSURE_PLATE;
    public static final Block BLOCK_JUNGLE_PRESSURE_PLATE;
    public static final Block BLOCK_ACACIA_PRESSURE_PLATE;
    public static final Block BLOCK_DARK_OAK_PRESSURE_PLATE;

    //Decoration
    public static final Block BLOCK_GOLDEN_BARS;
    public static final Block BLOCK_SOUL_GLASS_PANE;
    public static final Block BLOCK_ROSE;

    //public static final Block BLOCK_WOOL;

    static
    {
        BLOCK_BOOKSHELF = new BlockBookShelf();
        registerBlockMeta(BLOCK_BOOKSHELF, new ItemBlockMeta(BLOCK_BOOKSHELF, Names.BLOCK_BOOKSHELF));

        BLOCK_COBBLESTONE_BRICKS = registerBlock(new BlockBase(Names.BLOCK_COBBELSTONE_BRICKS));
        BLOCK_MOSSY_COBBLESTONE_BRICKS = registerBlock(new BlockBase(Names.BLOCK_MOSSY_COBBELSTONE_BRICKS));
        BLOCK_TERRACOTTA_BRICKS = registerBlock(new BlockBase(Names.BLOCK_TERRACOTTA_BRICKS));
        BLOCK_STAINED_TERRACOTTA_BRICKS = new BlockColoredBase(Names.BLOCK_STAINED_TERRACOTTA_BRICKS);
        registerBlockMeta(BLOCK_STAINED_TERRACOTTA_BRICKS, new ItemBlockMeta(BLOCK_STAINED_TERRACOTTA_BRICKS, Names.BLOCK_STAINED_TERRACOTTA_BRICKS));
        BLOCK_MAGMA_BRICKS = registerBlock(new BlockBase(Names.BLOCK_MAGMA_BRICKS));
        BLOCK_POLISHED = new BlockPolished();
        registerBlockMeta(BLOCK_POLISHED);
        BLOCK_FACELESS_PUMPKIN = registerBlock(new BlockFacelessPumpkin());

        BLOCK_CHARCOAL = registerBlock(new BlockBase(Material.ROCK, Names.BLOCK_CHARCOAL, SoundType.STONE).setHardness(0.1F));
        BLOCK_SUGAR = registerBlock(new BlockFallingBase(Names.BLOCK_SUGAR).setHardness(0.1F));
        BLOCK_SUGAR_CANE = registerBlock(new BlockPillarBase(Material.LEAVES, Names.BLOCK_SUGAR_CANE, SoundType.PLANT).setHardness(0.1F));
        BLOCK_GUNPOWDER = registerBlock(new BlockGunpowder().setHardness(0.1F));
        BLOCK_BLAZE_POWDER = registerBlock(new BlockFallingBase(Names.BLOCK_BLAZE_POWDER, SoundType.SNOW).setHardness(0.1F));
        BLOCK_MAGMA_CREAM = registerBlock(new BlockMagmaCream().setHardness(0.1F));
        BLOCK_PRISMARINE_CRYSTAL = registerBlock(new BlockBase(Material.GROUND, Names.BLOCK_PRISMARINE_CRYSTAL, SoundType.GLASS).setHardness(0.1F).setLightLevel(0.2F));
        BLOCK_CHARRED_BONE = registerBlock(new BlockPillarBase(Names.BLOCK_CHARRED_BONE)).setHardness(2.0F);
        BLOCK_DYE = new BlockDye().setHardness(0.1F);
        registerBlockMeta(BLOCK_DYE, new ItemBlockMeta(BLOCK_DYE, Names.BLOCK_DYE));

        BLOCK_SOUL_GLASS = registerBlock(new BlockSoulGlass());

        BLOCK_PILLAR_GRANITE = registerBlock(new BlockPillarBase(Names.BLOCK_PILLAR_GRANITE));
        BLOCK_PILLAR_DIORITE = registerBlock(new BlockPillarBase(Names.BLOCK_PILLAR_DIORITE));
        BLOCK_PILLAR_ANDESITE = registerBlock(new BlockPillarBase(Names.BLOCK_PILLAR_ANDESITE));
        BLOCK_PILLAR_PRISMARINE = registerBlock(new BlockPillarBase(Names.BLOCK_PILLAR_PRISMARINE));
        BLOCK_PILLAR_DARK_PRISMARINE = registerBlock(new BlockPillarBase(Names.BLOCK_PILLAR_DARK_PRISMARINE));
        BLOCK_PILLAR_END_STONE = registerBlock(new BlockPillarBase(Names.BLOCK_PILLAR_END_STONE));
        BLOCK_PILLAR_NETHERRACK = registerBlock(new BlockPillarBase(Names.BLOCK_PILLAR_NETHERRACK));

        BLOCK_STAIRS_STONE = registerBlock(new BlockStairBase(Blocks.STONE.getDefaultState().withProperty(BlockStone.VARIANT, BlockStone.EnumType.STONE), Names.STONE));
        BLOCK_STAIRS_SMOOTH_GRANITE = registerBlock(new BlockStairBase(Blocks.STONE.getDefaultState().withProperty(BlockStone.VARIANT, BlockStone.EnumType.GRANITE_SMOOTH), Names.SMOOTH_GRANITE));
        BLOCK_STAIRS_SMOOTH_DIORITE = registerBlock(new BlockStairBase(Blocks.STONE.getDefaultState().withProperty(BlockStone.VARIANT, BlockStone.EnumType.DIORITE_SMOOTH), Names.SMOOTH_DIORITE));
        BLOCK_STAIRS_SMOOTH_ANDESITE = registerBlock(new BlockStairBase(Blocks.STONE.getDefaultState().withProperty(BlockStone.VARIANT, BlockStone.EnumType.ANDESITE_SMOOTH), Names.SMOOTH_ANDESITE));
        BLOCK_STAIRS_MOSSY_COBBLESTONE = registerBlock(new BlockStairBase(Blocks.MOSSY_COBBLESTONE.getDefaultState(), Names.MOSSY_COBBLESTONE));
        BLOCK_STAIRS_MOSSY_STONEBRICK = registerBlock(new BlockStairBase(Blocks.STONEBRICK.getDefaultState().withProperty(BlockStoneBrick.VARIANT, BlockStoneBrick.EnumType.MOSSY), Names.MOSSY_STONEBRICK));
        BLOCK_STAIRS_CRACKED_STONEBRICK = registerBlock(new BlockStairBase(Blocks.STONEBRICK.getDefaultState().withProperty(BlockStoneBrick.VARIANT, BlockStoneBrick.EnumType.CRACKED), Names.CRACKED_STONEBRICK));
        BLOCK_STAIRS_CHISLED_STONEBRICK = registerBlock(new BlockStairBase(Blocks.STONEBRICK.getDefaultState().withProperty(BlockStoneBrick.VARIANT, BlockStoneBrick.EnumType.CHISELED), Names.CHISELED_STONEBRICK));
        BLOCK_STAIRS_TERRACOTTA = registerBlock(new BlockStairBase(Blocks.HARDENED_CLAY.getDefaultState(), Names.TERRACOTTA));
        BLOCK_STAIRS_CHISELED_SANDSTONE = registerBlock(new BlockStairBase(Blocks.SANDSTONE.getDefaultState().withProperty(BlockSandStone.TYPE, BlockSandStone.EnumType.CHISELED), Names.CHISELED_SANDSTONE));
        BLOCK_STAIRS_SMOOTH_SANDSTONE = registerBlock(new BlockStairBase(Blocks.SANDSTONE.getDefaultState().withProperty(BlockSandStone.TYPE, BlockSandStone.EnumType.SMOOTH), Names.SMOOTH_SANDSTONE));
        BLOCK_STAIRS_CHISELED_RED_SANDSTONE = registerBlock(new BlockStairBase(Blocks.RED_SANDSTONE.getDefaultState().withProperty(BlockRedSandstone.TYPE, BlockRedSandstone.EnumType.CHISELED), Names.CHISELED_RED_SANDSTONE));
        BLOCK_STAIRS_SMOOTH_RED_SANDSTONE = registerBlock(new BlockStairBase(Blocks.RED_SANDSTONE.getDefaultState().withProperty(BlockRedSandstone.TYPE, BlockRedSandstone.EnumType.SMOOTH), Names.SMOOTH_RED_SANDSTONE));
        BLOCK_STAIRS_PRISMARINE_BRICKS = registerBlock(new BlockStairBase(Blocks.PRISMARINE.getDefaultState().withProperty(BlockPrismarine.VARIANT, BlockPrismarine.EnumType.BRICKS), Names.PRISMARINE_BRICKS));
        BLOCK_STAIRS_DARK_PRISMARINE = registerBlock(new BlockStairBase(Blocks.PRISMARINE.getDefaultState().withProperty(BlockPrismarine.VARIANT, BlockPrismarine.EnumType.DARK), Names.DARK_PRISMARINE));
        BLOCK_STAIRS_END_BRICKS = registerBlock(new BlockStairBase(Blocks.END_BRICKS.getDefaultState(), Names.END_BRICKS));
        BLOCK_STAIRS_RED_NETHER_BRICK = registerBlock(new BlockStairBase(Blocks.RED_NETHER_BRICK.getDefaultState(), Names.RED_NETHER_BRICK));
        BLOCK_STAIRS_WHITE_TERRACOTTA = registerBlock(new BlockStairBase(Blocks.STAINED_HARDENED_CLAY.getDefaultState().withProperty(BlockStainedHardenedClay.COLOR, EnumDyeColor.WHITE), Names.WHITE + "_" + Names.TERRACOTTA));
        BLOCK_STAIRS_ORANGE_TERRACOTTA = registerBlock(new BlockStairBase(Blocks.STAINED_HARDENED_CLAY.getDefaultState().withProperty(BlockStainedHardenedClay.COLOR, EnumDyeColor.ORANGE), Names.ORANGE + "_" + Names.TERRACOTTA));
        BLOCK_STAIRS_MAGENTA_TERRACOTTA = registerBlock(new BlockStairBase(Blocks.STAINED_HARDENED_CLAY.getDefaultState().withProperty(BlockStainedHardenedClay.COLOR, EnumDyeColor.MAGENTA), Names.MAGENTA + "_" + Names.TERRACOTTA));
        BLOCK_STAIRS_LIGHT_BLUE_TERRACOTTA = registerBlock(new BlockStairBase(Blocks.STAINED_HARDENED_CLAY.getDefaultState().withProperty(BlockStainedHardenedClay.COLOR, EnumDyeColor.LIGHT_BLUE), Names.LIGHT_BLUE + "_" + Names.TERRACOTTA));
        BLOCK_STAIRS_YELLOW_TERRACOTTA = registerBlock(new BlockStairBase(Blocks.STAINED_HARDENED_CLAY.getDefaultState().withProperty(BlockStainedHardenedClay.COLOR, EnumDyeColor.YELLOW), Names.YELLOW + "_" + Names.TERRACOTTA));
        BLOCK_STAIRS_LIME_TERRACOTTA = registerBlock(new BlockStairBase(Blocks.STAINED_HARDENED_CLAY.getDefaultState().withProperty(BlockStainedHardenedClay.COLOR, EnumDyeColor.LIME), Names.LIME + "_" + Names.TERRACOTTA));
        BLOCK_STAIRS_PINK_TERRACOTTA = registerBlock(new BlockStairBase(Blocks.STAINED_HARDENED_CLAY.getDefaultState().withProperty(BlockStainedHardenedClay.COLOR, EnumDyeColor.PINK), Names.PINK + "_" + Names.TERRACOTTA));
        BLOCK_STAIRS_GRAY_TERRACOTTA = registerBlock(new BlockStairBase(Blocks.STAINED_HARDENED_CLAY.getDefaultState().withProperty(BlockStainedHardenedClay.COLOR, EnumDyeColor.GRAY), Names.GRAY + "_" + Names.TERRACOTTA));
        BLOCK_STAIRS_LIGHT_GRAY_TERRACOTTA = registerBlock(new BlockStairBase(Blocks.STAINED_HARDENED_CLAY.getDefaultState().withProperty(BlockStainedHardenedClay.COLOR, EnumDyeColor.SILVER), Names.SILVER + "_" + Names.TERRACOTTA));
        BLOCK_STAIRS_CYAN_TERRACOTTA = registerBlock(new BlockStairBase(Blocks.STAINED_HARDENED_CLAY.getDefaultState().withProperty(BlockStainedHardenedClay.COLOR, EnumDyeColor.CYAN), Names.CYAN + "_" + Names.TERRACOTTA));
        BLOCK_STAIRS_PURPLE_TERRACOTTA = registerBlock(new BlockStairBase(Blocks.STAINED_HARDENED_CLAY.getDefaultState().withProperty(BlockStainedHardenedClay.COLOR, EnumDyeColor.PURPLE), Names.PURPLE + "_" + Names.TERRACOTTA));
        BLOCK_STAIRS_BLUE_TERRACOTTA = registerBlock(new BlockStairBase(Blocks.STAINED_HARDENED_CLAY.getDefaultState().withProperty(BlockStainedHardenedClay.COLOR, EnumDyeColor.BLUE), Names.BLUE + "_" + Names.TERRACOTTA));
        BLOCK_STAIRS_BROWN_TERRACOTTA = registerBlock(new BlockStairBase(Blocks.STAINED_HARDENED_CLAY.getDefaultState().withProperty(BlockStainedHardenedClay.COLOR, EnumDyeColor.BROWN), Names.BROWN + "_" + Names.TERRACOTTA));
        BLOCK_STAIRS_GREEN_TERRACOTTA = registerBlock(new BlockStairBase(Blocks.STAINED_HARDENED_CLAY.getDefaultState().withProperty(BlockStainedHardenedClay.COLOR, EnumDyeColor.GREEN), Names.GREEN + "_" + Names.TERRACOTTA));
        BLOCK_STAIRS_RED_TERRACOTTA = registerBlock(new BlockStairBase(Blocks.STAINED_HARDENED_CLAY.getDefaultState().withProperty(BlockStainedHardenedClay.COLOR, EnumDyeColor.RED), Names.RED + "_" + Names.TERRACOTTA));
        BLOCK_STAIRS_BLACK_TERRACOTTA = registerBlock(new BlockStairBase(Blocks.STAINED_HARDENED_CLAY.getDefaultState().withProperty(BlockStainedHardenedClay.COLOR, EnumDyeColor.BLACK), Names.BLACK + "_" + Names.TERRACOTTA));
        BLOCK_STAIRS_WHITE_CONCRETE = registerBlock(new BlockStairBase(Blocks.CONCRETE.getDefaultState().withProperty(BlockStainedHardenedClay.COLOR, EnumDyeColor.WHITE), Names.WHITE + "_" + Names.CONCRETE));
        BLOCK_STAIRS_ORANGE_CONCRETE = registerBlock(new BlockStairBase(Blocks.CONCRETE.getDefaultState().withProperty(BlockStainedHardenedClay.COLOR, EnumDyeColor.ORANGE), Names.ORANGE + "_" + Names.CONCRETE));
        BLOCK_STAIRS_MAGENTA_CONCRETE = registerBlock(new BlockStairBase(Blocks.CONCRETE.getDefaultState().withProperty(BlockStainedHardenedClay.COLOR, EnumDyeColor.MAGENTA), Names.MAGENTA + "_" + Names.CONCRETE));
        BLOCK_STAIRS_LIGHT_BLUE_CONCRETE = registerBlock(new BlockStairBase(Blocks.CONCRETE.getDefaultState().withProperty(BlockStainedHardenedClay.COLOR, EnumDyeColor.LIGHT_BLUE), Names.LIGHT_BLUE + "_" + Names.CONCRETE));
        BLOCK_STAIRS_YELLOW_CONCRETE = registerBlock(new BlockStairBase(Blocks.CONCRETE.getDefaultState().withProperty(BlockStainedHardenedClay.COLOR, EnumDyeColor.YELLOW), Names.YELLOW + "_" + Names.CONCRETE));
        BLOCK_STAIRS_LIME_CONCRETE = registerBlock(new BlockStairBase(Blocks.CONCRETE.getDefaultState().withProperty(BlockStainedHardenedClay.COLOR, EnumDyeColor.LIME), Names.LIME + "_" + Names.CONCRETE));
        BLOCK_STAIRS_PINK_CONCRETE = registerBlock(new BlockStairBase(Blocks.CONCRETE.getDefaultState().withProperty(BlockStainedHardenedClay.COLOR, EnumDyeColor.PINK), Names.PINK + "_" + Names.CONCRETE));
        BLOCK_STAIRS_GRAY_CONCRETE = registerBlock(new BlockStairBase(Blocks.CONCRETE.getDefaultState().withProperty(BlockStainedHardenedClay.COLOR, EnumDyeColor.GRAY), Names.GRAY + "_" + Names.CONCRETE));
        BLOCK_STAIRS_LIGHT_GRAY_CONCRETE = registerBlock(new BlockStairBase(Blocks.CONCRETE.getDefaultState().withProperty(BlockStainedHardenedClay.COLOR, EnumDyeColor.SILVER), Names.SILVER + "_" + Names.CONCRETE));
        BLOCK_STAIRS_CYAN_CONCRETE = registerBlock(new BlockStairBase(Blocks.CONCRETE.getDefaultState().withProperty(BlockStainedHardenedClay.COLOR, EnumDyeColor.CYAN), Names.CYAN + "_" + Names.CONCRETE));
        BLOCK_STAIRS_PURPLE_CONCRETE = registerBlock(new BlockStairBase(Blocks.CONCRETE.getDefaultState().withProperty(BlockStainedHardenedClay.COLOR, EnumDyeColor.PURPLE), Names.PURPLE + "_" + Names.CONCRETE));
        BLOCK_STAIRS_BLUE_CONCRETE = registerBlock(new BlockStairBase(Blocks.CONCRETE.getDefaultState().withProperty(BlockStainedHardenedClay.COLOR, EnumDyeColor.BLUE), Names.BLUE + "_" + Names.CONCRETE));
        BLOCK_STAIRS_BROWN_CONCRETE = registerBlock(new BlockStairBase(Blocks.CONCRETE.getDefaultState().withProperty(BlockStainedHardenedClay.COLOR, EnumDyeColor.BROWN), Names.BROWN + "_" + Names.CONCRETE));
        BLOCK_STAIRS_GREEN_CONCRETE = registerBlock(new BlockStairBase(Blocks.CONCRETE.getDefaultState().withProperty(BlockStainedHardenedClay.COLOR, EnumDyeColor.GREEN), Names.GREEN + "_" + Names.CONCRETE));
        BLOCK_STAIRS_RED_CONCRETE = registerBlock(new BlockStairBase(Blocks.CONCRETE.getDefaultState().withProperty(BlockStainedHardenedClay.COLOR, EnumDyeColor.RED), Names.RED + "_" + Names.CONCRETE));
        BLOCK_STAIRS_BLACK_CONCRETE = registerBlock(new BlockStairBase(Blocks.CONCRETE.getDefaultState().withProperty(BlockStainedHardenedClay.COLOR, EnumDyeColor.BLACK), Names.BLACK + "_" + Names.CONCRETE));
        BLOCK_STAIRS_COBBLESTONE_BRICKS = registerBlock(new BlockStairBase(BLOCK_COBBLESTONE_BRICKS.getDefaultState(), Names.BLOCK_COBBELSTONE_BRICKS));
        BLOCK_STAIRS_MOSSY_COBBLESTONE_BRICKS = registerBlock(new BlockStairBase(BLOCK_MOSSY_COBBLESTONE_BRICKS.getDefaultState(), Names.BLOCK_MOSSY_COBBELSTONE_BRICKS));
        BLOCK_STAIRS_TERRACOTTA_BRICKS = registerBlock(new BlockStairBase(BLOCK_TERRACOTTA_BRICKS.getDefaultState(), Names.BLOCK_TERRACOTTA_BRICKS));
        BLOCK_STAIRS_MAGMA_BRICKS = registerBlock(new BlockStairBase(BLOCK_MAGMA_BRICKS.getDefaultState(), Names.BLOCK_MAGMA_BRICKS));
        BLOCK_STAIRS_SMOOTH_PRISMARINE = registerBlock(new BlockStairBase(BLOCK_POLISHED.getDefaultState().withProperty(BlockPolished.VARIANT, BlockPolished.EnumType.SMOOTH_PRISMARINE), Names.BLOCK_SMOOTH_PRISMARINE));
        BLOCK_STAIRS_SMOOTH_DARK_PRISMARINE = registerBlock(new BlockStairBase(BLOCK_POLISHED.getDefaultState().withProperty(BlockPolished.VARIANT, BlockPolished.EnumType.SMOOTH_DARK_PRISMARINE), Names.BLOCK_SMOOTH_DARK_PRISMARINE));
        BLOCK_STAIRS_SMOOTH_END_STONE = registerBlock(new BlockStairBase(BLOCK_POLISHED.getDefaultState().withProperty(BlockPolished.VARIANT, BlockPolished.EnumType.SMOOTH_END_STONE), Names.BLOCK_SMOOTH_END_STONE));
        BLOCK_STAIRS_SMOOTH_NETHERRACK = registerBlock(new BlockStairBase(BLOCK_POLISHED.getDefaultState().withProperty(BlockPolished.VARIANT, BlockPolished.EnumType.SMOOTH_NETHERRACK), Names.BLOCK_SMOOTH_NETHERRACK));
        BLOCK_STAIRS_WHITE_TERRACOTTA_BRICKS = registerBlock(new BlockStairBase(BLOCK_STAINED_TERRACOTTA_BRICKS.getDefaultState().withProperty(BlockStainedHardenedClay.COLOR, EnumDyeColor.WHITE), Names.WHITE + "_" + Names.BLOCK_TERRACOTTA_BRICKS));
        BLOCK_STAIRS_ORANGE_TERRACOTTA_BRICKS = registerBlock(new BlockStairBase(BLOCK_STAINED_TERRACOTTA_BRICKS.getDefaultState().withProperty(BlockStainedHardenedClay.COLOR, EnumDyeColor.ORANGE), Names.ORANGE + "_" + Names.BLOCK_TERRACOTTA_BRICKS));
        BLOCK_STAIRS_MAGENTA_TERRACOTTA_BRICKS = registerBlock(new BlockStairBase(BLOCK_STAINED_TERRACOTTA_BRICKS.getDefaultState().withProperty(BlockStainedHardenedClay.COLOR, EnumDyeColor.MAGENTA), Names.MAGENTA + "_" + Names.BLOCK_TERRACOTTA_BRICKS));
        BLOCK_STAIRS_LIGHT_BLUE_TERRACOTTA_BRICKS = registerBlock(new BlockStairBase(BLOCK_STAINED_TERRACOTTA_BRICKS.getDefaultState().withProperty(BlockStainedHardenedClay.COLOR, EnumDyeColor.LIGHT_BLUE), Names.LIGHT_BLUE + "_" + Names.BLOCK_TERRACOTTA_BRICKS));
        BLOCK_STAIRS_YELLOW_TERRACOTTA_BRICKS = registerBlock(new BlockStairBase(BLOCK_STAINED_TERRACOTTA_BRICKS.getDefaultState().withProperty(BlockStainedHardenedClay.COLOR, EnumDyeColor.YELLOW), Names.YELLOW + "_" + Names.BLOCK_TERRACOTTA_BRICKS));
        BLOCK_STAIRS_LIME_TERRACOTTA_BRICKS = registerBlock(new BlockStairBase(BLOCK_STAINED_TERRACOTTA_BRICKS.getDefaultState().withProperty(BlockStainedHardenedClay.COLOR, EnumDyeColor.LIME), Names.LIME + "_" + Names.BLOCK_TERRACOTTA_BRICKS));
        BLOCK_STAIRS_PINK_TERRACOTTA_BRICKS = registerBlock(new BlockStairBase(BLOCK_STAINED_TERRACOTTA_BRICKS.getDefaultState().withProperty(BlockStainedHardenedClay.COLOR, EnumDyeColor.PINK), Names.PINK + "_" + Names.BLOCK_TERRACOTTA_BRICKS));
        BLOCK_STAIRS_GRAY_TERRACOTTA_BRICKS = registerBlock(new BlockStairBase(BLOCK_STAINED_TERRACOTTA_BRICKS.getDefaultState().withProperty(BlockStainedHardenedClay.COLOR, EnumDyeColor.GRAY), Names.GRAY + "_" + Names.BLOCK_TERRACOTTA_BRICKS));
        BLOCK_STAIRS_LIGHT_GRAY_TERRACOTTA_BRICKS = registerBlock(new BlockStairBase(BLOCK_STAINED_TERRACOTTA_BRICKS.getDefaultState().withProperty(BlockStainedHardenedClay.COLOR, EnumDyeColor.SILVER), Names.SILVER + "_" + Names.BLOCK_TERRACOTTA_BRICKS));
        BLOCK_STAIRS_CYAN_TERRACOTTA_BRICKS = registerBlock(new BlockStairBase(BLOCK_STAINED_TERRACOTTA_BRICKS.getDefaultState().withProperty(BlockStainedHardenedClay.COLOR, EnumDyeColor.CYAN), Names.CYAN + "_" + Names.BLOCK_TERRACOTTA_BRICKS));
        BLOCK_STAIRS_PURPLE_TERRACOTTA_BRICKS = registerBlock(new BlockStairBase(BLOCK_STAINED_TERRACOTTA_BRICKS.getDefaultState().withProperty(BlockStainedHardenedClay.COLOR, EnumDyeColor.PURPLE), Names.PURPLE + "_" + Names.BLOCK_TERRACOTTA_BRICKS));
        BLOCK_STAIRS_BLUE_TERRACOTTA_BRICKS = registerBlock(new BlockStairBase(BLOCK_STAINED_TERRACOTTA_BRICKS.getDefaultState().withProperty(BlockStainedHardenedClay.COLOR, EnumDyeColor.BLUE), Names.BLUE + "_" + Names.BLOCK_TERRACOTTA_BRICKS));
        BLOCK_STAIRS_BROWN_TERRACOTTA_BRICKS = registerBlock(new BlockStairBase(BLOCK_STAINED_TERRACOTTA_BRICKS.getDefaultState().withProperty(BlockStainedHardenedClay.COLOR, EnumDyeColor.BROWN), Names.BROWN + "_" + Names.BLOCK_TERRACOTTA_BRICKS));
        BLOCK_STAIRS_GREEN_TERRACOTTA_BRICKS = registerBlock(new BlockStairBase(BLOCK_STAINED_TERRACOTTA_BRICKS.getDefaultState().withProperty(BlockStainedHardenedClay.COLOR, EnumDyeColor.GREEN), Names.GREEN + "_" + Names.BLOCK_TERRACOTTA_BRICKS));
        BLOCK_STAIRS_RED_TERRACOTTA_BRICKS = registerBlock(new BlockStairBase(BLOCK_STAINED_TERRACOTTA_BRICKS.getDefaultState().withProperty(BlockStainedHardenedClay.COLOR, EnumDyeColor.RED), Names.RED + "_" + Names.BLOCK_TERRACOTTA_BRICKS));
        BLOCK_STAIRS_BLACK_TERRACOTTA_BRICKS = registerBlock(new BlockStairBase(BLOCK_STAINED_TERRACOTTA_BRICKS.getDefaultState().withProperty(BlockStainedHardenedClay.COLOR, EnumDyeColor.BLACK), Names.BLACK + "_" + Names.BLOCK_TERRACOTTA_BRICKS));

        BLOCK_HALF_SLAB_VANILLA_STONE = new BlockVanillaStoneSlabHalf();
        BLOCK_DOUBLE_SLAB_VANILLA_STONE = new BlockVanillaStoneSlabDouble();
        BLOCK_HALF_SLAB_VANILLA_STONE_2 = new BlockVanillaStoneSlabHalf2();
        BLOCK_DOUBLE_SLAB_VANILLA_STONE_2 = new BlockVanillaStoneSlabDouble2();
        BLOCK_HALF_SLAB_TERRACOTTA = new BlockTerracottaSlabHalf();
        BLOCK_DOUBLE_SLAB_TERRACOTTA = new BlockTerracottaSlabDouble();
        BLOCK_HALF_SLAB_TERRACOTTA_2 = new BlockTerracottaSlabHalf2();
        BLOCK_DOUBLE_SLAB_TERRACOTTA_2 = new BlockTerracottaSlabDouble2();
        BLOCK_HALF_SLAB_CONCRETE = new BlockConcreteSlabHalf();
        BLOCK_DOUBLE_SLAB_CONCRETE = new BlockConcreteSlabDouble();
        BLOCK_HALF_SLAB_CONCRETE_2 = new BlockConcreteSlabHalf2();
        BLOCK_DOUBLE_SLAB_CONCRETE_2 = new BlockConcreteSlabDouble2();
        BLOCK_HALF_SLAB_MOD = new BlockModSlabHalf();
        BLOCK_DOUBLE_SLAB_MOD = new BlockModSlabDouble();
        BLOCK_HALF_SLAB_TERRACOTTA_BRICKS = new BlockTerracottaBricksSlabHalf();
        BLOCK_DOUBLE_SLAB_TERRACOTTA_BRICKS = new BlockTerracottaBricksSlabDouble();
        BLOCK_HALF_SLAB_TERRACOTTA_BRICKS_2 = new BlockTerracottaBricksSlabHalf2();
        BLOCK_DOUBLE_SLAB_TERRACOTTA_BRICKS_2 = new BlockTerracottaBricksSlabDouble2();

        registerBlockMeta(BLOCK_HALF_SLAB_VANILLA_STONE, new ItemSlabBase(BLOCK_HALF_SLAB_VANILLA_STONE, BLOCK_HALF_SLAB_VANILLA_STONE, BLOCK_DOUBLE_SLAB_VANILLA_STONE));
        registerBlockMeta(BLOCK_DOUBLE_SLAB_VANILLA_STONE, new ItemSlabBase(BLOCK_DOUBLE_SLAB_VANILLA_STONE, BLOCK_HALF_SLAB_VANILLA_STONE, BLOCK_DOUBLE_SLAB_VANILLA_STONE));
        registerBlockMeta(BLOCK_HALF_SLAB_VANILLA_STONE_2, new ItemSlabBase(BLOCK_HALF_SLAB_VANILLA_STONE_2, BLOCK_HALF_SLAB_VANILLA_STONE_2, BLOCK_DOUBLE_SLAB_VANILLA_STONE_2));
        registerBlockMeta(BLOCK_DOUBLE_SLAB_VANILLA_STONE_2, new ItemSlabBase(BLOCK_DOUBLE_SLAB_VANILLA_STONE_2, BLOCK_HALF_SLAB_VANILLA_STONE_2, BLOCK_DOUBLE_SLAB_VANILLA_STONE_2));
        registerBlockMeta(BLOCK_HALF_SLAB_TERRACOTTA, new ItemSlabBase(BLOCK_HALF_SLAB_TERRACOTTA, BLOCK_HALF_SLAB_TERRACOTTA, BLOCK_DOUBLE_SLAB_TERRACOTTA));
        registerBlockMeta(BLOCK_DOUBLE_SLAB_TERRACOTTA, new ItemSlabBase(BLOCK_DOUBLE_SLAB_TERRACOTTA, BLOCK_HALF_SLAB_TERRACOTTA, BLOCK_DOUBLE_SLAB_TERRACOTTA));
        registerBlockMeta(BLOCK_HALF_SLAB_TERRACOTTA_2, new ItemSlabBase(BLOCK_HALF_SLAB_TERRACOTTA_2, BLOCK_HALF_SLAB_TERRACOTTA_2, BLOCK_DOUBLE_SLAB_TERRACOTTA_2));
        registerBlockMeta(BLOCK_DOUBLE_SLAB_TERRACOTTA_2, new ItemSlabBase(BLOCK_DOUBLE_SLAB_TERRACOTTA_2, BLOCK_HALF_SLAB_TERRACOTTA_2, BLOCK_DOUBLE_SLAB_TERRACOTTA_2));
        registerBlockMeta(BLOCK_HALF_SLAB_CONCRETE, new ItemSlabBase(BLOCK_HALF_SLAB_CONCRETE, BLOCK_HALF_SLAB_CONCRETE, BLOCK_DOUBLE_SLAB_CONCRETE));
        registerBlockMeta(BLOCK_DOUBLE_SLAB_CONCRETE, new ItemSlabBase(BLOCK_DOUBLE_SLAB_CONCRETE, BLOCK_HALF_SLAB_CONCRETE, BLOCK_DOUBLE_SLAB_CONCRETE));
        registerBlockMeta(BLOCK_HALF_SLAB_CONCRETE_2, new ItemSlabBase(BLOCK_HALF_SLAB_CONCRETE_2, BLOCK_HALF_SLAB_CONCRETE_2, BLOCK_DOUBLE_SLAB_CONCRETE_2));
        registerBlockMeta(BLOCK_DOUBLE_SLAB_CONCRETE_2, new ItemSlabBase(BLOCK_DOUBLE_SLAB_CONCRETE_2, BLOCK_HALF_SLAB_CONCRETE_2, BLOCK_DOUBLE_SLAB_CONCRETE_2));
        registerBlockMeta(BLOCK_HALF_SLAB_MOD, new ItemSlabBase(BLOCK_HALF_SLAB_MOD, BLOCK_HALF_SLAB_MOD, BLOCK_DOUBLE_SLAB_MOD));
        registerBlockMeta(BLOCK_DOUBLE_SLAB_MOD, new ItemSlabBase(BLOCK_DOUBLE_SLAB_MOD, BLOCK_HALF_SLAB_MOD, BLOCK_DOUBLE_SLAB_MOD));
        registerBlockMeta(BLOCK_HALF_SLAB_TERRACOTTA_BRICKS, new ItemSlabBase(BLOCK_HALF_SLAB_TERRACOTTA_BRICKS, BLOCK_HALF_SLAB_TERRACOTTA_BRICKS, BLOCK_DOUBLE_SLAB_TERRACOTTA_BRICKS));
        registerBlockMeta(BLOCK_DOUBLE_SLAB_TERRACOTTA_BRICKS, new ItemSlabBase(BLOCK_DOUBLE_SLAB_TERRACOTTA_BRICKS, BLOCK_HALF_SLAB_TERRACOTTA_BRICKS, BLOCK_DOUBLE_SLAB_TERRACOTTA_BRICKS));
        registerBlockMeta(BLOCK_HALF_SLAB_TERRACOTTA_BRICKS_2, new ItemSlabBase(BLOCK_HALF_SLAB_TERRACOTTA_BRICKS_2, BLOCK_HALF_SLAB_TERRACOTTA_BRICKS_2, BLOCK_DOUBLE_SLAB_TERRACOTTA_BRICKS_2));
        registerBlockMeta(BLOCK_DOUBLE_SLAB_TERRACOTTA_BRICKS_2, new ItemSlabBase(BLOCK_DOUBLE_SLAB_TERRACOTTA_BRICKS_2, BLOCK_HALF_SLAB_TERRACOTTA_BRICKS_2, BLOCK_DOUBLE_SLAB_TERRACOTTA_BRICKS_2));

        BLOCK_SPRUCE_LADDER = registerBlock(new BlockWoodenLadder(Names.BLOCK_SPRUCE_LADDER));
        BLOCK_BIRCH_LADDER = registerBlock(new BlockWoodenLadder(Names.BLOCK_BIRCH_LADDER));
        BLOCK_JUNGLE_LADDER = registerBlock(new BlockWoodenLadder(Names.BLOCK_JUNGLE_LADDER));
        BLOCK_ACACIA_LADDER = registerBlock(new BlockWoodenLadder(Names.BLOCK_ACACIA_LADDER));
        BLOCK_DARK_OAK_LADDER = registerBlock(new BlockWoodenLadder(Names.BLOCK_DARK_OAK_LADDER));

        BLOCK_SPRUCE_TRAP_DOOR = registerBlock(new BlockWoodenTrapDoor(Names.BLOCK_SPRUCE_TRAP_DOOR));
        BLOCK_BIRCH_TRAP_DOOR = registerBlock(new BlockWoodenTrapDoor(Names.BLOCK_BIRCH_TRAP_DOOR));
        BLOCK_JUNGLE_TRAP_DOOR = registerBlock(new BlockWoodenTrapDoor(Names.BLOCK_JUNGLE_TRAP_DOOR));
        BLOCK_ACACIA_TRAP_DOOR = registerBlock(new BlockWoodenTrapDoor(Names.BLOCK_ACACIA_TRAP_DOOR));
        BLOCK_DARK_OAK_TRAP_DOOR = registerBlock(new BlockWoodenTrapDoor(Names.BLOCK_DARK_OAK_TRAP_DOOR));

        BLOCK_SPRUCE_BUTTON = registerBlock(new BlockWoodenButton(Names.BLOCK_SPRUCE_BUTTON));
        BLOCK_BIRCH_BUTTON = registerBlock(new BlockWoodenButton(Names.BLOCK_BIRCH_BUTTON));
        BLOCK_JUNGLE_BUTTON = registerBlock(new BlockWoodenButton(Names.BLOCK_JUNGLE_BUTTON));
        BLOCK_ACACIA_BUTTON = registerBlock(new BlockWoodenButton(Names.BLOCK_ACACIA_BUTTON));
        BLOCK_DARK_OAK_BUTTON = registerBlock(new BlockWoodenButton(Names.BLOCK_DARK_OAK_BUTTON));

        BLOCK_SPRUCE_PRESSURE_PLATE = registerBlock(new BlockWoodenPressurePlate(Names.BLOCK_SPRUCE_PRESSURE_PLATE));
        BLOCK_BIRCH_PRESSURE_PLATE = registerBlock(new BlockWoodenPressurePlate(Names.BLOCK_BIRCH_PRESSURE_PLATE));
        BLOCK_JUNGLE_PRESSURE_PLATE = registerBlock(new BlockWoodenPressurePlate(Names.BLOCK_JUNGLE_PRESSURE_PLATE));
        BLOCK_ACACIA_PRESSURE_PLATE = registerBlock(new BlockWoodenPressurePlate(Names.BLOCK_ACACIA_PRESSURE_PLATE));
        BLOCK_DARK_OAK_PRESSURE_PLATE = registerBlock(new BlockWoodenPressurePlate(Names.BLOCK_DARK_OAK_PRESSURE_PLATE));

        BLOCK_GOLDEN_BARS = registerBlock(new BlockPaneBase(Material.IRON, Names.BLOCK_GOLDEN_BARS, SoundType.METAL, true));
        BLOCK_SOUL_GLASS_PANE = registerBlock(new BlockSoulGlassPane());
        BLOCK_ROSE = registerBlock(new BlockRose());

        //if (ConfigurationHandler.Settings.replaceWool)
        {
            //BLOCK_WOOL = replaceBlock(new BlockWool(), Names.WOOL);
        }
        //else
        {
            //BLOCK_WOOL = (BlockColored) Blocks.WOOL;
        }
    }

    public static void registerBlocks()
    {
    }

    public static void registerTileEntities()
    {
    }

    public static void registerTileEntityRenderers()
    {
    }

    protected static <BLOCK extends Block> BLOCK registerBlock(BLOCK block)
    {
        return registerBlock(block, ItemBlock::new);
    }

    protected static <BLOCK extends Block> BLOCK registerBlock(BLOCK block, @Nullable Function<BLOCK, ItemBlock> itemFactory)
    {
        ForgeRegistries.BLOCKS.register(block);

        if (itemFactory != null)
        {
            final ItemBlock itemBlock = itemFactory.apply(block);

            ForgeRegistries.ITEMS.register(itemBlock.setRegistryName(block.getRegistryName()));
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
        ForgeRegistries.BLOCKS.register(block);
        ForgeRegistries.ITEMS.register(itemBlock);

        BLOCKS.add(block);
        return block;
    }

    protected static <BLOCK extends Block> BLOCK replaceBlock(BLOCK block, String name)
    {
        /*
         * if (block.getRegistryName() == null) { block.setRegistryName(name); }
         * try { GameRegistry.addSubstitutionAlias("minecraft:" + name,
         * GameRegistry.Type.BLOCK, block);
         * 
         * if (block == BLOCK_PUMPKIN) {
         * GameRegistry.addSubstitutionAlias("minecraft:" + name,
         * GameRegistry.Type.ITEM, new ItemBlockMeta(block,
         * Names.BLOCK_PUMPKIN)); BLOCKS.add(block); } } catch
         * (ExistingSubstitutionException e) { e.printStackTrace(); throw new
         * RuntimeException(e); }
         * 
         */
        return block;
    }
}
