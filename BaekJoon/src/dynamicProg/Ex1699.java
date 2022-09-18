package dynamicProg;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex1699 {
	static void f(int n, int now, int[] dp) {
		if(n < 4) dp[now] += n;
		
		for(int i = n; i > 1; i--) {
			if(dp[i] == 1) {
				dp[now]++;
				f(n - i, now, dp);
				break;
			}
		}
	}
	public static void main(String[] args) throws IOException {
		int n = Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());
		int[] dp = new int[n + 1];
		
		int cnt = 0;
		int s = 1;
		for(int i = 1; i <= n; i++) {
			cnt++;
			if(s == cnt) {
				s += 2;
				cnt = 0;
				dp[i] = 1;
			}else {
				f(i, i, dp);
			}
		}
		
		System.out.println(dp[n]);
//		System.out.println(Math.sqrt(100000));
//		System.out.println(Math.sqrt(10000));
//		System.out.println(Math.pow(316, 2));
//		System.out.println(Math.sqrt(144));
		
//		--------------------------------------------------------
//		int cnt = 0;
//		int prev = 0;
//		for(int i = 0; i < 100000; i++) {
//			if((int)(Math.sqrt(i)*1000%1000)==0) {
//				if(prev > cnt) {
//					System.out.println("false");
//					break;
//				}
//				System.out.println(cnt);
//				prev = cnt;
//				cnt = 0;
//			}
//			cnt++;
//		}
//		--------------------------------------------------------
//		for(int i = 0; i < 100; i++) {
//			System.out.println(Math.sqrt(i));
//		}
	}
}
