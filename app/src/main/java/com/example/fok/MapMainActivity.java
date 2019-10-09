package com.example.fok;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MapMainActivity extends FontActivity {

    Button map_main_gg, map_main_gw,map_main_cb,map_main_cn,map_main_jn,map_main_jb,map_main_gb,map_main_gn,map_main_jj;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.map_main);

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
