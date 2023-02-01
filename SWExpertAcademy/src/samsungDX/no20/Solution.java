package samsungDX.no20;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuffer sb = new StringBuffer();
        String s1, s2;
        int[][] lcsT;
        int T, s1Len, s2Len, result;

        T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());
            s1 = st.nextToken();
            s2 = st.nextToken();

            s1Len = s1.length();
            s2Len = s2.length();

            result = 0;
            lcsT = new int[s2Len + 1][s1Len + 1];
            for (int i = 1; i < s2Len + 1; i++) {
                for (int j = 1; j < s1Len + 1; j++) {
                    if (s2.charAt(i - 1) == s1.charAt(j - 1)) {
                        lcsT[i][j] = lcsT[i - 1][j - 1] + 1;
                        if (result < lcsT[i][j])
                            result = lcsT[i][j];
                    } else {
                        if (lcsT[i - 1][j] > lcsT[i][j - 1])
                            lcsT[i][j] = lcsT[i - 1][j];
                        else
                            lcsT[i][j] = lcsT[i][j - 1];
                    }
                }
            }
            sb.append("#" + tc + " " + result + "\n");
        }
        System.out.print(sb);
    }
}
