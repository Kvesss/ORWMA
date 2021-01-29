package com.example.rest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private Call<List<Product>> apiCall;
    private EditText etProduct;
    private Button btnSearch;
    private RecycleAdapter recycleAdapter;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etProduct = findViewById(R.id.etProduct);
        btnSearch = findViewById(R.id.btnSearch);
        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!etProduct.getText().toString().equals("")){
                    String search = etProduct.getText().toString();
                    setupRecycler();
                    setApiCall(search);
                    etProduct.setText("");
                }
                else {
                    Toast.makeText(MainActivity.this, "Please enter a product", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }

    public void setupRecycler(){
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recycleAdapter = new RecycleAdapter();
        recyclerView.setAdapter(recycleAdapter);
    }

    void setApiCall(String search){
        apiCall = NetworkUtils.getApiInterface().getProducts(search);
        apiCall.enqueue(new Callback<List<Product>>() {
            @Override
            public void onResponse(Call<List<Product>> call, Response<List<Product>> response) {
                if(response.isSuccessful() && response.body() != null){
                    showProducts(response.body());
                }
            }

            @Override
            public void onFailure(Call<List<Product>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Call Failed", Toast.LENGTH_SHORT).show();

            }
        });
    }

    private void showProducts(List<Product> productList) {
        recycleAdapter.addProducts(productList);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(apiCall != null){
            apiCall.cancel();
        }
    }
}