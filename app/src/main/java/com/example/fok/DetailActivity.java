package com.example.fok;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Random;

public class DetailActivity extends FontActivity {

    public static final String MYKEY = "IPbBi9DbtpkIHLLYxiEdNhiPoe%2B2ZzZWPHoag%2FeAOimpSX%2FCAZW4%2FU8CmowZTEuFFzgXP3%2FRAuH%2FZYJQ2fQgxQ%3D%3D";
    TextView txt_detail;
    ImageView imgbtn_detail;
    EditText editText;

    String ContentID="";

    String createdtime = null, homepage = null, modifiedtime = null, tel = null, telname = null, title = null, firstimage = null; // 등록날짜,홈페이지주소, 수정날짜, 전화번호, 전화번호이름, 제목, 사진
    String addr1 = null, addr2 = null, zipcode = null, mapx = null, mapy = null, overview = null; //주소1, 주소2, 우편번호, x좌표, y좌표, 미리보기텍스트 // 공통정보 조회 쪽

    String agelimit = null, bookingplace = null, discountinfofestival = null, eventenddate = null, eventhomepage = null, eventplace = null, eventstartdate = null;
    String festivalgrade = null, placeinfo = null, playtime = null, program = null, spendtimefestival = null, sponsor1 = null;
    String sponsor1tel = null, sponsor2 = null, sponsor2tel = null, subevent = null, usetimefestival = null; // 소개정보 조회 쪽

    String infoname=null,infotext=null; // 반복정보 조회 쪽

    String originimgurl=null; //이미지정보 조회 부분

    String result = null;

    boolean increatedtime = false, inhomepage = false, inmodifiedtime = false, intel = false, intelname = false, intitle= false,infirstimage = false;
    boolean inaddr1= false, inaddr2 = false, inzipcode = false, inmapx = false, inmapy = false, inoverview = false; // 공통정보 조회 쪽

    boolean inagelimit = false, inbookingplace = false, indiscountinfofestival = false, ineventenddate = false, ineventhomepage = false, ineventplace= false,ineventstartdate = false;
    boolean infestivalgrade= false, inplaceinfo = false, inplaytime = false, inprogram = false, inspendtimefestival = false, insponsor1 = false;
    boolean insponsor1tel = false, insponsor2 = false, insponsor2tel= false, insubevent = false, inusetimefestival = false; //소개정보 조회 쪽

    boolean ininfoname=false,ininfotext=false; // 반복정보 조회 쪽

    boolean inoriginimgurl = false; // 이미지정보 조회 쪽

    Bitmap DetailBitmap;



