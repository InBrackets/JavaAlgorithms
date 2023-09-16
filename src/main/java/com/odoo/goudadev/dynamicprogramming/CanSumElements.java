package com.odoo.goudadev.dynamicprogramming;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * https://youtu.be/oBt53YbR9Kk?t=4223
 *
 * Write a function `canSum(targetSum, numbers)` that takes in a
 * targetSum and an array of numbers as arguments.
 *
 * The function should return a boolean indicating whether or not it
 * is possible to generate the targetSum using numbers from the array.
 *
 * You may use an element of the array as many times as needed.
 *
 * You may assume that all input numbers are nonnegative.
 *
 * canSum(7, [5, 3, 4, 7]) -> true, because 3+4==7 or 7==7
 *
 * canSum(7, [2, 4]) -> false
 */
public class CanSumElements {

    static HashMap<Long, Boolean> memo = new HashMap<>();

    static boolean canSumRecursiveWay(long targetSum, List<Long> numbers) {
        if (targetSum == 0) return true;
        if (targetSum < 0) return false;
        for(Long number : numbers) {
            long remainder = targetSum - number;
            if(canSumRecursiveWay(remainder, numbers))
                return true;
        }
        return false;
    }

    static boolean canSumMemoizeWay(long targetSum, List<Long> numbers) {
        if(memo.containsKey(targetSum)) return memo.get(targetSum);
        if (targetSum == 0) return true;
        if (targetSum < 0) return false;
        for(Long number : numbers) {
            long remainder = targetSum - number;
            if(canSumMemoizeWay(remainder, numbers)) {
                memo.put(targetSum, true);
                return true;
            }
        }
        memo.put(targetSum, false);
        return false;
    }
}
