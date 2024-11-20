import java.util.*;

public class Problem10 {
    public static void main(String[] args) {
        System.out.println(solution("[](){}"));
    }

    public static int solution(String s) {

        Deque<String> p = new ArrayDeque<>();
        p.addAll(Arrays.asList(s.split("")));
        int answer = 0;

        for (int i = 0; i < p.size(); i++) {
            if (check(p)) {
                answer += 1;
            }

            String first = p.pollFirst();
            p.addLast(first);
        }
        return answer;
    }

    public static boolean check(Deque<String> d) {

        Stack<String> stack = new Stack();

        for (String s : d) {
            if (s.equals("[") || s.equals("(") || s.equals("{")) {
                stack.push(s);
            } else if (stack.isEmpty() || !match(stack.pop(), s)) {
                return false;
            }
        }
        return stack.isEmpty();
    }

    public static boolean match(String open, String close) {
        if (open.equals("["))
            return close.equals("]");

        if (open.equals("("))
            return close.equals(")");

        if (open.equals("{"))
            return close.equals("}");
        return false;
    }
}
