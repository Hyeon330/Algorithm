package samsungDX.no05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class No05 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        StringTokenizer st;
        List<Integer> lst;
        String cmd;
        int T, N, M, L;

        T = Integer.parseInt(br.readLine());
        for (int i = 1; i <= T; i++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            L = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            lst = new ArrayList<>(N);
            while (st.hasMoreTokens())
                lst.add(Integer.parseInt(st.nextToken()));
            for (int j = 0; j < M; j++) {
                st = new StringTokenizer(br.readLine());
                cmd = st.nextToken();
                if (cmd.equals("I"))
                    lst.add(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
                if (cmd.equals("D"))
                    lst.remove(Integer.parseInt(st.nextToken()));
                if (cmd.equals("C"))
                    lst.set(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            }
            if (lst.size() > L)
                sb.append("#" + i + " " + lst.get(L) + "\n");
            else
                sb.append("#" + i + " " + -1 + "\n");
        }
        System.out.print(sb);
    }
}
