package silver.four;

import java.io.*;

/*
문제
한수

어떤 양의 정수 X의 각 자리가 등차수열을 이룬다면, 그 수를 한수라고 한다. 등차수열은 연속된 두 개의 수의 차이가 일정한 수열을 말한다. 
N이 주어졌을 때, 1보다 크거나 같고, N보다 작거나 같은 한수의 개수를 출력하는 프로그램을 작성하시오.

입력
첫째 줄에 1,000보다 작거나 같은 자연수 N이 주어진다.

출력
첫째 줄에 1보다 크거나 같고, N보다 작거나 같은 한수의 개수를 출력한다.

110 -> 99
1 -> 1
210 -> 105
    1~99
    111
    123
    135
    147
    159
    210
1000 -> 144
500 -> 119
*/

public class Exam1065 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        int count = 0;

        for (int i = 1; i <= num; i++) {
            int seq = seq(i);
            int su = i;
            while (true) {
                su /= 10;
                if (su < 10) {
                    count++;
                    break;
                }
                if (seq != seq(su)) {
                    break;
                }
            }
        }
        System.out.println(count);
    }

    static int seq(int i) {
        int tmp1 = i % 10;
        int tmp2 = (i / 10) % 10;

        return tmp1 - tmp2;
    }
}
