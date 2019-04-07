package com.example.manisha.decodecc.kyc;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.manisha.decodecc.R;
import com.makeramen.roundedimageview.RoundedImageView;

public class NewsViewHolder extends RecyclerView.ViewHolder {

    public TextView title;
    public TextView description;
    public ImageView symbol;
    public RoundedImageView candImg;
    public TextView affidevit;
    public NewsViewHolder(View itemView) {
        super(itemView);
        title = (TextView) itemView.findViewById(R.id.candName);
        description = (TextView) itemView.findViewById(R.id.partyName);
        symbol = (ImageView) itemView.findViewById(R.id.parImg);
        candImg = (RoundedImageView)itemView.findViewById(R.id.canImg);
        affidevit = (TextView)itemView.findViewById(R.id.affidevit);

    }
}
