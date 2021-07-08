package com.release.androidbatch2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MovieItemViewHolder> {

    private final List<MOviewMOdel> mOviewMOdels;
    private final Context mContext;

    public RecyclerAdapter(List<MOviewMOdel> mOviewMOdels, Context mContext) {
        this.mOviewMOdels = mOviewMOdels;
        this.mContext = mContext;
    }




    @NonNull
    @Override
    public MovieItemViewHolder onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {
        return new MovieItemViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull  RecyclerAdapter.MovieItemViewHolder holder, int position) {

        MOviewMOdel model = mOviewMOdels.get(position);

        if (position==0){
            holder.name.setTextColor(R.color.colorPrimaryDark);
        }

        holder.name.setText(model.getMovieName());
        holder.description.setText(model.getMovieDescription());
        holder.rating.setText("IMDB"+model.getMovieRating()+"/10");


    }

    @Override
    public int getItemCount() {
        return mOviewMOdels.size();
    }

    public  class  MovieItemViewHolder extends RecyclerView.ViewHolder{

        public ImageView image ;
        public TextView name, rating, description;

        public MovieItemViewHolder(@NonNull View itemView) {
            super(itemView);
            name= itemView.findViewById(R.id.moviewName);
            rating= itemView.findViewById(R.id.moviewRating);
            description= itemView.findViewById(R.id.movieSummary);
            image= itemView.findViewById(R.id.moviewImage);
        }
    }

}
