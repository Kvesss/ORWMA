package com.example.viewpager;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class ModularFragment extends Fragment {

    private static final String KEY = "melon";
    private final String text;


    public ModularFragment(String KEY) {
        text = KEY;
    }

    public static ModularFragment newInstance(String KEY){
        return new ModularFragment(KEY);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        if(this.text == KEY){
            return inflater.inflate(R.layout.fragment_modular_alt, container, false);
        }
        else{
            return inflater.inflate(R.layout.fragment_modular, container, false);
        }

    }
}