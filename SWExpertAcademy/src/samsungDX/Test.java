package samsungDX;

import java.io.IOException;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Test {
    public static void main(String[] args) throws IOException {
        PriorityQueue<Integer> a = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return 0;
            }
        })
    }
}