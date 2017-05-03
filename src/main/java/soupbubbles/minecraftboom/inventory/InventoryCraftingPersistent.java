package soupbubbles.minecraftboom.inventory;

import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.ItemStack;

public class InventoryCraftingPersistent extends InventoryCrafting
{

    private final int length;
    private final Container eventHandler;
    private final IInventory parent;

    public InventoryCraftingPersistent(Container eventHandler, IInventory parent, int width, int height)
    {
        super(eventHandler, width, height);
        int k = width * height;

        assert (k == parent.getSizeInventory());

        this.parent = parent;
        length = k;
        this.eventHandler = eventHandler;
    }

    @Override
    public int getSizeInventory()
    {
        return length;
    }

    @Override
    public ItemStack getStackInSlot(int index)
    {
        return index >= getSizeInventory() ? null : parent.getStackInSlot(index);
    }

    public String getCommandSenderName()
    {
        return "container.crafting";
    }

    @Override
    public boolean hasCustomName()
    {
        return false;
    }

    public ItemStack getStackInSlotOnClosing(int index)
    {
        return null;
    }

    @Override
    public ItemStack decrStackSize(int index, int count)
    {
        if (getStackInSlot(index) != null)
        {
            ItemStack itemstack;

            if (getStackInSlot(index).getCount() <= count)
            {
                itemstack = getStackInSlot(index);
                setInventorySlotContents(index, ItemStack.EMPTY);
                eventHandler.onCraftMatrixChanged(this);
                return itemstack;
            }
            else
            {
                itemstack = getStackInSlot(index).splitStack(count);

                if (getStackInSlot(index).getCount() == 0)
                {
                    setInventorySlotContents(index, ItemStack.EMPTY);
                }

                eventHandler.onCraftMatrixChanged(this);
                return itemstack;
            }
        }
        else
        {
            return null;
        }
    }

    @Override
    public void setInventorySlotContents(int index, ItemStack stack)
    {
        parent.setInventorySlotContents(index, stack);
        eventHandler.onCraftMatrixChanged(this);
    }

    @Override
    public void markDirty()
    {
        parent.markDirty();
        eventHandler.onCraftMatrixChanged(this);
    }

    @Override
    public void clear()
    {
    }
}