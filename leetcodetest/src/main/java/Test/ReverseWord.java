package Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 翻转字符串里的单词
 */
public class ReverseWord {

    public String reverseWords(String s) {
        List<String> list = new ArrayList();
        String[] split = s.split(" ");
        for (int i = 0; i < split.length; i++) {
            if (!split[i].equals("")) {
                list.add(split[i]);
            }
        }
        Collections.reverse(list);
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            stringBuilder.append(list.get(i));
            if (i != list.size() - 1){
                stringBuilder.append(" ");
            }
        }
        return stringBuilder.toString();
    }
}
