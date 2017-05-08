package soupbubbles.minecraftboom.entity;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class EntityGrenade extends EntityThrowable
{

    public EntityGrenade(World world)
    {
        super(world);
    }

    public EntityGrenade(World world, EntityLivingBase thrower)
    {
        super(world, thrower);
    }

    public EntityGrenade(World world, double x, double y, double z)
    {
        super(world, x, y, z);
    }

    @Override
    protected void onImpact(RayTraceResult result)
    {
        if (!world.isRemote)
        {
            world.createExplosion(this, posX, posY, posZ, 2F, false);
            world.setEntityState(this, (byte) 3);
            setDead();
        }
    }
}
