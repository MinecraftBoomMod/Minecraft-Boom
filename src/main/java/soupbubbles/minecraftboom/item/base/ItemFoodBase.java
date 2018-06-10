package soupbubbles.minecraftboom.item.base;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import net.minecraftforge.common.config.Property;
import soupbubbles.minecraftboom.creativetab.CreativeTab;
import soupbubbles.minecraftboom.handler.ConfigurationHandler;
import soupbubbles.minecraftboom.reference.Assets;
import soupbubbles.minecraftboom.util.IDisableable;

public class ItemFoodBase extends ItemFood implements IDisableable
{
    private PotionEffect[] effects;
    private final String BASE_NAME;

    public ItemFoodBase(String name, int amount, boolean isWolfFood, PotionEffect... potionEffects)
    {
        this(name, amount, 0.6F, isWolfFood, potionEffects);
    }

    public ItemFoodBase(String name, int amount, float saturation, boolean isWolfFood, PotionEffect... potionEffects)
    {
        super(amount, saturation, isWolfFood);
        setRegistryName(name);
        setUnlocalizedName(name);
        setCreativeTab(CreativeTab.MINECRAFTBOOM_TAB);

        BASE_NAME = name;
        effects = potionEffects;
    }

    @Override
    public String getUnlocalizedName(ItemStack stack)
    {
        return String.format(Assets.ITEM_PREFIX, Assets.ASSET_PREFIX, BASE_NAME);
    }

    @Override
    protected void onFoodEaten(ItemStack stack, World world, EntityPlayer player)
    {
        super.onFoodEaten(stack, world, player);

        for (PotionEffect effect : effects)
        {
            player.addPotionEffect(effect);
        }
    }

    @Override
    public void registerConfig()
    {
        ConfigurationHandler.allowedItems.add(ConfigurationHandler.loadPropBool(getUnlocalizedName().replace("item.", ""), ConfigurationHandler.CATEGORY_ITEMS, "", true));
        ConfigurationHandler.saveConfiguration();
    }

    @Override
    public boolean isEnabled()
    {
        return ConfigurationHandler.configuration.get(ConfigurationHandler.CATEGORY_ITEMS + "." + BASE_NAME, BASE_NAME, true).getBoolean();
    }
}
