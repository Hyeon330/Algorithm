package kakaoPrac.lv1;

// https://school.programmers.co.kr/learn/courses/30/lessons/64061
// 2019 카카오 개발자 겨울 인턴십
// 크레인 인형뽑기 게임

import java.util.Stack;

public class Ex03 {
    public static int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> basket = new Stack<>();

        for (int n: moves) {
            for (int i = 0; i < board.length; i++) {
                if (board[i][n - 1] > 0) {
                    if (!basket.isEmpty() && basket.peek() == board[i][n - 1]) {
                        basket.pop();
                        answer += 2;
                    } else
                        basket.push(board[i][n - 1]);
                    board[i][n - 1] = 0;
                    break;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[][]{
                {0,0,0,0,0},
                {0,0,1,0,3},
                {0,2,5,0,1},
                {4,2,4,4,2},
                {3,5,1,3,1}
        }, new int[]{1,5,3,5,1,2,1,4}));
    }
}