    private String Parse_Data_Common() {

        try {
            URL url = new URL("http://api.visitkorea.or.kr/openapi/service/rest/KorService/detailCommon?ServiceKey="+MYKEY+"&contentId="+ContentID+"&defaultYN=Y&firstImageYN=Y&addrinfoYN=Y&mapinfoYN=Y&overviewYN=Y&MobileOS=ETC&MobileApp=FOK"
            );
            XmlPullParserFactory parserCreator = XmlPullParserFactory.newInstance();
            XmlPullParser parser = parserCreator.newPullParser();

            parser.setInput(new InputStreamReader(url.openStream(), "UTF-8"));

            int parserEvent = parser.getEventType();
            System.out.println("파싱시작합니다.");

            while (parserEvent != XmlPullParser.END_DOCUMENT) {
                switch (parserEvent) {
                    case XmlPullParser.START_TAG://parser가 시작 태그를 만나면 실행

                        if (parser.getName().equals("createdtime")) { // 주소
                            increatedtime = true;
                        }
                        if (parser.getName().equals("homepage")) { // 주소
                            inhomepage = true;
                        }
                        if (parser.getName().equals("modifiedtime")) { // 주소
                            inmodifiedtime = true;
                        }
                        if (parser.getName().equals("tel")) { // 주소
                            intel = true;
                        }
                        if (parser.getName().equals("telname")) { // 주소
                            intelname = true;
                        }
                        if (parser.getName().equals("title")) { // 주소
                            intitle = true;
                        }
                        if (parser.getName().equals("firstimage")) { // 주소
                            infirstimage = true;
                        }
                        if (parser.getName().equals("addr1")) { // 주소
                            inaddr1 = true;
                        }
                        if (parser.getName().equals("addr2")) { // 주소
                            inaddr2 = true;
                        }
                        if (parser.getName().equals("zipcode")) { // 주소
                            inzipcode = true;
                        }
                        if (parser.getName().equals("mapx")) { // 주소
                            inmapx = true;
                        }
                        if (parser.getName().equals("mapy")) { // 주소
                            inmapy = true;
                        }
                        if (parser.getName().equals("overview")) { // 주소
                            inoverview = true;
                        }

                        if (parser.getName().equals("message")) {
                            //오류시 메세지
                        }
                        break;

                    case XmlPullParser.TEXT://parser가 내용에 접근했을때

                        if (increatedtime) {
                            createdtime = parser.getText();
                            increatedtime = false;
                        }
                        if (inhomepage) {
                            homepage = parser.getText();
                            inhomepage = false;
                        }

                        if (inmodifiedtime) {
                            modifiedtime = parser.getText();
                            inmodifiedtime = false;
                        }

                        if (intel) {
                            tel = parser.getText();
                            intel = false;
                        }

                        if (intelname) {
                            telname = parser.getText();
                            intelname = false;
                        }

                        if (intitle) {
                            title = parser.getText();
                            intitle = false;
                        }

                        if (infirstimage) {
                            firstimage = parser.getText();
                            infirstimage = false;
                        }

                        if (inaddr1) {
                            addr1 = parser.getText();
                            inaddr1 = false;
                        }

                        if (inaddr2) {
                            addr2 = parser.getText();
                            inaddr2 = false;
                        }

                        if (inzipcode) {
                            zipcode = parser.getText();
                            inzipcode = false;
                        }

                        if (inmapx) {
                            mapx = parser.getText();
                            inmapx = false;
                        }

                        if (inmapy) {
                            mapy = parser.getText();
                            inmapy = false;
                        }

                        if (inoverview) {
                            overview = parser.getText();
                            inoverview = false;
                        }

                        break;
                    case XmlPullParser.END_TAG:
                        if (parser.getName().equals("item")) {

                        }
                        break;
                }
                parserEvent = parser.next();
            }

        } catch (Exception e) {

            e.printStackTrace();
        }


        return result;
    } //공통정보 조회
    private String Parse_Data_Intro() {

        try {
            URL url = new URL("http://api.visitkorea.or.kr/openapi/service/rest/KorService/detailIntro?ServiceKey="+ MYKEY + "&contentId="+ContentID + "&contentTypeId=15&MobileOS=ETC&MobileApp=FOK"
            );
            XmlPullParserFactory parserCreator = XmlPullParserFactory.newInstance();
            XmlPullParser parser = parserCreator.newPullParser();

            parser.setInput(new InputStreamReader(url.openStream(), "UTF-8"));

            int parserEvent = parser.getEventType();
            System.out.println("파싱시작합니다.");

            while (parserEvent != XmlPullParser.END_DOCUMENT) {
                switch (parserEvent) {
                    case XmlPullParser.START_TAG://parser가 시작 태그를 만나면 실행

                        if (parser.getName().equals("agelimit")) { // 주소
                            inagelimit = true;
                        }

                        if (parser.getName().equals("bookingplace")) { // 주소
                            inbookingplace = true;
                        }
                        if (parser.getName().equals("discountinfofestival")) { // 주소
                            indiscountinfofestival = true;
                        }
                        if (parser.getName().equals("eventenddate")) { // 주소
                            ineventenddate = true;
                        }
                        if (parser.getName().equals("eventstartdate")) { // 주소
                            ineventstartdate = true;
                        }
                        if (parser.getName().equals("eventhomepage")) { // 주소
                            ineventhomepage = true;
                        }
                        if (parser.getName().equals("eventplace")) { // 주소
                            ineventplace = true;
                        }
                        if (parser.getName().equals("festivalgrade")) { // 주소
                            infestivalgrade = true;
                        }
                        if (parser.getName().equals("placeinfo")) { // 주소
                            inplaceinfo = true;
                        }
                        if (parser.getName().equals("playtime")) { // 주소
                            inplaytime = true;
                        }
                        if (parser.getName().equals("program")) { // 주소
                            inprogram = true;
                        }
                        if (parser.getName().equals("spendtimefestival")) { // 주소
                            inspendtimefestival = true;
                        }
                        if (parser.getName().equals("sponsor1")) { // 주소
                            insponsor1 = true;
                        }
                        if (parser.getName().equals("sponsor1tel")) { // 주소
                            insponsor1tel = true;
                        }
                        if (parser.getName().equals("sponsor2")) { // 주소
                            insponsor2 = true;
                        }
                        if (parser.getName().equals("sponsor2tel")) { // 주소
                            insponsor2tel = true;
                        }
                        if (parser.getName().equals("subevent")) { // 주소
                            insubevent = true;
                        }
                        if (parser.getName().equals("usetimefestival")) { // 주소
                            inusetimefestival = true;
                        }


                        if (parser.getName().equals("message")) {
                            //오류시 메세지
                        }
                        break;

                    case XmlPullParser.TEXT://parser가 내용에 접근했을때

                        if (inagelimit) {
                            agelimit = parser.getText();
                            inagelimit = false;
                        }
                        if (inbookingplace) {
                            bookingplace = parser.getText();
                            inbookingplace = false;
                        }

                        if (indiscountinfofestival) {
                            discountinfofestival = parser.getText();
                            indiscountinfofestival = false;
                        }

                        if (ineventenddate) {
                            eventenddate = parser.getText();
                            ineventenddate = false;
                        }

                        if (ineventhomepage) {
                            eventhomepage = parser.getText();
                            ineventhomepage = false;
                        }

                        if (ineventplace) {
                            eventplace = parser.getText();
                            ineventplace = false;
                        }

                        if (ineventstartdate) {
                            eventstartdate = parser.getText();
                            ineventstartdate = false;
                        }

                        if (infestivalgrade) {
                            festivalgrade = parser.getText();
                            infestivalgrade = false;
                        }

                        if (inplaceinfo) {
                            placeinfo = parser.getText();
                            inplaceinfo = false;
                        }

                        if (inplaytime) {
                            playtime = parser.getText();
                            inplaytime = false;
                        }

                        if (inprogram) {
                            program = parser.getText();
                            inprogram = false;
                        }

                        if (inspendtimefestival) {
                            spendtimefestival = parser.getText();
                            inspendtimefestival = false;
                        }

                        if (insponsor1) {
                            sponsor1 = parser.getText();
                            insponsor1 = false;
                        }
                        if (insponsor1tel) {
                            sponsor1tel = parser.getText();
                            insponsor1tel = false;
                        }
                        if (insponsor2) {
                            sponsor2 = parser.getText();
                            insponsor2 = false;
                        }
                        if (insponsor2tel) {
                            sponsor2tel = parser.getText();
                            insponsor2tel = false;
                        }

                        if (insubevent) {
                            subevent = parser.getText();
                            insubevent = false;
                        }
                        if (inusetimefestival) {
                            usetimefestival = parser.getText();
                            inusetimefestival = false;
                        }

                        break;
                    case XmlPullParser.END_TAG:
                        if (parser.getName().equals("item")) {

                        }
                        break;
                }
                parserEvent = parser.next();
            }

        } catch (Exception e) {

            e.printStackTrace();
        }


        return result;
    } //소개정보 조회
    private String Parse_Data_Info() {

        try {
            URL url = new URL("http://api.visitkorea.or.kr/openapi/service/rest/KorService/detailInfo?ServiceKey="+MYKEY +"&contentId="+ContentID +"&contentTypeId=15&MobileOS=ETC&MobileApp=FOK"
            );
            XmlPullParserFactory parserCreator = XmlPullParserFactory.newInstance();
            XmlPullParser parser = parserCreator.newPullParser();

            parser.setInput(new InputStreamReader(url.openStream(), "UTF-8"));

            int parserEvent = parser.getEventType();
            System.out.println("파싱시작합니다.");

            while (parserEvent != XmlPullParser.END_DOCUMENT) {
                switch (parserEvent) {
                    case XmlPullParser.START_TAG://parser가 시작 태그를 만나면 실행

                        if (parser.getName().equals("infoname")) { // 주소
                            ininfoname = true;
                        }

                        if (parser.getName().equals("infotext")) { // 주소
                            ininfotext = true;
                        }

                        if (parser.getName().equals("message")) {
                            //오류시 메세지
                        }
                        break;

                    case XmlPullParser.TEXT://parser가 내용에 접근했을때

                        if (ininfoname) {
                            infoname = parser.getText();
                            ininfoname = false;
                        }
                        if (ininfotext) {
                            infotext = parser.getText();
                            ininfotext = false;
                        }

                        break;
                    case XmlPullParser.END_TAG:
                        if (parser.getName().equals("item")) {

                        }
                        break;
                }
                parserEvent = parser.next();
            }

        } catch (Exception e) {

            e.printStackTrace();
        }


        return result;
    } //반복정보 조회
    private String Parse_Data_Image() {

        try {
            URL url = new URL("http://api.visitkorea.or.kr/openapi/service/rest/KorService/detailImage?ServiceKey="+MYKEY +"&contentId="+ContentID +"&imageYN=Y&MobileOS=ETC&MobileApp=FOK"
            );
            XmlPullParserFactory parserCreator = XmlPullParserFactory.newInstance();
            XmlPullParser parser = parserCreator.newPullParser();

            parser.setInput(new InputStreamReader(url.openStream(), "UTF-8"));

            int parserEvent = parser.getEventType();
            System.out.println("파싱시작합니다.");

            while (parserEvent != XmlPullParser.END_DOCUMENT) {
                switch (parserEvent) {
                    case XmlPullParser.START_TAG://parser가 시작 태그를 만나면 실행

                        if (parser.getName().equals("originimgurl")) { // 주소
                            inoriginimgurl = true;
                        }
                        if (parser.getName().equals("message")) {
                            //오류시 메세지
                        }
                        break;
                    case XmlPullParser.TEXT://parser가 내용에 접근했을때

                        if (inoriginimgurl) {
                            originimgurl = parser.getText();
                            inoriginimgurl = false;
                        }
                        break;
                    case XmlPullParser.END_TAG:
                        if (parser.getName().equals("item")) {

                        }
                        break;
                }
                parserEvent = parser.next();
            }

        } catch (Exception e) {

            e.printStackTrace();
        }


        return result;
    } //이미지정보 조회

