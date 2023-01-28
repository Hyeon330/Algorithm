package samsungDX.battle.no01;

class Node {
    int id, team;
    Node next;

    Node(int id, int team) {
        this.id = id;
        this.team = team;
        next = null;
    }
}

class Team {
    Node head, tail;

    Team() {
        head = new Node(0,0);
        tail = null;
    }

    boolean add(Node newNode) {
        if (newNode == null)
            return false;
        if (head.next == null)
            head.next = newNode;
        else
            tail.next = newNode;
        tail = newNode;
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

        fire(mID);
        hire(mID, team, mScore);
    }

    public void updateTeam(int mTeam, int mChangeScore) {
        int score;

        if (mChangeScore < 0) {
            for (int i = 1; i < MAX_TEAM; i++) {
                score = i + mChangeScore;
                if (score < 1)
                    score = 1;
                if (i == score || teams[mTeam][i] == null) continue;
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
        if (mChangeScore > 0) {
            for (int i = MAX_TEAM - 1; i > 0; i--) {
                score = i + mChangeScore;
                if (score > 5)
                    score = 5;
                if (i == score || teams[mTeam][i] == null) continue;
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
    }

    public int bestSoldier(int mTeam) {
        Node n;
        int ret = 0;

        for (int i = MAX_TEAM - 1; i > 0; i--) {
            if (teams[mTeam][i] != null) {
                n = teams[mTeam][i].head.next;
                while (n != teams[mTeam][i].tail) {
                    if (ret < n.id)
                        ret = n.id;
                    n = n.next;
                }
                break;
            }
        }
        return ret;
    }
}
// 14 / 25