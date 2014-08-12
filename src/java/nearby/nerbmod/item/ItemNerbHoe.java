package nearby.nerbmod.item;

import nearby.nerbmod.common.NerbMod;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemHoe;

public class ItemNerbHoe extends ItemHoe {

	public ItemNerbHoe(int par1, EnumToolMaterial par2EnumToolMaterial) {
		super(par1, par2EnumToolMaterial);
		this.setCreativeTab(NerbMod.TabNerb);
	}
	public void registerIcons(IconRegister iconRegister) {
		itemIcon = iconRegister.registerIcon("nerbmod:NerbHoe");
		
	}

}
