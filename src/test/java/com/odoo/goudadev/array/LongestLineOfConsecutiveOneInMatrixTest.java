package com.odoo.goudadev.array;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com.odoo.goudadev.utils.extensions.TestTags.MEDIUM;
import static com.odoo.goudadev.utils.extensions.TestTags.PREMIUM;
import static org.junit.jupiter.api.Assertions.assertEquals;

@Tags({
    @Tag(PREMIUM),
    @Tag(MEDIUM)
})
class LongestLineOfConsecutiveOneInMatrixTest extends AbstractTest {

    LongestLineOfConsecutiveOneInMatrix base = new LongestLineOfConsecutiveOneInMatrix();

    @ParameterizedTest(name = "Case {index}: matrix={0}, output={1}")
    @MethodSource("generateTestData")
    void testLongestLine(int[][] matrix, int output) {
        assertEquals(output, base.longestLine(matrix));
    }

    @Override
    public Stream<Arguments> generateTestData() {
        return Stream.of(
            Arguments.of(
                new int[][] {
                    {1, 1, 0, 0, 1, 0, 0, 1, 1, 0},
                    {1, 0, 0, 1, 0, 1, 1, 1, 1, 1},
                    {1, 1, 1, 0, 0, 1, 1, 1, 1, 0},
                    {0, 1, 1, 1, 0, 1, 1, 1, 1, 1},
                    {0, 0, 1, 1, 1, 1, 1, 1, 1, 0},
                    {1, 1, 1, 1, 1, 1, 0, 1, 1, 1},
                    {0, 1, 1, 1, 1, 1, 1, 0, 0, 1},
                    {1, 1, 1, 1, 1, 0, 0, 1, 1, 1},
                    {0, 1, 0, 1, 1, 0, 1, 1, 1, 1},
                    {1, 1, 1, 0, 1, 0, 1, 1, 1, 1}
                },
                9
            )
        );
    }
}