package samsungDX.pre_test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No2 {
    public static void main(String[] args) throws IOException {
        BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuffer    sb, oneCase;
        String          N;
        int T, x, y, num, lstY, nowLen;

        sb = new StringBuffer();
        T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            N = st.nextToken();
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());

            if (N.length() == 1 && x == 0 && N.charAt(0) - '0' < y){
                sb.append("#" + t + " " + -1 + "\n");
                continue;
            }

            oneCase = new StringBuffer();
            boolean[] ck = {false, false};
            for (char c : N.toCharArray()) {
                if (ck[0])
                    oneCase.append(y);
                else {
                    num = c - '0';
                    if (num >= y || ck[1]) {
                        if (num > y || ck[1]) {
                            ck[0] = true;
                            ck[1] = false;
                        }
                        oneCase.append(y);
                    } else if (num >= x) {
                        if (num > x)
                            ck[0] = true;
                        oneCase.append(x);
                    } else {
                        if (oneCase.length() == 0)
                            ck[1] = true;
                        else {
                            lstY = oneCase.toString().lastIndexOf(y + '0');
                            if (lstY < 0)
                                oneCase.deleteCharAt(0);
                            if (lstY >= 0)
                                oneCase.setCharAt(lstY, (char)(x + '0'));
                            nowLen = oneCase.toString().length();
                            while (++lstY < nowLen)
                                oneCase.setCharAt(lstY, (char)(y + '0'));
                            oneCase.append(y);
                            ck[0] = true;
                        }
                    }
                }
            }
            if (ck[1])
                sb.append("#" + t + " " + -1 + "\n");
            else {
                if (oneCase.charAt(0) == '0')
                    oneCase.deleteCharAt(0);
                sb.append("#" + t + " " + oneCase.toString() + "\n");
            }
        }
        System.out.print(sb.toString());
    }
}