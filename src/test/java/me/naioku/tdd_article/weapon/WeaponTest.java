package me.naioku.tdd_article.weapon;

import me.naioku.tdd_article.entities.Entity;
import me.naioku.tdd_article.entities.NPC;
import me.naioku.tdd_article.entities.Player;
import me.naioku.tdd_article.helpers.Coordinates;
import me.naioku.tdd_article.services.distance.DistanceService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class WeaponTest {

    @InjectMocks
    Weapon longSword = new LongSword();

    @Mock
    DistanceService distanceService;

    @Mock
    Entity owner;



    @ParameterizedTest
    @MethodSource("createAllWeaponsType")
    void attackShouldDealDamageToTargetWhenTheTargetIsSetInProperDistance(Weapon weapon) {
        // given
        Player player = new Player(100, new Coordinates(0, 0));
        weapon.setOwner(player);

        int npcHealth = 100;
        NPC npc1 = new NPC(npcHealth, new Coordinates(0, weapon.sufficientDistanceToHurt));
        NPC npc2 = new NPC(npcHealth, new Coordinates(0, 0));

        // when
        weapon.attack(npc1);
        weapon.attack(npc2);

        // then
        assertThat(npc1.getHealth()).isEqualTo(npcHealth - weapon.attackDamage);
        assertThat(npc2.getHealth()).isEqualTo(npcHealth - weapon.attackDamage);
    }

    @ParameterizedTest
    @MethodSource("createAllWeaponsType")
    void attackShouldNotDealDamageToTargetWhenTheTargetIsSetTooFar(Weapon weapon) {
        // given
        Player player = new Player(100, new Coordinates(0, 0));
        weapon.setOwner(player);

        int npcHealth = 100;
        NPC npc = new NPC(npcHealth, new Coordinates(0, weapon.sufficientDistanceToHurt + 0.1));

        // when
        weapon.attack(npc);

        // then
        assertThat(npc.getHealth()).isEqualTo(npcHealth);
    }

    private static Stream<Arguments> createAllWeaponsType() {
        return Stream.of(
                Arguments.of(new Branch()),
                Arguments.of(new LongSword()),
                Arguments.of(new Bow())
        );
    }

    @Test
    void targetShouldBeDamagedWithProperValueWhenDistanceIsSufficient() {
        // given
        Entity entity = new NPC(100, new Coordinates(50, 50));
        given(distanceService.isDistanceSufficient(any(Entity.class), any(Entity.class), any(Double.class))).willReturn(true);

        // when
        longSword.doDamage(entity);

        // then
        assertThat(entity.getHealth()).isEqualTo(100 - longSword.getAttackDamage());
    }
}