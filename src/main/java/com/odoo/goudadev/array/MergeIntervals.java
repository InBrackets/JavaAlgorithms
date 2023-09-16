package com.odoo.goudadev.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 56. Merge Intervals
 *
 * Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.
 *
 *
 *
 * Example 1:
 *
 * Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
 * Output: [[1,6],[8,10],[15,18]]
 * Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].
 * Example 2:
 *
 * Input: intervals = [[1,4],[4,5]]
 * Output: [[1,5]]
 * Explanation: Intervals [1,4] and [4,5] are considered overlapping.
 *
 *
 * Constraints:
 *
 * 1 <= intervals.length <= 104
 * intervals[i].length == 2
 * 0 <= starti <= endi <= 104
 */
public class MergeIntervals {

    public int[][] merge_11ms(int[][] intervals) {
        if(intervals.length == 1) return intervals;
        Arrays.sort(intervals, Comparator.comparingInt(row -> row[0]));

        List<int[]> list = new ArrayList<>();
        if(intervals[1][0] >= intervals[0][0] && intervals[1][0] <= intervals[0][1]) {
            list.add(new int[] {intervals[0][0], Math.max(intervals[0][1], intervals[1][1])});
        } else {
            list.add(intervals[0]);
            list.add(intervals[1]);
        }

        for(int i = 2; i < intervals.length; i++) {
            int[] arr = list.get(list.size() - 1);
            if(intervals[i][0] >= arr[0] && intervals[i][0] <= arr[1]) {
                list.remove(list.size() - 1);
                list.add(new int[] {arr[0], Math.max(arr[1], intervals[i][1])});
            } else {
                list.add(intervals[i]);
            }
        }

        int[][] ans = new int[list.size()][2];
        for(int i = 0; i < ans.length; i++) ans[i] = list.get(i);
        return ans;
    }
}
