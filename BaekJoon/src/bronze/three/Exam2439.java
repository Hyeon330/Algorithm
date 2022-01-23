package bronze.three;
/*
문제 - 개쉬운 별찍기
첫째 줄에는 별 1개, 둘째 줄에는 별 2개, N번째 줄에는 별 N개를 찍는 문제

하지만, 오른쪽을 기준으로 정렬한 별(예제 참고)을 출력하시오.

입력
첫째 줄에 N(1 ≤ N ≤ 100)이 주어진다.

출력
첫째 줄부터 N번째 줄까지 차례대로 별을 출력한다.

예제 입력 1 
5

예제 출력 1 
    *
   **
  ***
 ****
*****

*/

import java.util.Scanner;

public class Exam2439 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for (int i = 1; i <= n; i++) {
			for (int j = n - i; j > 0; j--) {
				System.out.print(" ");
			}
			for (int o = 1; o <= i; o++) {
				System.out.print("*");
			}
			System.out.println();
		}
		sc.close();
	}
}