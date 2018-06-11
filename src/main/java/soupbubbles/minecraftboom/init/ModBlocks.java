package soupbubbles.minecraftboom.init;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Nullable;

import com.google.common.base.Function;

import net.minecraft.block.Block;
import net.minecraft.block.BlockColored;
import net.minecraft.block.BlockPrismarine;
import net.minecraft.block.BlockRedSandstone;
import net.minecraft.block.BlockSandStone;
import net.minecraft.block.BlockStone;
import net.minecraft.block.BlockStoneBrick;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import soupbubbles.minecraftboom.block.BlockBookShelf;
import soupbubbles.minecraftboom.block.BlockDye;
import soupbubbles.minecraftboom.block.BlockFacelessPumpkin;
import soupbubbles.minecraftboom.block.BlockGravelStone;
import soupbubbles.minecraftboom.block.BlockGunpowder;
import soupbubbles.minecraftboom.block.BlockMagmaBricks;
import soupbubbles.minecraftboom.block.BlockMagmaCream;
import soupbubbles.minecraftboom.block.BlockNetherBrickFenceGate;
import soupbubbles.minecraftboom.block.BlockPolished;
import soupbubbles.minecraftboom.block.BlockPrismarineCrystal;
import soupbubbles.minecraftboom.block.BlockRedNetherBrickFence;
import soupbubbles.minecraftboom.block.BlockRose;
import soupbubbles.minecraftboom.block.BlockSoulGlass;
import soupbubbles.minecraftboom.block.BlockSoulGlassPane;
import soupbubbles.minecraftboom.block.BlockStainedSoulGlass;
import soupbubbles.minecraftboom.block.BlockStainedSoulGlassPane;
import soupbubbles.minecraftboom.block.BlockWoodenButton;
import soupbubbles.minecraftboom.block.BlockWoodenLadder;
import soupbubbles.minecraftboom.block.BlockWoodenPressurePlate;
import soupbubbles.minecraftboom.block.BlockWoodenTrapDoor;
import soupbubbles.minecraftboom.block.base.BlockBase;
import soupbubbles.minecraftboom.block.base.BlockColoredBase;
import soupbubbles.minecraftboom.block.base.BlockFallingBase;
import soupbubbles.minecraftboom.block.base.BlockPaneBase;
import soupbubbles.minecraftboom.block.base.BlockPillarBase;
import soupbubbles.minecraftboom.block.base.BlockSlabBase;
import soupbubbles.minecraftboom.block.base.BlockStairBase;
import soupbubbles.minecraftboom.block.slab.BlockConcreteSlab;
import soupbubbles.minecraftboom.block.slab.BlockConcreteSlab2;
import soupbubbles.minecraftboom.block.slab.BlockGravelStoneSlab;
import soupbubbles.minecraftboom.block.slab.BlockModSlab;
import soupbubbles.minecraftboom.block.slab.BlockObsidianSlab;
import soupbubbles.minecraftboom.block.slab.BlockTerracottaBricksSlab;
import soupbubbles.minecraftboom.block.slab.BlockTerracottaBricksSlab2;
import soupbubbles.minecraftboom.block.slab.BlockTerracottaSlab;
import soupbubbles.minecraftboom.block.slab.BlockTerracottaSlab2;
import soupbubbles.minecraftboom.block.slab.BlockVanillaStoneSlab;
import soupbubbles.minecraftboom.block.slab.BlockVanillaStoneSlab2;
import soupbubbles.minecraftboom.creativetab.CreativeTab;
import soupbubbles.minecraftboom.handler.ConfigurationHandler;
import soupbubbles.minecraftboom.item.base.ItemBlockMeta;
import soupbubbles.minecraftboom.item.base.ItemSlabBase;
import soupbubbles.minecraftboom.reference.BlockValues;
import soupbubbles.minecraftboom.reference.Names;
import soupbubbles.minecraftboom.util.IBlockMeta;
import soupbubbles.minecraftboom.util.Utils;

public class ModBlocks
{
    public static final Set<Block> BLOCKS = new HashSet<>();
    public static final List<Block> STAIR_LIST = new ArrayList<Block>();

