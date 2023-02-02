package samsungDX.no18.no15_;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Node{
    int parent, deep;
    List<Integer> adjacent = new ArrayList<>();

    Node() {
        parent = 0;
        deep = 0;
    }
    Node(List<Node> nodes, int parent) {
        this.parent = parent;
        this.deep = nodes.get(parent).deep + 1;
    }
}

public class Solution {
    static List<Node> nodes;
    static Map<Long, Integer> dpMap;

    static int lca(int a, int b) {
        long key;
        if (nodes.get(a).deep < nodes.get(b).deep)
            b = nodes.get(b).parent;
        if (a == b) return a;

        key = (long)a * 100000 + (long)b;
        if (dpMap.containsKey(key))
            return dpMap.get(key);

        int result = lca(nodes.get(a).parent, nodes.get(b).parent);

        dpMap.put(key, result);

        return result;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        StringTokenizer st;
        Queue<Integer> queue;
        Integer T, N, n1, n2, retLca;
        long ret;

        T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            nodes = new ArrayList<>();
            dpMap = new HashMap<>();

            nodes.add(new Node());
            for (int i = 1; i < N; i++) {
                int p = Integer.parseInt(st.nextToken()) - 1;
                nodes.add(new Node(nodes, p));
                nodes.get(p).adjacent.add(i);
            }

            ret = 0;
            queue = new LinkedList<>();
            queue.offer(0);
            while (!queue.isEmpty()) {
                n1 = queue.poll();
                for (int i : nodes.get(n1).adjacent) {
                    System.out.println(i);
                    queue.offer(i);
                }
                n2 = queue.peek();
                if (n2 != null) {
                    retLca = lca(n1, n2);
                    ret += (nodes.get(n1).deep - retLca);
                    ret += (nodes.get(n2).deep - retLca);
                }
            }

            sb.append("#" + t + " " + ret + "\n");
        }
        System.out.print(sb);
    }
}
