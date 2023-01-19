package samsungDX.no03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No03 {
    static String manList;
    static int cnt, max;

    static int setManager(int idx) {
        if (manList.charAt(idx) == 'A') return 1;
        if (manList.charAt(idx) == 'B') return 2;
        if (manList.charAt(idx) == 'C') return 4;
        else return 8;
    }
    static void func(int prev, int idx) {
        if (idx == max) {
            cnt++;
            return ;
        }
        int M = setManager(idx);
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
            max = manList.length();
            func(1, 0);
            sb.append("#" + i + " " + cnt + "\n");
        }
        System.out.println(sb.toString());
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
