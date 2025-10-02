package net.jfgz3000.tutorialmod.item;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoodProperties {
    public static final FoodProperties RADISH = new FoodProperties.Builder().nutrition(5).saturationModifier(0.25f)
            .effect(() ->new MobEffectInstance(MobEffects.HEALTH_BOOST, 400),0.5f).build();
    public static final FoodProperties GRANADA = new FoodProperties.Builder().nutrition(8).saturationModifier(0.25f)
            .effect(() ->new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 400),0.5f).build();


}
