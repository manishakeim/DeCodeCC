package com.example.manisha.decodecc;

import android.content.Context;
import android.content.SharedPreferences;
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



    public PollingAdapter(List<Polling> pollings, Context context){
        this.context = context;
        this.pollings = pollings;

        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
    }


    class CustomViewHolder extends RecyclerView.ViewHolder {

        TextView epic;
        TextView textView;
        ImageView imageView;

        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);

            epic = itemView.findViewById(R.id.textView5);
            textView = itemView.findViewById(R.id.textView6);
            imageView = itemView.findViewById(R.id.imageView8);

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
        election = sharedPreferences.getString("epic", "");
        String epicno = pollings.get(i).getEPIC();
        if(election.equals(epicno)){
            Toast.makeText(context, "Good", Toast.LENGTH_SHORT).show();
            customViewHolder.epic.setVisibility(View.VISIBLE);
            customViewHolder.textView.setVisibility(View.VISIBLE);
            customViewHolder.epic.setText("Name of Polling Station : " + pollings.get(i).getPollingStation().getName());
            customViewHolder.textView.setText("Facilities : " + pollings.get(i).getPollingStation().getFacilities());
            Picasso.get().load(pollings.get(i).getPollingStation().getImage()).into(customViewHolder.imageView);
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
