import java.util.LinkedList;
import java.util.Queue;

public class test {
    public static void main(String[] args) {
        Queue<Integer> qu = new LinkedList<>();
        qu.add(1);

        for (int i = 0; i < qu.size(); i++) {
            int num = qu.poll();
            for (Integer integer : qu) {
                System.out.println(integer);
            }
        }
        System.out.println("world");
    }
}