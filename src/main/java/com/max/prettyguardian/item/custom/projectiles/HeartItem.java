package com.max.prettyguardian.item.custom.projectiles;


import com.max.prettyguardian.entity.ModEntities;
import com.max.prettyguardian.entity.custom.projectile.HeartEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;

public class HeartItem extends Item {

    public final float damage;

    public HeartItem(Properties properties, float damage) {
        super(properties);
        this.damage = damage;
    }

    public HeartEntity createArrow(Level world, float damage) {
        return new HeartEntity(ModEntities.HEART.get(), world, damage);
    }
}
