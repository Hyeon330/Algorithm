package lv3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class TravleRoute {
    ArrayList<String> arr = new ArrayList<>();
    boolean[] ck;

    // void f(String start, String[][] tickets) {
    // for (int i = 0; i < tickets.length; i++) {
    // if (start.equals(tickets[i][0]) && !ck[i]) {
    // arr.add(tickets[i][1]);
    // ck[i] = true;
    // f(tickets[i][1], tickets);
    // break;
    // }
    // }
    // }

    void dfs(String now, String[][] tickets, int cnt, String result) {
        if (cnt == tickets.length) {
            arr.add(result);
            return;
        }
        for (int i = 0; i < tickets.length; i++) {
            if (tickets[i][0].equals(now) && !ck[i]) {
                ck[i] = true;
                System.out.println(tickets[i][1]);
                dfs(tickets[i][1], tickets, cnt + 1, result + " " + tickets[i][1]);
                ck[i] = false; // 왜 이걸 넣어야 하지..?
            }
        }
    }

    public String[] solution(String[][] tickets) {
        String[] answer = new String[tickets.length + 1];
        ck = new boolean[tickets.length];
        String start = "ICN";
        Arrays.sort(tickets, new Comparator<String[]>() {
            @Override
            public int compare(String[] o1, String[] o2) {
                if (o1[0].toString().equals(o2[0].toString())) {
                    return o1[1].toString().compareTo(o2[1].toString());
                }
                return o1[0].toString().compareTo(o2[0].toString());
            }
        });
        for (String[] string : tickets) {
            System.out.println(Arrays.toString(string));
        }
        dfs(start, tickets, 0, start);

        answer = arr.get(0).split(" ");

        // arr.add(start);
        // f(start, tickets);
        // for (int i = 0; i < arr.size(); i++) {
        // answer[i] = arr.get(i);
        // }

        // Arrays.sort(tickets, new Comparator<String[]>() {
        // @Override
        // public int compare(String[] o1, String[] o2) {
        // return o1[1].compareTo(o2[1]);
        // }
        // });
        // arr.add(start);
        // f(start, tickets);
        // for (int i = 0; i < arr.size(); i++) {
        // answer[i] = arr.get(i);
        // }

        return answer;
    }

    public static void main(String[] args) {
        TravleRoute tr = new TravleRoute();
        // String[][] tickets = {{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}};
        // String[][] tickets = { { "ICN", "SFO" }, { "ICN", "ATL" }, { "SFO", "ATL" },
        // { "ATL", "ICN" },
        // { "ATL", "SFO" } };
        String[][] tickets = { { "ICN", "SFO" }, { "ICN", "ATL" }, { "SFO", "ATL" }, { "ATL", "ICN" }, { "ATL", "SFO" },
                { "SFO", "ICN" }, { "ICN", "AAA" } };
        System.out.println(Arrays.toString(tr.solution(tickets)));
    }
}
