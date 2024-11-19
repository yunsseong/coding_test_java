import java.util.*;

public class Problem07 {
    public static void main(String[] args) {
        System.out.println(solution("ULURRDLLU"));
    }

    public static int solution(String dirs) {
        int answer = 0;

        String[] direction = dirs.split("");

        List<String> visit = new ArrayList<>();

        int cur_x = 0;
        int cur_y = 0;
        int com_x = 0;
        int com_y = 0;

        for (String d : direction) {
            com_x = trance_x(d) + cur_x;
            com_y = trance_y(d) + cur_y;

            if (com_x > 5 || com_y > 5 || com_x < -5 || com_y < -5) {
                continue;
            }

            if (visit.contains(cur_x + " " + cur_y + " " + com_x + " " + com_y)) {
                cur_x = com_x;
                cur_y = com_y;
                continue;
            }

            if (visit.contains(com_x + " " + com_y + " " + cur_x + " " + cur_y)) {
                cur_x = com_x;
                cur_y = com_y;
                continue;
            }

            visit.add(cur_x + " " + cur_y + " " + com_x + " " + com_y);
            visit.add(com_x + " " + com_y + " " + cur_x + " " + cur_y);

            answer += 1;

            cur_x = com_x;
            cur_y = com_y;

        }
        return answer;
    }

    public static int trance_x(String d) {
        if (d.equals("L")) {
            return -1;
        }
        if (d.equals("R")) {
            return 1;
        }
        return 0;
    }

    public static int trance_y(String d) {
        if (d.equals("D")) {
            return -1;
        }
        if (d.equals("U")) {
            return 1;
        }
        return 0;
    }
}
