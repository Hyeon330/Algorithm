package lv3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class TravleRoute {
    ArrayList<String> arr = new ArrayList<>();

    void f(String start, boolean[] ck, ArrayList<String[]> tickets) {
        for (int i = 0; i < tickets.size(); i++) {
            if (start.equals(tickets.get(i)[0]) && !ck[i]) {
                arr.add(tickets.get(i)[1]);
                ck[i] = true;
                f(tickets.get(i)[1], ck, tickets);
                break;
            }
        }
    }

    public String[] solution(String[][] tickets) {
        String[] answer = new String[tickets.length + 1];
        boolean[] ck = new boolean[tickets.length];

        ArrayList<String[]> ticketsArr = new ArrayList<>(Arrays.asList(tickets));
        Collections.sort(ticketsArr, new Comparator<String[]>() {
            @Override
            public int compare(String[] o1, String[] o2) {
                return o1[1].compareTo(o2[1]);
            }
        });
        arr.add("ICN");
        f("ICN", ck, ticketsArr);

        for (int i = 0; i < arr.size(); i++) {
            answer[i] = arr.get(i);
        }

        return answer;
    }

    public static void main(String[] args) {
        TravleRoute tr = new TravleRoute();
        // String[][] tickets = {{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}};
        String[][] tickets = { { "ICN", "SFO" }, { "ICN", "ATL" }, { "SFO", "ATL" }, { "ATL", "ICN" },
                { "ATL", "SFO" } };

        System.out.println(Arrays.toString(tr.solution(tickets)));
    }
}
