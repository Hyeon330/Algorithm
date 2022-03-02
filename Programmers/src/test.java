public class test {
    public static void main(String[] args) {
        for (int i = 0; i < 16; i++) {
            System.out.println(String.format("%04d", Integer.parseInt(Integer.toBinaryString(i))));
        }
    }
}