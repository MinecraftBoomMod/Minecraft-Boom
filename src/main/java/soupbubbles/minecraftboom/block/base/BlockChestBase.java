package soupbubbles.minecraftboom.block.base;

import net.minecraft.block.BlockChest;
import net.minecraft.block.BlockChest.Type;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import soupbubbles.minecraftboom.creativetab.CreativeTab;
import soupbubbles.minecraftboom.reference.Assets;
import soupbubbles.minecraftboom.reference.Names;
import soupbubbles.minecraftboom.tileentity.TileEntityChestBase;

public class BlockChestBase extends BlockContainer
{
    protected final BlockChestBase.ChestType chestType;

    public BlockChestBase(ChestType type)
    {
        super(Material.WOOD);
        setRegistryName(type.getName());
        setUnlocalizedName(type.getName());
        setCreativeTab(CreativeTab.MINECRAFTBOOM_DECORATION_ITEM_TAB);
        
        chestType = type;
    }

    @Override
    public String getUnlocalizedName()
    {
        return String.format(Assets.BLOCK_PREFIX, Assets.ASSET_PREFIX, chestType.getName());
    }
    
    @Override
    public TileEntity createNewTileEntity(World world, int meta)
    {
        return chestType.getTileEntity();
    }
    
    public BlockChestBase.ChestType getType()
    {
        return chestType;
    }
    
    public static enum ChestType
    {
        SPRUCE_BASIC(Names.BLOCK_SPRUCE_CHEST, new TileEntityChestBase(), Type.BASIC),
        BIRCH_BASIC(Names.BLOCK_BIRCH_CHEST, new TileEntityChestBase(), Type.BASIC),
        JUNGLE_BASIC(Names.BLOCK_JUNGLE_CHEST, new TileEntityChestBase(), Type.BASIC),
        ACACIA_BASIC(Names.BLOCK_ACACIA_CHEST, new TileEntityChestBase(), Type.BASIC),
        DARK_OAK_BASIC(Names.BLOCK_DARK_OAK_CHEST, new TileEntityChestBase(), Type.BASIC),
        SPRUCE_TRAPPED(Names.BLOCK_TRAPPED_SPRUCE_CHEST, new TileEntityChestBase(), Type.TRAP),
        BIRCH_TRAPPED(Names.BLOCK_TRAPPED_BIRCH_CHEST, new TileEntityChestBase(), Type.TRAP),
        JUNGLE_TRAPPED(Names.BLOCK_TRAPPED_JUNGLE_CHEST, new TileEntityChestBase(), Type.TRAP),
        ACACIA_TRAPPED(Names.BLOCK_TRAPPED_ACACIA_CHEST, new TileEntityChestBase(), Type.TRAP),
        DARK_OAK_TRAPPED(Names.BLOCK_TRAPPED_DARK_OAK_CHEST, new TileEntityChestBase(), Type.TRAP);
        
        private String name;
        private TileEntity tile;
        private Type type;
        private ResourceLocation texture;

        private ChestType (String chestName, TileEntity tileEntity, BlockChest.Type chestType)
        {
            name = chestName;
            tile = tileEntity;
            type = chestType;
            texture = new ResourceLocation(Assets.ASSET_PREFIX, Assets.TEXTURE_CHEST_DIR + chestName + Assets.PNG);
        }
        
        public String getName()
        {
            return name;
        }
        
        public TileEntity getTileEntity()
        {
            return tile;
        }
        
        public BlockChest.Type getType()
        {
            return type;
        }
        
        public ResourceLocation getResourceLocation()
        {
            return texture;
        }
    }
}
