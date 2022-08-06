package com.example.rssreader.Cine;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.example.rssreader.FeedItem;
import com.example.rssreader.NewsDetails;
import com.example.rssreader.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by web on 25/05/2016.
 */
public class MyAdapterCine extends RecyclerView.Adapter<MyAdapterCine.MyViewHolder>{

    ArrayList<FeedItem> feedItems;
    Context context;
    public MyAdapterCine(Context context,ArrayList<FeedItem>feedItems){
        this.feedItems=feedItems;
        this.context=context;
    }

    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.custum_row_news_pdf,parent,false);
        MyViewHolder holder=new MyViewHolder(view);
        return holder;
    }

    public void onBindViewHolder(MyViewHolder holder, int position) {
        YoYo.with(Techniques.FadeIn).playOn(holder.cardView);
        final FeedItem current=feedItems.get(position);
        holder.Title.setText(current.getTitle());
        holder.Description.setText(current.getDescription());
        holder.Date.setText(current.getPubDate());
        Picasso.with(context).load(current.getThumbnailUrl()).into(holder.Thumbnail);
        holder.cardView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, NewsDetails.class);
                intent.putExtra("title", current.getTitle());
                intent.putExtra("link", current.getLink());
                intent.putExtra("description", current.getDescription());
                intent.putExtra("pubDate", current.getPubDate());
                intent.putExtra("thumb", current.getThumbnailUrl());
                intent.putExtra("content:encoded", current.getResumen());
                context.startActivity(intent);

            }
        });

    }


    public int getItemCount() {
        return feedItems.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView Title,Description,Date;
        ImageView Thumbnail;
        CardView cardView;
        public MyViewHolder(View itemView) {
            super(itemView);
            Title= (TextView) itemView.findViewById(R.id.title_text);
            Description= (TextView) itemView.findViewById(R.id.description_text);
            Date= (TextView) itemView.findViewById(R.id.date_text);
            Thumbnail= (ImageView) itemView.findViewById(R.id.thumb_img);
            cardView= (CardView) itemView.findViewById(R.id.cardview);
        }
    }
}
