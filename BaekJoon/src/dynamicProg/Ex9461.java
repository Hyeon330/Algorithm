package dynamicProg;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex9461 {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(bf.readLine());
		StringBuffer sb = new StringBuffer();
		int[] dp = new int[102];
		dp[1] = 1;
		dp[2] = 1;
		dp[3] = 1;
		dp[4] = 2;
		dp[5] = 2;
		int cnt = 5;
		for(int i = 0; i < t; i++) {
			int n = Integer.parseInt(bf.readLine());
			if(dp[n] == 0) {
				for(int j = cnt + 1; j <= n; j++) {
					dp[j] = dp[j - 1] + dp[j - 5];
				}
			}
			sb.append(dp[n]+"\n");
		}
	}
}
