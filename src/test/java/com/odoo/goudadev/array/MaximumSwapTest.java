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
class MaximumSwapTest extends AbstractTest {

    MaximumSwap base = new MaximumSwap();

    @ParameterizedTest(name = "Case {index}: num={0}, output={1}")
    @MethodSource("generateTestData")
    void testMaximumSwap_0ms(int num, int output) {
        assertEquals(output, base.maximumSwap_0ms(num));
    }

    @Override
    public Stream<Arguments> generateTestData() {
        return Stream.of(
            Arguments.of(
                2736,
                7236
            ),
            Arguments.of(
                9973,
                9973
            )
        );
    }
}