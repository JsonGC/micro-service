package Test;

/**
 * 给定一个含有 n 个正整数的数组和一个正整数 target 。
 *
 * 找出该数组中满足其和 ≥ target 的长度最小的 连续子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。如果不存在符合条件的子数组，返回 0 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：target = 7, nums = [2,3,1,2,4,3]
 * 输出：2
 * 解释：子数组 [4,3] 是该条件下的长度最小的子数组。
 *
 * 示例 2：
 *
 * 输入：target = 4, nums = [1,4,4]
 * 输出：1
 *
 * 示例 3：
 *
 * 输入：target = 11, nums = [1,1,1,1,1,1,1,1]
 * 输出：0
 *
 *
 *
 * 提示：
 *
 *     1 <= target <= 109
 *     1 <= nums.length <= 105
 *     1 <= nums[i] <= 105
 */
public class MinSubArrayLenCode {

    public static void main(String[] args) {
        int i = minSubArrayLen(3, new int[]{1,1,1,1,1,1,1,1});
        System.out.println(i);
    }

    public static int minSubArrayLen(int target, int[] nums) {
        int fastPoint = 0,slowPoint = 0,count = 0,minLength = nums.length,sum = nums[0];

        while (fastPoint != nums.length - 1 || sum >= target){

            if (sum >= target){
                count++;
                minLength = minLength > (fastPoint - slowPoint + 1) ? fastPoint - slowPoint + 1 : minLength;
                sum = sum - nums[slowPoint++];
                continue;
            }

            if (sum < target){
                sum = sum + nums[++fastPoint];
                continue;
            }

        }

        return count == 0 ? 0 : minLength;
    }
}
