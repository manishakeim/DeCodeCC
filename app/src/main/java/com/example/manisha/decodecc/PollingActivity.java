package com.example.manisha.decodecc;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.manisha.decodecc.http.ApiUtil;
import com.example.manisha.decodecc.model.Polling;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PollingActivity extends AppCompatActivity {

    List<Polling> pollings = new ArrayList<>();
    TextInputEditText epicNumber;
    private final String TAG = PollingActivity.class.getSimpleName();
    private RecyclerView recyclerView;
    private PollingAdapter pollingAdapter;
    Button submitButton;
    SharedPreferences sharedPreferences;
    public static final String MyPREFERENCES = "myprefs";
    public static final String Name = "nameKey";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_polling);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Know Your Polling Station");
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        toolbar.setNavigationIcon(android.support.v7.appcompat.R.drawable.abc_ic_ab_back_material);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        epicNumber = (TextInputEditText) findViewById(R.id.epicNumber) ;
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        submitButton = (Button) findViewById(R.id.button);
//        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setHasFixedSize(true);

        sharedPreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String epic = epicNumber.getText().toString();




//                SharedPreferences.Editor editor = sharedPreferences.edit();
//                editor.putString("epic", epic);
//                editor.apply();

                ApiUtil.getServiceClass().getPollingData().enqueue(new Callback<List<Polling>>() {

                    @Override
                    public void onResponse(Call<List<Polling>> call, Response<List<Polling>> response) {
                        if (response.isSuccessful()) {
                            loadList(response.body() , epic);
                        }
                    }

                    @Override
                    public void onFailure(Call<List<Polling>> call, Throwable t) {
                        Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });

            }
        });

    }

    private void loadList(List<Polling> pollings, String str)
    {
        pollingAdapter = new PollingAdapter(pollings, getApplicationContext(), str );
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(PollingActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(pollingAdapter);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

}