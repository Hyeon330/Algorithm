package silver.four;

/*
문제 - 소수 찾기

주어진 수 N개 중에서 소수가 몇 개인지 찾아서 출력하는 프로그램을 작성하시오.

입력
첫 줄에 수의 개수 N이 주어진다. N은 100이하이다. 다음으로 N개의 수가 주어지는데 수는 1,000 이하의 자연수이다.

출력
주어진 수들 중 소수의 개수를 출력한다.

입력
4
1 3 5 7

출력 
3
출처
*/

import java.io.*;
import java.util.StringTokenizer;

public class Exam1978 {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int cnt = Integer.parseInt(bf.readLine());
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int num = 0;
		int numCnt = 0;
		
		for (int i = 0; i < cnt; i++) {
			num = Integer.parseInt(st.nextToken());
			for (int j = 2; j <= num; j++) {
				if(j==num) {
					numCnt++;
				}
				if(num%j==0) {
					break;
				}
			}
		}
		System.out.println(numCnt);
	}
}
