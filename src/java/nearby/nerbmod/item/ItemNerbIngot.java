package nearby.nerbmod.item;

import nearby.nerbmod.common.NerbMod;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemNerbIngot extends Item {

	public ItemNerbIngot(int par1) {
		super(par1);
		this.setCreativeTab(NerbMod.TabNerb);
	}
	public void registerIcons(IconRegister iconRegister) {
		itemIcon = iconRegister.registerIcon("nerbmod:NerbIngot");
		
	}

}