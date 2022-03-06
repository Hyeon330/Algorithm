package lv3;

// 깊이/너비 우선 탐색 > 네트워크

public class Network {
    public int solution(int n, int[][] computers) {
        int answer = 0;

        // 플래그
        boolean[] check = new boolean[n];

        for (int i = 0; i < check.length; i++) {
            if (dfs(i, computers, check)) {
                answer++;
            }
        }
        return answer;
    }

    boolean dfs(int n, int[][] computers, boolean[] ck) {
        if (ck[n])
            return false;

        ck[n] = true;

        for (int i = 0; i < computers.length; i++) {
            if (computers[n][i] == 1) {
                dfs(i, computers, ck);
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Network net = new Network();
        int[][] computers = { { 1, 1, 0 }, { 1, 1, 0 }, { 0, 0, 1 } }; // return 2
        // int[][] computers = { { 1, 1, 0 }, { 1, 1, 1 }, { 0, 1, 1 } }; // reutnr 1

        System.out.println(net.solution(computers.length, computers));
    }
}