    public Bitmap bitmapFromUrl(final String sUrl) {

        Bitmap bitmap=null;
        System.out.println(sUrl);
        try {

            URL url = new URL(sUrl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setDoInput(true);
            conn.connect();

            InputStream is = conn.getInputStream();
            bitmap = BitmapFactory.decodeStream(is);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bitmap;
    } //미리보기 이미지 불러오기 메소드

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        if (savedInstanceState == null) {

            MainFragment mainFragment = new MainFragment();
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.mainFragment, mainFragment, "main")
                    .commit();
        }

        txt_detail = (TextView)findViewById(R.id.txt_detail);
        imgbtn_detail = (ImageView) findViewById(R.id.imgbtn_detail);
        editText = (EditText)findViewById(R.id.editText);

        Intent intent = new Intent(this.getIntent());
        ContentID = intent.getStringExtra("id");

        Thread DetailThread = new Thread() {
            @Override
            public void run() {
                // TODO Auto-generated method stub
                Parse_Data_Common();
                Parse_Data_Intro();//아래 메소드를 호출하여 XML data를 파싱해서 String 객체로 얻어오기
                Parse_Data_Info();
                Parse_Data_Image();

                DetailBitmap = bitmapFromUrl(firstimage);

                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        DetailThread.start();

        try {
            DetailThread.join();

            if (DetailBitmap != null) {
                imgbtn_detail.setImageBitmap(DetailBitmap);
                txt_detail.setText( "\n" + eventstartdate + " ~ " + eventenddate +"\n");
            } else {
                imgbtn_detail.setImageResource(R.drawable.ic_launcher_foreground);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } // 콘텐츠 코드로 데이터 불러오기

        editText.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                editText.setText("");
            }
        });
        editText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                editText.setText("");
            }
        });



    }
}
