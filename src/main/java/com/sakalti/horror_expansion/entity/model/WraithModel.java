package com.sakalti.horror_expansion.entity.model;

import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.model.ModelPart;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;
import net.minecraft.util.Identifier;
import com.sakalti.horror_expansion.entity.WraithEntity;

public class WraithModel extends EntityModel<WraithEntity> {
    private final ModelPart body;
    private final ModelPart[] legs;

    public WraithModel() {
        this.body = new ModelPart(this, 0, 0);
        this.body.addCuboid(-6.0F, 0.0F, -6.0F, 12, 12, 12);
        this.legs = new ModelPart[4];
        for (int i = 0; i < 4; i++) {
            legs[i] = new ModelPart(this, 0, 24);
            legs[i].addCuboid(-2.0F, 0.0F, -2.0F, 4, 12, 4);
        }
    }

    @Override
    public void setAngles(WraithEntity entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {
        // 必要に応じてアニメーション処理を追加
    }

    @Override
    public void render(MatrixStack matrices, VertexConsumer vertices, int light, int overlay, float red, float green, float blue, float alpha) {
        body.render(matrices, vertices, light, overlay, red, green, blue, alpha);
        for (ModelPart leg : legs) {
            leg.render(matrices, vertices, light, overlay, red, green, blue, alpha);
        }
    }
}
