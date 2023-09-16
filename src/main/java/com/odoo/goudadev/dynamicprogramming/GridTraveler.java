package com.odoo.goudadev.dynamicprogramming;

import java.util.HashMap;
import java.util.List;

/**
 * Source: https://youtu.be/oBt53YbR9Kk?t=2365
 * <p>
 * Say that you are a traveler on a 2D grid. You begin in the
 * top-left corner and your goal is to travel to the bottom-right
 * corner. You may only move down or right.
 * <p>
 * In how many ways can you travel to the goal on a grid with
 * dimensions m * n?
 * <p>
 * Write a function `gridTraveler(m, n)` that calculates this.
 */
public class GridTraveler {

    static HashMap<List<Long>, Long> memo = new HashMap<>();

    static long gridTravellerMemoicWay(long height, long width) {
        List<Long> key = new java.util.ArrayList<>(List.of(height, width));
        if (height == 0 || width == 0)
            return 0;
        if (height == 1 && width == 1)
            return 1;
        if (!memo.containsKey(key)) {
            memo.put(List.of(height, width), gridTravellerMemoicWay(height - 1, width) + gridTravellerMemoicWay(height, width - 1));
        }
        return memo.get(key);
    }

    static long gridTravellerRecursiveWay(long height, long width) {
        if (height == 0 || width == 0)
            return 0;
        if (height == 1 && width == 1)
            return 1;
        return gridTravellerRecursiveWay(height - 1, width) + gridTravellerRecursiveWay(height, width - 1);
    }
}
