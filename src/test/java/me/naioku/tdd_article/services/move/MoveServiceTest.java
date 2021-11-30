package me.naioku.tdd_article.services.move;

import me.naioku.tdd_article.custom_exceptions.MoveException;
import me.naioku.tdd_article.entities.Entity;
import me.naioku.tdd_article.entities.NPC;
import me.naioku.tdd_article.entities.Player;
import me.naioku.tdd_article.helpers.Coordinates;
import me.naioku.tdd_article.services.move.MoveService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class MoveServiceTest {

    @BeforeEach
    void clearPositionsList() {
        Coordinates.clearPositionsList();
    }

    @Test
    void movingNorthWithoutAnyObstacleShouldAdd1ToYCoordinate() throws MoveException {
        // given
        Coordinates startMoveCoordinates = new Coordinates(50, 50);
        Player player = new Player(100, startMoveCoordinates);

        MoveService moveService = new MoveService(player);
        Coordinates endMoveCoordinates = new Coordinates(50, startMoveCoordinates.getY()+1);

        // when
        moveService.moveNorth();

        // then
        assertThat(player.getCoordinates()).isEqualTo(endMoveCoordinates);
    }

    @Test
    void movingSouthWithoutAnyObstacleShouldSubtract1ToYCoordinate() throws MoveException {
        // given
        Coordinates startMoveCoordinates = new Coordinates(50, 50);
        Player player = new Player(100, startMoveCoordinates);

        MoveService moveService = new MoveService(player);
        Coordinates endMoveCoordinates = new Coordinates(50, startMoveCoordinates.getY()-1);

        // when
        moveService.moveSouth();

        // then
        assertThat(player.getCoordinates()).isEqualTo(endMoveCoordinates);
    }

    @Test
    void movingEastWithoutAnyObstacleShouldAdd1ToXCoordinate() throws MoveException {
        // given
        Coordinates startMoveCoordinates = new Coordinates(50, 50);
        Player player = new Player(100, startMoveCoordinates);

        MoveService moveService = new MoveService(player);
        Coordinates endMoveCoordinates = new Coordinates(startMoveCoordinates.getX()+1, 50);

        // when
        moveService.moveEast();

        // then
        assertThat(player.getCoordinates()).isEqualTo(endMoveCoordinates);
    }

    @Test
    void movingWestWithoutAnyObstacleShouldSubtract1ToXCoordinate() throws MoveException {
        // given
        Coordinates startMoveCoordinates = new Coordinates(50, 50);
        Player player = new Player(100, startMoveCoordinates);

        MoveService moveService = new MoveService(player);
        Coordinates endMoveCoordinates = new Coordinates(startMoveCoordinates.getX()-1, 50);

        // when
        moveService.moveWest();

        // then
        assertThat(player.getCoordinates()).isEqualTo(endMoveCoordinates);
    }

    // >>>>>>>>> MOCK <<<<<<<<<

//    @Test
//    void movingTowardsObstacleShouldResultInMoveException() {
//        // given
//        Coordinates startMoveCoordinates = new Coordinates(50, 50);
//        Player player = new Player(100, startMoveCoordinates);
//        MoveService moveService = new MoveService(player);
//
//        Coordinates obstacleCoordinates = new Coordinates(50, 51);
//        NPC npc = new NPC(100, obstacleCoordinates);
//
//        // when
//        // then
//        assertThrows(MoveException.class, moveService::moveNorth);
//    }

    @Test
    void movingTowardsObstacleShouldResultInMoveException() {
        // given
//        Coordinates startMoveCoordinates = new Coordinates(50, 50);
//        Player player = new Player(100, startMoveCoordinates);
        Player player = mock(Player.class);
        MoveService moveService = new MoveService(player);

        Coordinates newCoordinates = mock(Coordinates.class);
        when(newCoordinates.getItem()).thenReturn("anything");

        // when
        // then
        assertThrows(MoveException.class, () -> moveService.move(newCoordinates));
    }

    @Test
    void movingTowardsAnyDirectionWithoutObstacleShouldResultSetNewCoordinatesToEntity() throws MoveException {
        // given

        Player player = mock(Player.class);
        MoveService moveService = new MoveService(player);

        Coordinates newCoordinates = mock(Coordinates.class);
        when(newCoordinates.getItem()).thenReturn(null);

        // when
        moveService.move(newCoordinates);

        // then
        verify(player).setCoordinates(newCoordinates);
    }
}