package lv2;

import java.util.LinkedList;
import java.util.Queue;

class Truck {
    int weight;
    int move;

    Truck(int weight) {
        this.weight = weight;
        this.move = 1;
    }

    public void moving() {
        this.move++;
    }
}

public class CrosstheBridgeTruck_ {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        Queue<Truck> bridgeQueue = new LinkedList<>();
        int addWeight = 0;

        int truckNum = 0;
        while (!bridgeQueue.isEmpty() || truckNum != truck_weights.length) {
            if (addWeight < weight) {
                bridgeQueue.add(new Truck(truck_weights[truckNum]));
                truckNum++;
            } else {

            }

        }

        return answer;
    }

    public static void main(String[] args) {
        CrosstheBridgeTruck_ cbt = new CrosstheBridgeTruck_();
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