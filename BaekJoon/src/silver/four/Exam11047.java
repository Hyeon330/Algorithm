package silver.four;

import java.io.*;
import java.util.StringTokenizer;

public class Exam11047 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int[] coinArr = new int[N];
		int K = Integer.parseInt(st.nextToken());
		
		for(int i=0; i<N; i++) {
			coinArr[i] = Integer.parseInt(br.readLine());
		}
		
		int cnt = 0;
		for(int i=N-1; i>=0 && K!=0; i--) {
			if(coinArr[i]<=K) {
				cnt += K/coinArr[i];
				K %= coinArr[i];
			}
		}
		
		System.out.println(cnt);
	}
	
}
