import java.util.*;

class Problem21 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(
                new String[]{"Enter uid1234 Muzi", "Enter uid4567 Prodo", "Leave uid1234", "Enter uid1234 Prodo",
                        "Change uid4567 Ryan"})));
    }
    public static String[] solution(String[] record) {
        List<String> answer = new ArrayList<>();

        HashMap<String, String> uidMap = new HashMap<>();

        for(String r : record) {
            String[] s = r.split(" ");
            if (s.length == 3)
                uidMap.put(r.split(" ")[1], r.split(" ")[2]);
        }

        for(String r : record) {
            String[] s = r.split(" ");
            StringBuilder sb = new StringBuilder();
            if (!s[0].equals("Change")) {
                sb.append(uidMap.get(s[1])).append("님이 ");
                if (s[0].equals("Enter")) {
                    sb.append("들어왔습니다.");
                } else {
                    sb.append("나갔습니다.");
                }
                answer.add(sb.toString());
            }
        }
        return answer.toArray(String[]::new);
    }
}