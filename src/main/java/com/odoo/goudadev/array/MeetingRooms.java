package com.odoo.goudadev.array;

import java.util.Arrays;

/**
 * 252. Meeting Rooms
 *
 * Given an array of meeting time intervals consisting
 * of start and end times [[s1,e1],[s2,e2],...] (si < ei), determine if a person could attend all
 * meetings.
 *
 * <p>For example, Given [[0, 30],[5, 10],[15, 20]], return false.
 *
 * <p>Solution: Sort the interval based on the start interval. Then, for every interval check if the
 * previous interval ends before the start of the current interval.
 */
public class MeetingRooms {

    public static class Interval {
        int start;
        int end;

        Interval() {
            start = 0;
            end = 0;
        }

        Interval(int s, int e) {
            start = s;
            end = e;
        }
    }

    public boolean canAttendMeetings(Interval[] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a.start, b.start));
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i].start < intervals[i - 1].end) return false;
        }
        return true;
    }
}
