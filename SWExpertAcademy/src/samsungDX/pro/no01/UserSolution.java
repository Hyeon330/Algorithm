package samsungDX.pro.no01;

class Node {
    int id, team;
    Node next, prev;

    Node(int id, int team) {
        this.id = id;
        this.team = team;
        next = null;
        prev = null;
    }
}

class Team {
    Node head, tail;

    Team() {
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
    }

    boolean add(Node newNode) {
        if (newNode == null)
            return false;
        newNode.next = tail;
        newNode.prev = tail.prev;
        tail.prev.next = newNode;
        tail.prev = newNode;
        return true;
    }
}

class UserSolution {
    static final int MAX_ID = 100000 + 1;
    static final int MAX_TEAM = 5 + 1;

    Node[] ids;
    Team[][] teams;

    public void init() {
        ids = new Node[MAX_ID];
        teams = new Team[MAX_TEAM][MAX_TEAM];
    }

    public void hire(int mID, int mTeam, int mScore) {
        ids[mID] = new Node(mID, mTeam);
        if (teams[mTeam][mScore] == null)
            teams[mTeam][mScore] = new Team();
        teams[mTeam][mScore].add(ids[mID]);
    }

    public void fire(int mID) {
        ids[mID].prev.next = ids[mID].next;
        ids[mID].next.prev = ids[mID].prev;
        ids[mID] = null;
    }

    public void updateSoldier(int mID, int mScore) {
        int team = ids[mID].team;

        ids[mID].prev.next = ids[mID].next;
        ids[mID].next.prev = ids[mID].prev;
        if (teams[team][mScore] == null)
            teams[team][mScore] = new Team();
        teams[team][mScore].add(ids[mID]);
    }

    public void updateTeam(int mTeam, int mChangeScore) {
        int score, i, loop, loopCnt = 5;

        if (mChangeScore == 0) return;
        if (mChangeScore < 0) {
            i = 1;
            loop = 1;
        } else {
            i = MAX_TEAM - 1;
            loop = -1;
        }
        while (loopCnt-- > 0) {
            if (teams[mTeam][i] != null) {
                score = i + mChangeScore;
                if (score < 1)
                    score = 1;
                if (score > 5)
                    score = 5;
                if (i != score) {
                    if (teams[mTeam][score] == null)
                        teams[mTeam][score] = teams[mTeam][i];
                    else {
                        teams[mTeam][score].tail.prev.next = teams[mTeam][i].head.next;
                        teams[mTeam][i].head.next.prev = teams[mTeam][score].tail.prev;
                        teams[mTeam][score].tail = teams[mTeam][i].tail;
                    }
                    teams[mTeam][i] = null;
                }
            }
            i += loop;
        }
    }

    public int bestSoldier(int mTeam) {
        Node head = null;
        Node tail = null;
        int ret = 0;

        for (int i = MAX_TEAM - 1; i > 0; i--) {
            if (teams[mTeam][i] != null && teams[mTeam][i].head.next != teams[mTeam][i].tail) {
                head = teams[mTeam][i].head.next;
                tail = teams[mTeam][i].tail;
                break;
            }
        }
        while (head != tail) {
            if (ret < head.id)
                ret = head.id;
            head = head.next;
        }
        return ret;
    }
}
// 25 / 25