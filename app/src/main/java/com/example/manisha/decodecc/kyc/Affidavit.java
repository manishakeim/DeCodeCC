package com.example.manisha.decodecc.kyc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.manisha.decodecc.R;
import com.squareup.picasso.Picasso;

public class Affidavit extends AppCompatActivity {

    public static final String ID = "id";
    ImageView aff_img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_affidavit);

        Bundle bundle = getIntent().getExtras();
        getSupportActionBar().setTitle("Know Your Candidates");

        String str   = bundle.getCharSequence(ID)+"";

        aff_img = findViewById(R.id.img_for_aff);

        if (str != null) {
            Picasso.get().load(str)
                    .into(aff_img);
        }else{
             Toast.makeText(Affidavit.this, "No Data Available", Toast.LENGTH_LONG).show();
        }


    }
}
