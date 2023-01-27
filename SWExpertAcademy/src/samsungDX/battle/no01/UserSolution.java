package samsungDX.battle.no01;

class ID {
    int id;
    int team;
    int score;

    ID(int id, int team, int score) {
        this.id = id;
        this.team = team;
        this.score = score;
    }
}
class Team {
    ID[] teamLst;
    int nodeCnt;

    Team() {
        teamLst = new ID[100000];
        nodeCnt = 1;
    }

    void push(ID data) {
        ID tmp;
        int tmpCnt;

        teamLst[nodeCnt] = data;
        tmpCnt = nodeCnt++;
        while (tmpCnt > 1 && teamLst[tmpCnt >> 1].score < teamLst[tmpCnt].score) {
            tmp = teamLst[tmpCnt >> 1];
            teamLst[tmpCnt >> 1] = teamLst[tmpCnt];
            teamLst[tmpCnt] = tmp;
            tmpCnt = tmpCnt >> 1;
        }
    }

//    ID pop(int mID) {
//
//    }
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
        teams[mTeam - 1].push(ids[mID - 1]);
    }

    public void fire(int mID)
    {

    }

    public void updateSoldier(int mID, int mScore)
    {

    }

    public void updateTeam(int mTeam, int mChangeScore)
    {

    }

    public int bestSoldier(int mTeam)
    {
        return 0;
    }
}