package com.aug15.avinashchintareddy.eventbusdata;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.text.BreakIterator;

public class MainActivity extends AppCompatActivity {

    Button nextButton;
    TextView resEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        resEditText= (EditText) findViewById(R.id.editTextRes);
        nextButton = (Button) findViewById(R.id.buttonNext);



        EventBus.getDefault().register(this);

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, ChildActivity.class);
                startActivity(i);
            }
        });
    }


       // Register to the event
    @Subscribe
    public void myEvent(MyCustomevent myCustomevent){


        resEditText.setText(myCustomevent.getMyMessage());
    }


}