    //Mod Blocks
    public static final Block BLOCK_COBBLESTONE_BRICKS;
    public static final Block BLOCK_MOSSY_COBBLESTONE_BRICKS;
    public static final Block BLOCK_TERRACOTTA_BRICKS;
    public static final Block BLOCK_STAINED_TERRACOTTA_BRICKS;
    public static final Block BLOCK_MAGMA_BRICKS;
    public static final Block BLOCK_OBSIDIAN_BRICKS;
    public static final Block BLOCK_POLISHED;
    public static final Block BLOCK_FACELESS_PUMPKIN;
    public static final Block BLOCK_FINE_GRAVEL;
    public static final Block BLOCK_GRAVEL_STONE;

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
    public static final Block BLOCK_STAINED_SOUL_GLASS;

    //Pillars
    public static final Block BLOCK_PILLAR_GRANITE;
    public static final Block BLOCK_PILLAR_DIORITE;
    public static final Block BLOCK_PILLAR_ANDESITE;
    public static final Block BLOCK_PILLAR_PRISMARINE;
    public static final Block BLOCK_PILLAR_DARK_PRISMARINE;
    public static final Block BLOCK_PILLAR_END_STONE;
    public static final Block BLOCK_PILLAR_NETHERRACK;

    //Slabs
    public static final BlockVanillaStoneSlab BLOCK_HALF_SLAB_VANILLA_STONE;
    public static final BlockVanillaStoneSlab BLOCK_DOUBLE_SLAB_VANILLA_STONE;
    public static final BlockVanillaStoneSlab2 BLOCK_HALF_SLAB_VANILLA_STONE_2;
    public static final BlockVanillaStoneSlab2 BLOCK_DOUBLE_SLAB_VANILLA_STONE_2;
    public static final BlockTerracottaSlab BLOCK_HALF_SLAB_TERRACOTTA;
    public static final BlockTerracottaSlab BLOCK_DOUBLE_SLAB_TERRACOTTA;
    public static final BlockTerracottaSlab2 BLOCK_HALF_SLAB_TERRACOTTA_2;
    public static final BlockTerracottaSlab2 BLOCK_DOUBLE_SLAB_TERRACOTTA_2;
    public static final BlockConcreteSlab BLOCK_HALF_SLAB_CONCRETE;
    public static final BlockConcreteSlab BLOCK_DOUBLE_SLAB_CONCRETE;
    public static final BlockConcreteSlab2 BLOCK_HALF_SLAB_CONCRETE_2;
    public static final BlockConcreteSlab2 BLOCK_DOUBLE_SLAB_CONCRETE_2;
    public static final BlockModSlab BLOCK_HALF_SLAB_MOD;
    public static final BlockModSlab BLOCK_DOUBLE_SLAB_MOD;
    public static final BlockTerracottaBricksSlab BLOCK_HALF_SLAB_TERRACOTTA_BRICKS;
    public static final BlockTerracottaBricksSlab BLOCK_DOUBLE_SLAB_TERRACOTTA_BRICKS;
    public static final BlockTerracottaBricksSlab2 BLOCK_HALF_SLAB_TERRACOTTA_BRICKS_2;
    public static final BlockTerracottaBricksSlab2 BLOCK_DOUBLE_SLAB_TERRACOTTA_BRICKS_2;
    public static final BlockObsidianSlab BLOCK_HALF_SLAB_OBSIDIAN;
    public static final BlockObsidianSlab BLOCK_DOUBLE_SLAB_OBSIDIAN;
    public static final BlockGravelStoneSlab BLOCK_HALF_SLAB_GRAVEL_STONE;
    public static final BlockGravelStoneSlab BLOCK_DOUBLE_SLAB_GRAVEL_STONE;

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
    public static final Block BLOCK_RED_NETHER_BRICK_FENCE;
    public static final Block BLOCK_NETHER_BRICK_FENCE_GATE;
    public static final Block BLOCK_RED_NETHER_BRICK_FENCE_GATE;

    public static final Block BLOCK_SOUL_GLASS_PANE;
    public static final Block BLOCK_STAINED_SOUL_GLASS_PANE;
    public static final Block BLOCK_ROSE;

