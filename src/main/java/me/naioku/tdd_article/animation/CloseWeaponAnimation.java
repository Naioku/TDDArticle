package me.naioku.tdd_article.animation;

public class CloseWeaponAnimation implements WeaponAnimation {

    @Override
    public void drawAnimation() {
        System.out.println("Drawing a CLOSE weapon animation...");
    }

    @Override
    public void noAmmoAnimation() {

    }
}
