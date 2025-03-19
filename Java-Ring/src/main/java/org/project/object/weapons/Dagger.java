package org.project.object.weapons;

import org.project.entity.Entity;
import java.util.ArrayList;

public class Dagger extends Weapon {
    private int abilityCharge;

    public Dagger() {
        super("Dagger", "A lightweight blade that allows for swift attacks.", 15, 3);
        this.abilityCharge = 0;
    }

    @Override
    public void use(Entity target) {
        target.takeDamage(getDamage());
        System.out.println(getName() + " stabs " + target.getName() + " for " + getDamage() + " damage!");
    }

    // Unique Ability: Double Strike
    public void uniqueAbility(Entity target) {
        if (abilityCharge >= 3) {
            target.takeDamage(getDamage());
            target.takeDamage(getDamage());
            System.out.println(getName() + " performs a Double Strike on " + target.getName() + ", dealing " + (2 * getDamage()) + " damage!");
            abilityCharge = 0; // Reset charge
        } else {
            System.out.println(getName() + " needs more charge to use Double Strike! (" + (3 - abilityCharge) + " turns left)");
        }
    }

    public void chargeAbility() {
        abilityCharge++;
    }
}
