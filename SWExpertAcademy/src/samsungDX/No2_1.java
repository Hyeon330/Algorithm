package samsungDX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No2_1 {
    static int[] caseArr = new int[4];
    static int[] xy = new int[2];
    static StringBuffer caseResult;

    static void chgLastY() {
        caseResult.setCharAt(caseResult.toString().lastIndexOf(xy[1] + '0'), (char)(xy[0] + '0'));
    }

    static int func(int subNum) {
        for (int i = 0; i < 4; i++) {
            if (subNum >= caseArr[i]) {
                caseResult.append(caseArr[i]);
                if (subNum == caseArr[i])
                    return 1;
                return 0;
            }
        }
        if (xy[0] == xy[1])
            return -1;
        if (caseResult.length() == 0)
            caseResult.append(xy[1]);
        else {
            chgLastY();
            caseResult.append(caseArr[0]);
        }
        return 0;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer    sb = new StringBuffer();
        StringTokenizer st;
        String          N;
        int             c, ck, lenN, idxN, lstN;

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            caseResult = new StringBuffer();
            st = new StringTokenizer(br.readLine());
            N = st.nextToken();
            xy[0] = Integer.parseInt(st.nextToken());
            xy[1] = Integer.parseInt(st.nextToken());

            if (xy[0] == 0 && N.charAt(0) < xy[1] + '0'){
                sb.append("#" + t + " " + -1 + "\n");
                continue;
            }

            c = 0;
            for (int i = 1; i >= 0; i--) {
                for (int j = 1; j >= 0; j--)
                    caseArr[c++] = xy[i] * 10 + xy[j];
            }

            ck = 1;
            lenN = N.length();
            idxN = 0;
            while (idxN < lenN - 2) {
                ck = func(Integer.parseInt(N.substring(idxN, idxN + 2)));
                idxN += 2;
                if (ck <= 0) {
                    if (ck == -1)
                        sb.append("#" + t + " " + ck + "\n");
                    break ;
                }
            }
            if (ck < 0)
                continue ;
            if (ck == 0) {
                while (idxN++ < lenN)
                    caseResult.append(xy[1]);
            }
            if (lenN - idxN == 2)
                func(Integer.parseInt(N.substring(idxN, idxN + 2)));
            if (lenN - idxN == 1) {
                lstN = Integer.parseInt(N.substring(lenN - 1, lenN));
                if (lstN >= xy[1])
                    caseResult.append(xy[1]);
                if (lstN >= xy[0])
                    caseResult.append(xy[0]);
                if (lstN < xy[0]) {
                    if (caseResult.length() == 0)
                        caseResult.append(-1);
                    else {
                        chgLastY();
                        caseResult.append(xy[1]);
                    }
                }
            }
            sb.append("#" + t + " " + caseResult + "\n");
        }
        System.out.print(sb.toString());
    }
}
