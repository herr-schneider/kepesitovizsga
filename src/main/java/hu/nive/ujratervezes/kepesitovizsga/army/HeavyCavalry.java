package hu.nive.ujratervezes.kepesitovizsga.army;

public class HeavyCavalry extends MilitaryUnit {
    private int numOfAttach;

    public HeavyCavalry() {
        super(150, 20, true);
    }

    @Override
    public int doDamage() {
        if (numOfAttach < 1) {
            numOfAttach += 1;
            return 3 * getDamage();
        } else {
            numOfAttach += 1;
            return getDamage();
        }
    }
}
