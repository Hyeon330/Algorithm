package dynamicProg;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Prac2 {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(bf.readLine());
		int[] d = new int[n + 1];
		
		System.out.println(d[1]);
		for(int i = 2; i <= n; i++) {
			// +1은 횟수를 의미
			// 1을 빼거나 2를 나누거나 3을 나누거나 5를 나누거나 나누었을 때 당시의 f(n/i)의 횟수의 + 1
			d[i] = d[i - 1] + 1;
			if(i % 2 == 0) d[i] = Math.min(d[i], d[i / 2] + 1);
			if(i % 3 == 0) d[i] = Math.min(d[i], d[i / 3] + 1);
			if(i % 5 == 0) d[i] = Math.min(d[i], d[i / 5] + 1);
			System.out.println(d[i]);
		}
		
		System.out.println(d[n]);
	}
}
