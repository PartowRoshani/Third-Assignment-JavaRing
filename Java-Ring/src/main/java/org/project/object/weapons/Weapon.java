package org.project.object.weapons;

import org.project.entity.Entity;
import org.project.object.Object;

// TODO: UPDATE IMPLEMENTATION
public abstract class Weapon implements Object {
    private final String name;
    private final String description;
    private final int damage;
    private final int manaCost;

    /*
    TODO: ADD OTHER REQUIRED AND BONUS ATTRIBUTES
    */

    public Weapon(String name, String description, int damage, int manaCost) {
        this.name = name;
        this.description = description;
        this.damage = damage;
        this.manaCost = manaCost;
    }


    public abstract void use(Entity target);

    public int getDamage() {
        return damage;
    }

    public int getManaCost() {
        return manaCost;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }


    /*
    TODO: ADD OTHER REQUIRED AND BONUS METHODS
    */
}
