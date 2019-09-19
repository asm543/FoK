package com.example.fok;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.os.Bundle;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {
    public static final String imgURL = "http://tong.visitkorea.or.kr/cms/resource/75/2396275_image2_1.jpg";
    private ProgressDialog progressDialog;
    ImageView imageView;
    Bitmap bitmap;

    public Bitmap bitmapFromUrl(final String sUrl){
     final Bitmap[] bitmap = new Bitmap[1];
     Thread mThread = new Thread(){
         @Override
         public void run(){
             try {
                 URL url = new URL(sUrl);
                 HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                 conn.setDoInput(true);
                 conn.connect();
                 InputStream is = conn.getInputStream();
                 bitmap[0] = BitmapFactory.decodeStream(is);
             }catch (IOException e){
                 e.printStackTrace();
             }
         }
     };
     mThread.start();
     try{
         mThread.join();
     } catch (InterruptedException e ){
         e.printStackTrace();
     }
     return bitmap[0];
    }

    public void  intoImageView(ImageView iv, Bitmap bitmap){

        if(bitmap != null){
            iv.setImageBitmap(bitmap);
        }
        else {
            iv.setImageResource(R.drawable.ic_launcher_foreground);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = (ImageView)findViewById(R.id.imageView);


        intoImageView(imageView,bitmapFromUrl(imgURL));
    }
}
