package graphSearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

class Pixel {
    int x;
    int y;
    char color;

    Pixel(int x, int y, char color) {
        this.x = x;
        this.y = y;
        this.color = color;
    }
    Pixel(int x, int y) {
        this.x = x;
        this.y = y;
        this.color = color;
    }
}

public class Ex10026 {
    static void dfs(int[][] flag, String[] img, Stack<Pixel> stack, int N, int flagN) {
        Pixel p;

        while (!stack.isEmpty()) {
            p = stack.pop();
            if (p.y < N - 1 && img[p.y + 1].charAt(p.x) == p.color && flag[p.y + 1][p.x] == flagN) {
                stack.push(new Pixel(p.x, p.y + 1, p.color));
                flag[p.y + 1][p.x] = flagN + 1;
            }
            if (p.y > 0 && img[p.y - 1].charAt(p.x) == p.color && flag[p.y - 1][p.x] == flagN) {
                stack.push(new Pixel(p.x, p.y - 1, p.color));
                flag[p.y - 1][p.x] = flagN + 1;
            }
            if (p.x < N - 1 && img[p.y].charAt(p.x + 1) == p.color && flag[p.y][p.x + 1] == flagN) {
                stack.push(new Pixel(p.x + 1, p.y, p.color));
                flag[p.y][p.x + 1] = flagN + 1;
            }
            if (p.x > 0 && img[p.y].charAt(p.x - 1) == p.color && flag[p.y][p.x - 1] == flagN) {
                stack.push(new Pixel(p.x - 1, p.y, p.color));
                flag[p.y][p.x - 1] = flagN + 1;
            }
        }
    }

    static void dfsW(int[][] flag, String[] img, Stack<Pixel> stack, int N) {
        Pixel p;

        while (!stack.isEmpty()) {
            p = stack.pop();
            if (p.y < N - 1 && (img[p.y + 1].charAt(p.x) == 'R' || img[p.y + 1].charAt(p.x) == 'G') && flag[p.y + 1][p.x] == 0) {
                stack.push(new Pixel(p.x, p.y + 1));
                flag[p.y + 1][p.x] = 1;
            }
            if (p.y > 0 && (img[p.y - 1].charAt(p.x) == 'R' || img[p.y - 1].charAt(p.x) == 'G') && flag[p.y - 1][p.x] == 0) {
                stack.push(new Pixel(p.x, p.y - 1));
                flag[p.y - 1][p.x] = 1;
            }
            if (p.x < N - 1 && (img[p.y].charAt(p.x + 1) == 'R' || img[p.y].charAt(p.x + 1) == 'G') && flag[p.y][p.x + 1] == 0) {
                stack.push(new Pixel(p.x + 1, p.y));
                flag[p.y][p.x + 1] = 1;
            }
            if (p.x > 0 && (img[p.y].charAt(p.x - 1) == 'R' || img[p.y].charAt(p.x - 1) == 'G') && flag[p.y][p.x - 1] == 0) {
                stack.push(new Pixel(p.x - 1, p.y));
                flag[p.y][p.x - 1] = 1;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        Stack<Pixel> stack = new Stack<Pixel>();
        int color = 0;
        int colorW = 0;

        int N = Integer.parseInt(bf.readLine());
        String[] img = new String[N];
        int[][] flag = new int[N][N];
        for (int i = 0; i < N; i++) {
            img[i] = bf.readLine();
            Arrays.fill(flag[i], 0);
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (img[i].charAt(j) == 'B' && flag[i][j] == 0) {
                    stack.push(new Pixel(j, i, img[i].charAt(j)));
                    flag[i][j] = 1;
                    dfs(flag, img, stack, N, 0);
                    color++;
                    colorW++;
                }
                if ((img[i].charAt(j) == 'R' || img[i].charAt(j) == 'G') && flag[i][j] == 0) {
                    stack.push(new Pixel(j, i));
                    flag[i][j] = 1;
                    dfsW(flag, img, stack, N);
                    colorW++;
                }
                if (img[i].charAt(j) == 'R' && flag[i][j] == 1) {
                    stack.push(new Pixel(j, i, img[i].charAt(j)));
                    flag[i][j] = 2;
                    dfs(flag, img, stack, N, 1);
                    color++;
                }
                if (img[i].charAt(j) == 'G' && flag[i][j] == 1) {
                    stack.push(new Pixel(j, i, img[i].charAt(j)));
                    flag[i][j] = 2;
                    dfs(flag, img, stack, N, 1);
                    color++;
                }
            }
        }
        System.out.println(color + " " + colorW);
    }
}
