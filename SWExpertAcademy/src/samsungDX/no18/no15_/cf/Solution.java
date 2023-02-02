package samsungDX.no18.no15_.cf;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Node{
    int parent, dep;
    List<Integer> children = new ArrayList<>();

    public Node(){
        parent = 0;
        dep = 0;
    }

    public Node(List<Node> nodes, int parent){
        this.parent = parent;
        this.dep = nodes.get(parent).dep + 1;
    }
}

public class Solution{
    static Map<Long, Integer> cache;

    public static int findLCA(List<Node> nodes, int a, int b){
        if (a == b) return a;

        int depA = nodes.get(a).dep;
        int depB = nodes.get(b).dep;

        if (depA > depB){
            int c = a;
            a = b;
            b = c;
            c = depA;
            depA = depB;
            depB = c;
        }

        while (depA < depB){
            b = nodes.get(b).parent;    // b = 1
            depB--;                     // depB = 0
        }

        return findLCA2(nodes, a, b);
    }

    public static int findLCA2(List<Node> nodes, int a, int b){
        if (a == b) return a;

        long key = (long)a * 100000 + (long)b;
        if (cache.containsKey(key)){
            return cache.get(key);
        }
        int result = findLCA2(nodes, nodes.get(a).parent, nodes.get(b).parent);

        cache.put(key, result);

        return result;
    }

    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        StringTokenizer st;
        Queue<Integer> queue;
        int T, N;

        T = Integer.parseInt(br.readLine());
        for(int tc = 1; tc <= T; ++tc){
            N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            List<Node> nodes = new ArrayList<>();
            cache = new HashMap<>();

            nodes.add(new Node());

            for (int i = 1; i < N; i++){
                int p = Integer.parseInt(st.nextToken()) - 1;
                nodes.add(new Node(nodes, p));
                nodes.get(p).children.add(i);
            }

            queue = new LinkedList<>();
            queue.offer(0);
            int to = 0;
            long cnt = 0;

            while (!queue.isEmpty()){
                int id = queue.poll();
                int lca = findLCA(nodes, id, to);

                cnt += nodes.get(to).dep - nodes.get(lca).dep;
                cnt += nodes.get(id).dep - nodes.get(lca).dep;

                to = id;
                for (int i : nodes.get(id).children)
                    queue.add(i);
            }

            sb.append("#" + tc + " " + cnt + "\n");
        }
        System.out.print(sb);
    }
}
