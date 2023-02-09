package samsungDX.pro.no03;

import java.util.PriorityQueue;
import java.util.Queue;

class OrderNode {
    int tStamp, cityA, cityB, mTax;

    OrderNode(int tStamp, int cityA, int cityB, int mTax) {
        this.tStamp = tStamp;
        this.cityA = cityA;
        this.cityB = cityB;
        this.mTax = mTax;
    }
}
class UserSolution
{
    int[] citys;
    int N, M, time;
    PriorityQueue<OrderNode> pq = new PriorityQueue<>((o1, o2) -> {
        return o1.tStamp - o2.tStamp;
    });
    void init(int N, int M)
    {
        citys = new int[N];
        this.N = N;
        this.M = M;
        time = 0;
    }

    void destroy()
    {
    }

    int order(int tStamp, int mCityA, int mCityB, int mTax)
    {
        pq.add(new OrderNode(tStamp, mCityA, mCityB, mTax));
        return 0;
    }

    int check(int tStamp)
    {
        int ret, tmpT;

        tmpT = time;
        while (tmpT < tStamp) {

            tmpT++;
        }
        return -1;
    }
}