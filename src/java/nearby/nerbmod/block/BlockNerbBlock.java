package nearby.nerbmod.block;

import java.util.Random;

import nearby.nerbmod.common.NerbMod;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;

public class BlockNerbBlock extends Block {

	public BlockNerbBlock(int par1, Material par2Material) {
		super(par1, par2Material);
		this.setCreativeTab(NerbMod.TabNerb);
		this.setLightValue(0.0F);
		this.setHardness(4);
		this.setResistance(10);
	}
	public void registerIcons(IconRegister iconRegister) {
		blockIcon = iconRegister.registerIcon("nerbmod:NerbBlock");
	}
	public int idDropped(int par1, Random par2Random, int par3) {
		return NerbMod.NerbOre.itemID;
	}
	public int quantityDropped(Random par1Random) {
		return 3;
	}
}
