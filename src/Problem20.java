import java.util.*;
class Problem20 {

    public static void main(String[] args) {
        System.out.println(solution(new String[]{"banana", "apple", "rice", "pork", "pot"}, new int[]{3, 2, 2, 2, 1}, new String[]{"chicken", "apple", "apple", "banana", "rice", "apple", "pork", "banana", "pork", "rice", "pot", "banana", "apple", "banana"}));
    }
    public static int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        HashMap<String, Integer> map = new HashMap<>();
        HashMap<String, Integer> wantMap = new HashMap<>();
        Queue<String> q = new LinkedList<>();

        for(int i = 0; i < want.length; i++)
            wantMap.put(want[i], number[i]);

        for(String d : discount) {
            map.put(d, map.getOrDefault(d, 0) + 1);
            q.add(d);
            if (q.size() > 10) {
                String name = q.poll();
                if (map.get(name) == 1) {
                    map.remove(name);
                } else {
                    map.put(name, map.get(name) - 1);
                }
            }
            if (wantMap.equals(map))
                answer++;
        }
        return answer;
    }
}