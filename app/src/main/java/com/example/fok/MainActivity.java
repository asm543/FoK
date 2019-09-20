package com.example.fok;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.Button;
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

    String totalCount = null, addr1 = null, addr2 = null, areacode = null, cat1 = null, cat2 = null, cat3 = null, contentid = null;
    String contenttypeid = null, createdtime = null, eventstartdate = null, eventenddate = null, firstimage = null, firstimage2 = null;
    String mapx = null, mapy = null, mlevel = null, modifiedtime = null, readcount = null, sigungucode = null, tel = null, title = null;
    String result = null;

    boolean intotalCount = false, inaddr1 = false, inaddr2 = false, inareacode = false, incat1 = false, incat2 = false, incat3 = false, incontentid = false, incontenttypeid = false;
    boolean increatedtime = false, ineventstartdate = false, ineventenddate = false, infirstimage = false, infirstimage2 = false, inmapx = false;
    boolean inmapy = false, inmlevel = false, inmodifiedtime = false, inreadcount = false, insigungucode = false , intel= false,intitle = false;

    long mNow;
    Date mDate;
    int randomNum = 1;

    String seasonthumbnailImage = null, seasonthumbnailTitle = null, seasonthumbnailContentid =null;
    String seasonthumbnailImage2 = null, seasonthumbnailTitle2 = null, seasonthumbnailContentid2 =null;
    String seasonthumbnailImage3 = null, seasonthumbnailTitle3 = null, seasonthumbnailContentid3 =null;


    TextView textView, textView2;
    ImageButton button543;

    private String getYear(){
        mNow = System.currentTimeMillis();
        mDate = new Date(mNow);
        return Year.format(mDate);
    }// 현재 년도 구하기 메소드
    private String getMonth(){
        mNow = System.currentTimeMillis();
        mDate = new Date(mNow);
        return Month.format(mDate);
    }//현재 월 구하기 메소드
    private String getDay(){
        mNow = System.currentTimeMillis();
        mDate = new Date(mNow);
        return Day.format(mDate);
    }//현재 일 구하기 메소드

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
    } //미리보기 이미지 불러오기 메소드

    public void  intoImageView(ImageView iv, Bitmap bitmap){

        if(bitmap != null){
            iv.setImageBitmap(bitmap);
        }
        else {
            iv.setImageResource(R.drawable.ic_launcher_foreground);
        }
    } //이미지 삽입 메소드

    private String Parse_Data(){
        result ="";
        Random random = new Random();
        randomNum = random.nextInt(100)+1;
        String nowYear = getYear();
        String nowMonth = getMonth();
        String endMonth = null;
        seasonthumbnailImage = "";
        seasonthumbnailTitle = "";
        seasonthumbnailContentid ="";
        seasonthumbnailImage2 = "";
        seasonthumbnailTitle2 = "";
        seasonthumbnailContentid2 ="";
        seasonthumbnailImage3 = "";
        seasonthumbnailTitle3 = "";
        seasonthumbnailContentid3 ="";
        if(nowMonth == "12" || nowMonth == "01" || nowMonth == "02"){
            nowMonth = "12";
            endMonth = "02";

        }
        else if (nowMonth == "03" || nowMonth == "04" || nowMonth == "05"){
            nowMonth = "03";
            endMonth = "05";
        }
        else if (nowMonth == "06" || nowMonth == "07" || nowMonth == "08"){
            nowMonth = "06";
            endMonth = "08";
        }
        else{
            nowMonth = "09";
            endMonth = "11";
        }
        try {
            URL url = new URL("http://api.visitkorea.or.kr/openapi/service/rest/KorService/searchFestival?serviceKey=" + MYKEY + "&numOfRows=3&pageNo="+ randomNum+"&MobileOS=ETC&MobileApp=FoK&arrange=A&listYN=Y&eventStartDate=" + nowYear  + nowMonth+"01&eventEndDate="+nowYear+endMonth+"31"
            );
            XmlPullParserFactory parserCreator = XmlPullParserFactory.newInstance();
            XmlPullParser parser = parserCreator.newPullParser();

            parser.setInput( new InputStreamReader(url.openStream(), "UTF-8") );

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
                            textView2.setText("정보 불러오기 실패! 다시 시도해주세요.");
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
                            result +="\n" +addr1 +"\n" +areacode+"\n" +cat1+"\n" +cat2+"\n" +cat3+"\n" +contentid+"\n" +contenttypeid+"\n" +createdtime+"\n" +eventstartdate+"\n" +eventenddate+"\n" +firstimage+"\n" +firstimage2+"\n" +mapx+"\n" +mapy+"\n" +mlevel+"\n" +modifiedtime+"\n" +sigungucode+"\n" +tel+"\n" +title+"\n";
                            if(seasonthumbnailContentid == ""){
                            seasonthumbnailImage = firstimage2;
                            seasonthumbnailTitle = title;
                            seasonthumbnailContentid = contentid;
                                textView.setText(seasonthumbnailContentid + seasonthumbnailImage + seasonthumbnailTitle);
                                intoImageView(button543,bitmapFromUrl(seasonthumbnailImage));
                            }
                            else if(seasonthumbnailContentid2 ==""){
                                seasonthumbnailImage2 = firstimage2;
                                seasonthumbnailTitle2 = title;
                                seasonthumbnailContentid2 = contentid;
                            }
                            else {
                                seasonthumbnailImage3 = firstimage2;
                                seasonthumbnailTitle3 = title;
                                seasonthumbnailContentid3 = contentid;
                            }
                        }
                        break;
                }
                parserEvent = parser.next();
            }

        } catch (Exception e) {
            textView2.setText("ERROR");
            e.printStackTrace();
        }
        return result;
    } // 축제 정보 조회 - 계절별, 3개 랜덤

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


        textView = (TextView) findViewById(R.id.textView);
        button543 = (ImageButton) findViewById(R.id.button543);


        new Thread() {
            public void run() {

                String parsing = Parse_Data();

                Bundle bun = new Bundle();
                bun.putString("HTML_DATA",parsing);

                Message msg = handler.obtainMessage();
                msg.setData(bun);
                handler.sendMessage(msg);
            }
        }.start();





    }
}
