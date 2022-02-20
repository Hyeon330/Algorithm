package lv2;

import java.util.*;

// 해시 > 전화번호 목록

public class PhoneNumList {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        // for (int i = 0; i < phone_book.length - 1; i++) {
        // for (int j = i + 1; j < phone_book.length; j++) {
        // if (phone_book[i].length() < phone_book[j].length()) {
        // if (phone_book[i].hashCode() == phone_book[j].substring(0,
        // phone_book[i].length()).hashCode()) {
        // return false;
        // }
        // } else {
        // if (phone_book[j].hashCode() == phone_book[i].substring(0,
        // phone_book[j].length()).hashCode()) {
        // return false;
        // }
        // }
        // }
        // }

        // -----------------------------------------------------------------

        Arrays.sort(phone_book);

        for (int i = 0; i < phone_book.length - 1; i++) {
            if (phone_book[i + 1].startsWith(phone_book[i])) {
                return false;
            }
        }

        // ----------------------------------------------------------------

        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < phone_book.length; i++) {
            set.add(phone_book[i]);
        }
        for (int i = 0; i < phone_book.length; i++) {
            for (int j = 0; j < phone_book[i].length(); j++) {
                if (set.contains(phone_book[i].substring(0, j))) {
                    return false;
                }
            }
        }

        // ------------------------------------------------------------------

        // LinkedList<String> link = new LinkedList<>();
        // for (int i = 0; i < phone_book.length; i++) {
        // link.add(phone_book[i]);
        // }
        // for (int i = 0; i < phone_book.length; i++) {
        // for (int j = 0; j < phone_book[i].length(); j++) {
        // if (link.contains(phone_book[i].substring(0, j))) {
        // return false;
        // }
        // }
        // }

        // --------------------------------------------------------------

        // ArrayList<String> arr = new ArrayList<>();
        // for (int i = 0; i < phone_book.length; i++) {
        // arr.add(phone_book[i]);
        // }
        // for (int i = 0; i < phone_book.length; i++) {
        // for (int j = 0; j < phone_book[i].length(); j++) {
        // if (arr.contains(phone_book[i].substring(0, j))) {
        // return false;
        // }
        // }
        // }

        // ------------------------------------------------------------

        // HashMap<String, Integer> map = new HashMap<>();
        // for (int i = 0; i < phone_book.length; i++) {
        // map.put(phone_book[i], i);
        // }
        // for (int i = 0; i < phone_book.length; i++) {
        // for (int j = 0; j < phone_book[i].length(); j++) {
        // if (map.containsKey(phone_book[i].substring(0, j))) {
        // return false;
        // }
        // }
        // }

        return answer;
    }

    public static void main(String[] args) {
        PhoneNumList pnl = new PhoneNumList();
        String[] phone_book = { "119", "97674223", "1195524421" };
        // String[] phone_book = { "123", "456", "789" };
        // String[] phone_book = { "12", "123", "1235", "567", "88" };

        System.out.println(pnl.solution(phone_book));
        ;
    }
}
