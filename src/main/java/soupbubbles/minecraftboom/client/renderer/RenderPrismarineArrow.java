package soupbubbles.minecraftboom.client.renderer;

import net.minecraft.client.renderer.entity.RenderArrow;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import soupbubbles.minecraftboom.reference.Assets;
import soupbubbles.minecraftboom.reference.Reference;

public class RenderPrismarineArrow extends RenderArrow
{
	public RenderPrismarineArrow(RenderManager renderManager) 
	{
		super(renderManager);
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity entity) 
	{
		return new ResourceLocation(Reference.MOD_ID, Assets.TEXTURE_ENTITY_DIR + "prismarine_arrow.png");
	}
}
