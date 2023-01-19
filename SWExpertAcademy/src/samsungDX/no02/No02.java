package samsungDX.no02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No02 {
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
            while (N-- != 0 && M % 2 == 1) M /= 2;
            if (++N == 0) sb.append("#" + i + " " + "ON\n");
            else sb.append("#" + i + " " + "OFF\n");
        }
        System.out.print(sb.toString());
    }
}
