package nearby.nerbmod.creativetab;

import nearby.nerbmod.common.NerbMod;
import net.minecraft.creativetab.CreativeTabs;

public class CreativeTabNerb extends CreativeTabs{

	public CreativeTabNerb(int par1, String par2Str) {
		super(par1, par2Str);
		
	}
	public int getTabIconItemIndex() {
		return NerbMod.NerbGreatSword.itemID;
		
	}
	public String getTranslatedTabLabel() {
		return "Nerb Mod";
	}

}
