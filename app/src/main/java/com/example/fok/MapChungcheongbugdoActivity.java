package com.example.fok;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MapChungcheongbugdoActivity extends AppCompatActivity {

    Button btn_cb1,btn_cb2,btn_cb3,btn_cb4,btn_cb5,btn_cb6,btn_cb7,btn_cb8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.map_chungcheongbugdo);

        btn_cb1 = (Button)findViewById(R.id.btn_cb1);
        btn_cb2 = (Button)findViewById(R.id.btn_cb2);
        btn_cb3 = (Button)findViewById(R.id.btn_cb3);
        btn_cb4 = (Button)findViewById(R.id.btn_cb4);
        btn_cb5 = (Button)findViewById(R.id.btn_cb5);
        btn_cb6 = (Button)findViewById(R.id.btn_cb6);
        btn_cb7 = (Button)findViewById(R.id.btn_cb7);
        btn_cb8 = (Button)findViewById(R.id.btn_cb8);

        //천등산고구마축제 1358252
        //우륵문화제 1358165
        //단양557329
        //증평 1365782
        //유기농페스티벌2619028
        //청원생명축제613316
        //고추축제141234
        //영동 포도축제142191

        btn_cb1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                // 커스텀 리스트 뷰 창으로 이동
                Intent intent = new Intent(MapChungcheongbugdoActivity.this,DetailActivity.class); // 지금 이 액티비티 이름.this 천등산고구마
                intent.putExtra("id","1358252");
                startActivity(intent);
            }
        });
        btn_cb2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                // 커스텀 리스트 뷰 창으로 이동
                Intent intent = new Intent(MapChungcheongbugdoActivity.this,DetailActivity.class); // 지금 이 액티비티 이름.this 우륵문화제
                intent.putExtra("id","1358165");
                startActivity(intent);
            }
        });
        btn_cb3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                // 커스텀 리스트 뷰 창으로 이동
                Intent intent = new Intent(MapChungcheongbugdoActivity.this,DetailActivity.class); // 지금 이 액티비티 이름.this 단양
                intent.putExtra("id","557329");
                startActivity(intent);
            }
        });
        btn_cb4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                // 커스텀 리스트 뷰 창으로 이동
                Intent intent = new Intent(MapChungcheongbugdoActivity.this,DetailActivity.class); // 지금 이 액티비티 이름.this 증평
                intent.putExtra("id","1365782");
                startActivity(intent);
            }
        });
        btn_cb5.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                // 커스텀 리스트 뷰 창으로 이동
                Intent intent = new Intent(MapChungcheongbugdoActivity.this,DetailActivity.class); // 지금 이 액티비티 이름.this 유기농페스티벌
                intent.putExtra("id","2619028");
                startActivity(intent);
            }
        });
        btn_cb6.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                // 커스텀 리스트 뷰 창으로 이동
                Intent intent = new Intent(MapChungcheongbugdoActivity.this,DetailActivity.class); // 지금 이 액티비티 이름.this 청원생명축제
                intent.putExtra("id","613316");
                startActivity(intent);
            }
        });
        btn_cb7.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                // 커스텀 리스트 뷰 창으로 이동
                Intent intent = new Intent(MapChungcheongbugdoActivity.this,DetailActivity.class); // 지금 이 액티비티 이름.this 고추축제
                intent.putExtra("id","141234");
                startActivity(intent);
            }
        });
        btn_cb8.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                // 커스텀 리스트 뷰 창으로 이동
                Intent intent = new Intent(MapChungcheongbugdoActivity.this,DetailActivity.class); // 지금 이 액티비티 이름.this 영동포도축제
                intent.putExtra("id","142191");
                startActivity(intent);
            }
        });



    }
}
