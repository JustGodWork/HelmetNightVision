package com.justgod.helmetNightVision.enums;

import org.bukkit.Material;

public enum NightVisionHelmet {

    IRON("IRON", Material.IRON_HELMET),
    GOLD("GOLD", Material.GOLDEN_HELMET),
    DIAMOND("DIAMOND", Material.DIAMOND_HELMET),
    NETHERITE("NETHERITE", Material.NETHERITE_HELMET);

    private final String name;
    private final Material type;

    NightVisionHelmet(String name, Material type) {
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public Material getType() {
        return type;
    }

    public static NightVisionHelmet getByName(String name) {
        for (NightVisionHelmet helmet : values()) {
            if (helmet.name.equalsIgnoreCase(name)) {
                return helmet;
            }
        }
        return null;
    }

    public static NightVisionHelmet getByMaterial(Material material) {
        for (NightVisionHelmet helmet : values()) {
            if (helmet.type == material) {
                return helmet;
            }
        }
        return null;
    }

}
