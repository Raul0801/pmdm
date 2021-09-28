package com.example.holamundo01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private int result;
    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        TextView tv = findViewById(R.id.tv_result);
        Button bThrow = findViewById(R.id.bt_throw);
        Button bAct = findViewById(R.id.bt_activity);

        Toast.makeText(this, "Hey",Toast.LENGTH_LONG).show();

        findViewById(R.id.bt_throw).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                result = (int) (1 + Math.random()*6);
                tv.setText(String.valueOf(result));
                ((Button) view).setText(String.valueOf(result));
            }
        });

        findViewById(R.id.bt_activity).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent actKtIntent = new Intent(getApplicationContext(), MainActivityKotlin.class);
                startActivity(actKtIntent);
            }
        });
    }
}