package nearby.nerbmod.worldgen;

import java.util.Random;

import nearby.nerbmod.common.NerbMod;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import cpw.mods.fml.common.IWorldGenerator;

public class NerbOreWorldgen implements IWorldGenerator{

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world,
			IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
		switch(world.provider.dimensionId) {
		case -1 : generateNether(world, random, chunkX*16, chunkZ*16);
		case 0 : generateSurface(world, random, chunkX*16, chunkZ*16);
		
		}
		
	}

	private void generateNether(World world, Random random, int i, int j) {
		
		
	}

	private void generateSurface(World world, Random random, int blockX, int blockZ) {
		for(int i = 0; i < 4; i++) {
			int Xcoord = blockX + random.nextInt(16);
			int Ycoord = random.nextInt(80);
			int Zcoord = blockZ + random.nextInt(16);
			
			new WorldGenMinable(NerbMod.NerbBlock.blockID,4).generate(world, random, Xcoord, Ycoord, Zcoord);
		}
		
	}

}
