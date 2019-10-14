package com.example.fok;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
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

public class DetailActivity2 extends FontActivity {

    public static final String MYKEY = "IPbBi9DbtpkIHLLYxiEdNhiPoe%2B2ZzZWPHoag%2FeAOimpSX%2FCAZW4%2FU8CmowZTEuFFzgXP3%2FRAuH%2FZYJQ2fQgxQ%3D%3D";
    TextView txt_title,txt_what,txt_start;
    ImageView imgbtn_detail;
    EditText editText;
    Button btn_map,btn_home,btn_back,btnsearch;
    TextView txt_detail_title1,txt_detail_title2,txt_detail_title3,txt_detail_where1,txt_detail_where2,txt_detail_where3,txt_detail_date1,txt_detail_date2,txt_detail_date3;
    ImageButton imgbtn_detail_hot1,imgbtn_detail_hot2,imgbtn_detail_hot3;


    Bitmap  detailBitmap1, detailBitmap2, detailBitmap3;

    String ContentID="";
    String contentid = "";

    String createdtime = null, homepage = null, modifiedtime = null, tel = null, telname = null, title = null, firstimage = null, DetailImage = null; // 등록날짜,홈페이지주소, 수정날짜, 전화번호, 전화번호이름, 제목, 사진
    String addr1 = null, addr2 = null, zipcode = null;
    public String mapx = null, mapy = null, overview = null; //주소1, 주소2, 우편번호, x좌표, y좌표, 미리보기텍스트 // 공통정보 조회 쪽

    String agelimit = null, bookingplace = null, discountinfofestival = null, eventenddate = null, eventhomepage = null, eventplace = null, eventstartdate = null;
    String festivalgrade = null, placeinfo = null, playtime = null, program = null, spendtimefestival = null, sponsor1 = null;
    String sponsor1tel = null, sponsor2 = null, sponsor2tel = null, subevent = null, usetimefestival = null; // 소개정보 조회 쪽

    String infoname=null,infotext=null;
    String[] info = new String[3];// 반복정보 조회 쪽

    String originimgurl=null; //이미지정보 조회 부분

    String result = null;

    String[] detailthumbnail1 = new String[6];
    String[] detailthumbnail2 = new String[6];
    String[] detailthumbnail3 = new String[6];

    boolean incontentid = false;

    boolean increatedtime = false, inhomepage = false, inmodifiedtime = false, intel = false, intelname = false, intitle= false,infirstimage = false, inDetailImage=false;
    boolean inaddr1= false, inaddr2 = false, inzipcode = false, inmapx = false, inmapy = false, inoverview = false; // 공통정보 조회 쪽

    boolean inagelimit = false, inbookingplace = false, indiscountinfofestival = false, ineventenddate = false, ineventhomepage = false, ineventplace= false,ineventstartdate = false;
    boolean infestivalgrade= false, inplaceinfo = false, inplaytime = false, inprogram = false, inspendtimefestival = false, insponsor1 = false;
    boolean insponsor1tel = false, insponsor2 = false, insponsor2tel= false, insubevent = false, inusetimefestival = false; //소개정보 조회 쪽

    boolean ininfoname=false,ininfotext=false; // 반복정보 조회 쪽

    boolean inoriginimgurl = false; // 이미지정보 조회 쪽

    Bitmap DetailBitmap;



