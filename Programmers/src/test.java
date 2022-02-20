import java.util.HashSet;

public class test {
    public static void main(String[] args) {
        String[] phone_book = { "119", "97674223", "1195524421" };
        // String[] phone_book = { "123", "456", "789" };
        // String[] phone_book = { "12", "123", "1235", "567", "88" };

        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < phone_book.length; i++) {
            set.add(phone_book[i]);
        }

        for (int i = 0; i < phone_book.length; i++) {
            for (int j = 0; j < phone_book[i].length(); j++) {
                if (set.contains(phone_book[i].substring(0, j))) {
                    System.out.println(phone_book[i]);
                }
            }
        }
    }
}