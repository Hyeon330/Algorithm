package samsungDX;

import java.util.TreeSet;

public class Test {
    public static void main(String[] args) {
        TreeSet<Integer> tr = new TreeSet<>();
        tr.add(4);
        tr.add(1);
        tr.add(6);
        tr.add(8);
        tr.add(5);
        tr.add(3);
        tr.add(7);

        System.out.println("hh" + tr.size());
        for (int i : tr) {
            System.out.println(i);
        }


    }
}