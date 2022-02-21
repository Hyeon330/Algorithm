package lv2;

import java.util.*;
import static java.util.stream.Collectors.*;

public class CamouflageStream {
    public int solution(String[][] clothes) {
        return Arrays.stream(clothes)
                .collect(groupingBy(p -> p[1], mapping(p -> p[0], counting())))
                .values()
                .stream()
                .collect(reducing(1L, (x, y) -> x * (y + 1))).intValue() - 1;
    }

    public static void main(String[] args) {
        CamouflageStream camo = new CamouflageStream();
        String[][] clothes = { { "yellowhat", "headgear" }, { "bluesunglasses", "eyewear" },
                { "green_turban", "headgear" }, { "crowmask", "face" }, { "bluesunglasses", "face" },
                { "smoky_makeup", "face" } };

        System.out.println(camo.solution(clothes));
    }
}