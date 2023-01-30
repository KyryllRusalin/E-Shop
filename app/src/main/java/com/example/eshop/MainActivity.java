package com.example.eshop;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.example.eshop.adapters.CaterogyAdapter;
import com.example.eshop.adapters.ItemAdapter;
import com.example.eshop.models.Category;
import com.example.eshop.models.Item;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView categoryRecycler, itemRecycler;
    CaterogyAdapter caterogyAdapter;
    static ItemAdapter itemAdapter;
    static List<Item> itemList = new ArrayList<>();
    static List<Item> fullItemList = new ArrayList<>();

    ImageView filter;
    ImageButton open_butt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        filter = findViewById(R.id.filterAll);
        filter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                itemList.clear();
                itemList.addAll(fullItemList);
                itemAdapter.notifyDataSetChanged();
            }
        });

        open_butt = findViewById(R.id.imageButton);
        open_butt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), OrderPage.class);
                startActivity(intent);
            }
        });


        List<Category> categoryList = new ArrayList<>();
        categoryList.add(new Category(1, "Плитоноски"));
        categoryList.add(new Category(2, "Каски"));
        categoryList.add(new Category(3, "Спорядження"));
        categoryList.add(new Category(4, "Інше"));

        setCategoryRecycler(categoryList);


        itemList.add(new Item(1, "armor", "Плитоноска (pro)", "10000", "4", "#424345", "Плитоноска, модульний чохол (MOLLE) для стандартних бронепластин з кишенями під магазини. Проста і надійна конструкція під пластини 25 см 30 см за доступною ціною. Колір - COYOTE (КОЙОТ). Тканина - Кордура 1000D + стропи MOLLLE підвищена міцність.", 1));
        itemList.add(new Item(2, "helmet", "Каска (pro)", "5000", "3", "#9FA52D", "Шолом тактичний FAST (ФАСТ) кевларовий радимо кожному, хто хоче придбати якісний захист. Ціна каски FAST кевларової (ФАСТ) найнижча, та річ однозначно варта того. Нова, сучасна модель, розрахована на використання у бойових умовах, витримує та захищає голову не тільки від ударів і падінь, а й від дрібних уламків, куль та їх рикошетів, переноситься у сумці тактичній.", 2));
        itemList.add(new Item(3, "backpack", "Рюкзак", "3000", "2", "#1e0bff", "Мисливці і рибалки воліють використовувати тактичний рюкзак, так як він має всі необхідні для цього якості. Рибалкам також підійде тактичний рюкзак, Ви зможете укомплектувати додатковими елементами використовуючи систему кріплення MOLLE. Тактичний рюкзак забезпечений нашитими панелями з липучки \"Velcro\", на які можна помістити нашвки, іменну смужку, світловідбивачі або прапор.", 3));
        itemList.add(new Item(4, "clock", "Годинник", "1500", "2", "#ffb11b", "Для мисливців, любителів риболовлі та працівників спецпідрозділів компанія створює надійні моделі, виконані у тактичному стилі. Вони стають надійними супутниками для тривалих завдань та подорожі, здатні витримати занурення під воду, стійкі до ударів і відмінно проявляють себе як щоденний помічник завдяки ряду функцій, які вони з легкістю виконують. Наявність якісного LED підсвічування.", 4));
        itemList.add(new Item(5, "helmet2", "Каска", "5000", "2", "#9FA52D", "Шолом тактичний FAST (ФАСТ) кевларовий радимо кожному, хто хоче придбати якісний захист. Ціна каски FAST кевларової (ФАСТ) найнижча, та річ однозначно варта того. Нова, сучасна модель, розрахована на використання у бойових умовах, витримує та захищає голову не тільки від ударів і падінь, а й від дрібних уламків, куль та їх рикошетів, переноситься у сумці тактичній.", 2));
        itemList.add(new Item(6, "armor2", "Плитоноска", "8000", "3", "#424345", "Плитоноска, модульний чохол (MOLLE) для стандартних бронепластин з кишенями під магазини. Проста і надійна конструкція під пластини 25 см 30 см за доступною ціною. Колір - COYOTE (КОЙОТ). Тканина - Кордура 1000D + стропи MOLLLE підвищена міцність.", 1));

        fullItemList.addAll(itemList);

        setItemRecycler(itemList);
    }

    private void setItemRecycler(List<Item> itemList) {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);

        itemRecycler = findViewById(R.id.itemRecycler);
        itemRecycler.setLayoutManager(layoutManager);

        itemAdapter = new ItemAdapter(this, itemList);
        itemRecycler.setAdapter(itemAdapter);
    }

    private void setCategoryRecycler(List<Category> categoryList) {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);

        categoryRecycler = findViewById(R.id.categoryRecycler);
        categoryRecycler.setLayoutManager(layoutManager);

        caterogyAdapter = new CaterogyAdapter(this, categoryList);
        categoryRecycler.setAdapter(caterogyAdapter);
    }

    public static void showItemsByCategory(int category) {
        itemList.clear();
        itemList.addAll(fullItemList);

        List<Item> filterItems = new ArrayList<>();

        for(Item it : itemList) {
            if(it.getCategory() == category)
                filterItems.add(it);
        }

        itemList.clear();
        itemList.addAll(filterItems);

        itemAdapter.notifyDataSetChanged();
    }

}