package dynamicProg.G3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex11049 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int e, N = Integer.parseInt(br.readLine());
        int[][] arr = new int[2][N];
        int[][] dp = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[0][i] = Integer.parseInt(st.nextToken());
            arr[1][i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 1; i < N; i++) {
            for (int j = 0; j < N - i; j++) {
                e = j + i;
                dp[j][e] = (1 << 31) - 1;
                for (int k = j; k < e; k++) {
                    int tmp = dp[j][k] + dp[k + 1][e] + arr[0][j] * arr[1][k] * arr[1][e];
                    if (dp[j][e] > tmp)
                        dp[j][e] = tmp;
                }
            }
        }
        System.out.println(dp[0][N - 1]);
    }
}
