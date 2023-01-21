package samsungDX.no09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

class Tree_ {
    class Node {
        String data;
        Node left, right;

        Node(String data) {
            this.data = data;
            left = null;
            right = null;
        }
    }

    private Node[] nodeArr;
    private String[] ops = {"+", "-", "*", "/"};
    private HashSet<String> set = new HashSet<>(Arrays.asList(ops));

    Tree_(int num) {
        nodeArr = new Node[num + 1];
        for (int i = 1; i <= num; i++)
            nodeArr[i] = new Node(null);
    }

    void insert(int V, String data, int L, int R) {
        nodeArr[V].data = data;
        nodeArr[V].left = nodeArr[L];
        nodeArr[V].right = nodeArr[R];
    }

    void insert(int V, String data) {
        nodeArr[V].data = data;
    }

    boolean inorder() {
        return inorder(nodeArr[1]);
    }

    boolean inorder(Node n) {
        if (n != null) {
            if (!set.contains(n.data)) {
                if (n.left == null && n.right == null)
                    return true;
                else
                    return false;
            }
            return visit(inorder(n.left), n.data, inorder(n.right));
        }
        return false;
    }

    boolean visit(boolean n1, String op, boolean n2) {
        if (n1 && n2 && set.contains(op))
            return true;
        return false;
    }
}

public class Solution_ {
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
            Tree_ tree = new Tree_(N);
            while (0 < N--) {
                st = new StringTokenizer(br.readLine());
                if (st.countTokens() == 4)
                    tree.insert(Integer.parseInt(st.nextToken()), st.nextToken(), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
                else
                    tree.insert(Integer.parseInt(st.nextToken()), st.nextToken());
            }
            if (tree.inorder())
                sb.append("#" + i + " 1\n");
            else
                sb.append("#" + i + " 0\n");
        }
        System.out.print(sb.toString());
    }
}
