package com.odoo.goudadev.array;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BattleShipsInABoardTest extends AbstractTest {

    BattleShipsInABoard base = new BattleShipsInABoard();

    @ParameterizedTest(name = "Case {index}: board={0}, output={1}")
    @MethodSource("generateTestData")
    void testCountBattleships_121ms(char[][] board, int output) {
        assertEquals(output, base.countBattleships_121ms(board));
    }

    public Stream<Arguments> generateTestData() {
        return Stream.of(
            Arguments.of(
                new char[][]{{'X', '.', '.', 'X'}, {'.', '.', '.', 'X'}, {'.', '.', '.', 'X'}},
                2
            ),
            Arguments.of(
                new char[][]{{'.'}},
                0
            )
        );
    }
}