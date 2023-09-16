package com.odoo.goudadev.array;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com.odoo.goudadev.utils.extensions.TestTags.EASY;
import static org.junit.jupiter.api.Assertions.assertEquals;

@Tags({
    @Tag(EASY)
})
class CanPlaceFlowersTest extends AbstractTest {

    CanPlaceFlowers base = new CanPlaceFlowers();

    @ParameterizedTest(name = "Case {index}: flowerbed={0}, n={1}, output={2}")
    @MethodSource("generateTestData")
    void testCanPlaceFlowers(int[] flowerbed, int n, boolean output) {
        assertEquals(output, base.canPlaceFlowers_1ms(flowerbed, n));
    }

    @Override
    public Stream<Arguments> generateTestData() {
        return Stream.of(
            Arguments.of(
                new int[]{1, 0, 0, 0, 1},
                1,
                true
            ),
            Arguments.of(
                new int[]{1, 0, 0, 0, 1},
                2,
                false
            )
        );
    }
}