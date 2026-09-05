package com.ming.ringsofascension_reborn.events;

import com.ming.ringsofascension_reborn.init.ModItems;
import com.ming.ringsofascension_reborn.utils.Utils;
import net.minecraft.core.Holder;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.event.entity.living.MobEffectEvent;

public class ApplyPotionEvent {

    @SubscribeEvent
    public void onApplyPotion(MobEffectEvent.Applicable event) {
        if (!(event.getEntity() instanceof Player player)) return;
        MobEffectInstance effectInstance = event.getEffectInstance();
        if (effectInstance == null) return;
        Holder<MobEffect> effect = effectInstance.getEffect();

        if (effect.value() == MobEffects.POISON.value()) {
            if (Utils.isRingEquipped(ModItems.ringPoisonResistance.get(), player)) event.setResult(MobEffectEvent.Applicable.Result.DO_NOT_APPLY);
        } else

        if (effect.value() == MobEffects.MOVEMENT_SLOWDOWN.value()) {
            if (Utils.isRingEquipped(ModItems.ringSlowResistance.get(), player)) event.setResult(MobEffectEvent.Applicable.Result.DO_NOT_APPLY);
        } else

        if (effect.value() == MobEffects.WITHER.value()) {
            if (Utils.isRingEquipped(ModItems.ringWither.get(), player)) event.setResult(MobEffectEvent.Applicable.Result.DO_NOT_APPLY);
        }

//        //抗冻戒子
//        if (effect.value() ==)
    }

}
