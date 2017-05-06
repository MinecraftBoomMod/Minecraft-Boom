package soupbubbles.minecraftboom.entity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class EntityGrenade extends EntityThrowable
{

    public EntityGrenade(World worldIn)
    {
        super(worldIn);
    }

    public EntityGrenade(World worldIn, EntityLivingBase throwerIn)
    {
        super(worldIn, throwerIn);
    }

    public EntityGrenade(World worldIn, double x, double y, double z)
    {
        super(worldIn, x, y, z);
    }

    protected void onImpact(RayTraceResult result)
    {
        if (!world.isRemote)
        {
            world.createExplosion(getThrower(), posX, posY, posZ, 0.2F, true);
            world.setEntityState(this, (byte) 3);
            setDead();
        }
    }
}
