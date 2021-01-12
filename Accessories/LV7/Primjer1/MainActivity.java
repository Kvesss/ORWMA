package hr.ferit.lv7_dk;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.os.Message;
import android.view.View;

public class MainActivity extends AppCompatActivity implements ButtonClickListener {

    private InputFragment inputFragment;
    private MessageFragment messageFragment;

    private FragmentManager fragmentManager;
    private boolean mSwitched = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragmentManager = getSupportFragmentManager();
        setupViews();
        setupFragments();
    }

    private void setupFragments() {
        inputFragment = new InputFragment();
        messageFragment = new MessageFragment();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.firstFragment, messageFragment);
        fragmentTransaction.add(R.id.secondFragment, inputFragment);
        fragmentTransaction.commit();

    }

    private void setupViews() {
        findViewById(R.id.btSwitch).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switchFragments();
            }
        });
    }

    private void switchFragments() {
        mSwitched = !mSwitched;
        removeFragments();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        if(mSwitched){
            fragmentTransaction.replace(R.id.firstFragment, inputFragment);
            fragmentTransaction.replace(R.id.secondFragment, messageFragment);
        }
        else{
            fragmentTransaction.replace(R.id.firstFragment, messageFragment);
            fragmentTransaction.replace(R.id.secondFragment, inputFragment);
        }
        fragmentTransaction.commit();
    }

    private void removeFragments() {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.remove(inputFragment);
        fragmentTransaction.remove(messageFragment);
        fragmentTransaction.commit();
        fragmentManager.executePendingTransactions();
    }

    @Override
    public void onButtonClick(String message) {
        messageFragment.displayMessage(message);
    }
}