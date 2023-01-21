package samsungDX.no10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Tree<T> {
    class Node<T> {
        T data;
        Node left, right;

        Node(T data) {
            left = null;
            right = null;
            this.data = data;
        }
    }
    private Node<T>[] nodeArr;

    Tree(int num) {
        nodeArr = new Node[num + 1];
    }

    void insert(int V, T data) {
        if (V == 1)
            nodeArr[V] = new Node(data);
        else
            nodeArr[V].data = data;
    }

    void insert(int V, T data, int L, int R) {
        insert(V, data);
        nodeArr[L] = new Node(null);
        nodeArr[R] = new Node(null);
        nodeArr[V].left = nodeArr[L];
        nodeArr[V].right = nodeArr[R];
    }

    double inorder() {
        return inorder(nodeArr[1]);
    }

    double inorder(Node n) {
        if (n.left == null && n.right == null)
            return (double) n.data;
        else
            return visit(inorder(n.left), (String) n.data, inorder(n.right));
    }

    double visit(double n1, String op, double n2) {
        if (op.equals("+"))
            return n1 + n2;
        if (op.equals("-"))
            return n1 - n2;
        if (op.equals("*"))
            return n1 * n2;
        else
            return n1 / n2;
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
            Tree<Object> tree = new Tree<>(N);
            while (0 < N--) {
                st = new StringTokenizer(br.readLine());
                if (st.countTokens() == 4)
                    tree.insert(Integer.parseInt(st.nextToken()), st.nextToken(), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
                else
                    tree.insert(Integer.parseInt(st.nextToken()), Double.parseDouble(st.nextToken()));
            }
            sb.append("#" + i + " " + (int) tree.inorder() + "\n");
        }
        System.out.print(sb.toString());
    }
}