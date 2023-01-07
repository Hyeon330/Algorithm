package samsung_SW;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex14889 {
    static int N;
    static int oneTeamN;
    static int result;

    static boolean containsInt(int[] t1, int num) {
        for (int i : t1) {
            if (i == num)
                return true;
        }
        return false;
    }

    static int[] setT2(int[] t1) {
        int[] t2 = new int[N / 2];
        int j = 0;
        for (int i = 0; i < N; i++) {
            if (!containsInt(t1, i))
                t2[j++] = i;
        }
        return t2;
    }

    static int teamStat(int[][] arr, int[] team) {
        int stat = 0;
        for (int i = 0; i < oneTeamN - 1; i++) {
            for (int j = i + 1; j < oneTeamN; j++) {
                stat += arr[team[i]][team[j]];
                stat += arr[team[j]][team[i]];
            }
        }
        return stat;
    }
    static void func(int[][] arr, int[] t1, int num, int c) {
        t1[c] = num;
        if (result == 0)
            return ;
        if (c == oneTeamN - 1) {
            int[] t2 = setT2(t1);
            int teamGap = teamStat(arr, t1) - teamStat(arr, t2);
            if (teamGap < 0)
                teamGap *= -1;
            if (result > teamGap)
                result = teamGap;
            return ;
        }
        int limit = num + oneTeamN; // limit = 3
        for (int i = num; i < N - 1 && i <= limit; i++) {
            func(arr, t1, i + 1, c + 1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        result = 9999;
        N = Integer.parseInt(bf.readLine());
        oneTeamN = N / 2;
        int[][] arr = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        func(arr, new int[N / 2], 0, 0);
        System.out.println(result);
    }
}
