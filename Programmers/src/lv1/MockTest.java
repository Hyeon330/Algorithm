package lv1;

import java.util.ArrayList;
import java.util.Arrays;

// 완전탐색 > 모의고사

public class MockTest {
    public static void main(String[] args) {
        int[] answers = { 1, 2, 3, 4, 5 };
        System.out.println(Arrays.toString(solution(answers)));
    }

    public static int[] solution(int[] answers) {
        int[][] suPoZa = {
                { 1, 2, 3, 4, 5 },
                { 2, 1, 2, 3, 2, 4, 2, 5 },
                { 3, 3, 1, 1, 2, 2, 4, 4, 5, 5 }
        };
        ArrayList<Integer> answerList = new ArrayList<>();
        int ctX = 0;
        int ct = 0;
        for (int i = 0; i < suPoZa.length; i++) {
            int j = 0;
            ct = 0;
            for (int num : answers) {
                if (j == suPoZa[i].length) {
                    j = 0;
                }
                if (num == suPoZa[i][j]) {
                    ct++;
                }
                j++;
            }
            if (!(ctX > ct)) {
                if (ctX < ct) {
                    answerList.clear();
                }
                ctX = ct;
                answerList.add(i + 1);
            }
        }
        int[] answer = new int[answerList.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = answerList.get(i);
        }
        return answer;
    }
}
