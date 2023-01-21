package samsungDX.no03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    static final int maxNum = 1000000007;

    static int getMemNum(char m) {
        return 1 << (m - 'A');
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        String manList;
        int[] cases, prevCases;
        int T, M, cnt, maxDay;

        T = Integer.parseInt(br.readLine());
        for (int i = 1; i <= T; i++) {
            cnt = 0;
            manList = br.readLine();
            maxDay = manList.length();
            prevCases = new int[16];
            prevCases[1] = 1;
            for (int day = 0; day < maxDay; day++) {
                cases = new int[16];
                M = getMemNum(manList.charAt(day));
                for (int K = 1; K < 16; K++) {
                    for (int j = 1; j < 16 && prevCases[K] != 0; j++) {
                        if ((K & j) > 0 && (M & j) > 0) {
                            cases[j] += prevCases[K];
                            cases[j] %= maxNum;
                        }
                    }
                }
                prevCases = cases;
            }
            for (int n : prevCases) {
                cnt += n;
                cnt %= maxNum;
            }
            sb.append("#" + i + " " + cnt + "\n");
        }
        System.out.print(sb.toString());
    }
}
