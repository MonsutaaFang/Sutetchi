package net.monsutaafang.sutetchi.entity.Variant;


import java.util.Arrays;
import java.util.Comparator;

public enum SlimelinVariant {
    DEFAULT(0),
    SEA(1),
    NETHER(2),
    END(3),
    WITCH(4),
    SEAWITCH(5),
    NETHERWITCH(6),
    ENDWITCH(7),
    SNOW(8),
    SEASNOW(9),
    NETHERSNOW(10),
    ENDSNOW(11),
    ANCIENT(12),
    SEAANCIENT(13),
    NETHERANCIENT(14),
    ENDANCIENT(15),
    EXPLORERS(16),
    SEAEXPLORERS(17),
    NETHEREXPLORERS(18),
    ENDEXPLORERS(19);
    private static final SlimelinVariant[] BY_ID = Arrays.stream(values()).sorted(Comparator.
            comparingInt(SlimelinVariant::getId)).toArray(SlimelinVariant[]::new);
    private final int id;

    SlimelinVariant(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public static SlimelinVariant byId(int id) {
        return BY_ID[id % BY_ID.length];
    }
}
