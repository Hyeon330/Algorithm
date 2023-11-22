package kakaoPrac.lv1;

// https://school.programmers.co.kr/learn/courses/30/lessons/81301
// 2021 카카오 채용연계형 인턴십
// 숫자 문자열과 영단어

public class Ex01 {
    // O(n^2)
    public static int solution(String s) {
        s = s.replaceAll("zero", "0");
        s = s.replaceAll("one", "1");
        s = s.replaceAll("two", "2");
        s = s.replaceAll("three", "3");
        s = s.replaceAll("four", "4");
        s = s.replaceAll("five", "5");
        s = s.replaceAll("six", "6");
        s = s.replaceAll("seven", "7");
        s = s.replaceAll("eight", "8");
        s = s.replaceAll("nine", "9");
        return Integer.parseInt(s);
    }

    static boolean chkNum(String s, StringBuilder tmp) {
        if (s.equals("zero")) {
            tmp.append(0);
            return true;
        }
        if (s.equals("one")) {
            tmp.append(1);
            return true;
        }
        if (s.equals("two")) {
            tmp.append(2);
            return true;
        }
        if (s.equals("three")) {
            tmp.append(3);
            return true;
        }
        if (s.equals("four")) {
            tmp.append(4);
            return true;
        }
        if (s.equals("five")) {
            tmp.append(5);
            return true;
        }
        if (s.equals("six")) {
            tmp.append(6);
            return true;
        }
        if (s.equals("seven")) {
            tmp.append(7);
            return true;
        }
        if (s.equals("eight")) {
            tmp.append(8);
            return true;
        }
        if (s.equals("nine")) {
            tmp.append(9);
            return true;
        }
        return false;
    }

    // O(n)
    public static int solution_(String s) {
        StringBuilder answer = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                answer.append(s.charAt(i));
                continue;
            }

            int cnt = 3;
            if (chkNum(s.substring(i, i + cnt), answer)) {
                i += cnt - 1;
                continue;
            }
            if (chkNum(s.substring(i, i + ++cnt), answer)) {
                i += cnt - 1;
                continue;
            }
            if (chkNum(s.substring(i, i + ++cnt), answer)) i += cnt - 1;
        }
        return Integer.parseInt(answer.toString());
    }

    public static void main(String[] args) {
        System.out.println(solution_("23four5six7"));
    }
}
