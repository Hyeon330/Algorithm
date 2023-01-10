package samsung_SW;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

class H {
    int r;
    int c;

    H(int r, int c) {
        this.r = r;
        this.c = c;
    }
}

public class Ex15686 {
    static int N, M;
    static List<H> oHL;
    static List<H> cHL;
    static int min = Integer.MAX_VALUE;

    static void func(List<H> searchH, int bi, int c) {
        if (c == M) {
            func(searchH);
        }
        for (int i = bi + 1; i < cHL.size(); i++) {
            searchH.add(cHL.get(i));
            func(searchH, i, c + 1);
            searchH.remove(c);
        }
    }

    static void func(List<H> searchH) {
        H oH;
        H cH;
        int cityLen = 0;
        int rLen, cLen, minLen;
        for (int i = 0; i < oHL.size(); i++) {
            oH = oHL.get(i);
            minLen = N + N;
            for (int j = 0; j < searchH.size(); j++) {
                cH = searchH.get(j);
                if ((rLen = oH.r - cH.r) < 0)
                    rLen *= -1;
                if ((cLen = oH.c - cH.c) < 0)
                    cLen *= -1;
                if (minLen > rLen + cLen)
                    minLen = rLen + cLen;
            }
            cityLen += minLen;
        }
        if (min > cityLen)
            min = cityLen;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        oHL = new ArrayList<>();
        cHL = new ArrayList<>();
        String ck;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                ck = st.nextToken();
                if (ck.equals("1"))
                    oHL.add(new H(i, j));
                if (ck.equals("2"))
                    cHL.add(new H(i, j));
            }
        }
        if (cHL.size() == M)
            func(cHL);
        else
            func(new LinkedList<>(), -1, 0);
        System.out.println(min);
    }
}
