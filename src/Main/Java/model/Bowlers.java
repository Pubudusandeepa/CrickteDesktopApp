package model;

public class Bowlers {
    private String name;
    private int runs;
    private int wickets;
    private int balls;
    private int maidens;

    public Bowlers() {
    }

    public Bowlers(String name, int runs, int wickets, int balls, int maidens) {
        this.name = name;
        this.runs = runs;
        this.wickets = wickets;
        this.balls = balls;
        this.maidens = maidens;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRuns() {
        return runs;
    }

    public void setRuns(int runs) {
        this.runs = runs;
    }

    public int getWickets() {
        return wickets;
    }

    public void setWickets(int wickets) {
        this.wickets = wickets;
    }

    public int getBalls() {
        return balls;
    }

    public void setBalls(int balls) {
        this.balls = balls;
    }

    public int getMaidens() {
        return maidens;
    }

    public void setMaidens(int maidens) {
        this.maidens = maidens;
    }
}
