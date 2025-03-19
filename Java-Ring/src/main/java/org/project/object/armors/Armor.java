package org.project.object.armors;

public abstract class Armor {

    private String name;
    private int defense;
    private final int maxDefense;
    private int durability;
    private final int maxDurability;

    private boolean isBroke;

    public Armor(String name,int defense, int durability) {
        this.defense = this.maxDefense = defense;
        this.durability = this.maxDurability = durability;
        this.isBroke = false;
        this.name = getName();
    }

    public void checkBreak() {
        if (durability <= 0) {
            isBroke = true;
            defense = 0;
        }
    }

    public void takeDamage(int damage) {
        if (!isBroke) {
            durability -= damage / 2;
            checkBreak();
            if (!isBroke) {
                degrade();
            }
        }
    }

    public void degrade() {
        if (!isBroke) {
            defense = Math.max(1, (int) (maxDefense * ((double) durability / maxDurability)));
        }
    }


    public void repair() {
        if (isBroke) {
            isBroke = false;
            defense = maxDefense;
            durability = maxDurability;
        }
    }


    public int getDefense() {
        return defense;
    }

    public int getDurability() {
        return durability;
    }

    public boolean isBroke() {
        return isBroke;
    }


    public String getName() {
        return name;
    }

}
