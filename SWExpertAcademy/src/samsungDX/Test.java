package samsungDX;


import java.io.IOException;

public class Test {
    static void fun(Integer a) {
        if (a == 3)
            return;
        fun(++a);
    }
    public static void main(String[] args) throws IOException {
        System.out.println(0 % 123);
    }
}
