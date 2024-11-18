import java.sql.Array;
import java.util.*;

public class Problem06 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(4, new int[] {4,4,4,4,4})));
    }

    public static int[] solution(int N, int[] stages) {
        HashMap<Integer, Integer> m = new HashMap<>();

        Arrays.stream(stages)
                .forEach(num -> m.put(num, m.getOrDefault(num, 0) + 1));

        for (int i = 1; i < N+1; i++) {
            if(m.getOrDefault(i, 0) == 0)
                m.put(i, 0);
        }

        double player = stages.length;
        double prv = 0;
        HashMap<Integer, Double> r = new HashMap<>();
        for (int i = 1; i < N+1; i++) {
            double cur = m.get(i);
            player -= prv;
            if (player > 0) {
                r.put(i, cur / player);
            } else {
                r.put(i, 0.0);
            }
            prv = cur;
        }

        Map<Integer, Double> sortedMap = new TreeMap<>(r);

        List<Integer> keySet = new ArrayList<>(sortedMap.keySet());
        keySet.sort((o1, o2) -> sortedMap.get(o2).compareTo(sortedMap.get(o1)));

        return keySet.stream().mapToInt(Integer::intValue).toArray();
    }
}
