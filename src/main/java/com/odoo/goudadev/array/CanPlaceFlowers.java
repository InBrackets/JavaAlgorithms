package com.odoo.goudadev.array;

/**
 * 605. Can Place Flowers
 *
 * You have a long flowerbed in which some of the plots are planted, and some are not. However, flowers cannot be planted in adjacent plots.
 *
 * Given an integer array flowerbed containing 0's and 1's, where 0 means empty and 1 means not empty, and an integer n, return true if n new flowers can be planted in the flowerbed without violating the no-adjacent-flowers rule and false otherwise.
 *
 *
 *
 * Example 1:
 *
 * Input: flowerbed = [1,0,0,0,1], n = 1
 * Output: true
 * Example 2:
 *
 * Input: flowerbed = [1,0,0,0,1], n = 2
 * Output: false
 *
 *
 * Constraints:
 *
 * 1 <= flowerbed.length <= 2 * 104
 * flowerbed[i] is 0 or 1.
 * There are no two adjacent flowers in flowerbed.
 * 0 <= n <= flowerbed.length
 */
public class CanPlaceFlowers {

    public boolean canPlaceFlowers_1ms(int[] flowerbed, int n) {

        int[] T = new int[flowerbed.length + 4];
        for (int i = 0, j = 2; i < flowerbed.length; i++)
            T[j++] = flowerbed[i];
        T[0] = 1;
        T[T.length - 1] = 1;
        int total = 0, count = 0;
        for (int i = 1; i < T.length; i++) {
            if (T[i] == 0) count++;
            else {
                if ((count % 2) == 0) total += ((count / 2) - 1);
                else total += (count / 2);
                count = 0; // reset
            }
        }
        return (total >= n);
    }

}
