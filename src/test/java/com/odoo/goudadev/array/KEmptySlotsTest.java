package com.odoo.goudadev.array;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com.odoo.goudadev.utils.extensions.TestTags.HARD;
import static com.odoo.goudadev.utils.extensions.TestTags.PREMIUM;
import static org.junit.jupiter.api.Assertions.assertEquals;

@Tags({
    @Tag(PREMIUM),
    @Tag(HARD)
})
class KEmptySlotsTest extends AbstractTest {

    KEmptySlots base = new KEmptySlots();

    @ParameterizedTest(name = "Case {index}: flowers={0}, k={1}, output={2}")
    @MethodSource("generateTestData")
    void testKEmptySlots(int[] flowers, int k, int output) {
        assertEquals(output, base.kEmptySlots(flowers, k));
    }

    @Override
    public Stream<Arguments> generateTestData() {
        return Stream.of(
            Arguments.of(
                new int[]{1, 3, 2},
                2,
                3
            )
        );
    }
}