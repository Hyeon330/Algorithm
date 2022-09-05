package dynamicProg;

import java.io.*;

public class Ex2579 {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(bf.readLine());
		int[] dp = new int[n];
		int[] arr = new int[n];
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(bf.readLine());
		}
		
		dp[0] = arr[0];
		if(n > 1) dp[1] = Math.max(arr[0] + arr[1], arr[1]);
		if(n > 2) dp[2] = Math.max(arr[0] + arr[2], arr[1] + arr[2]);
		if(n > 3) {
			for(int i = 3; i < n; i++) {
				dp[i] = Math.max(arr[i] + dp[i - 2], arr[i - 1] + arr[i] + dp[i - 3]);
			}
		}
		
		System.out.println(dp[n - 1]);
	}
}
