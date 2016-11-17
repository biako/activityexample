package com.example.activitiesexample;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.service.carrier.CarrierService;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import static android.R.attr.data;

public class FirstActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        Button button = (Button) findViewById(R.id.button1);
        button.setOnClickListener(new View.OnClickListener() {
                                      @Override
                                      public void onClick(View v) {
                                          Intent intent = new Intent(FirstActivity.this, SecondActivity.class);
                                          EditText edittext = (EditText) findViewById(R.id.editText1);
                                          intent.putExtra("string_to_secondactivity", edittext.getText().toString());
                                          startActivityForResult(intent, 1);
                                      }
                                  }
        );
    }

    protected void onActivityResult(int requestCode, int ResultCode, Intent data) {
        switch (requestCode) {
            case 1:
                if (ResultCode == RESULT_OK) {
                    String string_to_firstactivity = data.getStringExtra("string_from_secondactivity");
                    TextView textview = (TextView) findViewById(R.id.textView1);
                    textview.setText(string_to_firstactivity);
                    break;
                }
            default:
        }

    }
}






