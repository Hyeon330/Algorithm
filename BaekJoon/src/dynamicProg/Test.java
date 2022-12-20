package dynamicProg;

import java.util.Arrays;

public class Test {
	
	static int a;
	
	static void func(int a) {
		a = 3;
	}
	
	public static void main(String[] args) {
		int arr[] = {1, 2, 3, 4};
		System.out.println(Arrays.toString(arr));
		int b[] = arr.clone();
		b[2] = 10;
		System.out.println(Arrays.toString(arr));
		System.out.println(Arrays.toString(b));
	}
}