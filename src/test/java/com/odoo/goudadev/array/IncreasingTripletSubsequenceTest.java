package com.odoo.goudadev.array;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com.odoo.goudadev.utils.extensions.TestTags.MEDIUM;
import static org.junit.jupiter.api.Assertions.*;

@Tags({
    @Tag(MEDIUM)
})
class IncreasingTripletSubsequenceTest extends AbstractTest {

    IncreasingTripletSubsequence base = new IncreasingTripletSubsequence();

    @ParameterizedTest(name = "Case {index}: nums={0}, output={1}")
    @MethodSource("generateTestData")
    void increasingTriplet_2ms(int[] nums, boolean output) {
        assertEquals(output, base.increasingTriplet_2ms(nums));
    }

    @Override
    public Stream<Arguments> generateTestData() {
        return Stream.of(
            Arguments.of(
                new int[] {1,2,3,4,5},
                true
            ),
            Arguments.of(
                new int[] {5,4,3,2,1},
                false
            ),
            Arguments.of(
                new int[] {2,1,5,0,4,6},
                true
            )
        );
    }
}