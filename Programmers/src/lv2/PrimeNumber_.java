package lv2;

//완전탐색 > 소수 찾기

public class PrimeNumber_ {
    public static void main(String[] args) {
        String numbers = "011";
        solution(numbers);
    }

    public static int solution(String numbers) {
        int answer = 0;
        int[] num = new int[numbers.length()];

        for (int i = 0; i < num.length; i++) {
            num[i] = numbers.charAt(i) - 48;
        }

        return answer;
    }
}