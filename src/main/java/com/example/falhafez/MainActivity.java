package com.example.falhafez;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickFal(View v)
    {
        Intent intent1 = new Intent(this,
                faal.class);

        Bundle b = new Bundle();
        intent1.putExtra("bundle data", b);
        startActivity(intent1);
    }



    public void onClickPoet(View v)
    {
        Intent intent1 = new Intent(this,
                Activityshaer.class);

        Bundle b = new Bundle();
        intent1.putExtra("bundle data", b);
        startActivity(intent1);
    }
}