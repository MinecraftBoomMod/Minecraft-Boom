package soupbubbles.minecraftboom.entity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import soupbubbles.minecraftboom.init.ModItems;

public class EntityPrismarineArrow extends EntityArrow
{
    public EntityPrismarineArrow(World world)
    {
        super(world);
    }

    public EntityPrismarineArrow(World world, double x, double y, double z)
    {
        super(world, x, y, z);
    }

    public EntityPrismarineArrow(World world, EntityLivingBase shooter)
    {
        super(world, shooter);
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