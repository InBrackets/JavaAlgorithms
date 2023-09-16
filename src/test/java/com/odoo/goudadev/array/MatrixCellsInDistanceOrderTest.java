package com.odoo.goudadev.array;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com.odoo.goudadev.utils.extensions.TestTags.EASY;
import static org.assertj.core.api.Assertions.assertThat;

@Tags({
    @Tag(EASY)
})
class MatrixCellsInDistanceOrderTest extends AbstractTest {

    MatrixCellsInDistanceOrder base = new MatrixCellsInDistanceOrder();

    @ParameterizedTest(name = "Case {index}: rows={0}, cols={1}, rCenter={2}, cCenter={3}, output={4}")
    @MethodSource("generateTestData")
    void testAllCellsDistOrder_24ms(int rows, int cols, int rCenter, int cCenter, int[][] output) {
        assertThat(base.allCellsDistOrder_24ms(rows, cols, rCenter, cCenter)).isDeepEqualTo(output);
    }

    @ParameterizedTest(name = "Case {index}: rows={0}, cols={1}, rCenter={2}, cCenter={3}, output={4}")
    @MethodSource("generateTestData")
    void testAllCellsDistOrder_4ms(int rows, int cols, int rCenter, int cCenter, int[][] output) {
        assertThat(base.allCellsDistOrder_4ms(rows, cols, rCenter, cCenter)).isDeepEqualTo(output);
    }

    @Override
    public Stream<Arguments> generateTestData() {
        return Stream.of(
            Arguments.of(
                1,
                2,
                0,
                0,
                new int[][]{{0, 0}, {0, 1}}
            ),
            Arguments.of(
                2,
                2,
                0,
                1,
                new int[][]{{0, 1}, {0, 0}, {1, 1}, {1, 0}}
            ),
            Arguments.of(
                2,
                3,
                1,
                2,
                new int[][]{{1, 2}, {0, 2}, {1, 1}, {0, 1}, {1, 0}, {0, 0}}
            )
        );
    }
}