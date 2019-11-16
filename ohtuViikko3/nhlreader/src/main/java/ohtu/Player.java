
package ohtu;

public class Player {
    private String name;
    private int goals;
    private String team;
    private int assists;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setGoals(int goals) {
        this.goals = goals;
    }

    public int getGoals() {
        return this.goals;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public String getTeam() {
        return this.team;
    }

    public void setAssists(int assists) {
        this.assists = assists;
    }

    /**
     * @return the assists
     */
    public int getAssists() {
        return this.assists;
    }

    public int scores() {
        return this.assists + this.goals;
    }
//Aleksander Barkov   FLA   2 + 15 = 17
    @Override
    public String toString() {
        return name + "   " + team + "   " + goals + " + " + assists + " = " + scores();
    }

}
