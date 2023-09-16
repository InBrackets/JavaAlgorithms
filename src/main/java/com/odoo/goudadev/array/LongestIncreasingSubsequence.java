package com.odoo.goudadev.array;

import java.util.ArrayList;

/**
 * 300. Longest Increasing Subsequence
 *
 * Given an integer array nums, return the length of the longest strictly increasing
 * subsequence
 * .
 *
 * Example 1:
 *
 * Input: nums = [10,9,2,5,3,7,101,18]
 * Output: 4
 * Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.
 * Example 2:
 *
 * Input: nums = [0,1,0,3,2,3]
 * Output: 4
 * Example 3:
 *
 * Input: nums = [7,7,7,7,7,7,7]
 * Output: 1
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 2500
 * -104 <= nums[i] <= 104
 *
 *
 * Follow up: Can you come up with an algorithm that runs in O(n log(n)) time complexity?
 */
public class LongestIncreasingSubsequence {

    public int lengthOfLIS_13ms(int[] nums)
    {
        ArrayList<Integer> list = new ArrayList<Integer>();
        for(int i = 0; i<nums.length; i++)
        {
            if(list.isEmpty()||list.get(list.size()-1)<nums[i])
                list.add(nums[i]);
            else if(list.contains(nums[i]))
                continue;
            else
            {
                int l = 0,r=list.size()-1;
                while(l<=r)
                {
                    int mid = (l+r)/2;
                    if(list.get(mid)==nums[i])
                        break;
                    else if(list.get(mid)<nums[i])
                        l = mid+1;
                    else
                        r = mid-1;
                }
                list.set(l,nums[i]);
            }
        }
        return list.size();
    }
}
