package com.odoo.goudadev.array;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;

import java.util.Arrays;

import static com.odoo.goudadev.utils.extensions.TestTags.HARD;

/**
 * 41. First Missing Positive
 *
 * Given an unsorted integer array nums, return the smallest missing positive integer.
 *
 * You must implement an algorithm that runs in O(n) time and uses O(1) auxiliary space.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,2,0]
 * Output: 3
 * Explanation: The numbers in the range [1,2] are all in the array.
 * Example 2:
 *
 * Input: nums = [3,4,-1,1]
 * Output: 2
 * Explanation: 1 is in the array but 2 is missing.
 * Example 3:
 *
 * Input: nums = [7,8,9,11,12]
 * Output: 1
 * Explanation: The smallest positive integer 1 is missing.
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 105
 * -231 <= nums[i] <= 231 - 1
 */
@Tags({
    @Tag(HARD)
})
public class FirstMissingPositive {

    private int L;

    public int firstMissingPositive_2ms(int[] nums) {
        L = nums.length;
        for (int i = 0; i < L; i++) {
            if (nums[i] > 0 && nums[i] <= L && nums[i] != i + 1) {
                int v = nums[i];
                nums[i] = -1;
                replace(v, nums);
            }
        }

        for (int i = 0; i < L; i++) {
            if (nums[i] != i + 1) return i + 1;
        }

        return L + 1;
    }


    public int firstMissingPositive_13ms(int[] nums) {
        Arrays.sort(nums);
        int c=0;
        int a=1;
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]>0 & a==nums[i])
            {
                a++;
            }

        }
        return a;
    }

    private void replace(int i, int[] nums) {
        if (i > 0 && i <= L && i != nums[i - 1]) {
            int v = nums[i - 1];
            nums[i - 1] = i;
            replace(v, nums);
        }
    }
}
