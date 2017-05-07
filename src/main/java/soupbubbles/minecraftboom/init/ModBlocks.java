package soupbubbles.minecraftboom.init;

import java.util.HashSet;
import java.util.Set;

import javax.annotation.Nullable;

import com.google.common.base.Function;

import net.minecraft.block.Block;
import net.minecraft.block.BlockColored;
import net.minecraft.block.BlockPrismarine;
import net.minecraft.block.BlockPumpkin;
import net.minecraft.block.BlockRedSandstone;
import net.minecraft.block.BlockSandStone;
import net.minecraft.block.BlockStone;
import net.minecraft.block.BlockStoneBrick;
import net.minecraft.block.BlockWorkbench;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.fml.common.registry.ExistingSubstitutionException;
import net.minecraftforge.fml.common.registry.GameRegistry;
import soupbubbles.minecraftboom.block.BlockBookShelf;
import soupbubbles.minecraftboom.block.BlockCraftingTable;
import soupbubbles.minecraftboom.block.BlockDye;
import soupbubbles.minecraftboom.block.BlockGoldenBars;
import soupbubbles.minecraftboom.block.BlockGunpowder;
import soupbubbles.minecraftboom.block.BlockMagmaCream;
import soupbubbles.minecraftboom.block.BlockModSlabDouble;
import soupbubbles.minecraftboom.block.BlockModSlabHalf;
import soupbubbles.minecraftboom.block.BlockNewPumpkin;
import soupbubbles.minecraftboom.block.BlockPolished;
import soupbubbles.minecraftboom.block.BlockSoulGlass;
import soupbubbles.minecraftboom.block.BlockStainedSoulGlass;
import soupbubbles.minecraftboom.block.BlockVanillaStoneSlabDouble;
import soupbubbles.minecraftboom.block.BlockVanillaStoneSlabDouble2;
import soupbubbles.minecraftboom.block.BlockVanillaStoneSlabHalf;
import soupbubbles.minecraftboom.block.BlockVanillaStoneSlabHalf2;
import soupbubbles.minecraftboom.block.BlockWool;
import soupbubbles.minecraftboom.block.base.BlockBase;
import soupbubbles.minecraftboom.block.base.BlockColoredBase;
import soupbubbles.minecraftboom.block.base.BlockFallingBase;
import soupbubbles.minecraftboom.block.base.BlockPillarBase;
import soupbubbles.minecraftboom.block.base.BlockStairBase;
import soupbubbles.minecraftboom.handler.ConfigurationHandler;
import soupbubbles.minecraftboom.item.base.ItemBlockMeta;
import soupbubbles.minecraftboom.item.base.ItemSlabBase;
import soupbubbles.minecraftboom.reference.Names;
import soupbubbles.minecraftboom.reference.Reference;
import soupbubbles.minecraftboom.tileentity.TileEntityCraftingTable;

public class ModBlocks
{
    public static final Set<Block> BLOCKS = new HashSet<>();

    public static final Block BLOCK_BOOKSHELF;

    public static final Block BLOCK_COBBLESTONE_BRICKS;
    public static final Block BLOCK_MOSSY_COBBLESTONE_BRICKS;
    public static final Block BLOCK_HARDENED_CLAY_BRICKS;
    public static final Block BLOCK_STAINED_CLAY_BRICKS;

    public static final Block BLOCK_POLISHED;

    public static final Block BLOCK_CHARCOAL;
    public static final Block BLOCK_SUGAR;
    public static final Block BLOCK_SUGAR_CANE;
    public static final Block BLOCK_GUNPOWDER;
    public static final Block BLOCK_BLAZE_POWDER;
    public static final Block BLOCK_MAGMA_CREAM;
    public static final Block BLOCK_PRISMARINE_CRYSTAL;
    public static final Block BLOCK_CHARRED_BONE;
    public static final Block BLOCK_DYE;

    public static final Block BLOCK_SOUL_GLASS;
    public static final Block BLOCK_STAINED_SOUL_GLASS;
    
    public static final Block BLOCK_PILLAR_SMOOTH_GRANITE;
    public static final Block BLOCK_PILLAR_SMOOTH_DIORITE;
    public static final Block BLOCK_PILLAR_SMOOTH_ANDESITE;
    public static final Block BLOCK_PILLAR_SMOOTH_PRISMARINE;
    public static final Block BLOCK_PILLAR_SMOOTH_DARK_PRISMARINE;
    public static final Block BLOCK_PILLAR_SMOOTH_END_STONE;
    public static final Block BLOCK_PILLAR_SMOOTH_NETHERRACK;

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

    public static final Block BLOCK_GOLDEN_BARS;
    
    public static final Block BLOCK_CRAFTING_TABLE;
    public static final Block BLOCK_PUMPKIN;
    public static final Block BLOCK_WOOL;

