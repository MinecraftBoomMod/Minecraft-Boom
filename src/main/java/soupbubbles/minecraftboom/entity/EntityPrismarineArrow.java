package soupbubbles.minecraftboom.entity;

import java.util.List;

import javax.annotation.Nullable;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.MoverType;
import net.minecraft.entity.item.EntityBoat;
import net.minecraft.entity.monster.EntityBlaze;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.entity.monster.EntityMagmaCube;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.init.Enchantments;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.network.play.server.SPacketChangeGameState;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EntityDamageSourceIndirect;
import net.minecraft.util.EntitySelectors;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.datafix.DataFixer;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import soupbubbles.minecraftboom.init.ModItems;

public class EntityPrismarineArrow extends EntityArrow
{
    public EntityPrismarineArrow(World worldIn)
    {
        super(worldIn);
    }

    public EntityPrismarineArrow(World worldIn, double x, double y, double z)
    {
    	super(worldIn, x, y, z);
    }

    public EntityPrismarineArrow(World worldIn, EntityLivingBase shooter)
    {
    	super(worldIn, shooter);
    }

    @Override
    protected void onHit(RayTraceResult raytrace)
    {
        Entity entity = raytrace.entityHit;
        
        if (entity != null && entity.isImmuneToFire())
        {
        	setDamage(getDamage() * 1.1F);
        }
        
        super.onHit(raytrace);
    }
    
    @Override
    public void onUpdate()
    {
    	if (!inGround && inWater)
    	{
    		for (int i = 0; i < 4; ++i)
            {
                float f3 = 0.25F;
                world.spawnParticle(EnumParticleTypes.WATER_BUBBLE, posX - motionX * 0.25D, posY - motionY * 0.25D, posZ - motionZ * 0.25D, motionX, motionY, motionZ, new int[0]);
            }
    	}
    	 
    	super.onUpdate();
    }
    
    @Override
    public boolean isInWater()
    {
        return false;
    }

    @Override
    protected ItemStack getArrowStack()
    {
    	return new ItemStack(ModItems.ITEM_PRISMARINE_ARROW);
    }
}