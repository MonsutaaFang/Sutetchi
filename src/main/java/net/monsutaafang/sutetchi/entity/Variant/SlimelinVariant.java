package net.monsutaafang.sutetchi.entity.Variant;


import java.util.Arrays;
import java.util.Comparator;

public enum SlimelinVariant {
    DEFAULT(0),
    WITCH(1);

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
