package d3;

import java.io.*;
import java.util.*;

public class E13229 {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		List<String> week = new ArrayList<String>(Arrays.asList("MON", "TUE", "WED", "THU", "FRI", "SAT", "SUN"));
		int weekL = week.size();

		int T = Integer.parseInt(bf.readLine());

		StringBuffer sb = new StringBuffer();
		for (int i = 1; i <= T; i++) {
			sb.append("#" + i + " ");
			String S = bf.readLine();
			int day = 7;
			int cnt = 0;
			for (int j = week.indexOf(S) + 1; j < weekL; j++) {
				day = ++cnt;
			}
			sb.append(day + "\n");
		}

		System.out.println(sb.toString());
	}
}
