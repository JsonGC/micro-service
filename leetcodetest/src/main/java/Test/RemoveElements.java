package Test;

/**
 * 移除元素
 */
public class RemoveElements {
    public int removeElement(int[] nums, int val) {
        int b = 0;
        if (nums.length < 1) {
            return 0;
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[b] = nums[i];
                b++;
            }
        }
        int[] arr1 = new int[b];
        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = nums[i];
        }
        nums = arr1;
        return nums.length;
    }
}
