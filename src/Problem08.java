public class Problem08 {

    public static void main(String[] args) {
        System.out.println(solution("(())"));
    }

    public static boolean solution(String s) {
        boolean answer = true;

        String[] ss = s.split("");

        int count = 0;
        int half = ss.length;

        for (String p : ss) {
            if (p.equals("(")) {
                count += 1;
            }

            if (p.equals(")")) {
                count -= 1;
            }

            if (count < 0) {
                return false;
            }

            if (count > half || count < half * -1) {
                return false;
            }
        }

        if (count > 0) {
            return false;
        }

        return answer;
    }
}
