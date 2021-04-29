package hu.nive.ujratervezes.kepesitovizsga.army;

public abstract class MilitaryUnit {
    private int hitPoints;
    private int damage;
    private boolean armor;

    public MilitaryUnit() {
    }

    public boolean isArmor() {
        return armor;
    }

    public void setHitPoints(int kick) {
        this.hitPoints = this.hitPoints-kick;
    }

    public int getDamage() {
        return damage;
    }

    public MilitaryUnit(int hitPoints, int damage, boolean armor) {
        this.hitPoints = hitPoints;
        this.damage = damage;
        this.armor = armor;
    }

    public int doDamage() {
        return damage;
    }

    public int getHitPoints(){
        return hitPoints;
    }

    public void sufferDamage(int damage) {
        if (armor) {
            hitPoints -= (damage / 2);
        }else{
            hitPoints -= damage;
        }
    }


}
