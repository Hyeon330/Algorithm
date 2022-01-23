package lv1;

import java.util.*;

public class ReportResult {

    public static void main(String[] args) {

        String[] id_list = { "muzi", "frodo", "apeach", "neo" };
        String[] report = { "muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi" };
        int k = 2;
        // String[] id_list = { "con", "ryan" };
        // String[] report = { "ryan con", "ryan con", "ryan con", "ryan con" };
        // int k = 3;

        solution(id_list, report, k);
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
                Iterator it = map.get(s).iterator();
                while (it.hasNext()) {
                    answer[Arrays.asList(id_list).indexOf(Arrays.asList(it.next()).get(0))]++;
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
