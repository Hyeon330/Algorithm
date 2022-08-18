package dynamicProg;

import java.io.*;

public class Ex2839 {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		
		if(N < 3) System.out.println(-1);
		else {
			System.out.println(count(5 * (N / 5)));
		}
		
//		if(N < 3) System.out.println(-1);
//		else if(N % 5 == 0) System.out.println(N/5);
//		else if(N < 10 && N % 3 == 0) System.out.println(N/3);
//		else System.out.println(count(N, 5 * (N / 5)));
		
		
	}
	
	static int count(int N) {
		return 0;
	}
	
//	public static int count(int N, int n) {
//		if(n < 3) return -1;
//		
//		if((N - n) % 3 == 0) return n / 5 + (N - n) / 3;
//		
//		return count(N, n-5);
//	}
}
