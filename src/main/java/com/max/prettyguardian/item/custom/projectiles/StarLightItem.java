package com.max.prettyguardian.item.custom.projectiles;


import com.max.prettyguardian.entity.ModEntities;
import com.max.prettyguardian.entity.custom.projectile.StarLightEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;

public class StarLightItem extends Item {
    public final float damage;

    public StarLightItem(Properties properties, float damage) {
        super(properties);
        this.damage = damage;
    }

    public StarLightEntity createArrow(Level world, float damage) {
        return new StarLightEntity(ModEntities.STAR_LIGHT.get(), world, damage);
    }
}
