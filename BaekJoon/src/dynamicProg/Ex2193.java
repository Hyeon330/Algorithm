package dynamicProg;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex2193 {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(bf.readLine());
		long dp[] = new long[n+1];
		
		/*
		 * 1 1
		 * 2 10
		 * 3 100 101
		 * 4 1000 1001 1010
		 * 5 10000 10001 10010 10100 10101
		 * 6 100000 100001 100010 100100 100101 101000 101001 101010  
		 */
		dp[1] = 1;
		for(int i = 2; i <= n; i++) {
			dp[i] = dp[i - 1] + dp[i - 2];
		}
		
		System.out.println(dp[n]);
	}
}
