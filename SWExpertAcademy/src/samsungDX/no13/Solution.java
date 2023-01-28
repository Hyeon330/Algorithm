package samsungDX.no13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
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
    static int N, core, line, coreCnt;
    static Stack<Node> stack;

    static void func() {
        if (stack.isEmpty()) {
            return;
        }
        Node n = stack.pop();
        int tmpX, tmpY, tmpL;
        for (int i = 0; i < 4; i++) {
            tmpX = n.x + ud[i];
            tmpY = n.y + lr[i];
            tmpL = 0;
            while (tmpX >= 0 && tmpX < N && tmpY >= 0 && tmpY < N && !mexy[tmpY][tmpX]) {
                mexy[tmpY][tmpX] = true;
                tmpL++;
            }
            if (tmpX == 0 || tmpX == N - 1 || tmpY == 0 || tmpY == N - 1)
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        StringTokenizer st;
        int T;

        T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            core = line = coreCnt = 0;
            stack = new Stack<>();
            N = Integer.parseInt(br.readLine());
            mexy = new boolean[N][N];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    if (st.nextToken().equals("1")) {
                        mexy[i][j] = true;
                        if (i != 0 && i != N - 1 && j != 0 && j != N - 1)
                            stack.push(new Node(j, i));
                        coreCnt++;
                    } else
                        mexy[i][j] = false;
                }
            }

        }
    }
}
