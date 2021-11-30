package me.naioku.tdd_article.services.move;

import me.naioku.tdd_article.custom_exceptions.MoveException;
import me.naioku.tdd_article.entities.Entity;
import me.naioku.tdd_article.helpers.Coordinates;

public class MoveService {

    private Entity entity;

    public MoveService() {
    }

    public MoveService(Entity entity) {
        this.entity = entity;
    }

    public void moveNorth() throws MoveException {
        Coordinates newCoordinates = new Coordinates(getLastXCoordinate(), getLastYCoordinate()+1);
        move(newCoordinates);
    }

    public void moveSouth() throws MoveException {
        Coordinates newCoordinates = new Coordinates(getLastXCoordinate(), getLastYCoordinate()-1);
        move(newCoordinates);
    }

    public void moveEast() throws MoveException {
        Coordinates newCoordinates = new Coordinates(getLastXCoordinate()+1, getLastYCoordinate());
        move(newCoordinates);
    }

    public void moveWest() throws MoveException {
        Coordinates newCoordinates = new Coordinates(getLastXCoordinate()-1, getLastYCoordinate());
        move(newCoordinates);
    }

    void move(Coordinates newCoordinates) throws MoveException {
        if (newCoordinates.getItem() == null) {
            entity.setCoordinates(newCoordinates);
        } else {
            throw new MoveException("Cannot move through the obstacle!");
        }
    }

    double getLastXCoordinate() {
        return entity.getCoordinates().getX();
    }

    double getLastYCoordinate() {
        return entity.getCoordinates().getY();
    }
}
