package com.example.mealrecipes;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class SecondAdapter extends RecyclerView.Adapter<SecondAdapter.SecondHolder>{

    List<Meal> mealListFavorite;
    Context context;
    RecyclerOnClickListener recyclerOnClickListener;

    public void setOnItemClickListener(SecondAdapter.RecyclerOnClickListener recyclerOnClickListener) {
        this.recyclerOnClickListener = recyclerOnClickListener;
    }

    public SecondAdapter(Context context,List<Meal> mealListFavorite){
        this.mealListFavorite = mealListFavorite;
        this.context = context;
    }

    @NonNull
    @Override
    public SecondHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.example_item_second,parent,false);
        SecondHolder holder = new SecondHolder(view,recyclerOnClickListener);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull SecondHolder holder, int position) {
        holder.imageView.setImageResource(mealListFavorite.get(position).getMealImage());
        holder.textView1.setText(mealListFavorite.get(position).getMealName());
        holder.textView2.setText(mealListFavorite.get(position).getMealComposition());
        holder.textView3.setText(String.valueOf(mealListFavorite.get(position).getPrice()*mealListFavorite.get(position).getCounter()));
        holder.counter.setText(String.valueOf(mealListFavorite.get(position).getCounter()));
    }

    @Override
    public int getItemCount() {
        return mealListFavorite.size();
    }

    public static class SecondHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView textView1;
        TextView textView2;
        TextView textView3,counter;
        ImageView buttonDelete;

        public SecondHolder(@NonNull View itemView, final SecondAdapter.RecyclerOnClickListener recyclerOnClickListener) {
            super(itemView);

            imageView = itemView.findViewById(R.id.image);
            textView1 = itemView.findViewById(R.id.item);
            textView2 = itemView.findViewById(R.id.description);
            textView3 = itemView.findViewById(R.id.price);
            buttonDelete = itemView.findViewById(R.id.btnDelete);
            counter = itemView.findViewById(R.id.counter);

            buttonDelete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    recyclerOnClickListener.onDeleteClick(position);
                }
            });
        }
    }
    public interface RecyclerOnClickListener{
        void onDeleteClick(int position);
    }
}
