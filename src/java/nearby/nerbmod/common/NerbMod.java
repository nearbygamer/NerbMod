package nearby.nerbmod.common;
/* imported classes */
import java.io.IOException;

import nearby.nerbmod.block.BlockNerbBlock;
import nearby.nerbmod.creativetab.CreativeTabNerb;
import nearby.nerbmod.event.NerbFillBucketEvent;
import nearby.nerbmod.food.SeasonedEgg;
import nearby.nerbmod.item.ItemNerbAxe;
import nearby.nerbmod.item.ItemNerbHoe;
import nearby.nerbmod.item.ItemNerbIngot;
import nearby.nerbmod.item.ItemNerbOre;
import nearby.nerbmod.item.ItemNerbPickaxe;
import nearby.nerbmod.item.ItemNerbShovel;
import nearby.nerbmod.item.ItemNerbSword;
import nearby.nerbmod.liquid.ItemNerbBucket;
import nearby.nerbmod.liquid.NerbJuice;
import nearby.nerbmod.plant.BlockPepper;
import nearby.nerbmod.plant.BlockSalt;
import nearby.nerbmod.plant.NerbPlantBlock;
import nearby.nerbmod.weapon.ItemNerbGreatSword;
import nearby.nerbmod.worldgen.NerbOreWorldgen;
import net.minecraft.block.Block;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialLiquid;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemSeedFood;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.Configuration;
import net.minecraftforge.common.EnumHelper;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidContainerRegistry;
import net.minecraftforge.fluids.FluidContainerRegistry.FluidContainerData;
import net.minecraftforge.fluids.FluidRegistry;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

// Declare Mod for Forge and Server Side Proxy
@Mod(modid = "NerbMod", name = "NerbMod", version = "0.0.1 Alpha")
@NetworkMod(clientSideRequired = true, serverSideRequired = false)

