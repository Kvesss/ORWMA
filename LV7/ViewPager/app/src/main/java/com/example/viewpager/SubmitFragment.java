package com.example.viewpager;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class SubmitFragment extends Fragment {

    EditText editText;
    Button btnSubmit;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_submit, container, false);
        ViewPager viewPager = getActivity().findViewById(R.id.viewPager);
        editText = (EditText)view.findViewById(R.id.etSubmit);
        btnSubmit = (Button)view.findViewById(R.id.btnSubmit);
        btnSubmit.setOnClickListener(v -> {
            viewPager.setCurrentItem(1);
            MessageFragment.displayMessage(editText.getText().toString());
            editText.setText("");
        });

        return view;
    }

    public static SubmitFragment newInstance(){
        return new SubmitFragment();

    }

}