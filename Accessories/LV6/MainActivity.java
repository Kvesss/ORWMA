package hr.ferit.lv6dk_recycleview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements NameclickListener{

    private RecyclerView recyclerView;
    private List<String> dataList;
    private CustomAdapter customAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupNames();
        setupRecyclerView();



    }

    private void setupNames(){
        dataList= new ArrayList<>();
        dataList.add("David");
        dataList.add("Filip");
        dataList.add("Laura");
        dataList.add("Matko");
        dataList.add("Ivan");
        dataList.add("Luka");
        dataList.add("Bishop");
        dataList.add("Tomo");
        dataList.add("Petar");
        dataList.add("Ana");
    }
    private void setupRecyclerView(){
        recyclerView=findViewById(R.id.recyclerView);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        customAdapter = new CustomAdapter(dataList, this);
        recyclerView.setAdapter(customAdapter);
    }


    @Override
    public void onNameClick(int position) {
        Log.d("onNameClick", "remove name"+ position);
        ((CustomAdapter)recyclerView.getAdapter()).removeName(position);
    }
}