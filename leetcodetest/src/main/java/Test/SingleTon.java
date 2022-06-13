package Test;

public class SingleTon {

    String sql = "select id,name from student where name in (select name from student group by name having count(name) > 1) order by name";

    public static int getArr(int[] arr, int left, int right){
        int mark = arr[left];
        while(left < right){
            while(left < right && mark < arr[right]){
                right--;
            }
            arr[left] = arr[right];
            while(left < right && mark > arr[right]){
                left++;
            }
            arr[right] = arr[left];
        }

        arr[left] = mark;
        return left;
    }

    public static void quickSort(int[] arr, int left, int right){
        if(left < right){
            int middle = getArr(arr, left, right);
            quickSort(arr, left, middle - 1);
            quickSort(arr, middle + 1, right);
        }
    }

    public static void main(String[] args) {
        Integer i1 = 100;
        int i2 = 100;
        System.out.println(i1==i2);
    }

}
