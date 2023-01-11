package samsung_SW;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Node {
    int r, c, data;
    boolean marked;

    Node(int r, int c, int data) {
        this.r = r;
        this.c = c;
        this.data = data;
        marked = false;
    }
}

public class Ex16234 {
    static int[] ud = {-1, 0, 1, 0};
    static int[] lr = {0, 1, 0, -1};
    static int N, L, R;
    static Node[][] map;

    static void fill(Node[][] map) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++)
                map[i][j].marked = false;
        }
    }

    static int func(int r, int c, Queue<Node> conn) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(map[r][c]);
        conn.offer(map[r][c]);
        map[r][c].marked = true;
        Node n;
        int tmpR, tmpC, cnt, dataGap;
        int result = map[r][c].data;
        cnt = 0;
        while (!queue.isEmpty()) {
            n = queue.poll();
            for (int i = 0; i < 4; i++) {
                tmpR = n.r + ud[i];
                tmpC = n.c + lr[i];
                dataGap = 0;
                if (tmpR >= 0 && tmpR < N && tmpC >= 0 && tmpC < N && !map[tmpR][tmpC].marked)
                    dataGap = map[n.r][n.c].data - map[tmpR][tmpC].data;
                if (dataGap < 0)
                    dataGap *= -1;
                if (dataGap >= L && dataGap <= R) {
                    queue.offer(map[tmpR][tmpC]);
                    conn.offer(map[tmpR][tmpC]);
                    result += map[tmpR][tmpC].data;
                    map[tmpR][tmpC].marked = true;
                    cnt++;
                }
            }
        }
        if (conn.size() > 1) {
            cnt++;
            while (!conn.isEmpty())
                conn.poll().data = result / cnt;
        }
        return cnt;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        map = new Node[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++)
                map[i][j] = new Node(i, j, Integer.parseInt(st.nextToken()));
        }

        int ck = 1;
        int day = 0;
        while (ck > 0) {
            ck = 0;
            fill(map);
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!map[i][j].marked) {
                        ck += func(i, j, new LinkedList<>());
                    }
                }
            }
            if (ck > 0)
                day++;
        }

        System.out.println(day);
    }
}
