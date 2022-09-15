package dynamicProg;

import java.io.*;

/*
int fibonacci(int n) {
    if (n == 0) {
        printf("0");
        return 0;
    } else if (n == 1) {
        printf("1");
        return 1;
    } else {
        return fibonacci(n‐1) + fibonacci(n‐2);
    }
}

	0 1
0 - 1 0
1 - 0 1
2 - 1 1
3 - 1 2
4 - 2 3
*/

public class Ex1003 {
	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		
		int[][] dp = new int[41][2];
		dp[0][0] = 1;
		dp[0][1] = 0;
		dp[1][0] = 0;
		dp[1][1] = 1;
		
		for(int i = 2; i <= 40; i++) {
			dp[i][0] = dp[i - 1][0] + dp[i - 2][0];
			dp[i][1] = dp[i - 1][1] + dp[i - 2][1];
		}
		
		int t = Integer.parseInt(bf.readLine());
		while(t-- != 0) {
			int n = Integer.parseInt(bf.readLine());
			sb.append(dp[n][0] + " " + dp[n][1] + "\n");
		}
		
		System.out.println(sb);
	}
}
