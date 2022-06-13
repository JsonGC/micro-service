package Test;

/**
 * 59. 螺旋矩阵 II
 *
 * 给你一个正整数 n ，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：n = 3
 * 输出：[[1,2,3],[8,9,4],[7,6,5]]
 *
 * 示例 2：
 *
 * 输入：n = 1
 * 输出：[[1]]
 *
 *
 *
 * 提示：
 *
 *     1 <= n <= 20
 */
public class GenerateMatrixCode {

    public static void main(String[] args) {
        int[][] ints = generateMatrix(5);
        System.out.println(ints);
    }

    public static int[][] generateMatrix(int n) {
        int[][] arr = new int[n][n];

        int num = 1;//填充数据
        int time = 0;//循环次数
        while (time < (n + 1) / 2){
            int leftIndex = time;
            int rightIndex = n - 1 - time;
            int upIndex = time;
            int downIndex = n - 1 - time;
            for (int i = leftIndex; i <= rightIndex; i++) {
                arr[upIndex][i] = num++;
            }
            for (int i = upIndex + 1; i <= downIndex; i++) {
                arr[i][rightIndex] = num++;
            }
            for (int i = rightIndex - 1; i >= leftIndex; i--) {
                arr[downIndex][i] = num++;
            }
            for (int i = downIndex - 1; i >= upIndex + 1; i--) {
                arr[i][leftIndex] = num++;
            }

            time++;
        }


        return arr;
    }
}
