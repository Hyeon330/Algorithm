package dynamicProg;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Prac4 {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(bf.readLine());
		StringBuffer sb = new StringBuffer();
		
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
			
			for(int j = 1; j < m; j++) {
				for(int k = 0; k < n; k++) {
					if(k == 0) {
						if(d[k][j - 1] > d[k + 1][j - 1]) d[k][j] = d[k][j - 1];
						else d[k][j] = d[k + 1][j - 1];
					}else if (k == n - 1) {
						if(d[k][j - 1] > d[k - 1][j - 1]) d[k][j] = d[k][j - 1];
						else d[k][j] = d[k - 1][j - 1];
					}else {
						d[k][j] = Math.max(d[k][j], d[k - 1][j - 1]);
						d[k][j] = Math.max(d[k][j], d[k][j - 1]);
						d[k][j] = Math.max(d[k][j], d[k + 1][j - 1]);
					}
					d[k][j] += arr[k][j];
				}
			}
			
			int result = 0;
			for(int j = 0; j < n; j++) {
				result = Math.max(result, d[j][m - 1]);
			}
			sb.append(result + "\n");
		}
		
		System.out.print(sb);
	}
}
