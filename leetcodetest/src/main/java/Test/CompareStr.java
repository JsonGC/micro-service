package Test;

/**
 * 输入：s = "aa", p = "a"
 * 输出：false
 * 解释："a" 无法匹配 "aa" 整个字符串。
 *
 * 示例 2:
 *
 * 输入：s = "aaab", p = "a*b"
 * 输出：true
 * 解释：因为 '*' 代表可以匹配零个或多个前面的那一个元素, 在这里前面的元素就是 'a'。因此，字符串 "aa" 可被视为 'a' 重复了一次。
 *
 * 示例 3：
 *
 * 输入：s = "ab", p = ".*"
 * 输出：true
 * 解释：".*" 表示可匹配零个或多个（'*'）任意字符（'.'）。
 *
 *
 *
 * 提示：
 *
 *     1 <= s.length <= 20
 *     1 <= p.length <= 30
 *     s 只包含从 a-z 的小写字母。
 *     p 只包含从 a-z 的小写字母，以及字符 . 和 *。
 *     保证每次出现字符 * 时，前面都匹配到有效的字符
 *s="aab",p="c * a * b"
 */
public class CompareStr {

    char cp = '*';
    char cd = '.';

    public boolean isMatch(String s, String p) {

        if (s.equals("") && p.equals("")){
            return true;
        }

        if (!s.equals("") && p.equals("")){
            return false;
        }

        char[] chars = s.toCharArray();
        char[] chars1 = p.toCharArray();
        int a = 0;
        char c;
        for (int i = 0; i < chars.length; i++) {
            char aChar = chars[i];//字符串当前字符
            if (a > chars1.length - 1){
                return false;
            }
            c = chars1[a];
            if (judje(aChar, c)){
                a++;
                continue;
            }

            if (c == cp && judje(aChar, chars1[a - 1])){
                continue;
            }

            if (c == cp && !judje(aChar, chars1[a - 1])){
                a++;
                i--;
                continue;
            }

            if (c != cp && chars1[a + 1] == cp){
                a = a + 2;
                i--;
                continue;
            }

            return false;

        }

        if (a < chars1.length - 1){
            return false;
        }

        return true;

    }

    public boolean judje(char c, char c1){
        return (c == c1 || c1 == cd);
    }

    public static void main(String[] args) {
        String s = "";
        char[] chars = s.toCharArray();
        System.out.println(chars.length);
    }
}
