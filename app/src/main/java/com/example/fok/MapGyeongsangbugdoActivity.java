package com.example.fok;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MapGyeongsangbugdoActivity extends FontActivity {

    //울진 619676
    //문경오미자축제 621109
    //하회별신굿탈놀이 704189
    //LG드림 페스티벌 2428176
    //경주 국악여행 2611054
    //수산물페스티벌 2563968

    Button btn_gb1,btn_gb2,btn_gb3,btn_gb4,btn_gb5,btn_gb6;
    Button btn_map,btn_home,btn_back,btnsearch;
    EditText editText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.map_gyeongsangbugdo);

        btn_gb1 = (Button)findViewById(R.id.btn_gb1);
        btn_gb2 = (Button)findViewById(R.id.btn_gb2);
        btn_gb3 = (Button)findViewById(R.id.btn_gb3);
        btn_gb4 = (Button)findViewById(R.id.btn_gb4);
        btn_gb5 = (Button)findViewById(R.id.btn_gb5);
        btn_gb6 = (Button)findViewById(R.id.btn_gb6);


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
                Intent intent = new Intent(MapGyeongsangbugdoActivity.this,MapMainActivity.class);
                startActivity(intent);
            }
        });
        btn_home.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                // 커스텀 리스트 뷰 창으로 이동
                Intent intent = new Intent(MapGyeongsangbugdoActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
        btn_back.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                // 커스텀 리스트 뷰 창으로 이동
                Intent intent = new Intent(MapGyeongsangbugdoActivity.this,MapMainActivity.class);
                startActivity(intent);
            }
        });
        btnsearch.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                // 커스텀 리스트 뷰 창으로 이동
                Intent intent = new Intent(MapGyeongsangbugdoActivity.this,ListViewActivity.class);
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

        btn_gb1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                // 커스텀 리스트 뷰 창으로 이동
                Intent intent = new Intent( MapGyeongsangbugdoActivity.this,DetailActivity.class); // 지금 이 액티비티 이름.this 울진
                intent.putExtra("id","619676");
                startActivity(intent);
            }
        });
        btn_gb2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                // 커스텀 리스트 뷰 창으로 이동
                Intent intent = new Intent( MapGyeongsangbugdoActivity.this,DetailActivity.class); // 지금 이 액티비티 이름.this 문경오미자축제
                intent.putExtra("id","621109");
                startActivity(intent);
            }
        });
        btn_gb3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                // 커스텀 리스트 뷰 창으로 이동
                Intent intent = new Intent( MapGyeongsangbugdoActivity.this,DetailActivity.class); // 지금 이 액티비티 이름.this 하회별신굿탈놀이
                intent.putExtra("id","704189");
                startActivity(intent);
            }
        });
        btn_gb4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                // 커스텀 리스트 뷰 창으로 이동
                Intent intent = new Intent( MapGyeongsangbugdoActivity.this,DetailActivity.class); // 지금 이 액티비티 이름.this lg드림페스티벌
                intent.putExtra("id","2428176");
                startActivity(intent);
            }
        });
        btn_gb5.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                // 커스텀 리스트 뷰 창으로 이동
                Intent intent = new Intent( MapGyeongsangbugdoActivity.this,DetailActivity.class); // 지금 이 액티비티 이름.this 경주국악여행
                intent.putExtra("id","2611054");
                startActivity(intent);
            }
        });
        btn_gb6.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                // 커스텀 리스트 뷰 창으로 이동
                Intent intent = new Intent( MapGyeongsangbugdoActivity.this,DetailActivity.class); // 지금 이 액티비티 이름.this 수산물페스티벌
                intent.putExtra("id","2563968");
                startActivity(intent);
            }
        });
    }
}
