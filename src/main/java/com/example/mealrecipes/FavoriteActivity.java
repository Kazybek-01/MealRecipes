package com.example.mealrecipes;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class FavoriteActivity extends AppCompatActivity {

    List<Meal> mealListFavorite = new ArrayList<>();
    RecyclerView recyclerView;
    SecondAdapter secondAdapter;
    TextView emptyCart;
    TextView counter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorite);

        ActionBar actionBar = getSupportActionBar();  //стрелка назад
        actionBar.setDisplayHomeAsUpEnabled(true);

        recyclerView = findViewById(R.id.recyclerViewFavorite);
        emptyCart = findViewById(R.id.emptyCart);
        counter = findViewById(R.id.counter);
        Intent intent = getIntent();

        mealListFavorite = (List<Meal>) intent.getSerializableExtra("meals");
        secondAdapter = new SecondAdapter(this,mealListFavorite);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(secondAdapter);


        for(Meal meal: mealListFavorite){
            Log.i("MyTagFav",meal.getMealName());
        }

        secondAdapter.setOnItemClickListener(new SecondAdapter.RecyclerOnClickListener() {
            @Override
            public void onDeleteClick(int position) {
                removeItem(position);
            }
        });
    }
    public void removeItem(int position){
        mealListFavorite.remove(position);
        secondAdapter.notifyItemRemoved(position);
    }
}