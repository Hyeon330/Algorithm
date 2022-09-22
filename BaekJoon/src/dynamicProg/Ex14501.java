package dynamicProg;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Ex14501 {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(bf.readLine());
		int[][] arr = new int[n][2];
		int[] dp = new int[n];
		
		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 0; i < n; i++) {
			if(i + arr[i][0] <= n) {
				dp[i] = arr[i][1];
				for(int j = i - 1; j >= 0; j--) {
					if(i - j >= arr[j][0]) {
						dp[i] = Math.max(dp[i], arr[i][1] + dp[j]);
					}
				}
			}
		}
		
		Arrays.sort(dp);
		System.out.println(dp[dp.length - 1]);
	}
}
