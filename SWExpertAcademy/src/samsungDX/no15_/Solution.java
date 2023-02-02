package samsungDX.no15_;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Node{
    int num, deep;
    Node v;
    List<Node> adjacent = new ArrayList<>();

    Node(int num, Node v, int deep) {
        this.num = num;
        this.deep = deep;
        this.v = v;
    }
}

public class Solution {
    static Node[] nodes;
    static Map<Long, Node> dpMap;

    static void add(int num, int p) {
        nodes[num] = new Node(num, nodes[p], nodes[p].deep + 1);
        nodes[p].adjacent.add(nodes[num]);
    }

    static Node lca(Node a, Node b) {
        long key;
        if (a.deep < b.deep)
            b = b.v;

        if (a == b) return a;

        key = (long)a.num * 100000 + (long)b.num;
        if (dpMap.containsKey(key))
            return dpMap.get(key);

        a = a.v;
        b = b.v;
        Node result = lca(a, b);

        dpMap.put(key, result);

        return result;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        StringTokenizer st;
        Queue<Node> queue;
        Node n1, n2, sameV;
        int T, N, ret;

        T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
            nodes = new Node[N + 1];
            nodes[1] = new Node(1, null, 0);
            st = new StringTokenizer(br.readLine());
            for (int i = 2; i < N + 1; i++)
                add(i, Integer.parseInt(st.nextToken()));
            ret = 0;
            dpMap = new HashMap<>();
            queue = new LinkedList<>();
            queue.offer(nodes[1]);
            while (!queue.isEmpty()) {
                n1 = queue.poll();
                for (Node n : n1.adjacent)
                    queue.offer(n);
                n2 = queue.peek();
                if (n2 != null) {
                    sameV = lca(n1, n2);
                    ret += n1.deep - sameV.deep;
                    ret += n2.deep - sameV.deep;
                }
            }

            sb.append("#" + t + " " + ret + "\n");
        }
        System.out.print(sb);
    }
}
