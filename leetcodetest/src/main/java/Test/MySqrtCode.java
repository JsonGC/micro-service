package Test;

/**
 * 给你一个非负整数 x ，计算并返回 x 的 算术平方根 。
 *
 * 由于返回类型是整数，结果只保留 整数部分 ，小数部分将被 舍去 。
 *
 * 注意：不允许使用任何内置指数函数和算符，例如 pow(x, 0.5) 或者 x ** 0.5 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：x = 4
 * 输出：2
 *
 * 示例 2：
 *
 * 输入：x = 8
 * 输出：2
 * 解释：8 的算术平方根是 2.82842..., 由于返回类型是整数，小数部分将被舍去。
 *
 *
 *
 * 提示：
 *
 *     0 <= x <= 2^31 - 1
 */
public class MySqrtCode {

    public static void main(String[] args) {
        int i = mySqrt(2147395599);
        System.out.println(i);
    }

    public static int mySqrt(int x) {
        int left = 0;
        int right = x;
        int middle = 0;

        while (left <= right){
            middle = (left + right) / 2;

            long middleNum = (long)middle * middle;
            if (middleNum == x){
                return middle;
            }
            if (middleNum > x){
                right = middle - 1;
            }
            if (middleNum < x){
                left = middle + 1;
            }
        }

        return left - 1;
    }
}
