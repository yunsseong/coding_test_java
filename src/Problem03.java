import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class Problem03 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{2, 1, 3, 4, 1})));
        System.out.println(Arrays.toString(solution(new int[]{5, 0, 2, 7})));
    }

    public static int[] solution(int[] input) {
        List<Integer> numberList = new ArrayList<>();
        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input.length; j++) {
                if (i != j)
                    numberList.add(input[i] + input[j]);
            }
        }
        return numberList.stream()
                .distinct()
                .mapToInt(Integer::intValue)
                .sorted()
                .toArray();
    }
}
