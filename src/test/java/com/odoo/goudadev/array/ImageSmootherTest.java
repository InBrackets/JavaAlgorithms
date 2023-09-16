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
class ImageSmootherTest extends AbstractTest {

    ImageSmoother base = new ImageSmoother();

    @ParameterizedTest(name = "Case {index}: img={0}, output={1}")
    @MethodSource("generateTestData")
    void imageSmoother_9ms(int[][] img, int[][] output) {
        assertThat(base.imageSmoother_9ms(img)).isDeepEqualTo(output);
    }

    @Override
    public Stream<Arguments> generateTestData() {
        return Stream.of(
            Arguments.of(
                new int[][]{{1, 1, 1}, {1, 0, 1}, {1, 1, 1}},
                new int[][]{{0, 0, 0}, {0, 0, 0}, {0, 0, 0}}
            ),
            Arguments.of(
                new int[][]{{100, 200, 100}, {200, 50, 200}, {100, 200, 100}},
                new int[][]{{137, 141, 137}, {141, 138, 141}, {137, 141, 137}}
            )
        );
    }
}