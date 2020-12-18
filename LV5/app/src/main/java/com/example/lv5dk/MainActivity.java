package com.example.lv5dk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private String[] quotes;
    ArrayList<TextView> descriptions;
    ArrayList<ImageView> imageViews;
    EditText enterNewDescription;
    ArrayList<RadioButton> people;
    Button inspiration, editDescription;
    RandomGenerator rand = RandomGenerator.getInstance();




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        InitializeUI();
        InitializeQuotes();
    }

    private void InitializeQuotes(){
        quotes = getResources().getStringArray(R.array.quotes);
    }

    private void InitializeUI(){
        this.descriptions = new ArrayList<TextView>();
        this.descriptions.add((TextView) findViewById(R.id.tv_row1_desc));
        this.descriptions.add((TextView) findViewById(R.id.tv_row2_desc));
        this.descriptions.add((TextView) findViewById(R.id.tv_row3_desc));
        this.imageViews = new ArrayList<ImageView>();
        this.imageViews.add((ImageView) findViewById(R.id.ivRow1));
        this.imageViews.add((ImageView) findViewById(R.id.ivRow2));
        this.imageViews.add((ImageView) findViewById(R.id.ivRow3));
        this.people = new ArrayList<RadioButton>();
        this.people.add((RadioButton) findViewById(R.id.radBtnFirst));
        this.people.add((RadioButton) findViewById(R.id.radBtnSecond));
        this.people.add((RadioButton) findViewById(R.id.radBtnThird));
        this.enterNewDescription = (EditText) findViewById(R.id.etEnterNewDescription);
        this.inspiration = (Button) findViewById(R.id.ButtonInspiration);
        this.editDescription = (Button) findViewById(R.id.btnEditDescription);
        this.inspiration.setOnClickListener(this);
        this.editDescription.setOnClickListener(this);
        for(ImageView image : imageViews){
            image.setOnClickListener(this);
        }



    }

    public void ToastQuote(String message){
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }

    public void ClearImage(ImageView image){
            image.setVisibility(View.INVISIBLE);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.ivRow1:
                ClearImage(imageViews.get(0));
                break;

            case R.id.ivRow2:
                ClearImage(imageViews.get(1));
                break;

            case R.id.ivRow3:
                ClearImage(imageViews.get(2));
                break;
            case R.id.ButtonInspiration:
                ToastQuote(quotes[rand.nextInt(quotes.length)]);
                break;
            case R.id.btnEditDescription:
                if(people.get(0).isChecked()){
                    descriptions.get(0).setText(enterNewDescription.getText());
                    enterNewDescription.setText("");
                }
                else if(people.get(1).isChecked()) {
                    descriptions.get(1).setText(enterNewDescription.getText());
                    enterNewDescription.setText("");
                }
                else if(people.get(2).isChecked()) {
                    descriptions.get(2).setText(enterNewDescription.getText());
                    enterNewDescription.setText("");
                }
                else

                    Toast.makeText(this, "Please choose a person", Toast.LENGTH_SHORT).show();
            default:
                break;
            }

        }

     

    }

