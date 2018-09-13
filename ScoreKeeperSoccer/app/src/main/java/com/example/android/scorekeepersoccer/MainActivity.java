package com.example.android.scorekeepersoccer;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int homeScore = 0;
    int yellowCardsHome=0;
    int redCardsHome=0;
    int offSidesHome=0;
    int cornersHome=0;
    int freeKicksHome=0;
    int penaltiesHome=0;

// Away Variable

    int awayScore = 0;
    int yellowCardsAway=0;
    int redCardsAway=0;
    int offSidesAway=0;
    int cornersAway=0;
    int freeKicksAway=0;
    int penaltiesAway=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void incrementGoalHome(View view) {
        homeScore = homeScore + 1;
        displayScore();
    }

    public void incrementGoalAway(View view) {
        awayScore = awayScore + 1;
        displayScore();
    }

    public void displayScore() {

        // To display Home Team's score
        TextView homeScoreView = (TextView) findViewById(R.id.home_score);
        homeScoreView.setText("" + homeScore);

        TextView homeYellowCardsView = (TextView) findViewById(R.id.yellow_cards_home);
        homeYellowCardsView.setText("" + yellowCardsHome);

        TextView homeRedCardsView = (TextView) findViewById(R.id.red_cards_home);
        homeRedCardsView.setText("" + redCardsHome);

        TextView homeOffsideView = (TextView) findViewById(R.id.offside_home);
        homeOffsideView.setText("" + offSidesHome);

        TextView homeCornerView = (TextView) findViewById(R.id.corner_home);
        homeCornerView.setText("" + cornersHome);

        TextView homeFreekickView = (TextView) findViewById(R.id.freekick_home);
        homeFreekickView.setText("" + freeKicksHome);

        TextView homePenaltiesView = (TextView) findViewById(R.id.penalties_home);
        homePenaltiesView.setText("" + penaltiesHome);

        //To display Away Team's score
        TextView awayScoreView = (TextView) findViewById(R.id.away_score);
        awayScoreView.setText("" + awayScore);

        TextView awayYellowCardsView = (TextView) findViewById(R.id.yellow_cards_away);
        awayYellowCardsView.setText("" + yellowCardsAway);

        TextView awayRedCardsView = (TextView) findViewById(R.id.red_cards_away);
        awayRedCardsView.setText("" + redCardsAway);

        TextView awayOffsideView = (TextView) findViewById(R.id.offside_away);
        awayOffsideView.setText("" + offSidesAway);

        TextView awayCornerView = (TextView) findViewById(R.id.corner_away);
        awayCornerView.setText("" + cornersAway);

        TextView awayFreekickView = (TextView) findViewById(R.id.freekick_away);
        awayFreekickView.setText("" + freeKicksAway);

        TextView awayPenaltiesView = (TextView) findViewById(R.id.penalties_away);
        awayPenaltiesView.setText("" + penaltiesAway);

    }

    public void reset(View view){
        homeScore = 0;
        yellowCardsHome=0;
        redCardsHome=0;
        offSidesHome=0;
        cornersHome=0;
        freeKicksHome=0;
        penaltiesHome=0;
        awayScore = 0;
        yellowCardsAway=0;
        redCardsAway=0;
        offSidesAway=0;
        cornersAway=0;
        freeKicksAway=0;
        penaltiesAway=0;
        displayScore();
    }

    public void incrementYellowCardsHome(View view){
        yellowCardsHome = yellowCardsHome + 1;
        displayScore();
    }

    public void decrementYellowCardsHome(View view){
        yellowCardsHome = yellowCardsHome - 1;
        if (yellowCardsHome<=0){
            yellowCardsHome=0;
        }
        displayScore();
    }

    public void incrementRedCardsHome(View view){
        redCardsHome = redCardsHome + 1;
        displayScore();
    }

    public void decrementRedCardsHome(View view){
        redCardsHome = redCardsHome - 1;
        if (redCardsHome<=0){
            redCardsHome=0;
        }
        displayScore();
    }

    public void incrementOffsideHome(View view){
        offSidesHome = offSidesHome + 1;
        displayScore();
    }

    public void decrementOffsideHome(View view){
        offSidesHome = offSidesHome - 1;
        if (offSidesHome<=0){
            offSidesHome=0;
        }
        displayScore();
    }
    public void incrementCornerHome(View view){
        cornersHome = cornersHome + 1;
        displayScore();
    }

    public void decrementCornerHome(View view){
        cornersHome = cornersHome - 1;
        if (cornersHome<=0){
            cornersHome=0;
        }
        displayScore();
    }

    public void incrementFreeKickHome(View view){
        freeKicksHome = freeKicksHome + 1;
        displayScore();
    }

    public void decrementFreeKickHome(View view){
        freeKicksHome = freeKicksHome - 1;
        if (freeKicksHome<=0){
            freeKicksHome=0;
        }
        displayScore();
    }
    public void incrementPenaltyHome(View view){
        penaltiesHome = penaltiesHome + 1;
        displayScore();
    }

    public void decrementPenaltyHome(View view){
        penaltiesHome = penaltiesHome - 1;
        if (penaltiesHome<=0){
            penaltiesHome=0;
        }
        displayScore();
    }


    // methods for Away Team


    public void incrementYellowCardsAway(View view){
        yellowCardsAway = yellowCardsAway + 1;
        displayScore();
    }

    public void decrementYellowCardsAway(View view){
        yellowCardsAway = yellowCardsAway - 1;
        if (yellowCardsAway<=0){
            yellowCardsAway=0;
        }
        displayScore();
    }

    public void incrementRedCardsAway(View view){
        redCardsAway = redCardsAway + 1;
        displayScore();
    }

    public void decrementRedCardsAway(View view){
        redCardsAway = redCardsAway - 1;
        if (redCardsAway<=0){
            redCardsAway=0;
        }
        displayScore();
    }

    public void incrementOffsideAway(View view){
        offSidesAway = offSidesAway + 1;
        displayScore();
    }

    public void decrementOffsidesAway(View view){
        offSidesAway = offSidesAway - 1;
        if (offSidesAway<=0){
            offSidesAway=0;
        }
        displayScore();
    }
    public void incrementCornerAway(View view){
        cornersAway = cornersAway + 1;
        displayScore();
    }

    public void decrementCornerAway(View view){
        cornersAway = cornersAway - 1;
        if (cornersAway<=0){
            cornersAway=0;
        }
        displayScore();
    }

    public void incrementFreeKickAway(View view){
        freeKicksAway = freeKicksAway + 1;
        displayScore();
    }

    public void decrementFreeKickAway(View view){
        freeKicksAway = freeKicksAway - 1;
        if (freeKicksAway<=0){
            freeKicksAway=0;
        }
        displayScore();
    }
    public void incrementPenaltyAway(View view){
        penaltiesAway = penaltiesAway + 1;
        displayScore();
    }

    public void decrementPenaltyAway(View view){
        penaltiesAway = penaltiesAway - 1;
        if (penaltiesAway<=0){
            penaltiesAway=0;
        }
        displayScore();
    }

}
