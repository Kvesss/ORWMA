package hr.ferit.lv6dk_recycleview;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.NameViewHolder> {
    private static final String TAG = "CustomAdapter";
    private List<String> dataList;
    private NameclickListener nameclickListener;

    public CustomAdapter(List<String> dataList, NameclickListener nameclickListener) {
        this.dataList = dataList;
        this.nameclickListener = nameclickListener;
    }

    @NonNull
        @Override
        public NameViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View listItemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
            return new NameViewHolder(listItemView, nameclickListener);
        }

        @Override
        public void onBindViewHolder(@NonNull NameViewHolder holder, int position) {
        Log.d(TAG, "Element"+ position + "set");
            holder.setName(dataList.get(position));
        }

        @Override
        public int getItemCount() {
            return dataList.size();
        }

        public void removeName(int position){
            if(dataList.size()>position){
                dataList.remove(position);
                notifyDataSetChanged();
            }
        }

        public static class NameViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
            private NameclickListener nameclickListener;
            private final TextView textView;
            public NameViewHolder(@NonNull View itemView, NameclickListener nameclickListener) {
                super(itemView);

                textView = itemView.findViewById(R.id.nameTextView);
                this.nameclickListener = nameclickListener;
                itemView.setOnClickListener(this);
            }

            public void setName(String name){
                textView.setText(name);
            }

            @Override
            public void onClick(View v) {
                nameclickListener.onNameClick(getAdapterPosition());
            }
        }
}
