package graphSearch;

import java.io.*;
import java.util.*;

class Node {
    int row;
    int col;

    Node (int row, int col) {
        this.row = row;
        this.col = col;
    }
}

public class Ex7576 {
    static boolean isTomato(int[][] arr) {
        for (int[] i : arr) {
            for (int j : i) {
                if (j == 0)
                    return false;
            }
        }
        return true;
    }

    static int bfs(int[][] arr, Queue<Node> queue, int row, int col) {
        int tomato;
        int day = 0;

        while (!queue.isEmpty()) {
            tomato = queue.size();
            for (int i = 0; i < tomato; i++){
                Node n = queue.poll();
                if (n.row > 0 && arr[n.row - 1][n.col] == 0) {
                    arr[n.row - 1][n.col] = 1;
                    queue.add(new Node(n.row - 1, n.col));
                }
                if (n.col < col - 1 && arr[n.row][n.col + 1] == 0) {
                    arr[n.row][n.col + 1] = 1;
                    queue.add(new Node(n.row, n.col + 1));
                }
                if (n.row < row - 1 && arr[n.row + 1][n.col] == 0) {
                    arr[n.row + 1][n.col] = 1;
                    queue.add(new Node(n.row + 1, n.col));
                }
                if (n.col > 0 && arr[n.row][n.col - 1] == 0) {
                    arr[n.row][n.col - 1] = 1;
                    queue.add(new Node(n.row, n.col - 1));
                }
            }
            day++;
        }
        return day - 1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        Queue<Node> queue = new LinkedList<Node>();

        StringTokenizer st = new StringTokenizer(bf.readLine());
        int col = Integer.parseInt(st.nextToken());
        int row = Integer.parseInt(st.nextToken());
        int[][] arr = new int[row][col];
        for (int i = 0; i < row; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < col; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] == 1)
                    queue.add(new Node(i, j));
            }
        }
        int result = bfs(arr, queue, row, col);
        System.out.println(isTomato(arr) ? result : -1);
    }
}
