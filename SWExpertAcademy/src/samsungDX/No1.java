package samsungDX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class No1 {
    static int[] ud = {-1, 1, 0, 0};
    static int[] lr = {0, 0, -1, 1};
    static boolean[] alpha = new boolean[26];
    static String[] arr;
    static int result, R, C;

    static boolean isMove(int x, int y) {
        int tmpX;
        int tmpY;
        for (int i = 0; i < 4; i++) {
            tmpX = x + lr[i];
            tmpY = y + ud[i];
            if (tmpY >= 0 && tmpY < R && tmpX >= 0 && tmpX < C && !alpha[arr[tmpY].charAt(tmpX) % 26])
                return true;
        }
        return false;
    }

    static void func(int x, int y, int cnt) {
        alpha[arr[y].charAt(x) % 26] = true;
        if (!isMove(x, y)) {
            if (result < cnt)
                result = cnt;
        } else {
            for (int i = 0; i < 4; i++) {
                int tmpX = x + lr[i];
                int tmpY = y + ud[i];
                if (tmpY >= 0 && tmpY < R && tmpX >= 0 && tmpX < C && !alpha[arr[tmpY].charAt(tmpX) % 26])
                    func(tmpX, tmpY, cnt + 1);
            }
        }
        alpha[arr[y].charAt(x) % 26] = false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer    sb = new StringBuffer();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            arr = new String[R];
            for (int i = 0; i < R; i++)
                arr[i] = br.readLine();
            Arrays.fill(alpha, false);
            result = 0;
            func(0, 0, 1);
            sb.append("#" + t + " " + result + "\n");
        }
        System.out.print(sb.toString());
    }
}
