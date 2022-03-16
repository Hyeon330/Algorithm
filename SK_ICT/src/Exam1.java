public class Exam1 {
    int answer = 0;
    float[] coin = { 1, 5, 10, 50, 100, 500 };

    public int solution(int money, int[] costs) {
        float[] ck = new float[costs.length];
        boolean[] flag = new boolean[costs.length];

        for (int i = 0; i < ck.length; i++) {
            ck[i] = coin[i] / (float) costs[i];
        }

        f(money, ck, costs, flag);

        return answer;
    }

    void f(int money, float[] ck, int[] costs, boolean[] flag) {
        int maxI = 0;
        float max = 0;
        int resultCoinNum = 0;
        int result = 0;
        for (int i = 0; i < ck.length; i++) {
            if (max <= ck[i] && !flag[i]) {
                maxI = i;
                max = ck[i];
            }
        }
        flag[maxI] = true;
        resultCoinNum = money / (int) coin[maxI];
        result = (int) coin[maxI] * resultCoinNum;
        if (0 <= money - result) {
            answer += costs[maxI] * resultCoinNum;
            if (0 == money - result) {
                return;
            }
            f(money - result, ck, costs, flag);
        } else {
            f(money, ck, costs, flag);
        }
    }

    public static void main(String[] args) {
        Exam1 e1 = new Exam1();

        // cost: 1, 5, 10, 50, 100, 500

        // int money = 4578;
        // int[] costs = { 1, 4, 99, 35, 50, 1000 }; // 2308;

        int money = 1999;
        int[] costs = { 2, 11, 20, 100, 200, 600 }; // 2798

        System.out.println(e1.solution(money, costs));
    }
}
