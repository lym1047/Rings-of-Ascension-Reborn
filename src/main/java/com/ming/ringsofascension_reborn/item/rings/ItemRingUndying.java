package com.ming.ringsofascension_reborn.item.rings;

import com.ming.ringsofascension_reborn.client.GlintRenderTypes;
import com.ming.ringsofascension_reborn.item.ItemRingBase;
import net.minecraft.world.entity.player.Player;

import java.util.function.Supplier;

public class ItemRingUndying extends ItemRingBase {

    private final Supplier<Integer> cooldown;

    public ItemRingUndying(Properties properties, String tooltip, Supplier<Boolean> enabled, Supplier<Integer> cooldown, GlintRenderTypes glintType) {
        super(properties, tooltip, enabled, glintType);
        this.cooldown = cooldown;
    }

    public void setCooldown(Player player) {
        if (!isEnabled.get()) return;
        player.getCooldowns().addCooldown(this, cooldown.get() * 20);
    }

}
