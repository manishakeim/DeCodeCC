package com.example.manisha.decodecc.kyc;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.manisha.decodecc.R;
import com.example.manisha.decodecc.model.ApiObject;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class NewAdapter extends RecyclerView.Adapter<NewsViewHolder> {


    private Context context;

    private ArrayList<ApiObject> apiObjectList;

    public NewAdapter(Context context, ArrayList<ApiObject> apiObjects){
       this.context = context;
        this.apiObjectList =  apiObjects;
    }

    @NonNull
    @Override
    public NewsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent, false);
        return new NewsViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull NewsViewHolder holder, int position) {
        ApiObject apiObject = apiObjectList.get(position);
        holder.title.setText("Candidate Name: " + apiObject.getTitle());
        holder.description.setText(apiObject.getDescription());

        String image_url = apiObject.getSymbolUrl();
        String can_img_url = apiObject.getCanUrl();

        final String aff_url = apiObject.getAffidevit();


        if (image_url != null) {
            Picasso.get().load(image_url).resize(250, 180)
                    .into(holder.symbol);
        }

        if (can_img_url != null) {
            Picasso.get().load(can_img_url).resize(250, 350)
                    .into(holder.candImg);
        }


        holder.affidevit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, Affidavit.class);
                Bundle b = new Bundle();
                b.putString(Affidavit.ID, aff_url);
                intent.putExtras(b);
                context.startActivity(intent);
            }
        });


//        holder.castImage.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(mContext, CreditPageActivity.class);
//                Bundle b = new Bundle();
//                b.putString(CreditPageActivity.ID, movieCast.getId()+"");
//                intent.putExtras(b);
//                mContext.startActivity(intent);
//            }
//        });

    }

    @Override
    public int getItemCount() {
        return apiObjectList.size();
    }
}
