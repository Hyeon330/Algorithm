package samsungDX.no13_;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Node{
    int x, y;

    Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Solution {
    static int[] ud = {-1, 0, 1, 0};
    static int[] lr = {0, 1, 0, -1};
    static boolean[][] mexy;
    static int N, maxC, minL;
    static Queue<Node> queue;

    static void func(int line, int core) {
        if (queue.isEmpty()) {
            if (maxC < core) {
                maxC = core;
                minL = line;
            }
            if (maxC == core && minL > line)
                minL = line;
            return;
        }
        Node n = queue.poll();
        int tmpX, tmpY, tmpL;
        for (int i = 0; i < 4; i++) {
            tmpX = n.x;
            tmpY = n.y;
            tmpL = 0;
            while (tmpX >= 1 && tmpX < N - 1 &&
                    tmpY >= 1 && tmpY < N - 1 &&
                    !mexy[tmpY + ud[i]][tmpX + lr[i]]) {
                tmpX += lr[i];
                tmpY += ud[i];
                mexy[tmpY][tmpX] = true;
                tmpL++;
            }
            if (tmpX == 0 || tmpX == N - 1 || tmpY == 0 || tmpY == N - 1) {
                func(line + tmpL, core + 1);
            } else {
                while (tmpL-- > 0) {
                    mexy[tmpY][tmpX] = false;
                    tmpX -= lr[i];
                    tmpY -= ud[i];
                }
                func(line, core);
            }
            while (tmpL-- > 0) {
                mexy[tmpY][tmpX] = false;
                tmpX -= lr[i];
                tmpY -= ud[i];
            }
        }
        queue.offer(n);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        StringTokenizer st;
        int T;

        T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            maxC = 0;
            minL = 144;
            queue = new LinkedList<>();
            N = Integer.parseInt(br.readLine());
            mexy = new boolean[N][N];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    if (st.nextToken().equals("1")) {
                        mexy[i][j] = true;
                        if (i != 0 && i != N - 1 && j != 0 && j != N - 1)
                            queue.offer(new Node(j, i));
                    } else
                        mexy[i][j] = false;
                }
            }
            func(0, 0);
            sb.append("#" + t + " " + minL + "\n");
        }
        System.out.print(sb);
    }
}
