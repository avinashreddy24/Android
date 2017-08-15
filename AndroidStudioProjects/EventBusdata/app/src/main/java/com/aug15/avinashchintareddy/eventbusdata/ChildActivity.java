package com.aug15.avinashchintareddy.eventbusdata;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import org.greenrobot.eventbus.EventBus;

public class ChildActivity extends AppCompatActivity {
    EditText inputEditText;
    Button inpButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_child);

        inputEditText = (EditText) findViewById(R.id.editTextInp);
        inpButton = (Button) findViewById(R.id.button);

        inpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyCustomevent mc = new MyCustomevent();
                mc.setMyMessage(inputEditText.getText().toString());
                EventBus.getDefault().post(mc);

                finish();
            }
        });



    }
}
