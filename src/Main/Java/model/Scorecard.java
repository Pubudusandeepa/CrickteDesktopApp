package model;

import operation.OperationFactory;

import java.util.ArrayList;
import java.util.List;

public class Scorecard {
    private List<Batsman> battingCard;
    private List<Bowlers> bowlingCard;
    private OperationFactory operationFactory;

    public Scorecard() {
        operationFactory=new OperationFactory();
    }

    public Scorecard(List<Batsman> battingCard, List<Bowlers> bowlingCard) {
        this.battingCard = battingCard;
        this.bowlingCard = bowlingCard;
        operationFactory=new OperationFactory();
    }

    public List<Batsman> getBattingCard() {
        return battingCard;
    }

    public void setBattingCard(List<Batsman> battingCard) {
        this.battingCard = battingCard;
    }

    public List<Bowlers> getBowlingCard() {
        return bowlingCard;
    }

    public void setBowlingCard(List<Bowlers> bowlingCard) {
        this.bowlingCard = bowlingCard;
    }

    public double getTotalRunsScored(){
        List<Double> runsScored=new ArrayList<>();
        for (Batsman batsman:battingCard){
            runsScored.add((double) batsman.getRuns());
        }
        return operationFactory.getOperation("add",runsScored).perform();
    }
}
