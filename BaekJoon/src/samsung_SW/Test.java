package samsung_SW;

import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Test {
    public static void main(String[] args) {
        StringTokenizer st = new StringTokenizer("1 2 3 4 5");
        while (st.hasMoreTokens()) {
            System.out.println(st.nextToken());
        }

        HashSet<Integer> set = new HashSet<>();
        set.add(1);
        HashMap<Integer, HashSet<Integer>> map = new HashMap<>();
        map.put(1, set);
        System.out.println(map.get(2));
    }
}
