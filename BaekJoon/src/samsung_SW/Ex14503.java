package samsung_SW;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class R {
    int[] ud = {-1, 0, 1, 0};
    int[] lr = {0, 1, 0, -1};
    int[][] map;
    int r;
    int c;
    int front;

    R(int r, int c, int front, int[][] map) {
        this.r = r;
        this.c = c;
        this.front = front;
        this.map = map;
        this.map[r][c] = 1;
    }

    void turn() {
        front--;
        if (front < 0)
            front = 3;
    }

    boolean isMove() {
        int tmpR = 0;
        int tmpC = 0;
        for (int i = 0; i < 4; i++) {
            if (i == front) {
                tmpR = r + ud[i];
                tmpC = c + lr[i];
                break ;
            }
        }
        if (map[tmpR][tmpC] == 0)
            return true;
        return false;
    }

    void move() {
        for (int i = 0; i < 4; i++) {
            if (i == front) {
                r += ud[i];
                c += lr[i];
                break ;
            }
        }
        map[r][c] = 1;
    }

    boolean back() {
        for (int i = 0; i < 4; i++) {
            if (i == front) {
                r -= ud[i];
                c -= lr[i];
                break ;
            }
        }
        if (map[r][c] < 0)
            return true;
        return false;
    }
}

public class Ex14503 {
    static int N;
    static int M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int[][] map = new int[N][M];

        st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                if (Integer.parseInt(st.nextToken()) == 0)
                    map[i][j] = 0;
                else
                    map[i][j] = -1;
            }
        }
        R robot = new R(r, c, d, map);
        int cnt = 1;
        while (true) {
            robot.turn();
            int i = -1;
            while (++i < 4) {
                if (robot.isMove()) {
                    robot.move();
                    cnt++;
                    break ;
                } else if (i < 3)
                    robot.turn();
            }
            if (i == 4) {
                if (robot.back())
                    break;
            }
        }
        System.out.println(cnt);
    }
}
