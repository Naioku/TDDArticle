package me.naioku.tdd_article.services.distance;

import me.naioku.tdd_article.entities.Entity;
import me.naioku.tdd_article.helpers.Coordinates;

public class DistanceService {
    public boolean isDistanceSufficient(Entity entity1, Entity entity2, double sufficientDistance) {
        double distance = calculateDistance(entity1.getCoordinates(), entity2.getCoordinates());

        return distance <= sufficientDistance;
    }

    private double calculateDistance(Coordinates cord1, Coordinates cord2) {
        return Math.sqrt(Math.pow(cord1.getX() - cord2.getX(), 2) + Math.pow(cord1.getY() - cord2.getY(), 2));
    }
}
