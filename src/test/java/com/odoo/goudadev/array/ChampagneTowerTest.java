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
class ChampagneTowerTest extends AbstractTest {

    ChampagneTower base = new ChampagneTower();

    @ParameterizedTest(name = "Case {index}: poured={0}, queryRow={1}, queryGlass={2}, output={3}")
    @MethodSource("generateTestData")
    void testChampagneTower(int poured, int queryRow, int queryGlass, double output) {
        assertEquals(output, base.champagneTower_4ms(poured, queryRow, queryGlass));
    }

    @Override
    public Stream<Arguments> generateTestData() {
        return Stream.of(
            Arguments.of(
                1,
                1,
                1,
                0.000
            ),
            Arguments.of(
                2,
                1,
                1,
                0.500
            ),
            Arguments.of(
                100000009,
                33,
                17,
                1.00000
            )
        );
    }
}