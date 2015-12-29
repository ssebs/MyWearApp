package io.github.ssebs.mywearapp;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends Activity {

    Button bt, bf;
    TextView questionTV;
    Question[] questions;
    int questionNum;
    int score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        //Toast.makeText(SecondActivity.this, "2nd", Toast.LENGTH_SHORT).show();

        questionNum = 0;
        score = 0;

        questionTV = (TextView) findViewById(R.id.question);

        bt = (Button) findViewById(R.id.btn_T);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                answerQuestion(true);
            }
        });

        bf = (Button) findViewById(R.id.btn_f);
        bf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                answerQuestion(false);
            }
        });

        initQs();
        askQuestion();

    }

    private void askQuestion() {
        questionTV.setText(questions[questionNum].getQuestion());
    }


    private void answerQuestion(boolean btnBool) {
        boolean answer = questions[questionNum].getAnsBool();
        if (btnBool == answer) {
            //Toast.makeText(SecondActivity.this, "CORRECT", Toast.LENGTH_SHORT).show();
            customToast("Correct!", 100);
            score++;
        } else {
            Toast.makeText(SecondActivity.this, "WRONG", Toast.LENGTH_SHORT).show();
            // customToast("WRONG!", 500);
            Toast.makeText(SecondActivity.this, "Your score is: " + score, Toast.LENGTH_SHORT).show();
            // customToast("Your score is: " + score, 500);
            score = 0;
            finish();
        }
        if (questionNum < questions.length - 1) {
            questionNum++;
        } else {
            //Toast.makeText(SecondActivity.this, "YOU WON!!", Toast.LENGTH_SHORT).show();
            customToast("You Won!", 500);
            Toast.makeText(SecondActivity.this, "Your score is: " + score, Toast.LENGTH_SHORT).show();
            finish();
        }
        askQuestion();
    }

    private void customToast(String s, int time) {
        final Toast toast = Toast.makeText(SecondActivity.this, s, Toast.LENGTH_SHORT);
        toast.show();

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                toast.cancel();
            }
        }, time);
    }

    private void initQs() {
        questions = new Question[]{
                new Question("Is having a smartwatch cool?", true),
                new Question("Is android better than iOS", true),
                new Question("Is the android logo an apple?", false),
                new Question("Was Jeb Bush the creator of Omegle?", false),
                new Question("Did Steve Jobs make Windows?", false),
                new Question("Did Rich Miner create Android?", true),
                new Question("Are Gypsies real?", true),
                new Question("Is Nascar for the sophisticated?", false)
        };
    }


}
