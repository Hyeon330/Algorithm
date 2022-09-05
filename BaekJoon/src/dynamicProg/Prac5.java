package dynamicProg;

import java.io.*;
import java.util.*;

public class Prac5 {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());
		ArrayList<Integer> arr = new ArrayList<Integer>(n);
		int[] d = new int[n];
		Arrays.fill(d, 1);
		
		StringTokenizer st = new StringTokenizer(bf.readLine());
		for(int i = 0; i < n; i++) {
			arr.add(Integer.parseInt(st.nextToken()));
		}
		Collections.reverse(arr);
		
		for(int i = 1; i < n; i++) {
			for(int j = 0; j < i; j++) {
				if(arr.get(j) < arr.get(i)) d[i] = Math.max(d[i], d[j] + 1);
				System.out.print(d[i]);
			}
			System.out.println();
		}
		
		int result = 0;
		for(int i = 0; i < n; i++) {
			result = Math.max(result, d[i]);
		}
		
		System.out.println(n - result);
	}
}
