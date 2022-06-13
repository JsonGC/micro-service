package Test;

/**
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 *
 * 如果数组中不存在目标值 target，返回 [-1, -1]。
 *
 * 进阶：
 *
 *     你可以设计并实现时间复杂度为 O(log n) 的算法解决此问题吗？
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [5,7,7,8,8,10], target = 8
 * 输出：[3,4]
 *
 * 示例 2：
 *
 * 输入：nums = [5,7,7,8,8,10], target = 6
 * 输出：[-1,-1]
 *
 * 示例 3：
 *
 * 输入：nums = [], target = 0
 * 输出：[-1,-1]
 *
 *
 *
 * 提示：
 *
 *     0 <= nums.length <= 105
 *     -109 <= nums[i] <= 109
 *     nums 是一个非递减数组
 *     -109 <= target <= 109
 *
 */
public class SearchRangeCode {

    public static void main(String[] args) {
        int[] ints = searchRange(new int[]{1,4}, 4);
        System.out.println(ints);
    }

    public static int[] searchRange(int[] nums, int target) {

        if (nums.length == 0){
            return new int[]{-1,-1};
        }

        int left = 0;
        int right = nums.length - 1;
        int middle = 0;

        while (left <= right){
            middle = (left + right) / 2;
            int middleNum = nums[middle];
            if (middleNum == target){
                int start = 0;
                int end = nums.length - 1;
                for (int a = middle - 1; a >= 0; a--){
                    if (nums[a] != target){
                        start = a + 1;
                        break;
                    }
                }
                for (int a = middle + 1; a < nums.length; a++){
                    if (nums[a] != target){
                        end = a - 1;
                        break;
                    }
                }
                return new int[]{start, end};
            }
            if (middleNum > target){
                right = middle - 1;
            }
            if (middleNum < target){
                left = middle + 1;
            }
        }

        return new int[]{-1,-1};
    }
}
