package org.project.entity.players;

import org.project.entity.Entity;
import org.project.object.armors.Armor;
import org.project.object.armors.PlateArmor;
import org.project.object.weapons.Sword;
import org.project.object.weapons.Weapon;

public class Knight extends Player {

    private int roundsPassed = 0;
    private static final int KICK_MANA_COST = 10;
    private static final int KICK_COOLDOWN = 3; // Each 3 rounds the kick can be used

    public Knight(String name) {
        super(name, 120, 30, new Sword(), new PlateArmor(), 120, 30);
    }

    @Override
    public void useAbility(Entity target) {
        if (roundsPassed >= KICK_COOLDOWN) {
            if (getMp() >= KICK_MANA_COST) {
                fillMana(-KICK_MANA_COST); // Reduce mana for the kick
                int kickDamage = 25;
                target.takeDamage(kickDamage);
                System.out.println(getName() + " performs a powerful kick, dealing " + kickDamage + " damage!");
                roundsPassed = 0; // Reset cooldown
            } else {
                System.out.println(getName() + " does not have enough mana to use Kick Attack!");
            }
        } else {
            System.out.println(getName() + " cannot use Kick Attack yet! " + (KICK_COOLDOWN - roundsPassed) + " turns left.");
        }
    }

    // This method should be called each round to increment roundsPassed for cooldown
    public void nextTurn() {
        roundsPassed++;
    }
}
