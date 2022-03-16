package lv1;

public class NewIdRecomm_ {
    public String solution(String new_id) {
        String answer = new_id.toLowerCase();
        System.out.println(answer);

        String tmp = "";
        for (int i = 0; i < new_id.length(); i++) {
            if ((answer.charAt(i) >= 97 && answer.charAt(i) <= 122) ||
                    (answer.charAt(i) >= 48 && answer.charAt(i) <= 57) ||
                    answer.charAt(i) == '-' ||
                    answer.charAt(i) == '_' ||
                    answer.charAt(i) == '.') {
                tmp += answer.charAt(i);
            }
        }
        answer = tmp;
        System.out.println(answer);

        for (int i = 0; i < answer.length() - 1; i++) {
            if (answer.charAt(i) == '.' && answer.charAt(i + 1) == '.') {
                answer = answer.replace("..", ".");
                i = -1;
            }
        }
        System.out.println(answer);

        answer = answer.replaceFirst(".", "");
        if (answer.charAt(answer.length() - 1) == '.') {
            answer = answer.substring(0, answer.length() - 1);
        }
        System.out.println(answer);

        if (answer.length() > 15) {
            answer = answer.substring(0, 15);
        }
        System.out.println(answer);

        if (answer.length() <= 2) {
            while (answer.length() != 3) {
                answer += answer.charAt(answer.length() - 1);
            }
        }

        return answer;

    }

    public static void main(String[] args) {
        NewIdRecomm_ nir = new NewIdRecomm_();
        String new_id = "z-+.^.";

        System.out.println(nir.solution(new_id));
    }
}
