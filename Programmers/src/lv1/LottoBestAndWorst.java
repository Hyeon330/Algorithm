package lv1;

// Dev-Matching: 웹 백엔드 개발... > 로또의 최고 순위와 최저 순위

public class LottoBestAndWorst {

    public static void main(String[] args) {

        int[] lottos = { 44, 1, 0, 0, 31, 25 };
        int[] win_nums = { 31, 10, 45, 1, 6, 19 };
        int[] result = solution(lottos, win_nums);
        System.out.println("[" + result[0] + ", " + result[1] + "]");
    }

    public static int[] solution(int[] lottos, int[] win_nums) {
        int best = 7;
        int worst = 7;

        for (int i : lottos) {
            if (i == 0) {
                best--;
            } else {
                for (int j : win_nums) {
                    if (i == j) {
                        best--;
                        worst--;
                        break;
                    }
                }
            }
        }
        if (worst > 6)
            worst = 6;
        if (best > 6)
            best = 6;

        int[] answer = { best, worst };
        return answer;
    }

}
