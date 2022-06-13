package Test;

import java.util.ArrayList;
import java.util.List;

/**
 *     数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 *
 *     示例 1：
 *
 *     输入：n = 3
 *     输出：["((()))","(()())","(())()","()(())","()()()"]
 *
 *     示例 2：
 *
 *     输入：n = 1
 *     输出：["()"]  bnm
 *
 *     提示：1 <= n <= 8
 */
public class CreateContainer {

    List<String> result = new ArrayList<>();

    public  List<String> generateParenthesis(int n) {

        back("", n, 0, 0);

        return result;
    }

    public void back(String ss, int n, int x, int y){

        if (x > n || y > n){
            return;
        }

        if (x == n && y == n){
            result.add(ss);
        }

        if (x >= y){
            back(ss + "(", n, x + 1, y);
        }
        if (x > y){
            back(new String(ss) + ")", n, x, y + 1);
        }

    }

    public static void main(String[] args) {
//        List<String> strings = generateParenthesis(4);
//        for (String string : strings) {
//            System.out.println(string);
//        }
    }
}
