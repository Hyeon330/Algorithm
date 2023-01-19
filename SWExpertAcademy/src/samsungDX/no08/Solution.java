package samsungDX.no08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Tree<T> {
    class Node<T> {
        T data;
        Node left, right;

        Node(T data) {
            this.data = data;
            left = null;
            right = null;
        }
    }
    private Node root;
    private Node[] nodeArr;
    private StringBuffer sb;

    Tree(int num) {
        nodeArr = new Node[num + 1];
        root = null;
    }

    void add(int num, T data) {
        Node newNode = new Node(data);
        if (num == 1)
            root = newNode;
        else {
            if (num % 2 == 0)
                nodeArr[num / 2].left = newNode;
            else
                nodeArr[num / 2].right = newNode;
        }
        nodeArr[num] = newNode;
    }

    String inorder() {
        sb = new StringBuffer();
        inorder(root);
        return sb.toString();
    }
    void inorder(Node n) {
        if (n != null) {
            inorder(n.left);
            visit(n);
            inorder(n.right);
        }
    }

    void visit(Node n) {
        sb.append(n.data);
    }
}
public class Solution {
    static BufferedReader br;
    static StringTokenizer st;
    static StringBuffer sb;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuffer();
        int T, N;

        T = 10;
        for (int i = 1; i <= T; i++) {
            N = Integer.parseInt(br.readLine());
            Tree<String> tree = new Tree<>(N);
            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());
                tree.add(Integer.parseInt(st.nextToken()), st.nextToken());
                while (st.hasMoreTokens()) st.nextToken();
            }
            sb.append("#" + i + " " + tree.inorder() + "\n");
        }
        System.out.print(sb.toString());
    }
}
