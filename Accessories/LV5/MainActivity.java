package hr.ferit.lv4dk;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView tvShoeSize;
    Button btnCalc;
    EditText etEnterShoeSize;
    ImageView ivShoes;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        InitializeUI();
    }

    private void InitializeUI(){
        this.tvShoeSize = (TextView) findViewById(R.id.tvShoeSize);
        this.btnCalc = (Button) findViewById(R.id.btnCalc);
        this.etEnterShoeSize = (EditText) findViewById(R.id.etEnterShoeSize);
        this.ivShoes = (ImageView) findViewById(R.id.ivShoes);

        this.btnCalc.setOnClickListener(this);

        this.ivShoes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ivShoes.setVisibility(View.INVISIBLE);

            }
        });
    }

    @Override
    public void onClick(View v) {
        int shoeSize;
        shoeSize=Integer.parseInt(etEnterShoeSize.getText().toString());
        shoeSize=shoeSize/5;
        this.tvShoeSize.setText("Your US shoe size is: "+ shoeSize);

        Log.d("Test1", "Before toast msg");
        Toast.makeText(this, "Picture is hidden", Toast.LENGTH_LONG).show();
        Log.wtf("Test1", "Test after msg ");
    }
}