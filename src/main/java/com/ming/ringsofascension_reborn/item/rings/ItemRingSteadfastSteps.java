package com.ming.ringsofascension_reborn.item.rings;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import com.ming.ringsofascension_reborn.RingsOfAscensionReborn;
import com.ming.ringsofascension_reborn.client.GlintRenderTypes;
import com.ming.ringsofascension_reborn.item.ItemRingBase;
import net.minecraft.core.Holder;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.ItemStack;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class ItemRingSteadfastSteps extends ItemRingBase {

    private static final ResourceLocation STEP_HEIGHT_MODIFIER_ID = ResourceLocation.fromNamespaceAndPath(RingsOfAscensionReborn.MODID, "ring_steadfast_steps");

    public ItemRingSteadfastSteps(Properties properties, String tooltip, Supplier<Boolean> enabled, GlintRenderTypes glintType) {
        super(properties, tooltip, enabled, glintType);
    }

    @Override
    public Multimap<Holder<Attribute>, AttributeModifier> curioModifiers(ItemStack stack, String identifier) {
        Multimap<Holder<Attribute>, AttributeModifier> modifiers = HashMultimap.create();

        if (isEnabled.get()) {
            modifiers.put(Attributes.STEP_HEIGHT,
                    new AttributeModifier(STEP_HEIGHT_MODIFIER_ID, 0.4625D,
                            AttributeModifier.Operation.ADD_VALUE));
        }

        return modifiers;
    }

    @Override
    public List<Component> getAttributesTooltip(List<Component> tooltips) {
        return new ArrayList<>();
    }

}
