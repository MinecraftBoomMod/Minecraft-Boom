package soupbubbles.minecraftboom.entity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntitySnowball;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class EntityGrenade extends EntitySnowball {

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
        
        this.world.newExplosion((Entity)null, this.posX, this.posY, this.posZ, 2.0F, false, false);

        if (!this.world.isRemote)
        {
            this.world.setEntityState(this, (byte)3);
            this.setDead();
        }
    }


}
