package samsungDX.no23.s1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sbCase, sb = new StringBuffer();
        StringTokenizer st;
        PriorityQueue<Integer> priorityQueue;
        int T, N;

        T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            sbCase = new StringBuffer();
            priorityQueue = new PriorityQueue<>(Collections.reverseOrder());
            N = Integer.parseInt(br.readLine());
            while (N-- > 0) {
                st = new StringTokenizer(br.readLine());
                if (st.nextToken().equals("1"))
                    priorityQueue.add(Integer.parseInt(st.nextToken()));
                else {
                    Integer ret = priorityQueue.poll();
                    if (ret == null)
                        sbCase.append(" " + -1);
                    else
                        sbCase.append(" " + ret);
                }
            }

            sb.append("#" + tc + sbCase + "\n");
        }
        System.out.print(sb);
    }
}
