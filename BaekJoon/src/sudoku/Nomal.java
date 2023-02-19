package sudoku;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Nomal {
    static int[][] board = new int[9][9];

    static boolean chk(int y, int x, int num) {
        int boxY = y / 3;
        int boxX = x / 3;
        int i = 0;

        for (int j = boxY * 3; j < (boxY + 1) * 3; j++) {
            for (int k = boxX * 3; k < (boxX + 1) * 3; k++) {
                if (board[j][k] == num)
                    return false;
                if (board[i][x] == num)
                    return false;
                if (board[y][i] == num)
                    return false;
                i++;
            }
        }
        return true;
    }

    static void putBoard() {
        for (int i = 0; i < 9; i++) {
            if (i != 0 && i % 3 == 0)
                System.out.println();
            for (int j = 0; j < 9; j++) {
                if (j != 0 && j % 3 == 0)
                    System.out.print(" ");
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    static boolean func(int y, int x) {
        if (x == 9) {
            y++;
            if (y == 9) {
                putBoard();
                return true;
            }
            x = 0;
        }

        if (board[y][x] > 0)
            return func(y, x + 1);
        else {
            for (int i = 1; i <= 9; i++) {
                if (chk(y, x, i)) {
                    board[y][x] = i;
                    if (func(y, x + 1))
                        return true;
                    board[y][x] = 0;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        for (int i = 0; i < 9; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++)
                board[i][j] = Integer.parseInt(st.nextToken());
        }
        func(0, 0);
    }
}
