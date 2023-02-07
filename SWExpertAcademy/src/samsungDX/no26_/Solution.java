package samsungDX.no26_;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 되는 로직, 이해가 안됨...
class Node{
    int cnt;
    int left;

    Node(int cnt, int left) {
        this.cnt = cnt;
        this.left = left;
    }
}

public class Solution {
    static int N, K, Ans;
    static int[] A = new int[11];

    static void GetAnc() {
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> {
            if (o1.cnt < o2.cnt) return -1;
            return 1;
        });

        pq.add(new Node(0, K));
        while (pq.peek().left != 0) {
            Node cur = pq.poll();

            pq.add(new Node(cur.cnt + cur.left, 0));
            for (int i = 0; i < N; i++)
                pq.add(new Node(cur.cnt + cur.left % A[i], cur.left / A[i]));
        }
        Ans = pq.peek().cnt;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        StringTokenizer st;
        int T;

        T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            for (int i = 0; st.hasMoreTokens(); i++)
                A[i] = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(br.readLine());
            Ans = 0;
            GetAnc();

            sb.append("#" + tc + " " + Ans + "\n");
        }
        System.out.print(sb);
    }
}
