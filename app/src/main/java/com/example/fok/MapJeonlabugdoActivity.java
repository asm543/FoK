package com.example.fok;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MapJeonlabugdoActivity extends AppCompatActivity {


//국제무형유산영살축제 2489499
//완주 와일드푸드축제 1336591
//김제 지평선축제 574285
//필봉 GOOD 보러가세 2446507
//가을꽃잔치 - 고창228999
//순창 638241
//남원 1265305


    Button btn_jb1,btn_jb2,btn_jb3,btn_jb4,btn_jb5,btn_jb6,btn_jb7;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.map_jeonlabugdo);

        btn_jb1 = (Button)findViewById(R.id.btn_jb1);
        btn_jb2 = (Button)findViewById(R.id.btn_jb2);
        btn_jb3 = (Button)findViewById(R.id.btn_jb3);
        btn_jb4 = (Button)findViewById(R.id.btn_jb4);
        btn_jb5 = (Button)findViewById(R.id.btn_jb5);
        btn_jb6 = (Button)findViewById(R.id.btn_jb6);
        btn_jb7 = (Button)findViewById(R.id.btn_jb7);


        btn_jb1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                // 커스텀 리스트 뷰 창으로 이동
                Intent intent = new Intent(MapJeonlabugdoActivity.this,DetailActivity.class); // 지금 이 액티비티 이름.this 국제무형유산영살축제
                intent.putExtra("id","2489499");
                startActivity(intent);
            }
        });
        btn_jb2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                // 커스텀 리스트 뷰 창으로 이동
                Intent intent = new Intent(MapJeonlabugdoActivity.this,DetailActivity.class); // 지금 이 액티비티 이름.this 완주 와일드푸드축제
                intent.putExtra("id","574285");
                startActivity(intent);
            }
        });
        btn_jb3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                // 커스텀 리스트 뷰 창으로 이동
                Intent intent = new Intent(MapJeonlabugdoActivity.this,DetailActivity.class); // 지금 이 액티비티 이름.this 김제 지평선축제
                intent.putExtra("id","2446507");
                startActivity(intent);
            }
        });
        btn_jb4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                // 커스텀 리스트 뷰 창으로 이동
                Intent intent = new Intent(MapJeonlabugdoActivity.this,DetailActivity.class); // 지금 이 액티비티 이름.this 필봉 GOOD 보러가세
                intent.putExtra("id","2446507");
                startActivity(intent);
            }
        });
        btn_jb5.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                // 커스텀 리스트 뷰 창으로 이동
                Intent intent = new Intent(MapJeonlabugdoActivity.this,DetailActivity.class); // 지금 이 액티비티 이름.this 가을꽃잔치
                intent.putExtra("id","228999");
                startActivity(intent);
            }
        });
        btn_jb6.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                // 커스텀 리스트 뷰 창으로 이동
                Intent intent = new Intent(MapJeonlabugdoActivity.this,DetailActivity.class); // 지금 이 액티비티 이름.this 순창
                intent.putExtra("id","638241");
                startActivity(intent);
            }
        });
        btn_jb7.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                // 커스텀 리스트 뷰 창으로 이동
                Intent intent = new Intent(MapJeonlabugdoActivity.this,DetailActivity.class); // 지금 이 액티비티 이름.this 남원
                intent.putExtra("id","1265305");
                startActivity(intent);
            }
        });
    }
}
