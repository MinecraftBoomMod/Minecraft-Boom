package soupbubbles.minecraftboom.init;

import java.util.HashSet;
import java.util.Set;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameRegistry;
import soupbubbles.minecraftboom.creativetab.CreativeTab;
import soupbubbles.minecraftboom.item.base.ItemBase;
import soupbubbles.minecraftboom.item.base.ItemBasic;
import soupbubbles.minecraftboom.reference.Names;
import soupbubbles.minecraftboom.reference.Reference;

public class ModItems
{
	//The list of all items in our mod
    public static final Set<Item> ITEMS = new HashSet<>();

    //Our item object, notice that it is final so you can't change the item
    //The name of the object should be in ALL CAPS since it is final
    //This is pretty much how vanilla does it too
    public static final Item ELDER_GUARDIAN_SPIKE; 
    
    //public static final Item ITEM_WITH_SUBITEMS; 

    //The static initializer
    //Here is where we create the objects for out mod items
    static
    {
        //We set the item to the return of the registerItem method
        //This will be the item we give as a parameter to the registerItem method
        //The ItemBase class was previously abstract, I've changed that
        //All ItemBase takes is the unlocalized item name which we set in the Names class
        
        ELDER_GUARDIAN_SPIKE = registerItem(new ItemBase(Names.ITEM_ELDER_GUARDIAN_SPIKE));
        
        //A item with subitems (just for demonstration)
        //This will add 4 new items to the game
        //ITEM_WITH_SUBITEMS = registerItem(new ItemBase("red", "yellow", "green", "blue"));
    }

    //Method to make sure that the static initializer runs
    public static void registerItems()
    {
    }

    //A method for registering our items
    //It registers them with GameRegistry and then adds the item to the list of all our mod items
    //Finally it returns our item
    private static <T extends Item> T registerItem(T item)
    {
        GameRegistry.register(item);
        ITEMS.add(item);

        return item;
    }
    
    /**
     * Old Methods
     * There if we want to keep them
     */
    
    /*
	public static void init() {
		elderGuardianSpike = new ItemBasic();
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
	*/
}
