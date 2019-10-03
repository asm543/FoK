package com.example.fok;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.InputStreamReader;
import java.net.URL;
import java.util.Random;

public class DetailActivity extends AppCompatActivity {

    TextView textView;








//    private String Parse_Data_season() {
//        result = "";
//        Random random = new Random();
//        randomNum = random.nextInt(1000) + 1;
//
//
//        String nowYear = getYear();
//        String nowMonth = getMonth();
//        String endMonth = null;
//        if (nowMonth == "12" || nowMonth == "01" || nowMonth == "02") {
//            nowMonth = "12";
//            endMonth = "02";
//
//        } else if (nowMonth == "03" || nowMonth == "04" || nowMonth == "05") {
//            nowMonth = "03";
//            endMonth = "05";
//        } else if (nowMonth == "06" || nowMonth == "07" || nowMonth == "08") {
//            nowMonth = "06";
//            endMonth = "08";
//        } else {
//            nowMonth = "09";
//            endMonth = "11";
//        }
//        try {
//            URL url = new URL("http://api.visitkorea.or.kr/openapi/service/rest/KorService/searchFestival?serviceKey=" + MYKEY + "&numOfRows=3&pageNo=" + randomNum + "&MobileOS=ETC&MobileApp=FoK&arrange=P&listYN=Y&eventStartDate=" + nowYear + nowMonth + "01&eventEndDate=" + nowYear + endMonth + "31"
//            );
//            XmlPullParserFactory parserCreator = XmlPullParserFactory.newInstance();
//            XmlPullParser parser = parserCreator.newPullParser();
//
//            parser.setInput(new InputStreamReader(url.openStream(), "UTF-8"));
//
//            int parserEvent = parser.getEventType();
//            System.out.println("파싱시작합니다.");
//
//            while (parserEvent != XmlPullParser.END_DOCUMENT) {
//                switch (parserEvent) {
//                    case XmlPullParser.START_TAG://parser가 시작 태그를 만나면 실행
//
//                        if (parser.getName().equals("addr1")) { // 주소
//                            inaddr1 = true;
//                        }
//
//                        if (parser.getName().equals("areacode")) { // 주소
//                            inareacode = true;
//                        }
//                        if (parser.getName().equals("cat1")) { // 주소
//                            incat1 = true;
//                        }
//                        if (parser.getName().equals("cat2")) { // 주소
//                            incat2 = true;
//                        }
//                        if (parser.getName().equals("cat3")) { // 주소
//                            incat3 = true;
//                        }
//                        if (parser.getName().equals("contentid")) { // 주소
//                            incontentid = true;
//                        }
//                        if (parser.getName().equals("contenttypeid")) { // 주소
//                            incontenttypeid = true;
//                        }
//                        if (parser.getName().equals("createdtime")) { // 주소
//                            increatedtime = true;
//                        }
//                        if (parser.getName().equals("eventstartdate")) { // 주소
//                            ineventstartdate = true;
//                        }
//                        if (parser.getName().equals("eventenddate")) { // 주소
//                            ineventenddate = true;
//                        }
//                        if (parser.getName().equals("firstimage")) { // 주소
//                            infirstimage = true;
//                        }
//                        if (parser.getName().equals("firstimage2")) { // 주소
//                            infirstimage2 = true;
//                        }
//                        if (parser.getName().equals("mapx")) { // 주소
//                            inmapx = true;
//                        }
//                        if (parser.getName().equals("mapy")) { // 주소
//                            inmapy = true;
//                        }
//                        if (parser.getName().equals("mlevel")) { // 주소
//                            inmlevel = true;
//                        }
//                        if (parser.getName().equals("modifiedtime")) { // 주소
//                            inmodifiedtime = true;
//                        }
//                        if (parser.getName().equals("sigungucode")) { // 주소
//                            insigungucode = true;
//                        }
//                        if (parser.getName().equals("tel")) { // 주소
//                            intel = true;
//                        }
//                        if (parser.getName().equals("title")) { // 주소
//                            intitle = true;
//                        }
//
//
//                        if (parser.getName().equals("message")) {
//                            txt_wheather_title1.setText("정보 불러오기 실패! 다시 시도해주세요.");
//                            txt_wheather_title2.setText("정보 불러오기 실패! 다시 시도해주세요.");
//                            txt_wheather_title3.setText("정보 불러오기 실패! 다시 시도해주세요.");
//                            txt_wheather_date1.setText("");
//                            txt_wheather_date2.setText("");
//                            txt_wheather_date3.setText("");
//                            txt_wheather_where1.setText("");
//                            txt_wheather_where2.setText("");
//                            txt_wheather_where2.setText("");
//
//                        }
//                        break;
//
//                    case XmlPullParser.TEXT://parser가 내용에 접근했을때
//
//                        if (inaddr1) {
//                            addr1 = parser.getText();
//                            inaddr1 = false;
//                        }
//                        if (inareacode) {
//                            areacode = parser.getText();
//                            inareacode = false;
//                        }
//
//                        if (incat1) {
//                            cat1 = parser.getText();
//                            incat1 = false;
//                        }
//
//                        if (incat2) {
//                            cat2 = parser.getText();
//                            incat2 = false;
//                        }
//
//                        if (incat3) {
//                            cat3 = parser.getText();
//                            incat3 = false;
//                        }
//
//                        if (incontentid) {
//                            contentid = parser.getText();
//                            incontentid = false;
//                        }
//
//                        if (incontenttypeid) {
//                            contenttypeid = parser.getText();
//                            incontenttypeid = false;
//                        }
//
//                        if (increatedtime) {
//                            createdtime = parser.getText();
//                            increatedtime = false;
//                        }
//
//                        if (ineventstartdate) {
//                            eventstartdate = parser.getText();
//                            ineventstartdate = false;
//                        }
//
//                        if (ineventenddate) {
//                            eventenddate = parser.getText();
//                            ineventenddate = false;
//                        }
//
//                        if (infirstimage) {
//                            firstimage = parser.getText();
//                            infirstimage = false;
//                        }
//
//                        if (infirstimage2) {
//                            firstimage2 = parser.getText();
//                            infirstimage2 = false;
//                        }
//
//                        if (inmapx) {
//                            mapx = parser.getText();
//                            inmapx = false;
//                        }
//                        if (inmapy) {
//                            mapy = parser.getText();
//                            inmapy = false;
//                        }
//                        if (inmlevel) {
//                            mlevel = parser.getText();
//                            inmlevel = false;
//                        }
//                        if (inmodifiedtime) {
//                            modifiedtime = parser.getText();
//                            inmodifiedtime = false;
//                        }
//
//                        if (insigungucode) {
//                            sigungucode = parser.getText();
//                            insigungucode = false;
//                        }
//                        if (intel) {
//                            tel = parser.getText();
//                            intel = false;
//                        }
//                        if (intitle) {
//                            title = parser.getText();
//                            intitle = false;
//                        }
//
//                        break;
//                    case XmlPullParser.END_TAG:
//                        if (parser.getName().equals("item")) {
//                            result += "\n" + addr1 + "\n" + areacode + "\n" + cat1 + "\n" + cat2 + "\n" + cat3 + "\n" + contentid + "\n" + contenttypeid + "\n" + createdtime + "\n" + eventstartdate + "\n" + eventenddate + "\n" + firstimage + "\n" + firstimage2 + "\n" + mapx + "\n" + mapy + "\n" + mlevel + "\n" + modifiedtime + "\n" + sigungucode + "\n" + tel + "\n" + title + "\n";
//                            if (seasonthumbnail1[0] == null) {
//                                seasonthumbnail1[0] = firstimage;
//                                seasonthumbnail1[1] = title;
//                                seasonthumbnail1[2] = addr1;
//                                seasonthumbnail1[3] = eventstartdate;
//                                seasonthumbnail1[4] = eventenddate;
//                                seasonthumbnail1[5] = contentid;
//
////                                        textView.setText(seasonthumbnailContentid + seasonthumbnailImage + seasonthumbnailTitle);
////                                        intoImageView(seasonthumbnailImage,button1);
//                            } else if (seasonthumbnail2[0] == null) {
//                                seasonthumbnail2[0] = firstimage;
//                                seasonthumbnail2[1] = title;
//                                seasonthumbnail2[2] = addr1;
//                                seasonthumbnail2[3] = eventstartdate;
//                                seasonthumbnail2[4] = eventenddate;
//                                seasonthumbnail2[5] = contentid;
////                                        textView.setText(seasonthumbnailContentid2 + seasonthumbnailImage2 + seasonthumbnailTitle2);
////                                        intoImageView(seasonthumbnailImage2,button2);
//                            } else if (seasonthumbnail3[0] == null) {
//                                seasonthumbnail3[0] = firstimage;
//                                seasonthumbnail3[1] = title;
//                                seasonthumbnail3[2] = addr1;
//                                seasonthumbnail3[3] = eventstartdate;
//                                seasonthumbnail3[4] = eventenddate;
//                                seasonthumbnail3[5] = contentid;
////                                        textView.setText(seasonthumbnailContentid3 + seasonthumbnailImage3 + seasonthumbnailTitle3);
////                                        intoImageView(seasonthumbnailImage3,button3);
//                            }
//                        }
//                        break;
//                }
//                parserEvent = parser.next();
//            }
//
//        } catch (Exception e) {
//
//            e.printStackTrace();
//        }
//
//
//        return result;
//    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        textView = (TextView)findViewById(R.id.textView);

        Intent intent = new Intent(this.getIntent());
        String s = intent.getStringExtra("id");
        textView.setText(s);
    }
}
