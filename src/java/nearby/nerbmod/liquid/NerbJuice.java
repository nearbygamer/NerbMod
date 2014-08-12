package nearby.nerbmod.liquid;


import nearby.nerbmod.common.NerbMod;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fluids.BlockFluidClassic;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class NerbJuice extends BlockFluidClassic{

@SideOnly(Side.CLIENT)
protected Icon stillIcon;
@SideOnly(Side.CLIENT)
protected Icon flowingIcon;
    
	public NerbJuice(int id) {
		super(id, NerbMod.fluidNerb, Material.water);
		this.setCreativeTab(NerbMod.TabNerb);
		this.setLightValue(1.0F);
		this.setDensity(1500);
		}
	
@Override
     public Icon getIcon(int side, int meta) {
             return (side == 0 || side == 1)? stillIcon : flowingIcon;
     }
     
@SideOnly(Side.CLIENT)
@Override
     public void registerIcons(IconRegister register) {
             stillIcon = register.registerIcon("nerbmod:NerbJuice");
             flowingIcon = register.registerIcon("nerbmod:NerbJuiceFlowing");
     }
     
@Override
     public boolean canDisplace(IBlockAccess world, int x, int y, int z) {
             if (world.getBlockMaterial(x,  y,  z).isLiquid()) return false;
             return super.canDisplace(world, x, y, z);
     }
     
@Override
     public boolean displaceIfPossible(World world, int x, int y, int z) {
             if (world.getBlockMaterial(x,  y,  z).isLiquid()) return false;
             return super.displaceIfPossible(world, x, y, z);
     }


}
