package bronze.one;
/*
평균은 넘겠지

문제
대학생 새내기들의 90%는 자신이 반에서 평균은 넘는다고 생각한다.
당신은 그들에게 슬픈 진실을 알려줘야 한다.

입력
첫째 줄에는 테스트 케이스의 개수 C가 주어진다.
둘째 줄부터 각 테스트 케이스마다 학생의 수 N(1 ≤ N ≤ 1000, N은 정수)이 첫 수로 주어지고,
이어서 N명의 점수가 주어진다. 점수는 0보다 크거나 같고, 100보다 작거나 같은 정수이다.

출력
각 케이스마다 한 줄씩 평균을 넘는 학생들의 비율을 반올림하여 소수점 셋째 자리까지 출력한다.

예제 입력1
5
5 50 50 70 80 100
7 100 95 90 80 70 60 50
3 70 90 80
3 70 90 81
9 100 99 98 97 96 95 94 93 91

예제 출력1
40.000%
57.143%
33.333%
66.667%
55.556%
*/

import java.util.ArrayList;
import java.util.Scanner;

public class Exam4344 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCaseNum = 0;
		while (true) {
			try {
				testCaseNum = sc.nextInt();
				break;
			} catch (Exception e) {
				System.out.println("올바른 값 입력");
				sc.nextLine();
			}
		}
		sc.nextLine();

		ArrayList<ArrayList<Integer>> testCases = new ArrayList<ArrayList<Integer>>();
		inputTestCase(testCases, sc, testCaseNum);
		outputAverage(testCases);

		sc.close();

	}

	// 각각의 테스트 케이스를 리스트화 해서 testCases에 넣는 함수
	public static void inputTestCase(ArrayList<ArrayList<Integer>> testCases, Scanner sc, int testCaseNum) {
		for (int i = 1; i <= testCaseNum; i++) {
			ArrayList<Integer> grades = new ArrayList<Integer>();
			String testCase = sc.nextLine();
			for (String grade : testCase.split(" ")) {
				grades.add(Integer.parseInt(grade));
			}
			testCases.add(grades);
		}
	}

	// 평균점 보다 높은 점수의 갯수 추출
	public static float acceptNumCheck(ArrayList<Integer> grades, float gradeNum) {
		int total = 0;
		float accept = 0;

		grades.remove(0);

		for (Integer grade : grades) {
			total += grade;
		}
		for (Integer grade : grades) {
			if (grade > total / gradeNum) {
				accept++;
			}
		}

		return accept;
	}

	// 평균을 넘는 학생 비율 출력
	public static void outputAverage(ArrayList<ArrayList<Integer>> testCases) {
		for (ArrayList<Integer> grades : testCases) {
			// int total = 0;
			float gradeNum = (float) grades.get(0);

			System.out.println(String.format("%.3f", acceptNumCheck(grades, gradeNum) / gradeNum * 100) + "%");

		}
	}

}
