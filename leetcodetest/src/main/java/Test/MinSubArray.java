package Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 长度最小的子数组
 */
public class MinSubArray {

    public int minSubArrayLen(int s, int[] nums) {
        int a = 0;
        int m = 0;
        List list = new ArrayList();
        int min = nums.length;
        for (int i = a; i < nums.length; i++) {
            list.add(nums[i]);
            m += nums[i];
            if (m >= s) {
                if (min > list.size()) {
                    min = list.size();
                }
                list = new ArrayList();
                i = ++a;
                m = 0;
                continue;
            }
        }
        if (a == 0) {
            min = 0;
        }
        return min;
    }
}
