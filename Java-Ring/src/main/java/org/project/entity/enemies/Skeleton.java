package org.project.entity.enemies;

import org.project.entity.Entity;
import org.project.object.armors.Armor;
import org.project.object.armors.PlateArmor;
import org.project.object.weapons.Sword;
import org.project.object.weapons.Weapon;

public class Skeleton extends Enemy {

    private boolean isDefending;
    private boolean isResurrected = false;  // Flag to check if the skeleton has been resurrected
    private static final int RESURRECTION_MANA_COST = 20; // Mana cost for resurrection
    private static final int RESURRECTION_COOLDOWN = 5; // Can resurrect after 5 rounds


    // Constructor to initialize Skeleton object with specific values
    public Skeleton(String name) {
        super(name, 100, 50, new Sword(), new PlateArmor(), 100, 50);
    }

    @Override
    public void useAbility(Entity target) {
        // Check if resurrection is needed and possible
        if (!isAlive() && !isResurrected) {
            if (getMp() >= RESURRECTION_MANA_COST) {
                fillMana(-RESURRECTION_MANA_COST); // Decrease mana for resurrection
                resurrect();
            } else {
                System.out.println(getName() + " does not have enough mana to resurrect!");
            }
        } else {
            System.out.println(getName() + " has no unique abilities to use right now.");
        }
    }

    @Override
    public void equipWeapon(Weapon weapon) {
        if (weapon != null) {
            super.equipWeapon(weapon); // Equip weapon
            System.out.println(getName() + " equipped a new weapon: " + weapon.getName());
        } else {
            System.out.println(getName() + " tried to equip weapon, but it was null!");
        }
    }

    @Override
    public void equipArmor(Armor armor) {
        if (armor != null) {
            super.equipArmor(armor); // Equip armor
            System.out.println(getName() + " equipped a new armor: " + armor.getName());
        } else {
            System.out.println(getName() + " tried to equip armor, but it was null!");
        }
    }

    @Override
    public String getName() {
        return "Skeleton";
    }

    @Override
    public Weapon getWeapon() {
        return null;
    }

    // Resurrect the Skeleton when defeated
    private void resurrect() {
        if (!isResurrected) {
            setHp(getMaxHP() / 2); // Revive with 50% of max HP
            isResurrected = true;
            System.out.println(getName() + " has resurrected with " + (getMaxHP() / 2) + " HP!");
        } else {
            System.out.println(getName() + " has already resurrected once.");
        }
    }

    private void setHp(int i) {
    }

    @Override
    public void takeDamage(int damage) {
        if (isResurrected && getHp() <= 0) {
            System.out.println(getName() + " is already dead and can't take more damage.");
        } else {
            super.takeDamage(damage);
        }
    }

    @Override
    public int getHp() {
        return 0;
    }

    @Override
    public int getMp() {
        return 0;
    }
    @Override
    public boolean isDefending() {
        return isDefending;
    }

    public void defend() {
        isDefending = true;
        System.out.println(getName() + " is now defending!");
    }

    public void stopDefending() {
        isDefending = false;
        System.out.println(getName() + " stopped defending!");
    }

    // You can override other methods if necessary (attack, heal, etc.)
}