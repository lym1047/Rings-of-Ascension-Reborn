package com.ming.ringsofascension_reborn.client;

import com.ming.ringsofascension_reborn.RingsOfAscensionReborn;
import com.ming.ringsofascension_reborn.item.ItemRingBase;
import com.mojang.blaze3d.vertex.DefaultVertexFormat;
import com.mojang.blaze3d.vertex.VertexFormat;
import net.minecraft.client.renderer.RenderStateShard;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;

import java.util.LinkedHashMap;
import java.util.Map;

public class GlintHandler {

    private static final ThreadLocal<ItemStack> stack = new ThreadLocal<>();

    public static final Map<GlintRenderTypes, RenderType> glintMap = new LinkedHashMap<>();
    public static final Map<GlintRenderTypes, RenderType> translucentMap = new LinkedHashMap<>();

    static {
        for (GlintRenderTypes glint : GlintRenderTypes.values()) {
            glintMap.put(glint, buildGlintRenderType(glint.name));
            translucentMap.put(glint, buildGlintTranslucentRenderType(glint.name));
        }
    }

    public static void setStack(ItemStack value) {
        stack.set(value);
    }

    public static void clearStack() {
        stack.remove();
    }

    public static RenderType getGlintTranslucent() {
        GlintRenderTypes color = getColor(stack.get());
        return color == null ? RenderType.glintTranslucent() : translucentMap.get(color);
    }

    public static RenderType getGlint() {
        GlintRenderTypes color = getColor(stack.get());
        return color == null ? RenderType.glint() : glintMap.get(color);
    }

    private static GlintRenderTypes getColor(ItemStack value) {
        if (value == null || !(value.getItem() instanceof ItemRingBase item)) return null;
        return item.glintType;
    }

    private static RenderType buildGlintRenderType(String colorName) {
        return RenderType.create("glint_" + colorName, DefaultVertexFormat.POSITION_TEX, VertexFormat.Mode.QUADS, 1536, RenderType.CompositeState.builder()
                .setShaderState(RenderStateShard.RENDERTYPE_GLINT_SHADER)
                .setTextureState(new RenderStateShard.TextureStateShard(glintTexture(colorName), true, false))
                .setWriteMaskState(RenderStateShard.COLOR_WRITE)
                .setCullState(RenderStateShard.NO_CULL)
                .setDepthTestState(RenderStateShard.EQUAL_DEPTH_TEST)
                .setTransparencyState(RenderStateShard.GLINT_TRANSPARENCY)
                .setTexturingState(RenderStateShard.GLINT_TEXTURING)
                .createCompositeState(false));
    }

    private static RenderType buildGlintTranslucentRenderType(String colorName) {
        return RenderType.create("glint_translucent_" + colorName, DefaultVertexFormat.POSITION_TEX, VertexFormat.Mode.QUADS, 1536, RenderType.CompositeState.builder()
                .setShaderState(RenderStateShard.RENDERTYPE_GLINT_TRANSLUCENT_SHADER)
                .setTextureState(new RenderStateShard.TextureStateShard(glintTexture(colorName), true, false))
                .setWriteMaskState(RenderStateShard.COLOR_WRITE)
                .setCullState(RenderStateShard.NO_CULL)
                .setDepthTestState(RenderStateShard.EQUAL_DEPTH_TEST)
                .setTransparencyState(RenderStateShard.GLINT_TRANSPARENCY)
                .setTexturingState(RenderStateShard.GLINT_TEXTURING)
                .setOutputState(RenderStateShard.ITEM_ENTITY_TARGET)
                .createCompositeState(false));
    }

    private static ResourceLocation glintTexture(String colorName) {
        return ResourceLocation.fromNamespaceAndPath(RingsOfAscensionReborn.MODID, "textures/glint/glint_" + colorName + ".png");
    }

}
