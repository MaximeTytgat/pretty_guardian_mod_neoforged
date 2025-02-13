package com.max.prettyguardian.item.custom.projectiles;


import com.max.prettyguardian.entity.ModEntities;
import com.max.prettyguardian.entity.custom.projectile.BubbleEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;

public class BubbleItem extends Item {

    public final float damage;

    public BubbleItem(Properties properties, float damage) {
        super(properties);
        this.damage = damage;
    }

    public BubbleEntity createArrow(Level world) {
        return new BubbleEntity(ModEntities.BUBBLE.get(), world);
    }
}
