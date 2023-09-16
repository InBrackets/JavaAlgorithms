package com.odoo.goudadev.array;

import org.junit.jupiter.api.Disabled;
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
@Disabled("Whole task is broken. TDDO: find on gitghub a working version")
class FindTheCelebrityTest extends AbstractTest {

    FindTheCelebrity base = new FindTheCelebrity();

    @ParameterizedTest(name = "Case {index}: n={0}, output={1}")
    @MethodSource("generateTestData")
    void testFindCelebrity(int n, int output) {
        assertEquals(output, base.findCelebrity(n));
    }

    @Override
    public Stream<Arguments> generateTestData() {
        return Stream.of(
            Arguments.of(
                0,
                -1
            ),
            Arguments.of(
                2,
                -1
            )

        );
    }
}