package org.project.location;

import org.project.entity.enemies.Enemy;
import java.util.ArrayList;

public class Location {
    private String name;
    private ArrayList<Location> connectedLocations;
    private ArrayList<Enemy> enemies;

    public Location(String name) {
        this.name = name;
        this.connectedLocations = new ArrayList<>();
        this.enemies = new ArrayList<>();
    }

    public void addConnectedLocation(Location location) {
        connectedLocations.add(location);
    }

    public void addEnemy(Enemy enemy) {
        enemies.add(enemy);
    }

    public void resetLocation() {
        enemies.clear();
    }

    public String getName() {
        return name;
    }

    public ArrayList<Location> getConnectedLocations() {
        return connectedLocations;
    }

    public ArrayList<Enemy> getEnemies() {
        return enemies;
    }
}
