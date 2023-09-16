package com.odoo.goudadev.array;

import java.util.ArrayList;
import java.util.List;

/**
 * 57. Insert Interval
 *
 * You are given an array of non-overlapping intervals intervals where intervals[i] = [starti, endi] represent the start and the end of the ith interval and intervals is sorted in ascending order by starti. You are also given an interval newInterval = [start, end] that represents the start and end of another interval.
 *
 * Insert newInterval into intervals such that intervals is still sorted in ascending order by starti and intervals still does not have any overlapping intervals (merge overlapping intervals if necessary).
 *
 * Return intervals after the insertion.
 *
 *
 *
 * Example 1:
 *
 * Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
 * Output: [[1,5],[6,9]]
 * Example 2:
 *
 * Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
 * Output: [[1,2],[3,10],[12,16]]
 * Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].
 *
 *
 * Constraints:
 *
 * 0 <= intervals.length <= 104
 * intervals[i].length == 2
 * 0 <= starti <= endi <= 105
 * intervals is sorted by starti in ascending order.
 * newInterval.length == 2
 * 0 <= start <= end <= 105
 */
public class InsertInterval {

    public int[][] insert_1ms(int[][] intervals, int[] newInterval) {
        if(intervals.length == 0) return new int[][]{newInterval};  // is Empty return new Interval
        int first  = newInterval[0];
        int second = newInterval[1];
        boolean isFind = false;     //If we find interval that is rigth, this will be true
        int n = intervals.length;
        List<int[]> list = new ArrayList<>();
        for(int a = 0; a < n; a++){
            if(isFind){ list.add(intervals[a]); continue;}  // if we find that we don't need search
            int subF = intervals[a][0];
            int subS = intervals[a][1];

            // if first val is in array
            if(first >= subF && first <= subS){
                int[] priory = new int[2];
                priory[0] = subF;   //setting interval's first val is Array's first val

                for(int b = a; b < n; b++){// we looking for setting interval's last value
                    if(second >= intervals[b][0]){
                        if(intervals[b][1] >= second){// if second val is in
                            priory[1] = intervals[b][1]; list.add(priory);
                            a = b; isFind = true; break;
                        }
                    }else{// if second val isn't in
                        priory[1] = second; list.add(priory);
                        a = b-1; isFind = true; break;
                    }
                    if(b == n-1){// if second val is most biggest value
                        priory[1] = second; list.add(priory);
                        a = b; isFind = true; break;
                    }
                }
            }
            // ----------------------------------
            // if first val smaller than first array
            else if(first < subF){
                int[] priory = new int[2];
                priory[0] = first; //setting interval's first val is our first val

                if(second < subF){// if whole interval isn't in first array
                    priory[1] = second; list.add(priory);
                    a --; isFind = true; continue;
                }
                else{
                    for(int b = a; b < n; b++){// we looking for setting interval's last value
                        if(second >= intervals[b][0]){
                            if(second <= intervals[b][1]){// if second val is in
                                priory[1] = intervals[b][1];
                                list.add(priory); isFind = true; a = b; break;
                            }
                        }
                        else{
                            a = b-1; priory[1] = second;
                            list.add(priory); isFind = true; break;
                        }
                        if(b == n-1 && !isFind){
                            priory[1] = second; list.add(priory);
                            a = b; isFind = true; break;
                        }
                    }
                }
            }
            // ----------------------------------
            else{
                list.add(intervals[a]);
            }
            if(a == n-1 && !isFind) list.add(newInterval);
        }
        int l = list.size();
        int[][] ret = new int[l][2];
        for(int a = 0; a < l; a++){
            ret[a] = list.get(a);
        }
        return ret;
    }
}
