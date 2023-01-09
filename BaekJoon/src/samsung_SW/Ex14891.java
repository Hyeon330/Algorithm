package samsung_SW;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Ex14891 {
    final static int WHEEL_NUM = 4;
    static Deque<Character>[] cogW;
    static boolean clock;

    static boolean[] isRotate(int wheelNo) {
        boolean[] ckRotate = new boolean[WHEEL_NUM];
        Arrays.fill(ckRotate, false);
        ckRotate[wheelNo] = true;
        List<Character> wheelLst = new ArrayList<>(cogW[wheelNo]);

        char right = wheelLst.get(2);
        char left = wheelLst.get(6);
        for (int i = wheelNo + 1; i < WHEEL_NUM; i++) {
            wheelLst = new ArrayList<>(cogW[i]);
            if (right == wheelLst.get(6))
                break ;
            ckRotate[i] = true;
            right = wheelLst.get(2);
        }
        for (int i = wheelNo - 1; i >=0 ; i--) {
            wheelLst = new ArrayList<>(cogW[i]);
            if (left == wheelLst.get(2))
                break ;
            ckRotate[i] = true;
            left = wheelLst.get(6);
        }
        return ckRotate;
    }

    static void oneRotate(Deque<Character> dq) {
        if (clock)
            dq.offerFirst(dq.pollLast());
        else
            dq.offerLast(dq.pollFirst());
    }

    static void cog(boolean[] ckRotate, int wheelNo) {
        for (int i = 0; i < WHEEL_NUM; i++) {
            if (ckRotate[wheelNo % WHEEL_NUM])
                oneRotate(cogW[wheelNo % WHEEL_NUM]);
            clock = !clock;
            wheelNo++;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        cogW = new Deque[WHEEL_NUM];
        String tmpCog;
        int result = 0;

        for (int i = 0; i < WHEEL_NUM; i++) {
            cogW[i] = new ArrayDeque<>();
            tmpCog = br.readLine();
            for (int j = 0; j < 8; j++)
                cogW[i].offer(tmpCog.charAt(j));
        }
        int K = Integer.parseInt(br.readLine());
        int wheelNo;
        String ckClock;
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            wheelNo = Integer.parseInt(st.nextToken()) - 1;
            ckClock = st.nextToken();
            clock = ckClock.equals("1");
            cog(isRotate(wheelNo), wheelNo);
        }

        if (cogW[0].peekFirst() == '1')
            result += 1;
        if (cogW[1].peekFirst() == '1')
            result += 2;
        if (cogW[2].peekFirst() == '1')
            result += 4;
        if (cogW[3].peekFirst() == '1')
            result += 8;

        System.out.println(result);
    }
}
