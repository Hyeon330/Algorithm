import java.util.ArrayList;
import java.util.Arrays;

public class test {
    public static void main(String[] args) {
        ArrayList<Integer> integers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));

        int[] ret = new int[integers.size()];
        for (int i = 0; i < ret.length; i++) {
            ret[i] = integers.get(i);
        }

        System.out.println(Arrays.toString(ret));
    }
}
