package dynamicProg;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex1149 {
	
	static final int RGB = 3;
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(bf.readLine());
		int[][] arr = new int[n][RGB];
		int[][] dp = new int[n][RGB];
		
		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			for(int j = 0; st.hasMoreTokens(); j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i = 0; i < RGB; i++) dp[0][i] = arr[0][i];
		for(int i = 1; i < n; i++) {
			dp[i][0] = Math.min(arr[i][0] + dp[i - 1][1], arr[i][0] + dp[i - 1][2]);
			dp[i][1] = Math.min(arr[i][1] + dp[i - 1][0], arr[i][1] + dp[i - 1][2]);
			dp[i][2] = Math.min(arr[i][2] + dp[i - 1][0], arr[i][2] + dp[i - 1][1]);
		}
		
		int result = dp[n - 1][0];
		for(int i = 1; i < RGB; i++) {
			result = Math.min(result, dp[n - 1][i]);
		}
		
		System.out.println(result);
	}
}
