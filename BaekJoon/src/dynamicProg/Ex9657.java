package dynamicProg;

import java.io.*;
import java.util.Arrays;

/*
 * 1 1 상근
 * 2 1 1 창영
 * 3 3 상근
 * 4 4 상근
 * 5 3 1 1 상근
 * 6 4 1 1 상근
 * 7 1 4 1 1 창영
 *   3 4 창영
 *   4 3 창영
 * 8 1 1 4 1 1 상근
*/

public class Ex9657 {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(bf.readLine());
		
		String[] dp = new String[n + 1];
		Arrays.fill(dp, "CY");
		for(int i = 1; i <= n; i++) {
			if(	dp[i - 1] == "CY" ||
				i >= 3 && dp[i - 3] == "CY" || 
				i >= 4 && dp[i - 4] == "CY") dp[i] = "SK";
		}
		
		System.out.println(dp[n]);
	}
}
