package model;

public class Match {
    private Country country1;
    private Country country2;
    private String toss;
    private String winner;
    private String ground;

    public Match() {
    }

    public Match(Country country1, Country country2, String toss, String winner, String ground) {
        this.country1 = country1;
        this.country2 = country2;
        this.toss = toss;
        this.winner = winner;
        this.ground = ground;
    }

    public Country getCountry1() {
        return country1;
    }

    public void setCountry1(Country country1) {
        this.country1 = country1;
    }

    public Country getCountry2() {
        return country2;
    }

    public void setCountry2(Country country2) {
        this.country2 = country2;
    }

    public String getToss() {
        return toss;
    }

    public void setToss(String toss) {
        this.toss = toss;
    }

    public String getWinner() {
        return winner;
    }

    public void setWinner(String winner) {
        this.winner = winner;
    }

    public String getGround() {
        return ground;
    }

    public void setGround(String ground) {
        this.ground = ground;
    }
}
