package me.naioku.tdd_article.weapon;

import me.naioku.tdd_article.animation.DistanceWeaponAnimation;
import me.naioku.tdd_article.entities.Entity;

public class Bow extends Weapon {

    private int ammoQuantity = 10;

    public Bow() {
        attackDamage = 25;
        weaponAnimation = new DistanceWeaponAnimation();
        sufficientDistanceToHurt = 100D;
    }

    @Override
    public void attack(Entity entity) {
        if (doesYouHaveEnoughAmmo()) {
            drawWeaponAnimation();
            doDamage(entity);
            ammoQuantity--;
        } else {
            drawNoAmmoAnimation();
        }
    }

    private void drawNoAmmoAnimation() {
        weaponAnimation.noAmmoAnimation();
    }

    private boolean doesYouHaveEnoughAmmo() {
        return ammoQuantity > 0;
    }


}
