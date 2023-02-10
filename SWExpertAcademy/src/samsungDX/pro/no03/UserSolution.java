package samsungDX.pro.no03;

class Manager {
    int startT, arrivT, dstLoc;

    Manager(int startT, int arrivT, int dstLoc) {
        this.startT = startT;
        this.arrivT = arrivT;
        this.dstLoc = dstLoc;
    }
}

class Order {
    int city, tax;

    Order(int city, int tax) {
        this.city = city;
        this.tax = tax;
    }
}

class Heap {
    static int parent(int i) {return i >> 1;}
    static int left(int i) {return i << 1;}
    static int right(int i) {return i << 1 | 1;}
    static final int MAX_N = 1000000000;

    Order[] data;
    int size = 0;

    Heap() {
        data = new Order[MAX_N + 1];
    }

    Heap(int M) {
        data = new Order[M + 1];
    }

    private void swap(int n1, int n2) {
        Order tmp;

        tmp = data[n1];
        data[n1] = data[n2];
        data[n2] = tmp;
    }

    private int searchCity(int city) {
        for (int i = 1; i <= size; i++) {
            if (data[i].city == city)
                return i;
        }
        return 0;
    }
    public void push(Order x) {
        int sameCity = searchCity(x.city);

        if (sameCity != 0)
            data[sameCity].tax += x.tax;
        else
            data[++size] = x;
        for (int i = sameCity; parent(i) != 0 && data[parent(i)].tax < data[i].tax; i >>= 1)
            swap(parent(i), i);
    }
}

class UserSolution
{
    int N, M;
    int[] city;


    void init(int N, int M)
    {
    }

    void destroy()
    {

    }

    int order(int tStamp, int mCityA, int mCityB, int mTax)
    {
        return 0;
    }

    int check(int tStamp)
    {
        return -1;
    }
}