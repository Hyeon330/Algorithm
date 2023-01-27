package samsungDX.no18;

public class UserSolution {
    private static int[][] graph;
    private static int king;
    private static boolean chk;
    public void dfs_init(int N, int[][] path) {
        graph = new int[100][5];
        for (int i = 0; i < N - 1; i++) {
            for (int j = 0; j < 5; j++) {
                if (graph[path[i][0]][j] == 0) {
                    graph[path[i][0]][j] = path[i][1];
                    break ;
                }
            }
        }
    }

    public int dfs(int N) {
        if (!chk) {
            king = N;
            chk = true;
        }
        int result = 0;
        for (int i = 0; i < 5 && result < king; i++) {
            if ((result = graph[N][i]) == 0)
                break;
            if (result < king)
                result = dfs(graph[N][i]);
        }
        if (N == king)
            chk = false;
        if (result < king)
            return -1;
        else
            return result;
    }
}