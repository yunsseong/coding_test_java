import java.util.*;

/*
1. 겹치는 숫자 없애기
2. 내림차순으로 정렬하기
 */
public class Problem02 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{4, 2, 2, 1, 3, 4})));
        System.out.println(Arrays.toString(solution(new int[]{2, 1, 1, 3, 2, 5, 4})));
    }

    public static int[] solution(int[] input) {
        return Arrays.stream(input)
                .distinct()
                .map(num -> num * -1)
                .sorted()
                .map(num -> num * -1)
                .toArray();
    }
}
