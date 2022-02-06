package lv1;

// 신고 결과 받기

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class ReportResult {
    public static void main(String[] args) {

        String[][] id_list = { { "muzi", "frodo", "apeach", "neo" }, { "con", "ryan" } };
        String[][] report = { { "muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi" },
                { "ryan con", "ryan con", "ryan con", "ryan con" } };
        int k[] = { 2, 3 };

        for (int i = 0; i < id_list.length; i++) {
            for (int j : solution(id_list[i], report[i], k[i])) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }

    public static int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        HashMap<String, HashSet<String>> map = new HashMap<String, HashSet<String>>();

        for (String r : report) {
            String[] r_name = r.split(" ");
            HashSet<String> reportGroup = addReportGroup(map, r_name[1]);
            reportGroup.add(r_name[0]);
        }

        for (String s : id_list) {
            if (map.get(s) != null && map.get(s).size() >= k) {
                Iterator<String> it = map.get(s).iterator();
                while (it.hasNext()) {
                    answer[Arrays.asList(id_list).indexOf(it.next())]++;
                }
            }
        }
        return answer;
    }

    public static HashSet<String> addReportGroup(HashMap<String, HashSet<String>> map, String r_name) {
        if (!map.containsKey(r_name)) {
            map.put(r_name, new HashSet<String>());
        }

        return map.get(r_name);
    }
}
