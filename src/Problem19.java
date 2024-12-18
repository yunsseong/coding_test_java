import java.util.*;

class Problem19 {
    public static void main(String[] args) {
        System.out.println(solution(new String[]{"leo", "kiki", "eden"}, new String[]{"eden", "kiki"}));
    }
    public static String solution(String[] participant, String[] completion) {
        HashMap<String, Integer> map = new HashMap<>();

        for (String name : completion) {
            if(map.containsKey(name)) {
                map.put(name, map.get(name) + 1);
            } else {
                map.put(name, 1);
            }
        }

        for (String name : participant) {
            if(!map.containsKey(name) || map.get(name) == 0) {
                return name;
            } else {
                map.put(name, map.get(name) - 1);
            }
        }
        return "";
    }
}