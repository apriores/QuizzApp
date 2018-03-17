package com.example.apriores.quizzapp;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.Scroller;
import android.widget.Toast;

import com.example.apriores.quizzapp.R;

public class MainActivity extends AppCompatActivity {

    CheckBox movie1Question1Answer1;
    CheckBox movie1Question1Answer2;
    CheckBox movie1Question1Answer3;
    CheckBox movie1Question1Answer4;
    EditText deviceNameField;
    RadioButton movie2Question1Answer3;
    RadioButton movie2Question2Answer1;
    RadioButton movie3Question1Answer2;
    CheckBox movie3Question2Answer1;
    CheckBox movie3Question2Answer2;
    CheckBox movie3Question2Answer3;
    CheckBox movie3Question2Answer4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

        movie1Question1Answer1 = findViewById(R.id.m1q1a1);
        movie1Question1Answer2 = findViewById(R.id.m1q1a2);
        movie1Question1Answer3 = findViewById(R.id.m1q1a3);
        movie1Question1Answer4 = findViewById(R.id.m1q1a4);
        deviceNameField = findViewById(R.id.m1q2a1);
        movie2Question1Answer3 = findViewById(R.id.m2q1a3);
        movie2Question2Answer1 = findViewById(R.id.m2q2a1);
        movie3Question1Answer2 = findViewById(R.id.m3q1a2);
        movie3Question2Answer1 = findViewById(R.id.m3q2a1);
        movie3Question2Answer2 = findViewById(R.id.m3q2a2);
        movie3Question2Answer3 = findViewById(R.id.m3q2a3);
        movie3Question2Answer4 = findViewById(R.id.m3q2a4);

    }

    @Override
    public void onWindowFocusChanged (boolean hasFocus)
    {
        LinearLayout child_of_scrollView = (LinearLayout) findViewById(R.id.child_of_scrollView);
        ScrollView oScrollView = (ScrollView) findViewById(R.id.oScrollView);

        if(child_of_scrollView.getMeasuredHeight() > oScrollView.getMeasuredHeight());
        //Show some arrow image or something you like to show
    }


    /**
     * This method calculates the score of the quiz.
     */
    public int calculateScore() {
        int score = 0;
        Editable name = deviceNameField.getText();
        String deviceName = name.toString();

        /**
         * Question 1 resolve for Guardians of the Galaxy
         */
        if (movie1Question1Answer1.isChecked()) {
            if (movie1Question1Answer2.isChecked()) {
                if (!movie1Question1Answer3.isChecked()) {
                    if (!movie1Question1Answer4.isChecked()) {
                        score += 1;
                    }
                }
            }
        }

        /**
         * Question 2 resolve for Guardians of the Galaxy
         */
        if (deviceName.equalsIgnoreCase(getString(R.string.walkman))) {
            score += 1;
        }

        /**
         * Question 1 resolve for Twilight
         */
        if (movie2Question1Answer3.isChecked()) {
            score += 1;
        }

        /**
         * Question 2 resolve for Twilight
         */

        if (movie2Question2Answer1.isChecked()) {
            score += 1;
        }

        /**
         * Question 1 resolve for Frozen
         */

        if (movie3Question1Answer2.isChecked()) {
            score += 1;
        }

        /**
         * Question 2 resolve for Frozen
         */
        if (movie3Question2Answer1.isChecked()) {
            if (!movie3Question2Answer2.isChecked()) {
                if (movie3Question2Answer3.isChecked()) {
                    if (movie3Question2Answer4.isChecked()) {
                        score += 1;
                    }
                }
            }
        }

        return score;
    }

    /**
     * This method displays result as a toast when QUIZZ RESULT button is pressed
     * @param view
     */
    public void submitResults (View view){
        Context context = getApplicationContext();

        String text = getString(R.string.answerCorrect)+ " " + calculateScore() +" ";
        if (calculateScore() == 1){
            text+=getString(R.string.question) + " " + getString(R.string.ofMaxQuestions);
        }else if (calculateScore() == 6){
            text = getString(R.string.congratulations_quizz);
        }else text+=getString(R.string.questions) + " " + getString(R.string.ofMaxQuestions);

        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context,text,duration);
        toast.show();
    }

    /*
    /This method clears all checked buttons
     */
    public void resetResults (View view){

        CheckBox checkBox1 = (CheckBox) findViewById(R.id.m1q1a1);
        checkBox1.setChecked(false);

        CheckBox checkBox2 = (CheckBox) findViewById(R.id.m1q1a2);
        checkBox2.setChecked(false);

        CheckBox checkBox3 = (CheckBox) findViewById(R.id.m1q1a3);
        checkBox3.setChecked(false);

        CheckBox checkBox4 = (CheckBox) findViewById(R.id.m1q1a4);
        checkBox4.setChecked(false);

        EditText editField = (EditText) findViewById(R.id.m1q2a1);
        editField.setText(null);
        editField.setFocusableInTouchMode(false);
        editField.setFocusable(false);
        editField.setFocusableInTouchMode(true);
        editField.setFocusable(true);


        RadioGroup radioGroup1 = (RadioGroup) findViewById(R.id.radio_group1);
        radioGroup1.clearCheck();

        RadioGroup radioGroup2 = (RadioGroup) findViewById(R.id.radio_group2);
        radioGroup2.clearCheck();

        RadioGroup radioGroup3 = (RadioGroup) findViewById(R.id.radio_group3);
        radioGroup3.clearCheck();


        CheckBox checkBox5 = (CheckBox) findViewById(R.id.m3q2a1);
        checkBox5.setChecked(false);

        CheckBox checkBox6 = (CheckBox) findViewById(R.id.m3q2a2);
        checkBox6.setChecked(false);

        CheckBox checkBox7 = (CheckBox) findViewById(R.id.m3q2a3);
        checkBox7.setChecked(false);

        CheckBox checkBox8 = (CheckBox) findViewById(R.id.m3q2a4);
        checkBox8.setChecked(false);

    }
}


