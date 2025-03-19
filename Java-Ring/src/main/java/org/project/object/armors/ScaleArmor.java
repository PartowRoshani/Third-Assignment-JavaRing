package org.project.object.armors;

import org.project.entity.players.Player;

public class ScaleArmor extends Armor {
    private final double physicalResistance;

    public ScaleArmor() {
        super("Scale Armor", 25, 60);
        this.physicalResistance = 0.2;
    }

    @Override
    public void takeDamage(int damage) {
        int reducedDamage = (int) (damage * (1 - physicalResistance));
        super.takeDamage(reducedDamage);
        System.out.println(getName() + " reduces physical damage by " + (int)(physicalResistance * 100) + "%!");
    }

}
