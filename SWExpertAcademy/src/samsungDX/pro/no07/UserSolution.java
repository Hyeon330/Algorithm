package samsungDX.pro.no07;

import java.util.PriorityQueue;

class Node {
    int r, c, energy;

    Node(int r, int c, int energy) {
        this.r = r;
        this.c = c;
        this.energy = energy;
    }
}
class UserSolution {
    PriorityQueue<Node> blueQ;
    PriorityQueue<Node> redQ;

    void init(int N, int mDish[][]) {
        blueQ = new PriorityQueue<>((o1, o2) -> o2.energy - o1.energy);
        redQ = new PriorityQueue<>((o1, o2) -> o2.energy - o1.energy);
    }

    int dropMedicine(int mTarget, int mRow, int mCol, int mEnergy){
        return -1;
    }

    int cleanBacteria(int mRow, int mCol){
        return -1;
    }
}