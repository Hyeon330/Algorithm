package samsungDX.no25_;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Solution {
    static final int MAX_NUM = 20171109;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        StringTokenizer st;
        TreeSet<Integer> ts;
        int T, N, n1, n2, m, tsSize, result;

        T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            result = 0;
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            ts = new TreeSet<>();
            m = Integer.parseInt(st.nextToken());
            ts.add(m);
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                n1 = Integer.parseInt(st.nextToken());
                n2 = Integer.parseInt(st.nextToken());
                ts.add(n1);
                ts.add(n2);
                if ((m >= n1 && m <= n2) || (m <= n1 && m >= n2))
                    result += m % MAX_NUM;
                else {
                    int j = 0;
                    tsSize = ts.size();
                    for (int n : ts) {
                        if (j == tsSize / 2) {
                            m = n;
                            result += m % MAX_NUM;
                        }
                        j++;
                    }
                }
            }
            sb.append("#" + tc + " " + result + "\n");
        }
        System.out.print(sb);
    }
}
