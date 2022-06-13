package Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 杨辉三角 II
 */
public class Yh {

    public List<Integer> getRow(int rowIndex) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < rowIndex + 1; i++) {
            Long nn = nn(rowIndex, i);
            list.add(Integer.valueOf(nn.toString()));
        }
        return list;
    }
    public Long nn(int a, int b) {
        Long ss = 1L;
        if (b == 0 || a == b) {
            return 1L;
        }
        for (int i = 0; i < b; i++) {
            ss = ss*(a-i)/(i+1);
        }
        return ss;
    }
}
