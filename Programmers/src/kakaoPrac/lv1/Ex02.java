package kakaoPrac.lv1;

// https://school.programmers.co.kr/learn/courses/30/lessons/67256
// 2020 카카오 인턴십
// 키패드 누르기

public class Ex02 {
    public static String solution(int[] numbers, String hand) {
        StringBuilder answer = new StringBuilder();
        int[][] hands = new int[2][2];
        hands[0][0] = hands[1][0] = 3;
        hands[0][1] = 0;
        hands[1][1] = 2;

        for(int num: numbers) {
            int[] num_c = new int[2];

            if (num == 0) {
                num_c[0] = 3;
                num_c[1] = 1;
            } else {
                num_c[0] = (num - 1) / 3;
                num_c[1] = (num - 1) % 3;
            }
            if (num == 0 || num % 3 == 2) {
                int lDist, rDist;

                lDist = Math.abs(hands[0][0] - num_c[0]) + Math.abs(hands[0][1] - num_c[1]);
                rDist = Math.abs(hands[1][0] - num_c[0]) + Math.abs(hands[1][1] - num_c[1]);
                if (lDist < rDist || (lDist == rDist && hand.equals("left"))) {
                    hands[0][0] = num_c[0];
                    hands[0][1] = num_c[1];
                    answer.append("L");
                } else {
                    hands[1][0] = num_c[0];
                    hands[1][1] = num_c[1];
                    answer.append("R");
                }
            } else if (num % 3 == 1) {
                hands[0][0] = num_c[0];
                hands[0][1] = num_c[1];
                answer.append("L");
            } else {
                hands[1][0] = num_c[0];
                hands[1][1] = num_c[1];
                answer.append("R");
            }
        }
        return answer.toString();
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5}, "right"));
        System.out.println(solution(new int[]{7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2}, "left"));
        System.out.println(solution(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 0}, "right"));
    }
}