public class NerbMod {
@SidedProxy(clientSide = "nearby.nerbmod.client.ClientProxy", serverSide = "nearby.nerbmod.common.CommonProxy")
public static CommonProxy proxy;

//Blocks
public static Block NerbBlock;
public static Block saltBlock;
public static Block pepperBlock;
public static Block nerbPlantBlock;
public static Block nerbJuice;

//Items
public static Item itemSalt;
public static Item itemPepper;
public static Item itemNerbSeed;
public static Item HardBoiledEgg;
public static Item NerbPickaxe;
public static Item NerbShovel;
public static Item NerbAxe;
public static Item NerbHoe;
public static Item NerbSword;
public static Item NerbOre;
public static Item NerbIngot;
public static Item EggSeasoned;
public static Item NerbGreatSword;
public static Item bucketNerbJuice;


//int for config blockID
public static int NerbBlockID;
public static int saltBlockID;
public static int pepperBlockID;
public static int nerbJuiceID;
public static int nerbPlantBlockID;
//int for config ItemID
public static int itemSaltID;
public static int itemPepperID;
public static int nerbSeedID;
public static int HardBoiledEggID;
public static int NerbPickaxeID;
public static int NerbShovelID;
public static int NerbAxeID;
public static int NerbHoeID;
public static int NerbSwordID;
public static int NerbOreID;
public static int NerbIngotID;
public static int EggSeasonedID;
public static int NerbGreatSwordID;
public static int bucketNerbJuiceID;


public static Material materialNerb;
public static Fluid fluidNerb;
public static final int idNerbJuice = 1166;


@EventHandler
public void preInit(FMLPreInitializationEvent e)throws IOException{ 
	Configuration config = new Configuration(e.getSuggestedConfigurationFile());

	config.load();

	NerbBlockID = config.getBlock("NerbBlock", 1151).getInt();
	saltBlockID = config.getBlock("saltBlock", 1052).getInt();
	pepperBlockID = config.getBlock("pepperBlock", 1053).getInt();
	nerbPlantBlockID = config.getBlock("nerbPlantBlock", 1054).getInt();
	itemSaltID = config.getItem("itemSalt", 29500).getInt();
	itemPepperID = config.getItem("itemPepper", 29501).getInt();
	HardBoiledEggID = config.getItem("HardBoiledEgg", 29502).getInt();
	NerbPickaxeID = config.getItem("NerbPickaxe", 29503).getInt();
	NerbShovelID = config.getItem("NerbShovel", 29504).getInt();
	NerbAxeID = config.getItem("NerbAxe", 29505).getInt();
	NerbHoeID = config.getItem("NerbHoe", 29506).getInt();
	NerbSwordID = config.getItem("NerbSword", 29507).getInt();
	NerbOreID = config.getItem("NerbOre", 29508).getInt();
	NerbIngotID = config.getItem("NerbIngot", 29509).getInt();
	EggSeasonedID = config.getItem("EggSeasoned", 29510).getInt();
	NerbGreatSwordID = config.getItem("NerbGreatSword", 29511).getInt();
	bucketNerbJuiceID = config.getItem("bucketNerbJuice", 29512).getInt();
	nerbSeedID = config.getItem("itemNerbSeed", 29513).getInt();
	config.save();
	
	
	fluidNerb = new Fluid("FluidNerbJuice").setBlockID(idNerbJuice);
    FluidRegistry.registerFluid(fluidNerb);
    nerbJuice = new NerbJuice(idNerbJuice).setUnlocalizedName("NerbJuice");
	bucketNerbJuice = new ItemNerbBucket(bucketNerbJuiceID, idNerbJuice).setUnlocalizedName("Nerb Bucket").setMaxStackSize(1).setContainerItem(Item.bucketEmpty);
}


//Creative Tabs
public static CreativeTabs TabNerb = new CreativeTabNerb(CreativeTabs.getNextID(), "NerbTab");
//Tool Materials
public static EnumToolMaterial toolNerb = EnumHelper.addToolMaterial("NERB", 3, 2000, 3.0F, 3.0F, 30);
public static EnumToolMaterial toolSuperNerb = EnumHelper.addToolMaterial("SUPERNERB", 20, 100, 10.0F, 0.0F, 30);
//Weapon Materials
public static EnumToolMaterial toolNerbGreatSword = EnumHelper.addToolMaterial("NERBGREATSWORD", 3, 2000, 3.0F, 4.0F, 30);

//WordGen
public static NerbOreWorldgen WorldgenNerbOre = new NerbOreWorldgen();


@Init
public void load(FMLInitializationEvent event) {
	proxy.registerRenderInformation();
	
	//Blocks
	NerbBlock = new BlockNerbBlock(NerbBlockID, Material.rock).setUnlocalizedName("NerbBlock");
    saltBlock = new BlockSalt(saltBlockID).setUnlocalizedName("salt");
    pepperBlock = new BlockPepper(pepperBlockID).setUnlocalizedName("salt");
    nerbPlantBlock = new NerbPlantBlock(nerbPlantBlockID).setUnlocalizedName("Nerb Berry");
    
    //Items
    itemSalt = new ItemSeedFood(itemSaltID, 1, 0.5F, NerbMod.saltBlock.blockID, Block.tilledField.blockID ).setUnlocalizedName("itemSalt").setTextureName("nerbmod:salt").setCreativeTab(NerbMod.TabNerb);
    itemPepper = new ItemSeedFood(itemPepperID, 1, 0.5F, NerbMod.pepperBlock.blockID, Block.tilledField.blockID ).setUnlocalizedName("itemPepper").setTextureName("nerbmod:pepper").setCreativeTab(NerbMod.TabNerb);
    itemNerbSeed = new ItemSeedFood(nerbSeedID, 4, 3F, NerbMod.nerbPlantBlock.blockID, Block.tilledField.blockID ).setUnlocalizedName("itemNerbSeed").setTextureName("nerbmod:nerbberry").setCreativeTab(NerbMod.TabNerb);
    HardBoiledEgg = new ItemFood(HardBoiledEggID, 8, 3F, false).setUnlocalizedName("HardBoiledEgg").setTextureName("nerbmod:HardBoiledEgg").setCreativeTab(NerbMod.TabNerb);
    NerbPickaxe = new ItemNerbPickaxe(NerbPickaxeID, toolSuperNerb).setUnlocalizedName("Nerb Pickaxe");
    NerbShovel = new ItemNerbShovel(NerbShovelID, toolNerb).setUnlocalizedName("Nerb Shovel");
    NerbAxe = new ItemNerbAxe(NerbAxeID, toolNerb).setUnlocalizedName("Nerb Axe");
    NerbHoe = new ItemNerbHoe(NerbHoeID, toolNerb).setUnlocalizedName("Nerb Hoe");
    NerbSword = new ItemNerbSword(NerbSwordID, toolNerb).setUnlocalizedName("Nerb Sword");
    NerbOre = new ItemNerbOre(NerbOreID).setUnlocalizedName("Nerb Ore");
    NerbIngot = new ItemNerbIngot(NerbIngotID).setUnlocalizedName("Nerb Ingot");
    EggSeasoned = new SeasonedEgg(EggSeasonedID).setUnlocalizedName("Egg Seasoned");
    NerbGreatSword = new ItemNerbGreatSword(NerbGreatSwordID, toolNerbGreatSword).setUnlocalizedName("Nerb Great Sword");
    
    
    
    
    
    
    
    //Game Registry
    GameRegistry.registerWorldGenerator(WorldgenNerbOre);
    GameRegistry.registerBlock(NerbBlock);
    GameRegistry.registerBlock(saltBlock);
    GameRegistry.registerBlock(pepperBlock);
    GameRegistry.registerBlock(nerbPlantBlock);
   
    MinecraftForge.EVENT_BUS.register(new NerbFillBucketEvent());
    //Language Registry
    LanguageRegistry.addName(NerbGreatSword, "Nerb Great Sword");
    LanguageRegistry.addName(NerbSword, "Nerb Sword");
    LanguageRegistry.addName(NerbPickaxe, "Nerb Pickaxe");
    LanguageRegistry.addName(NerbShovel, "Nerb Shovel");
    LanguageRegistry.addName(NerbAxe, "Nerb Axe");
    LanguageRegistry.addName(NerbHoe, "Nerb Hoe");
    LanguageRegistry.addName(NerbBlock, "Nerb Block");
    LanguageRegistry.addName(NerbOre, "Nerb Ore");
    LanguageRegistry.addName(NerbIngot, "Nerb Ingot");
    LanguageRegistry.addName(itemPepper, "Pepper");
    LanguageRegistry.addName(itemSalt, "Salt");
    LanguageRegistry.addName(EggSeasoned, "Seasoned Egg");
    LanguageRegistry.addName(HardBoiledEgg, "Hard Boiled Egg");
    LanguageRegistry.addName(nerbJuice, "Nerb Juice");
    LanguageRegistry.addName(bucketNerbJuice, "Nerb Juice Bucket");
    LanguageRegistry.addName(nerbPlantBlock, "Nerb Berry Plant");
    LanguageRegistry.addName(itemNerbSeed, "Nerb Berry Plant");
    
  //Shaped Crafting Recipes
    GameRegistry.addRecipe(new ItemStack (NerbPickaxe, 1), new Object [] {
    	"XXX"," Y "," Y ",'X', NerbIngot, 'Y', Item.stick
    });
    GameRegistry.addRecipe(new ItemStack (NerbAxe, 1), new Object [] {
    	"XX ","XY "," Y ",'X', NerbIngot, 'Y', Item.stick
    });
    GameRegistry.addRecipe(new ItemStack (NerbSword, 1), new Object [] {
    	" X "," X "," Y ",'X', NerbIngot, 'Y', Item.stick
    });
    GameRegistry.addRecipe(new ItemStack (NerbHoe, 1), new Object [] {
    	"XX "," Y "," Y ",'X', NerbIngot, 'Y', Item.stick
    });
    GameRegistry.addRecipe(new ItemStack (NerbShovel, 1), new Object [] {
    	" X "," Y "," Y ",'X', NerbIngot, 'Y', Item.stick
    });
    GameRegistry.addRecipe(new ItemStack (NerbGreatSword, 1), new Object [] {
    	" X ","XXX"," Y ",'X', NerbIngot, 'Y', Item.stick
    });
    
    //Shapeless Crafting Recipes
    GameRegistry.addShapelessRecipe(new ItemStack(NerbMod.EggSeasoned, 1), new ItemStack(NerbMod.itemPepper),new ItemStack(NerbMod.itemSalt),new ItemStack(Item.egg));
    GameRegistry.addShapelessRecipe(new ItemStack(NerbMod.bucketNerbJuice, 1), new ItemStack(NerbMod.itemNerbSeed),new ItemStack(Item.bucketWater));
    
  //Furnace Recipes
    GameRegistry.addSmelting(NerbMod.EggSeasoned.itemID, new ItemStack(NerbMod.HardBoiledEgg), 0.5F);
    GameRegistry.addSmelting(NerbMod.NerbOre.itemID, new ItemStack(NerbMod.NerbIngot), 0.5F);
    
    MinecraftForge.addGrassSeed(new ItemStack(itemSalt), 30);
	MinecraftForge.addGrassSeed(new ItemStack(itemPepper), 30);
	MinecraftForge.addGrassSeed(new ItemStack(itemNerbSeed), 30);
	
}
@EventHandler
public void postInit(FMLPostInitializationEvent e){
	FluidContainerRegistry.registerFluidContainer(new FluidContainerData(FluidRegistry.getFluidStack(NerbMod.fluidNerb.getName(), FluidContainerRegistry.BUCKET_VOLUME),new ItemStack(NerbMod.bucketNerbJuice), new ItemStack(Item.bucketEmpty)));
}
}
