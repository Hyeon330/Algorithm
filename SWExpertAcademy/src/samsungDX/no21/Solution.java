package samsungDX.no21;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static int func(int i, int K, int[] V, int[] C) {
        if (i <= 0 || K <= 0) return 0;
        if (V[i] > K) {
            int value = func(i - 1, K, V, C);
//            System.out.println(i - 1 + " " + W + " " + value);
            return value;
        } else {
            int left = func(i - 1, K, V, C);
//            System.out.println(i - 1 + " " + W + " " + left);
            int right = func(i - 1, K - V[i], V, C);
//            System.out.println(i - 1 + " " + (W - w[i]) + " " + right);
            return Math.max(left, C[i] + right);
        }
    }
    // W = K, w = 무게 배열, p = 가치 배열
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        StringTokenizer st;
        int[] V, C;
        int T, N, K, result;

        T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            V = new int[N + 1];
            C = new int[N + 1];
            for (int i = 1; i <= N; i++) {
                st = new StringTokenizer(br.readLine());
                V[i] = Integer.parseInt(st.nextToken());
                C[i] = Integer.parseInt(st.nextToken());
            }
            result = func(N, K, V, C);

            sb.append("#" + tc + " " + result + "\n");
        }
        System.out.print(sb);
    }
}
