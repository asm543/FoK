package com.example.fok;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MapGyeongsangnamdoActivity extends FontActivity {

    //거창한마당대축제 1798646
    //합천 1916715
    //울산-국제가요페스티벌  1937469
    //민속소싸움대회 2599144
    //감달진문학제 1374667
    //문화재야행 2551117
    //코스모스축제 2559210
    //다랭이마을 고성 1150297
    //부산 2530829

    Button btn_gn1,btn_gn2,btn_gn3,btn_gn4,btn_gn5,btn_gn6,btn_gn7,btn_gn8,btn_gn9;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.map_gyeongsangnamdo);

        btn_gn1 = (Button)findViewById(R.id.btn_gn1);
        btn_gn2 = (Button)findViewById(R.id.btn_gn2);
        btn_gn3 = (Button)findViewById(R.id.btn_gn3);
        btn_gn4 = (Button)findViewById(R.id.btn_gn4);
        btn_gn5 = (Button)findViewById(R.id.btn_gn5);
        btn_gn6 = (Button)findViewById(R.id.btn_gn6);
        btn_gn7 = (Button)findViewById(R.id.btn_gn7);
        btn_gn8 = (Button)findViewById(R.id.btn_gn8);
        btn_gn9 = (Button)findViewById(R.id.btn_gn9);

        btn_gn1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                // 커스텀 리스트 뷰 창으로 이동
                Intent intent = new Intent( MapGyeongsangnamdoActivity.this,DetailActivity.class); // 지금 이 액티비티 이름.this 거창한마당대축제
                intent.putExtra("id","1798646");
                startActivity(intent);
            }
        });
        btn_gn2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                // 커스텀 리스트 뷰 창으로 이동
                Intent intent = new Intent( MapGyeongsangnamdoActivity.this,DetailActivity.class); // 지금 이 액티비티 이름.this 합천
                intent.putExtra("id","1916715");
                startActivity(intent);
            }
        });
        btn_gn3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                // 커스텀 리스트 뷰 창으로 이동
                Intent intent = new Intent( MapGyeongsangnamdoActivity.this,DetailActivity.class); // 지금 이 액티비티 이름.this 울산-국제가요페스티벌
                intent.putExtra("id","1937469");
                startActivity(intent);
            }
        });
        btn_gn4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                // 커스텀 리스트 뷰 창으로 이동
                Intent intent = new Intent( MapGyeongsangnamdoActivity.this,DetailActivity.class); // 지금 이 액티비티 이름.this 민속소싸움대회
                intent.putExtra("id","2599144");
                startActivity(intent);
            }
        });
        btn_gn5.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                // 커스텀 리스트 뷰 창으로 이동
                Intent intent = new Intent( MapGyeongsangnamdoActivity.this,DetailActivity.class); // 지금 이 액티비티 이름.this 감달진문학제
                intent.putExtra("id","1374667");
                startActivity(intent);
            }
        });
        btn_gn6.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                // 커스텀 리스트 뷰 창으로 이동
                Intent intent = new Intent( MapGyeongsangnamdoActivity.this,DetailActivity.class); // 지금 이 액티비티 이름.this 문화재야행
                intent.putExtra("id","2551117");
                startActivity(intent);
            }
        });
        btn_gn7.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                // 커스텀 리스트 뷰 창으로 이동
                Intent intent = new Intent( MapGyeongsangnamdoActivity.this,DetailActivity.class); // 지금 이 액티비티 이름.this 코스모스축제
                intent.putExtra("id","2559210");
                startActivity(intent);
            }
        });
        btn_gn8.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                // 커스텀 리스트 뷰 창으로 이동
                Intent intent = new Intent( MapGyeongsangnamdoActivity.this,DetailActivity.class); // 지금 이 액티비티 이름.this 다랭이마을 고성
                intent.putExtra("id","1150297");
                startActivity(intent);
            }
        });
        btn_gn9.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                // 커스텀 리스트 뷰 창으로 이동
                Intent intent = new Intent( MapGyeongsangnamdoActivity.this,DetailActivity.class); // 지금 이 액티비티 이름.this 부산
                intent.putExtra("id","2530829");
                startActivity(intent);
            }
        });
    }
}
