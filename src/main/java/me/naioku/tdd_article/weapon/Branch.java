package me.naioku.tdd_article.weapon;

import me.naioku.tdd_article.animation.CloseWeaponAnimation;

public class Branch extends Weapon {

    public Branch() {
        attackDamage = 10;
        weaponAnimation = new CloseWeaponAnimation();
        sufficientDistanceToHurt = 5.5D;
    }
}
