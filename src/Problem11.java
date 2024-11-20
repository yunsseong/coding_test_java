import java.util.*;

public class Problem11 {
    public static void main(String[] args) {
        System.out.println(solution("baabaa"));
    }

    public static int solution(String s)
    {
        Stack<String> d = new Stack<>();

        for (String c : s.split("")) {
            if (d.isEmpty() || !d.peek().equals(c)) {
                d.push(c);
            } else {
                d.pop();
            }
        }

        if(d.isEmpty())
            return 1;
        return 0;
    }
}
