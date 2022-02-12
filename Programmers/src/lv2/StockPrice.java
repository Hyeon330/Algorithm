package lv2;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class StockPrice {
    public int[] solution(int[] prices) {
        int l = prices.length;
        int[] answer = new int[l];

        Queue<Integer> qu = new LinkedList<>();
        for (int i : prices) {
            qu.add(i);
        }
        for (int i = 0; i < l; i++) {
            int sec = 0;
            int num = qu.poll();
            for (Integer s : qu) {
                sec++;
                if (num > s) {
                    break;
                }
            }
            answer[i] = sec;
        }

        // --------------------------------------------------

        // for (int i = 0; i < l; i++) {
        // int sec = 0;
        // for (int j = i + 1; j < l; j++) {
        // sec++;
        // if (prices[i] > prices[j]) {
        // break;
        // }
        // }
        // answer[i] = sec;
        // }
        return answer;
    }

    public static void main(String[] args) {
        StockPrice sp = new StockPrice();
        int[] prices = { 1, 2, 3, 2, 3 };

        System.out.println(Arrays.toString(sp.solution(prices)));
    }
}
