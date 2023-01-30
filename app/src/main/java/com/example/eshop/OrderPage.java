package com.example.eshop;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.eshop.models.Item;
import com.example.eshop.models.Order;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class OrderPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_page);

        int i = 0;

        ListView orders_list = findViewById(R.id.orders_list);

        List<String> itemsTitle = new ArrayList<>();

        for(Item it : MainActivity.fullItemList) {
            for(int id : Order.items_id) {
                if(id == it.getId()) {
                    itemsTitle.add(it.getTitle());
                    i = Collections.frequency(itemsTitle, it.getTitle());
                }
            }
            if(i > 1) {
                Iterator<String> itemIterator = itemsTitle.iterator();//создаем итератор
                while(itemIterator.hasNext()) {//до тех пор, пока в списке есть элементы

                    String nextItem = itemIterator.next();//получаем следующий элемент
                    if (nextItem.equals(it.getTitle())) {
                        itemIterator.remove();//удаляем с нужным именем
                    }
                }

                itemsTitle.add(it.getTitle() + " x " + i);
                i = 0;
            }
        }

        orders_list.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, itemsTitle));
    }
}