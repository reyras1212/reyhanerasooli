package com.example.falhafez;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Activityshaer extends AppCompatActivity {


           RecyclerView recyclerView;
           List<poets> poetsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_poet);
        recyclerView=findViewById(R.id.RecyclerView);
        poetsList=new ArrayList<>();

              Retrofit retrofit=new Retrofit.Builder().baseUrl("https://ganjgah.ir/")
               .addConverterFactory(GsonConverterFactory.create()).build();
       shaerapi myapicall=retrofit.create(shaerapi.class);
       Call <List<poets>> call=myapicall.getData();
       call.enqueue(new Callback<List<poets>>() {
           @Override
           public void onResponse(Call<List<poets>> call, Response<List<poets>> response) {
               if (response.code()!=200) {
                   return;
               }
               List<poets> poet= response.body();
               for (poets poetss : poet){
                   poetsList.add(poetss);
               }
               PutDataIntoRecyclerView(poetsList);
           }

           @Override
           public void onFailure(Call<List<poets>> call, Throwable t) {

           }
       });


       }

    private void PutDataIntoRecyclerView(List<poets> poetsList) {
        Adaptershaer adapterrv=new Adaptershaer(this,poetsList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapterrv);

    }


    public void onClickBack(View v)
    {
        Intent intent2 = new Intent(this,
                MainActivity.class);

        Bundle b = new Bundle();
        intent2.putExtra("bundle data", b);
        startActivity(intent2);
    }
}