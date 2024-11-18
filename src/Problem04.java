import java.util.*;

public class Problem04 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{1, 2, 3, 4, 5})));
        System.out.println(Arrays.toString(solution(new int[]{1, 3, 2, 4, 2})));
    }

    public static int[] solution(int[] input) {
        List<List<Integer>> pattern = List.of(
                List.of(1, 2, 3, 4, 5),
                List.of(2, 1, 2, 3, 2, 4, 2, 5),
                List.of(3, 3, 1, 1, 2, 2, 4, 4, 5, 5)
        );

        int[] cnt = new int[3];

        for (int i = 0; i < input.length; i++) {
            if (pattern.get(0).get(i % pattern.get(0).size()) == input[i])
                cnt[0] += 1;
            if (pattern.get(1).get(i % pattern.get(1).size()) == input[i])
                cnt[1] += 1;
            if (pattern.get(2).get(i % pattern.get(2).size()) == input[i])
                cnt[2] += 1;
        }

        int max = Arrays.stream(cnt).max().getAsInt();

        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            if (cnt[i] == max) {
                result.add(i+1);
            }
        }
        return result.stream().mapToInt(Integer::intValue).toArray();
    }


}
