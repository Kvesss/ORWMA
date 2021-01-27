package com.example.viewpager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import java.util.List;

public class RecycleAdapter extends RecyclerView.Adapter<RecycleAdapter.NameViewHolder> {
    private List<String> dataList;
    private ButtonClickListener buttonClickListener;


    public RecycleAdapter(List<String> dataList, ButtonClickListener buttonClickListener) {
        this.dataList = dataList;
        this.buttonClickListener = buttonClickListener;
    }

    @NonNull
    @Override
    public NameViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View listItemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        return new NameViewHolder(listItemView, buttonClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull NameViewHolder holder, int position) {
        holder.setName(dataList.get(position));
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public void removeName(int position){
        if(dataList.size() > position){
            dataList.remove(position);
            notifyItemRemoved(position);
        }
    }

//    public void addData(List<String> dataList){
//        this.dataList.clear();
//        this.dataList.addAll(dataList);
//        notifyDataSetChanged();
//    }

    public void addNewName(String name){
        dataList.add(name);
        notifyItemInserted(dataList.size());
    }



    public static class NameViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private ButtonClickListener buttonClickListener;
        private final TextView textView;
        private final ImageButton buttonRemove;

        public NameViewHolder(@NonNull View itemView, ButtonClickListener buttonClickListener) {
            super(itemView);
            textView = itemView.findViewById(R.id.tvItemName);
            buttonRemove = itemView.findViewById(R.id.buttonRemove);
            this.buttonClickListener = buttonClickListener;
            buttonRemove.setOnClickListener(this);

        }

        public void setName(String name){
            textView.setText(name);
        }

        @Override
        public void onClick(View v) {
            buttonClickListener.onButtonClick(getAdapterPosition());
        }
    }
}
