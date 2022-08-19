package dynamicProg;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Prac1 {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(bf.readLine());
		int[] arr = new int[n];
		
		// DP테이블
		int[] d = new int[n];
		
		StringTokenizer st = new StringTokenizer(bf.readLine());
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		// 다이나믹프로그래밍 (바텀업)
		d[0] = arr[0];
		d[1] = Math.max(arr[0], arr[1]);
		for(int i = 2; i < n; i++) {
			d[i] = Math.max(d[i - 1], d[i - 2] + arr[i]);
		}
		
		System.out.println(d[n - 1]);
	}
}
