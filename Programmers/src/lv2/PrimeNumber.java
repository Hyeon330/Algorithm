package lv2;

import java.util.HashSet;
import java.util.Iterator;

//완전탐색 > 소수 찾기

public class PrimeNumber {
    HashSet<Integer> numberSet = new HashSet<>();

    public void recursive(String comb, String others) {
        // comb: 지금까지 조합된 숫자
        // others: 지금까지 쓰지 않은 숫자

        // 1. 현재 조합(comb)을 set에 추가한다.
        if (!comb.equals("")) { // 콤비네이션이 맨 처음 들어왔을 때는 comb는 비어있기 때문에 set에 추가해주면 안된다.
            numberSet.add(Integer.valueOf(comb));
        }

        // 2. 남은숫자 중 한개를 더 해 새로운 조합을 만든다.
        for (int i = 0; i < others.length(); i++) {
            // 현재 comb에 추가한 숫자를 제외한 others값을 매개변수에 넣어준다.
            // 맨 앞부터 i번째 까지 i번째 바로 다음거부터 끝까지
            recursive(comb + others.charAt(i), others.substring(0, i) + others.substring(i + 1));
        }
    }

    public boolean isPrime(int num) {
        if (num > 1) {
            for (int i = 2; i <= Math.sqrt(num); i++) {
                if (num % i == 0) {
                    return false;
                }
            }
        } else {
            return false;
        }
        return true;
    }

    public int solution(String numbers) {
        int answer = 0;
        // 1. 모든 조합의 숫자를 만든다.
        recursive("", numbers);

        // 2. 소수의 개수만 센다.
        Iterator<Integer> it = numberSet.iterator();
        while (it.hasNext()) {
            int num = it.next();
            if (isPrime(num)) {
                answer++;
            }
        }

        // 3. 소수의 개수를 반환한다.
        return answer;
    }

    public static void main(String[] args) {
        PrimeNumber pn = new PrimeNumber();
        String numbers = "011";
        System.out.println(pn.solution(numbers));
    }
}