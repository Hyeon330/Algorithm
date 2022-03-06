package lv2;

import java.util.Queue;

// 깊이/너비 우선 탐색(DFS/BFS) > 타겟 넘버

public class TargetNum {
    int answer = 0;

    public void dfs(int n, int sum, int[] numbers, int target) {
        if (n == numbers.length) {
            if (sum == target)
                answer++;
            return;
        }
        dfs(n + 1, sum + numbers[n], numbers, target);
        dfs(n + 1, sum - numbers[n], numbers, target);
    }

    public int solution(int[] numbers, int target) {
        dfs(0, 0, numbers, target);
        // ---------------------------------------------------------------------------------------------
        // int answer = 0;

        // for (int i = 0; i < Math.pow(numbers.length, 2); i++) {
        // int result = 0;
        // String pnm = String.format("%0" + numbers.length + "d",
        // Integer.parseInt(Integer.toBinaryString(i)));
        // for (int j = 0; j < numbers.length; j++) {
        // if (pnm.charAt(j) == '0') {
        // result += numbers[j];
        // } else {
        // result -= numbers[j];
        // }
        // }
        // if (result == target) {
        // answer++;
        // }
        // }

        return answer;
    }

    public static void main(String[] args) {
        // int[] numbers = { 1, 1, 1, 1, 1 };
        // int target = 3;
        int[] numbers = { 4, 1, 2, 1 };
        int target = 4;

        TargetNum tn = new TargetNum();
        System.out.println(tn.solution(numbers, target)); // 5
    }
}
