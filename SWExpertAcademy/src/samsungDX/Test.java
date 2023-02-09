package samsungDX;

import java.util.PriorityQueue;
import java.util.Set;

public class Test {
    public static void main(String[] args) {
        char[] name = "aa ".toCharArray();
        name[2] = 0;
        int a = 0;
        for (int i = 0; name[i] != 0; i++) {
            a = a << 5 | (name[i] ^ 96);
        }
        System.out.println(a);
    }
}