package samsung_SW;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex14888 {
    static int max = -1000000000;
    static int min = 1000000000;
    static int N;

    static void func(int[] numArr, int[] opNumArr, int result, int c) {
        if (c == N - 1) {
            if (result > max)
                max = result;
            if (result < min)
                min = result;
        }
        for (int i = 0; i < 4; i++) {
            if (opNumArr[i] > 0) {
                opNumArr[i]--;
                if (i == 0)
                    func(numArr, opNumArr, result + numArr[c + 1], c + 1);
                if (i == 1)
                    func(numArr, opNumArr, result - numArr[c + 1], c + 1);
                if (i == 2)
                    func(numArr, opNumArr, result * numArr[c + 1], c + 1);
                if (i == 3)
                    func(numArr, opNumArr, result / numArr[c + 1], c + 1);
                opNumArr[i]++;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(bf.readLine());
        int[] numArr = new int[N];

        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < N; i++)
            numArr[i] = Integer.parseInt(st.nextToken());

        int[] opNumArr = new int[4];
        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < 4; i++)
            opNumArr[i] = Integer.parseInt(st.nextToken());

        func(numArr, opNumArr, numArr[0], 0);
        System.out.println(max);
        System.out.println(min);
    }
}
