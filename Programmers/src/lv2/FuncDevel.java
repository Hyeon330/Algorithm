package lv2;

import java.util.ArrayList;
import java.util.Arrays;

// 스택/큐 > 기능개발

public class FuncDevel {
    public int[] solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> arr = new ArrayList<>();
        int ct = 0;
        int ck = 0;

        while (ck < progresses.length) {
            ct = 0;
            for (int i = ck; i < progresses.length; i++) {
                progresses[i] += speeds[i];
                System.out.println(progresses[i]);
            }
            for (int i = ck; i < progresses.length; i++) {
                if (progresses[i] < 100) {
                    break;
                }
                ct++;
                ck++;
            }
            if (ct != 0) {
                arr.add(ct);
            }
        }
        int[] answer = new int[arr.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = arr.get(i);
        }
        return answer;
    }

    public static void main(String[] args) {
        FuncDevel fd = new FuncDevel();

        int[] progresses = { 93, 30, 55 };
        int[] speeds = { 1, 30, 5 };

        System.out.println(Arrays.toString(fd.solution(progresses, speeds)));
    }
}