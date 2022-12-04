package net.monsutaafang.sutetchi;

import net.fabricmc.api.ModInitializer;
import net.monsutaafang.sutetchi.item.ModItems;
import net.monsutaafang.sutetchi.util.ModRegistries;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import software.bernie.geckolib3.GeckoLib;

public class Sutetchi implements ModInitializer {
	public static final String MOD_ID = "sutetchi";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {

		ModItems.registerModItems();

		ModRegistries.registerModStuffs();

		GeckoLib.initialize();

		
	}
}
