import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class test {
    public static void main(String[] args) {
        Map<String, Integer> testMap = new HashMap<String, Integer>();

        // Map에 데이터 추가
        testMap.put("apple", 1);
        testMap.put("orange", 2);
        testMap.put("pineapple", 4);
        testMap.put("strawberry", 5);
        testMap.put("melon", 3);

        // Map.Entry 리스트 작성
        List<Entry<String, Integer>> list_entries = new ArrayList<Entry<String, Integer>>(testMap.entrySet());

        // 비교함수 Comparator를 사용하여 오름차순으로 정렬
        Collections.sort(list_entries, new Comparator<Entry<String, Integer>>() {
            // compare로 값을 비교
            public int compare(Entry<String, Integer> obj1, Entry<String, Integer> obj2) {
                // 오름 차순 정렬
                return obj2.getValue().compareTo(obj1.getValue());
            }
        });

        System.out.println("오름 차순 정렬");
        // 결과 출력
        for (Entry<String, Integer> entry : list_entries) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }
}