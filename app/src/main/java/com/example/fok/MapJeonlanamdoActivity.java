package com.example.fok;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MapJeonlanamdoActivity extends FontActivity {


    //불갑산상화축제  1078905
    //나주풍류열전 2485814
    //순천 푸드아트 페스티벌 2485123
    //명량대첩축제 607417
    //보성 1805256
    //미남불꽃크루즈 2585645

    Button btn_jn1,btn_jn2,btn_jn3,btn_jn4,btn_jn5,btn_jn6;
    Button btn_map,btn_home,btn_back,btnsearch;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.map_jeonlanamdo);

        btn_jn1 = (Button)findViewById(R.id.btn_jn1);
        btn_jn2 = (Button)findViewById(R.id.btn_jn2);
        btn_jn3 = (Button)findViewById(R.id.btn_jn3);
        btn_jn4 = (Button)findViewById(R.id.btn_jn4);
        btn_jn5 = (Button)findViewById(R.id.btn_jn5);
        btn_jn6 = (Button)findViewById(R.id.btn_jn6);


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
                Intent intent = new Intent(MapJeonlanamdoActivity.this,MapMainActivity.class);
                startActivity(intent);
            }
        });
        btn_home.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                // 커스텀 리스트 뷰 창으로 이동
                Intent intent = new Intent(MapJeonlanamdoActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
        btn_back.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                // 커스텀 리스트 뷰 창으로 이동
                Intent intent = new Intent(MapJeonlanamdoActivity.this,MapMainActivity.class);
                startActivity(intent);
            }
        });
        btnsearch.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                // 커스텀 리스트 뷰 창으로 이동
                Intent intent = new Intent(MapJeonlanamdoActivity.this,ListViewActivity.class);
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


        btn_jn1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                // 커스텀 리스트 뷰 창으로 이동
                Intent intent = new Intent(MapJeonlanamdoActivity.this,DetailActivity.class); // 지금 이 액티비티 이름.this 불갑산상화축제
                intent.putExtra("id","1078905");
                startActivity(intent);
            }
        });
        btn_jn2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                // 커스텀 리스트 뷰 창으로 이동
                Intent intent = new Intent(MapJeonlanamdoActivity.this,DetailActivity.class); // 지금 이 액티비티 이름.this 나주풍류열전
                intent.putExtra("id","2485814");
                startActivity(intent);
            }
        });
        btn_jn3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                // 커스텀 리스트 뷰 창으로 이동
                Intent intent = new Intent(MapJeonlanamdoActivity.this,DetailActivity.class); // 지금 이 액티비티 이름.this 순천 푸드아트 페스티벌
                intent.putExtra("id","2485123");
                startActivity(intent);
            }
        });
        btn_jn4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                // 커스텀 리스트 뷰 창으로 이동
                Intent intent = new Intent(MapJeonlanamdoActivity.this,DetailActivity.class); // 지금 이 액티비티 이름.this 명량대첩축제
                intent.putExtra("id","607417");
                startActivity(intent);
            }
        });
        btn_jn5.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                // 커스텀 리스트 뷰 창으로 이동
                Intent intent = new Intent(MapJeonlanamdoActivity.this,DetailActivity.class); // 지금 이 액티비티 이름.this 보성
                intent.putExtra("id","1805256");
                startActivity(intent);
            }
        });
        btn_jn6.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                // 커스텀 리스트 뷰 창으로 이동
                Intent intent = new Intent(MapJeonlanamdoActivity.this,DetailActivity.class); // 지금 이 액티비티 이름.this 미남불꽃크루즈
                intent.putExtra("id","2585645");
                startActivity(intent);
            }
        });

    }
}
