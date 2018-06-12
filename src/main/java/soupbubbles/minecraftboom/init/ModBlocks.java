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
import soupbubbles.minecraftboom.block.base.BlockStairBase;
import soupbubbles.minecraftboom.block.base.BlockSlabBase;
import soupbubbles.minecraftboom.creativetab.CreativeTab;
import soupbubbles.minecraftboom.handler.ConfigurationHandler;
import soupbubbles.minecraftboom.item.base.ItemBlockMeta;
import soupbubbles.minecraftboom.item.base.ItemBlockSlab;
import soupbubbles.minecraftboom.reference.BlockValues;
import soupbubbles.minecraftboom.reference.Names;
import soupbubbles.minecraftboom.util.IBlockMeta;
import soupbubbles.minecraftboom.util.IStairSlab;
import soupbubbles.minecraftboom.util.Utils;

public class ModBlocks
{
    public static final Set<Block> BLOCKS = new HashSet<>();
    public static final List<Block> STAIRSLAB_LIST = new ArrayList<Block>();

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
        BLOCK_COBBLESTONE_BRICKS = registerBlock(((BlockBase) new BlockBase(Names.BLOCK_COBBELSTONE_BRICKS).setHardness(BlockValues.COBBLESTONE_HARDNESS).setResistance(BlockValues.COBBLESTONE_RESISTANCE)).addStairSlab());
        BLOCK_MOSSY_COBBLESTONE_BRICKS = registerBlock(((BlockBase) new BlockBase(Names.BLOCK_MOSSY_COBBELSTONE_BRICKS).setHardness(BlockValues.COBBLESTONE_HARDNESS).setResistance(BlockValues.COBBLESTONE_RESISTANCE)).addStairSlab());
        BLOCK_TERRACOTTA_BRICKS = ((BlockBase) registerBlock(new BlockBase(Names.BLOCK_TERRACOTTA_BRICKS).setHardness(BlockValues.TERRACOTTA_HARDNESS).setResistance(BlockValues.TERRACOTTA_RESISTANCE))).addStairSlab();
        BLOCK_STAINED_TERRACOTTA_BRICKS = ((BlockColoredBase) new BlockColoredBase(Material.ROCK, Names.BLOCK_STAINED_TERRACOTTA_BRICKS).setHardness(BlockValues.TERRACOTTA_HARDNESS).setResistance(BlockValues.TERRACOTTA_RESISTANCE)).addStairSlab();
        registerBlockMeta(BLOCK_STAINED_TERRACOTTA_BRICKS, new ItemBlockMeta(BLOCK_STAINED_TERRACOTTA_BRICKS, Names.BLOCK_STAINED_TERRACOTTA_BRICKS));
        BLOCK_MAGMA_BRICKS = registerBlock(new BlockMagmaBricks().addStairSlab());
        BLOCK_OBSIDIAN_BRICKS = ((BlockBase) registerBlock(new BlockBase(Names.BLOCK_OBSIDIAN_BRICKS).setHardness(BlockValues.OBSIDIAN_HARDNESS).setResistance(BlockValues.OBSIDIAN_RESISTANCE))).addStairSlab();
        BLOCK_POLISHED = new BlockPolished().addStairSlab();
        registerBlockMeta(BLOCK_POLISHED);
        BLOCK_FACELESS_PUMPKIN = registerBlock(new BlockFacelessPumpkin());
        BLOCK_FINE_GRAVEL = registerBlock(new BlockFallingBase(Names.BLOCK_FINE_GRAVEL, SoundType.GROUND).setHardness(BlockValues.SAND_HARDNESS).setResistance(BlockValues.SAND_RESISTANCE));
        BLOCK_GRAVEL_STONE = new BlockGravelStone().addStairSlab();
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

