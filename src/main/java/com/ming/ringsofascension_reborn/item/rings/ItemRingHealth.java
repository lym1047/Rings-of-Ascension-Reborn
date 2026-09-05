package com.ming.ringsofascension_reborn.item.rings;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import com.ming.ringsofascension_reborn.RingsOfAscensionReborn;
import com.ming.ringsofascension_reborn.client.GlintRenderTypes;
import com.ming.ringsofascension_reborn.item.ItemRingBase;
import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.ItemStack;

import java.util.function.Supplier;

public class ItemRingHealth extends ItemRingBase {

    private static final ResourceLocation HEALTH_MODIFIER_ID = ResourceLocation.fromNamespaceAndPath(RingsOfAscensionReborn.MODID, "ring_health");
    private final Supplier<Integer> hearts;

    public ItemRingHealth(Properties properties, String tooltip, Supplier<Boolean> enabled, Supplier<Integer> hearts, GlintRenderTypes glintType) {
        super(properties, tooltip, enabled, glintType);
        this.hearts = hearts;
    }

    @Override
    public void onUnequippedCurio(String identifier, LivingEntity livingEntity) {
        if (livingEntity.getHealth() > livingEntity.getMaxHealth())
            livingEntity.setHealth(livingEntity.getMaxHealth());
    }

    @Override
    public Multimap<Holder<Attribute>, AttributeModifier> curioModifiers(ItemStack stack, String identifier) {
        Multimap<Holder<Attribute>, AttributeModifier> modifiers = HashMultimap.create();

        if (isEnabled.get()) {
            modifiers.put(Attributes.MAX_HEALTH,
                    new AttributeModifier(HEALTH_MODIFIER_ID, hearts.get() * 2,
                            AttributeModifier.Operation.ADD_VALUE));
        }

        return modifiers;
    }

}
