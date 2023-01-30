package com.example.eshop;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.eshop.models.Order;

public class ItemPage extends AppCompatActivity {
    ImageButton buy_butt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_page);

        ConstraintLayout itemBg = findViewById(R.id.itemPageBg);
        ImageView itemImage = findViewById(R.id.itemPageImage);
        TextView itemTitle = findViewById(R.id.itemPageTitle);
        TextView itemPrice = findViewById(R.id.itemPagePrice);
        TextView itemLevel = findViewById(R.id.itemPageLevel);
        TextView itemText = findViewById(R.id.itemPageText);

        itemBg.setBackgroundColor(getIntent().getIntExtra("itemBg", 0));
        itemImage.setImageResource(getIntent().getIntExtra("itemImage", 0));
        itemTitle.setText(getIntent().getStringExtra("itemTitle"));
        itemPrice.setText(getIntent().getStringExtra("itemPrice"));
        itemLevel.setText(getIntent().getStringExtra("itemLevel"));
        itemText.setText(getIntent().getStringExtra("itemText"));


        buy_butt = findViewById(R.id.addToCart);
        buy_butt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int item_id = getIntent().getIntExtra("itemId", 0);
                Order.items_id.add(item_id);
                Toast.makeText(getApplicationContext(), "Додано!", Toast.LENGTH_LONG).show();
            }
        });
    }
}