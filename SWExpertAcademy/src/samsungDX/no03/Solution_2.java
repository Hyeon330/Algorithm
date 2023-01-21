package samsungDX.no03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_2 {
    static final int maxNum = 1000000007;
    static String manList;
    static int cnt, maxDay;

    static int getMemNum(char m) {
        return 1 << (m - 'A');
    }

    static void func(int[] prevCases, int day) {
        if (day == maxDay) {
            for (int n : prevCases) {
                cnt += n;
                cnt %= maxNum;
            }
            return;
        }
        int[] cases = new int[16];
        int M = getMemNum(manList.charAt(day));
        for (int K = 1; K < 16; K++) {
            for (int i = 1; i < 16; i++) {
                if (prevCases[K] != 0 && (K & i) > 0 && (M & i) > 0) {
                    cases[i] += prevCases[K];
                    cases[i] %= maxNum;
                }
            }
        }
        func(cases, day + 1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        int[] firstCases;
        int T;

        T = Integer.parseInt(br.readLine());
        for (int i = 1; i <= T; i++) {
            manList = br.readLine();
            cnt = 0;
            maxDay = manList.length();
            firstCases = new int[16];
            firstCases[1] = 1;
            func(firstCases, 0);
            sb.append("#" + i + " " + cnt + "\n");
        }
        System.out.print(sb.toString());
    }
}
