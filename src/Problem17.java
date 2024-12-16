import java.util.*;

class Problem17 {
    public static void main(String[] args) {
        System.out.println(solution(
                new String[]{"i", "drink", "water"},
                new String[]{"want","to"},
                new String[]{"i", "want", "to", "drink", "water"}
                )
        );
    }
    public static String solution(String[] cards1, String[] cards2, String[] goal) {
        Queue<String> c1 = new LinkedList<String>(List.of(cards1));
        Queue<String> c2 = new LinkedList<String>(List.of(cards2));

        for(String g : goal) {
            if (!c1.isEmpty() && c1.peek().equals(g)) {
                c1.poll();
                continue;
            }
            if (!c2.isEmpty() && c2.peek().equals(g)) {
                c2.poll();
                continue;
            }
            return "No";
        }
        return "Yes";
    }
}