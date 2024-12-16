import java.util.*;

public class Problem16 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{93, 30, 55}, new int[]{1, 30, 5})));
    }

    public static int[] solution(int[] progresses, int[] speeds) {
        List<Integer> answer = new ArrayList<>();
        int cnt = 0;

        Deque<Integer> p = new LinkedList<>();
        Deque<Integer> s = new LinkedList<>();

        for(int i = 0; i < progresses.length; i++) {
            p.add(progresses[i]);
            s.add(speeds[i]);
        }

        int prvEta = calcEta(p.poll(), s.poll());
        System.out.println(prvEta);
        cnt++;

        while(!p.isEmpty()) {
            int curEta = calcEta(p.poll(), s.poll());

            if (prvEta >= curEta) {
                cnt++;
            } else {
                answer.add(cnt);
                prvEta = curEta;
                cnt = 1;
            }
        }

        answer.add(cnt);

        return answer.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }

    public static int calcEta(double p, double s) {
        return (int) Math.ceil((100 - p) / s);
    }
}
