package com.example.unscarmble;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView questionNumberTextView,questionTextView,guideTextView,scoreTextView,questionHeadingTextView;
    EditText answerEditText;
    Button submitButton,skipButton;
    ImageButton infoImageButton;
    int count=1,score=0;

    String ques[]={"aesy","noom","rofg","pehl","ykoa","bleta","tingh","lovges","efotrun","eblreanluv"};
    String  ans[]={"easy","moon","frog","help","okay","table","night","gloves","fortune","vulnerable"};

    public void information(View view){
        Toast.makeText(MainActivity.this, "THIS SAMPLE PROJECT IS MADE BY PRATYUSH", Toast.LENGTH_LONG).show();
    }
    public void redo(){
        if(count>=11){
              submitButton.setEnabled(false);submitButton.setAlpha(0);
              skipButton.setEnabled(false);skipButton.setAlpha(0);
              answerEditText.setEnabled(false);answerEditText.setAlpha(0);
              questionHeadingTextView.setAlpha(0);

              questionTextView.setText("SCORE : "+score);
              questionNumberTextView.setAlpha(0);
              scoreTextView.setText("--");

            Dialog dialog = new Dialog(this);
            dialog.setContentView(R.layout.custom_dialogue_box);
            dialog.show();

        }else{
            questionNumberTextView.setText(count+"/10");
            questionTextView.setText(ques[count-1]);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);

        questionNumberTextView=findViewById(R.id.questionNumberTextView);
        questionTextView=findViewById(R.id.questionTextView);
        answerEditText=findViewById(R.id.answerEditTextView);
        submitButton=findViewById(R.id.submitButton);
        skipButton=findViewById(R.id.skipButton);
        scoreTextView=findViewById(R.id.scoreTextView);
        questionHeadingTextView=findViewById(R.id.questionHeadingTextView);
        infoImageButton=findViewById(R.id.infoImageButton);

            questionNumberTextView.setText(count+"/10");
            questionTextView.setText(ques[count-1]);

            Dialog dialoged = new Dialog(this);
            dialoged.setContentView(R.layout.infodialog);
            dialoged.show();

            submitButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(answerEditText.getText().toString().compareTo("")==0){
                        Toast.makeText(MainActivity.this, "PLEASE ENTER YOUR ANSWER OR SKIP", Toast.LENGTH_SHORT).show();
                    }
                    else if(ans[count-1].compareToIgnoreCase(answerEditText.getText().toString())==0){
                        count++;
                        score+=10;
                        scoreTextView.setText(score+"/100");
                        answerEditText.setText("");
                        Toast.makeText(MainActivity.this, "RIGHT ANSWER...", Toast.LENGTH_SHORT).show();
                        redo();
                    }else{
                        count++;
                        score-=5;
                        scoreTextView.setText(score+"/100");
                        answerEditText.setText("");
                        Toast.makeText(MainActivity.this, "WRONG ANSWER...", Toast.LENGTH_SHORT).show();
                        redo();
                    }
                }
            });

            skipButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    count++;
                    answerEditText.setText("");
                    Toast.makeText(MainActivity.this, "SKIPPED...", Toast.LENGTH_SHORT).show();
                    redo();
                }
            });
    }

}