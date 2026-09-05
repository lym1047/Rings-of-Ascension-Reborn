package com.ming.ringsofascension_reborn;

import com.ming.ringsofascension_reborn.client.GlintHandler;
import net.minecraft.client.renderer.RenderType;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.client.event.RegisterRenderBuffersEvent;
import net.neoforged.neoforge.client.gui.ConfigurationScreen;
import net.neoforged.neoforge.client.gui.IConfigScreenFactory;

@Mod(value = RingsOfAscensionReborn.MODID, dist = Dist.CLIENT)
@EventBusSubscriber(modid = RingsOfAscensionReborn.MODID, value = Dist.CLIENT)
public class RingsOfAscensionRebornClient {

    public RingsOfAscensionRebornClient(ModContainer container) {
        container.registerExtensionPoint(IConfigScreenFactory.class, ConfigurationScreen::new);
    }

    @SubscribeEvent
    public static void onRegisterRenderBuffers(RegisterRenderBuffersEvent event) {
        for (RenderType glint : GlintHandler.glintMap.values()) {
            event.registerRenderBuffer(glint);
        }
        for (RenderType translucent : GlintHandler.translucentMap.values()) {
            event.registerRenderBuffer(translucent);
        }
    }
}
