package lv3;

public class WordChange {
    boolean[] flag;
    int answer = 0;

    void dfs() {

    }

    public int solution(String begin, String target, String[] words) {
        flag = new boolean[words.length];
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
