package com.example.manisha.decodecc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Button;

import com.example.manisha.decodecc.kyc.KYC;

public class MainActivity extends AppCompatActivity {

    Button rateUsButton;
    CardView cardView1, cardView3, cardView6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rateUsButton = (Button) findViewById(R.id.rateUs);
        cardView1 = (CardView) findViewById(R.id.cardview2);
        cardView3 = (CardView) findViewById(R.id.cardview3);
        cardView6 = (CardView) findViewById(R.id.cardview6);


        cardView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.getContext().startActivity(new Intent(v.getContext(), PollingActivity.class));
            }
        });

        cardView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.getContext().startActivity(new Intent(v.getContext(), KYC.class));
            }
        });

        cardView6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.getContext().startActivity(new Intent(v.getContext(), ResultActivity.class));
            }
        });

        rateUsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), RateActivity.class);
                startActivity(intent);

            }
        });



    }
}
