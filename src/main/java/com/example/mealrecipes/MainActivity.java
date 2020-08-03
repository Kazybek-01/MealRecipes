package com.example.mealrecipes;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<Meal> mealList;
    MealAdapter adapter;
    SecondAdapter secondAdapter;
    ImageView buttonAdd, imageView;
    List<Meal> mealsToFavorite = new ArrayList<>();
    TextView textView1;
    TextView textView2;
    TextView textView3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonAdd = findViewById(R.id.buttonAdd);
        textView1 = findViewById(R.id.item);
        textView2 = findViewById(R.id.description);
        textView3 = findViewById(R.id.price);
        imageView = findViewById(R.id.image);

        mealList = new ArrayList<>();
        mealList.add(new Meal(R.drawable.hamburger_png,"Гамбургер","Рубленый бифштекс из натуральной цельной говядины на карамелизованной булочке, заправленной горчицей, кетчупом, луком и кусочком маринованного огурчика.",60,"Бифштекс из говядины рубленый, приготовленный на гриле, Булочка для гамбургеров, поджаренная в тостере, Горчичный соус, Лук репчатый резаный восстановленный, Огурцы маринованные резанные,Приправа для гриля ","8,5 г","3,4 г","30 г","6,4 г","1,9 г","13 г","1,2 г", "12%","17%","12%","7%","-","26%","20%","253 ккал, 1063 кДж",1));
        mealList.add(new Meal(R.drawable.chburger,"Чизбургер","Рубленый бифштекс из натуральной цельной говядины с кусочками сыра «Чеддер» на карамелизованной булочке, заправленной горчицей, кетчупом, луком и кусочком маринованного огурчика.",70,"Бифштекс из говядины рубленый, приготовленный на гриле, Булочка для гамбургеров, поджаренная в тостере, Горчичный соус, Лук репчатый резаный восстановленный, Огурцы маринованные резанные, Плавленый сыр Чеддер, Приправа для гриля","12 г","6 г","31 г","6,9 г","1,9 г","16 г","1,6 г","18%","30%","12%","8%","-","31%","27%","302 ккал, 1266 кДж",1));
        mealList.add(new Meal(R.drawable.kartoshka_fri, "Картофель фри","Вкусные, обжаренные в растительном фритюре и слегка посоленные палочки картофеля.",50,"Картофель фри, Масло растительное фритюрное, Соль йодированная экстра","21 г","2 г","54 г","0,5 г","5,3 г","5,2 г","0,7 г", "29%","10%","21%","1%","-","10%","12%","434 ккал, 1815 кДж",1));
        mealList.add(new Meal(R.drawable.peperr,"Пепперони","Острая колбаса, салями, деликатес итало-американского происхождения с пряным, слегка копченым вкусом. У колбасы мелкая зернистость, мягкая текстура и ярко-красный цвет. Высококалорийный продукт. В классической рецептуре пепперони состоит на 30% из говядины и на 70% из свинины с различными специями и чесноком. Иногда в колбасу добавляют мясо птицы. Пепперони – самостоятельная закуска, а также популярный ингредиент пиццы, бутербродов, сэндвичей, яичницы. Нередко ее добавляют в салаты, супы, рагу.",290,"Пикантная пеперони, увеличенная порция моцареллы, томатный соус","11,23г","4,87г","31,46г","3,81г","1,5г","12,33г","-","37%","-","46%","-","-","18%","-","276 ккал 1155 кДж",1));
        mealList.add(new Meal(R.drawable.krylyshki_kfc,"Крылышки","Сочная, нежная курица в хрустящей панировке.",100,"Полуфабрикаты из мяса птицы замороженные «Стрипсы формованные»","12 г","1,8 г","23 г","1,8 г","0,2 г","17 г","1,7 г","18%","9%","9%","2%","-","34%","28%","270 ккал, 1131 кДж",1));
        mealList.add(new Meal(R.drawable.kebab,"Шаурма","Два приготовленных на огне бифштекса, свежие овощи, много соуса",120,"Лаваш тонкий, помидоры, огурцы, капуста, кетчуп, майонез, говядина, растительное масло","30 г","12 г","36 г","3,5 г","0,8 г","26 г","2,0 г","43%","61%","14%","4%","-","53%","34%","521 ккал, 2174 кДж",1));


        adapter = new MealAdapter(MainActivity.this,mealList);
        secondAdapter = new SecondAdapter(MainActivity.this,mealsToFavorite);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        adapter.setOnItemClickListener(new MealAdapter.RecyclerOnClickListener() {
            @Override
            public void onItemClick(int position) {
                Intent intent = new Intent(MainActivity.this, DetailsActivity.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("meal", mealList.get(position));
                intent.putExtras(bundle);
                startActivity(intent);

            }
            @Override
            public void onAddClick(int position) {
//                addMeal(position);
                orderProcess(position);
                adapter.notifyItemChanged(position);
            }
        });
    }
//    public void addMeal(int position){
//        mealsToFavorite.add(mealList.get(position));
//        adapter.notifyItemChanged(position);
//    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.item1) {
            Intent secondActivity = new Intent(MainActivity.this,FavoriteActivity.class);
            secondActivity.putExtra("meals", (Serializable) mealsToFavorite);
            startActivity(secondActivity);
        }
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.shoping_menu,menu);
        return true;
    }

    public void orderProcess(int position){
        Meal meal = mealList.get(position);
        int counter = 1;

        if(isAdded(meal.getMealName(),mealsToFavorite)){
            counter++;
            for(Meal m: mealsToFavorite){
                if(m.getMealName().equals(meal.getMealName())){
                    m.setCounter(counter);
                }
            }
        }
        else {
            mealsToFavorite.add(meal);
            Toast.makeText(this, "Вы успешно добавили товар в корзину!", Toast.LENGTH_SHORT).show();
        }

    }
    public boolean isAdded(String mealName, List<Meal> mealsToFavorite){
        for(Meal meal: mealsToFavorite){
            if(meal.getMealName().equals(mealName)){
                return true;
            }
        }
        return false;
    }

}
