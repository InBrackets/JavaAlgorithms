package com.odoo.goudadev.array;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com.odoo.goudadev.utils.extensions.TestTags.EASY;
import static com.odoo.goudadev.utils.extensions.TestTags.PREMIUM;
import static org.junit.jupiter.api.Assertions.assertEquals;

@Tags({
    @Tag(PREMIUM),
    @Tag(EASY)
})
class MeetingRoomsTest extends AbstractTest {

    MeetingRooms base = new MeetingRooms();

    @ParameterizedTest(name = "Case {index}: intervals={0}, output={1}")
    @MethodSource("generateTestData")
    void testCanAttendMeetings(MeetingRooms.Interval[] intervals, boolean output) {
        assertEquals(output, base.canAttendMeetings(intervals));
    }

    @Override
    public Stream<Arguments> generateTestData() {
        return Stream.of(
            Arguments.of(
                new MeetingRooms.Interval[]{
                    new MeetingRooms.Interval(0, 30),
                    new MeetingRooms.Interval(5, 10),
                    new MeetingRooms.Interval(15, 20)
                },
                false
            ),
            Arguments.of(
                new MeetingRooms.Interval[]{
                    new MeetingRooms.Interval(0, 10),
                    new MeetingRooms.Interval(10, 20),
                    new MeetingRooms.Interval(20, 30)
                },
                true
            )
        );
    }
}