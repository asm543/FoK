package com.example.fok;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MapChungcheongnamdoActivity extends FontActivity {

    //심훈상록문화제 1692948
    //천안흥타령춤축제 506935
    //홍성 140911
    //괴산 고추축제 1086249
    //보령 1093672
    //상월 고구마 축제 1087184

    Button btn_cn1,btn_cn2,btn_cn3,btn_cn4,btn_cn5,btn_cn6;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.map_chungcheongnamdo);

        btn_cn1 = (Button)findViewById(R.id.btn_cn1);
        btn_cn2 = (Button)findViewById(R.id.btn_cn2);
        btn_cn3 = (Button)findViewById(R.id.btn_cn3);
        btn_cn4 = (Button)findViewById(R.id.btn_cn4);
        btn_cn5 = (Button)findViewById(R.id.btn_cn5);
        btn_cn6 = (Button)findViewById(R.id.btn_cn6);


        btn_cn1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                // 커스텀 리스트 뷰 창으로 이동
                Intent intent = new Intent(MapChungcheongnamdoActivity.this,DetailActivity.class); // 지금 이 액티비티 이름.this 심훈상록문화제
                intent.putExtra("id","1692948");
                startActivity(intent);
            }
        });
        btn_cn2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                // 커스텀 리스트 뷰 창으로 이동
                Intent intent = new Intent(MapChungcheongnamdoActivity.this,DetailActivity.class); // 지금 이 액티비티 이름.this 천안흥타령
                intent.putExtra("id","506935");
                startActivity(intent);
            }
        });
        btn_cn3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                // 커스텀 리스트 뷰 창으로 이동
                Intent intent = new Intent(MapChungcheongnamdoActivity.this,DetailActivity.class); // 지금 이 액티비티 이름.this 홍성
                intent.putExtra("id","140911");
                startActivity(intent);
            }
        });
        btn_cn4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                // 커스텀 리스트 뷰 창으로 이동
                Intent intent = new Intent(MapChungcheongnamdoActivity.this,DetailActivity.class); // 지금 이 액티비티 이름.this 괴산고추축제
                intent.putExtra("id","1086249");
                startActivity(intent);
            }
        });
        btn_cn5.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                // 커스텀 리스트 뷰 창으로 이동
                Intent intent = new Intent(MapChungcheongnamdoActivity.this,DetailActivity.class); // 지금 이 액티비티 이름.this 보령
                intent.putExtra("id","1093672");
                startActivity(intent);
            }
        });
        btn_cn6.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                // 커스텀 리스트 뷰 창으로 이동
                Intent intent = new Intent(MapChungcheongnamdoActivity.this,DetailActivity.class); // 지금 이 액티비티 이름.this 상월고구마축제
                intent.putExtra("id","1087184");
                startActivity(intent);
            }
        });
    }
}
