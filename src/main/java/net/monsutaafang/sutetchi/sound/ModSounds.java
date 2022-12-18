package net.monsutaafang.sutetchi.sound;

import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.monsutaafang.sutetchi.Sutetchi;
import net.minecraft.util.registry.Registry;

import java.util.LinkedHashMap;
import java.util.Map;

public class ModSounds {

    private static final Map<SoundEvent, Identifier> SOUND_EVENTS = new LinkedHashMap<>();
    public static final SoundEvent SLIMESTEP = create("slimestep");
    public static final SoundEvent TAMESOUND = create("tamesound");
    public static final SoundEvent UPGRADE = create("upgrade");
    public static final SoundEvent CRUNCH = create("crunch");
    public static final SoundEvent SLIMECHANGE = create("slimechange");
    public static final SoundEvent WITCHCHANGE = create("witchchange");
    public static final SoundEvent SNOWCHANGE = create("snowchange");
    public static final SoundEvent ANCIENTCHANGE = create("ancientchange");


    private static SoundEvent create(String name) {
        Identifier id = new Identifier(Sutetchi.MOD_ID, name);
        SoundEvent soundEvent = new SoundEvent(id);
        SOUND_EVENTS.put(soundEvent, id);
        return soundEvent;
    }

    public static void registerSounds() {
        SOUND_EVENTS.keySet().forEach(soundEvent -> Registry.register(Registry.SOUND_EVENT, SOUND_EVENTS.get(soundEvent), soundEvent));
    }
}
