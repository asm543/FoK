package com.example.fok;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
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

public class MapJeonlabugdoActivity extends FontActivity {


//국제무형유산영살축제 2489499
//완주 와일드푸드축제 1336591
//김제 지평선축제 574285
//필봉 GOOD 보러가세 2446507
//가을꽃잔치 - 고창228999
//순창 638241
//남원 1265305


    Button btn_jb1,btn_jb2,btn_jb3,btn_jb4,btn_jb5,btn_jb6,btn_jb7;
    Button btn_map,btn_home,btn_back,btnsearch;
    EditText editText;


    public static final String MYKEY = "IPbBi9DbtpkIHLLYxiEdNhiPoe%2B2ZzZWPHoag%2FeAOimpSX%2FCAZW4%2FU8CmowZTEuFFzgXP3%2FRAuH%2FZYJQ2fQgxQ%3D%3D";

    TextView txt_festival_title1,txt_festival_title2,txt_festival_title3,txt_festival_where1,txt_festival_where2,txt_festival_where3,txt_festival_date1,txt_festival_date2,txt_festival_date3;
    ImageButton imgbtn_festival_hot1,imgbtn_festival_hot2,imgbtn_festival_hot3;
    TextView txt_tour_title1,txt_tour_title2,txt_tour_title3,txt_tour_where1,txt_tour_where2,txt_tour_where3,txt_tour_date1,txt_tour_date2,txt_tour_date3;
    ImageButton imgbtn_tour_hot1,imgbtn_tour_hot2,imgbtn_tour_hot3;

    String areaCode = "37";


    Bitmap festivalBitmap1, festivalBitmap2, festivalBitmap3;
    Bitmap tourBitmap1, tourBitmap2, tourBitmap3;
    String contentid = "";
    String  title = null, DetailImage = null; // 등록날짜,홈페이지주소, 수정날짜, 전화번호, 전화번호이름, 제목, 사진
    String addr1 = null;
    String eventenddate = null,eventstartdate = null;
    String result = null;

    String[] festivalthumbnail1 = new String[6];
    String[] festivalthumbnail2 = new String[6];
    String[] festivalthumbnail3 = new String[6];
    String[] tourthumbnail1 = new String[6];
    String[] tourthumbnail2 = new String[6];
    String[] tourthumbnail3 = new String[6];

    boolean incontentid = false;
    boolean intitle= false, inDetailImage=false;
    boolean inaddr1= false;
    boolean ineventenddate = false,ineventstartdate = false;

