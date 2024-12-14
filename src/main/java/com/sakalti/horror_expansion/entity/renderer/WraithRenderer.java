package com.sakalti.horror_expansion.entity.renderer;

import com.mojang.blaze3d.systems.RenderSystem;
import com.sakalti.horror_expansion.HorrorExpansionMod;
import com.sakalti.horror_expansion.entity.WraithEntity;
import com.sakalti.horror_expansion.entity.model.WraithModel;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;
import net.minecraft.util.Identifier;

public class WraithRenderer extends EntityRenderer<WraithEntity> {
    private static final Identifier TEXTURE = new Identifier(HorrorExpansionMod.MOD_ID, "textures/entity/wraith.png");
    private final WraithModel model;

    public WraithRenderer(EntityRendererFactory.Context context) {
        super(context);
        this.model = new WraithModel();
    }

    @Override
    public void render(WraithEntity entity, float yaw, float tickDelta, MatrixStack matrices, net.minecraft.client.render.VertexConsumerProvider vertexConsumers, int light) {
        RenderSystem.setShaderTexture(0, TEXTURE);
        this.model.render(matrices, vertexConsumers.getBuffer(this.model.getLayer(TEXTURE)), light, OverlayTexture.DEFAULT_UV, 1.0F, 1.0F, 1.0F, 1.0F);
    }

    @Override
    public Identifier getTexture(WraithEntity entity) {
        return TEXTURE;
    }
}
