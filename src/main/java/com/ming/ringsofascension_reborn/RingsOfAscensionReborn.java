package com.ming.ringsofascension_reborn;

import com.ming.ringsofascension_reborn.config.Config;
import com.ming.ringsofascension_reborn.events.ApplyPotionEvent;
import com.ming.ringsofascension_reborn.events.PlayerDeathEvent;
import com.ming.ringsofascension_reborn.init.ModItems;
import com.ming.ringsofascension_reborn.loot.RingsLootModifier;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

@Mod(RingsOfAscensionReborn.MODID)
public class RingsOfAscensionReborn {

    public static final String MODID = "ringsofascensionreborn";

    private static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB_REGISTRY =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MODID);

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> CREATIVE_TAB =
            CREATIVE_MODE_TAB_REGISTRY.register("creative_tab", () -> CreativeModeTab.builder()
                    .title(Component.translatable("itemGroup." + MODID))
                    .icon(() -> new ItemStack(ModItems.ringExperience.get()))
                    .displayItems((params, output) -> {
                        for (Item entry : ModItems.allRings) {
                            output.accept(entry);
                        }
                    })
                    .build());

    public RingsOfAscensionReborn(IEventBus modEventBus, ModContainer modContainer) {
        modContainer.registerConfig(ModConfig.Type.COMMON, Config.SPEC);

        ModItems.init(modEventBus);
        RingsLootModifier.REGISTER.register(modEventBus);
        CREATIVE_MODE_TAB_REGISTRY.register(modEventBus);

        NeoForge.EVENT_BUS.register(new PlayerDeathEvent());
        NeoForge.EVENT_BUS.register(new ApplyPotionEvent());
    }

}
