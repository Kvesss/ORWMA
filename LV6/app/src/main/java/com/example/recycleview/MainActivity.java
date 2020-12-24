package com.example.recycleview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements ButtonClickListener {

    private RecyclerView recyclerView;
    private List<String> dataList;
    private CustomAdapter customAdapter;
    private EditText enterName;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupNames();
        setupRecyclerView();
        enterName = (EditText) findViewById(R.id.enterName);
    }

    @Override
    public void onButtonClick(int position) {
        ((CustomAdapter)recyclerView.getAdapter()).removeName(position);
    }

    private void setupNames(){
        dataList = new ArrayList<>();
        dataList.add("Edgar Davids");
        dataList.add("Hernan Crespo");
        dataList.add("Andy Cole");
    }

    private void setupRecyclerView(){
        recyclerView = findViewById(R.id.recycleView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        customAdapter = new CustomAdapter(dataList, this);
        recyclerView.setAdapter(customAdapter);

    }

//    public void removeName(View view){
//        customAdapter.removeName(0);
//    }

    public void addName(View view){
        String name = enterName.getText().toString();
        String message = getResources().getString(R.string.toastMessage);
        if(name.matches(getResources().getString(R.string.empty))){
            Toast.makeText(this,message,Toast.LENGTH_SHORT).show();

        }
        else {
            customAdapter.addNewName(name);
            enterName.setText(getResources().getString(R.string.empty));

        }
    }

}