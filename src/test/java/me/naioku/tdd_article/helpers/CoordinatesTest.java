package me.naioku.tdd_article.helpers;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class CoordinatesTest {

    public static Stream<Arguments> createStreamOfIllegalCoordinates() {
        return Stream.of(
                Arguments.of(-1D, -1D),
                Arguments.of(-2D, 0D),
                Arguments.of(0D, -4D),
                Arguments.of(101D, 101D),
                Arguments.of(101D, 100D),
                Arguments.of(100D, 101D),
                Arguments.of(-1D, 101D),
                Arguments.of(101D, -1D)
        );
    }

    public static Stream<Arguments> createStreamOfLegalCoordinates() {
        return Stream.of(
                Arguments.of(0D, 100D),
                Arguments.of(100D, 0D),
                Arguments.of(10D, 72D)
        );
    }

    @ParameterizedTest
    @MethodSource("createStreamOfIllegalCoordinates")
    void shouldThrowExceptionWhenCoordinatesAreOutOfRangeOfTheMap(double x, double y) {
        // given
        // when
        // x, y

        // then
        assertThrows(IllegalArgumentException.class, () -> new Coordinates(x, y));
    }

    @ParameterizedTest
    @MethodSource("createStreamOfLegalCoordinates")
    void shouldNotThrowExceptionWhenCoordinatesAreInRangeOfTheMap(double x, double y) {
        // given
        // x, y

        // when
        new Coordinates(x, y);

        // then
        // no error
    }
}