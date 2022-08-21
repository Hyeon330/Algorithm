package dynamicProg;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Prac3 {
	static final int DONT = -1;
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken()) + 1;
		
		int[] arr = new int[n];
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(bf.readLine());
		}
		
		int[] d = new int[m];
		for(int i = 1; i < m; i++) {
			d[i] = -1;
		}
		
		for(int i = 0; i < n; i++) {
			System.out.println(arr[i]);
			for(int j = arr[i]; j < m; j++) {
				System.out.println(j);
				System.out.println(arr[i]);
				if(d[j - arr[i]] != -1) {
					d[j] = Math.min(d[j],  d[j - arr[j]] + 1);
				}
			}
		}
		
		System.out.println(d[m]);
	}
}
