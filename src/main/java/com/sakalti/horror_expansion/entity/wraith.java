package com.sakalti.horror_expansion.entity;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.AttributeSupplier;
import net.minecraft.entity.attribute.Attributes;
import net.minecraft.entity.ai.control.MoveControl;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.entity.mob.MobEntityWithAi;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;
import com.sakalti.horror_expansion.HorrorExpansionMod;

public class WraithEntity extends MobEntityWithAi {
    public WraithEntity(EntityType<? extends MobEntityWithAi> entityType, World world) {
        super(entityType, world);
        this.moveControl = new MoveControl(this);
    }

    @Override
    protected void initAttributes() {
        super.initAttributes();
        this.getAttributeInstance(Attributes.MAX_HEALTH).setBaseValue(54.0);
        this.getAttributeInstance(Attributes.ATTACK_DAMAGE).setBaseValue(6.0);
        this.getAttributeInstance(Attributes.MOVEMENT_SPEED).setBaseValue(0.3);
    }

    // AIタスク
    @Override
    protected void initGoals() {
        this.goalSelector.add(0, new WanderAroundGoal(this, 1.0D));
        this.goalSelector.add(1, new MeleeAttackGoal(this, 1.2D, true));
        this.goalSelector.add(2, new NearestAttackableTargetGoal<>(this, LivingEntity.class, true));
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return new SoundEvent(new Identifier(HorrorExpansionMod.MOD_ID, "entity.wraith.ambient"));
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return new SoundEvent(new Identifier(HorrorExpansionMod.MOD_ID, "entity.wraith.hurt"));
    }

    @Override
    protected SoundEvent getDeathSound() {
        return new SoundEvent(new Identifier(HorrorExpansionMod.MOD_ID, "entity.wraith.death"));
    }

    // 属性設定
    public static AttributeSupplier.Builder createAttributes() {
        return MobEntity.createMobAttributes()
            .add(Attributes.MAX_HEALTH, 54.0D)
            .add(Attributes.ATTACK_DAMAGE, 6.0D)
            .add(Attributes.MOVEMENT_SPEED, 0.3D);
    }

    // 近接攻撃の処理
    @Override
    public void attack(LivingEntity target) {
        super.attack(target);
    }
}
