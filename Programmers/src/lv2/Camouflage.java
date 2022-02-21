package lv2;

import java.util.HashMap;

public class Camouflage {
    public int solution(String[][] clothes) {
        int answer = 1;
        // HashMap<String, ArrayList<String>> map = new HashMap<>();
        // for (int i = 0; i < clothes.length; i++) {
        // if (!map.containsKey(clothes[i][1])) {
        // map.put(clothes[i][1], new ArrayList<>());
        // }
        // map.get(clothes[i][1]).add(clothes[i][0]);
        // }
        // for (String s : map.keySet()) {
        // answer *= map.get(s).size() + 1;
        // }

        // ----------------------------------------------------------

        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < clothes.length; i++) {
            map.put(clothes[i][1], map.getOrDefault(clothes[i][1], 0) + 1);
        }
        for (String s : map.keySet()) {
            answer *= map.get(s) + 1;
        }
        return --answer;
    }

    public static void main(String[] args) {
        Camouflage camo = new Camouflage();
        String[][] clothes = { { "yellowhat", "headgear" }, { "bluesunglasses", "eyewear" },
                { "green_turban", "headgear" }, { "crowmask", "face" }, { "bluesunglasses", "face" },
                { "smoky_makeup", "face" } };

        System.out.println(camo.solution(clothes));
    }
}
