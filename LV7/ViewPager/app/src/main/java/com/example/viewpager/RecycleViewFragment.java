package com.example.viewpager;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class RecycleViewFragment extends Fragment implements ButtonClickListener{


    private RecyclerView recyclerView;
    private List<String> dataList;
    private RecycleAdapter recycleAdapter;
    private EditText enterName;
    private Button btnAdd;


    public static RecycleViewFragment newInstance(){
        return new RecycleViewFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_recycle_view, container, false);
        setupNames();
        setupRecyclerView(view);

        btnAdd = view.findViewById(R.id.btnAddButton);
        btnAdd.setOnClickListener(v -> {
            String name = enterName.getText().toString();
            String message = getResources().getString(R.string.toastMessage);
            if(name.matches(getResources().getString(R.string.empty))){
                Toast.makeText(getContext(),message,Toast.LENGTH_SHORT).show();

            }
            else {
                recycleAdapter.addNewName(name);
                enterName.setText(getResources().getString(R.string.empty));

            }
        });

        return view;

    }

    @Override
    public void onButtonClick(int position) {
            ((RecycleAdapter) Objects.requireNonNull(recyclerView.getAdapter())).removeName(position);
    }

    private void setupNames(){
        dataList = new ArrayList<>();
        dataList.add("Edgar Davids");
        dataList.add("Hernan Crespo");
        dataList.add("Andy Cole");
    }

    private void setupRecyclerView(View view) {
        recyclerView = view.findViewById(R.id.recycleView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recycleAdapter = new RecycleAdapter(dataList, this);
        recyclerView.setAdapter(recycleAdapter);
        enterName = (EditText)view.findViewById(R.id.enterName);
    }


}