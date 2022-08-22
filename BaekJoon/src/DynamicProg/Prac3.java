package dynamicProg;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
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
		Arrays.fill(d, m);
		// 구하려는 원의 +1을 초기값으로 한 이유는 Math.min함수를 사용하기 때문에
		d[0] = 0;
		
		// 바텀업 방식(1원부터 m원까지 최소 화폐계수를 구함)
		for(int i = 0; i < n; i++) {
			for(int j = arr[i]; j < m; j++) {
				if(d[j - arr[i]] != -1) {
					d[j] = Math.min(d[j],  d[j - arr[i]] + 1);
				}
			}
		}
		
		if(d[m-1]==m) System.out.println(-1);
		else System.out.println(d[m-1]);
	}
}
