package nearby.nerbmod.plant;

import nearby.nerbmod.common.NerbMod;
import net.minecraft.block.BlockCrops;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.util.Icon;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockSalt extends BlockCrops {

	@SideOnly(Side.CLIENT)
	private Icon[] iconArray;
	
	public BlockSalt(int par1) {
		super(par1);
	}
	
	@SideOnly(Side.CLIENT)
	public Icon getIcon(int side, int metadata){
		if(metadata < 7){
			if(metadata == 6){
				metadata = 5;
			}
			return iconArray[metadata >> 1];
		}
		return iconArray[3];
	}
	public int getSeedItem(){
		return NerbMod.itemSalt.itemID;
	}
	public int getCropItem(){
		return NerbMod.itemSalt.itemID;
	}
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister iconRegister){
		this.iconArray = new Icon[4];
		
		for(int i = 0; i < this.iconArray.length; i++){
			this.iconArray[i] = iconRegister.registerIcon("nerbmod:SaltPlant_" + (i+1));
			
		}
		
	}

}
