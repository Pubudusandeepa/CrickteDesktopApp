import db.MatchDAO;
import db.MatchDAOMySQLImpl;
import model.Batsman;
import model.Bowlers;
import model.Match;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Cricket {

    JPanel board;
    private JTextField textId;
    private JButton searchButton;
    private JTextField textMatch;
    private JTextField textTeam1;
    private JTextField textRun1;
    private JTextField textTeam2;
    private JTextField textRun2;
    private JTextField textWinner;
    private JComboBox comboBox;
    private JTextField textToss;
    private JTable Bating_table1;
    private JTable Bating_table2;
    private JTextField textGround;
    private JTable Bowling_table1;
    private JTable Bowling_table2;

    MatchDAO matchDAOMySQL;
    Match match;


    public Cricket() {
        matchDAOMySQL = new MatchDAOMySQLImpl();
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int match_id = Integer.parseInt(textId.getText());
                showMatchData(match_id);

            }
        });
        comboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int ind = comboBox.getSelectedIndex();
                select_combo(ind);

            }
        });
    }



    public void showMatchData(int id) {

        match = matchDAOMySQL.getMatch(id);

        String matchname = match.getCountry1().getName() + " vs " + match.getCountry2().getName();

        this.textMatch.setText(matchname);
        this.textTeam1.setText(match.getCountry1().getName());
        this.textTeam2.setText(match.getCountry2().getName());
        this.textWinner.setText(match.getWinner());
        this.textToss.setText(match.getToss());
        this.textGround.setText(match.getGround());
        this.textRun1.setText(String.valueOf(match.getCountry1().getScorecard().getTotalRunsScored()));
        this.textRun2.setText(String.valueOf(match.getCountry2().getScorecard().getTotalRunsScored()));

    }

    public void select_combo(int ind) {

        if (ind == 1) {
            show_1st_Inning();
        }
        if (ind == 2) {
            showBating_table2();
        }
    }

    public void show_1st_Inning() {

        String[] tbHead = {"Name", "Runs", "Balls", "Sixes", "Fours"};

        DefaultTableModel dtm = new DefaultTableModel(tbHead, 0);

        Bating_table1.setModel(dtm);
        for (Batsman batsman : match.getCountry1().getScorecard().getBattingCard()) {
            String[] data = {batsman.getName(), String.valueOf(batsman.getRuns()), String.valueOf(batsman.getBalls()), String.valueOf(batsman.getSixes()), String.valueOf(batsman.getFours())};
            dtm.addRow(data);
        }

        String[] tbHead2 = {"Name", "Runs", "Balls", "Wicket", "Maidens"};

        DefaultTableModel dtm2 = new DefaultTableModel(tbHead2, 0);

        Bowling_table1.setModel(dtm2);
        for (Bowlers bowler : match.getCountry1().getScorecard().getBowlingCard()) {
            String[] data = {bowler.getName(), String.valueOf(bowler.getRuns()), String.valueOf(bowler.getBalls()), String.valueOf(bowler.getWickets()), String.valueOf(bowler.getMaidens())};
            dtm2.addRow(data);
        }


    }



    public void showBating_table2() {


        String[] tbHead3 = {"Name", "Runs", "Balls", "Sixes", "Fours"};

        DefaultTableModel dtm3 = new DefaultTableModel(tbHead3, 0);

        Bating_table2.setModel(dtm3);
        for (Batsman batsman : match.getCountry2().getScorecard().getBattingCard()) {
            String[] data = {batsman.getName(), String.valueOf(batsman.getRuns()), String.valueOf(batsman.getBalls()), String.valueOf(batsman.getSixes()), String.valueOf(batsman.getFours())};
            dtm3.addRow(data);
        }

        String[] tbHead4 = {"Name", "Runs", "Balls", "Wicket", "Maidens"};

        DefaultTableModel dtm4 = new DefaultTableModel(tbHead4, 0);

        Bowling_table2.setModel(dtm4);
        for (Bowlers bowler : match.getCountry2().getScorecard().getBowlingCard()) {
            String[] data = {bowler.getName(), String.valueOf(bowler.getRuns()), String.valueOf(bowler.getBalls()), String.valueOf(bowler.getWickets()), String.valueOf(bowler.getMaidens())};
            dtm4.addRow(data);
        }
    }
}
