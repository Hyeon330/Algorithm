package bronze.three;

/*
문제 - 직각삼각형

과거 이집트인들은 각 변들의 길이가 3, 4, 5인 삼각형이 직각 삼각형인것을 알아냈다. 주어진 세변의 길이로 삼각형이 직각인지 아닌지 구분하시오.

입력
입력은 여러개의 테스트케이스로 주어지며 마지막줄에는 0 0 0이 입력된다. 각 테스트케이스는 모두 30,000보다 작은 양의 정수로 주어지며, 각 입력은 변의 길이를 의미한다.

출력
각 입력에 대해 직각 삼각형이 맞다면 "right", 아니라면 "wrong"을 출력한다.

예제 입력 1 
6 8 10
25 52 60
5 12 13
0 0 0

예제 출력 1
right
wrong
right

*/

import java.io.*;
import java.util.*;

public class Exam4153 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        ArrayList<StringTokenizer> starr = new ArrayList<>();

        while (true) {
            String s = bf.readLine();
            if (s.equals("0 0 0")) {
                break;
            }
            starr.add(new StringTokenizer(s));
        }
        for (StringTokenizer s : starr) {
            int a = Integer.parseInt(s.nextToken());
            int b = Integer.parseInt(s.nextToken());
            int c = Integer.parseInt(s.nextToken());
            if (a * a + b * b == c * c) {
                sb.append("right\n");
            } else if (b * b + c * c == a * a) {
                sb.append("right\n");
            } else if (c * c + a * a == b * b) {
                sb.append("right\n");
            } else {
                sb.append("wrong\n");
            }
        }
        System.out.println(sb);
    }
}