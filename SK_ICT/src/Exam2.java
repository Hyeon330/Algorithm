import java.util.Arrays;

public class Exam2 {
    public int[][] solution(int n, boolean clockwise) {
        int[][] answer = new int[n][n];

        if (clockwise) {
            for (int i = 0; i < answer.length; i++) {

            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Exam2 ex2 = new Exam2();

        int n = 5;
        boolean clockwise = true; // 시계
        // int n = 6;
        // boolean clockwise = false; // 반시계
        // int n = 9;
        // boolean clockwise = false; // 반시계

        for (int[] i : ex2.solution(n, clockwise)) {
            System.out.println(Arrays.toString(i));
        }
    }
}
