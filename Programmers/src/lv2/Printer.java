package lv2;

import java.util.ArrayList;

public class Printer {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        ArrayList<Integer> arr = new ArrayList<>();
        for (Integer integer : priorities) {
            arr.add(integer);
        }

        return answer;
    }

    public static void main(String[] args) {
        Printer printer = new Printer();
        int[] priorities = { 2, 1, 3, 2 };
        int location = 2;

        System.out.println(printer.solution(priorities, location));

    }
}
