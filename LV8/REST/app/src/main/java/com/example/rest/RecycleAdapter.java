package com.example.rest;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class RecycleAdapter extends RecyclerView.Adapter<RecycleAdapter.ViewHolder> {

    private final List<Product> productList = new ArrayList<>();


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_product, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.setupProduct(productList.get(position));

    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

    public void addProducts(List<Product> productList){
        this.productList.clear();
        this.productList.addAll(productList);
        notifyDataSetChanged();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder{

        private final ImageView image;
        private final TextView name;
        private final TextView price;
        private final TextView rating;
        private final TextView description;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.imageProduct);
            name = itemView.findViewById(R.id.tvName);
            price = itemView.findViewById(R.id.tvPrice);
            rating = itemView.findViewById(R.id.tvRating);
            description = itemView.findViewById(R.id.tvDescription);
        }

        public void setupProduct(Product product){


            //Glide.with(itemView).load(product.getImageURL()).into(image);
            Picasso.get().load(product.getImage_link()).into(image);
            name.setText("Name: "+ product.getName());
            price.setText( product.getPrice() != null ? "Price: "+ product.getPrice() : "Price: unknown");
            rating.setText( product.getRating() != null ? "Rating: "+ product.getRating() : "Rating: /");
            product.setDescription(product.getDescription().replaceAll("\n" , ""));
            description.setText( product.getDescription() != null ? product.getDescription() : "Description: ");


        }

    }
}


