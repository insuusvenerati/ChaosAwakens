package io.github.chaosawakens.registry;

import com.google.common.collect.*;

import io.github.chaosawakens.ChaosAwakens;
import io.github.chaosawakens.worldgen.structures.*;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.feature.structure.Structure;
import net.minecraft.world.gen.settings.*;

import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.*;

import java.util.*;

public class ModStructures {

	public static final DeferredRegister<Structure<?>> STRUCTURES = DeferredRegister
			.create(ForgeRegistries.STRUCTURE_FEATURES, ChaosAwakens.MODID);

	public static final RegistryObject<Structure<NoFeatureConfig>> ENT_DUNGEON = STRUCTURES.register("ent_dungeon",
			() -> (new EntDungeonStructure(NoFeatureConfig.CODEC)));

	public static void setupStructures() {
		setupMapSpacingAndLand(ENT_DUNGEON.get(),
				new StructureSeparationSettings(10 /* average distance apart in chunks between spawn attempts */,
						8 /* minimum distance apart in chunks between spawn attempts */, 32034987),
				true);
	}

	public static <F extends Structure<?>> void setupMapSpacingAndLand(F structure,
			StructureSeparationSettings structureSeparationSettings, boolean transformSurroundingLand) {

		Structure.NAME_STRUCTURE_BIMAP.put(structure.getRegistryName().toString(), structure);

		/*if (transformSurroundingLand) {
			Structure.field_236384_t_ = ImmutableList.<Structure<?>>builder().addAll(Structure.field_236384_t_)
					.add(structure).build();
		}

		DimensionStructuresSettings.field_236191_b_ = ImmutableMap.<Structure<?>, StructureSeparationSettings>builder()
				.putAll(DimensionStructuresSettings.field_236191_b_).put(structure, structureSeparationSettings)
				.build();

		WorldGenRegistries.NOISE_SETTINGS.getEntries().forEach(settings -> {
			
			 * Map<Structure<?>, StructureSeparationSettings> structureMap =
			 * settings.getValue().getStructures().field_236193_d_;
			 * 
			 * if (structureMap instanceof ImmutableMap) { Map<Structure<?>,
			 * StructureSeparationSettings> tempMap = new HashMap<>(structureMap);
			 * tempMap.put(structure, structureSeparationSettings);
			 * settings.getValue().getStructures().field_236193_d_ = tempMap; } else {
			 * structureMap.put(structure, structureSeparationSettings); }
			 
		});*/
	}
}