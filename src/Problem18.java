import java.util.*;

public class Problem18 {

    public static void main(String[] args) {
        System.out.println(solution(new int[]{2,3,5,9}, 10));
    }

    public static boolean solution(int[] arr, int target) {
        HashMap<Integer, Integer> numberMap = new HashMap<>();
        for (int i : arr) {
            numberMap.put(i, i);
        }

        for (int i : arr) {
            if(numberMap.containsKey(target - i) && target - i != i)
                return true;
        }
        return false;
    }
}
