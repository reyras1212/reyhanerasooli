package com.example.falhafez;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class faal extends AppCompatActivity {

        TextView poetry, number;
        ImageView back;
        String random_string = "";
        TextView textView;

        ImageView again;





        @Override
        protected void onCreate(Bundle savedInstanceState) {


            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_fall);

            poetry = findViewById(R.id.textPoem);
            number = findViewById(R.id.textQazal);


            back=findViewById(R.id.imageView7);
            back.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(faal.this, MainActivity.class);
                    startActivity(intent);
                }
            });


            textView=findViewById(R.id.txt3);
            again = findViewById(R.id.imageView8);
            again.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    getFaal();

                }
            });




            getFaal();

            int random_string_length = 8;
            String[] all_characters = {
                    "از معشوق خود بیخبر و دلتنگ او هستی و درآرزوی دیدار او می باشی ،امیدوار با ش و از خداوند یاری بخواه که به مرادت می رسی.زیاد آه و ناله نکن که خدا کسانی را که ناراضی هستند دوست ندارد.\n" +
                            "\n.",
                    "از آنجایی که زندگی آرام داشته ای طاقت تحمل سختیها را نداری، اما بدان که اگر می خواهی به مقصود خود برسی باید رنج و مشقت بسیاری را تحمل نمایی. انسانهای بسیاری همچون تو در این راه قدم گذاشته اند و با صبر و بردباری به مقصود رسیده اند. ",
                    "روزهای خوبی در پیش رو خواهی داشت. به زودی اتفاقات بسیار مثبتی در زندگیت روی می دهد که زندگیت را رونقی تازه می بخشد. به یاری خدا درهای بسته به رویت گشوده خواهد شد. در حال حاضر صلاح نیست که کار خود را عوض کنی. به کار قبلی خود ادامه بده .",
                    "از گفته خودت در مورد دیگران ناراحت نشو وبدان که هرکس شایستگی آنرا ندارد که درمورد کارها ،کمالات و اخلاق شما نظر دهد پس هر گفته ای را جدی نگیر و به کار خود ادامه بده.",
                    "اگر قصد انجام این نیت را داری باید در مقابل مشکلات و سختی های این راه ناهموار صبر و تحمل داشته باشی و با شکیبایی قدم به قدم پیش بروی و بدان که هرچه انسانی دارای مقام و قدرت باشد، بدون یاری خدا از عهده هیچ کاری بر نخواهد آمد. پس به خدا توکل کن .",
                    "خبرهای بسیار خوشی درراه است که زندگی را به شما باز می گرداند ،هر چند کاری کرده اید که خود را مستوجب این شادی نمی دانید پس سعی کنید این اشتباه را تکرار نکنید .",
                    "ستاره اقبال به شما رو کرده سعی کن از این فرصت استفاده کنی.دل خود را از کینه ها و بدی ها خالی کن و به دنبال کارهای بیهوده و افکار باطل نرو که پشیمان خواهی شد ،دنبال کارها ی عاقلانه برو که نتیجه آنرا خواهی دید .",
                    "سختی هایت به پایان رسیده ،زمان خوشی و کامروائی در انتظارت است ،حالا تو خوب ارزش روزهای خوب را می فهمی پس تا وقت ازدست نرفته یادی از ضعفا کن و سعی کن آنها را در موفقیت خود سهیم کنی.\n" +
                            "\n .",
                    "عزیزی را از دست داده ای که می اندیشی هیچ کس در دنیا جای خالی او را برایت پر نمی کند و این موضوع تو را به شدت غمناک و بی تاب کرده است. فکر می کنی تمام زندگیت به او وابسته بود و اکنون که او رفته زندگی تو نیز فنا شده است. \n"
            };
            int all_characters_length = all_characters.length;

            int min = 0;
            int max = all_characters_length-1;



            Random r = new Random();
            int random_number = r.nextInt(max - min + 1) + min;
            String random_character = all_characters[random_number];
            random_string = random_string + random_character;












        }


        private void getFaal() {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(falapi.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            falapi falApi = retrofit.create(falapi.class);
            Call<modelfal> call = falApi.getFal();
            call.enqueue(new Callback<modelfal>() {
                @Override
                public void onResponse(Call<modelfal> call, Response<modelfal> response) {
                    if (response.isSuccessful()) {
                        modelfal faal = response.body();
                        number.setText(faal.getTitle());
                        poetry.setText(faal.getPlainText());
                        textView.setText(random_string);








                    }
                }

                @Override
                public void onFailure(Call<modelfal> call, Throwable t) {
                    Toast.makeText(faal.this, "Failed to get the Data from server", Toast.LENGTH_SHORT).show();
                }
            });
        }
}