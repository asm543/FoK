package com.example.fok;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MapGangwondoActivity extends AppCompatActivity {

    //이디오피아길 2504008
    //설악문화제1718491
    //홍천 2553554
    //평창효석문화제 507635
    //횡성더덕축제 2027280
    //삼척2531480

    Button btn_gw1,btn_gw2,btn_gw3,btn_gw4,btn_gw5,btn_gw6;
    Button btn_map,btn_home,btn_back,btnsearch;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.map_gangwondo);

        btn_gw1 = (Button)findViewById(R.id.btn_gw1);
        btn_gw2 = (Button)findViewById(R.id.btn_gw2);
        btn_gw3 = (Button)findViewById(R.id.btn_gw3);
        btn_gw4 = (Button)findViewById(R.id.btn_gw4);
        btn_gw5 = (Button)findViewById(R.id.btn_gw5);
        btn_gw6 = (Button)findViewById(R.id.btn_gw6);

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
                Intent intent = new Intent(MapGangwondoActivity.this,MapMainActivity.class);
                startActivity(intent);
            }
        });
        btn_home.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                // 커스텀 리스트 뷰 창으로 이동
                Intent intent = new Intent(MapGangwondoActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
        btn_back.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                // 커스텀 리스트 뷰 창으로 이동
                Intent intent = new Intent(MapGangwondoActivity.this,MapMainActivity.class);
                startActivity(intent);
            }
        });
        btnsearch.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                // 커스텀 리스트 뷰 창으로 이동
                Intent intent = new Intent(MapGangwondoActivity.this,ListViewActivity.class);
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


        btn_gw1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                // 커스텀 리스트 뷰 창으로 이동
                Intent intent = new Intent( MapGangwondoActivity.this,DetailActivity.class); // 지금 이 액티비티 이름.this 이디오피아길
                intent.putExtra("id","2504008");
                startActivity(intent);
            }
        });
        btn_gw2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                // 커스텀 리스트 뷰 창으로 이동
                Intent intent = new Intent( MapGangwondoActivity.this,DetailActivity.class); // 지금 이 액티비티 이름.this 설악산문화제
                intent.putExtra("id","1718491");
                startActivity(intent);
            }
        });
        btn_gw3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                // 커스텀 리스트 뷰 창으로 이동
                Intent intent = new Intent( MapGangwondoActivity.this,DetailActivity.class); // 지금 이 액티비티 이름.this 홍천
                intent.putExtra("id","2553554");
                startActivity(intent);
            }
        });
        btn_gw4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                // 커스텀 리스트 뷰 창으로 이동
                Intent intent = new Intent( MapGangwondoActivity.this,DetailActivity.class); // 지금 이 액티비티 이름.this 평창효석
                intent.putExtra("id","507635");
                startActivity(intent);
            }
        });
        btn_gw5.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                // 커스텀 리스트 뷰 창으로 이동
                Intent intent = new Intent( MapGangwondoActivity.this,DetailActivity.class); // 지금 이 액티비티 이름.this 횡성더덕
                intent.putExtra("id","2027280");
                startActivity(intent);
            }
        });
        btn_gw6.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                // 커스텀 리스트 뷰 창으로 이동
                Intent intent = new Intent( MapGangwondoActivity.this,DetailActivity.class); // 지금 이 액티비티 이름.this 삼척
                intent.putExtra("id","2531480");
                startActivity(intent);
            }
        });
    }
}
