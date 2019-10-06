package com.example.fok;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MapSeoulGyeonggidoActivity extends AppCompatActivity {


    //월미도 2495836
    //탑삭골길 2563119
    //포천 673949
    //막걸리페스티벌-가평 2039819
    //가로수길 2618874
    //용문산 993743
    //아인스월드 빛축제-부천 1906753
    //에버랜드 - 1728337
    //이천 설봉산 별빛 축제1057944

    Button btn_gg1,btn_gg2,btn_gg3,btn_gg4,btn_gg5,btn_gg6,btn_gg7,btn_gg8,btn_gg9;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.map_seoul_gyeonggido);


        btn_gg1 = (Button)findViewById(R.id.btn_gg1);
        btn_gg2 = (Button)findViewById(R.id.btn_gg2);
        btn_gg3 = (Button)findViewById(R.id.btn_gg3);
        btn_gg4 = (Button)findViewById(R.id.btn_gg4);
        btn_gg5 = (Button)findViewById(R.id.btn_gg5);
        btn_gg6 = (Button)findViewById(R.id.btn_gg6);
        btn_gg7 = (Button)findViewById(R.id.btn_gg7);
        btn_gg8 = (Button)findViewById(R.id.btn_gg8);
        btn_gg9 = (Button)findViewById(R.id.btn_gg9);


        btn_gg1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                // 커스텀 리스트 뷰 창으로 이동
                Intent intent = new Intent(MapSeoulGyeonggidoActivity.this,DetailActivity.class); // 지금 이 액티비티 이름.this 월미도
                intent.putExtra("id","2495836");
                startActivity(intent);
            }
        });
        btn_gg2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                // 커스텀 리스트 뷰 창으로 이동
                Intent intent = new Intent(MapSeoulGyeonggidoActivity.this,DetailActivity.class); // 지금 이 액티비티 이름.this 탑삭골길
                intent.putExtra("id","2563119");
                startActivity(intent);
            }
        });
        btn_gg3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                // 커스텀 리스트 뷰 창으로 이동
                Intent intent = new Intent(MapSeoulGyeonggidoActivity.this,DetailActivity.class); // 지금 이 액티비티 이름.this 포천
                intent.putExtra("id","673949");
                startActivity(intent);
            }
        });
        btn_gg4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                // 커스텀 리스트 뷰 창으로 이동
                Intent intent = new Intent(MapSeoulGyeonggidoActivity.this,DetailActivity.class); // 지금 이 액티비티 이름.this 막걸리페스티벌
                intent.putExtra("id","2039819");
                startActivity(intent);
            }
        });
        btn_gg5.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                // 커스텀 리스트 뷰 창으로 이동
                Intent intent = new Intent(MapSeoulGyeonggidoActivity.this,DetailActivity.class); // 지금 이 액티비티 이름.this 가로수길
                intent.putExtra("id","2618874");
                startActivity(intent);
            }
        });
        btn_gg6.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                // 커스텀 리스트 뷰 창으로 이동
                Intent intent = new Intent(MapSeoulGyeonggidoActivity.this,DetailActivity.class); // 지금 이 액티비티 이름.this 용문산
                intent.putExtra("id","993743");
                startActivity(intent);
            }
        });
        btn_gg7.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                // 커스텀 리스트 뷰 창으로 이동
                Intent intent = new Intent(MapSeoulGyeonggidoActivity.this,DetailActivity.class); // 지금 이 액티비티 이름.this 아인스월드 빛축제
                intent.putExtra("id","1906753");
                startActivity(intent);
            }
        });
        btn_gg8.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                // 커스텀 리스트 뷰 창으로 이동
                Intent intent = new Intent(MapSeoulGyeonggidoActivity.this,DetailActivity.class); // 지금 이 액티비티 이름.this 에버랜드
                intent.putExtra("id","1728337");
                startActivity(intent);
            }
        });
        btn_gg9.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                // 커스텀 리스트 뷰 창으로 이동
                Intent intent = new Intent(MapSeoulGyeonggidoActivity.this,DetailActivity.class); // 지금 이 액티비티 이름.this 이천 설봉산 별빛축제제
               intent.putExtra("id","1057944");
                startActivity(intent);
            }
        });

    }
}