    private String Parse_Data_detailrandom() {
        result = "";
        int randomNum = 1;
        Random random = new Random();
        randomNum = random.nextInt(10) + 1;
        String areaCode = ""+randomNum;
        String nowYear = "2019";
        try {
            URL url = new URL("http://api.visitkorea.or.kr/openapi/service/rest/KorService/searchFestival?serviceKey=" + MYKEY + "&numOfRows=3&pageNo=1&MobileOS=ETC&MobileApp=FoK&arrange=Q&listYN=Y&eventStartDate=" + nowYear + "0101&eventEndDate=" + nowYear + "1231&areaCode=" +areaCode
            );
            XmlPullParserFactory parserCreator = XmlPullParserFactory.newInstance();
            XmlPullParser parser = parserCreator.newPullParser();

            parser.setInput(new InputStreamReader(url.openStream(), "UTF-8"));

            int parserEvent = parser.getEventType();
            System.out.println("파싱시작합니다.");

            while (parserEvent != XmlPullParser.END_DOCUMENT) {
                switch (parserEvent) {
                    case XmlPullParser.START_TAG://parser가 시작 태그를 만나면 실행

                        if (parser.getName().equals("addr1")) { // 주소
                            inaddr1 = true;
                        }
                        if (parser.getName().equals("contentid")) { // 주소
                            incontentid = true;
                        }
                        if (parser.getName().equals("eventstartdate")) { // 주소
                            ineventstartdate = true;
                        }
                        if (parser.getName().equals("eventenddate")) { // 주소
                            ineventenddate = true;
                        }
                        if (parser.getName().equals("firstimage")) { // 주소
                            inDetailImage = true;
                        }
                        if (parser.getName().equals("title")) { // 주소
                            intitle = true;
                        }


                        if (parser.getName().equals("message")) {
                            txt_detail_title1.setText("정보 불러오기 실패! 다시 시도해주세요.");
                            txt_detail_title2.setText("정보 불러오기 실패! 다시 시도해주세요.");
                            txt_detail_title3.setText("정보 불러오기 실패! 다시 시도해주세요.");
                            txt_detail_date1.setText("");
                            txt_detail_date2.setText("");
                            txt_detail_date3.setText("");
                            txt_detail_where1.setText("");
                            txt_detail_where2.setText("");
                            txt_detail_where2.setText("");

                        }
                        break;
                    case XmlPullParser.TEXT://parser가 내용에 접근했을때

                        if (inaddr1) {
                            addr1 = parser.getText();
                            inaddr1 = false;
                        }
                        if (incontentid) {
                            contentid = parser.getText();
                            incontentid = false;
                        }

                        if (increatedtime) {
                            createdtime = parser.getText();
                            increatedtime = false;
                        }

                        if (ineventstartdate) {
                            eventstartdate = parser.getText();
                            ineventstartdate = false;
                        }

                        if (ineventenddate) {
                            eventenddate = parser.getText();
                            ineventenddate = false;
                        }

                        if (inDetailImage) {
                            DetailImage = parser.getText();
                            inDetailImage = false;
                        }
                        if (intitle) {
                            title = parser.getText();
                            intitle = false;
                        }

                        break;
                    case XmlPullParser.END_TAG:
                        if (parser.getName().equals("item")) {
                            if (detailthumbnail1[0] == null) {
                                detailthumbnail1[0] = DetailImage;
                                detailthumbnail1[1] = title;
                                detailthumbnail1[2] = addr1;
                                detailthumbnail1[3] = eventstartdate;
                                detailthumbnail1[4] = eventenddate;
                                detailthumbnail1[5] = contentid;

//                                        textView.setText(seasonthumbnailContentid + seasonthumbnailImage + seasonthumbnailTitle);
//                                        intoImageView(seasonthumbnailImage,button1);
                            } else if (detailthumbnail2[0] == null) {
                                detailthumbnail2[0] = DetailImage;
                                detailthumbnail2[1] = title;
                                detailthumbnail2[2] = addr1;
                                detailthumbnail2[3] = eventstartdate;
                                detailthumbnail2[4] = eventenddate;
                                detailthumbnail2[5] = contentid;
//                                        textView.setText(seasonthumbnailContentid2 + seasonthumbnailImage2 + seasonthumbnailTitle2);
//                                        intoImageView(seasonthumbnailImage2,button2);
                            } else if (detailthumbnail3[0] == null) {
                                detailthumbnail3[0] = DetailImage;
                                detailthumbnail3[1] = title;
                                detailthumbnail3[2] = addr1;
                                detailthumbnail3[3] = eventstartdate;
                                detailthumbnail3[4] = eventenddate;
                                detailthumbnail3[5] = contentid;
//                                        textView.setText(seasonthumbnailContentid3 + seasonthumbnailImage3 + seasonthumbnailTitle3);
//                                        intoImageView(seasonthumbnailImage3,button3);
                            }
                        }
                        break;
                }
                parserEvent = parser.next();
            }

        } catch (Exception e) {

            e.printStackTrace();
        }


        return result;
    }//축제 정보 조회 - 지역별, 지역랜덤, 3개 랜덤
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
                            if(info[0] == null) {
                                info[0] = infoname + " : " + infotext;
                            }
                            else info[0] = "";
                            if(info[1] == null){
                                info[1] = infoname + " : " + infotext;
                            }
                            else info[1] ="";
                            if(info[2] == null){
                                info[2] = infoname + " : " + infotext;
                            }
                            else info[2] = "";
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

        txt_title = (TextView)findViewById(R.id.txt_title);
        txt_what = (TextView)findViewById(R.id.txt_what);
        txt_start = (TextView)findViewById(R.id.txt_start);
        imgbtn_detail = (ImageView) findViewById(R.id.imgbtn_detail);
        editText = (EditText)findViewById(R.id.editText);
        btn_map = (Button)findViewById(R.id.btn_map);
        btn_home = (Button)findViewById(R.id.btn_home);
        btn_back = (Button)findViewById(R.id.btn_back);
        btnsearch = (Button)findViewById(R.id.btnsearch);


