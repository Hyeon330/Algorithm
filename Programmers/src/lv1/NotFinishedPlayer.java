package lv1;

import java.util.Arrays;
import java.util.HashMap;

public class NotFinishedPlayer {
    public String solution(String[] participant, String[] completion) {
        String answer = "";

        HashMap<String, Integer> map = new HashMap<>();
        // for (String s : participant) {
        // map.put(s, 0);
        // }
        // for (String s : participant) {
        // map.put(s, map.get(s) + 1);
        // }

        for (String s : participant) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
        for (String s : completion) {
            map.put(s, map.get(s) - 1);
        }

        // --------------------------------------------------------------
        // Set<Entry<String, Integer>> entrySet = map.entrySet();
        // for (Entry<String, Integer> entry : entrySet) {
        // if (entry.getValue().equals(1)) {
        // return entry.getKey();
        // }
        // }

        for (String key : map.keySet()) {
            if (map.get(key) != 0) {
                return key;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        NotFinishedPlayer nfp = new NotFinishedPlayer();
        // String[] participant = { "leo", "kiki", "eden" };
        // String[] completion = { "eden", "kiki" };

        // String[] participant = { "marina", "josipa", "nikola", "vinko", "filipa" };
        // String[] completion = { "josipa", "filipa", "marina", "nikola" };

        String[] participant = { "mislav", "stanko", "mislav", "ana" };
        String[] completion = { "stanko", "ana", "mislav" };

        System.out.println(nfp.solution(participant, completion));
    }
}
