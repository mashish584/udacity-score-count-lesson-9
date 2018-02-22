package com.example.android.cricketscore;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {




    //Required variables
    private int countBalls = 0;
    private int countRuns = 0;
    private int countExtras = 0;
    private int countWickets = 0;
    private int countOver = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        updateTextScore();

    }

    private void updateTextScore() {

        //Views Declarations
        TextView textScore   = findViewById(R.id.textScore);
        TextView textOvers   = findViewById(R.id.textOvers);
        TextView textExtras  = findViewById(R.id.textExtras);
        TextView textBalls   = findViewById(R.id.textBalls);
        TextView textWickets = findViewById(R.id.textWickets);

        //Setting default values for views
        String score = countRuns + " - " + countWickets;
        textScore.setText(score);
        textOvers.setText("Overs : " + countOver);
        textExtras.setText("Extras : " + countExtras);
        textBalls.setText(countBalls + "");
        textWickets.setText(countWickets + "");
    }

    private void getOver() {
        if((float)countBalls % 6 == 0){
            countOver++;
        }
    }

    public void increaseBall(View view) {
        if(countWickets == 10){
            return;
        }
        this.countBalls++;
        getOver();
        updateTextScore();
    }

    public void decreaseBall(View view) {
        if(countBalls == 0 || countWickets == 10){
            return;
        }
        this.countBalls--;
        getOver();
        updateTextScore();
    }

    public void addNoBall(View view) {
        if(countWickets == 10){
            return;
        }
        this.countExtras++;
        this.countRuns++;
        updateTextScore();
    }

    public void addWideBall(View view) {
        if(countWickets == 10){
            return;
        }
        this.countExtras++;
        this.countRuns++;
        updateTextScore();
    }

    public void add1Run(View view) {
        if(countWickets == 10){
            return;
        }
        this.countRuns++;
        updateTextScore();
    }

    public void add2Run(View view) {
        if(countWickets == 10){
            return;
        }
        this.countRuns += 2;
        updateTextScore();
    }

    public void add3Run(View view) {
        if(countWickets == 10){
            return;
        }
        this.countRuns += 3;
        updateTextScore();
    }

    public void add4Run(View view) {
        if(countWickets == 10){
            return;
        }
        this.countRuns += 4;
        updateTextScore();
    }

    public void add6Run(View view) {
        if(countWickets == 10){
            return;
        }
        this.countRuns += 6;
        updateTextScore();
    }

    public void decreaseWicket(View view) {
        if(countWickets == 0){
            return;
        }
        this.countWickets--;
        updateTextScore();
    }

    public void increaseWicket(View view) {
        if(countWickets == 10){
            return;
        }
        this.countWickets++;
        updateTextScore();
    }

    public void resetScore(View view) {
        this.countOver = this.countBalls = this.countWickets = this.countRuns = this.countExtras = 0;
        updateTextScore();
    }
}
