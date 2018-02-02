package com.example.android.quizzapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;
import android.view.View;


public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // Checks the imputed answers and calculates the points

    private int check_points() {
        int points = 0;
        RadioButton answer_1 = findViewById(R.id.answer_11);
        RadioButton answer_2 = findViewById(R.id.answer_23);
        RadioButton answer_3 = findViewById(R.id.answer_32);
        RadioButton answer_5 = findViewById(R.id.answer_53);
        RadioButton answer_6 = findViewById(R.id.answer_61);

        CheckBox answer_41 = findViewById(R.id.answer_41);
        CheckBox answer_42 = findViewById(R.id.answer_42);
        CheckBox answer_43 = findViewById(R.id.answer_43);
        CheckBox answer_44 = findViewById(R.id.answer_44);

        //Verifies if the correct RadioButtons are checked, and gives 1 point if they are

        if (answer_1.isChecked()) {
            points++;
        }
        if (answer_2.isChecked()) {
            points++;
        }
        if (answer_3.isChecked()) {
            points++;
        }
        if (answer_5.isChecked()) {
            points++;
        }
        if (answer_6.isChecked()) {
            points++;
        }

        //Verifies that the CheckBoxes are correctly marked, and only gives the point if the correct ones are checked
        //and the wrong ones are not

        if (answer_41.isChecked() && answer_42.isChecked() && !answer_43.isChecked() && !answer_44.isChecked()) {
            points++;
        }

        return points;
    }

    //The method that is called when the user clicks on Submit Answers button.
    //It displays a text containing the name of the user and the points that he had accumulated

    public void display_points(View view) {

        EditText name = findViewById(R.id.name);
        String text = name.getText().toString() + getString(R.string.you_got) + check_points() + getString(R.string.points);

        Toast toast = Toast.makeText(this, text, Toast.LENGTH_LONG);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();

    }

}
