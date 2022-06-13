package Test;

import java.util.ArrayList;
import java.util.List;

/**
 *  旋转数组
 */
public class RotateArr {

    public void rotate(int[] nums, int k) {
        List<Integer> list = new ArrayList();
        List<Integer> list2 = new ArrayList();
        int a = 0;
        for (int i = 0; i < nums.length; i++) {
            list.add(nums[i]);
        }
        if (list.size() >= k) {
            a = list.size() - k;
        } else if (list.size() < k) {
            a = list.size()- k % list.size();
        }
        List<Integer> list1 = list.subList(a, list.size());
        for (int i = 0; i < list1.size(); i++) {
            list2.add(list1.get(i));
        }
        list.subList(a, list.size()).clear();
        list.addAll(0, list2);
        for (int i = 0; i < nums.length; i++) {
            nums[i] = list.get(i);
        }
    }
}
