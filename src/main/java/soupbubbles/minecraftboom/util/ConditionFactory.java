package soupbubbles.minecraftboom.util;

import java.util.function.BooleanSupplier;

import com.google.gson.JsonObject;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.util.JsonUtils;
import net.minecraftforge.common.crafting.IConditionFactory;
import net.minecraftforge.common.crafting.JsonContext;
import soupbubbles.minecraftboom.init.ModBlocks;
import soupbubbles.minecraftboom.init.ModItems;
import soupbubbles.minecraftboom.reference.Assets;

public class ConditionFactory implements IConditionFactory
{
    @Override
    public BooleanSupplier parse(JsonContext context, JsonObject json)
    {
        boolean value = JsonUtils.getBoolean(json, "value", true);
        String key = JsonUtils.getString(json, "type");

        for (Item item: ModItems.ITEMS)
        {
            if (key.equals(Assets.TEXTURE_PREFIX + item.getUnlocalizedName().replace("item.", "")))
            {
                return () -> Utils.isItemEnabled(item) == value;
            }
        }
        
        for (Block block: ModBlocks.BLOCKS)
        {
            if (key.equals(Assets.TEXTURE_PREFIX + block.getUnlocalizedName().replace("tile.minecraftboom", "")))
            {
                return () -> Utils.isBlockEnabled(block) == value;
            }
        }
        
        return null;
    }
}