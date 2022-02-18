package lv1;

import java.util.Arrays;

public class NotFinishedPlayer {
    public String solution(String[] participant, String[] completion) {
        String answer = "";

        for (String s : participant) {
            if (!Arrays.asList(completion).contains(s)) {
                return s;
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
