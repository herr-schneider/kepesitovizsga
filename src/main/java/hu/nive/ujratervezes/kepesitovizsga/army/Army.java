package hu.nive.ujratervezes.kepesitovizsga.army;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Army {
    private List<MilitaryUnit> army = new ArrayList<>();

    public void addUnit(MilitaryUnit militaryUnit) {
        army.add(militaryUnit);
    }

    public void damageAll(int damage) {
        Iterator<MilitaryUnit> iterator = army.iterator();
        while (iterator.hasNext()) {
            MilitaryUnit unit = iterator.next();
            unit.sufferDamage(damage);
            if (unit.getHitPoints() < 25) {
                iterator.remove();
            }
        }
    }

    public int getArmyDamage() {
        int result = 0;
        for (MilitaryUnit unit : army) {
            result += unit.getDamage();
        }
        return result;
    }

    public int getArmySize(){
        return army.size();
    }

}