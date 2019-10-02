package com.example.fok;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
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
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    public static final String MYKEY = "IPbBi9DbtpkIHLLYxiEdNhiPoe%2B2ZzZWPHoag%2FeAOimpSX%2FCAZW4%2FU8CmowZTEuFFzgXP3%2FRAuH%2FZYJQ2fQgxQ%3D%3D";
    SimpleDateFormat Year = new SimpleDateFormat("yyyy");
    SimpleDateFormat Month = new SimpleDateFormat("MM");
    SimpleDateFormat Day = new SimpleDateFormat("dd");
    Bitmap  bitmap1, bitmap2, bitmap3, hotBitmap1,hotBitmap2,hotBitmap3,localBitmap1,localBitmap2,localBitmap3;


    String totalCount = null, addr1 = null, addr2 = null, areacode = null, cat1 = null, cat2 = null, cat3 = null, contentid = null;
    String contenttypeid = null, createdtime = null, eventstartdate = null, eventenddate = null, firstimage = null, firstimage2 = null;
    String mapx = null, mapy = null, mlevel = null, modifiedtime = null, readcount = null, sigungucode = null, tel = null, title = null;
    String result = null;
    String data;

    boolean intotalCount = false, inaddr1 = false, inaddr2 = false, inareacode = false, incat1 = false, incat2 = false, incat3 = false, incontentid = false, incontenttypeid = false;
    boolean increatedtime = false, ineventstartdate = false, ineventenddate = false, infirstimage = false, infirstimage2 = false, inmapx = false;
    boolean inmapy = false, inmlevel = false, inmodifiedtime = false, inreadcount = false, insigungucode = false, intel = false, intitle = false;

    long mNow;
    Date mDate;
    int randomNum = 1;


    String[] seasonthumbnail1 = new String[6];
    String[] seasonthumbnail2 = new String[6];
    String[] seasonthumbnail3 = new String[6];
    String[] hotthumbnail1 = new String[6];
    String[] hotthumbnail2 = new String[6];
    String[] hotthumbnail3 = new String[6];
    String[] localthumbnail1 = new String[6];
    String[] localthumbnail2 = new String[6];
    String[] localthumbnail3 = new String[6];


    TextView txt_wheather_title1,txt_wheather_title2,txt_wheather_title3,txt_wheather_where1,txt_wheather_where2,txt_wheather_where3,txt_wheather_date1,txt_wheather_date2,txt_wheather_date3; //계절별 ui 모음
    TextView txt_hot_title1,txt_hot_title2,txt_hot_title3,txt_hot_where1,txt_hot_where2,txt_hot_where3,txt_hot_date1,txt_hot_date2,txt_hot_date3;
    TextView txt_local_title1,txt_local_title2,txt_local_title3,txt_local_where1,txt_local_where2,txt_local_where3,txt_local_date1,txt_local_date2,txt_local_date3;
    ImageButton imgbtn_main_wheather1,imgbtn_main_wheather2,imgbtn_main_wheather3;
    ImageButton imgbtn_main_hot1,imgbtn_main_hot2,imgbtn_main_hot3;
    ImageButton imgbtn_main_local1,imgbtn_main_local2,imgbtn_main_local3;

    private String getYear() {
        mNow = System.currentTimeMillis();
        mDate = new Date(mNow);
        return Year.format(mDate);
    }// 현재 년도 구하기 메소드

    private String getMonth() {
        mNow = System.currentTimeMillis();
        mDate = new Date(mNow);
        return Month.format(mDate);
    }//현재 월 구하기 메소드

    private String getDay() {
        mNow = System.currentTimeMillis();
        mDate = new Date(mNow);
        return Day.format(mDate);
    }//현재 일 구하기 메소드

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


    private String Parse_Data_season() {
        result = "";
        Random random = new Random();
        randomNum = random.nextInt(1000) + 1;


        String nowYear = getYear();
        String nowMonth = getMonth();
        String endMonth = null;
        if (nowMonth == "12" || nowMonth == "01" || nowMonth == "02") {
            nowMonth = "12";
            endMonth = "02";

        } else if (nowMonth == "03" || nowMonth == "04" || nowMonth == "05") {
            nowMonth = "03";
            endMonth = "05";
        } else if (nowMonth == "06" || nowMonth == "07" || nowMonth == "08") {
            nowMonth = "06";
            endMonth = "08";
        } else {
            nowMonth = "09";
            endMonth = "11";
        }
        try {
            URL url = new URL("http://api.visitkorea.or.kr/openapi/service/rest/KorService/searchFestival?serviceKey=" + MYKEY + "&numOfRows=3&pageNo=" + randomNum + "&MobileOS=ETC&MobileApp=FoK&arrange=P&listYN=Y&eventStartDate=" + nowYear + nowMonth + "01&eventEndDate=" + nowYear + endMonth + "31"
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

                        if (parser.getName().equals("areacode")) { // 주소
                            inareacode = true;
                        }
                        if (parser.getName().equals("cat1")) { // 주소
                            incat1 = true;
                        }
                        if (parser.getName().equals("cat2")) { // 주소
                            incat2 = true;
                        }
                        if (parser.getName().equals("cat3")) { // 주소
                            incat3 = true;
                        }
                        if (parser.getName().equals("contentid")) { // 주소
                            incontentid = true;
                        }
                        if (parser.getName().equals("contenttypeid")) { // 주소
                            incontenttypeid = true;
                        }
                        if (parser.getName().equals("createdtime")) { // 주소
                            increatedtime = true;
                        }
                        if (parser.getName().equals("eventstartdate")) { // 주소
                            ineventstartdate = true;
                        }
                        if (parser.getName().equals("eventenddate")) { // 주소
                            ineventenddate = true;
                        }
                        if (parser.getName().equals("firstimage")) { // 주소
                            infirstimage = true;
                        }
                        if (parser.getName().equals("firstimage2")) { // 주소
                            infirstimage2 = true;
                        }
                        if (parser.getName().equals("mapx")) { // 주소
                            inmapx = true;
                        }
                        if (parser.getName().equals("mapy")) { // 주소
                            inmapy = true;
                        }
                        if (parser.getName().equals("mlevel")) { // 주소
                            inmlevel = true;
                        }
                        if (parser.getName().equals("modifiedtime")) { // 주소
                            inmodifiedtime = true;
                        }
                        if (parser.getName().equals("sigungucode")) { // 주소
                            insigungucode = true;
                        }
                        if (parser.getName().equals("tel")) { // 주소
                            intel = true;
                        }
                        if (parser.getName().equals("title")) { // 주소
                            intitle = true;
                        }


                        if (parser.getName().equals("message")) {
                            txt_wheather_title1.setText("정보 불러오기 실패! 다시 시도해주세요.");
                            txt_wheather_title2.setText("정보 불러오기 실패! 다시 시도해주세요.");
                            txt_wheather_title3.setText("정보 불러오기 실패! 다시 시도해주세요.");
                            txt_wheather_date1.setText("");
                            txt_wheather_date2.setText("");
                            txt_wheather_date3.setText("");
                            txt_wheather_where1.setText("");
                            txt_wheather_where2.setText("");
                            txt_wheather_where2.setText("");

                        }
                        break;

                    case XmlPullParser.TEXT://parser가 내용에 접근했을때

                        if (inaddr1) {
                            addr1 = parser.getText();
                            inaddr1 = false;
                        }
                        if (inareacode) {
                            areacode = parser.getText();
                            inareacode = false;
                        }

                        if (incat1) {
                            cat1 = parser.getText();
                            incat1 = false;
                        }

                        if (incat2) {
                            cat2 = parser.getText();
                            incat2 = false;
                        }

                        if (incat3) {
                            cat3 = parser.getText();
                            incat3 = false;
                        }

                        if (incontentid) {
                            contentid = parser.getText();
                            incontentid = false;
                        }

                        if (incontenttypeid) {
                            contenttypeid = parser.getText();
                            incontenttypeid = false;
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

                        if (infirstimage) {
                            firstimage = parser.getText();
                            infirstimage = false;
                        }

                        if (infirstimage2) {
                            firstimage2 = parser.getText();
                            infirstimage2 = false;
                        }

                        if (inmapx) {
                            mapx = parser.getText();
                            inmapx = false;
                        }
                        if (inmapy) {
                            mapy = parser.getText();
                            inmapy = false;
                        }
                        if (inmlevel) {
                            mlevel = parser.getText();
                            inmlevel = false;
                        }
                        if (inmodifiedtime) {
                            modifiedtime = parser.getText();
                            inmodifiedtime = false;
                        }

                        if (insigungucode) {
                            sigungucode = parser.getText();
                            insigungucode = false;
                        }
                        if (intel) {
                            tel = parser.getText();
                            intel = false;
                        }
                        if (intitle) {
                            title = parser.getText();
                            intitle = false;
                        }

                        break;
                    case XmlPullParser.END_TAG:
                        if (parser.getName().equals("item")) {
                            result += "\n" + addr1 + "\n" + areacode + "\n" + cat1 + "\n" + cat2 + "\n" + cat3 + "\n" + contentid + "\n" + contenttypeid + "\n" + createdtime + "\n" + eventstartdate + "\n" + eventenddate + "\n" + firstimage + "\n" + firstimage2 + "\n" + mapx + "\n" + mapy + "\n" + mlevel + "\n" + modifiedtime + "\n" + sigungucode + "\n" + tel + "\n" + title + "\n";
                            if (seasonthumbnail1[0] == null) {
                                seasonthumbnail1[0] = firstimage;
                                seasonthumbnail1[1] = title;
                                seasonthumbnail1[2] = addr1;
                                seasonthumbnail1[3] = eventstartdate;
                                seasonthumbnail1[4] = eventenddate;
                                seasonthumbnail1[5] = contentid;

//                                        textView.setText(seasonthumbnailContentid + seasonthumbnailImage + seasonthumbnailTitle);
//                                        intoImageView(seasonthumbnailImage,button1);
                            } else if (seasonthumbnail2[0] == null) {
                                seasonthumbnail2[0] = firstimage;
                                seasonthumbnail2[1] = title;
                                seasonthumbnail2[2] = addr1;
                                seasonthumbnail2[3] = eventstartdate;
                                seasonthumbnail2[4] = eventenddate;
                                seasonthumbnail2[5] = contentid;
//                                        textView.setText(seasonthumbnailContentid2 + seasonthumbnailImage2 + seasonthumbnailTitle2);
//                                        intoImageView(seasonthumbnailImage2,button2);
                            } else if (seasonthumbnail3[0] == null) {
                                seasonthumbnail3[0] = firstimage;
                                seasonthumbnail3[1] = title;
                                seasonthumbnail3[2] = addr1;
                                seasonthumbnail3[3] = eventstartdate;
                                seasonthumbnail3[4] = eventenddate;
                                seasonthumbnail3[5] = contentid;
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
    } // 축제 정보 조회 - 계절별, 3개 랜덤
    private String Parse_Data_sortView() {
        result = "";
        String nowYear = getYear();
        try {
            URL url = new URL("http://api.visitkorea.or.kr/openapi/service/rest/KorService/searchFestival?serviceKey=" + MYKEY + "&numOfRows=3&pageNo=1&MobileOS=ETC&MobileApp=FoK&arrange=P&listYN=Y&eventStartDate=" + nowYear + "0101&eventEndDate=" + nowYear + "1231"
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

                        if (parser.getName().equals("areacode")) { // 주소
                            inareacode = true;
                        }
                        if (parser.getName().equals("cat1")) { // 주소
                            incat1 = true;
                        }
                        if (parser.getName().equals("cat2")) { // 주소
                            incat2 = true;
                        }
                        if (parser.getName().equals("cat3")) { // 주소
                            incat3 = true;
                        }
                        if (parser.getName().equals("contentid")) { // 주소
                            incontentid = true;
                        }
                        if (parser.getName().equals("contenttypeid")) { // 주소
                            incontenttypeid = true;
                        }
                        if (parser.getName().equals("createdtime")) { // 주소
                            increatedtime = true;
                        }
                        if (parser.getName().equals("eventstartdate")) { // 주소
                            ineventstartdate = true;
                        }
                        if (parser.getName().equals("eventenddate")) { // 주소
                            ineventenddate = true;
                        }
                        if (parser.getName().equals("firstimage")) { // 주소
                            infirstimage = true;
                        }
                        if (parser.getName().equals("firstimage2")) { // 주소
                            infirstimage2 = true;
                        }
                        if (parser.getName().equals("mapx")) { // 주소
                            inmapx = true;
                        }
                        if (parser.getName().equals("mapy")) { // 주소
                            inmapy = true;
                        }
                        if (parser.getName().equals("mlevel")) { // 주소
                            inmlevel = true;
                        }
                        if (parser.getName().equals("modifiedtime")) { // 주소
                            inmodifiedtime = true;
                        }
                        if (parser.getName().equals("sigungucode")) { // 주소
                            insigungucode = true;
                        }
                        if (parser.getName().equals("tel")) { // 주소
                            intel = true;
                        }
                        if (parser.getName().equals("title")) { // 주소
                            intitle = true;
                        }


                        if (parser.getName().equals("message")) {
                            txt_hot_title1.setText("정보 불러오기 실패! 다시 시도해주세요.");
                            txt_hot_title2.setText("정보 불러오기 실패! 다시 시도해주세요.");
                            txt_hot_title3.setText("정보 불러오기 실패! 다시 시도해주세요.");
                            txt_hot_date1.setText("");
                            txt_hot_date2.setText("");
                            txt_hot_date3.setText("");
                            txt_hot_where1.setText("");
                            txt_hot_where2.setText("");
                            txt_hot_where2.setText("");

                        }
                        break;
          case XmlPullParser.TEXT://parser가 내용에 접근했을때

                        if (inaddr1) {
                            addr1 = parser.getText();
                            inaddr1 = false;
                        }
                        if (inareacode) {
                            areacode = parser.getText();
                            inareacode = false;
                        }

                        if (incat1) {
                            cat1 = parser.getText();
                            incat1 = false;
                        }

                        if (incat2) {
                            cat2 = parser.getText();
                            incat2 = false;
                        }

                        if (incat3) {
                            cat3 = parser.getText();
                            incat3 = false;
                        }

                        if (incontentid) {
                            contentid = parser.getText();
                            incontentid = false;
                        }

                        if (incontenttypeid) {
                            contenttypeid = parser.getText();
                            incontenttypeid = false;
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

                        if (infirstimage) {
                            firstimage = parser.getText();
                            infirstimage = false;
                        }

                        if (infirstimage2) {
                            firstimage2 = parser.getText();
                            infirstimage2 = false;
                        }

                        if (inmapx) {
                            mapx = parser.getText();
                            inmapx = false;
                        }
                        if (inmapy) {
                            mapy = parser.getText();
                            inmapy = false;
                        }
                        if (inmlevel) {
                            mlevel = parser.getText();
                            inmlevel = false;
                        }
                        if (inmodifiedtime) {
                            modifiedtime = parser.getText();
                            inmodifiedtime = false;
                        }

                        if (insigungucode) {
                            sigungucode = parser.getText();
                            insigungucode = false;
                        }
                        if (intel) {
                            tel = parser.getText();
                            intel = false;
                        }
                        if (intitle) {
                            title = parser.getText();
                            intitle = false;
                        }

                        break;
                    case XmlPullParser.END_TAG:
                        if (parser.getName().equals("item")) {
                            result += "\n" + addr1 + "\n" + areacode + "\n" + cat1 + "\n" + cat2 + "\n" + cat3 + "\n" + contentid + "\n" + contenttypeid + "\n" + createdtime + "\n" + eventstartdate + "\n" + eventenddate + "\n" + firstimage + "\n" + firstimage2 + "\n" + mapx + "\n" + mapy + "\n" + mlevel + "\n" + modifiedtime + "\n" + sigungucode + "\n" + tel + "\n" + title + "\n";
                            if (hotthumbnail1[0] == null) {
                                hotthumbnail1[0] = firstimage;
                                hotthumbnail1[1] = title;
                                hotthumbnail1[2] = addr1;
                                hotthumbnail1[3] = eventstartdate;
                                hotthumbnail1[4] = eventenddate;
                                hotthumbnail1[5] = contentid;

//                                        textView.setText(seasonthumbnailContentid + seasonthumbnailImage + seasonthumbnailTitle);
//                                        intoImageView(seasonthumbnailImage,button1);
                            } else if (hotthumbnail2[0] == null) {
                                hotthumbnail2[0] = firstimage;
                                hotthumbnail2[1] = title;
                                hotthumbnail2[2] = addr1;
                                hotthumbnail2[3] = eventstartdate;
                                hotthumbnail2[4] = eventenddate;
                                hotthumbnail2[5] = contentid;
//                                        textView.setText(seasonthumbnailContentid2 + seasonthumbnailImage2 + seasonthumbnailTitle2);
//                                        intoImageView(seasonthumbnailImage2,button2);
                            } else if (hotthumbnail3[0] == null) {
                                hotthumbnail3[0] = firstimage;
                                hotthumbnail3[1] = title;
                                hotthumbnail3[2] = addr1;
                                hotthumbnail3[3] = eventstartdate;
                                hotthumbnail3[4] = eventenddate;
                                hotthumbnail3[5] = contentid;
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
    } //축제 정보 조회 - 조회수별, 3개 랜덤
    private String Parse_Data_sortLocal() {
        result = "";
        Random random = new Random();
        randomNum = random.nextInt(10) + 1;
        String areaCode = ""+randomNum;
        String nowYear = getYear();
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

                        if (parser.getName().equals("areacode")) { // 주소
                            inareacode = true;
                        }
                        if (parser.getName().equals("cat1")) { // 주소
                            incat1 = true;
                        }
                        if (parser.getName().equals("cat2")) { // 주소
                            incat2 = true;
                        }
                        if (parser.getName().equals("cat3")) { // 주소
                            incat3 = true;
                        }
                        if (parser.getName().equals("contentid")) { // 주소
                            incontentid = true;
                        }
                        if (parser.getName().equals("contenttypeid")) { // 주소
                            incontenttypeid = true;
                        }
                        if (parser.getName().equals("createdtime")) { // 주소
                            increatedtime = true;
                        }
                        if (parser.getName().equals("eventstartdate")) { // 주소
                            ineventstartdate = true;
                        }
                        if (parser.getName().equals("eventenddate")) { // 주소
                            ineventenddate = true;
                        }
                        if (parser.getName().equals("firstimage")) { // 주소
                            infirstimage = true;
                        }
                        if (parser.getName().equals("firstimage2")) { // 주소
                            infirstimage2 = true;
                        }
                        if (parser.getName().equals("mapx")) { // 주소
                            inmapx = true;
                        }
                        if (parser.getName().equals("mapy")) { // 주소
                            inmapy = true;
                        }
                        if (parser.getName().equals("mlevel")) { // 주소
                            inmlevel = true;
                        }
                        if (parser.getName().equals("modifiedtime")) { // 주소
                            inmodifiedtime = true;
                        }
                        if (parser.getName().equals("sigungucode")) { // 주소
                            insigungucode = true;
                        }
                        if (parser.getName().equals("tel")) { // 주소
                            intel = true;
                        }
                        if (parser.getName().equals("title")) { // 주소
                            intitle = true;
                        }


                        if (parser.getName().equals("message")) {
                            txt_local_title1.setText("정보 불러오기 실패! 다시 시도해주세요.");
                            txt_local_title2.setText("정보 불러오기 실패! 다시 시도해주세요.");
                            txt_local_title3.setText("정보 불러오기 실패! 다시 시도해주세요.");
                            txt_local_date1.setText("");
                            txt_local_date2.setText("");
                            txt_local_date3.setText("");
                            txt_local_where1.setText("");
                            txt_local_where2.setText("");
                            txt_local_where2.setText("");

                        }
                        break;
                    case XmlPullParser.TEXT://parser가 내용에 접근했을때

                        if (inaddr1) {
                            addr1 = parser.getText();
                            inaddr1 = false;
                        }
                        if (inareacode) {
                            areacode = parser.getText();
                            inareacode = false;
                        }

                        if (incat1) {
                            cat1 = parser.getText();
                            incat1 = false;
                        }

                        if (incat2) {
                            cat2 = parser.getText();
                            incat2 = false;
                        }

                        if (incat3) {
                            cat3 = parser.getText();
                            incat3 = false;
                        }

                        if (incontentid) {
                            contentid = parser.getText();
                            incontentid = false;
                        }

                        if (incontenttypeid) {
                            contenttypeid = parser.getText();
                            incontenttypeid = false;
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

                        if (infirstimage) {
                            firstimage = parser.getText();
                            infirstimage = false;
                        }

                        if (infirstimage2) {
                            firstimage2 = parser.getText();
                            infirstimage2 = false;
                        }

                        if (inmapx) {
                            mapx = parser.getText();
                            inmapx = false;
                        }
                        if (inmapy) {
                            mapy = parser.getText();
                            inmapy = false;
                        }
                        if (inmlevel) {
                            mlevel = parser.getText();
                            inmlevel = false;
                        }
                        if (inmodifiedtime) {
                            modifiedtime = parser.getText();
                            inmodifiedtime = false;
                        }

                        if (insigungucode) {
                            sigungucode = parser.getText();
                            insigungucode = false;
                        }
                        if (intel) {
                            tel = parser.getText();
                            intel = false;
                        }
                        if (intitle) {
                            title = parser.getText();
                            intitle = false;
                        }

                        break;
                    case XmlPullParser.END_TAG:
                        if (parser.getName().equals("item")) {
                            result += "\n" + addr1 + "\n" + areacode + "\n" + cat1 + "\n" + cat2 + "\n" + cat3 + "\n" + contentid + "\n" + contenttypeid + "\n" + createdtime + "\n" + eventstartdate + "\n" + eventenddate + "\n" + firstimage + "\n" + firstimage2 + "\n" + mapx + "\n" + mapy + "\n" + mlevel + "\n" + modifiedtime + "\n" + sigungucode + "\n" + tel + "\n" + title + "\n";
                            if (localthumbnail1[0] == null) {
                                localthumbnail1[0] = firstimage;
                                localthumbnail1[1] = title;
                                localthumbnail1[2] = addr1;
                                localthumbnail1[3] = eventstartdate;
                                localthumbnail1[4] = eventenddate;
                                localthumbnail1[5] = contentid;

//                                        textView.setText(seasonthumbnailContentid + seasonthumbnailImage + seasonthumbnailTitle);
//                                        intoImageView(seasonthumbnailImage,button1);
                            } else if (localthumbnail2[0] == null) {
                                localthumbnail2[0] = firstimage;
                                localthumbnail2[1] = title;
                                localthumbnail2[2] = addr1;
                                localthumbnail2[3] = eventstartdate;
                                localthumbnail2[4] = eventenddate;
                                localthumbnail2[5] = contentid;
//                                        textView.setText(seasonthumbnailContentid2 + seasonthumbnailImage2 + seasonthumbnailTitle2);
//                                        intoImageView(seasonthumbnailImage2,button2);
                            } else if (localthumbnail3[0] == null) {
                                localthumbnail3[0] = firstimage;
                                localthumbnail3[1] = title;
                                localthumbnail3[2] = addr1;
                                localthumbnail3[3] = eventstartdate;
                                localthumbnail3[4] = eventenddate;
                                localthumbnail3[5] = contentid;
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

    Handler handler = new Handler() {
        public void handleMessage(Message msg) {
            Bundle bun = msg.getData();
            String parsing = bun.getString("HTML_DATA");
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt_wheather_title1 = (TextView) findViewById(R.id.txt_wheather_title1);
        txt_wheather_title2 = (TextView) findViewById(R.id.txt_wheather_title2);
        txt_wheather_title3 = (TextView) findViewById(R.id.txt_wheather_title3);
        txt_wheather_where1 = (TextView) findViewById(R.id.txt_wheather_where1);
        txt_wheather_where2 = (TextView) findViewById(R.id.txt_wheather_where2);
        txt_wheather_where3 = (TextView) findViewById(R.id.txt_wheather_where3);
        txt_wheather_date1 = (TextView) findViewById(R.id.txt_wheather_date1);
        txt_wheather_date2 = (TextView) findViewById(R.id.txt_wheather_date2);
        txt_wheather_date3 = (TextView) findViewById(R.id.txt_wheather_date3);
        txt_hot_title1 = (TextView) findViewById(R.id.txt_hot_title1);
        txt_hot_title2 = (TextView) findViewById(R.id.txt_hot_title2);
        txt_hot_title3 = (TextView) findViewById(R.id.txt_hot_title3);
        txt_hot_where1 = (TextView) findViewById(R.id.txt_hot_where1);
        txt_hot_where2 = (TextView) findViewById(R.id.txt_hot_where2);
        txt_hot_where3 = (TextView) findViewById(R.id.txt_hot_where3);
        txt_hot_date1 = (TextView) findViewById(R.id.txt_hot_date1);
        txt_hot_date2 = (TextView) findViewById(R.id.txt_hot_date2);
        txt_hot_date3 = (TextView) findViewById(R.id.txt_hot_date3);
        txt_local_title1 = (TextView) findViewById(R.id.txt_local_title1);
        txt_local_title2 = (TextView) findViewById(R.id.txt_local_title2);
        txt_local_title3 = (TextView) findViewById(R.id.txt_local_title3);
        txt_local_where1 = (TextView) findViewById(R.id.txt_local_where1);
        txt_local_where2 = (TextView) findViewById(R.id.txt_local_where2);
        txt_local_where3 = (TextView) findViewById(R.id.txt_local_where3);
        txt_local_date1 = (TextView) findViewById(R.id.txt_local_date1);
        txt_local_date2 = (TextView) findViewById(R.id.txt_local_date2);
        txt_local_date3 = (TextView) findViewById(R.id.txt_local_date3);

        imgbtn_main_wheather1 = (ImageButton) findViewById(R.id.imgbtn_main_wheather1);
        imgbtn_main_wheather2 = (ImageButton) findViewById(R.id.imgbtn_main_wheather2);
        imgbtn_main_wheather3 = (ImageButton) findViewById(R.id.imgbtn_main_wheather3);
        imgbtn_main_hot1 = (ImageButton) findViewById(R.id.imgbtn_main_hot1);
        imgbtn_main_hot2 = (ImageButton) findViewById(R.id.imgbtn_main_hot2);
        imgbtn_main_hot3 = (ImageButton) findViewById(R.id.imgbtn_main_hot3);
        imgbtn_main_local1 = (ImageButton) findViewById(R.id.imgbtn_main_local1);
        imgbtn_main_local2 = (ImageButton) findViewById(R.id.imgbtn_main_local2);
        imgbtn_main_local3 = (ImageButton) findViewById(R.id.imgbtn_main_local3);




        Thread hotThread = new Thread() {
            @Override
            public void run() {
                // TODO Auto-generated method stub
                int errCount = 7;
                Parse_Data_sortView();//아래 메소드를 호출하여 XML data를 파싱해서 String 객체로 얻어오기
                hotBitmap1 = bitmapFromUrl(hotthumbnail1[0]);
                hotBitmap2 = bitmapFromUrl(hotthumbnail2[0]);
                hotBitmap3 = bitmapFromUrl(hotthumbnail3[0]);
                while (errCount >= 0) {
                    if (hotBitmap1 != null) {
                        break;
                    } else {
                        Parse_Data_sortView();
                        hotBitmap1 = bitmapFromUrl(hotthumbnail1[0]);
                        hotBitmap2 = bitmapFromUrl(hotthumbnail2[0]);
                        hotBitmap3 = bitmapFromUrl(hotthumbnail3[0]);
                        errCount -= 1;
                        continue;
                    }
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        hotThread.start();

        try {
            hotThread.join();

            if (hotBitmap1 != null) {
                imgbtn_main_hot1.setImageBitmap(hotBitmap1);
                txt_hot_title1.setText(hotthumbnail1[1]);
                txt_hot_where1.setText(hotthumbnail1[2]);
                txt_hot_date1.setText(hotthumbnail1[3] + " ~ " + hotthumbnail1[4]);
            } else {
                imgbtn_main_hot1.setImageResource(R.drawable.ic_launcher_foreground);
            }


            if (hotBitmap2 != null) {
                imgbtn_main_hot2.setImageBitmap(hotBitmap2);
                txt_hot_title2.setText(hotthumbnail2[1]);
                txt_hot_where2.setText(hotthumbnail2[2]);
                txt_hot_date2.setText(hotthumbnail2[3] + " ~ " + hotthumbnail2[4]);
            } else {
                imgbtn_main_hot2.setImageResource(R.drawable.ic_launcher_foreground);
            }

            if (hotBitmap3 != null) {
                imgbtn_main_hot3.setImageBitmap(hotBitmap3);
                txt_hot_title3.setText(hotthumbnail3[1]);
                txt_hot_where3.setText(hotthumbnail3[2]);
                txt_hot_date3.setText(hotthumbnail3[3] + " ~ " + hotthumbnail3[4]);
            } else {
                imgbtn_main_hot3.setImageResource(R.drawable.ic_launcher_foreground);
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }//메인화면 인기순 3개 축제 띄우기
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        Thread localThread = new Thread() {

            @Override
            public void run() {
                // TODO Auto-generated method stub
                int errCount = 7;
                Parse_Data_sortLocal();//아래 메소드를 호출하여 XML data를 파싱해서 String 객체로 얻어오기
                localBitmap1 = bitmapFromUrl(localthumbnail1[0]);
                localBitmap2 = bitmapFromUrl(localthumbnail2[0]);
                localBitmap3 = bitmapFromUrl(localthumbnail3[0]);
                while (errCount >= 0) {
                    if (localBitmap1 != null) {
                        break;
                    } else {
                        Parse_Data_sortLocal();
                        localBitmap1 = bitmapFromUrl(localthumbnail1[0]);
                        localBitmap2 = bitmapFromUrl(localthumbnail2[0]);
                        localBitmap3 = bitmapFromUrl(localthumbnail3[0]);
                        errCount -= 1;
                        continue;
                    }
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        localThread.start();

        try {
            localThread.join();

            if (localBitmap1 != null) {
                imgbtn_main_local1.setImageBitmap(localBitmap1);
                txt_local_title1.setText(localthumbnail1[1]);
                txt_local_where1.setText(localthumbnail1[2]);
                txt_local_date1.setText(localthumbnail1[3] + " ~ " + localthumbnail1[4]);
            } else {
                imgbtn_main_local1.setImageResource(R.drawable.ic_launcher_foreground);
            }


            if (localBitmap2 != null) {
                imgbtn_main_local2.setImageBitmap(localBitmap2);
                txt_local_title2.setText(localthumbnail2[1]);
                txt_local_where2.setText(localthumbnail2[2]);
                txt_local_date2.setText(localthumbnail2[3] + " ~ " + localthumbnail2[4]);
            } else {
                imgbtn_main_local2.setImageResource(R.drawable.ic_launcher_foreground);
            }

            if (localBitmap3 != null) {
                imgbtn_main_local3.setImageBitmap(localBitmap3);
                txt_local_title3.setText(localthumbnail3[1]);
                txt_local_where3.setText(localthumbnail3[2]);
                txt_local_date3.setText(localthumbnail3[3] + " ~ " + localthumbnail3[4]);
            } else {
                imgbtn_main_local3.setImageResource(R.drawable.ic_launcher_foreground);
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }//메인화면 지역별 랜덤 3개 축제 띄우기
        ////////////////////////////////////////////////////////////////////////////////////////////////////

        Thread seasonThread = new Thread() {

            @Override
            public void run() {
                // TODO Auto-generated method stub
                int errCount = 7;
                Parse_Data_season();//아래 메소드를 호출하여 XML data를 파싱해서 String 객체로 얻어오기
                bitmap1 = bitmapFromUrl(seasonthumbnail1[0]);
                bitmap2 = bitmapFromUrl(seasonthumbnail2[0]);
                bitmap3 = bitmapFromUrl(seasonthumbnail3[0]);
                while (errCount >= 0) {
                    if (bitmap1 != null) {
                        break;
                    } else {
                        Parse_Data_season();
                        bitmap1 = bitmapFromUrl(seasonthumbnail1[0]);
                        bitmap2 = bitmapFromUrl(seasonthumbnail2[0]);
                        bitmap3 = bitmapFromUrl(seasonthumbnail3[0]);
                        errCount -= 1;
                        continue;
                    }
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        seasonThread.start();

        try {
            seasonThread.join();

            if (bitmap1 != null) {
                imgbtn_main_wheather1.setImageBitmap(bitmap1);
                txt_wheather_title1.setText(seasonthumbnail1[1]);
                txt_wheather_where1.setText(seasonthumbnail1[2]);
                txt_wheather_date1.setText(seasonthumbnail1[3] + " ~ " + seasonthumbnail1[4]);
            } else {
                imgbtn_main_wheather1.setImageResource(R.drawable.ic_launcher_foreground);
            }


            if (bitmap2 != null) {
                imgbtn_main_wheather2.setImageBitmap(bitmap2);
                txt_wheather_title2.setText(seasonthumbnail2[1]);
                txt_wheather_where2.setText(seasonthumbnail2[2]);
                txt_wheather_date2.setText(seasonthumbnail2[3] + " ~ " + seasonthumbnail2[4]);
            } else {
                imgbtn_main_wheather2.setImageResource(R.drawable.ic_launcher_foreground);
            }

            if (bitmap3 != null) {
                imgbtn_main_wheather3.setImageBitmap(bitmap3);
                txt_wheather_title3.setText(seasonthumbnail3[1]);
                txt_wheather_where3.setText(seasonthumbnail3[2]);
                txt_wheather_date3.setText(seasonthumbnail3[3] + " ~ " + seasonthumbnail3[4]);
            } else {
                imgbtn_main_wheather3.setImageResource(R.drawable.ic_launcher_foreground);
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }//메인화면 계절별 랜덤 3개 축제 띄우기
///////////////////////////////////////////////////////////////

    imgbtn_main_hot1.setOnClickListener(new View.OnClickListener(){
        @Override
        public void onClick(View view) {
            Intent hot1Intent =
        }
    });


    }
}

