package dynamicProg;

import java.io.*;

public class Ex2839 {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		
		if(N < 3) System.out.println(-1);
		else if(N % 5 == 0) System.out.println(N/5);
		else if(N < 10 && N % 3 == 0) System.out.println(N/3);
		else System.out.println(count(N, 5 * (N / 5)));
	}
	
	public static int count(int N, int n) {
		if(n < 3) return -1;
		
		if((N - n) % 3 == 0) return n / 5 + (N - n) / 3;
		
		return count(N, n-5);
	}
}

//import java.io.InputStreamReader;
//import java.io.BufferedReader;
//import java.io.IOException;
// 
//public class Main {
// 
//	public static void main(String[] args) throws IOException {
//		
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		int N = Integer.parseInt(br.readLine());
//		
// 
//		if (N == 4 || N == 7) {
//			System.out.println(-1);
//		}
//		else if (N % 5 == 0) {
//			System.out.println(N / 5);
//		}
//		else if (N % 5 == 1 || N % 5 == 3) {
//			System.out.println((N / 5) + 1);
//		}
//		else if (N % 5 == 2 || N % 5 == 4) {
//			System.out.println((N / 5) + 2);
//		}
//	}
//}