    static
    {
        BLOCK_BOOKSHELF = new BlockBookShelf();
        registerBlockMeta(BLOCK_BOOKSHELF, new ItemBlockMeta(BLOCK_BOOKSHELF, Names.BLOCK_BOOKSHELF));
        BLOCK_COBBLESTONE_BRICKS = registerBlock(((BlockBase) new BlockBase(Names.BLOCK_COBBELSTONE_BRICKS).setHardness(BlockValues.COBBLESTONE_HARDNESS).setResistance(BlockValues.COBBLESTONE_RESISTANCE)).addStair());
        BLOCK_MOSSY_COBBLESTONE_BRICKS = registerBlock(((BlockBase) new BlockBase(Names.BLOCK_MOSSY_COBBELSTONE_BRICKS).setHardness(BlockValues.COBBLESTONE_HARDNESS).setResistance(BlockValues.COBBLESTONE_RESISTANCE)).addStair());
        BLOCK_TERRACOTTA_BRICKS = ((BlockBase) registerBlock(new BlockBase(Names.BLOCK_TERRACOTTA_BRICKS).setHardness(BlockValues.TERRACOTTA_HARDNESS).setResistance(BlockValues.TERRACOTTA_RESISTANCE))).addStair();
        BLOCK_STAINED_TERRACOTTA_BRICKS = ((BlockColoredBase) new BlockColoredBase(Material.ROCK, Names.BLOCK_STAINED_TERRACOTTA_BRICKS).setHardness(BlockValues.TERRACOTTA_HARDNESS).setResistance(BlockValues.TERRACOTTA_RESISTANCE)).addStair();
        registerBlockMeta(BLOCK_STAINED_TERRACOTTA_BRICKS, new ItemBlockMeta(BLOCK_STAINED_TERRACOTTA_BRICKS, Names.BLOCK_STAINED_TERRACOTTA_BRICKS));
        BLOCK_MAGMA_BRICKS = registerBlock(new BlockMagmaBricks().addStair());
        BLOCK_OBSIDIAN_BRICKS = ((BlockBase) registerBlock(new BlockBase(Names.BLOCK_OBSIDIAN_BRICKS).setHardness(BlockValues.OBSIDIAN_HARDNESS).setResistance(BlockValues.OBSIDIAN_RESISTANCE))).addStair();
        BLOCK_POLISHED = new BlockPolished().addStair();
        registerBlockMeta(BLOCK_POLISHED);
        BLOCK_FACELESS_PUMPKIN = registerBlock(new BlockFacelessPumpkin());
        BLOCK_FINE_GRAVEL = registerBlock(new BlockFallingBase(Names.BLOCK_FINE_GRAVEL, SoundType.GROUND).setHardness(BlockValues.SAND_HARDNESS).setResistance(BlockValues.SAND_RESISTANCE));
        BLOCK_GRAVEL_STONE = new BlockGravelStone().addStair();
        registerBlockMeta(BLOCK_GRAVEL_STONE);

        BLOCK_CHARCOAL = registerBlock(new BlockBase(Material.ROCK, Names.BLOCK_CHARCOAL, SoundType.STONE).setHardness(5.0F).setResistance(10.0F));
        BLOCK_SUGAR = registerBlock(new BlockFallingBase(Names.BLOCK_SUGAR).setHardness(BlockValues.SAND_HARDNESS).setResistance(BlockValues.SAND_RESISTANCE));
        BLOCK_SUGAR_CANE = registerBlock(new BlockPillarBase(Material.LEAVES, Names.BLOCK_SUGAR_CANE, SoundType.PLANT).setHardness(BlockValues.PLANT_BLOCK_HARDNESS).setResistance(BlockValues.PLANT_BLOCK_RESISTANCE));
        BLOCK_GUNPOWDER = registerBlock(new BlockGunpowder());
        BLOCK_BLAZE_POWDER = registerBlock(new BlockFallingBase(Names.BLOCK_BLAZE_POWDER, SoundType.SNOW).setHardness(BlockValues.SAND_HARDNESS).setResistance(BlockValues.SAND_RESISTANCE));
        BLOCK_MAGMA_CREAM = registerBlock(new BlockMagmaCream());
        BLOCK_PRISMARINE_CRYSTAL = registerBlock(new BlockPrismarineCrystal());
        BLOCK_CHARRED_BONE = registerBlock(new BlockPillarBase(Names.BLOCK_CHARRED_BONE)).setHardness(BlockValues.BONE_BLOCK_HARDNESS).setResistance(BlockValues.BONE_BLOCK_RESISTANCE);
        BLOCK_DYE = new BlockDye();
        registerBlockMeta(BLOCK_DYE, new ItemBlockMeta(BLOCK_DYE, Names.BLOCK_DYE));

        BLOCK_SOUL_GLASS = registerBlock(new BlockSoulGlass());
        BLOCK_STAINED_SOUL_GLASS = new BlockStainedSoulGlass();
        registerBlockMeta(BLOCK_STAINED_SOUL_GLASS);

        BLOCK_PILLAR_GRANITE = registerBlock(new BlockPillarBase(Names.BLOCK_PILLAR_GRANITE).setHardness(BlockValues.STONE_HARDNESS).setResistance(BlockValues.STONE_RESISTANCE));
        BLOCK_PILLAR_DIORITE = registerBlock(new BlockPillarBase(Names.BLOCK_PILLAR_DIORITE).setHardness(BlockValues.STONE_HARDNESS).setResistance(BlockValues.STONE_RESISTANCE));
        BLOCK_PILLAR_ANDESITE = registerBlock(new BlockPillarBase(Names.BLOCK_PILLAR_ANDESITE).setHardness(BlockValues.STONE_HARDNESS).setResistance(BlockValues.STONE_RESISTANCE));
        BLOCK_PILLAR_PRISMARINE = registerBlock(new BlockPillarBase(Names.BLOCK_PILLAR_PRISMARINE).setHardness(BlockValues.STONE_HARDNESS).setResistance(BlockValues.STONE_RESISTANCE));
        BLOCK_PILLAR_DARK_PRISMARINE = registerBlock(new BlockPillarBase(Names.BLOCK_PILLAR_DARK_PRISMARINE).setHardness(BlockValues.STONE_HARDNESS).setResistance(BlockValues.STONE_RESISTANCE));
        BLOCK_PILLAR_END_STONE = registerBlock(new BlockPillarBase(Names.BLOCK_PILLAR_END_STONE).setHardness(BlockValues.END_STONE_HARDNESS).setResistance(BlockValues.END_STONE_RESISTANCE));
        BLOCK_PILLAR_NETHERRACK = registerBlock(new BlockPillarBase(Names.BLOCK_PILLAR_NETHERRACK).setHardness(BlockValues.NETHER_BRICKS_HARDNESS).setResistance(BlockValues.NETHERRACK_RESISTANCE));

        BLOCK_HALF_SLAB_VANILLA_STONE = new BlockVanillaStoneSlab(Names.BLOCK_HALF_SLAB_VANILLA_STONE, false);
        BLOCK_DOUBLE_SLAB_VANILLA_STONE = new BlockVanillaStoneSlab(Names.BLOCK_DOUBLE_SLAB_VANILLA_STONE, true);
        BLOCK_HALF_SLAB_VANILLA_STONE_2 = new BlockVanillaStoneSlab2(Names.BLOCK_HALF_SLAB_VANILLA_STONE_2, false);
        BLOCK_DOUBLE_SLAB_VANILLA_STONE_2 = new BlockVanillaStoneSlab2(Names.BLOCK_DOUBLE_SLAB_VANILLA_STONE_2, true);
        BLOCK_HALF_SLAB_TERRACOTTA = new BlockTerracottaSlab(Names.BLOCK_HALF_SLAB_TERRACOTTA, false);
        BLOCK_DOUBLE_SLAB_TERRACOTTA = new BlockTerracottaSlab(Names.BLOCK_DOUBLE_SLAB_TERRACOTTA, true);
        BLOCK_HALF_SLAB_TERRACOTTA_2 = new BlockTerracottaSlab2(Names.BLOCK_HALF_SLAB_TERRACOTTA_2, false);
        BLOCK_DOUBLE_SLAB_TERRACOTTA_2 = new BlockTerracottaSlab2(Names.BLOCK_DOUBLE_SLAB_TERRACOTTA_2, true);
        BLOCK_HALF_SLAB_CONCRETE = new BlockConcreteSlab(Names.BLOCK_HALF_SLAB_CONCRETE, false);
        BLOCK_DOUBLE_SLAB_CONCRETE = new BlockConcreteSlab(Names.BLOCK_DOUBLE_SLAB_CONCRETE, true);
        BLOCK_HALF_SLAB_CONCRETE_2 = new BlockConcreteSlab2(Names.BLOCK_HALF_SLAB_CONCRETE_2, false);
        BLOCK_DOUBLE_SLAB_CONCRETE_2 = new BlockConcreteSlab2(Names.BLOCK_DOUBLE_SLAB_CONCRETE_2, true);
        BLOCK_HALF_SLAB_MOD = new BlockModSlab(Names.BLOCK_HALF_SLAB_MOD, false);
        BLOCK_DOUBLE_SLAB_MOD = new BlockModSlab(Names.BLOCK_DOUBLE_SLAB_MOD, true);
        BLOCK_HALF_SLAB_TERRACOTTA_BRICKS = new BlockTerracottaBricksSlab(Names.BLOCK_HALF_SLAB_TERRACOTTA_BRICKS, false);
        BLOCK_DOUBLE_SLAB_TERRACOTTA_BRICKS = new BlockTerracottaBricksSlab(Names.BLOCK_DOUBLE_SLAB_TERRACOTTA_BRICKS, true);
        BLOCK_HALF_SLAB_TERRACOTTA_BRICKS_2 = new BlockTerracottaBricksSlab2(Names.BLOCK_HALF_SLAB_TERRACOTTA_BRICKS_2, false);
        BLOCK_DOUBLE_SLAB_TERRACOTTA_BRICKS_2 = new BlockTerracottaBricksSlab2(Names.BLOCK_DOUBLE_SLAB_TERRACOTTA_BRICKS_2, true);
        BLOCK_HALF_SLAB_OBSIDIAN = new BlockObsidianSlab(Names.BLOCK_HALF_SLAB_OBSIDIAN, false);
        BLOCK_DOUBLE_SLAB_OBSIDIAN = new BlockObsidianSlab(Names.BLOCK_DOUBLE_SLAB_OBSIDIAN, true);
        BLOCK_HALF_SLAB_GRAVEL_STONE = new BlockGravelStoneSlab(Names.BLOCK_HALF_SLAB_GRAVEL_STONE, false);
        BLOCK_DOUBLE_SLAB_GRAVEL_STONE = new BlockGravelStoneSlab(Names.BLOCK_DOUBLE_SLAB_GRAVEL_STONE, true);

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
        registerBlockMeta(BLOCK_HALF_SLAB_OBSIDIAN, new ItemSlabBase(BLOCK_HALF_SLAB_OBSIDIAN, BLOCK_HALF_SLAB_OBSIDIAN, BLOCK_DOUBLE_SLAB_OBSIDIAN));
        registerBlockMeta(BLOCK_DOUBLE_SLAB_OBSIDIAN, new ItemSlabBase(BLOCK_DOUBLE_SLAB_OBSIDIAN, BLOCK_HALF_SLAB_OBSIDIAN, BLOCK_DOUBLE_SLAB_OBSIDIAN));
        registerBlockMeta(BLOCK_HALF_SLAB_GRAVEL_STONE, new ItemSlabBase(BLOCK_HALF_SLAB_GRAVEL_STONE, BLOCK_HALF_SLAB_GRAVEL_STONE, BLOCK_DOUBLE_SLAB_GRAVEL_STONE));
        registerBlockMeta(BLOCK_DOUBLE_SLAB_GRAVEL_STONE, new ItemSlabBase(BLOCK_DOUBLE_SLAB_GRAVEL_STONE, BLOCK_HALF_SLAB_GRAVEL_STONE, BLOCK_DOUBLE_SLAB_GRAVEL_STONE));

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

        BLOCK_GOLDEN_BARS = registerBlock(new BlockPaneBase(Material.IRON, Names.BLOCK_GOLDEN_BARS, SoundType.METAL, true).setHardness(5.0F).setResistance(10.0F));
        BLOCK_RED_NETHER_BRICK_FENCE = registerBlock(new BlockRedNetherBrickFence());
        BLOCK_NETHER_BRICK_FENCE_GATE = registerBlock(new BlockNetherBrickFenceGate(Names.BLOCK_NETHER_FENCE_GATE));
        BLOCK_RED_NETHER_BRICK_FENCE_GATE = registerBlock(new BlockNetherBrickFenceGate(Names.BLOCK_RED_NETHER_FENCE_GATE));
        BLOCK_SOUL_GLASS_PANE = registerBlock(new BlockSoulGlassPane());
        BLOCK_STAINED_SOUL_GLASS_PANE = new BlockStainedSoulGlassPane();
        registerBlockMeta(BLOCK_STAINED_SOUL_GLASS_PANE);
        BLOCK_ROSE = registerBlock(new BlockRose());

        addVanillaStair(Blocks.STONE.getDefaultState().withProperty(BlockStone.VARIANT, BlockStone.EnumType.STONE), Names.STONE);
        addVanillaStair(Blocks.STONE.getDefaultState().withProperty(BlockStone.VARIANT, BlockStone.EnumType.GRANITE_SMOOTH), Names.SMOOTH_GRANITE);
        addVanillaStair(Blocks.STONE.getDefaultState().withProperty(BlockStone.VARIANT, BlockStone.EnumType.DIORITE_SMOOTH), Names.SMOOTH_DIORITE);
        addVanillaStair(Blocks.STONE.getDefaultState().withProperty(BlockStone.VARIANT, BlockStone.EnumType.ANDESITE_SMOOTH), Names.SMOOTH_ANDESITE);
        addVanillaStair(Blocks.MOSSY_COBBLESTONE, Names.MOSSY_COBBLESTONE);
        addVanillaStair(Blocks.STONEBRICK.getDefaultState().withProperty(BlockStoneBrick.VARIANT, BlockStoneBrick.EnumType.MOSSY), Names.MOSSY_STONEBRICK);
        addVanillaStair(Blocks.STONEBRICK.getDefaultState().withProperty(BlockStoneBrick.VARIANT, BlockStoneBrick.EnumType.CRACKED), Names.CRACKED_STONEBRICK);
        addVanillaStair(Blocks.STONEBRICK.getDefaultState().withProperty(BlockStoneBrick.VARIANT, BlockStoneBrick.EnumType.CHISELED), Names.CHISELED_STONEBRICK);
        addVanillaStair(Blocks.SANDSTONE.getDefaultState().withProperty(BlockSandStone.TYPE, BlockSandStone.EnumType.CHISELED), Names.CHISELED_SANDSTONE);
        addVanillaStair(Blocks.SANDSTONE.getDefaultState().withProperty(BlockSandStone.TYPE, BlockSandStone.EnumType.SMOOTH), Names.SMOOTH_SANDSTONE);
        addVanillaStair(Blocks.RED_SANDSTONE.getDefaultState().withProperty(BlockRedSandstone.TYPE, BlockRedSandstone.EnumType.CHISELED), Names.CHISELED_RED_SANDSTONE);
        addVanillaStair(Blocks.RED_SANDSTONE.getDefaultState().withProperty(BlockRedSandstone.TYPE, BlockRedSandstone.EnumType.SMOOTH), Names.SMOOTH_RED_SANDSTONE);
        addVanillaStair(Blocks.PRISMARINE.getDefaultState().withProperty(BlockPrismarine.VARIANT, BlockPrismarine.EnumType.BRICKS), Names.PRISMARINE_BRICKS);
        addVanillaStair(Blocks.PRISMARINE.getDefaultState().withProperty(BlockPrismarine.VARIANT, BlockPrismarine.EnumType.DARK), Names.DARK_PRISMARINE);
        addVanillaStair(Blocks.END_BRICKS, Names.END_BRICKS);
        addVanillaStair(Blocks.RED_NETHER_BRICK.getDefaultState(), Names.RED_NETHER_BRICK);
        addVanillaStair(Blocks.STAINED_HARDENED_CLAY.getDefaultState().withProperty(BlockColored.COLOR, EnumDyeColor.WHITE), Names.WHITE + "_" + Names.TERRACOTTA);
        addVanillaStair(Blocks.STAINED_HARDENED_CLAY.getDefaultState().withProperty(BlockColored.COLOR, EnumDyeColor.ORANGE), Names.ORANGE + "_" + Names.TERRACOTTA);
        addVanillaStair(Blocks.STAINED_HARDENED_CLAY.getDefaultState().withProperty(BlockColored.COLOR, EnumDyeColor.MAGENTA), Names.MAGENTA + "_" + Names.TERRACOTTA);
        addVanillaStair(Blocks.STAINED_HARDENED_CLAY.getDefaultState().withProperty(BlockColored.COLOR, EnumDyeColor.LIGHT_BLUE), Names.LIGHT_BLUE + "_" + Names.TERRACOTTA);
        addVanillaStair(Blocks.STAINED_HARDENED_CLAY.getDefaultState().withProperty(BlockColored.COLOR, EnumDyeColor.YELLOW), Names.YELLOW + "_" + Names.TERRACOTTA);
        addVanillaStair(Blocks.STAINED_HARDENED_CLAY.getDefaultState().withProperty(BlockColored.COLOR, EnumDyeColor.LIME), Names.LIME + "_" + Names.TERRACOTTA);
        addVanillaStair(Blocks.STAINED_HARDENED_CLAY.getDefaultState().withProperty(BlockColored.COLOR, EnumDyeColor.PINK), Names.PINK + "_" + Names.TERRACOTTA);
        addVanillaStair(Blocks.STAINED_HARDENED_CLAY.getDefaultState().withProperty(BlockColored.COLOR, EnumDyeColor.GRAY), Names.GRAY + "_" + Names.TERRACOTTA);
        addVanillaStair(Blocks.STAINED_HARDENED_CLAY.getDefaultState().withProperty(BlockColored.COLOR, EnumDyeColor.SILVER), Names.SILVER + "_" + Names.TERRACOTTA);
        addVanillaStair(Blocks.STAINED_HARDENED_CLAY.getDefaultState().withProperty(BlockColored.COLOR, EnumDyeColor.CYAN), Names.CYAN + "_" + Names.TERRACOTTA);
        addVanillaStair(Blocks.STAINED_HARDENED_CLAY.getDefaultState().withProperty(BlockColored.COLOR, EnumDyeColor.PURPLE), Names.PURPLE + "_" + Names.TERRACOTTA);
        addVanillaStair(Blocks.STAINED_HARDENED_CLAY.getDefaultState().withProperty(BlockColored.COLOR, EnumDyeColor.BLUE), Names.BLUE + "_" + Names.TERRACOTTA);
        addVanillaStair(Blocks.STAINED_HARDENED_CLAY.getDefaultState().withProperty(BlockColored.COLOR, EnumDyeColor.BROWN), Names.BROWN + "_" + Names.TERRACOTTA);
        addVanillaStair(Blocks.STAINED_HARDENED_CLAY.getDefaultState().withProperty(BlockColored.COLOR, EnumDyeColor.GREEN), Names.GREEN + "_" + Names.TERRACOTTA);
        addVanillaStair(Blocks.STAINED_HARDENED_CLAY.getDefaultState().withProperty(BlockColored.COLOR, EnumDyeColor.RED), Names.RED + "_" + Names.TERRACOTTA);
        addVanillaStair(Blocks.STAINED_HARDENED_CLAY.getDefaultState().withProperty(BlockColored.COLOR, EnumDyeColor.BLACK), Names.BLACK + "_" + Names.TERRACOTTA);
        addVanillaStair(Blocks.CONCRETE.getDefaultState().withProperty(BlockColored.COLOR, EnumDyeColor.WHITE), Names.WHITE + "_" + Names.CONCRETE);
        addVanillaStair(Blocks.CONCRETE.getDefaultState().withProperty(BlockColored.COLOR, EnumDyeColor.ORANGE), Names.ORANGE + "_" + Names.CONCRETE);
        addVanillaStair(Blocks.CONCRETE.getDefaultState().withProperty(BlockColored.COLOR, EnumDyeColor.MAGENTA), Names.MAGENTA + "_" + Names.CONCRETE);
        addVanillaStair(Blocks.CONCRETE.getDefaultState().withProperty(BlockColored.COLOR, EnumDyeColor.LIGHT_BLUE), Names.LIGHT_BLUE + "_" + Names.CONCRETE);
        addVanillaStair(Blocks.CONCRETE.getDefaultState().withProperty(BlockColored.COLOR, EnumDyeColor.YELLOW), Names.YELLOW + "_" + Names.CONCRETE);
        addVanillaStair(Blocks.CONCRETE.getDefaultState().withProperty(BlockColored.COLOR, EnumDyeColor.LIME), Names.LIME + "_" + Names.CONCRETE);
        addVanillaStair(Blocks.CONCRETE.getDefaultState().withProperty(BlockColored.COLOR, EnumDyeColor.PINK), Names.PINK + "_" + Names.CONCRETE);
        addVanillaStair(Blocks.CONCRETE.getDefaultState().withProperty(BlockColored.COLOR, EnumDyeColor.GRAY), Names.GRAY + "_" + Names.CONCRETE);
        addVanillaStair(Blocks.CONCRETE.getDefaultState().withProperty(BlockColored.COLOR, EnumDyeColor.SILVER), Names.SILVER + "_" + Names.CONCRETE);
        addVanillaStair(Blocks.CONCRETE.getDefaultState().withProperty(BlockColored.COLOR, EnumDyeColor.CYAN), Names.CYAN + "_" + Names.CONCRETE);
        addVanillaStair(Blocks.CONCRETE.getDefaultState().withProperty(BlockColored.COLOR, EnumDyeColor.PURPLE), Names.PURPLE + "_" + Names.CONCRETE);
        addVanillaStair(Blocks.CONCRETE.getDefaultState().withProperty(BlockColored.COLOR, EnumDyeColor.BLUE), Names.BLUE + "_" + Names.CONCRETE);
        addVanillaStair(Blocks.CONCRETE.getDefaultState().withProperty(BlockColored.COLOR, EnumDyeColor.BROWN), Names.BROWN + "_" + Names.CONCRETE);
        addVanillaStair(Blocks.CONCRETE.getDefaultState().withProperty(BlockColored.COLOR, EnumDyeColor.GREEN), Names.GREEN + "_" + Names.CONCRETE);
        addVanillaStair(Blocks.CONCRETE.getDefaultState().withProperty(BlockColored.COLOR, EnumDyeColor.RED), Names.RED + "_" + Names.CONCRETE);
        addVanillaStair(Blocks.CONCRETE.getDefaultState().withProperty(BlockColored.COLOR, EnumDyeColor.BLACK), Names.BLACK + "_" + Names.CONCRETE);
        addVanillaStair(Blocks.OBSIDIAN.getDefaultState(), Names.OBSIDIAN);
        
        addStairs();
        
        //Block test = new BlockTest(BLOCK_COBBLESTONE_BRICKS.getDefaultState(), Utils.getBaseBlockName(BLOCK_COBBLESTONE_BRICKS), false, false);
        //Block test1 = new BlockTest(BLOCK_COBBLESTONE_BRICKS.getDefaultState(), Utils.getBaseBlockName(BLOCK_COBBLESTONE_BRICKS), true, false);
    }

