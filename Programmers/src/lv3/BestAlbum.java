package lv3;

import java.util.*;
import java.util.Map.Entry;

// 해시 > 베스트앨범

public class BestAlbum {
    public int[] solution(String[] genres, int[] plays) {
        // HashMap<String, Integer> mapSum = new HashMap<>();
        // for (int i = 0; i < genres.length; i++) {
        // mapSum.put(genres[i], mapSum.getOrDefault(genres[i], 0) + plays[i]);
        // }
        // HashMap<String, ArrayList<Integer>> mapNumArr = new HashMap<>();
        // for (int i = 0; i < genres.length; i++) {
        // if (!mapNumArr.containsKey(genres[i])) {
        // mapNumArr.put(genres[i], new ArrayList<>());
        // }
        // mapNumArr.get(genres[i]).add(plays[i]);
        // }
        // List<Entry<String, Integer>> listEntryes = new ArrayList<Entry<String,
        // Integer>>(mapSum.entrySet());
        // Collections.sort(listEntryes, new Comparator<Entry<String, Integer>>() {
        // @Override
        // public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
        // return o2.getValue().compareTo(o1.getValue());
        // }
        // });
        // ArrayList<Integer> arr = new ArrayList<>();
        // for (Entry<String, Integer> entry : listEntryes) {
        // Collections.sort(mapNumArr.get(entry.getKey()), Collections.reverseOrder());
        // for (int i = 0; i < 2; i++) {
        // for (int j = 0; j < plays.length; j++) {
        // if (mapNumArr.get(entry.getKey()).get(i) == plays[j]) {
        // arr.add(j);
        // break;
        // }
        // }
        // }
        // }
        // int[] answer = new int[arr.size()];
        // for (int i = 0; i < arr.size(); i++) {
        // answer[i] = arr.get(i);
        // }
        // return answer;

        // -------------------------------------------------------------

        // HashMap<String, Integer> mapSum = new HashMap<>();
        // HashMap<String, HashMap<Integer, ArrayList<Integer>>> map = new HashMap<>();
        // for (int i = 0; i < genres.length; i++) {
        // mapSum.put(genres[i], mapSum.getOrDefault(genres[i], 0) + plays[i]);
        // }
        // System.out.println(mapSum);
        // for (int i = 0; i < genres.length; i++) {
        // if (!map.containsKey(genres[i])) {
        // HashMap<Integer, ArrayList<Integer>> mapArr = new HashMap<>();
        // mapArr.put(mapSum.get(genres[i]), new ArrayList<Integer>());
        // map.put(genres[i], mapArr);
        // }
        // map.get(genres[i]).get(mapSum.get(genres[i])).add(plays[i]);
        // }
        // List<Entry<String, HashMap<Integer, ArrayList<Integer>>>> listEntryes = new
        // ArrayList<>(map.entrySet());
        // Collections.sort(listEntryes, new Comparator<Entry<String, HashMap<Integer,
        // ArrayList<Integer>>>>() {
        // @Override
        // public int compare(Entry<String, HashMap<Integer, ArrayList<Integer>>> o1,
        // Entry<String, HashMap<Integer, ArrayList<Integer>>> o2) {
        // return o2.getKey().compareTo(o1.getKey());
        // }
        // });
        // ArrayList<Integer> answerArr = new ArrayList<>();
        // for (int i = 0; i < listEntryes.size(); i++) {
        // Collections.sort(listEntryes.get(i).getValue().get(mapSum.get(listEntryes.get(i).getKey())),
        // Collections.reverseOrder());
        // for (int j = 0; j < 2; j++) {
        // for (int j2 = 0; j2 < plays.length; j2++) {
        // if (plays[j2] ==
        // listEntryes.get(i).getValue().get(mapSum.get(listEntryes.get(i).getKey()))
        // .get(j)) {
        // answerArr.add(j2);
        // break;
        // }
        // }
        // }
        // }
        // int[] answer = new int[answerArr.size()];
        // for (int i = 0; i < answerArr.size(); i++) {
        // answer[i] = answerArr.get(i);
        // }
        // return answer;

        // ---------------------------------------------------------------------------------------

        int[] answer = {};
        return answer;
    }

    public static void main(String[] args) {
        BestAlbum ba = new BestAlbum();
        String[] genres = { "classic", "pop", "classic", "classic", "pop" };
        int[] plays = { 500, 600, 150, 800, 2500 };

        System.out.println(Arrays.toString(ba.solution(genres, plays)));
    }
}
