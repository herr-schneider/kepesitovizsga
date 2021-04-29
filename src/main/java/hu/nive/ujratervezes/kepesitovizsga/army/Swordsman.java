package hu.nive.ujratervezes.kepesitovizsga.army;

public class Swordsman extends MilitaryUnit {
    private boolean isAttach = false;

    public Swordsman(boolean armor) {
        super(100, 10, armor);
    }

    @Override
    public void sufferDamage(int damage) {
        if (isAttach) {
            if (isArmor()) {
                setHitPoints(damage / 2);
            } else {
                setHitPoints(damage);
            }
        }
        isAttach = true;
    }
}
