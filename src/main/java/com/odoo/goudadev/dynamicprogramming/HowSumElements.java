package com.odoo.goudadev.dynamicprogramming;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Source: https://youtu.be/oBt53YbR9Kk?t=5413
 *
 * Write a function howSum(targetSum, numbers)` that takes in a
 * targetSum and an array of numbers as arguments.
 *
 * The function should return an array containing any combination of
 * elements that add up to exactly the targetSum. If there is no
 * combination that adds up to the targetSum, then return null.
 *
 * If there are multiple combinations possible, you may return any
 * single one.
 */
public class HowSumElements {

    static HashMap<Long,ArrayList<Long>> memo = new HashMap<>();

    static ArrayList<Long> howSumMemoicWay(long targetSum, List<Long> numbers) {
        if (targetSum==0) return new ArrayList<>();
        if (targetSum<0) return null;

        for(Long number: numbers) {
            long remainder = targetSum - number;
            if(!memo.containsKey(remainder))
                memo.put(remainder, howSumMemoicWay(remainder, numbers));
            ArrayList<Long> remainderResult = memo.get(remainder);
            if (remainderResult!=null) {
                remainderResult.add(number);
                return new ArrayList<>(remainderResult);
            }
        }
        return null;
    }

    static ArrayList<Long> howSumRecursionWay(long targetSum, List<Long> numbers) {
        if (targetSum==0) return new ArrayList<>();
        if (targetSum<0) return null;

        for(Long number: numbers) {
            long remainder = targetSum - number;
            ArrayList<Long> remainderResult = howSumRecursionWay(remainder, numbers);
            if (remainderResult!=null) {
                remainderResult.add(number);
                return new ArrayList<>(remainderResult);
            }
        }
        return null;
    }
}
