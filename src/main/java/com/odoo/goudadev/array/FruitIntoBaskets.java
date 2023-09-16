package com.odoo.goudadev.array;

import java.util.HashMap;
import java.util.Map;

/**
 * 904. Fruit Into Baskets
 *
 * <p>
 * You are visiting a farm that has a single row of fruit trees arranged from left to right. The trees are represented by an integer array fruits where fruits[i] is the type of fruit the ith tree produces.
 * <p>
 * You want to collect as much fruit as possible. However, the owner has some strict rules that you must follow:
 * <p>
 * You only have two baskets, and each basket can only hold a single type of fruit. There is no limit on the amount of fruit each basket can hold.
 * Starting from any tree of your choice, you must pick exactly one fruit from every tree (including the start tree) while moving to the right. The picked fruits must fit in one of your baskets.
 * Once you reach a tree with fruit that cannot fit in your baskets, you must stop.
 * Given the integer array fruits, return the maximum number of fruits you can pick.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: fruits = [1,2,1]
 * Output: 3
 * Explanation: We can pick from all 3 trees.
 * Example 2:
 * <p>
 * Input: fruits = [0,1,2,2]
 * Output: 3
 * Explanation: We can pick from trees [1,2,2].
 * If we had started at the first tree, we would only pick from trees [0,1].
 * Example 3:
 * <p>
 * Input: fruits = [1,2,3,2,2]
 * Output: 4
 * Explanation: We can pick from trees [2,3,2,2].
 * If we had started at the first tree, we would only pick from trees [1,2].
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= fruits.length <= 105
 * 0 <= fruits[i] < fruits.length
 */
public class FruitIntoBaskets {

    public int totalFruit_50ms(int[] fruits) {
        int i = 0, j = 0;
        int ans = 0;
        Map<Integer, Integer> b = new HashMap<>();
        while (j < fruits.length) {
            b.put(fruits[j], 1 + b.getOrDefault(fruits[j], 0));
            while (b.size() > 2) {
                b.put(fruits[i], b.get(fruits[i]) - 1);
                if (b.get(fruits[i]) == 0) {
                    b.remove(fruits[i]);
                }
                i++;
            }
            ans = Math.max(ans, j - i + 1);
            j++;
        }

        return ans;
    }
}
