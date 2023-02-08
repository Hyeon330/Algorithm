package samsungDX.battle.no02_;

class Node{
    int r, c;
    char[] monarch;
    int soldier;

    MyHash alliance = new MyHash();
    MyHash hostile = new MyHash();

    Node(int r, int c, int soldier, char[] monarch) {
        this.r = r;
        this.c = c;
        this.monarch = monarch;
        this.soldier = soldier;
    }
}

class MyList {
    class LstNode {
        Node data;
        LstNode next;

        LstNode(Node data) {
            this.data = data;
            this.next = null;
        }
    }

    LstNode head;
    LstNode tail;
    int size;

    MyList() {
        head = null;
        tail = null;
        size = 0;
    }

    void add(Node data) {
        LstNode n = new LstNode(data);
        if (head == null)
            head = n;
        else
            tail.next = n;
        tail = n;
        size++;
    }

    Node poll() {
        Node n = head.data;
        head = head.next;
        size--;
        if (size == 0) tail = null;
        return n;
    }
}

// 한글자당 5bit
// 총 10글자
// 50bit
// 7byte
class MyHash {
    class HashNode{
        Node data;
        HashNode next;

        HashNode(Node data, HashNode next) {
            this.data = data;
            this.next = next;
        }
    }
    static int MAX_IDX = 50000;
    HashNode[] table = new HashNode[MAX_IDX];
    MyList lst = new MyList();

    static int strcmp(char[] s1, char[] s2) {
        int i = 0;

        while (s1[i] != 0 && s2[i] != 0 && s1[i] == s2[i]) i++;
        return s1[i] - s2[i];
    }
    private int getIdx(char[] data) {
        long idx = 0;

        for (int i = 0; data[i] != 0; i++)
            idx = idx << 5 | (data[i] ^ 96);
        return (int)(idx % MAX_IDX);
    }

    void add(Node data) {
        int idx = getIdx(data.monarch);
        table[idx] = new HashNode(data, table[idx]);
        lst.add(data);
    }

    boolean contains(char[] data) {
        int idx = getIdx(data);
        HashNode n = table[idx];

        while (n != null) {
            if (strcmp(data, n.data.monarch) == 0)
                return true;
            n = n.next;
        }
        return false;
    }
}

public class UserSolution {
    static int[] ud = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] lr = {0, 1, 1, 1, 0, -1, -1, -1};
    static Node[][] map;
    int N;

    void init(int N, int mSoldier[][], char mMonarch[][][])
    {
        this.N = N;
        map = new Node[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++)
                map[i][j] = new Node(i, j, mSoldier[i][j], mMonarch[i][j]);
        }
    }
    void destroy()
    {

    }
    int ally(char mMonarchA[], char mMonarchB[])
    {
        Node n1 = null, n2 = null;
        int chk = 0;

        if (MyHash.strcmp(mMonarchA, mMonarchB) == 0) return -1;
        for (int i = 0; i < N && chk < 2; i++) {
            for (int j = 0; j < N && chk < 2; j++) {
                if (MyHash.strcmp(map[i][j].monarch, mMonarchA) == 0) {
                    if (map[i][j].alliance.contains(mMonarchB))
                        return -1;
                    if (map[i][j].hostile.contains(mMonarchB))
                        return -2;
                    n1 = map[i][j];
                    chk++;
                }
                if (MyHash.strcmp(map[i][j].monarch, mMonarchB) == 0) {
                    if (map[i][j].alliance.contains(mMonarchA))
                        return -1;
                    if (map[i][j].hostile.contains(mMonarchA))
                        return -2;
                    n2 = map[i][j];
                    chk++;
                }
            }
        }
        n1.alliance.add(n2);
        n2.alliance.add(n1);
        return 1;
    }
    int attack(char mMonarchA[], char mMonarchB[], char mGeneral[])
    {
        MyList queue = new MyList();
        Node n1 = null, n2 = null;
        int attP, chk;

        attP = chk = 0;
        for (int i = 0; i < N && chk < 2; i++) {
            for (int j = 0; j < N && chk < 2; j++) {
                if (MyHash.strcmp(map[i][j].monarch, mMonarchA) == 0) {
                    if (map[i][j].alliance.contains(mMonarchB))
                        return -1;
                    n1 = map[i][j];
                    chk++;
                }
                if (MyHash.strcmp(map[i][j].monarch, mMonarchB) == 0) {
                    if (map[i][j].alliance.contains(mMonarchA))
                        return -1;
                    n2 = map[i][j];
                    chk++;
                }
            }
        }
        queue.add(n1);
        while (queue.size != 0) {
            Node n = queue.poll();
            int tmpR, tmpC;
            for (int i = 0; i < 8; i++) {
                tmpR = n2.r + ud[i];
                tmpC = n2.c + lr[i];
                if (tmpR == n.r && tmpC == n.c) {
                    attP += n.soldier << 1;
                    n.soldier -= n.soldier << 1;
                }
            }
            while (n.alliance.lst.head != null) {

            }
        }
        return -3;
    }
    int recruit(char mMonarch[], int mNum, int mOption)
    {

        return -1;
    }
}