package dynamicProg;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 1 - 1 = 1
 * 
 * 2 - 1 1 = 2
 *     2
 * 
 * 3 - 1 1 1 = 4
 * 	   2 1
 * 	   1 2
 *     3 
 * 
 * 4 - 1 1 1 1 = 7  1 3
 * 	   2 1 1		2 2
 *     1 2 1		3 1
 *     3 1
 *     1 1 2
 *     2 2
 *     1 3
 *     
 * 5 - 1 1 1 1 1 = 13  1 4
 *     2 1 1 1		   2 3
 *     1 2 1 1		   3 2
 *     3 1 1
 *     1 1 2 1
 *     2 2 1
 *     1 3 1
 *     1 1 1 2
 *     2 1 2
 *     1 2 2
 *     3 2
 *     1 1 3
 *     2 3
 *     
 * 6 - 1 5 = 24
 *     2 4
 *     3 3
 *     
 * 7 - 1 6 = 44
 *     2 5
 *     3 4
*/

public class Ex9095 {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		
		int[] dp = new int[12];
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 4;
		
		for(int i = 4; i < dp.length; i++) {
			dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
		}
		
		int T = Integer.parseInt(bf.readLine());
		while(T-- != 0) {
			sb.append(dp[Integer.parseInt(bf.readLine())] + "\n");
		}
		
		System.out.println(sb);
	}
}
