package com.odoo.goudadev.dynamicprogramming;

import java.util.HashMap;

/**
 * Source: https://youtu.be/oBt53YbR9Kk?t=218
 * <p>
 * Write a function `fib(n)` that takes in a number as an argument.
 * The function should return the n-th number of the Fibonacci sequence.
 * <p>
 * The 1st and 2nd number of the sequence is 1.
 * To generate the next number of the sequence, we sum the previous two.
 * <p>
 * n:      1, 2, 3, 4, 5, 6, 7,  8,  9,  ...
 * fib(n): 1, 1, 2, 3, 5, 8, 13, 21, 34, ...
 * ***
 */
public class NthNumberInFibonacciSequence {

    static HashMap<Long, Long> memos = new HashMap<Long, Long>();

    public static long memoizeWay(long n) {
        if (n <= 2) return 1;
        if (!memos.containsKey(n))
            memos.put(n, memoizeWay(n - 1) + memoizeWay(n - 2));
        return memos.get(n);
    }

//    static long memoizeWayShortened(long n) {
//        if (n<=2) return 1;
//        memos.computeIfAbsent(n, (x) -> memoizeWayShortened(x-1) + memoizeWayShortened(x-2));
//        return memos.get(n);
//    }

    public static long recursiveWay(long n) {
        if (n <= 2) return 1;
        return recursiveWay(n - 1) + recursiveWay(n - 2);
    }
}