        addVanillaStairSlab(Blocks.STONE.getDefaultState().withProperty(BlockStone.VARIANT, BlockStone.EnumType.STONE), Names.STONE);
        addVanillaStairSlab(Blocks.STONE.getDefaultState().withProperty(BlockStone.VARIANT, BlockStone.EnumType.GRANITE_SMOOTH), Names.SMOOTH_GRANITE);
        addVanillaStairSlab(Blocks.STONE.getDefaultState().withProperty(BlockStone.VARIANT, BlockStone.EnumType.DIORITE_SMOOTH), Names.SMOOTH_DIORITE);
        addVanillaStairSlab(Blocks.STONE.getDefaultState().withProperty(BlockStone.VARIANT, BlockStone.EnumType.ANDESITE_SMOOTH), Names.SMOOTH_ANDESITE);
        addVanillaStairSlab(Blocks.MOSSY_COBBLESTONE, Names.MOSSY_COBBLESTONE);
        addVanillaStairSlab(Blocks.STONEBRICK.getDefaultState().withProperty(BlockStoneBrick.VARIANT, BlockStoneBrick.EnumType.MOSSY), Names.MOSSY_STONEBRICK);
        addVanillaStairSlab(Blocks.STONEBRICK.getDefaultState().withProperty(BlockStoneBrick.VARIANT, BlockStoneBrick.EnumType.CRACKED), Names.CRACKED_STONEBRICK);
        addVanillaStairSlab(Blocks.STONEBRICK.getDefaultState().withProperty(BlockStoneBrick.VARIANT, BlockStoneBrick.EnumType.CHISELED), Names.CHISELED_STONEBRICK);
        addVanillaStairSlab(Blocks.SANDSTONE.getDefaultState().withProperty(BlockSandStone.TYPE, BlockSandStone.EnumType.CHISELED), Names.CHISELED_SANDSTONE);
        addVanillaStairSlab(Blocks.SANDSTONE.getDefaultState().withProperty(BlockSandStone.TYPE, BlockSandStone.EnumType.SMOOTH), Names.SMOOTH_SANDSTONE);
        addVanillaStairSlab(Blocks.RED_SANDSTONE.getDefaultState().withProperty(BlockRedSandstone.TYPE, BlockRedSandstone.EnumType.CHISELED), Names.CHISELED_RED_SANDSTONE);
        addVanillaStairSlab(Blocks.RED_SANDSTONE.getDefaultState().withProperty(BlockRedSandstone.TYPE, BlockRedSandstone.EnumType.SMOOTH), Names.SMOOTH_RED_SANDSTONE);
        addVanillaStairSlab(Blocks.PRISMARINE.getDefaultState().withProperty(BlockPrismarine.VARIANT, BlockPrismarine.EnumType.BRICKS), Names.PRISMARINE_BRICKS);
        addVanillaStairSlab(Blocks.PRISMARINE.getDefaultState().withProperty(BlockPrismarine.VARIANT, BlockPrismarine.EnumType.DARK), Names.DARK_PRISMARINE);
        addVanillaStairSlab(Blocks.END_BRICKS, Names.END_BRICKS);
        addVanillaStairSlab(Blocks.RED_NETHER_BRICK.getDefaultState(), Names.RED_NETHER_BRICK);
        addVanillaStairSlab(Blocks.STAINED_HARDENED_CLAY, Names.TERRACOTTA);
        addVanillaStairSlab(Blocks.STAINED_HARDENED_CLAY.getDefaultState().withProperty(BlockColored.COLOR, EnumDyeColor.WHITE), Names.WHITE + "_" + Names.TERRACOTTA);
        addVanillaStairSlab(Blocks.STAINED_HARDENED_CLAY.getDefaultState().withProperty(BlockColored.COLOR, EnumDyeColor.ORANGE), Names.ORANGE + "_" + Names.TERRACOTTA);
        addVanillaStairSlab(Blocks.STAINED_HARDENED_CLAY.getDefaultState().withProperty(BlockColored.COLOR, EnumDyeColor.MAGENTA), Names.MAGENTA + "_" + Names.TERRACOTTA);
        addVanillaStairSlab(Blocks.STAINED_HARDENED_CLAY.getDefaultState().withProperty(BlockColored.COLOR, EnumDyeColor.LIGHT_BLUE), Names.LIGHT_BLUE + "_" + Names.TERRACOTTA);
        addVanillaStairSlab(Blocks.STAINED_HARDENED_CLAY.getDefaultState().withProperty(BlockColored.COLOR, EnumDyeColor.YELLOW), Names.YELLOW + "_" + Names.TERRACOTTA);
        addVanillaStairSlab(Blocks.STAINED_HARDENED_CLAY.getDefaultState().withProperty(BlockColored.COLOR, EnumDyeColor.LIME), Names.LIME + "_" + Names.TERRACOTTA);
        addVanillaStairSlab(Blocks.STAINED_HARDENED_CLAY.getDefaultState().withProperty(BlockColored.COLOR, EnumDyeColor.PINK), Names.PINK + "_" + Names.TERRACOTTA);
        addVanillaStairSlab(Blocks.STAINED_HARDENED_CLAY.getDefaultState().withProperty(BlockColored.COLOR, EnumDyeColor.GRAY), Names.GRAY + "_" + Names.TERRACOTTA);
        addVanillaStairSlab(Blocks.STAINED_HARDENED_CLAY.getDefaultState().withProperty(BlockColored.COLOR, EnumDyeColor.SILVER), Names.SILVER + "_" + Names.TERRACOTTA);
        addVanillaStairSlab(Blocks.STAINED_HARDENED_CLAY.getDefaultState().withProperty(BlockColored.COLOR, EnumDyeColor.CYAN), Names.CYAN + "_" + Names.TERRACOTTA);
        addVanillaStairSlab(Blocks.STAINED_HARDENED_CLAY.getDefaultState().withProperty(BlockColored.COLOR, EnumDyeColor.PURPLE), Names.PURPLE + "_" + Names.TERRACOTTA);
        addVanillaStairSlab(Blocks.STAINED_HARDENED_CLAY.getDefaultState().withProperty(BlockColored.COLOR, EnumDyeColor.BLUE), Names.BLUE + "_" + Names.TERRACOTTA);
        addVanillaStairSlab(Blocks.STAINED_HARDENED_CLAY.getDefaultState().withProperty(BlockColored.COLOR, EnumDyeColor.BROWN), Names.BROWN + "_" + Names.TERRACOTTA);
        addVanillaStairSlab(Blocks.STAINED_HARDENED_CLAY.getDefaultState().withProperty(BlockColored.COLOR, EnumDyeColor.GREEN), Names.GREEN + "_" + Names.TERRACOTTA);
        addVanillaStairSlab(Blocks.STAINED_HARDENED_CLAY.getDefaultState().withProperty(BlockColored.COLOR, EnumDyeColor.RED), Names.RED + "_" + Names.TERRACOTTA);
        addVanillaStairSlab(Blocks.STAINED_HARDENED_CLAY.getDefaultState().withProperty(BlockColored.COLOR, EnumDyeColor.BLACK), Names.BLACK + "_" + Names.TERRACOTTA);
        addVanillaStairSlab(Blocks.CONCRETE.getDefaultState().withProperty(BlockColored.COLOR, EnumDyeColor.WHITE), Names.WHITE + "_" + Names.CONCRETE);
        addVanillaStairSlab(Blocks.CONCRETE.getDefaultState().withProperty(BlockColored.COLOR, EnumDyeColor.ORANGE), Names.ORANGE + "_" + Names.CONCRETE);
        addVanillaStairSlab(Blocks.CONCRETE.getDefaultState().withProperty(BlockColored.COLOR, EnumDyeColor.MAGENTA), Names.MAGENTA + "_" + Names.CONCRETE);
        addVanillaStairSlab(Blocks.CONCRETE.getDefaultState().withProperty(BlockColored.COLOR, EnumDyeColor.LIGHT_BLUE), Names.LIGHT_BLUE + "_" + Names.CONCRETE);
        addVanillaStairSlab(Blocks.CONCRETE.getDefaultState().withProperty(BlockColored.COLOR, EnumDyeColor.YELLOW), Names.YELLOW + "_" + Names.CONCRETE);
        addVanillaStairSlab(Blocks.CONCRETE.getDefaultState().withProperty(BlockColored.COLOR, EnumDyeColor.LIME), Names.LIME + "_" + Names.CONCRETE);
        addVanillaStairSlab(Blocks.CONCRETE.getDefaultState().withProperty(BlockColored.COLOR, EnumDyeColor.PINK), Names.PINK + "_" + Names.CONCRETE);
        addVanillaStairSlab(Blocks.CONCRETE.getDefaultState().withProperty(BlockColored.COLOR, EnumDyeColor.GRAY), Names.GRAY + "_" + Names.CONCRETE);
        addVanillaStairSlab(Blocks.CONCRETE.getDefaultState().withProperty(BlockColored.COLOR, EnumDyeColor.SILVER), Names.SILVER + "_" + Names.CONCRETE);
        addVanillaStairSlab(Blocks.CONCRETE.getDefaultState().withProperty(BlockColored.COLOR, EnumDyeColor.CYAN), Names.CYAN + "_" + Names.CONCRETE);
        addVanillaStairSlab(Blocks.CONCRETE.getDefaultState().withProperty(BlockColored.COLOR, EnumDyeColor.PURPLE), Names.PURPLE + "_" + Names.CONCRETE);
        addVanillaStairSlab(Blocks.CONCRETE.getDefaultState().withProperty(BlockColored.COLOR, EnumDyeColor.BLUE), Names.BLUE + "_" + Names.CONCRETE);
        addVanillaStairSlab(Blocks.CONCRETE.getDefaultState().withProperty(BlockColored.COLOR, EnumDyeColor.BROWN), Names.BROWN + "_" + Names.CONCRETE);
        addVanillaStairSlab(Blocks.CONCRETE.getDefaultState().withProperty(BlockColored.COLOR, EnumDyeColor.GREEN), Names.GREEN + "_" + Names.CONCRETE);
        addVanillaStairSlab(Blocks.CONCRETE.getDefaultState().withProperty(BlockColored.COLOR, EnumDyeColor.RED), Names.RED + "_" + Names.CONCRETE);
        addVanillaStairSlab(Blocks.CONCRETE.getDefaultState().withProperty(BlockColored.COLOR, EnumDyeColor.BLACK), Names.BLACK + "_" + Names.CONCRETE);
        addVanillaStairSlab(Blocks.OBSIDIAN.getDefaultState(), Names.OBSIDIAN);

