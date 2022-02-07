package lv2;

// 정렬 > 가장 큰 수

public class BiggestNum {
    public static void main(String[] args) {
        int[] nums = { 3, 30, 34, 5, 9 };

        System.out.println(solution(nums));
    }

    public static String solution(int[] numbers) {
        String answer = "";
        StringBuffer sb = new StringBuffer();

        sort(numbers, 0, numbers.length - 1);
        if (numbers[0] == 0) {
            return "0";
        }
        for (int i : numbers) {
            sb.append(i);
        }
        answer = sb.toString();
        return answer;
    }

    public static void sort(int[] arr, int left, int right) {
        int pl = left;
        int pr = right;
        int piRealNum = arr[(left + right) / 2];
        int pi = headNum(piRealNum);
        do {
            while (headNum(arr[pl]) >= pi) {
                if (com(arr[pl], piRealNum)) {
                    break;
                }
                pl++;
            }
            while (headNum(arr[pr]) <= pi) {
                if (com(piRealNum, arr[pr])) {
                    break;
                }
                pr--;
            }
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

    public static int headNum(int num) {
        if (num >= 10) {
            num /= 10;
            num = headNum(num);
        }
        return num;
    }

    public static boolean com(int num1, int num2) {
        if (num1 != num2) {
            String a = num1 + "" + num2;
            String b = num2 + "" + num1;
            if (Integer.parseInt(a) > Integer.parseInt(b)) {
                return false;
            }
        }
        return true;
    }
}
