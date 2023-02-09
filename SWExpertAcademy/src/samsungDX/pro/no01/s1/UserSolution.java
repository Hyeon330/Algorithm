package samsungDX.pro.no01.s1;

class ID {
    int score;
    int team;

    ID(int score, int team) {
        this.score = score;
        this.team = team;
    }
}

class UserSolution
{
    static final int MAX_ID = 100000;
    static final int MAX_TEAM = 5;

    ID[] ids;
    boolean[][] teams;
    int[] teamNum;

    public void init()
    {
        ids = new ID[MAX_ID];
        teams = new boolean[MAX_TEAM][MAX_ID];
        teamNum = new int[MAX_TEAM];
    }

    public void hire(int mID, int mTeam, int mScore)
    {
        ids[mID - 1] = new ID(mScore, mTeam - 1);
        teams[mTeam - 1][mID - 1] = true;
        teamNum[mTeam - 1]++;
    }

    public void fire(int mID)
    {
        teams[ids[mID - 1].team][mID - 1] = false;
        teamNum[ids[mID - 1].team]--;
        ids[mID - 1] = null;
    }

    public void updateSoldier(int mID, int mScore)
    {
        ids[mID - 1].score = mScore;
    }

    public void updateTeam(int mTeam, int mChangeScore)
    {
        int teamN = teamNum[mTeam - 1];

        for (int i = 0; i < MAX_ID && teamN > 0; i++) {
            if (teams[mTeam - 1][i]) {
                ids[i].score += mChangeScore;
                if (ids[i].score > 5)
                    ids[i].score = 5;
                if (ids[i].score < 1)
                    ids[i].score = 1;
                teamN--;
            }
        }
    }

    public int bestSoldier(int mTeam)
    {
        int teamN = teamNum[mTeam - 1];
        int maxScore, result;

        maxScore = result = 0;
        for (int i = 0; i < MAX_ID && teamN > 0; i++) {
            if (teams[mTeam - 1][i]) {
                if (ids[i].score >= maxScore) {
                    maxScore = ids[i].score;
                    result = i;
                }
                teamN--;
            }
        }
        return result + 1;
    }
}