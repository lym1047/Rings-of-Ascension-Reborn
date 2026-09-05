package com.ming.ringsofascension_reborn.item;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import com.ming.ringsofascension_reborn.client.GlintRenderTypes;
import com.ming.ringsofascension_reborn.init.ModItems;
import net.minecraft.ChatFormatting;
import net.minecraft.core.Holder;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.network.chat.TextColor;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import org.jetbrains.annotations.NotNull;
import top.theillusivec4.curios.api.SlotContext;
import top.theillusivec4.curios.api.type.capability.ICurio;
import top.theillusivec4.curios.api.type.capability.ICurioItem;

import java.util.List;
import java.util.Objects;
import java.util.function.Supplier;

public abstract class ItemRingBase extends Item implements ICurioItem {

    protected String tooltip;
    public final Supplier<Boolean> isEnabled;
    public final GlintRenderTypes glintType;

    public ItemRingBase(Properties properties, String tooltip, Supplier<Boolean> enabled, GlintRenderTypes glintType) {
        super(properties.stacksTo(1));
        this.tooltip = tooltip;
        this.isEnabled = enabled;
        this.glintType = glintType;
        ModItems.allRings.add(this);
    }

    @Override
    public @NotNull Component getName(@NotNull ItemStack stack) {
        return super.getName(stack).copy().withStyle(ChatFormatting.LIGHT_PURPLE);
    }

    public void tickCurio(String identifier, int index, LivingEntity livingEntity) {}

    public Multimap<Holder<Attribute>, AttributeModifier> curioModifiers(ItemStack stack, String identifier) {
        return HashMultimap.create();
    }

    public void onEquippedCurio(String identifier, LivingEntity livingEntity) {}

    public void onUnequippedCurio(String identifier, LivingEntity livingEntity) {}

    public List<Component> getAttributesTooltip(List<Component> tooltips) {
        return tooltips;
    }

    @Override
    public void curioTick(SlotContext slotContext, ItemStack stack) {
        if (!slotContext.cosmetic())
            tickCurio(slotContext.identifier(), slotContext.index(), slotContext.entity());
    }

    @Override
    public void onEquip(SlotContext slotContext, ItemStack prevStack, ItemStack stack) {
        if (!slotContext.cosmetic())
            onEquippedCurio(slotContext.identifier(), slotContext.entity());
    }

    @Override
    public void onUnequip(SlotContext slotContext, ItemStack newStack, ItemStack stack) {
        if (!slotContext.cosmetic())
            onUnequippedCurio(slotContext.identifier(), slotContext.entity());
    }

    @Override
    public boolean canEquip(SlotContext slotContext, ItemStack stack) {
        return !slotContext.cosmetic();
    }

    @Override
    public boolean canEquipFromUse(SlotContext slotContext, ItemStack stack) {
        return true;
    }

    @NotNull
    @Override
    public ICurio.SoundInfo getEquipSound(SlotContext slotContext, ItemStack stack) {
        return new ICurio.SoundInfo(SoundEvents.ARMOR_EQUIP_GOLD.value(), 1.0F, 1.0F);
    }

    @Override
    public Multimap<Holder<Attribute>, AttributeModifier> getAttributeModifiers(SlotContext slotContext, ResourceLocation id, ItemStack stack) {
        return curioModifiers(stack, slotContext.identifier());
    }

    @Override
    public List<Component> getSlotsTooltip(List<Component> tooltips, Item.TooltipContext context, ItemStack stack) {
        List<Component> tooltipList = ICurioItem.super.getSlotsTooltip(tooltips, context, stack);
        return replaceTooltips(tooltipList);
    }

    @Override
    public List<Component> getAttributesTooltip(List<Component> tooltips, Item.TooltipContext context, ItemStack stack) {
        List<Component> tooltipList = ICurioItem.super.getAttributesTooltip(tooltips, context, stack);
        return this.getAttributesTooltip(replaceTooltips(tooltipList));
    }

    private static List<Component> replaceTooltips(List<Component> tooltips) {
        List<Component> recolored = new java.util.ArrayList<>(tooltips.size());
        for (Component tooltip : tooltips) {
            recolored.add(changeColors(tooltip, TextColor.fromLegacyFormat(ChatFormatting.GOLD), TextColor.fromLegacyFormat(ChatFormatting.GRAY)));
        }
        return recolored;
    }

    private static Component changeColors(Component component, TextColor from, TextColor to) {
        MutableComponent mutable = component.copy();

        if (Objects.equals(mutable.getStyle().getColor(), from))
            mutable.setStyle(mutable.getStyle().withColor(to));

        mutable.getSiblings().replaceAll(component1 -> changeColors(component1, from, to));

        return mutable;
    }

    @Override
    public boolean isEnchantable(@NotNull ItemStack stack) {
        return false;
    }

    @Override
    public boolean isFoil(@NotNull ItemStack stack) {
        return true;
    }

    @Override
    public void appendHoverText(@NotNull ItemStack stack, Item.TooltipContext context, @NotNull List<Component> tooltip, @NotNull TooltipFlag flag) {
        super.appendHoverText(stack, context, tooltip, flag);
        if (this.tooltip == null) return;

        tooltip.add(Component.literal(""));
        tooltip.add(Component.literal(ChatFormatting.GRAY + Component.translatable("tooltip.ringsofascensionreborn.worn").getString()));
        tooltip.add(Component.literal(ChatFormatting.BLUE + Component.translatable(this.tooltip).getString()));
    }

}
