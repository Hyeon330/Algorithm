package lv2;

import java.util.LinkedList;
import java.util.Queue;

public class Printer {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        Queue<Integer> qu = new LinkedList<>();
        for (Integer integer : priorities) {
            qu.offer(integer);
        }
        boolean ck = true;

        // LinkedList<Integer> li = (LinkedList<Integer>) qu;
        // while (ck) {
        // for (int i = 0; i < qu.size(); i++) {
        // if (qu.peek() < li.get(i)) {
        // qu.offer(qu.poll());
        // break;
        // }
        // if (i == qu.size() - 1) {
        // qu.remove();
        // answer++;
        // if (location == 0) {
        // ck = false;
        // }
        // }
        // }
        // System.out.println(qu);
        // if (location == 0) {
        // location = qu.size() - 1;
        // } else {
        // location--;
        // }
        // }

        // --------------------------------------------------

        sort(priorities, 0, priorities.length - 1);
        int size = priorities.length - 1;

        while (ck) {
            if (qu.peek() == priorities[size - answer]) {
                qu.remove();
                location--;
                answer++;
                if (location < 0)
                    ck = false;
            } else {
                qu.add(qu.poll());
                location--;
                if (location < 0)
                    location = qu.size() - 1;
            }
        }

        return answer;
    }

    public void sort(int[] arr, int left, int right) {
        int pl = left;
        int pr = right;
        int pi = arr[(pl + pr) / 2];

        do {
            while (arr[pl] < pi)
                pl++;
            while (arr[pr] > pi)
                pr--;

            if (pl <= pr) {
                int tmp = arr[pl];
                arr[pl] = arr[pr];
                arr[pr] = tmp;
                pl++;
                pr--;
            }
        } while (pl <= pr);

        if (pl < right)
            sort(arr, pl, right);
        if (left < pr)
            sort(arr, left, pr);
    }

    public static void main(String[] args) {
        Printer printer = new Printer();
        int[] priorities = { 1, 2, 8, 3, 4 };
        int location = 4;

        System.out.println(printer.solution(priorities, location));

    }
}
