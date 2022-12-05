package net.monsutaafang.sutetchi.item;

import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.monsutaafang.sutetchi.Sutetchi;

public class ModItemGroups {
    public static final ItemGroup SUTETCHIGROUP = FabricItemGroupBuilder.build(new Identifier(Sutetchi.MOD_ID, "sutetchi"),
            () -> new ItemStack(ModItems.SLIMELIN_SPAWN_EGG));
}
