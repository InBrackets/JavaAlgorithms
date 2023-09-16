package com.odoo.goudadev.dynamicprogramming;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Source: https://youtu.be/oBt53YbR9Kk?t=6740
 *
 * Write a function `bestSum(targetSum, numbers)` that takes in a
 * targetSum and an array of numbers as arguments.
 *
 * The function should return an array containing the shortest
 * combination of numbers that add up to exactly the targetSum.
 *
 * If there is a tie for the shortest combination, you may return any
 * one of the shortest.
 *
 * bestSum(7, [3,4,7]) -> [7] : [3,4] is wrong because we are looking for the shortest solution
 * 7 == 7
 * bestSum(8 [2,3,5]) -> [3,5] : [2,2,2,2] is wrong because we are looking for the shortest solution
 * 3 + 5 == 8
 */



// NEEDS reimplementation !!!!!
public class BestSumOfElements {

    static HashMap<Long, List<Long>> memo = new HashMap<>();

    static List<Long> bestSumRecursiveWay(long targetSum, List<Long> numbers) {
        if (targetSum == 0)  return new ArrayList<>();
        if (targetSum < 0) return null;
        List<Long> shortestCombination = null;

        // branching logic
        for(long number : numbers) {
            long remainder = targetSum - number;
            List<Long> remainderCombination = bestSumRecursiveWay(remainder, numbers);
            if (remainderCombination != null) {
                List<Long> combination = new ArrayList<>(remainderCombination);
                combination.add(number);
                if(shortestCombination == null || combination.size() < shortestCombination.size()) {
                    shortestCombination = combination;
                }
            }
        }
        return shortestCombination;
    }

    static List<Long> bestSumMemoicWay(long targetSum, List<Long> numbers) {
        if (memo.containsKey(targetSum)) return memo.get(targetSum);
        if (targetSum == 0)  return new ArrayList<>();
        if (targetSum < 0) return null;
        List<Long> shortestCombination = null;

        // branching logic
        for(long number : numbers) {
            long remainder = targetSum - number;
            List<Long> remainderCombination = bestSumMemoicWay(remainder, numbers);
            if (remainderCombination != null) {
                List<Long> combination = new ArrayList<>(remainderCombination);
                combination.add(number);
                if(shortestCombination == null || combination.size() < shortestCombination.size()) {
                    shortestCombination = combination;
                }
            }
        }
        memo.put(targetSum, shortestCombination);
        return shortestCombination;
    }
}
