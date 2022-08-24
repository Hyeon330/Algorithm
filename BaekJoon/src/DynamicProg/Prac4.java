package dynamicProg;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Prac4 {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(bf.readLine());
		
		StringTokenizer st = null;
		for(int i = 0; i < T; i++) {
			st = new StringTokenizer(bf.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			
			int[][] arr = new int[n][m];
			st = new StringTokenizer(bf.readLine());
			for(int j = 0; j < n; j++) {
				for(int k = 0; k < m; k++) {
					arr[j][k] = Integer.parseInt(st.nextToken());
				}
			}
			
			int[][] d = new int[n][m];
			for(int j = 0; j < n; j++) {
				d[j][0] = arr[j][0];
			}
//			---------------------------------------
			
			for(int j = 0; j < n; j++) {
				for(int k = 1; k < m; k++) {
					if(j == 0) {
						if(d[j][k - 1] > d[j + 1][k - 1]) d[j][k] = d[j][k - 1];
						else d[j][k] = d[j + 1][k - 1];
					}else if (j == n - 1) {
						if(d[j][k - 1] > d[j - 1][k - 1]) d[j][k] = d[j][k - 1];
						else d[j][k] = d[j - 1][k - 1];
					}else {
						d[j][k] = Math.max(d[j][k], d[j - 1][k - 1]);
						d[j][k] = Math.max(d[j][k], d[j][k - 1]);
						d[j][k] = Math.max(d[j][k], d[j + 1][k - 1]);
					}
					d[j][k] += arr[j][k];
					System.out.println(d[j][k]);
				}
			}
			
			for(int j = 0; j < n; j++) {
				System.out.println(d[j][m - 1]);
			}
		}
	}
}
