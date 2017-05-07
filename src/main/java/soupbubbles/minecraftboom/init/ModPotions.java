package soupbubbles.minecraftboom.init;

import java.awt.Color;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import soupbubbles.minecraftboom.reference.Assets;
import soupbubbles.minecraftboom.reference.Names;
import soupbubbles.minecraftboom.reference.Reference;

public class ModPotions
{
    public static final Potion LEVITATION;

    static
    {
        LEVITATION = registerPotion(new NewPotion(false, 0, Names.POTION_LEVITATION));
    }

    public static void init()
    {
    }

    private static <POTION extends Potion> POTION registerPotion(POTION potion)
    {
        return GameRegistry.register(potion);
    }

    public static class NewPotion extends Potion
    {
        private final ResourceLocation iconTexture;

        public NewPotion(boolean isBadEffect, int liquidColor, String name)
        {
            super(isBadEffect, liquidColor);
            setPotionName(this, name);
            iconTexture = new ResourceLocation(Reference.MOD_ID, Assets.TEXTURE_POTIONS_DIR + name + Assets.PNG);
        }

        public NewPotion(boolean isBadEffect, int liquidR, int liquidG, int liquidB, String name)
        {
            this(isBadEffect, new Color(liquidR, liquidG, liquidB).getRGB(), name);
        }

        public Potion setPotionName(Potion potion, String name)
        {
            potion.setRegistryName(name);
            potion.setPotionName("effect." + Reference.MOD_ID + "." + name + ".name");
            return this;
        }

        @Override
        public boolean hasStatusIcon()
        {
            return false;
        }

        @SideOnly(Side.CLIENT)
        @Override
        public void renderInventoryEffect(int x, int y, PotionEffect effect, Minecraft mc)
        {
            if (mc.currentScreen != null)
            {
                mc.getTextureManager().bindTexture(iconTexture);
                Gui.drawModalRectWithCustomSizedTexture(x + 6, y + 7, 0, 0, 18, 18, 18, 18);
            }
        }

        @SideOnly(Side.CLIENT)
        @Override
        public void renderHUDEffect(int x, int y, PotionEffect effect, Minecraft mc, float alpha)
        {
            mc.getTextureManager().bindTexture(iconTexture);
            Gui.drawModalRectWithCustomSizedTexture(x + 3, y + 3, 0, 0, 18, 18, 18, 18);
        }
    }
}
