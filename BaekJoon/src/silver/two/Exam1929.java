package silver.two;

/*
문제 - 소수 구하기
M이상 N이하의 소수를 모두 출력하는 프로그램을 작성하시오.

입력
첫째 줄에 자연수 M과 N이 빈 칸을 사이에 두고 주어진다. (1 ≤ M ≤ N ≤ 1,000,000) M이상 N이하의 소수가 하나 이상 있는 입력만 주어진다.

출력
한 줄에 하나씩, 증가하는 순서대로 소수를 출력한다.

예제 입력 1 
3 16

예제 출력 1 
3
5
7
11
13

*/
import java.io.*;
import java.util.StringTokenizer;

public class Exam1929 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		// ------------------------------------------------------------------------
		// 272ms

		// int m = Integer.parseInt(st.nextToken());
		// int n = Integer.parseInt(st.nextToken());
		// boolean[] p = new boolean[n + 1];
		// StringBuilder sb = new StringBuilder();

		// p[0] = true;
		// p[1] = true;

		// for (int i = 2; i <= Math.sqrt(n); i++) {
		// if (!p[i]) {
		// for (int j = i * 2; j <= n; j += i) {
		// p[j] = true;
		// }
		// }
		// }

		// for (int i = m; i <= n; i++) {
		// if (!p[i])
		// sb.append(i).append('\n');
		// }

		// System.out.println(sb);

		// -----------------------------------------------------------------------------
		// 256ms

		int m = Integer.parseInt(st.nextToken()) - 1;
		boolean[] n = new boolean[Integer.parseInt(st.nextToken())];
		StringBuilder sb = new StringBuilder();

		n[0] = true;

		for (int i = 2; i <= Math.sqrt(n.length); i++) {
			if (!n[i - 1]) {
				for (int j = i * 2; j <= n.length; j += i) {
					n[j - 1] = true;
				}
			}
		}

		for (int i = m; i < n.length; i++) {
			if (!n[i])
				sb.append(i + 1).append('\n');
		}
		System.out.println(sb);

		// ---------------------------------------------------------------------------

		// int m = Integer.parseInt(st.nextToken());
		// int n = Integer.parseInt(st.nextToken());

		// // n% 2~sqrt(n)!=0;

		// if (m == 1) {
		// m++;
		// }

		// for (int i = m; i <= n; i++) {
		// int m_ = (int) Math.sqrt(i);
		// boolean ck = true;
		// for (int j = 2; j <= m_; j++) {
		// if (i % j == 0) {
		// ck = false;
		// break;
		// }
		// }
		// if (ck) {
		// System.out.println(i);
		// }
		// }

		// -------------------------------------------------------------------------------

		// int m = Integer.parseInt(st.nextToken()) - 1;
		// boolean[] n = new boolean[Integer.parseInt(st.nextToken())];

		// n[0] = true;

		// for (int i = 2; i <= n.length; i++) {
		// if (n[i - 1]) {
		// continue;
		// }
		// for (int j = i + i; j <= n.length; j += i) {
		// n[j - 1] = true;
		// }
		// }

		// for (int i = m; i < n.length; i++) {
		// if (!n[i]) {
		// System.out.println(i + 1);
		// }
		// }
	}
}
