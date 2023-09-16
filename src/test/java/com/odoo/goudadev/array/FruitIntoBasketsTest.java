package com.odoo.goudadev.array;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com.odoo.goudadev.utils.extensions.TestTags.MEDIUM;
import static org.junit.jupiter.api.Assertions.assertEquals;

@Tags({
    @Tag(MEDIUM)
})
class FruitIntoBasketsTest extends AbstractTest {

    FruitIntoBaskets base = new FruitIntoBaskets();

    @ParameterizedTest(name = "Case {index}: fruits={0}, output={1}")
    @MethodSource("generateTestData")
    void testTotalFruit_50ms(int[] fruits, int output) {
        assertEquals(output, base.totalFruit_50ms(fruits));
    }

    @Override
    public Stream<Arguments> generateTestData() {
        return Stream.of(
            Arguments.of(
                new int[]{1, 2, 1},
                3
            ),
            Arguments.of(
                new int[]{0, 1, 2, 2},
                3
            ),
            Arguments.of(
                new int[]{1, 2, 3, 2, 2},
                4
            )
        );
    }
}