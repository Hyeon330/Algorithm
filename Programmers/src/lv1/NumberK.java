package lv1;

// 정렬 > k번쨰 수

import java.util.Arrays;

public class NumberK {
    public static void main(String[] args) {
        int[] arr = { 1, 5, 2, 6, 3, 7, 4 };
        int[][] commands = { { 2, 5, 3 }, { 4, 4, 1 }, { 1, 7, 3 } };

        System.out.println(Arrays.toString(solution(arr, commands)));
    }

    public static int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for (int i = 0; i < commands.length; i++) {
            int[] arrCut = Arrays.copyOfRange(array, commands[i][0] - 1, commands[i][1]);
            quickSort(arrCut, 0, arrCut.length - 1);
            answer[i] = arrCut[commands[i][2] - 1];
        }

        return answer;
    }

    public static void quickSort(int[] arr, int left, int right) {
        int pl = left;
        int pr = right;
        int pi = arr[(pl + pr) / 2];

        do {
            while (arr[pl] < pi)
                pl++;
            while (arr[pr] > pi)
                pr--;

            if (pl <= pr) {
                swap(arr, pl++, pr--);
            }
        } while (pl <= pr);

        if (left < pr) {
            quickSort(arr, left, pr);
        }
        if (pl < right) {
            quickSort(arr, pl, right);
        }
    }

    public static void swap(int[] arr, int pl, int pr) {
        int tmp = arr[pl];
        arr[pl] = arr[pr];
        arr[pr] = tmp;
    }
}
