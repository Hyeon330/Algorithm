package samsungDX.no15_.s1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Node{
    int num, deep;
    Node v;
    LinkedList<Node> adjacent;

    Node(int num, Node v, int deep) {
        this.num = num;
        this.deep = deep;
        this.v = v;
        adjacent = new LinkedList<>();
    }
}

class Graph {
    Node[] nodes;

    Graph(int N) {
        nodes = new Node[N + 1];
        nodes[1] = new Node(1, null, 0);
    }

    void add(int num, int p) {
        nodes[num] = new Node(num, nodes[p], nodes[p].deep + 1);
        nodes[p].adjacent.add(nodes[num]);
    }

    int lca(Node a, Node b) {
        int cnt = 0;

        while (a.deep != b.deep) {
            if (a.deep > b.deep)
                a = a.v;
            else
                b = b.v;
            cnt++;
        }
        while (a.num != b.num) {
            a = a.v;
            b = b.v;
            cnt += 2;
        }
        return cnt;
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        StringTokenizer st;
        Queue<Node> queue;
        Graph g;
        Node n1, n2;
        int T, N, ret;

        T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
            ret = 0;
            g = new Graph(N);
            queue = new LinkedList<>();
            queue.offer(g.nodes[1]);
            st = new StringTokenizer(br.readLine());
            for (int i = 2; i < N + 1; i++)
                g.add(i, Integer.parseInt(st.nextToken()));
            while (!queue.isEmpty()) {
                n1 = queue.poll();
                for (Node n : n1.adjacent)
                    queue.offer(n);
                n2 = queue.peek();
                if (n2 != null)
                    ret += g.lca(n1, n2);
            }
            sb.append("#" + t + " " + ret + "\n");
        }
        System.out.print(sb);
    }
}
