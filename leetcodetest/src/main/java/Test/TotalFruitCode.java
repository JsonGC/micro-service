package Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 你正在探访一家农场，农场从左到右种植了一排果树。这些树用一个整数数组 fruits 表示，其中 fruits[i] 是第 i 棵树上的水果 种类 。
 *
 * 你想要尽可能多地收集水果。然而，农场的主人设定了一些严格的规矩，你必须按照要求采摘水果：
 *
 *     你只有 两个 篮子，并且每个篮子只能装 单一类型 的水果。每个篮子能够装的水果总量没有限制。
 *     你可以选择任意一棵树开始采摘，你必须从 每棵 树（包括开始采摘的树）上 恰好摘一个水果 。采摘的水果应当符合篮子中的水果类型。每采摘一次，你将会向右移动到下一棵树，并继续采摘。
 *     一旦你走到某棵树前，但水果不符合篮子的水果类型，那么就必须停止采摘。
 *
 * 给你一个整数数组 fruits ，返回你可以收集的水果的 最大 数目。
 *
 *
 *
 * 示例 1：
 *
 * 输入：fruits = [1,2,1]
 * 输出：3
 * 解释：可以采摘全部 3 棵树。
 *
 * 示例 2：
 *
 * 输入：fruits = [0,1,2,2]
 * 输出：3
 * 解释：可以采摘 [1,2,2] 这三棵树。
 * 如果从第一棵树开始采摘，则只能采摘 [0,1] 这两棵树。
 *
 * 示例 3：
 *
 * 输入：fruits = [1,2,3,2,2]
 * 输出：4
 * 解释：可以采摘 [2,3,2,2] 这四棵树。
 * 如果从第一棵树开始采摘，则只能采摘 [1,2] 这两棵树。
 *
 * 示例 4：
 *
 * 输入：fruits = [3,3,3,1,2,1,1,2,3,3,4]
 * 输出：5
 * 解释：可以采摘 [1,2,1,1,2] 这五棵树。
 *
 *
 *
 * 提示：
 *
 *     1 <= fruits.length <= 105
 *     0 <= fruits[i] < fruits.length
 */
public class TotalFruitCode {
    public static void main(String[] args) {
        int i = totalFruit(new int[]{3,3,3,1,2,1,1,2,3,3,4});
        System.out.println(i);
    }

    public static int totalFruit(int[] tree) {

//        int leftPoint = 0, rightPoint = 0,maxLength = 0,first = fruits[0],last = -1;
//        //3,3,3,1,3,3,2,1,1,2,3,3,4
//        while (rightPoint < fruits.length){
//            if (fruits[rightPoint] == first || fruits[rightPoint] == last){
//                rightPoint++;
//                continue;
//            }
//            if (fruits[rightPoint] != first && last == -1){
//                last = fruits[rightPoint];
//                rightPoint++;
//                continue;
//            }
//            if (fruits[rightPoint] != first && fruits[rightPoint] != last){
//                maxLength = maxLength > (rightPoint - leftPoint) ? maxLength : (rightPoint - leftPoint);
//                first = fruits[rightPoint - 1];
//                last = fruits[rightPoint];
//                for (int i = rightPoint - 1; i >= 0; i--) {
//                    if (fruits[i] != first){
//                        leftPoint = i + 1;
//                        break;
//                    }
//                }
//                rightPoint++;
//            }
//        }
//
//        maxLength = maxLength > (rightPoint - leftPoint) ? maxLength : (rightPoint - leftPoint);
//
//        return maxLength;

        List<Integer> blockLefts = new ArrayList();

        // Add the left boundary of each block
        for (int i = 0; i < tree.length; ++i){
            if (i == 0 || tree[i-1] != tree[i])
                blockLefts.add(i);
        }


        // Add tree.length as a sentinel for convenience
        blockLefts.add(tree.length);

        int ans = 0, i = 0;
        search: while (true) {
            // We'll start our scan at block[i].
            // types : the different values of tree[i] seen
            // weight : the total number of trees represented
            //          by blocks under consideration
            Set<Integer> types = new HashSet();
            int weight = 0;

            // For each block from the i-th and going forward,
            for (int j = i; j < blockLefts.size() - 1; ++j) {
                // Add each block to consideration
                //111222111333 blockLefts:0 3 6 9 12
                types.add(tree[blockLefts.get(j)]);
                weight += blockLefts.get(j+1) - blockLefts.get(j);

                // If we have 3+ types, this is an illegal subarray
                if (types.size() >= 3) {
                    i = j - 1;
                    continue search;
                }

                // If it is a legal subarray, record the answer
                ans = Math.max(ans, weight);
            }

            break;
        }

        return ans;

    }
}
