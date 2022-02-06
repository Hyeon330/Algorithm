package lv2;

// 정렬 > H-Index

public class Hindex {
    public static void main(String[] args) {

        int[] citations = { 0, 1, 3, 15, 16, 17, 17, 19 };

        System.out.println(solution(citations));
    }

    public static int solution(int[] citations) {
        int answer = 0;

        sort(citations, 0, citations.length - 1);
        // { 0, 1, 3, 5, 6, 7 }

        for (int i = 0; i < citations.length; i++) {
            int h = citations.length - i;
            if (citations[i] >= h) {
                answer = h;
                break;
            }
        }

        return answer;
    }

    public static void sort(int[] arr, int left, int right) {
        int pl = left;
        int pr = right;
        int pi = arr[(pl + pr) / 2];

        do {
            while (arr[pl] < pi)
                pl++;
            while (arr[pr] > pi)
                pr--;

            if (pl <= pr) {
                int tmp = arr[pl];
                arr[pl] = arr[pr];
                arr[pr] = tmp;
                pl++;
                pr--;
            }
        } while (pl <= pr);
        if (left < pr)
            sort(arr, left, pr);
        if (pl < right)
            sort(arr, pl, right);
    }
}
