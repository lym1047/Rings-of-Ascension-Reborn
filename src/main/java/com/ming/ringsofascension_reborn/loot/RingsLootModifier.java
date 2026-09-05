package com.ming.ringsofascension_reborn.loot;

import com.ming.ringsofascension_reborn.RingsOfAscensionReborn;
import com.ming.ringsofascension_reborn.item.ItemRingBase;
import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.neoforged.neoforge.common.loot.IGlobalLootModifier;
import net.neoforged.neoforge.common.loot.LootModifier;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class RingsLootModifier extends LootModifier {

    public static final DeferredRegister<MapCodec<? extends IGlobalLootModifier>> REGISTER = DeferredRegister.create(NeoForgeRegistries.Keys.GLOBAL_LOOT_MODIFIER_SERIALIZERS, RingsOfAscensionReborn.MODID);
    public static final DeferredHolder<MapCodec<? extends IGlobalLootModifier>, MapCodec<RingsLootModifier>> CODEC = REGISTER.register("rings_modifier", () ->
            RecordCodecBuilder.mapCodec(
                    inst -> LootModifier.codecStart(inst).and(
                            inst.group(
                                    Codec.list(Codec.STRING).fieldOf("loot_tables").forGetter(m -> m.lootTables),
                                    ResourceLocation.CODEC.fieldOf("ring").forGetter(m -> m.ring)
                            )
                    ).apply(inst, RingsLootModifier::new)
            )
    );

    public final List<String> lootTables;
    public final ResourceLocation ring;

    public RingsLootModifier(LootItemCondition[] conditionsIn, List<String> lootTables, ResourceLocation ring) {
        super(conditionsIn);
        this.lootTables = lootTables;
        this.ring = ring;
    }

    @Override
    protected @NotNull ObjectArrayList<ItemStack> doApply(ObjectArrayList<ItemStack> generatedLoot, LootContext context) {
        if (lootTables.contains(context.getQueriedLootTableId().toString())) {
            if (context.getLevel().registryAccess().registryOrThrow(Registries.ITEM).get(ring) instanceof ItemRingBase item
                    && item.isEnabled.get()) {
                generatedLoot.add(new ItemStack(item));
            }
        }

        return generatedLoot;
    }

    @Override
    public MapCodec<? extends IGlobalLootModifier> codec() {
        return CODEC.get();
    }

}
