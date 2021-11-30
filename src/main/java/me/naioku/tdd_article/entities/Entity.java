package me.naioku.tdd_article.entities;

import me.naioku.tdd_article.animation.EntityMoveAnimation;
import me.naioku.tdd_article.custom_exceptions.MoveException;
import me.naioku.tdd_article.helpers.Coordinates;
import me.naioku.tdd_article.messages.Messages;
import me.naioku.tdd_article.services.move.MoveService;
import me.naioku.tdd_article.weapon.Weapon;

public abstract class Entity {
    int health;
    Coordinates coordinates;

    Entity markedEntity;
    int goldQuantity;
    Weapon weapon;
    EntityMoveAnimation animation = new EntityMoveAnimation();
    MoveService moveService = new MoveService(this);

    public Entity(int health, Coordinates coordinates) {
        this.health = health;
        setCoordinates(coordinates);
    }

    public void attack() {
        weapon.attack(markedEntity);
    }

    public void walkAhead() {
        animation.walkAheadAnimation();
    }

    public void markFacingEntity(Entity markedEntity) {
        this.markedEntity = markedEntity;
    }

    public void addGold(int addedGold) {
        goldQuantity += addedGold;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        if (this.coordinates != null) {
            this.coordinates.clearCurrentPositionFromList();
        }

        this.coordinates = coordinates;
        coordinates.addEntityToTheEntitiesPositionsList(this);
    }

    // You must test it. Check if weapon's owner is set properly.
    // In TDD You would do the same.
    public void setWeapon(Weapon weapon) {
        weapon.setOwner(this);
        this.weapon = weapon;
    }

    // You must test if moveNorth etc. won't throw an unhandled exception. As You want to handle it here...
    public void moveNorth() {
        try {
            moveService.moveNorth();
        } catch (MoveException e) {
            System.out.println(Messages.cannotMoveNorth);
        }
    }

    public void moveSouth() {
        try {
            moveService.moveSouth();
        } catch (MoveException e) {
            System.out.println(Messages.cannotMoveSouth);
        }
    }

    public void moveEast() {
        try {
            moveService.moveEast();
        } catch (MoveException e) {
            System.out.println(Messages.cannotMoveEast);
        }
    }

    public void moveWest() {
        try {
            moveService.moveWest();
        } catch (MoveException e) {
            System.out.println(Messages.cannotMoveWest);
        }
    }
}
