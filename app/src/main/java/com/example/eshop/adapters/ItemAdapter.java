package com.example.eshop.adapters;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.eshop.ItemPage;
import com.example.eshop.R;
import com.example.eshop.models.Item;

import java.util.List;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ItemViewHolder> {
    Context context;
    List<Item> items;

    public ItemAdapter(Context context, List<Item> items) {
        this.context = context;
        this.items = items;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemItems = LayoutInflater.from(context).inflate(R.layout.item_item, parent, false);
        return new ItemAdapter.ItemViewHolder(itemItems);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.itemBg.setCardBackgroundColor(Color.parseColor(items.get(position).getColor()));

        int imageId = context.getResources().getIdentifier(items.get(position).getImg(), "drawable", context.getPackageName());
        holder.itemImage.setImageResource(imageId);

        holder.itemTitle.setText(items.get(position).getTitle());
        holder.itemPrice.setText(items.get(position).getPrice());
        holder.itemLevel.setText(items.get(position).getLevel());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, ItemPage.class);
                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(
                        (Activity) context,
                        new Pair<View, String>(holder.itemImage, "itemImage")
                        );

                intent.putExtra("itemBg", Color.parseColor(items.get(position).getColor()));
                intent.putExtra("itemImage", imageId);
                intent.putExtra("itemTitle", items.get(position).getTitle());
                intent.putExtra("itemPrice", items.get(position).getPrice());
                intent.putExtra("itemLevel", items.get(position).getLevel());

                intent.putExtra("itemText", items.get(position).getText());

                intent.putExtra("itemId", items.get(position).getId());

                context.startActivity(intent, options.toBundle());
            }
        });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public static final class ItemViewHolder extends RecyclerView.ViewHolder {
        CardView itemBg;
        ImageView itemImage;
        TextView itemTitle, itemPrice, itemLevel;

        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);

            itemBg = itemView.findViewById(R.id.itemBg);
            itemImage = itemView.findViewById(R.id.itemImage);
            itemTitle = itemView.findViewById(R.id.itemTitle);
            itemPrice = itemView.findViewById(R.id.itemPrice);
            itemLevel = itemView.findViewById(R.id.itemLevel);
        }
    }
}
