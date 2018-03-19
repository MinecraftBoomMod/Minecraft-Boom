package soupbubbles.minecraftboom.entity;

import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.monster.EntitySlime;
import net.minecraft.init.Blocks;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.world.World;

public class EntityNewSlime extends EntitySlime
{
    public EntityNewSlime(World world)
    {
        super(world);
    }

    @Override
    public boolean canPickUpLoot()
    {
        return !isSmallSlime();
    }
}
