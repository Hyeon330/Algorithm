package graphSearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class OutCheese {
    int x;
    int y;

    OutCheese(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Ex2636 {
    static int[] udArr = {-1, 1, 0, 0};
    static int[] lrArr = {0, 0, -1, 1};
    static int maxX;
    static int maxY;
    static int cheeseNum;

    static void getArr(int[][] arr) {
        for (int[] i : arr) {
            for (int j : i)
                System.out.print(j + " ");
            System.out.println();
        }
    }

    static boolean isOuter(int[][] arr, int x, int y) {
        int ud;
        int lr;

        for (int i = 0; i < 4; i++) {
            ud = y + udArr[i];
            lr = x + lrArr[i];
            if (!(ud < 0 || lr < 0 || ud >= maxY || lr >= maxX) && arr[ud][lr] == 0)
                return true;
        }
        return false;
    }

    static Queue<OutCheese> getQueue(int[][] arr) {
        Queue<OutCheese> queue = new LinkedList<>();

        for (int i = 0; i < maxY; i++) {
            for (int j = 0; j < maxX; j++) {
                if (arr[i][j] == 1 && isOuter(arr, j, i)) {
                    queue.add(new OutCheese(j, i));
                }
            }
        }
        return queue;
    }

    static void melting(Queue<OutCheese> queue, int[][] arr) {
        OutCheese c;

        while (!queue.isEmpty()) {
            c = queue.poll();
            arr[c.y][c.x] = 0;
            cheeseNum++;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        Queue<OutCheese> queue = new LinkedList<>();
        maxY = Integer.parseInt(st.nextToken());
        maxX = Integer.parseInt(st.nextToken());
        int[][] arr = new int[maxY][maxX];
        for (int i = 0; i < maxY; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < maxX; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int hour = 0;
        queue = getQueue(arr);
        while (!queue.isEmpty()) {
            cheeseNum = 0;
            melting(queue, arr);
            hour++;
            queue = getQueue(arr);
        }
        System.out.println(hour + "\n" + cheeseNum);
    }
}
