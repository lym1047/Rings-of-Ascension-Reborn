package com.ming.ringsofascension_reborn.item.rings;

import com.ming.ringsofascension_reborn.client.GlintRenderTypes;
import com.ming.ringsofascension_reborn.item.ItemRingBase;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;

import java.util.function.Supplier;

public class ItemRingPoisonResistance extends ItemRingBase {

    public ItemRingPoisonResistance(Properties properties, String tooltip, Supplier<Boolean> enabled, GlintRenderTypes glintType) {
        super(properties, tooltip, enabled, glintType);
    }

    @Override
    public void tickCurio(String identifier, int index, LivingEntity livingEntity) {
        if (!isEnabled.get()) return;
        if (livingEntity.hasEffect(MobEffects.POISON)) {
            livingEntity.removeEffectNoUpdate(MobEffects.POISON);
        }
    }

}
