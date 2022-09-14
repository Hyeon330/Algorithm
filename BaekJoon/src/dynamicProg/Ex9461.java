package dynamicProg;

import java.io.*;

public class Ex9461 {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		
//		-----------------------------------------------------
//		int t = Integer.parseInt(bf.readLine());
//		long[] dp = new long[101];
//		dp[1] = 1;
//		dp[2] = 1;
//		dp[3] = 1;
//		dp[4] = 2;
//		dp[5] = 2;
//		int cnt = 5;
//		for(int i = 0; i < t; i++) {
//			int n = Integer.parseInt(bf.readLine());
//			if(dp[n] == 0) {
//				for(int j = cnt + 1; j <= n; j++) {
//					dp[j] = dp[j - 1] + dp[j - 5];
//				}
//			}
//			sb.append(dp[n]+"\n");
//		}
		
//		------------------------------------------------------
		
		long[] dp = new long[101];
		dp[1] = 1;
		dp[2] = 1;
		dp[3] = 1;
		dp[4] = 2;
		dp[5] = 2;
		for(int i = 6; i < dp.length; i++) {
			dp[i] = dp[i - 1] + dp[i - 5];
		}
		
		int t = Integer.parseInt(bf.readLine());
		for(int i = 0; i < t; i++) {
			sb.append(dp[Integer.parseInt(bf.readLine())] + "\n");
		}
		
		System.out.println(sb);
	}
}
