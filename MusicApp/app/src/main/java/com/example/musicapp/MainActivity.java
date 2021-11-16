package com.example.musicapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btnEnter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnEnter = findViewById(R.id.btn_enter);
        btnEnter.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent in = new Intent(MainActivity.this, MusicActivity.class);
                startActivity(in);
            }
        });
    }
}
