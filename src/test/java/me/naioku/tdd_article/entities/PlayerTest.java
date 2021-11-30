package me.naioku.tdd_article.entities;

import me.naioku.tdd_article.animation.CloseWeaponAnimation;
import me.naioku.tdd_article.animation.WeaponAnimation;
import me.naioku.tdd_article.helpers.Coordinates;
import me.naioku.tdd_article.weapon.Branch;
import me.naioku.tdd_article.weapon.Weapon;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class PlayerTest {


}