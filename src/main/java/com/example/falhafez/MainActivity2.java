package com.example.falhafez;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        ImageView imageView ;
        imageView=findViewById(R.id.imageView6);
        imageView.setOnClickListener(v -> {
            Intent i = new Intent(MainActivity2.this, faal.class);
            startActivity(i);


        });
    }
}