    public static void registerBlocks()
    {
    }

    private static void addStairs()
    {
        for (Block block : STAIR_LIST)
        {
            IBlockState state = block.getDefaultState();
            String name = Utils.getBaseBlockName(block);

            if (block instanceof IBlockMeta)
            {
                for (int i = 0; i < ((ItemBlockMeta) Item.getItemFromBlock(block)).getVariants().length; i++)
                {
                    state = block.getDefaultState().withProperty(((IBlockMeta) block).getVariants(), ((IBlockMeta) block).byMetadata(i));
                    name = Utils.getBaseBlockName(((IBlockMeta) block).getSpecialName(i)).replace("stained_", "");

                    addStair(state, name, false);
                }
            }
            else
            {
                addStair(state, name, false);
            }
        }
    }

    private static void addVanillaStair(Block block, String name)
    {
        addVanillaStair(block.getDefaultState(), name);
    }

    private static void addVanillaStair(IBlockState state, String name)
    {
        addStair(state, name, true);
    }

    private static void addStair(IBlockState state, String name, boolean vanilla)
    {
        registerBlock(new BlockStairBase(state, name, vanilla));
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
        addCreativeList(block);
        addConfig(block);

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
        addCreativeList(block);
        addConfig(block);

        return block;
    }

    private static void addConfig(Block block)
    {
        if (block instanceof BlockStairBase)
        {
            if (((BlockStairBase) block).isVanilla())
            {
                ConfigurationHandler.createVanillaConfig(block);
            }

            return;
        }
        else if (block instanceof BlockSlabBase)
        {
            return;
        }

        ConfigurationHandler.createBlockConfig(block);
    }

    private static void addCreativeList(Block block)
    {
        Item item = Item.getItemFromBlock(block);

        if (block instanceof BlockStairBase || block instanceof BlockSlabBase)
        {
            CreativeTab.stairAndSlabList.add(item);
        }
        else
        {
            CreativeTab.tabList.add(item);
        }
    }
}