        addStairSlabs();
    }

    public static void registerBlocks()
    {
    }

    private static void addStairSlabs()
    {
        for (Block block : STAIRSLAB_LIST)
        {
            IBlockState state = block.getDefaultState();
            String name = Utils.getBaseBlockName(block);

            if (block instanceof IBlockMeta)
            {
                for (int i = 0; i < ((ItemBlockMeta) Item.getItemFromBlock(block)).getVariants().length; i++)
                {
                    state = block.getDefaultState().withProperty(((IBlockMeta) block).getVariants(), ((IBlockMeta) block).byMetadata(i));
                    name = Utils.getBaseBlockName(((IBlockMeta) block).getSpecialName(i)).replace("stained_", "");

                    addStairSlab(state, name, false);
                }
            }
            else
            {
                addStairSlab(state, name, false);
            }
        }
    }

    private static void addVanillaStairSlab(Block block, String name)
    {
        addVanillaStairSlab(block.getDefaultState(), name);
    }

    private static void addVanillaStairSlab(IBlockState state, String name)
    {
        addStairSlab(state, name, true);
    }

    private static void addStairSlab(IBlockState state, String name, boolean vanilla)
    {
        BlockStairBase stair = state.getBlock() instanceof IStairSlab ? ((IStairSlab) state.getBlock()).setStair(new BlockStairBase(state, name, vanilla)) : new BlockStairBase(state, name, vanilla);
        registerBlock(stair);

        if (!name.equals(Names.STONE))
        {
            BlockSlabBase slab = state.getBlock() instanceof IStairSlab ? ((IStairSlab) state.getBlock()).setSlab(new BlockSlabBase(state, name, vanilla)) : new BlockSlabBase(state, name, vanilla);
            registerBlock(slab, ItemBlockSlab::new);
        }
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
            if (((BlockSlabBase) block).isVanilla())
            {
                ConfigurationHandler.createVanillaConfig(block);
            }

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
