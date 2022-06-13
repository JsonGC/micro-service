package Test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * 给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
 *
 *
 *
 * 注意：
 *
 *     对于 t 中重复字符，我们寻找的子字符串中该字符数量必须不少于 t 中该字符数量。
 *     如果 s 中存在这样的子串，我们保证它是唯一的答案。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = "ADOBECODEBANC", t = "ABC"
 * 输出："BANC"
 *
 * 示例 2：
 *
 * 输入：s = "a", t = "a"
 * 输出："a"
 *
 * 示例 3:
 *
 * 输入: s = "a", t = "aa"
 * 输出: ""
 * 解释: t 中两个字符 'a' 均应包含在 s 的子串中，
 * 因此没有符合条件的子字符串，返回空字符串。
 *
 *
 *
 * 提示：
 *
 *     1 <= s.length, t.length <= 105
 *     s 和 t 由英文字母组成
 */
public class MinWindowCode {

    public static void main(String[] args) {
        String s = minWindow("ADOBECODEBANC", "ABC");
        System.out.println(s);
    }

    static Map<Character, Integer> tempMap = new HashMap<>();
    static Map<Character, Integer> sMap = new HashMap<>();
    public static String minWindow(String s, String t) {
        int left = 0;
        int right = 0;
        int minLength = s.length();
        int leftReal = -1;
        int rightReal = -1;

        for (int i = 0; i < t.length(); i++) {
            char tChar = t.charAt(i);
            tempMap.put(tChar,tempMap.getOrDefault(tChar, 0) + 1);
        }

        while (right < s.length()){

            char rightChar = s.charAt(right);

            if (tempMap.containsKey(rightChar)){
                sMap.put(rightChar,sMap.getOrDefault(rightChar, 0) + 1);
            }

            if (check()){//开始缩扩

                //ADOBECODEBANC
                for (int i = left; i <= right; i++) {
                    char sChar = s.charAt(i);
                    if (!tempMap.containsKey(sChar)){
                        continue;
                    }
                    if (tempMap.get(sChar).compareTo(sMap.get(sChar)) < 0){
                        sMap.put(sChar,sMap.get(sChar) - 1);
                        continue;
                    }
                    if (tempMap.get(sChar).compareTo(sMap.get(sChar)) == 0){
                        left = i;
                        if (minLength >= (right - left + 1)){
                            minLength = right - left + 1;
                            leftReal = left;
                            rightReal = right + 1;
                        }
                        break;
                    }
                }
            }

            right++;
        }

        return leftReal == -1 ? "" : s.substring(leftReal, rightReal);
    }

    public static boolean check() {
        Iterator iter = tempMap.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry entry = (Map.Entry) iter.next();
            Character key = (Character) entry.getKey();
            Integer val = (Integer) entry.getValue();
            if (sMap.getOrDefault(key, 0) < val) {
                return false;
            }
        }
        return true;
    }
}
