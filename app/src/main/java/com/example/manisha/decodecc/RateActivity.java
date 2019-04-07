package com.example.manisha.decodecc;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Toast;

import com.example.manisha.decodecc.db.DatabaseHelper;

public class RateActivity extends AppCompatActivity {
    Button RegistrationButton;
    DatabaseHelper mDatabaseHelper;

        @Override
        protected void onCreate (Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_rate);

            final EditText t = (EditText) findViewById(R.id.editText_review);
            //t.setGravity(Gravity.CENTER);

            final RatingBar rating = (RatingBar) findViewById(R.id.ratingBar);
            mDatabaseHelper = new DatabaseHelper(this);
            RegistrationButton = (Button) findViewById(R.id.floatingActionButton);

            RegistrationButton.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View view) {

                    String newEntry = t.getText().toString();
                    Float rate = rating.getRating();
                    if (newEntry.length() <= 255 && t.length() >= 0) {
                        if (newEntry.matches("[a-zA-Z0-9]+")) {
                            AddData(rate, newEntry);
                            t.setText("");
                            rating.setNumStars(0);
                        } else {
                            toastMessage("Enter alphanumeric characters only");
                        }
                    } else {
                        toastMessage("Please enter the review in less than 255 words");
                    }
                }
            });

        }

        public void AddData(Float m, String newEntry){
            boolean insertData = mDatabaseHelper.addData(m, newEntry);

            if (insertData) {
                toastMessage("Ratings Saved!!!");
            } else {
                toastMessage("Something went wrong");
            }
        }

        private void toastMessage (String message){
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
        }
    }


