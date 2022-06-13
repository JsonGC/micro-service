package Test;

import java.util.*;

/**
 * 最大连续1的个数
 */
public class FindMaxConsecutiveOne {

    private static int ss = 2;

    public static int findMaxConsecutiveOnes(int[] nums) {

        int a = 0;
        int max = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                a++;
            } else if (nums[i] == 0 && a > 0) {
                if (max < a) {
                    max = a;
                }
                a = 0;
            }
        }
        if (nums[nums.length - 1] == 1 && max < a) {
            max = a;
        }

        return max;
    }

    public static void main(String[] args) {
        ss = 3;
        System.out.println(ss);
    }


}
