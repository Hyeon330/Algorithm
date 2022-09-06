package dynamicProg;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 45656
 * 1
 * 2
 * 3
 * 4
 * 5
 * 6
 * 7
 * 8
 * 9
 * 
 * 2
 * 10
 * 12
 * 21
 * 23
 * 32
 * 34
 * 43
 * 45
 * 54
 * 56
 * 65
 * 67
 * 76
 * 78
 * 87
 * 89
 * 98
 * 
 * 3 
 * 101
 * 121
 * 123
 * 210
 * 212
 * 232
 * 234
 * 321
 * 323
 * 343
 * 345
 * ...
 * 765
 * 767
 * 787
 * 789
 * 876
 * 878
 * 898
 * 987
 * 989
 * 
 * 4
 * 1010
 * 1012
 * 1210
 * 1212
 * 1232
 * 1234
 * 2101
 * 2121
 * 2123
 * 2321
 * 2323
 * 2343
 * 2345
 * 3210
 * 3212
 * 3232
 * 3234
 * 3432
 * 3434
 * 3454
 * 3456
 * 10101
 *
 * 모르겠다..
*/
public class Ex10844 {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(bf.readLine());
		
		Long[][] dp = new Long[n + 1][10];
		
	}
	
	static long recur(int digit, int val, Long[][] dp) {
		if(digit == 1) return dp[digit][val];
		
		if(dp[digit][val] == null) {
			if(val == 0) {
				dp[digit][val] = recur(digit - 1, 1, dp);
			}else if(val == 9) {
				dp[digit][val] = recur(digit - 1, 8, dp);
			}else {
				dp[digit][val] = recur(digit - 1, val - 1, dp) + recur(digit - 1, val + 1, dp);
			}
		}
		
		return dp[digit][val];
	}
}
