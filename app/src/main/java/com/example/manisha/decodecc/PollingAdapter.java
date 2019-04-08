package com.example.manisha.decodecc;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.manisha.decodecc.model.Polling;
import com.squareup.picasso.Picasso;

import java.util.List;

public class PollingAdapter extends RecyclerView.Adapter<PollingAdapter.CustomViewHolder> {

    private List<Polling> pollings;
    String election;
    Context context;
    SharedPreferences sharedPreferences ;

    public static final String ID = "id";


    public PollingAdapter(List<Polling> pollings, Context context, String str){
        this.context = context;
        this.pollings = pollings;
        this.election = str;

        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
    }


    class CustomViewHolder extends RecyclerView.ViewHolder {

        TextView epic;
        TextView textView;
        ImageView imageView;
        TextView MaptextView;

        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);

            epic = itemView.findViewById(R.id.textView5);
            textView = itemView.findViewById(R.id.textView6);
            imageView = itemView.findViewById(R.id.imageView8);
            MaptextView = itemView.findViewById(R.id.textView7);
        }

    }

    @NonNull
    @Override
    public PollingAdapter.CustomViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
        View view = layoutInflater.inflate(R.layout.row_polling, viewGroup, false);
        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PollingAdapter.CustomViewHolder customViewHolder, int i) {
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);

      //  election = sharedPreferences.getString("epic", "XVP1406270");


        String epicno = pollings.get(i).getEPIC();

        if(epicno!= null && election.equals(epicno)){
            Toast.makeText(context, "Good", Toast.LENGTH_SHORT).show();
            customViewHolder.epic.setVisibility(View.VISIBLE);
            customViewHolder.textView.setVisibility(View.VISIBLE);
            customViewHolder.imageView.setVisibility(View.VISIBLE);
            customViewHolder.epic.setText("Name of Polling Station : \n" + pollings.get(i).getPollingStation().getName());
            customViewHolder.textView.setText("Facilities : " + pollings.get(i).getPollingStation().getFacilities());
            Picasso.get().load(pollings.get(i).getPollingStation().getImage()).into(customViewHolder.imageView);
           // i++;
            customViewHolder.MaptextView.setVisibility(View.VISIBLE);

            customViewHolder.MaptextView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    context.startActivity(new Intent(context, MapsActivity.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
                }
            });

            // customViewHolder.textView.setText(election);
        }
        else {
            Toast.makeText(context,"Invalid EPIC No.", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public int getItemCount() {
        return pollings.size();
    }
}
