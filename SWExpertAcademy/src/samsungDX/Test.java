package samsungDX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Test {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        StringTokenizer st;
        int T;

        T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {

            sb.append("#" + tc + " " + "\n");
        }
        System.out.print(sb);
    }
}