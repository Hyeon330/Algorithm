package samsungDX;

import java.util.PriorityQueue;

public class Test {
    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> {
            int x = Integer.parseInt(o1.toString());
            int y = Integer.parseInt(o2.toString());

            if (x < y) return 1;
            return -1;
        });
        pq.add(3);
        pq.add(1);
        pq.add(2);
        pq.add(0);
        pq.add(5);
        pq.add(8);
        System.out.println(pq);
    }
}