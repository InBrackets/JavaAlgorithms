package com.odoo.goudadev.array;

import java.util.Arrays;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;

/**
 * 949. Largest Time for Given Digits
 * <p>
 * Given an array arr of 4 digits, find the latest 24-hour time that can be made using each digit exactly once.
 * <p>
 * 24-hour times are formatted as "HH:MM", where HH is between 00 and 23, and MM is between 00 and 59. The earliest 24-hour time is 00:00, and the latest is 23:59.
 * <p>
 * Return the latest 24-hour time in "HH:MM" format. If no valid time can be made, return an empty string.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: arr = [1,2,3,4]
 * Output: "23:41"
 * Explanation: The valid 24-hour times are "12:34", "12:43", "13:24", "13:42", "14:23", "14:32", "21:34", "21:43", "23:14", and "23:41". Of these times, "23:41" is the latest.
 * Example 2:
 * <p>
 * Input: arr = [5,5,5,5]
 * Output: ""
 * Explanation: There are no valid 24-hour times as "55:55" is not valid.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * arr.length == 4
 * 0 <= arr[i] <= 9
 */
public class LargestTimeForGivenDigits {

    private boolean rearrange(int maxValue, int targetIndex, int[] array) {
        int indexWithMaxValue = -1;

        // loop ignores values before the targetIndex
        for (int i = targetIndex; i < array.length; i++)
            /*
             * First we check if the value matches the possible value (for first digit is 2 since hour 23 o clock is the max),
             * then we check if the value was already defined (different than -1)
             * then if the current value under index 'i' is bigger than the current max
             */
            if (array[i] <= maxValue && (indexWithMaxValue == -1 || array[indexWithMaxValue] < array[i]))
                indexWithMaxValue = i;
        if (indexWithMaxValue == -1)
            return false;

        int temp = array[indexWithMaxValue];
        array[indexWithMaxValue] = array[targetIndex];
        array[targetIndex] = temp;
        return true;
    }

    public String largestTimeFromDigits_0ms(int[] a) {
        boolean res = (
            rearrange(2, 0, a) // max value for the first digit is 2
                && (a[0] == 2 ? rearrange(3, 1, a) : rearrange(9, 1, a)) // max value for the second digit is 3 or 9 depending if digit 1 has value of 2
                && rearrange(5, 2, a) // max value for the third digit is 5
                && rearrange(9, 3, a) // max value for the fourth digit is 9
        );

        StringBuilder sb = new StringBuilder();

        if (!res)
            return sb.toString();

        return sb.append(a[0])
            .append(a[1])
            .append(':')
            .append(a[2])
            .append(a[3]).toString();
    }
}
