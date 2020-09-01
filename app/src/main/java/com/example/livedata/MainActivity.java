package com.example.livedata;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public CustomViewModel customViewModel;
    public TextView displayTextView;
    public Button testButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        displayTextView =
                (TextView) findViewById(R.id.display_textview);

        testButton = (Button) findViewById(R.id.test_button);

        testButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // update customViewModel (i.e increments Livedata
                // value) when button is clicked
                updateLiveData();
            }
        });
        // holds instance of CustomViewModel
        customViewModel =
                ViewModelProviders
                        .of(this)
                        .get(CustomViewModel.class);
        // observes the livedata from customViewModel
        observeLiveData();
    }
    // updates livedata from customViewModel
    public void updateLiveData(){

        Integer value =  customViewModel
                .getLiveData()
                .getValue();


        if(null != value) {
            if (value >= 0) {
                customViewModel
                        .getLiveData()
                        .setValue(++value);
            }
        }

        if(null == value){
            customViewModel
                    .getLiveData()
                    .setValue(0);
        }
    }

    // observes livedata from current activity
    public void observeLiveData(){
        customViewModel.getLiveData().observe(this, new Observer<Integer>() {
                    @Override
                    public void onChanged(@Nullable Integer integer) {
                        displayTextView.setText(integer.toString());
                        Log.d("TAG", String.valueOf(displayTextView));
                    }
                });

    }
}