        txt_detail_title1 = (TextView) findViewById(R.id.txt_detail_title1);
        txt_detail_title2 = (TextView) findViewById(R.id.txt_detail_title2);
        txt_detail_title3 = (TextView) findViewById(R.id.txt_detail_title3);
        txt_detail_where1 = (TextView) findViewById(R.id.txt_detail_where1);
        txt_detail_where2 = (TextView) findViewById(R.id.txt_detail_where2);
        txt_detail_where3 = (TextView) findViewById(R.id.txt_detail_where3);
        txt_detail_date1 = (TextView) findViewById(R.id.txt_detail_date1);
        txt_detail_date2 = (TextView) findViewById(R.id.txt_detail_date2);
        txt_detail_date3 = (TextView) findViewById(R.id.txt_detail_date3);
        imgbtn_detail_hot1 = (ImageButton) findViewById(R.id.imgbtn_detail_hot1);
        imgbtn_detail_hot2 = (ImageButton) findViewById(R.id.imgbtn_detail_hot2);
        imgbtn_detail_hot3 = (ImageButton) findViewById(R.id.imgbtn_detail_hot3);



        Intent intent = new Intent(this.getIntent());
        ContentID = intent.getStringExtra("id");
        System.out.println(ContentID);

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
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        DetailThread.start();

        try {
            DetailThread.join();

            if (DetailBitmap != null) {
                if(addr1 == null){
                    addr1 = "정보가 없습니다.";
                }
                if(sponsor1 == null){
                    sponsor1 = "정보가 없습니다.";
                }
                if(sponsor2 == null){
                    sponsor2 = "정보가 없습니다.";
                }

                overview = overview.replace("<br />","\n");
                overview = overview.replace("<br>","\n");
                overview = overview.replace("<b>","\b");
                overview = overview.replace("</b>","\b");
                info[0] = info[0].replace("<br />","\n");
                info[1] = info[1].replace("<br />","\n");
                info[0] = info[0].replace("<br>","\n");
                info[1] = info[1].replace("<br>","\n");

                imgbtn_detail.setImageBitmap(DetailBitmap);
                txt_title.setText(title);
                txt_what.setText("\b"+ overview + "\n\n" + "\b"+info[0] + "\n\n" + "\b"+info[1]);
                txt_start.setText("행사 기간 : " + eventstartdate.substring(0,4) + "년" + eventstartdate.substring(4,6) + "월" + eventstartdate.substring(6) + "일 부터\n" +eventenddate.substring(0,4) + "년" + eventenddate.substring(4,6) + "월" + eventenddate.substring(6) + "일 까지 \n" +
                        "행사 위치 : " + addr1 + "\n주최 : " + sponsor1 + "\n주관 : " + sponsor2 + "\n연락처 : " +tel + "(" + telname + ")");
            } else {
                imgbtn_detail.setImageResource(R.drawable.ic_launcher_foreground);
                if(addr1 == null){
                    addr1 = "정보가 없습니다.";
                }
                if(sponsor1 == null){
                    sponsor1 = "정보가 없습니다.";
                }
                if(sponsor2 == null){
                    sponsor2 = "정보가 없습니다.";
                }

                overview = overview.replace("<br />","\n");
                overview = overview.replace("<br>","\n");
                overview = overview.replace("<b>","\b");
                overview = overview.replace("</b>","\b");
                info[0] = info[0].replace("<br />","\n");
                info[1] = info[1].replace("<br />","\n");
                info[0] = info[0].replace("<br>","\n");
                info[1] = info[1].replace("<br>","\n");

                imgbtn_detail.setImageBitmap(DetailBitmap);
                txt_title.setText(title);
                txt_what.setText("\b"+ overview + "\n\n" + "\b"+info[0] + "\n\n" + "\b"+info[1]);
                txt_start.setText("행사 기간 : " + eventstartdate.substring(0,4) + "년" + eventstartdate.substring(4,6) + "월" + eventstartdate.substring(6) + "일 부터\n" +eventenddate.substring(0,4) + "년" + eventenddate.substring(4,6) + "월" + eventenddate.substring(6) + "일 까지 \n" +
                        "행사 위치 : " + addr1 + "\n주최 : " + sponsor1 + "\n주관 : " + sponsor2 + "\n연락처 : " +tel + "(" + telname + ")");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } // 콘텐츠 코드로 데이터 불러오기






        if (savedInstanceState == null) {

            MainFragment mainFragment = new MainFragment();
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.mainFragment, mainFragment, "main")
                    .commit();
            Bundle bundle = new Bundle(2); // 파라미터는 전달할 데이터 개수
            bundle.putString("id", ContentID); // key , value
            bundle.putString("id2", title); // key , value
            mainFragment.setArguments(bundle);
        }

