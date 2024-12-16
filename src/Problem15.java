import java.util.*;
import java.util.stream.IntStream;

public class Problem15 {

    public static void main(String[] args) {
        System.out.println(solution(5, 2));
    }

    public static int solution(int N, int K) {
        Deque<Integer> q = new ArrayDeque<>();
        IntStream.range(1, N+1).forEach(idx -> q.add(idx));
        while (q.size() != 1) {
            for (int k = 0; k < K; k++) {
                int tmp = q.pollFirst();
                if (k == K - 1)
                    continue;
                q.addLast(tmp);
            }
        }
        return q.poll();
    }
}
