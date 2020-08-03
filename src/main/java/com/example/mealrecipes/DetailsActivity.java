package com.example.mealrecipes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailsActivity extends AppCompatActivity {

    ImageView mealImage;
    TextView mealName, mealInfo, mealComposition, mealValueInfo, calory;
    TextView grammJir, grammNasJir, grammUglevod, grammSahar, grammKletchatka, grammBelki, grammSol;
    TextView procJir, procNasJir, procUglevod, procSahar, procKletchatka, procBelki, procSol;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mealImage = findViewById(R.id.mealImage);
        mealName = findViewById(R.id.mealName);
        mealInfo = findViewById(R.id.mealInfo);
        mealComposition = findViewById(R.id.mealComposition);
        mealValueInfo = findViewById(R.id.mealValueInfo);
        calory = findViewById(R.id.calory);

        grammJir = findViewById(R.id.gramJir);
        grammNasJir = findViewById(R.id.gramNasJ);
        grammUglevod = findViewById(R.id.gramUgl);
        grammSahar = findViewById(R.id.gramSahar);
        grammKletchatka = findViewById(R.id.gramKletch);
        grammBelki = findViewById(R.id.gramBelki);
        grammSol = findViewById(R.id.gramSol);

        procJir = findViewById(R.id.procJir);
        procNasJir = findViewById(R.id.procNasJir);
        procUglevod = findViewById(R.id.procUglev);
        procKletchatka = findViewById(R.id.procKletch);
        procSahar = findViewById(R.id.procSahar);
        procBelki = findViewById(R.id.procBelki);
        procSol = findViewById(R.id.procSol);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        Meal meal = (Meal) bundle.getSerializable("meal");
        mealImage.setImageResource(meal.getMealImage());
        mealName.setText(meal.getMealName());
        mealInfo.setText(meal.getMealInfo());
        mealComposition.setText(meal.getMealComposition());
        calory.setText(meal.getCalory());

        grammJir.setText(meal.getGrammJir());
        grammNasJir.setText(meal.getGrammNasJir());
        grammUglevod.setText(meal.getGrammUglevod());
        grammKletchatka.setText(meal.getGrammKletchatka());
        grammBelki.setText(meal.getGrammBelki());
        grammSahar.setText(meal.getGrammSahar());
        grammSol.setText(meal.getGrammSol());

        procJir.setText(meal.getProcJir());
        procNasJir.setText(meal.getProcNasJir());
        procUglevod.setText(meal.getProcUglevod());
        procKletchatka.setText(meal.getProcKletchatka());
        procBelki.setText(meal.getProcBelki());
        procSahar.setText(meal.getProcSahar());
        procSol.setText(meal.getProcSol());


    }
}