        Thread hotThread = new Thread() {
            @Override
            public void run() {
                // TODO Auto-generated method stub
                int errCount = 7;
                Parse_Data_detailrandom();//아래 메소드를 호출하여 XML data를 파싱해서 String 객체로 얻어오기
                detailBitmap1 = bitmapFromUrl(detailthumbnail1[0]);
                detailBitmap2 = bitmapFromUrl(detailthumbnail2[0]);
                detailBitmap3 = bitmapFromUrl(detailthumbnail3[0]);
                while (errCount >= 0) {
                    if (detailBitmap1 != null) {
                        break;
                    } else {
                        Parse_Data_detailrandom();
                        detailBitmap1 = bitmapFromUrl(detailthumbnail1[0]);
                        detailBitmap2 = bitmapFromUrl(detailthumbnail2[0]);
                        detailBitmap3 = bitmapFromUrl(detailthumbnail3[0]);
                        errCount -= 1;
                        continue;
                    }
                }
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        hotThread.start();

        try {
            hotThread.join();


            if (detailBitmap1 != null) {
                imgbtn_detail_hot1.setImageBitmap(detailBitmap1);
                txt_detail_title1.setText(detailthumbnail1[1]);
                txt_detail_where1.setText(detailthumbnail1[2]);
                txt_detail_date1.setText(detailthumbnail1[3].substring(0,4) + "년" + detailthumbnail1[3].substring(4,6) + "월" + detailthumbnail1[3].substring(6) + "일 부터 " +detailthumbnail1[4].substring(0,4) + "년" + detailthumbnail1[4].substring(4,6) + "월" + detailthumbnail1[4].substring(6) + "일 까지");
            } else {
                imgbtn_detail_hot1.setImageResource(R.drawable.ic_launcher_foreground);
            }


            if (detailBitmap2 != null) {
                imgbtn_detail_hot2.setImageBitmap(detailBitmap2);
                txt_detail_title2.setText(detailthumbnail2[1]);
                txt_detail_where2.setText(detailthumbnail2[2]);
                txt_detail_date2.setText(detailthumbnail2[3].substring(0,4) + "년" + detailthumbnail2[3].substring(4,6) + "월" + detailthumbnail2[3].substring(6) + "일 부터 " +detailthumbnail2[4].substring(0,4) + "년" + detailthumbnail2[4].substring(4,6) + "월" + detailthumbnail2[4].substring(6) + "일 까지");
            } else {
                imgbtn_detail_hot2.setImageResource(R.drawable.ic_launcher_foreground);
            }

            if (detailBitmap3 != null) {
                imgbtn_detail_hot3.setImageBitmap(detailBitmap3);
                txt_detail_title3.setText(detailthumbnail3[1]);
                txt_detail_where3.setText(detailthumbnail3[2]);
                txt_detail_date3.setText(detailthumbnail3[3].substring(0,4) + "년" + detailthumbnail3[3].substring(4,6) + "월" + detailthumbnail3[3].substring(6) + "일 부터 " +detailthumbnail3[4].substring(0,4) + "년" + detailthumbnail3[4].substring(4,6) + "월" + detailthumbnail3[4].substring(6) + "일 까지");
            } else {
                imgbtn_detail_hot3.setImageResource(R.drawable.ic_launcher_foreground);
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }//메인화면 인기순 3개 축제 띄우기

        btn_map.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                // 커스텀 리스트 뷰 창으로 이동
                Intent intent = new Intent(DetailActivity2.this,MapMainActivity.class);
                startActivity(intent);
            }
        });
        btn_home.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                // 커스텀 리스트 뷰 창으로 이동
                Intent intent = new Intent(DetailActivity2.this,MainActivity.class);
                startActivity(intent);
            }
        });
        btn_back.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                // 커스텀 리스트 뷰 창으로 이동
                finish();
            }
        });
        btnsearch.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                // 커스텀 리스트 뷰 창으로 이동
                Intent intent = new Intent(DetailActivity2.this,ListViewActivity.class);
                intent.putExtra("searchKeyword",editText.getText().toString());
                startActivity(intent);
            }
        });
        imgbtn_detail_hot1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent Intent = new Intent(DetailActivity2.this, DetailActivity.class);
                Intent.putExtra("id",detailthumbnail1[5]);
                startActivity(Intent);
            }
        });
        imgbtn_detail_hot2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent Intent = new Intent(DetailActivity2.this, DetailActivity.class);
                Intent.putExtra("id",detailthumbnail2[5]);
                startActivity(Intent);
            }
        });
        imgbtn_detail_hot3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent Intent = new Intent(DetailActivity2.this, DetailActivity.class);
                Intent.putExtra("id",detailthumbnail3[5]);
                startActivity(Intent);
            }
        });




        // 상단바 , 검색 창 버튼 이벤트 끝







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
