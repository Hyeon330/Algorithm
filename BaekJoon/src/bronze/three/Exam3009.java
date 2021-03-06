package bronze.three;

/*
문제 - 네 번째 점
세 점이 주어졌을 때, 축에 평행한 직사각형을 만들기 위해서 필요한 네 번째 점을 찾는 프로그램을 작성하시오.

입력
세 점의 좌표가 한 줄에 하나씩 주어진다. 좌표는 1보다 크거나 같고, 1000보다 작거나 같은 정수이다.

출력
직사각형의 네 번째 점의 좌표를 출력한다.

예제 입력 1 
5 5
5 7
7 5

예제 출력 1 
7 7

예제 입력 2 
30 20
10 10
10 20

예제 출력 2 
30 10

*/

import java.io.*;
import java.util.StringTokenizer;

public class Exam3009 {
	public static void main(String[] args) throws IOException {

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		int[] numX = new int[3];
		int[] numY = new int[3];

		for (int i = 0; i < numX.length; i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			numX[i] = Integer.parseInt(st.nextToken());
			numY[i] = Integer.parseInt(st.nextToken());
		}

		if (numX[0] == numX[1]) {
			sb.append(numX[2]);
		} else if (numX[1] == numX[2]) {
			sb.append(numX[0]);
		} else {
			sb.append(numX[1]);
		}
		sb.append(" ");
		if (numY[0] == numY[1]) {
			sb.append(numY[2]);
		} else if (numY[1] == numY[2]) {
			sb.append(numY[0]);
		} else {
			sb.append(numY[1]);
		}
		System.out.println(sb);
	}
}