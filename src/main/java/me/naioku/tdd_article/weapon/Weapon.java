package me.naioku.tdd_article.weapon;

import me.naioku.tdd_article.entities.Entity;
import me.naioku.tdd_article.animation.WeaponAnimation;
import me.naioku.tdd_article.services.distance.DistanceService;

public abstract class Weapon {
    Entity owner;
    int attackDamage;
    WeaponAnimation weaponAnimation;
    double sufficientDistanceToHurt;

    DistanceService distanceService = new DistanceService();

    public void attack(Entity entity) {
        drawWeaponAnimation();
        doDamage(entity);
    }

    void drawWeaponAnimation() {
        weaponAnimation.drawAnimation();
    }

    void doDamage(Entity entity) {
        if (distanceService.isDistanceSufficient(owner, entity, sufficientDistanceToHurt)) {
            entity.setHealth(entity.getHealth() - getAttackDamage());
        }
    }

    public void setOwner(Entity owner) {
        this.owner = owner;
    }

    public int getAttackDamage() {
        return attackDamage;
    }
}
