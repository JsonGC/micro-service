package Test;

/**
 * 给定一个 正整数 num ，编写一个函数，如果 num 是一个完全平方数，则返回 true ，否则返回 false 。
 *
 * 进阶：不要 使用任何内置的库函数，如  sqrt 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：num = 16
 * 输出：true
 *
 * 示例 2：
 *
 * 输入：num = 14
 * 输出：false
 *
 *
 *
 * 提示：
 *
 *     1 <= num <= 2^31 - 1
 */
public class IsPerfectSquareCode {

    public static void main(String[] args) {
        boolean perfectSquare = isPerfectSquare(200 * 201);
        System.out.println(perfectSquare);
    }

    public static boolean isPerfectSquare(int num) {
        int left = 0;
        int right = num;
        int middle = 0;
        while (left <= right){
            middle = (left + right) / 2;
            long middleNum = (long)middle * middle;
            if (middleNum == num){
                return true;
            }
            if (middleNum > num){
                right = middle - 1;
            }
            if (middleNum < num){
                left = middle + 1;
            }
        }

        return false;

    }
}
