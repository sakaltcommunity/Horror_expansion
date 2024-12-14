package com.sakalti.horror_expansion;

import com.mojang.logging.LogUtils;
import com.sakalti.horror_expansion.entity.ModEntities;
import com.sakalti.horror_expansion.registry.ModBlocks;
import com.sakalti.horror_expansion.registry.ModDimensions;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientEntityEvents;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HorrorExpansionMod implements ModInitializer, ClientModInitializer {
    public static final String MOD_ID = "horror_expansion";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        ModEntities.registerEntities();
        ModBlocks.registerBlocks();
        ModDimensions.registerDimensions();
        LOGGER.info("初期化されました。");

        // ブロックの燃料登録など
        FuelRegistry.INSTANCE.add(ModBlocks.CURSED_STONE, 300);
    }

    @Override
    public void onInitializeClient() {
        ClientEntityEvents.ENTITY_LOAD.register((entity, clientWorld) -> {
            if (entity instanceof WraithEntity) {
                EntityRendererRegistry.register(ModEntities.WRAITH, (context) -> new WraithRenderer(context.getEntityRenderDispatcher()));
            }
        });
    }
}
