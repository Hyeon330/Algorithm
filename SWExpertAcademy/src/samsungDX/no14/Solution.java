package samsungDX.no14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

class Node {
    int r, c;

    Node(int r, int c) {
        this.r = r;
        this.c = c;
    }
}

public class Solution {
    static int[] ud = {-1, 0, 1, 0, -1, 1, 1, -1};
    static int[] lr = {0, 1, 0, -1, 1, 1, -1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        Queue<Node> q1, q2;
        Node n;
        String[] s;
        int[][] chk;
        int T, N, tmpR, tmpC, retC;

        T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            q1 = new LinkedList<>();
            q2 = new LinkedList<>();
            N = Integer.parseInt(br.readLine());
            retC = 0;
            s = new String[N];
            chk = new int[N][N];
            for (int r = 0; r < N; r++)
                s[r] = br.readLine();
            for (int r = 0; r < N; r++) {
                for (int c = 0; c < N; c++) {
                    if (s[r].charAt(c) == '*') {
                        chk[r][c] = -1;
                        continue;
                    }
                    for (int i = 0; i < 8; i++) {
                        tmpR = r + ud[i];
                        tmpC = c + lr[i];
                        if (tmpR >= 0 && tmpR < N && tmpC >= 0 && tmpC < N && s[tmpR].charAt(tmpC) == '*') {
                            chk[r][c] = 1;
                            break;
                        }
                        if (i == 8 - 1)
                            q1.offer(new Node(r, c));
                    }
                    retC++;
                }
            }
            while (!q1.isEmpty()) {
                n = q1.poll();
                q2.offer(n);
                if (chk[n.r][n.c] == -1) continue;
                chk[n.r][n.c] = -1;
                retC--;
                while (!q2.isEmpty()) {
                    n = q2.poll();
                    for (int i = 0; i < 8; i++) {
                        tmpR = n.r + ud[i];
                        tmpC = n.c + lr[i];
                        if (tmpR >= 0 && tmpR < N && tmpC >= 0 && tmpC < N && chk[tmpR][tmpC] != -1) {
                            if (chk[tmpR][tmpC] == 0)
                                q2.offer(new Node(tmpR, tmpC));
                            chk[tmpR][tmpC] = -1;
                            retC--;
                        }
                    }
                }
                retC++;
            }
            sb.append("#" + t + " " + retC + "\n");
        }
        System.out.print(sb);
    }
}