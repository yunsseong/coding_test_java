import java.util.*;

public class Problem14 {

    public static void main(String[] args) {
        System.out.println(solution(8, 2, new String[]{"D 2","C","U 3","C","D 4","C","U 2","Z","Z"}));
    }

    public static String solution(int n, int k, String[] cmd) {
        Stack<Integer> jobStack = new Stack<>();
        LinkedList<Integer> list = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            list.add(i);
        }

        for (String c : cmd) {
            if (c.equals("C")) {
                int tmp = list.get(k);
                list.remove(k);
                jobStack.add(tmp);
                if (k == list.size()) {
                    k -= 1;
                }
                continue;
            }

            if (c.equals("Z")) {
                int prv = jobStack.pop();
                if (list.size() <= prv) {
                    list.add(prv);
                } else {
                    list.add(prv, prv);
                }

                if (prv < k) {
                    k += 1;
                }
                continue;
            }

            String[] s = c.split(" ");
            if (s[0].equals("D")) {
                int move = Integer.parseInt(s[1]);
                k += Integer.parseInt(s[1]);
                continue;
            }

            if (s[0].equals("U")) {
                k -= Integer.parseInt(s[1]);
                continue;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (list.contains(i)) {
                sb.append("O");
            } else {
                sb.append("X");
            }
        }
        return sb.toString();
    }
}

