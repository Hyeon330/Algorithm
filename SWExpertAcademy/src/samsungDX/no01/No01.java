package samsungDX.no01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class No01 {
	static boolean isUseAllNum(boolean[] cntNum) {
		return cntNum[0] || cntNum[1] || cntNum[2] || cntNum[3] || cntNum[4] || cntNum[5] || cntNum[6] || cntNum[7] || cntNum[8] || cntNum[9];
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		int T, N, x, n;
		boolean[] cntNum = new boolean[10];
		
		T = Integer.parseInt(br.readLine());
		for (int i = 1; i <= T; i++) {
			Arrays.fill(cntNum, true);
			N = Integer.parseInt(br.readLine());
			x = 1;
			while (isUseAllNum(cntNum)) {
				n = N * x++;
				while (n != 0) {
					if (cntNum[n % 10])
						cntNum[n % 10] = false;
					n /= 10;
				}
			}
			sb.append("#" + i + " " + (N * --x) + "\n");
		}
		System.out.print(sb.toString());
	}
}
