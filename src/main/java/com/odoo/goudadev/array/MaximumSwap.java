package com.odoo.goudadev.array;

/**
 * 670. Maximum Swap
 *
 * You are given an integer num. You can swap two digits at most once to get the maximum valued number.
 *
 * Return the maximum valued number you can get.
 *
 *
 *
 * Example 1:
 *
 * Input: num = 2736
 * Output: 7236
 * Explanation: Swap the number 2 and the number 7.
 * Example 2:
 *
 * Input: num = 9973
 * Output: 9973
 * Explanation: No swap.
 *
 *
 * Constraints:
 *
 * 0 <= num <= 108
 */
public class MaximumSwap {

    public int maximumSwap_0ms(int num) {
        if(num < 10) return num;

        char[] arr = String.valueOf(num).toCharArray();

        int[] rightIndex = new int[10]; // to hold the last index of each digit

        for(int i=0; i<arr.length; i++){
            rightIndex[arr[i] - '0'] = i;  // arr[i] - '0' converts char to num
        }

        for(int i=0; i<arr.length; i++){  // index of present digit we are looking at
            for(int j=9; j>arr[i] - '0'; j--){ // max digit could be 9 and min be GREATER than the present digit we looking at
                if(rightIndex[j] > i){  // if index of 'j' (starts with 9) is greater than present index (basically, is the bigger digit at RIGHT of present digit)
                    // swap and return the answer
                    char temp = arr[i];
                    arr[i] = arr[rightIndex[j]];
                    arr[rightIndex[j]] = temp;
                    return Integer.valueOf(new String(arr)); // return here
                }
            }
        }

        // if we reach till here, that means no swapping is required in the input number.
        return num;
    }
}
