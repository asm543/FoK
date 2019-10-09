package com.example.fok;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MapJejudoActivity extends AppCompatActivity {


    //금악마을 2561340
    //오라동 1803870
    //성산일출봉 141360
    //휴애리 핑크뮬리축제 2559560
    //유럽수국축제 2600763
    //허브동산별빛놀이 2444532

    Button btn_jj1,btn_jj2,btn_jj3,btn_jj4,btn_jj5,btn_jj6;
    Button btn_map,btn_home,btn_back,btnsearch;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.map_jejudo);

        btn_jj1 = (Button)findViewById(R.id.btn_jj1);
        btn_jj2 = (Button)findViewById(R.id.btn_jj2);
        btn_jj3 = (Button)findViewById(R.id.btn_jj3);
        btn_jj4 = (Button)findViewById(R.id.btn_jj4);
        btn_jj5 = (Button)findViewById(R.id.btn_jj5);
        btn_jj6 = (Button)findViewById(R.id.btn_jj6);


        // 상단바 , 검색 창  버튼 이벤트 시작
        btn_map = (Button)findViewById(R.id.btn_map);
        btn_home = (Button)findViewById(R.id.btn_home);
        btn_back = (Button)findViewById(R.id.btn_back);
        btnsearch = (Button)findViewById(R.id.btnsearch);
        editText = (EditText)findViewById(R.id.editText);



        btn_map.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                // 커스텀 리스트 뷰 창으로 이동
                Intent intent = new Intent(MapJejudoActivity.this,MapMainActivity.class);
                startActivity(intent);
            }
        });
        btn_home.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                // 커스텀 리스트 뷰 창으로 이동
                Intent intent = new Intent(MapJejudoActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
        btn_back.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                // 커스텀 리스트 뷰 창으로 이동
                Intent intent = new Intent(MapJejudoActivity.this,MapMainActivity.class);
                startActivity(intent);
            }
        });
        btnsearch.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                // 커스텀 리스트 뷰 창으로 이동
                Intent intent = new Intent(MapJejudoActivity.this,ListViewActivity.class);
                intent.putExtra("searchKeyword",editText.getText().toString());
                startActivity(intent);
            }
        });
        editText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                editText.setText("");
            }
        });



        // 상단바 , 검색 창 버튼 이벤트 끝

        btn_jj1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                // 커스텀 리스트 뷰 창으로 이동
                Intent intent = new Intent(MapJejudoActivity.this,DetailActivity.class); // 지금 이 액티비티 이름.this 금악마을
                intent.putExtra("id","2561340");
                startActivity(intent);
            }
        });
        btn_jj2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                // 커스텀 리스트 뷰 창으로 이동
                Intent intent = new Intent(MapJejudoActivity.this,DetailActivity.class); // 지금 이 액티비티 이름.this 오라동
                intent.putExtra("id","1803870");
                startActivity(intent);
            }
        });
        btn_jj3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                // 커스텀 리스트 뷰 창으로 이동
                Intent intent = new Intent(MapJejudoActivity.this,DetailActivity.class); // 지금 이 액티비티 이름.this 성산일출봉
                intent.putExtra("id","141360");
                startActivity(intent);
            }
        });
        btn_jj4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                // 커스텀 리스트 뷰 창으로 이동
                Intent intent = new Intent(MapJejudoActivity.this,DetailActivity.class); // 지금 이 액티비티 이름.this 핑크뮬리축제
                intent.putExtra("id","2559560");
                startActivity(intent);
            }
        });
        btn_jj5.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                // 커스텀 리스트 뷰 창으로 이동
                Intent intent = new Intent(MapJejudoActivity.this,DetailActivity.class); // 지금 이 액티비티 이름.this 유럽수국축제
                intent.putExtra("id","2600763");
                startActivity(intent);
            }
        });
        btn_jj6.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                // 커스텀 리스트 뷰 창으로 이동
                Intent intent = new Intent(MapJejudoActivity.this,DetailActivity.class); // 지금 이 액티비티 이름.this 허브동산별빛놀이
                intent.putExtra("id","2444532");
                startActivity(intent);
            }
        });
    }
}
