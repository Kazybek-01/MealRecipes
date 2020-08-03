package com.example.mealrecipes;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MealAdapter extends RecyclerView.Adapter<MealAdapter.ExampleHolder>{

    List<Meal> mealList;
    Context context;
    RecyclerOnClickListener listener;

    public void setOnItemClickListener(RecyclerOnClickListener listener){
        this.listener = listener;
    }

    public MealAdapter(Context context,List<Meal> mealList){
        this.mealList = mealList;
        this.context = context;
    }

    @NonNull
    @Override
    public ExampleHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.example_item,parent,false);
        ExampleHolder holder = new ExampleHolder(view,listener);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ExampleHolder holder, int position) {
        holder.imageView.setImageResource(mealList.get(position).getMealImage());
        holder.textView1.setText(mealList.get(position).getMealName());
        holder.textView2.setText(mealList.get(position).getMealComposition());
        holder.textView3.setText(String.valueOf(mealList.get(position).getPrice()));
    }

    @Override
    public int getItemCount() {
        return mealList.size();
    }

    public static class ExampleHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView textView1;
        TextView textView2;
        TextView textView3;
        ImageButton buttonAdd;

        public ExampleHolder(@NonNull View itemView, final RecyclerOnClickListener listener) {
            super(itemView);

            imageView = itemView.findViewById(R.id.image);
            textView1 = itemView.findViewById(R.id.item);
            textView2 = itemView.findViewById(R.id.description);
            textView3 = itemView.findViewById(R.id.price);
            buttonAdd = itemView.findViewById(R.id.buttonAdd);

            buttonAdd.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    listener.onAddClick(position);
                    buttonAdd.setImageResource(R.drawable.ic_baseline_add_circle_24);
                }
            });

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    listener.onItemClick(position);
                }
            });
        }
    }
    public interface RecyclerOnClickListener{
        void onItemClick(int position);
        void onAddClick(int position);
    }
}
