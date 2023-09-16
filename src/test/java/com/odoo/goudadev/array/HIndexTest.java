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
class HIndexTest extends AbstractTest {

    HIndex base = new HIndex();

    @ParameterizedTest(name = "Case {index}: citations={0}, output={1}")
    @MethodSource("generateTestData")
    void testHIndex(int[] citations, int output) {
        assertEquals(output, base.hIndex(citations));
    }

    @Override
    public Stream<Arguments> generateTestData() {
        return Stream.of(
            Arguments.of(
                new int[]{3, 0, 6, 1, 5},
                3
            ),
            Arguments.of(
                new int[]{1, 3, 1},
                1
            )
        );
    }
}