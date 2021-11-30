package me.naioku.tdd_article.animation;

public class DistanceWeaponAnimation implements WeaponAnimation {
    @Override
    public void drawAnimation() {
        System.out.println("Drawing a DISTANCE weapon animation...");
    }

    @Override
    public void noAmmoAnimation() {
        System.out.println("Drawing a NO AMMO animation...");
    }
}
