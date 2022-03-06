package lv3;

public class WordChange {
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        return answer;
    }

    public static void main(String[] args) {
        WordChange wc = new WordChange();

        String begin = "hit";
        String target = "cog";
        String[] words = { "hot", "dot", "dog", "lot", "log", "cog" };

        System.out.println(wc.solution(begin, target, words));
    }
}
