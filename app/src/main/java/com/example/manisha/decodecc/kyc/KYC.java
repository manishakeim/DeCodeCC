package com.example.manisha.decodecc.kyc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import com.example.manisha.decodecc.R;
import com.example.manisha.decodecc.http.ApiUtil;
import com.example.manisha.decodecc.model.ApiObject;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.support.v7.widget.DividerItemDecoration.HORIZONTAL;

public class KYC extends AppCompatActivity  {

    RecyclerView recyclerView;
    NewAdapter adapter;

    ArrayList<ApiObject> candidates = new ArrayList<>();

    ProgressBar progressBar;
    private final String TAG = KYC.class.getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kyc);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Know Your Candidate");
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        toolbar.setNavigationIcon(android.support.v7.appcompat.R.drawable.abc_ic_ab_back_material);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_id);
        adapter = new NewAdapter(this, candidates);

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        dividerItemDecoration.setDrawable(getResources().getDrawable(R.drawable.recyclerview_divider));
        recyclerView.addItemDecoration(dividerItemDecoration);

        recyclerView.setAdapter(adapter);
        progressBar  = findViewById(R.id.progressBar);
        final LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setHasFixedSize(true);

        //   recyclerView.addItemDecoration(new DividerItemDecoration(recyclerView.getContext(), DividerItemDecoration.HORIZONTAL));




        ApiUtil.getServiceClass().getAllPost().enqueue(new Callback<List<ApiObject>>() {
            @Override
            public void onResponse(Call<List<ApiObject>> call, Response<List<ApiObject>> response) {
                if(response.isSuccessful()){

                    ArrayList<ApiObject> temp_follow = (ArrayList<ApiObject>) response.body();
                    Log.d("MainActivityABC", temp_follow.size()+ "");
                    //     Log.d("MainActivity", repository.name);


                    //candidates.clear();
                    for (int i = 0; i<temp_follow.size(); i++){

                        candidates.add(temp_follow.get(i));
                        adapter.notifyDataSetChanged();
                    }

                    progressBar.setVisibility(View.GONE);
                    recyclerView.setVisibility(View.VISIBLE);


                }
            }

            @Override
            public void onFailure(Call<List<ApiObject>> call, Throwable t) {
                //showErrorMessage();
                Log.d(TAG, "error loading from API");
            }
        });
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }



}

