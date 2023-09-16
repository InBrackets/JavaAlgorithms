package com.odoo.goudadev.array;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 989. Add to Array-Form of Integer
 *
 * The array-form of an integer 'num' is an array representing its digits in left to right order.
 *
 * * For example, for num = 1321, the array form is [1,3,2,1].
 * Given num, the array-form of an integer, and an integer k, return the array-form of the integer num + k.
 *
 * Example 1:
 *
 * Input: num = [1,2,0,0], k = 34
 * Output: [1,2,3,4]
 * Explanation: 1200 + 34 = 1234
 *
 * Example 2:
 *
 * Input: num = [2,7,4], k = 181
 * Output: [4,5,5]
 * Explanation: 274 + 181 = 455
 *
 * Example 3:
 *
 * Input: num = [2,1,5], k = 806
 * Output: [1,0,2,1]
 * Explanation: 215 + 806 = 1021
 *
 */
public class AddToArrayFormOfInteger {

    public List<Integer> addToArrayForm_2ms(int[] num, int k) {
        LinkedList<Integer> ans = new LinkedList<>();
        int carry = 0, i = num.length - 1;
        while (i >= 0 || k > 0) {
            int sum = carry + k % 10;
            if (i >= 0) sum += num[i--];
            ans.addFirst(sum % 10);
            carry = sum / 10;
            k /= 10;
        }
        if (carry != 0) ans.addFirst(carry);
        return ans;
    }

    public List<Integer> addToArrayForm_89ms(int[] num, int k) {
        StringBuilder sb = new StringBuilder();
        for (int a : num) {
            sb.append(a);
        }
        BigInteger big = new BigInteger(sb.toString());
        BigInteger result = big.add(BigInteger.valueOf(k));
        String resultStr = result.toString();
        List<Integer> list = new ArrayList<>();
        for (char a : resultStr.toCharArray()) {
            list.add(Integer.parseInt(String.valueOf(a)));
        }
        return list;
    }

}
