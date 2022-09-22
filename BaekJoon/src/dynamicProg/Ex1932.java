package dynamicProg;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex1932 {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(bf.readLine());
		int[][] arr = new int[n][n];
		int[][] dp = new int[n][n];
		
		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			for(int j = 0; st.hasMoreTokens(); j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dp[0][0] = arr[0][0];
		for(int i = 1; i < n; i++) {
			dp[i][0] = arr[i][0] + dp[i - 1][0];
			dp[i][i] = arr[i][i] + dp[i - 1][i - 1];
			for(int j = 1; j < i ; j++) {
				dp[i][j] = Math.max(arr[i][j] + dp[i - 1][j - 1], arr[i][j] + dp[i - 1][j]);
			}
		}
		
		int result = 0;
		for(int i = 0; i < n; i++) {
			result = Math.max(result, dp[n - 1][i]);
		}
		
		System.out.println(result);
	}
}
