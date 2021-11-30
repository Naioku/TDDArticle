package me.naioku.tdd_article.weapon;

import me.naioku.tdd_article.animation.CloseWeaponAnimation;
import me.naioku.tdd_article.animation.WeaponAnimation;
import me.naioku.tdd_article.entities.NPC;
import me.naioku.tdd_article.entities.Player;
import me.naioku.tdd_article.helpers.Coordinates;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class LongSwordTest {

    @Mock
    WeaponAnimation closeWeaponAnimation;

    @InjectMocks
    LongSword longSword;

    @BeforeEach
    void setWeaponOwner() {
        longSword.setOwner(new Player(100, new Coordinates(0, 0)));
    }

    @ParameterizedTest
    @MethodSource("createCoordinates")
    void attackShouldPrintProperAnimationNoMatterHowFarTargetIs() {
        // given
        NPC npc = new NPC(100, new Coordinates(0, 2));

        // when
        longSword.attack(npc);

        // then
        verify(closeWeaponAnimation).drawAnimation();
    }

    private static Stream<Arguments> createCoordinates() {
        return Stream.of(
                Arguments.of(new Coordinates(0, 1)),
                Arguments.of(new Coordinates(2, 2)),
                Arguments.of(new Coordinates(6, 6))
        );
    }
}