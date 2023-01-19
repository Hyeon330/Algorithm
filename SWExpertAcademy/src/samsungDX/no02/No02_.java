package samsungDX.no02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No02_ {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuffer sb = new StringBuffer();
        int T, N, M;

        T = Integer.parseInt(br.readLine());
        for (int i = 1; i <= T; i++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            for (int j = 0; N-- != 0; j++)
                if ((M | (1 << j)) != M) break;
            if (++N == 0) sb.append("#" + i + " " + "ON\n");
            else sb.append("#" + i + " " + "OFF\n");
        }
        System.out.print(sb.toString());
    }
}
