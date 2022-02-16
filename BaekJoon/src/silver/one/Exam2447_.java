package silver.one;

/*
문제 - 별 찍기 - 10

재귀적인 패턴으로 별을 찍어 보자. N이 3의 거듭제곱(3, 9, 27, ...)이라고 할 때, 크기 N의 패턴은 N×N 정사각형 모양이다.

크기 3의 패턴은 가운데에 공백이 있고, 가운데를 제외한 모든 칸에 별이 하나씩 있는 패턴이다.

***
* *
***
N이 3보다 클 경우, 크기 N의 패턴은 공백으로 채워진 가운데의 (N/3)×(N/3) 정사각형을 크기 N/3의 패턴으로 둘러싼 형태이다. 예를 들어 크기 27의 패턴은 예제 출력 1과 같다.

입력
첫째 줄에 N이 주어진다. N은 3의 거듭제곱이다. 즉 어떤 정수 k에 대해 N=3k이며, 이때 1 ≤ k < 8이다.

출력
첫째 줄부터 N번째 줄까지 별을 출력한다.

예제 입력 1 
27

예제 출력 1 
***************************
* ** ** ** ** ** ** ** ** *
***************************
***   ******   ******   ***
* *   * ** *   * ** *   * *
***   ******   ******   ***
***************************
* ** ** ** ** ** ** ** ** *
***************************
*********         *********
* ** ** *         * ** ** *
*********         *********
***   ***         ***   ***
* *   * *         * *   * *
***   ***         ***   ***
*********         *********
* ** ** *         * ** ** *
*********         *********
***************************
* ** ** ** ** ** ** ** ** *
***************************
***   ******   ******   ***
* *   * ** *   * ** *   * *
***   ******   ******   ***
***************************
* ** ** ** ** ** ** ** ** *
***************************
*
*/
import java.io.*;
import java.util.Arrays;

public class Exam2447_ {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		int n = Integer.parseInt(bf.readLine());
		char[][] star = new char[n][n];

		for (char[] cs : star) {
			Arrays.fill(cs, '*');
		}
		int start = 1;
		int end = 2;
		int primeN = isPrime(n);

		int x = primeN;
		int prime = primeN;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				// if (i % 3 >= 1 && i % 3 < 2 && j % 3 >= 1 && j % 3 < 2) {
				if (i % x >= start && i % x < end && j % x >= start && j % x < end) {
					star[i][j] = ' ';
				}
			}
		}

		x *= prime;
		start *= prime;
		end *= prime;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				// if (i % 9 >= 3 && i % 9 < 6 && j % 9 >= 3 && j % 9 < 6) {
				if (i % x >= start && i % x < end && j % x >= start && j % x < end) {
					star[i][j] = ' ';
				}
			}
		}

		x *= prime;
		start *= prime;
		end *= prime;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				// if (i % 27 >= 9 && i % 27 < 18 && j % 27 >= 9 && j % 27 < 18) {
				if (i % x >= start && i % x < end && j % x >= start && j % x < end) {
					star[i][j] = ' ';
				}
			}
		}

		// -------------------------------------------------------------------------------

		nonStar(star, n, primeN, primeN, start, end);

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				sb.append(star[i][j]);
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

	public static void nonStar(char[][] star, int n, int primeN, int x, int start, int end) {
		if (n < x) {
			return;
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (i % x >= start && i % x < end && j % x >= start && j % x < end) {
					star[i][j] = ' ';
				}
			}
		}
		x *= primeN;
		start *= primeN;
		end *= primeN;
		nonStar(star, n, primeN, x, start, end);
	}

	public static int isPrime(int n) {
		int i = 2;
		while (n % i != 0)
			i++;
		return i;
	}
}
