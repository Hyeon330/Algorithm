package sudoku;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Node {
    int num, GID;

    Node(int num) {
        this.num = num;
        GID = 0;
    }
}

class Group {
    int nodeNum, nodeCnt, necNum, total;

    Group(int nodeNum, int necNum) {
        this.nodeNum = nodeNum;
        nodeCnt = 0;
        this.necNum = necNum;
        total = 0;
    }
}

public class Killer {
    static Node[][] board = new Node[9][9];
    static Group[] group;

    static void putBoard() {
        for (int i = 0; i < 9; i++) {
            if (i != 0 && i % 3 == 0)
                System.out.println();
            for (int j = 0; j < 9; j++) {
                if (j != 0 && j % 3 == 0)
                    System.out.print(" ");
                System.out.print(board[i][j].num + " ");
            }
            System.out.println();
        }
    }

    static boolean chk(int r, int c, int num) {
        Group g = group[board[r][c].GID];
        int boxY = r / 3;
        int boxX = c / 3;
        int i = 0;

        if (g.total > g.necNum)
            return false;
        if (g.total < g.necNum && g.nodeNum == g.nodeCnt)
            return false;
        if (g.total == g.necNum && g.nodeNum < g.nodeCnt)
            return false;
        for (int j = boxY * 3; j < (boxY + 1) * 3; j++) {
            for (int k = boxX * 3; k < (boxX + 1) * 3; k++) {
                if (board[j][k].num == num)
                    return false;
                if (board[i][c].num == num)
                    return false;
                if (board[r][i].num == num)
                    return false;
                i++;
            }
        }
        return true;
    }

    private static void setNum(int r, int c, int i) {
        Group g = group[board[r][c].GID];
        board[r][c].num = i;
        g.total += i;
        g.nodeCnt++;
    }

    private static void delNum(int r, int c, int i) {
        Group g = group[board[r][c].GID];
        board[r][c].num = 0;
        g.total -= i;
        g.nodeCnt--;
    }

    static boolean func(int r, int c) {
        if (c == 9) {
            r++;
            if (r == 9) {
                putBoard();
                return true;
            }
            c = 0;
        }

        if (board[r][c].num > 0)
            return func(r, c + 1);
        else {
            for (int i = 1; i <= 9; i++) {
                if (chk(r, c, i)) {
                    setNum(r, c, i);
                    if (func(r, c + 1))
                        return true;
                    delNum(r, c, i);
                }
            }
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N, r, c, necNum;

        for (int i = 0; i < 9; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++)
                board[i][j] = new Node(Integer.parseInt(st.nextToken()));
        }
        N = Integer.parseInt(br.readLine());
        group = new Group[N];
        for (int g = 0; g < N; g++) {
            st = new StringTokenizer(br.readLine());
            necNum = Integer.parseInt(st.nextToken());
            group[g] = new Group(st.countTokens() / 2, necNum);
            if (st.countTokens() == 2){
                r = Integer.parseInt(st.nextToken());
                c = Integer.parseInt(st.nextToken());
                board[r][c].num = necNum;
            } else {
                while (st.hasMoreTokens()) {
                    r = Integer.parseInt(st.nextToken());
                    c = Integer.parseInt(st.nextToken());
                    board[r][c].GID = g;
                }
            }
        }
        func(0, 0);
    }
}
