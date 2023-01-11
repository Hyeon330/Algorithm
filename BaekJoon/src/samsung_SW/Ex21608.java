package samsung_SW;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Ex21608 {
    static int[] ud = {-1, 0, 1, 0};
    static int[] rl = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int tot = N * N;
        int[][] seat = new int[N][N];
        int[] key = new int[tot];
        HashMap<Integer, HashSet<Integer>> like = new HashMap<>();
        HashSet<Integer> set;
        for (int i = 0; i < tot; i++) {
            if (i < N)
                Arrays.fill(seat[i], 0);
            st = new StringTokenizer(br.readLine());
            set = new HashSet<>();
            key[i] = Integer.parseInt(st.nextToken());
            while (st.hasMoreTokens())
                set.add(Integer.parseInt(st.nextToken()));
            like.put(key[i], set);
        }

        seat[1][1] = key[0];
        int likeR, likeC, blackMax, blackCnt, likeMax, likeCnt, tmpR, tmpC;
        for (int i = 1; i < tot; i++) {
            set = like.get(key[i]);
            blackMax = 0;
            likeMax = 0;
            likeR = 0;
            likeC = 0;
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    blackCnt = 0;
                    likeCnt = 0;
                    if (seat[j][k] == 0) {
                        for (int l = 0; l < 4; l++) {
                            tmpR = j + ud[l];
                            tmpC = k + rl[l];
                            if (tmpR >= 0 && tmpR < N && tmpC >= 0 && tmpC < N) {
                                if (set.contains(seat[tmpR][tmpC]))
                                    likeCnt++;
                                if (seat[tmpR][tmpC] == 0)
                                    blackCnt++;
                            }
                        }
                        if (likeMax < likeCnt) {
                            likeMax = likeCnt;
                            blackMax = blackCnt;
                            likeR = j;
                            likeC = k;
                        }
                        if (likeMax == likeCnt && blackMax < blackCnt) {
                            blackMax = blackCnt;
                            likeR = j;
                            likeC = k;
                        }
                    }
                }
            }
            seat[likeR][likeC] = key[i];
        }

        int result = 0;
        int cnt;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                set = like.get(seat[i][j]);
                cnt = 0;
                for (int k = 0; k < 4; k++) {
                    tmpR = i + ud[k];
                    tmpC = j + rl[k];
                    if (tmpR >= 0 && tmpR < N && tmpC >= 0 && tmpC < N && set.contains(seat[tmpR][tmpC]))
                        cnt++;
                }
                if (cnt == 0) result += 0;
                if (cnt == 1) result += 1;
                if (cnt == 2) result += 10;
                if (cnt == 3) result += 100;
                if (cnt == 4) result += 1000;
            }
        }
        System.out.println(result);
    }
}
