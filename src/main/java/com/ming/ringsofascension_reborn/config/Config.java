package com.ming.ringsofascension_reborn.config;

import com.ming.ringsofascension_reborn.RingsOfAscensionReborn;
import net.neoforged.neoforge.common.ModConfigSpec;
import net.neoforged.neoforge.common.ModConfigSpec.BooleanValue;
import net.neoforged.neoforge.common.ModConfigSpec.IntValue;

public class Config {

    private static final ModConfigSpec.Builder BUILDER = new ModConfigSpec.Builder();
    private static final General GENERAL = new General(BUILDER);
    public static final ModConfigSpec SPEC = BUILDER.build();

    public static IntValue configRingUndyingCooldown;
    public static IntValue configRingHealthHearts;

    public static BooleanValue configRingFireResistance;
    public static BooleanValue configRingInvisibility;
    public static BooleanValue configRingRegeneration;
    public static BooleanValue configRingSlowFalling;
    public static BooleanValue configRingStrength;
    public static BooleanValue configRingWaterBreathing;
    public static BooleanValue configRingSpeed;
    public static BooleanValue configRingNightVision;
    public static BooleanValue configRingJumpBoost;
    public static BooleanValue configRingMining;
    public static BooleanValue configRingLuck;
    public static BooleanValue configRingDolphin;
    public static BooleanValue configRingMagnetism;
    public static BooleanValue configRingFlight;
    public static BooleanValue configRingPoisonResistance;
    public static BooleanValue configRingHungerless;
    public static BooleanValue configRingGrowth;
    public static BooleanValue configRingKnockbackResistance;
    public static BooleanValue configRingHealth;
    public static BooleanValue configRingSponge;
    public static BooleanValue configRingExperience;
    public static BooleanValue configRingWaterWalking;
    public static BooleanValue configRingWither;
    public static BooleanValue configRingUndying;
    public static BooleanValue configRingSlowResistance;
    public static BooleanValue configRingSteadfastSteps;

    public static IntValue configRingAmplifierFireResistance;
    public static IntValue configRingAmplifierInvisibility;
    public static IntValue configRingAmplifierRegeneration;
    public static IntValue configRingAmplifierSlowFalling;
    public static IntValue configRingAmplifierStrength;
    public static IntValue configRingAmplifierWaterBreathing;
    public static IntValue configRingAmplifierSpeed;
    public static IntValue configRingAmplifierNightVision;
    public static IntValue configRingAmplifierJumpBoost;
    public static IntValue configRingAmplifierMining;
    public static IntValue configRingAmplifierLuck;
    public static IntValue configRingAmplifierDolphin;

    private static String key(String name) {
        return RingsOfAscensionReborn.MODID + ".config." + name;
    }

