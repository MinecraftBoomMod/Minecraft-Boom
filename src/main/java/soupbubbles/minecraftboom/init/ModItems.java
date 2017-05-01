package soupbubbles.minecraftboom.init;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameRegistry;
import soupbubbles.minecraftboom.creativetab.CreativeTab;
import soupbubbles.minecraftboom.item.base.ItemBasic;
import soupbubbles.minecraftboom.reference.Reference;

public class ModItems {
	/*
    public static final Set<Item> ITEMS = new HashSet<>();

    static
    {
    }

    public static void registerItems()
    {
    }

    private static <T extends Item> T registerItem(T item)
    {
        GameRegistry.register(item);
        ITEMS.add(item);

        return item;
    }
    */
	
	public static Item elderGuardianSpike; 
	
	public static void init() {
		elderGuardianSpike = new ItemBasic("elder_guardian_spike");
	}
	
	public static void register() {
		registerItem(elderGuardianSpike);
	}
	
	public static void registerRenders() {
		registerRender(elderGuardianSpike);
	}
	
	public static void registerItem(Item item) {
		item.setCreativeTab(CreativeTab.MINECRAFTBOOM_TAB);
		GameRegistry.register(item);
	}
	
	public static void registerRender(Item item) {
		ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(new ResourceLocation(Reference.MOD_ID, item.getUnlocalizedName().substring(5)), "inventory"));
	}
	
}
