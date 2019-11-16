package model;

public class Batsman {
    private String name;
    private int runs;
    private int balls;
    private int sixes;
    private int fours;

    public Batsman() {
    }

    public Batsman(String name, int runs, int balls, int sixes, int fours) {
        this.name = name;
        this.runs = runs;
        this.balls = balls;
        this.sixes = sixes;
        this.fours = fours;
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

    public int getBalls() {
        return balls;
    }

    public void setBalls(int balls) {
        this.balls = balls;
    }

    public int getSixes() {
        return sixes;
    }

    public void setSixes(int sixes) {
        this.sixes = sixes;
    }

    public int getFours() {
        return fours;
    }

    public void setFours(int fours) {
        this.fours = fours;
    }
}