    private String Parse_Data_detailrandom() {
        result = "";
        int randomNum = 1;
        Random random = new Random();
        randomNum = random.nextInt(10) + 1;
        String RANDOMNUM = ""+randomNum;
        String nowYear = "2019";
        try {
            URL url = new URL("http://api.visitkorea.or.kr/openapi/service/rest/KorService/searchFestival?serviceKey=" + MYKEY + "&numOfRows=3&pageNo="+RANDOMNUM+"&MobileOS=ETC&MobileApp=FoK&arrange=Q&listYN=Y&eventStartDate=" + nowYear + "0101&eventEndDate=" + nowYear + "1231&areaCode=" +areaCode
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
                            txt_festival_title1.setText("정보 불러오기 실패! 다시 시도해주세요.");
                            txt_festival_title2.setText("정보 불러오기 실패! 다시 시도해주세요.");
                            txt_festival_title3.setText("정보 불러오기 실패! 다시 시도해주세요.");
                            txt_festival_date1.setText("");
                            txt_festival_date2.setText("");
                            txt_festival_date3.setText("");
                            txt_festival_where1.setText("");
                            txt_festival_where2.setText("");
                            txt_festival_where2.setText("");

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
                            if (festivalthumbnail1[0] == null) {
                                festivalthumbnail1[0] = DetailImage;
                                festivalthumbnail1[1] = title;
                                festivalthumbnail1[2] = addr1;
                                festivalthumbnail1[3] = eventstartdate;
                                festivalthumbnail1[4] = eventenddate;
                                festivalthumbnail1[5] = contentid;

//                                        textView.setText(seasonthumbnailContentid + seasonthumbnailImage + seasonthumbnailTitle);
//                                        intoImageView(seasonthumbnailImage,button1);
                            } else if (festivalthumbnail2[0] == null) {
                                festivalthumbnail2[0] = DetailImage;
                                festivalthumbnail2[1] = title;
                                festivalthumbnail2[2] = addr1;
                                festivalthumbnail2[3] = eventstartdate;
                                festivalthumbnail2[4] = eventenddate;
                                festivalthumbnail2[5] = contentid;
//                                        textView.setText(seasonthumbnailContentid2 + seasonthumbnailImage2 + seasonthumbnailTitle2);
//                                        intoImageView(seasonthumbnailImage2,button2);
                            } else if (festivalthumbnail3[0] == null) {
                                festivalthumbnail3[0] = DetailImage;
                                festivalthumbnail3[1] = title;
                                festivalthumbnail3[2] = addr1;
                                festivalthumbnail3[3] = eventstartdate;
                                festivalthumbnail3[4] = eventenddate;
                                festivalthumbnail3[5] = contentid;
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
    private String Parse_Data_tourrandom() {
        result = "";
        int randomNum = 1;
        Random random = new Random();
        randomNum = random.nextInt(100) + 1;
        String RANDOMNUM = ""+randomNum;
        try {
            URL url = new URL(" http://api.visitkorea.or.kr/openapi/service/rest/KorService/areaBasedList?ServiceKey=IPbBi9DbtpkIHLLYxiEdNhiPoe%2B2ZzZWPHoag%2FeAOimpSX%2FCAZW4%2FU8CmowZTEuFFzgXP3%2FRAuH%2FZYJQ2fQgxQ%3D%3D&areaCode="+areaCode+"&contentTypeId=12&arrange=O&numOfRows=3&pageNo="+RANDOMNUM+"&MobileOS=ETC&MobileApp=FOK"
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
                        if (parser.getName().equals("firstimage")) { // 주소
                            inDetailImage = true;
                        }
                        if (parser.getName().equals("title")) { // 주소
                            intitle = true;
                        }


                        if (parser.getName().equals("message")) {
                            txt_tour_title1.setText("정보 불러오기 실패! 다시 시도해주세요.");
                            txt_tour_title2.setText("정보 불러오기 실패! 다시 시도해주세요.");
                            txt_tour_title3.setText("정보 불러오기 실패! 다시 시도해주세요.");
                            txt_tour_date1.setText("");
                            txt_tour_date2.setText("");
                            txt_tour_date3.setText("");
                            txt_tour_where1.setText("");
                            txt_tour_where2.setText("");
                            txt_tour_where2.setText("");

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
                            if (tourthumbnail1[0] == null) {
                                tourthumbnail1[0] = DetailImage;
                                tourthumbnail1[1] = title;
                                tourthumbnail1[2] = addr1;
                                tourthumbnail1[5] = contentid;

//                                        textView.setText(seasonthumbnailContentid + seasonthumbnailImage + seasonthumbnailTitle);
//                                        intoImageView(seasonthumbnailImage,button1);
                            } else if (tourthumbnail2[0] == null) {
                                tourthumbnail2[0] = DetailImage;
                                tourthumbnail2[1] = title;
                                tourthumbnail2[2] = addr1;
                                tourthumbnail2[5] = contentid;
//                                        textView.setText(seasonthumbnailContentid2 + seasonthumbnailImage2 + seasonthumbnailTitle2);
//                                        intoImageView(seasonthumbnailImage2,button2);
                            } else if (tourthumbnail3[0] == null) {
                                tourthumbnail3[0] = DetailImage;
                                tourthumbnail3[1] = title;
                                tourthumbnail3[2] = addr1;
                                tourthumbnail3[5] = contentid;
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
        setContentView(R.layout.map_jeonlabugdo);

        btn_jb1 = (Button)findViewById(R.id.btn_jb1);
        btn_jb2 = (Button)findViewById(R.id.btn_jb2);
        btn_jb3 = (Button)findViewById(R.id.btn_jb3);
        btn_jb4 = (Button)findViewById(R.id.btn_jb4);
        btn_jb5 = (Button)findViewById(R.id.btn_jb5);
        btn_jb6 = (Button)findViewById(R.id.btn_jb6);
        btn_jb7 = (Button)findViewById(R.id.btn_jb7);


        // 상단바 , 검색 창  버튼 이벤트 시작
        btn_map = (Button)findViewById(R.id.btn_map);
        btn_home = (Button)findViewById(R.id.btn_home);
        btn_back = (Button)findViewById(R.id.btn_back);
        btnsearch = (Button)findViewById(R.id.btnsearch);
        editText = (EditText)findViewById(R.id.editText);


        txt_festival_title1 = (TextView) findViewById(R.id.txt_festival_title1);
        txt_festival_title2 = (TextView) findViewById(R.id.txt_festival_title2);
        txt_festival_title3 = (TextView) findViewById(R.id.txt_festival_title3);
        txt_festival_where1 = (TextView) findViewById(R.id.txt_festival_where1);
        txt_festival_where2 = (TextView) findViewById(R.id.txt_festival_where2);
        txt_festival_where3 = (TextView) findViewById(R.id.txt_festival_where3);
        txt_festival_date1 = (TextView) findViewById(R.id.txt_festival_date1);
        txt_festival_date2 = (TextView) findViewById(R.id.txt_festival_date2);
        txt_festival_date3 = (TextView) findViewById(R.id.txt_festival_date3);
        imgbtn_festival_hot1 = (ImageButton) findViewById(R.id.festival1);
        imgbtn_festival_hot2 = (ImageButton) findViewById(R.id.festival2);
        imgbtn_festival_hot3 = (ImageButton) findViewById(R.id.festival3);
        txt_tour_title1 = (TextView) findViewById(R.id.txt_tour_title1);
        txt_tour_title2 = (TextView) findViewById(R.id.txt_tour_title2);
        txt_tour_title3 = (TextView) findViewById(R.id.txt_tour_title3);
        txt_tour_where1 = (TextView) findViewById(R.id.txt_tour_where1);
        txt_tour_where2 = (TextView) findViewById(R.id.txt_tour_where2);
        txt_tour_where3 = (TextView) findViewById(R.id.txt_tour_where3);
        txt_tour_date1 = (TextView) findViewById(R.id.txt_tour_date1);
        txt_tour_date2 = (TextView) findViewById(R.id.txt_tour_date2);
        txt_tour_date3 = (TextView) findViewById(R.id.txt_tour_date3);
        imgbtn_tour_hot1 = (ImageButton) findViewById(R.id.tour1);
        imgbtn_tour_hot2 = (ImageButton) findViewById(R.id.tour2);
        imgbtn_tour_hot3 = (ImageButton) findViewById(R.id.tour3);


        Thread hotThread = new Thread() {
            @Override
            public void run() {
                // TODO Auto-generated method stub
                int errCount = 7;
                Parse_Data_detailrandom();//아래 메소드를 호출하여 XML data를 파싱해서 String 객체로 얻어오기
                festivalBitmap1 = bitmapFromUrl(festivalthumbnail1[0]);
                festivalBitmap2 = bitmapFromUrl(festivalthumbnail2[0]);
                festivalBitmap3 = bitmapFromUrl(festivalthumbnail3[0]);
                while (errCount >= 0) {
                    if (festivalBitmap1 != null) {
                        break;
                    } else {
                        Parse_Data_detailrandom();
                        festivalBitmap1 = bitmapFromUrl(festivalthumbnail1[0]);
                        festivalBitmap2 = bitmapFromUrl(festivalthumbnail2[0]);
                        festivalBitmap3 = bitmapFromUrl(festivalthumbnail3[0]);
                        errCount -= 1;
                        continue;
                    }
                }
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        hotThread.start();

        try {
            hotThread.join();


            if (festivalBitmap1 != null) {
                imgbtn_festival_hot1.setImageBitmap(festivalBitmap1);
                txt_festival_title1.setText(festivalthumbnail1[1]);
                txt_festival_where1.setText(festivalthumbnail1[2]);
                txt_festival_date1.setText(festivalthumbnail1[3].substring(0,4) + "년" + festivalthumbnail1[3].substring(4,6) + "월" + festivalthumbnail1[3].substring(6) + "일 부터 " +festivalthumbnail1[4].substring(0,4) + "년" + festivalthumbnail1[4].substring(4,6) + "월" + festivalthumbnail1[4].substring(6) + "일 까지");
            } else {
                imgbtn_festival_hot1.setImageResource(R.drawable.ic_launcher_foreground);
            }


            if (festivalBitmap2 != null) {
                imgbtn_festival_hot2.setImageBitmap(festivalBitmap2);
                txt_festival_title2.setText(festivalthumbnail2[1]);
                txt_festival_where2.setText(festivalthumbnail2[2]);
                txt_festival_date2.setText(festivalthumbnail2[3].substring(0,4) + "년" + festivalthumbnail2[3].substring(4,6) + "월" + festivalthumbnail2[3].substring(6) + "일 부터 " +festivalthumbnail2[4].substring(0,4) + "년" + festivalthumbnail2[4].substring(4,6) + "월" + festivalthumbnail2[4].substring(6) + "일 까지");
            } else {
                imgbtn_festival_hot2.setImageResource(R.drawable.ic_launcher_foreground);
            }

            if (festivalBitmap3 != null) {
                imgbtn_festival_hot3.setImageBitmap(festivalBitmap3);
                txt_festival_title3.setText(festivalthumbnail3[1]);
                txt_festival_where3.setText(festivalthumbnail3[2]);
                txt_festival_date3.setText(festivalthumbnail3[3].substring(0,4) + "년" + festivalthumbnail3[3].substring(4,6) + "월" + festivalthumbnail3[3].substring(6) + "일 부터 " +festivalthumbnail3[4].substring(0,4) + "년" + festivalthumbnail3[4].substring(4,6) + "월" + festivalthumbnail3[4].substring(6) + "일 까지");
            } else {
                imgbtn_festival_hot3.setImageResource(R.drawable.ic_launcher_foreground);
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }//메인화면 인기순 3개 축제 띄우기

        Thread tourThread = new Thread() {
            @Override
            public void run() {
                // TODO Auto-generated method stub
                int errCount = 7;
                Parse_Data_tourrandom();//아래 메소드를 호출하여 XML data를 파싱해서 String 객체로 얻어오기
                tourBitmap1 = bitmapFromUrl(tourthumbnail1[0]);
                tourBitmap2 = bitmapFromUrl(tourthumbnail2[0]);
                tourBitmap3 = bitmapFromUrl(tourthumbnail3[0]);
                while (errCount >= 0) {
                    if (tourBitmap1 != null) {
                        break;
                    } else {
                        Parse_Data_tourrandom();
                        tourBitmap1 = bitmapFromUrl(tourthumbnail1[0]);
                        tourBitmap2 = bitmapFromUrl(tourthumbnail2[0]);
                        tourBitmap3 = bitmapFromUrl(tourthumbnail3[0]);
                        errCount -= 1;
                        continue;
                    }
                }
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        tourThread.start();

        try {
            tourThread.join();


            if (tourBitmap1 != null) {
                imgbtn_tour_hot1.setImageBitmap(tourBitmap1);
                txt_tour_title1.setText(tourthumbnail1[1]);
                txt_tour_where1.setText(tourthumbnail1[2]);
                txt_tour_date1.setText("");
            } else {
                imgbtn_tour_hot1.setImageResource(R.drawable.ic_launcher_foreground);
            }


            if (tourBitmap2 != null) {
                imgbtn_tour_hot2.setImageBitmap(tourBitmap2);
                txt_tour_title2.setText(tourthumbnail2[1]);
                txt_tour_where2.setText(tourthumbnail2[2]);
                txt_tour_date2.setText("");

            } else {
                imgbtn_tour_hot2.setImageResource(R.drawable.ic_launcher_foreground);
            }

            if (tourBitmap3 != null) {
                imgbtn_tour_hot3.setImageBitmap(tourBitmap3);
                txt_tour_title3.setText(tourthumbnail3[1]);
                txt_tour_where3.setText(tourthumbnail3[2]);
                txt_tour_date3.setText("");

            } else {
                imgbtn_tour_hot3.setImageResource(R.drawable.ic_launcher_foreground);
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }//메인화면 인기순 3개 축제 띄우기


        imgbtn_festival_hot1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent Intent = new Intent(MapJeonlabugdoActivity.this, DetailActivity2.class);
                Intent.putExtra("id",festivalthumbnail1[5]);
                startActivity(Intent);
            }
        });
        imgbtn_festival_hot2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent Intent = new Intent(MapJeonlabugdoActivity.this, DetailActivity2.class);
                Intent.putExtra("id",festivalthumbnail2[5]);
                startActivity(Intent);
            }
        });
        imgbtn_festival_hot3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent Intent = new Intent(MapJeonlabugdoActivity.this, DetailActivity2.class);
                Intent.putExtra("id",festivalthumbnail3[5]);
                startActivity(Intent);
            }
        });
        imgbtn_tour_hot1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent Intent = new Intent(MapJeonlabugdoActivity.this, DetailActivity2.class);
                Intent.putExtra("id",tourthumbnail1[5]);
                startActivity(Intent);
            }
        });
        imgbtn_tour_hot2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent Intent = new Intent(MapJeonlabugdoActivity.this, DetailActivity2.class);
                Intent.putExtra("id",tourthumbnail2[5]);
                startActivity(Intent);
            }
        });
        imgbtn_tour_hot3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent Intent = new Intent(MapJeonlabugdoActivity.this, DetailActivity2.class);
                Intent.putExtra("id",tourthumbnail3[5]);
                startActivity(Intent);
            }
        });



        btn_map.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                // 커스텀 리스트 뷰 창으로 이동
                Intent intent = new Intent(MapJeonlabugdoActivity.this,MapMainActivity.class);
                startActivity(intent);
            }
        });
        btn_home.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                // 커스텀 리스트 뷰 창으로 이동
                Intent intent = new Intent(MapJeonlabugdoActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
        btn_back.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                // 커스텀 리스트 뷰 창으로 이동
                Intent intent = new Intent(MapJeonlabugdoActivity.this,MapMainActivity.class);
                startActivity(intent);
            }
        });
        btnsearch.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                // 커스텀 리스트 뷰 창으로 이동
                Intent intent = new Intent(MapJeonlabugdoActivity.this,ListViewActivity.class);
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


        btn_jb1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                // 커스텀 리스트 뷰 창으로 이동
                Intent intent = new Intent(MapJeonlabugdoActivity.this,DetailActivity.class); // 지금 이 액티비티 이름.this 국제무형유산영살축제
                intent.putExtra("id","2489499");
                startActivity(intent);
            }
        });
        btn_jb2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                // 커스텀 리스트 뷰 창으로 이동
                Intent intent = new Intent(MapJeonlabugdoActivity.this,DetailActivity.class); // 지금 이 액티비티 이름.this 완주 와일드푸드축제
                intent.putExtra("id","574285");
                startActivity(intent);
            }
        });
        btn_jb3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                // 커스텀 리스트 뷰 창으로 이동
                Intent intent = new Intent(MapJeonlabugdoActivity.this,DetailActivity.class); // 지금 이 액티비티 이름.this 김제 지평선축제
                intent.putExtra("id","2446507");
                startActivity(intent);
            }
        });
        btn_jb4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                // 커스텀 리스트 뷰 창으로 이동
                Intent intent = new Intent(MapJeonlabugdoActivity.this,DetailActivity.class); // 지금 이 액티비티 이름.this 필봉 GOOD 보러가세
                intent.putExtra("id","2446507");
                startActivity(intent);
            }
        });
        btn_jb5.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                // 커스텀 리스트 뷰 창으로 이동
                Intent intent = new Intent(MapJeonlabugdoActivity.this,DetailActivity.class); // 지금 이 액티비티 이름.this 가을꽃잔치
                intent.putExtra("id","228999");
                startActivity(intent);
            }
        });
        btn_jb6.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                // 커스텀 리스트 뷰 창으로 이동
                Intent intent = new Intent(MapJeonlabugdoActivity.this,DetailActivity.class); // 지금 이 액티비티 이름.this 순창
                intent.putExtra("id","638241");
                startActivity(intent);
            }
        });
        btn_jb7.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                // 커스텀 리스트 뷰 창으로 이동
                Intent intent = new Intent(MapJeonlabugdoActivity.this,DetailActivity.class); // 지금 이 액티비티 이름.this 남원
                intent.putExtra("id","1265305");
                startActivity(intent);
            }
        });
    }
}
