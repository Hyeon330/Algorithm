package dynamicProg;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex9465 {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		
		int T = Integer.parseInt(bf.readLine());
		while(T-- != 0) {
			int n = Integer.parseInt(bf.readLine());
			int[][] arr = new int[2][n];
			int[][] dp = new int[2][n];
			int[] d = new int[n];
			
			StringTokenizer st0 = new StringTokenizer(bf.readLine());
			StringTokenizer st1 = new StringTokenizer(bf.readLine());
			for(int i = 0; st0.hasMoreTokens(); i++) {
				arr[0][i] = Integer.parseInt(st0.nextToken());
				arr[1][i] = Integer.parseInt(st1.nextToken());
			}
			
			dp[0][0] = arr[0][0];
			dp[1][0] = arr[1][0];
			d[0] = Math.max(dp[0][0], dp[1][0]);
			for(int i = 1; i < n; i++) {
				dp[0][i] = arr[0][i] + dp[1][i - 1];
				dp[1][i] = arr[1][i] + dp[0][i - 1];
				if(i > 1) {
					for(int j = 0; j < 2; j++) {
						dp[j][i] = Math.max(dp[j][i], arr[j][i] + d[i - 2]);
					}
				}
				d[i] = Math.max(dp[0][i], dp[1][i]);
			}
			
			sb.append(d[n - 1] + "\n");
		}
		
		System.out.println(sb);
	}
}