    public static class General {
        public General(final ModConfigSpec.Builder builder) {
            builder.push("Rings of Ascension");
            configRingUndyingCooldown = builder
                    .comment("The cooldown in seconds of the Ring of Undying")
                    .translation(key("ringUndyingCooldown"))
                    .defineInRange("ringUndyingCooldown", 600, 0, Integer.MAX_VALUE);
            configRingHealthHearts = builder
                    .comment("The amount of hearts that Max Health's ring gives you.")
                    .translation(key("ringHealthHearts"))
                    .defineInRange("ringHealthHearts", 10, 0, 400);
            builder.pop();

            builder.push("Enable/Disable Rings");
            configRingFireResistance = builder.translation(key("ringFireResistance")).define("ringFireResistance", true);
            configRingInvisibility = builder.translation(key("ringInvisibility")).define("ringInvisibility", true);
            configRingRegeneration = builder.translation(key("ringRegeneration")).define("ringRegeneration", true);
            configRingSlowFalling = builder.translation(key("ringSlowFalling")).define("ringSlowFalling", true);
            configRingStrength = builder.translation(key("ringStrength")).define("ringStrength", true);
            configRingWaterBreathing = builder.translation(key("ringWaterBreathing")).define("ringWaterBreathing", true);
            configRingSpeed = builder.translation(key("ringSpeed")).define("ringSpeed", true);
            configRingNightVision = builder.translation(key("ringNightVision")).define("ringNightVision", true);
            configRingJumpBoost = builder.translation(key("ringJumpBoost")).define("ringJumpBoost", true);
            configRingMining = builder.translation(key("ringMining")).define("ringMining", true);
            configRingLuck = builder.translation(key("ringLuck")).define("ringLuck", true);
            configRingDolphin = builder.translation(key("ringDolphin")).define("ringDolphin", true);
            configRingMagnetism = builder.translation(key("ringMagnetism")).define("ringMagnetism", true);
            configRingFlight = builder.translation(key("ringFlight")).define("ringFlight", true);
            configRingPoisonResistance = builder.translation(key("ringPoisonResistance")).define("ringPoisonResistance", true);
            configRingHungerless = builder.translation(key("ringHungerless")).define("ringHungerless", true);
            configRingGrowth = builder.translation(key("ringGrowth")).define("ringGrowth", true);
            configRingKnockbackResistance = builder.translation(key("ringKnockbackResistance")).define("ringKnockbackResistance", true);
            configRingHealth = builder.translation(key("ringHealth")).define("ringHealth", true);
            configRingSponge = builder.translation(key("ringSponge")).define("ringSponge", true);
            configRingExperience = builder.translation(key("ringExperience")).define("ringExperience", true);
            configRingWaterWalking = builder.translation(key("ringWaterWalking")).define("ringWaterWalking", true);
            configRingWither = builder.translation(key("ringWither")).define("ringWither", true);
            configRingUndying = builder.translation(key("ringUndying")).define("ringUndying", true);
            configRingSlowResistance = builder.translation(key("ringSlowResistance")).define("ringSlowResistance", true);
            configRingSteadfastSteps = builder.translation(key("ringSteadfastSteps")).define("ringSteadfastSteps", true);
            builder.pop();

            builder.push("Rings Amplifier").comment("Sets the amplifier of the effect given by the ring. Example:\n" +
                    "0 = Fire Resistance I\n" +
                    "1 = Fire Resistance II").push("Amplifiers");
            configRingAmplifierFireResistance = builder.translation(key("ringAmplifierFireResistance")).defineInRange("ringAmplifierFireResistance", 1, 0, 255);
            configRingAmplifierInvisibility = builder.translation(key("ringAmplifierInvisibility")).defineInRange("ringAmplifierInvisibility", 0, 0, 255);
            configRingAmplifierRegeneration = builder.translation(key("ringAmplifierRegeneration")).defineInRange("ringAmplifierRegeneration", 0, 0, 255);
            configRingAmplifierSlowFalling = builder.translation(key("ringAmplifierSlowFalling")).defineInRange("ringAmplifierSlowFalling", 0, 0, 255);
            configRingAmplifierStrength = builder.translation(key("ringAmplifierStrength")).defineInRange("ringAmplifierStrength", 0, 0, 255);
            configRingAmplifierWaterBreathing = builder.translation(key("ringAmplifierWaterBreathing")).defineInRange("ringAmplifierWaterBreathing", 1, 0, 255);
            configRingAmplifierSpeed = builder.translation(key("ringAmplifierSpeed")).defineInRange("ringAmplifierSpeed", 0, 0, 255);
            configRingAmplifierNightVision = builder.translation(key("ringAmplifierNightVision")).defineInRange("ringAmplifierNightVision", 0, 0, 255);
            configRingAmplifierJumpBoost = builder.translation(key("ringAmplifierJumpBoost")).defineInRange("ringAmplifierJumpBoost", 0, 0, 255);
            configRingAmplifierMining = builder.translation(key("ringAmplifierMining")).defineInRange("ringAmplifierMining", 1, 0, 255);
            configRingAmplifierLuck = builder.translation(key("ringAmplifierLuck")).defineInRange("ringAmplifierLuck", 1, 0, 255);
            configRingAmplifierDolphin = builder.translation(key("ringAmplifierDolphin")).defineInRange("ringAmplifierDolphin", 0, 0, 255);
            builder.pop(2);
        }
    }

}
