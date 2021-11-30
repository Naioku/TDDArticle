package me.naioku.tdd_article.weapon;

import me.naioku.tdd_article.animation.CloseWeaponAnimation;
import me.naioku.tdd_article.entities.Entity;

public class LongSword extends Weapon {

    public LongSword() {
        attackDamage = 30;
        weaponAnimation = new CloseWeaponAnimation();
        sufficientDistanceToHurt = 12D;
    }
}
