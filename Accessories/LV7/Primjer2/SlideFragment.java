package hr.ferit.lv3_dk_2;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class SlideFragment extends Fragment {

    private static final String KEY = "display_message";

    private TextView mMessageTextView;

    public static SlideFragment newInstance(String message){
        SlideFragment fragment = new SlideFragment();
        Bundle args = new Bundle();
        args.putString(KEY, message);
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_slide, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mMessageTextView = view.findViewById(R.id.tvMessage);
        setupTextView();
    }

    private void setupTextView() {
        String message = "Hello World!";
        if(getArguments() != null){
            String argMessage = getArguments().getString(KEY);
            if(argMessage != null && !argMessage.isEmpty()){
                message = argMessage;
            }
        }
        mMessageTextView.setText(message);
    }
}