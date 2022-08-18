package dynamicProg;

import java.io.*;
import java.util.StringTokenizer;

public class Ex11052 {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		
		int[] cardPrice = new int[N+1];
		int[] d = new int[N+1];
		
		StringTokenizer st = new StringTokenizer(bf.readLine());
		for(int i = 1; i <= N; i++) {
			cardPrice[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= i; j++) {
				d[i] = Math.max(d[i], d[i - j] + cardPrice[j]);
			}
		}
		
		System.out.println(d[N]);
	}
}
