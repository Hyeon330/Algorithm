package samsungDX.no11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Tree {
    class Node {
        Integer no;
        Node left, right;

        Node(int no) {
            this.no = no;
            left = null;
            right = null;
        }
    }

    ArrayList<Integer> ancLst = new ArrayList<>();
    ArrayList<Set<Integer>> ancSetLst = new ArrayList<>();
    Set<Integer> numSet;
    Node[] nodeArr;
    int sameAncNo, cntSubNode;

    Tree(int num, Integer[] numLst) {
        nodeArr = new Node[num + 1];
        numSet = new HashSet<>(Arrays.asList(numLst));
    }

    void insert(Integer anc, Integer des) {
        if (nodeArr[anc] == null)
            nodeArr[anc] = new Node(anc);
        if (nodeArr[des] == null)
            nodeArr[des] = new Node(des);
        if (nodeArr[anc].left == null)
            nodeArr[anc].left = nodeArr[des];
        else
            nodeArr[anc].right = nodeArr[des];
    }

    void postOrder() {
        postOrder(nodeArr[1]);
    }

    void postOrder(Node v) {
        if (v != null) {
            ancLst.add(v.no);
            postOrder(v.left);
            postOrder(v.right);
            visit(v);
            ancLst.remove((Integer) v.no);
        }
    }

    void visit(Node v) {
        int ancSetLstSize, prev;

        if (numSet.contains(v.no)) {
            ancSetLst.add(new HashSet<>(ancLst));
            if (numSet.size() == ancSetLst.size()) {
                ancSetLstSize = ancSetLst.size();
                for (int i = 0; i < ancSetLstSize - 1; i++) {
                    prev = 0;
                    for (Integer n : ancLst) {
                        if (!ancSetLst.get(i).contains(n)) {
                            sameAncNo = prev;
                            break;
                        }
                        prev = n;
                    }
                }
                cntSubTree(nodeArr[sameAncNo]);
            }
        }
    }

    void cntSubTree(Node v) {
        if (v != null) {
            cntSubNode++;
            cntSubTree(v.left);
            cntSubTree(v.right);
        }
    }
}
public class Solution {
    static BufferedReader br;
    static StringBuffer sb;
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuffer();
        int T, V, E;
        Integer[] S;

        T = Integer.parseInt(br.readLine());
        for (int i = 1; i <= T; i++) {
            st = new StringTokenizer(br.readLine());
            V = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());
            S = new Integer[st.countTokens()];
            for (int j = 0; st.hasMoreTokens(); j++)
                S[j] = Integer.parseInt(st.nextToken());
            Tree tree = new Tree(V, S);

            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < E; j++)
                tree.insert(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

            tree.postOrder();
            sb.append("#" + i + " " + tree.sameAncNo + " " + tree.cntSubNode + "\n");
        }
        System.out.println(sb.toString());
    }
}
