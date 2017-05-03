package soupbubbles.minecraftboom.block;

import net.minecraft.block.properties.PropertyEnum;
import soupbubbles.minecraftboom.block.base.BlockBase;
import soupbubbles.minecraftboom.block.base.IBlockMeta;

public class BlockBookshelves extends BlockBase implements IBlockMeta {

	public BlockBookshelves(String name) {
		super(name);
		setHardness(2.0F);
		setResistance(10.0F);
	}

	@Override
	public String getSpecialName(int meta) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PropertyEnum getVariants() {
		// TODO Auto-generated method stub
		return null;
	}

}
