package lv2;

import java.util.LinkedList;
import java.util.Queue;

public class Printer {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        Queue<Integer> qu = new LinkedList<>();
        LinkedList<Integer> li = (LinkedList<Integer>) qu;
        for (Integer integer : priorities) {
            qu.offer(integer);
        }
        boolean ck = true;
        while (ck) {
            // int imp = qu.poll();
            for (int i = 0; i < qu.size(); i++) {
                if (/* img */qu.peek() < li.get(i)) {
                    qu.offer(/* imp */qu.poll());
                    break;
                }
                if (i == qu.size() - 1) {
                    qu.remove(); // <- 없었음.
                    answer++;
                    if (location == 0) {
                        ck = false;
                    }
                }
            }
            System.out.println(qu);
            if (location == 0) {
                location = qu.size() - 1;
            } else {
                location--;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Printer printer = new Printer();
        int[] priorities = { 1, 2, 8, 3, 4 };
        int location = 4;

        System.out.println(printer.solution(priorities, location));

    }
}
