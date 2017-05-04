package soupbubbles.minecraftboom.block;

import java.util.List;
import java.util.Random;

import net.minecraft.block.BlockPumpkin;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemShears;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import soupbubbles.minecraftboom.block.base.IBlockMeta;
import soupbubbles.minecraftboom.creativetab.CreativeTab;
import soupbubbles.minecraftboom.init.ModBlocks;
import soupbubbles.minecraftboom.init.ModItems;
import soupbubbles.minecraftboom.reference.Assets;
import soupbubbles.minecraftboom.reference.Names;

public class BlockNewPumpkin extends BlockPumpkin implements IBlockMeta
{
    protected static final PropertyEnum<BlockNewPumpkin.EnumType> VARIANT = PropertyEnum.<BlockNewPumpkin.EnumType>create("variant", BlockNewPumpkin.EnumType.class);

    protected final String BASE_NAME = Names.BLOCK_PUMPKIN;

    public BlockNewPumpkin()
    {
        super();
        setDefaultState(blockState.getBaseState().withProperty(VARIANT, BlockNewPumpkin.EnumType.DEFAULT).withProperty(FACING, EnumFacing.NORTH));
        setRegistryName(BASE_NAME);
        setUnlocalizedName(BASE_NAME);
        setHardness(1.0F);
        setSoundType(SoundType.WOOD);
    }

    @Override
    public String getUnlocalizedName()
    {
        return getSpecialName(BlockNewPumpkin.EnumType.DEFAULT.getMetadata());
    }

    @Override
    public String getSpecialName(int meta)
    {
        return String.format(Assets.BLOCK_PREFIX, Assets.ASSET_PREFIX, BlockNewPumpkin.EnumType.byMetadata(meta).getName());
    }
    
    @Override
    public void onBlockAdded(World world, BlockPos pos, IBlockState state)
    {
        if (getMetaFromState(state) == BlockNewPumpkin.EnumType.CARVED.getMetadata())
        {
            super.onBlockAdded(world, pos, state);
        }
    }
    
    @Override
    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
    {
        if (getMetaFromState(state) == BlockNewPumpkin.EnumType.DEFAULT.getMetadata())
        {
            ItemStack stack = player.getHeldItem(hand);
            
            if (stack != null && stack.getItem() instanceof ItemShears)
            {
                if (facing == EnumFacing.UP || facing == EnumFacing.DOWN)
                {
                    facing = player.getHorizontalFacing().getOpposite();
                }
                
                world.setBlockState(pos, state.withProperty(VARIANT, BlockNewPumpkin.EnumType.CARVED).withProperty(FACING, facing));
                stack.damageItem(1, player);
            }
        }
        
        return true;
    }
    
    @Override
    public Item getItemDropped(IBlockState state, Random rand, int fortune)
    {
        return ModItems.ITEM_PUMPKIN_SLICE;
    }
    
    @Override
    public int damageDropped(IBlockState state)
    {
        return state.getValue(VARIANT).getMetadata();
    }
    
    @Override
    public int quantityDropped(Random random)
    {
        return 3 + random.nextInt(5);
    }
    
    @Override
    public int quantityDroppedWithBonus(int fortune, Random random)
    {
        return Math.min(9, quantityDropped(random) + random.nextInt(1 + fortune));
    }
    
    @Override
    public List<ItemStack> getDrops(IBlockAccess world, BlockPos pos, IBlockState state, int fortune)
    {
        if (getMetaFromState(state) == BlockNewPumpkin.EnumType.CARVED.getMetadata())
        {
            List<ItemStack> ret = new java.util.ArrayList<ItemStack>();
            ret.add(new ItemStack(this, 1, getMetaFromState(state)));
            
            return ret;
        }
        
        return super.getDrops(world, pos, state, fortune);
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void getSubBlocks(Item itemIn, CreativeTabs tab, NonNullList<ItemStack> list)
    {
        for (BlockNewPumpkin.EnumType blockpumpkin$enumtype : BlockNewPumpkin.EnumType.values())
        {
            list.add(new ItemStack(itemIn, 1, blockpumpkin$enumtype.getMetadata()));
        }
    }
    
    @Override
    public IBlockState getStateForPlacement(World world, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer, EnumHand hand)
    {
        return super.getStateForPlacement(world, pos, facing, hitX, hitY, hitZ, meta, placer).withProperty(VARIANT, BlockNewPumpkin.EnumType.byMetadata(placer.getHeldItem(hand).getItemDamage()));
    }

    @Override
    public IBlockState getStateFromMeta(int meta)
    {
        return getDefaultState().withProperty(VARIANT, BlockNewPumpkin.EnumType.byMetadata(meta));
    }

    @Override
    public int getMetaFromState(IBlockState state)
    {
        return state.getValue(VARIANT).getMetadata();
    }

    @Override
    protected BlockStateContainer createBlockState()
    {
        return new BlockStateContainer(this, new IProperty[] {FACING, VARIANT});
    }

    @Override
    public PropertyEnum getVariants()
    {
        return VARIANT;
    }

    public static enum EnumType implements IStringSerializable
    {
        DEFAULT(0, Names.BLOCK_PUMPKIN), 
        CARVED(1, "carved_" + Names.BLOCK_PUMPKIN);

        private static final BlockNewPumpkin.EnumType[] META_LOOKUP = new BlockNewPumpkin.EnumType[values().length];

        private final int meta;
        private final String name;

        private EnumType(int damage, String blockName)
        {
            meta = damage;
            name = blockName;
        }

        public int getMetadata()
        {
            return meta;
        }

        @Override
        public String toString()
        {
            return name;
        }

        public static BlockNewPumpkin.EnumType byMetadata(int meta)
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
            for (BlockNewPumpkin.EnumType blockpumpkin$enumtype : values())
            {
                META_LOOKUP[blockpumpkin$enumtype.getMetadata()] = blockpumpkin$enumtype;
            }
        }
    }
}
