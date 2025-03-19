package org.project.object.armors;

import org.project.entity.players.Knight;

public class KnightArmor extends Armor {

    private static final int MANA_DRAIN = 5;

    public KnightArmor() {
        super("Knight Armor",40 , 100);
    }

    @Override
    public void takeDamage(int damage) {
        if (!isBroke()) {
            int reducedDamage = (int) (damage * 0.7);
            super.takeDamage(reducedDamage);
        }
    }

    public int drainMana() {
        return MANA_DRAIN;
    }
}
