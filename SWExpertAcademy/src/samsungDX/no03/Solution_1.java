package samsungDX.no03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_1 {
    static String manList;
    static int cnt, maxDay;
    static final int maxNum = 1000000007;

    static int getManager(int day) {
        if (manList.charAt(day) == 'A') return 1;
        if (manList.charAt(day) == 'B') return 2;
        if (manList.charAt(day) == 'C') return 4;
        else return 8;
    }
    static void func(int prev, int idx) {
        if (idx == maxDay) {
            cnt++;
            cnt %= maxNum;
            return;
        }
        int M = getManager(idx);
        for (int i = 0; i < 16; i++) {
            if (((prev & i) != 0) && ((M & i) != 0))
                func(i, idx + 1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        int T;

        T = Integer.parseInt(br.readLine());
        for (int i = 1; i <= T; i++) {
            manList = br.readLine();
            cnt = 0;
            maxDay = manList.length();
            func(1, 0);
            sb.append("#" + i + " " + cnt + "\n");
        }
        System.out.print(sb.toString());
    }
}
/*
BC
ab      ac      *
        bc      *
        abc     *
        acd     *
        bcd
        abcd    *
abc     c
        ac
        bc
        cd
        abc
        acd
        bcd
        abcd
abd     ac
        bc
        cd
        abc
        acd
        bcd
        abcd
abcd    c
        ac
        bc
        cd
        abc
        acd
        bcd
        abcd

 */
