package com.example.fok;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MapMainActivity extends AppCompatActivity {

    Button btn_home,btnsearch,btn_back;
    EditText editText;

    Button map_main_gg, map_main_gw,map_main_cb,map_main_cn,map_main_jn,map_main_jb,map_main_gb,map_main_gn,map_main_jj;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.map_main);


        // 상단바 시작

        btn_home = (Button)findViewById(R.id.btn_home);
        btnsearch = (Button)findViewById(R.id.btnsearch);
        editText = (EditText)findViewById(R.id.editText);
        btn_back = (Button)findViewById(R.id.btn_back);


        btn_home.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                // 커스텀 리스트 뷰 창으로 이동
                Intent intent = new Intent(MapMainActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
        btn_back.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                // 커스텀 리스트 뷰 창으로 이동
                Intent intent = new Intent(MapMainActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
        btnsearch.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                // 커스텀 리스트 뷰 창으로 이동
                Intent intent = new Intent(MapMainActivity.this,ListViewActivity.class);
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



        // 상단바 끝

        map_main_gg = (Button)findViewById(R.id.map_main_gg);
        map_main_gw = (Button)findViewById(R.id.map_main_gw);
        map_main_cb = (Button)findViewById(R.id.map_main_cb);
        map_main_cn = (Button)findViewById(R.id.map_main_cn);
        map_main_jn = (Button)findViewById(R.id.map_main_jn);
        map_main_jb = (Button)findViewById(R.id.map_main_jb);
        map_main_gb = (Button)findViewById(R.id.map_main_gb);
        map_main_gn = (Button)findViewById(R.id.map_main_gn);
        map_main_jj = (Button)findViewById(R.id.map_main_jj);


        map_main_gg.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MapMainActivity.this,MapSeoulGyeonggidoActivity.class);
                startActivity(intent);
            }
        });
        map_main_gw.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MapMainActivity.this,MapGangwondoActivity.class);
                startActivity(intent);
            }
        });
        map_main_cb.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MapMainActivity.this,MapChungcheongbugdoActivity.class);
                startActivity(intent);
            }
        });
        map_main_cn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MapMainActivity.this,MapChungcheongnamdoActivity.class);
                startActivity(intent);
            }
        });
        map_main_jb.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MapMainActivity.this,MapJeonlabugdoActivity.class);
                startActivity(intent);
            }
        });
        map_main_jn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MapMainActivity.this,MapJeonlanamdoActivity.class);
                startActivity(intent);
            }
        });
        map_main_gb.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MapMainActivity.this,MapGyeongsangbugdoActivity.class);
                startActivity(intent);
            }
        });
        map_main_gn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MapMainActivity.this,MapGyeongsangnamdoActivity.class);
                startActivity(intent);
            }
        });
        map_main_jj.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MapMainActivity.this,MapJejudoActivity.class);
                startActivity(intent);
            }
        });
    }
}
