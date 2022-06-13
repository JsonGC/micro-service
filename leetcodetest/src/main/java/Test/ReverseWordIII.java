package Test;

/**
 * 反转字符串中的单词 III
 */
public class ReverseWordIII {
    public String reverseWords(String s) {
        String[] s1 = s.split(" ");
        for (int i = 0; i < s1.length; i++) {
            String ss = s1[i];
            StringBuilder stringBuilder = new StringBuilder(ss);
            StringBuilder reverse = stringBuilder.reverse();
            s1[i] = reverse.toString();
        }
        StringBuilder stringBuilder1 = new StringBuilder();
        for (int i = 0; i < s1.length; i++) {
            stringBuilder1.append(s1[i]);
            if (i != s1.length - 1){
                stringBuilder1.append(" ");
            }
        }
        return stringBuilder1.toString();
    }
}
