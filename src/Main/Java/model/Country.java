package model;

public class Country {
    private String name;
    private Scorecard scorecard;

    public Country() {
    }

    public Country(String name, Scorecard scorecard) {
        this.name = name;
        this.scorecard = scorecard;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Scorecard getScorecard() {
        return scorecard;
    }

    public void setScorecard(Scorecard scorecard) {
        this.scorecard = scorecard;
    }
}
