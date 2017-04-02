package com.gjuric.rockpaperscissors;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private Button btRock;
    private Button btPaper;
    private Button btScissors;

    private ImageView ivComputer;
    private ImageView ivPlayer;

    private String computerChoice;
    private String playerChoice;
    private String winner;

    private Random random;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initWidgets();

        setListeners();

        random = new Random();

    }

    //set listeners on buttons
    private void setListeners() {
        btRock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                playerChoice = "rock";
                ivPlayer.setImageResource(R.drawable.rock);
                result();

            }
        });

        btPaper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                playerChoice = "paper";
                ivPlayer.setImageResource(R.drawable.paper);
                result();

            }
        });

        btScissors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                playerChoice = "scissors";
                ivPlayer.setImageResource(R.drawable.scissors);
                result();

            }
        });
    }

    //initialize widgets
    private void initWidgets() {
        btRock = (Button) findViewById(R.id.btRock);
        btPaper = (Button) findViewById(R.id.btPaper);
        btScissors = (Button) findViewById(R.id.btScissors);

        ivComputer = (ImageView) findViewById(R.id.ivComputer);
        ivPlayer = (ImageView) findViewById(R.id.ivPlayer);
    }

    public void result() {

        //determine computer choice
        int computer = random.nextInt(3);

        if (computer == 0) {
            computerChoice = "rock";
            ivComputer.setImageResource(R.drawable.rock);
        }
        else if (computer == 1) {
            computerChoice = "paper";
            ivComputer.setImageResource(R.drawable.paper);
        }
        else if (computer == 2) {
            computerChoice = "scissors";
            ivComputer.setImageResource(R.drawable.scissors);
        }

        //compare player choice to computer choice
        if (playerChoice.equals("scissors") && computerChoice.equals("rock")) {
            winner = "You lose";
        }
        else if (playerChoice.equals("scissors") && computerChoice.equals("paper")) {
            winner = "You win";
        }
        else if (playerChoice.equals("paper") && computerChoice.equals("scissors")) {
            winner = "You lose";
        }
        else if (playerChoice.equals("paper") && computerChoice.equals("rock")) {
            winner = "You win";
        }
        else if (playerChoice.equals("rock") && computerChoice.equals("scissors")) {
            winner = "You win";
        }
        else if (playerChoice.equals("rock") && computerChoice.equals("paper")) {
            winner = "You lose";
        }
        else if (playerChoice.equals("scissors") && computerChoice.equals("scissors")) {
            winner = "Draw";
        }
        else if (playerChoice.equals("rock") && computerChoice.equals("rock")) {
            winner = "Draw";
        }
        else if (playerChoice.equals("paper") && computerChoice.equals("paper")) {
            winner = "Draw";
        }

        //display toast message of result
        Toast.makeText(this, winner, Toast.LENGTH_SHORT).show();

    }
}
