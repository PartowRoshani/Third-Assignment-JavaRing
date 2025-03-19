package org.project.object.consumables;

import org.project.entity.Entity;

public abstract class Consumable {
    private String name;
    private int effectValue;

    public Consumable(String name, int effectValue) {
        this.name = name;
        this.effectValue = effectValue;
    }

    public abstract void use(Entity target); 

    public String getName() {
        return name;
    }

    public int getEffectValue() {
        return effectValue;
    }
}
