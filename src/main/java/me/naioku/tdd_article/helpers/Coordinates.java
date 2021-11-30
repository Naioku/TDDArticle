package me.naioku.tdd_article.helpers;

import me.naioku.tdd_article.entities.Entity;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Coordinates {

    private static final Map<Coordinates, Entity> entitiesPositions = new HashMap<>();
    double x;
    double y;

    public Coordinates(double x, double y) {
        if ((x > 100 || y > 100) || (x < 0 || y < 0)) {
            throw new IllegalArgumentException("You cannot set entity out of current map!");
        } else {
            this.x = x;
            this.y = y;
        }
    }

    public double getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Object getItem() {
        return Coordinates.entitiesPositions.get(this);
    }

    public void addEntityToTheEntitiesPositionsList(Entity entity) {
        Coordinates.entitiesPositions.put(this, entity);
    }

    public void clearCurrentPositionFromList() {
        Coordinates.entitiesPositions.remove(this);
    }

    public static void clearPositionsList() {
        entitiesPositions.clear();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordinates that = (Coordinates) o;
        return Double.compare(that.x, x) == 0 && Double.compare(that.y, y) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
