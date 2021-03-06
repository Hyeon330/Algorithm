package lv2;

import java.util.Arrays;

// 완전탐색 > 카펫

public class Carpet {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(24, 24)));
    }

    public static int[] solution(int brown, int yellow) {
        // int[] answer = new int[2];
        // int num = brown + yellow;

        // for (int i = 3; i <= Math.sqrt(num); i++) {
        // if (num % i == 0) {
        // int tmp = num / i;
        // if (yellow == (tmp - 2) * (i - 2)) {
        // answer[0] = tmp;
        // answer[1] = i;
        // break;
        // }
        // }
        // }

        // -------------------------------------------------

        int[] answer = new int[2];
        int area = brown + yellow;
        // area = x * y ==> x = area/y
        // yellow = (x-2)*(y-2) ==> (area/y-2)*(y-2)
        for (int i = 1; i < area; i++) {
            if (yellow == (area / i - 2) * (i - 2)) {
                answer[0] = area / i;
                answer[1] = i;
                break;
            }
        }
        return answer;
    }
}
