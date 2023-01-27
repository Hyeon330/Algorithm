package samsungDX.battle.no01.s2;

class ID {
    int id;
    int score;
    int team;

    ID(int id, int team, int score) {
        this.id = id;
        this.score = score;
        this.team = team;
    }
}

class Team {
    class Node {
        ID data;
        Node next;
        Node prev;

        Node(ID data) {
            this.data = data;
            prev = null;
            next = null;
        }
    }

    Node[] t;
    Node head, tail;
    int size;
    Team() {
        t = new Node[100000];
        head = new Node(null);
        tail = new Node(null);
        head.next = tail;
        tail.prev = head;
    }

    boolean add(ID data) {
        if (data == null)
            return false;
        Node newNode = new Node(data);

        t[data.id] = newNode;
        newNode.prev = tail.prev;
        newNode.next = tail;
        tail.prev.next = newNode;
        tail.prev = newNode;
        size++;
        return true;
    }

    void remove(int id) {
        t[id].prev.next = t[id].next;
        t[id].next.prev = t[id].prev;
        t[id] = null;
        size--;
    }

    void updateScore(int chScore) {
        Node n = head.next;

        while (n != tail) {
            n.data.score += chScore;
            if (n.data.score > 5)
                n.data.score = 5;
            if (n.data.score < 1)
                n.data.score = 1;
            n = n.next;
        }
    }

    int bestSoldier() {
        Node n = head.next;
        int maxScore, result;

        maxScore = result = 0;
        while (n != tail) {
            if (maxScore < n.data.score) {
                result = n.data.id;
                maxScore = n.data.score;
            }
            if (maxScore == n.data.score && result < n.data.id)
                result = n.data.id;
            n = n.next;
        }
        return result + 1;
    }
}

class UserSolution
{
    static final int MAX_ID = 100000;
    static final int MAX_TEAM = 5;

    ID[] ids;
    Team[] teams;

    public void init()
    {
        ids = new ID[MAX_ID];
        teams = new Team[MAX_TEAM];
    }

    public void hire(int mID, int mTeam, int mScore)
    {
        ids[mID - 1] = new ID(mID - 1, mTeam - 1, mScore);
        if (teams[mTeam - 1] == null)
            teams[mTeam - 1] = new Team();
        teams[mTeam - 1].add(ids[mID - 1]);
    }

    public void fire(int mID)
    {
        teams[ids[mID - 1].team].remove(mID - 1);
        ids[mID - 1] = null;
    }

    public void updateSoldier(int mID, int mScore)
    {
        ids[mID - 1].score = mScore;
    }

    public void updateTeam(int mTeam, int mChangeScore)
    {
        teams[mTeam - 1].updateScore(mChangeScore);
    }

    public int bestSoldier(int mTeam)
    {
        return teams[mTeam - 1].bestSoldier();
    }
}

// 14 / 25