    static
    {
        BLOCK_BOOKSHELF = new BlockBookShelf();
        registerBlockMeta(BLOCK_BOOKSHELF, new ItemBlockMeta(BLOCK_BOOKSHELF, Names.BLOCK_BOOKSHELF));

        BLOCK_COBBLESTONE_BRICKS = registerBlock(new BlockBase(Names.BLOCK_COBBELSTONE_BRICKS));
        BLOCK_MOSSY_COBBLESTONE_BRICKS = registerBlock(new BlockBase(Names.BLOCK_MOSSY_COBBELSTONE_BRICKS));
        BLOCK_HARDENED_CLAY_BRICKS = registerBlock(new BlockBase(Names.BLOCK_HARDENED_CLAY_BRICKS));
        BLOCK_STAINED_CLAY_BRICKS = new BlockColoredBase(Names.BLOCK_STAINED_HARDENED_CLAY_BRICKS);
        registerBlockMeta(BLOCK_STAINED_CLAY_BRICKS, new ItemBlockMeta(BLOCK_STAINED_CLAY_BRICKS, Names.BLOCK_STAINED_HARDENED_CLAY_BRICKS));

        BLOCK_POLISHED = new BlockPolished();
        registerBlockMeta(BLOCK_POLISHED);

        BLOCK_CHARCOAL =  registerBlock(new BlockBase(Material.ROCK, Names.BLOCK_CHARCOAL, SoundType.STONE).setHardness(0.1F));
        BLOCK_SUGAR = registerBlock(new BlockFallingBase(Names.BLOCK_SUGAR).setHardness(0.1F));
        BLOCK_SUGAR_CANE =  registerBlock(new BlockPillarBase(Material.LEAVES, Names.BLOCK_SUGAR_CANE, SoundType.PLANT).setHardness(0.1F));
        BLOCK_GUNPOWDER =  registerBlock(new BlockGunpowder().setHardness(0.1F));
        BLOCK_BLAZE_POWDER =  registerBlock(new BlockFallingBase(Names.BLOCK_BLAZE_POWDER, SoundType.SNOW).setHardness(0.1F));
        BLOCK_MAGMA_CREAM = registerBlock(new BlockMagmaCream().setHardness(0.1F));
        BLOCK_PRISMARINE_CRYSTAL = registerBlock(new BlockBase(Material.GROUND, Names.BLOCK_PRISMARINE_CRYSTAL, SoundType.GLASS).setHardness(0.1F).setLightLevel(0.2F));
        BLOCK_CHARRED_BONE = registerBlock(new BlockPillarBase(Names.BLOCK_CHARRED_BONE)).setHardness(2.0F);
        BLOCK_DYE = new BlockDye().setHardness(0.1F);
        registerBlockMeta(BLOCK_DYE, new ItemBlockMeta(BLOCK_DYE, Names.BLOCK_DYE));
        
        BLOCK_SOUL_GLASS = registerBlock(new BlockSoulGlass());
        BLOCK_STAINED_SOUL_GLASS = new BlockStainedSoulGlass();
        registerBlockMeta(BLOCK_STAINED_SOUL_GLASS, new ItemBlockMeta(BLOCK_STAINED_SOUL_GLASS, Names.BLOCK_STAINED_SOUL_GLASS));
        
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
        BLOCK_STAIRS_SMOOTH_PRISMARINE = registerBlock(new BlockStairBase(BLOCK_POLISHED.getDefaultState().withProperty(BlockPolished.VARIANT, BlockPolished.EnumType.SMOOTH_PRISMARINE), Names.BLOCK_SMOOTH_PRISMARINE));
        BLOCK_STAIRS_SMOOTH_DARK_PRISMARINE = registerBlock(new BlockStairBase(BLOCK_POLISHED.getDefaultState().withProperty(BlockPolished.VARIANT, BlockPolished.EnumType.SMOOTH_DARK_PRISMARINE), Names.BLOCK_SMOOTH_DARK_PRISMARINE));
        BLOCK_STAIRS_SMOOTH_END_STONE = registerBlock(new BlockStairBase(BLOCK_POLISHED.getDefaultState().withProperty(BlockPolished.VARIANT, BlockPolished.EnumType.SMOOTH_END_STONE), Names.BLOCK_SMOOTH_END_STONE));
        BLOCK_STAIRS_SMOOTH_NETHERRACK = registerBlock(new BlockStairBase(BLOCK_POLISHED.getDefaultState().withProperty(BlockPolished.VARIANT, BlockPolished.EnumType.SMOOTH_NETHERRACK), Names.BLOCK_SMOOTH_NETHERRACK));

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

        BLOCK_GOLDEN_BARS = registerBlock(new BlockGoldenBars());
        
        if (ConfigurationHandler.Settings.replaceCraftingTable)
        {
            BLOCK_CRAFTING_TABLE = replaceBlock(new BlockCraftingTable(), Names.BLOCK_CRAFTING_TABLE);
        }
        else 
        {
            BLOCK_CRAFTING_TABLE = (BlockWorkbench) Blocks.CRAFTING_TABLE;
        }
        
        if (ConfigurationHandler.Settings.replacePumpkin)
        {
            BLOCK_PUMPKIN = new BlockNewPumpkin();
            replaceBlock(BLOCK_PUMPKIN, Names.PUMPKIN);
        }
        else 
        {
            BLOCK_PUMPKIN = (BlockPumpkin) Blocks.PUMPKIN;
        }
        
        if (ConfigurationHandler.Settings.replaceWool)
        {
            BLOCK_WOOL = replaceBlock(new BlockWool(), Names.WOOL);
        }
        else
        {
            BLOCK_WOOL = (BlockColored) Blocks.WOOL;
        }
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

    protected static <BLOCK extends Block> BLOCK replaceBlock(BLOCK block, String name)
    {
        if (block.getRegistryName() == null)
        {
            block.setRegistryName(name);
        }
        try
        {
            GameRegistry.addSubstitutionAlias("minecraft:" + name, GameRegistry.Type.BLOCK, block);
            
            if (block == BLOCK_PUMPKIN)
            {
                GameRegistry.addSubstitutionAlias("minecraft:" + name, GameRegistry.Type.ITEM, new ItemBlockMeta(block, Names.BLOCK_PUMPKIN));
                BLOCKS.add(block);
            }
//          else
//          {
//              GameRegistry.addSubstitutionAlias("minecraft:" + name, GameRegistry.Type.ITEM, new ItemBlock(block).setRegistryName(name));
//          }
        }
        catch (ExistingSubstitutionException e)
        {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

        return block;
    }
}
