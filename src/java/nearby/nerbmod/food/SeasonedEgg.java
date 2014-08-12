package nearby.nerbmod.food;

import nearby.nerbmod.common.NerbMod;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;

public class SeasonedEgg extends Item{
	public SeasonedEgg(int par1) {
		super(par1);
		this.setCreativeTab(NerbMod.TabNerb);
	}
	public void registerIcons(IconRegister iconRegister) {
		itemIcon = iconRegister.registerIcon("nerbmod:SeasonedEgg");
		
	}

}



