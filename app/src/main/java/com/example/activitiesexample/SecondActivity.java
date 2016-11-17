package com.example.activitiesexample;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Intent intent = getIntent();
        String string_from_firstactivity = intent.getStringExtra("string_to_secondactivity");
        TextView textview = (TextView) findViewById(R.id.textView2);
        textview.setText(string_from_firstactivity);

        Button button = (Button) findViewById(R.id.button2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                EditText edittext = (EditText) findViewById(R.id.editText2);
                intent.putExtra("string_from_secondactivity", edittext.getText().toString());
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }

    public void onBackPressed() {
        Intent intent = new Intent();
        EditText edittext = (EditText) findViewById(R.id.editText2);
        intent.putExtra("string_from_secondactivity", edittext.getText().toString());
        setResult(RESULT_OK, intent);
        finish();
    }


}
