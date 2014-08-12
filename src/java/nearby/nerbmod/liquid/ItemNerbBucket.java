package nearby.nerbmod.liquid;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import nearby.nerbmod.common.NerbMod;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.ItemBucket;
import net.minecraft.world.World;

public class ItemNerbBucket extends ItemBucket {

	private int liquidID;
	
	
	public ItemNerbBucket(int itemID, int liquidID) {
		super(itemID, liquidID);

		this.setCreativeTab(NerbMod.TabNerb);
		this.liquidID = liquidID;
	}

	public boolean tryPlaceContainedLiquid(World world,int x, int y, int z){
		if(liquidID <= 0){
			return false;
		}else if(!world.isAirBlock(x, y, z) && world.getBlockMaterial(x, y, z).isSolid()){
			return false;
		}else{
			world.setBlock(x, y, z, liquidID, 0, 3);
			return true;
		}
	}
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister iconRegister) {
		itemIcon = iconRegister.registerIcon("nerbmod:nerbJuiceBucket");

	}
}
