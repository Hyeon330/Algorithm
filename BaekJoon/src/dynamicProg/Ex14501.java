package dynamicProg;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex14501 {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(bf.readLine());
		int[][] arr = new int[n][2];
		int[] dp = new int[n];
		
		while(n-- != 0) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			arr[n][0] = Integer.parseInt(st.nextToken());
			arr[n][1] = Integer.parseInt(st.nextToken());
		}
		
		dp[0] = arr[0][1];
		for(int i = 1; i < n; i++) {
			dp[i] = arr[i][1];
			for(int j = i - 1; j >= 0; i--) {
				if(i - j == arr[j][0]) {
					dp[i] = Math.max(dp[i], arr[i][1] + dp[j]);
				}
			}
		}
	}
}
