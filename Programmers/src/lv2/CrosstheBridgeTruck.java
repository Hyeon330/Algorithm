package lv2;

import java.util.LinkedList;
import java.util.Queue;

public class CrosstheBridgeTruck {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> bridgeQueue = new LinkedList<>();
        int answer = 0;
        int addWeight = 0;

        // Queue<Integer> truckQueue = new LinkedList<>();
        // for (int i : truck_weights) {
        // truckQueue.add(i);
        // }
        // for (int i = 1; i <= bridge_length; i++) {
        // if (truckQueue.size() != 0) {
        // if (bridgeQueue.size() == bridge_length) {
        // if (bridgeQueue.peek() != null) {
        // addWeight -= bridgeQueue.poll();
        // } else {
        // bridgeQueue.remove();
        // }
        // }
        // if (addWeight + truckQueue.peek() <= weight) {
        // addWeight += truckQueue.peek();
        // bridgeQueue.add(truckQueue.poll());
        // i = 0;
        // } else {
        // bridgeQueue.add(null);
        // }
        // }
        // answer++;
        // }

        // ---------------------------------------------------------

        int truckNum = 0;
        for (int i = 1; i <= bridge_length; i++) {
            if (truckNum != truck_weights.length) {
                if (bridgeQueue.size() == bridge_length) {
                    if (bridgeQueue.peek() != null) {
                        addWeight -= bridgeQueue.poll();
                    } else {
                        bridgeQueue.remove();
                    }
                }
                if (addWeight + truck_weights[truckNum] <= weight) {
                    addWeight += truck_weights[truckNum];
                    bridgeQueue.add(truck_weights[truckNum]);
                    truckNum++;
                    i = 0;
                } else {
                    bridgeQueue.add(null);
                }
            }
            answer++;
        }
        return answer;
    }

    public static void main(String[] args) {
        CrosstheBridgeTruck cbt = new CrosstheBridgeTruck();
        // int bridge_length = 2;
        // int weight = 10;
        // int[] truck_weights = { 7, 5, 4, 6 };

        int bridge_length = 100;
        int weight = 100;
        int[] truck_weights = { 10, 10, 10, 10, 10, 10, 10, 10, 10, 10 };

        // int bridge_length = 100;
        // int weight = 100;
        // int[] truck_weights = { 10 };

        System.out.println(cbt.solution(bridge_length, weight, truck_weights));
    }
}