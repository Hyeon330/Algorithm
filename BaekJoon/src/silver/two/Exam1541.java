package silver.two;

import java.io.*;
import java.util.StringTokenizer;

public class Exam1541 {
	
	static int plusNum(String str) {
		int plusNum = 0;
		StringTokenizer plusNumSt = new StringTokenizer(str, "+");
		
		while(plusNumSt.hasMoreTokens()) {
			plusNum += Integer.parseInt(plusNumSt.nextToken());
		}
		
		return plusNum;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), "-");
		int result = 0;
		
		result += plusNum(st.nextToken());
		while(st.hasMoreTokens()) {
			result -= plusNum(st.nextToken());
		}
		
		System.out.println(result);
	}
}
