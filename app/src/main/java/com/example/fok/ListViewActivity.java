package com.example.fok;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ListView;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Random;

public class ListViewActivity extends AppCompatActivity implements AbsListView.OnScrollListener {

    public static final String MYKEY = "IPbBi9DbtpkIHLLYxiEdNhiPoe%2B2ZzZWPHoag%2FeAOimpSX%2FCAZW4%2FU8CmowZTEuFFzgXP3%2FRAuH%2FZYJQ2fQgxQ%3D%3D";
    public String searchKeyword;

    String firstimage=null,title=null,eventenddate=null,eventstartdate=null,contentid=null;
    boolean infirstimage=false,intitle=false,ineventenddate=false,ineventstartdate=false,incontentid=false;

    String arrange = "Q";

    ListView listview;
    ListViewAdapter adapter;
    private boolean mLockListView;
    private LayoutInflater mInflater;
    String pageNo = "1";
    EditText editText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        editText = (EditText)findViewById(R.id.editText);
        Intent intent = new Intent(this.getIntent());
        searchKeyword = intent.getStringExtra("searchKeyword");
        editText.setText(searchKeyword);



        adapter = new ListViewAdapter();

        listview = (ListView) findViewById(R.id.listview1);
        View footer = getLayoutInflater().inflate(R.layout.activity_list_footer,null,false);
        listview.addFooterView(footer);
        listview.setOnScrollListener(this);
        listview.setAdapter(adapter);


        addItems();


            // 기본 생성 코드 및 ListView와 Adapter 생성 코드
            // ...

        // 위에서 생성한 listview에 클릭 이벤트 핸들러 정의.
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView parent, View v, int position, long id) {
                // get item
                ListViewItem item = (ListViewItem) parent.getItemAtPosition(position) ;

                String titleStr = item.getTitle() ;
                String descStr = item.getDesc() ;
                Bitmap iconDrawable = item.getIcon() ;
                String contentid = item.getContentid();

                Intent intent = new Intent(ListViewActivity.this,DetailActivity.class);
                intent.putExtra("id",contentid);
                startActivity(intent);

                // TODO : use item data.
            }
        }) ;

        editText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                editText.setText("");
            }
        });
//
//        마지막으로 ListView 아이템 클릭 이벤트에 대한 처리를 해줍니다. ListView 아이템이 클릭되었을 때 호출되는 onItemClick() 함수에서
//        ListView 아이템 정보를 가져오려면 파라미터로 전달되는 변수들을 사용하면 됩니다. 각 파라미터에 대한 설명은 아래와 같습니다.
//
//        parent : ListView 자체에 대한 참조.
//        view : 클릭이 발생한 View에 대한 참조.
//                position : Adapter에서의 view의 position.
//                id : 클릭된 아이템의 row id.
//        여기서 parent를 통해 getItemAtPosition() 함수를 사용하면 position에 해당하는 아이템 데이터를 가져올 수 있습니다.
//        단, getItemAtPosition() 함수의 리턴 타입은 Object 타입이므로 소스에서 정의한 아이템 데이터 타입으로 형변환을 해줘야 합니다.
    }
    //http://api.visitkorea.or.kr/openapi/service/rest/KorService/searchFestival?serviceKey=" + MYKEY + "&numOfRows=20&pageNo=1&MobileOS=ETC&MobileApp=FoK&arrange=Q&listYN=Y
    private void Parse_Data() {

        try {
            URL url = new URL("http://api.visitkorea.or.kr/openapi/service/rest/KorService/searchKeyword?ServiceKey="+MYKEY +"&contentTypeId=15&arrange="+ arrange +"&keyword="+searchKeyword+"&numOfRows=10&pageNo="+pageNo+"&MobileOS=ETC&MobileApp=FOK"
            );
            XmlPullParserFactory parserCreator = XmlPullParserFactory.newInstance();
            XmlPullParser parser = parserCreator.newPullParser();

            parser.setInput(new InputStreamReader(url.openStream(), "UTF-8"));

            int parserEvent = parser.getEventType();
            System.out.println("파싱시작합니다.");

            while (parserEvent != XmlPullParser.END_DOCUMENT) {
                switch (parserEvent) {
                    case XmlPullParser.START_TAG://parser가 시작 태그를 만나면 실행
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
                            infirstimage = true;
                        }
                        if (parser.getName().equals("title")) { // 주소
                            intitle = true;
                        }


                        if (parser.getName().equals("message")) {
                        }
                        break;

                    case XmlPullParser.TEXT://parser가 내용에 접근했을때
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

                        if (infirstimage) {
                            firstimage = parser.getText();
                            infirstimage = false;
                        }
                        if (intitle) {
                            title = parser.getText();
                            intitle = false;
                        }

                        break;
                    case XmlPullParser.END_TAG:
                        if (parser.getName().equals("item")) {
                            adapter.addItem(bitmapFromUrl(firstimage), title,eventstartdate + "~" + eventenddate,contentid ) ;
                        }
                        break;
                }
                parserEvent = parser.next();
            }

        } catch (Exception e) {

            e.printStackTrace();
        }


//        return result;
    }
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
    public void onScrollStateChanged(AbsListView absListView, int i) {

    }

    public void onScroll(AbsListView view, int firstVisibleItem,
                         int visibleItemCount, int totalItemCount)
    {
        // 현재 가장 처음에 보이는 셀번호와 보여지는 셀번호를 더한값이
        // 전체의 숫자와 동일해지면 가장 아래로 스크롤 되었다고 가정합니다.
        int count = totalItemCount - visibleItemCount+1;

        if(firstVisibleItem+1 >= count && totalItemCount != 0
                && mLockListView == false)
        {
            pageNo = String.valueOf((Integer.parseInt(pageNo) + 1));
            addItems();
        }
    }
    private void addItems()
    {
        // 아이템을 추가하는 동안 중복 요청을 방지하기 위해 락을 걸어둡니다.
        mLockListView = true;

        Thread hotThread = new Thread() {
            @Override
            public void run() {
                // TODO Auto-generated method stub
                Parse_Data();//아래 메소드를 호출하여 XML data를 파싱해서 String 객체로 얻어오기

            }
        };
        hotThread.start();

        try {
            hotThread.join();

            adapter.notifyDataSetChanged();
            mLockListView = false;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 속도의 딜레이를 구현하기 위한 꼼수
        Handler handler = new Handler();
        handler.postDelayed(hotThread, 3000);
    }

}
