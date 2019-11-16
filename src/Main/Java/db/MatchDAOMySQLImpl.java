package db;

import model.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MatchDAOMySQLImpl implements MatchDAO {

    Connection connection;

    public MatchDAOMySQLImpl() {
        connection= DBConnect.connection();
    }

    @Override
    public Match getMatch(int id) {

        Match match=new Match();


        try {
            Statement statement = connection.createStatement();
            ResultSet rs=statement.executeQuery("SELECT * FROM matches WHERE id='"+id+"'");

            rs.next();
            int country1_id=rs.getInt(2);
            int country2_id = rs.getInt(3);
            String toss = rs.getString(4);
            String winner=rs.getString(5);
            String ground = rs.getString(6);

            Country country1=getCountry(country1_id);
            Country country2=getCountry(country2_id);


            match=new Match(country1,country2,toss,winner,ground);

        } catch (SQLException e) {
            e.printStackTrace();
        }


        return match;
    }

    Country getCountry(int id){
        Statement statement= null;
        Country country=new Country();
        try {
            statement = connection.createStatement();

        ResultSet country_rs=statement.executeQuery("SELECT * FROM country WHERE id='"+id+"'");
        country_rs.next();
        String country_name=country_rs.getString("name");
        int country_scorecard_id=country_rs.getInt("scorecard_id");
        ResultSet batting_scorecard_rs=statement.executeQuery("SELECT * FROM batsman WHERE scorecard_id='"+country_scorecard_id+"'");

        List<Batsman> batsmanScorecard=new ArrayList<>();

        while (batting_scorecard_rs.next()){
            String name=batting_scorecard_rs.getString("name");
            int runs = batting_scorecard_rs.getInt("runs");
            int balls = batting_scorecard_rs.getInt("balls");
            int fours = batting_scorecard_rs.getInt("fours");
            int sixes = batting_scorecard_rs.getInt("sixes");
            Batsman batsman=new Batsman(name,runs,balls,sixes,fours);
            batsmanScorecard.add(batsman);
        }

        ResultSet bowling_scorecard_rs=statement.executeQuery("SELECT * FROM bowlers WHERE scorecard_id='"+country_scorecard_id+"'");

        List<Bowlers> bowlersScorecard=new ArrayList<>();

        while (bowling_scorecard_rs.next()){
            String name=bowling_scorecard_rs.getString("name");
            int runs = bowling_scorecard_rs.getInt("runs");
            int balls = bowling_scorecard_rs.getInt("balls");
            int wickets = bowling_scorecard_rs.getInt("wickets");
            int maidens = bowling_scorecard_rs.getInt("maidens");
            Bowlers bowler=new Bowlers(name,runs,wickets,balls,maidens);
            bowlersScorecard.add(bowler);
        }

        Scorecard scorecard=new Scorecard(batsmanScorecard,bowlersScorecard);

        country= new Country(country_name,scorecard);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return country;
    }
}




