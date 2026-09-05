package com.ming.ringsofascension_reborn.init;

import com.ming.ringsofascension_reborn.RingsOfAscensionReborn;
import com.ming.ringsofascension_reborn.client.GlintRenderTypes;
import com.ming.ringsofascension_reborn.config.Config;
import com.ming.ringsofascension_reborn.item.ItemRingBase;
import com.ming.ringsofascension_reborn.item.rings.ItemRingEffect;
import com.ming.ringsofascension_reborn.item.rings.ItemRingExperience;
import com.ming.ringsofascension_reborn.item.rings.ItemRingFlight;
import com.ming.ringsofascension_reborn.item.rings.ItemRingGrowth;
import com.ming.ringsofascension_reborn.item.rings.ItemRingHealth;
import com.ming.ringsofascension_reborn.item.rings.ItemRingHungerless;
import com.ming.ringsofascension_reborn.item.rings.ItemRingKnockbackResistance;
import com.ming.ringsofascension_reborn.item.rings.ItemRingMagnet;
import com.ming.ringsofascension_reborn.item.rings.ItemRingPoisonResistance;
import com.ming.ringsofascension_reborn.item.rings.ItemRingSlowResistance;
import com.ming.ringsofascension_reborn.item.rings.ItemRingSponge;
import com.ming.ringsofascension_reborn.item.rings.ItemRingSteadfastSteps;
import com.ming.ringsofascension_reborn.item.rings.ItemRingUndying;
import com.ming.ringsofascension_reborn.item.rings.ItemRingWaterWalking;
import com.ming.ringsofascension_reborn.item.rings.ItemRingWither;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.material.Fluids;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class ModItems {

    public static List<ItemRingBase> allRings = new ArrayList<>();

    private static final DeferredRegister<Item> register = DeferredRegister.create(Registries.ITEM, RingsOfAscensionReborn.MODID);

    public static DeferredHolder<Item, ItemRingBase> ringFireResistance = register("ring_fire_resistance",
            () -> new ItemRingEffect(new Item.Properties(), "tooltip.ringsofascensionreborn.fire_resistance",
                    () -> Config.configRingFireResistance.get(), MobEffects.FIRE_RESISTANCE,
                    () -> Config.configRingAmplifierFireResistance.get(), GlintRenderTypes.ORANGE));

    public static DeferredHolder<Item, ItemRingBase> ringInvisibility = register("ring_invisibility",
            () -> new ItemRingEffect(new Item.Properties(), "tooltip.ringsofascensionreborn.invisibility",
                    () -> Config.configRingInvisibility.get(), MobEffects.INVISIBILITY,
                    () -> Config.configRingAmplifierInvisibility.get(), GlintRenderTypes.PURPLE));

    public static DeferredHolder<Item, ItemRingBase> ringRegeneration = register("ring_regeneration",
            () -> new ItemRingEffect(new Item.Properties(), "tooltip.ringsofascensionreborn.regeneration",
                    () -> Config.configRingRegeneration.get(), MobEffects.REGENERATION,
                    () -> Config.configRingAmplifierRegeneration.get(), GlintRenderTypes.RED));

    public static DeferredHolder<Item, ItemRingBase> ringSlowFalling = register("ring_slow_falling",
            () -> new ItemRingEffect(new Item.Properties(), "tooltip.ringsofascensionreborn.slow_falling",
                    () -> Config.configRingSlowFalling.get(), MobEffects.SLOW_FALLING,
                    () -> Config.configRingAmplifierSlowFalling.get(), GlintRenderTypes.WHITE));

    public static DeferredHolder<Item, ItemRingBase> ringStrength = register("ring_strength",
            () -> new ItemRingEffect(new Item.Properties(), "tooltip.ringsofascensionreborn.strength",
                    () -> Config.configRingStrength.get(), MobEffects.DAMAGE_BOOST,
                    () -> Config.configRingAmplifierStrength.get(), GlintRenderTypes.RED));

    public static DeferredHolder<Item, ItemRingBase> ringWaterBreathing = register("ring_water_breathing",
            () -> new ItemRingEffect(new Item.Properties(), "tooltip.ringsofascensionreborn.water_breathing",
                    () -> Config.configRingWaterBreathing.get(), MobEffects.WATER_BREATHING,
                    () -> Config.configRingAmplifierWaterBreathing.get(), GlintRenderTypes.BLUE));

    public static DeferredHolder<Item, ItemRingBase> ringSpeed = register("ring_speed",
            () -> new ItemRingEffect(new Item.Properties(), "tooltip.ringsofascensionreborn.speed",
                    () -> Config.configRingSpeed.get(), MobEffects.MOVEMENT_SPEED,
                    () -> Config.configRingAmplifierSpeed.get(), GlintRenderTypes.LIGHT_BLUE));

    public static DeferredHolder<Item, ItemRingBase> ringNightVision = register("ring_night_vision",
            () -> new ItemRingEffect(new Item.Properties(), "tooltip.ringsofascensionreborn.night_vision",
                    () -> Config.configRingNightVision.get(), MobEffects.NIGHT_VISION,
                    () -> Config.configRingAmplifierNightVision.get(), GlintRenderTypes.LIGHT_GRAY));

    public static DeferredHolder<Item, ItemRingBase> ringJumpBoost = register("ring_jump_boost",
            () -> new ItemRingEffect(new Item.Properties(), "tooltip.ringsofascensionreborn.jump_boost",
                    () -> Config.configRingJumpBoost.get(), MobEffects.JUMP,
                    () -> Config.configRingAmplifierJumpBoost.get(), GlintRenderTypes.LIME));

    public static DeferredHolder<Item, ItemRingBase> ringMining = register("ring_mining",
            () -> new ItemRingEffect(new Item.Properties(), "tooltip.ringsofascensionreborn.mining",
                    () -> Config.configRingMining.get(), MobEffects.DIG_SPEED,
                    () -> Config.configRingAmplifierMining.get(), GlintRenderTypes.YELLOW));

    public static DeferredHolder<Item, ItemRingBase> ringLuck = register("ring_luck",
            () -> new ItemRingEffect(new Item.Properties(), "tooltip.ringsofascensionreborn.luck",
                    () -> Config.configRingLuck.get(), MobEffects.LUCK,
                    () -> Config.configRingAmplifierLuck.get(), GlintRenderTypes.GREEN));

    public static DeferredHolder<Item, ItemRingBase> ringDolphin = register("ring_dolphin",
            () -> new ItemRingEffect(new Item.Properties(), "tooltip.ringsofascensionreborn.dolphin",
                    () -> Config.configRingDolphin.get(), MobEffects.DOLPHINS_GRACE,
                    () -> Config.configRingAmplifierDolphin.get(), GlintRenderTypes.LIGHT_GRAY));

    public static DeferredHolder<Item, ItemRingBase> ringMagnetism = register("ring_magnetism",
            () -> new ItemRingMagnet(new Item.Properties(), "tooltip.ringsofascensionreborn.magnetism",
                    () -> Config.configRingMagnetism.get(), GlintRenderTypes.LIGHT_GRAY));

    public static DeferredHolder<Item, ItemRingBase> ringFlight = register("ring_flight",
            () -> new ItemRingFlight(new Item.Properties(), "tooltip.ringsofascensionreborn.flight",
                    () -> Config.configRingFlight.get(), GlintRenderTypes.LIGHT_BLUE));

    public static DeferredHolder<Item, ItemRingBase> ringPoisonResistance = register("ring_poison_resistance",
            () -> new ItemRingPoisonResistance(new Item.Properties(), "tooltip.ringsofascensionreborn.poison_resistance",
                    () -> Config.configRingPoisonResistance.get(), GlintRenderTypes.GREEN));

    public static DeferredHolder<Item, ItemRingBase> ringHungerless = register("ring_hungerless",
            () -> new ItemRingHungerless(new Item.Properties(), "tooltip.ringsofascensionreborn.hungerless",
                    () -> Config.configRingHungerless.get(), GlintRenderTypes.BROWN));

    public static DeferredHolder<Item, ItemRingBase> ringGrowth = register("ring_growth",
            () -> new ItemRingGrowth(new Item.Properties(), "tooltip.ringsofascensionreborn.growth",
                    () -> Config.configRingGrowth.get(), GlintRenderTypes.GREEN));

    public static DeferredHolder<Item, ItemRingBase> ringKnockbackResistance = register("ring_knockback_resistance",
            () -> new ItemRingKnockbackResistance(new Item.Properties(), null,
                    () -> Config.configRingKnockbackResistance.get(), GlintRenderTypes.GRAY));

    public static DeferredHolder<Item, ItemRingBase> ringHealth = register("ring_health",
            () -> new ItemRingHealth(new Item.Properties(), null, () -> Config.configRingHealth.get(),
                    () -> Config.configRingHealthHearts.get(), GlintRenderTypes.RED));

    public static DeferredHolder<Item, ItemRingBase> ringSponge = register("ring_sponge",
            () -> new ItemRingSponge(new Item.Properties(), "tooltip.ringsofascensionreborn.sponge",
                    () -> Config.configRingSponge.get(), Fluids.WATER, Fluids.FLOWING_WATER, GlintRenderTypes.YELLOW));

    public static DeferredHolder<Item, ItemRingBase> ringLavaSponge = register("ring_lava_sponge",
            () -> new ItemRingSponge(new Item.Properties(), "tooltip.ringsofascensionreborn.lava_sponge",
                    () -> Config.configRingSponge.get(), Fluids.LAVA, Fluids.FLOWING_LAVA, GlintRenderTypes.ORANGE));

    public static DeferredHolder<Item, ItemRingBase> ringExperience = register("ring_experience",
            () -> new ItemRingExperience(new Item.Properties(), "tooltip.ringsofascensionreborn.experience",
                    () -> Config.configRingExperience.get(), GlintRenderTypes.LIME));

    public static DeferredHolder<Item, ItemRingBase> ringWaterWalking = register("ring_water_walking",
            () -> new ItemRingWaterWalking(new Item.Properties(), "tooltip.ringsofascensionreborn.water_walking",
                    () -> Config.configRingWaterWalking.get(), GlintRenderTypes.LIGHT_BLUE));

    public static DeferredHolder<Item, ItemRingBase> ringWither = register("ring_wither",
            () -> new ItemRingWither(new Item.Properties(), "tooltip.ringsofascensionreborn.wither",
                    () -> Config.configRingWither.get(), GlintRenderTypes.BLACK));

    public static DeferredHolder<Item, ItemRingBase> ringUndying = register("ring_undying",
            () -> new ItemRingUndying(new Item.Properties(), "tooltip.ringsofascensionreborn.undying",
                    () -> Config.configRingUndying.get(), () -> Config.configRingUndyingCooldown.get(), GlintRenderTypes.ORANGE));

    public static DeferredHolder<Item, ItemRingBase> ringSlowResistance = register("ring_slow_resistance",
            () -> new ItemRingSlowResistance(new Item.Properties(), "tooltip.ringsofascensionreborn.slow_resistance",
                    () -> Config.configRingSlowResistance.get(), GlintRenderTypes.GRAY));

    public static DeferredHolder<Item, ItemRingBase> ringSteadfastSteps = register("ring_steadfast_steps",
            () -> new ItemRingSteadfastSteps(new Item.Properties(), "tooltip.ringsofascensionreborn.steadfast_steps", () -> Config.configRingSteadfastSteps.get(), GlintRenderTypes.BROWN));

    public static void init(IEventBus bus) {
        register.register(bus);
    }

    private static DeferredHolder<Item, ItemRingBase> register(String name, Supplier<ItemRingBase> supplier) {
        return register.register(name, supplier);
    }

}
