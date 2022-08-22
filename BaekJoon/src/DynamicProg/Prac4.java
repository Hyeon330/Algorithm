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
			
			int[] arr = new int[n * m];
			st = new StringTokenizer(bf.readLine());
			for(int j = 0; j < arr.length; j++) {
				arr[j] = Integer.parseInt(st.nextToken());
			}
			
			int[] d = new int[m];
			for(int j = 0; j < m; j++) {
				for(int k = j; k < arr.length; k += m) {
					d[j] = Math.max(d[j], arr[k]);
				}
			}
		}
	}
}
