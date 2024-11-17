package com.justgod.helmetNightVision.controllers;

import com.destroystokyo.paper.event.player.PlayerArmorChangeEvent;
import com.justgod.helmetNightVision.enums.NightVisionHelmet;
import com.justgod.helmetNightVision.HelmetNightVision;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.entity.Player;
import java.util.logging.Logger;
import org.bukkit.Material;
import java.util.List;

public class PlayerController implements Listener {

    @EventHandler
    public void onPlayerJoin(PlayerArmorChangeEvent event) {
        Player player = event.getPlayer();
        ItemStack oldItem = event.getOldItem();
        ItemStack newItem = event.getNewItem();
        Material oldItemType = oldItem.getType();
        Material newItemType = newItem.getType();
        NightVisionHelmet oldHelmet = NightVisionHelmet.getByMaterial(oldItemType);
        NightVisionHelmet newHelmet = NightVisionHelmet.getByMaterial(newItemType);

        if (oldHelmet != null || newHelmet != null) {
            HelmetNightVision instance = HelmetNightVision.getInstance();
            Logger logger = instance.getLogger();
            FileConfiguration config = instance.getConfig();
            PotionEffectType nightVision = PotionEffectType.NIGHT_VISION;
            List<String> helmetConfig = config.getStringList("night-vision-helmets");
            boolean configHasOldHelmet = oldHelmet != null && helmetConfig.contains(oldHelmet.getName());
            boolean configHasNewHelmet = newHelmet != null && helmetConfig.contains(newHelmet.getName());

            logger.info("Swap armor helmet triggered for player " + player.getName());

            if (configHasOldHelmet && !configHasNewHelmet) {
                if (player.hasPotionEffect(nightVision)) {
                    logger.info("Player " + player.getName() + " has no longer a valid night vision helmet, removing night vision");
                    player.removePotionEffect(nightVision);
                }
            } else if (configHasNewHelmet && !configHasOldHelmet) {
                if (!player.hasPotionEffect(nightVision)) {
                    logger.info("Player " + player.getName() + " has equiped a valid night vision helmet, adding night vision");
                    player.addPotionEffect(
                        new PotionEffect(
                            nightVision,
                            PotionEffect.INFINITE_DURATION,
                            1000
                        )
                    );
                }
            }
        }
    }

}
