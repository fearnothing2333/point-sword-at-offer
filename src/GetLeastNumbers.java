import java.util.ArrayList;
import java.util.Arrays;

public class GetLeastNumbers {
    public ArrayList<Integer> getLeastNumbers(int[] arr, int k) {
        ArrayList<Integer> ret = new ArrayList<>();
        Arrays.sort(arr);
        for (int i = 0; i < k; i++) {
            ret.add(arr[i]);
        }
        return ret;
    }

    public static void main(String[] args) {
        GetLeastNumbers getLeastNumbers = new GetLeastNumbers();
        int[] arr = {4, 5, 1, 6, 2, 7, 3, 8};
        int k = 5;
        ArrayList<Integer> ret = getLeastNumbers.getLeastNumbers(arr, k);
        System.out.println(ret);
    }
}
