package com.example.manisha.decodecc;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
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
    private final String TAG = MainActivity.class.getSimpleName();
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
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("epic", epic);
                editor.apply();

                ApiUtil.getServiceClass().getPollingData().enqueue(new Callback<List<Polling>>() {

                    @Override
                    public void onResponse(Call<List<Polling>> call, Response<List<Polling>> response) {
                        if (response.isSuccessful()) {
                            loadList(response.body());
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

    private void loadList(List<Polling> pollings)
    {
        pollingAdapter = new PollingAdapter(pollings, getApplicationContext());
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(PollingActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(pollingAdapter);
    }

}