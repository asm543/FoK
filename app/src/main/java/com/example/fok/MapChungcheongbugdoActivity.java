package com.example.fok;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MapChungcheongbugdoActivity extends AppCompatActivity {

    Button btn_cb1,btn_cb2,btn_cb3,btn_cb4,btn_cb5,btn_cb6,btn_cb7;

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


        btn_cb1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                // 커스텀 리스트 뷰 창으로 이동
                Intent intent = new Intent(MapChungcheongbugdoActivity.this,DetailActivity.class); // 지금 이 액티비티 이름.this
                intent.putExtra("id","1235456");
                startActivity(intent);
            }
        });


    }
}
