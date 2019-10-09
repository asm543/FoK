package com.example.fok;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.InputStreamReader;
import java.net.URL;
import java.text.NumberFormat;
import java.text.ParseException;

public class MainFragment extends Fragment implements OnMapReadyCallback {
    public static final String MYKEY = "IPbBi9DbtpkIHLLYxiEdNhiPoe%2B2ZzZWPHoag%2FeAOimpSX%2FCAZW4%2FU8CmowZTEuFFzgXP3%2FRAuH%2FZYJQ2fQgxQ%3D%3D";


    View rootView;
    MapView mapView;

    String mapx="37.0";
    String mapy="132.0";

    boolean inmapx =false , inmapy = false;
    String title="테스트";
    double x=37.0,y=132.0;
    String id = "";



    public MainFragment() {
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.map_detail, container, false);
        mapView = (MapView) rootView.findViewById(R.id.mapview);
        mapView.onCreate(savedInstanceState);

        mapView.getMapAsync(this);



        Bundle bundle = getArguments();


        if(bundle != null) {
            id = bundle.getString("id");
            title = bundle.getString("id2");
        }
        else {
            id = "";
        }

        Thread DetailThread = new Thread() {
            @Override
            public void run() {
                // TODO Auto-generated method stub
                Parse_Data_Common();
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

        } catch (InterruptedException e) {
            e.printStackTrace();
        } // 콘텐츠 코드로 데이터 불러오기
        return rootView;
    }


    @Override
    public void onResume() {
        mapView.onResume();
        super.onResume();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mapView.onDestroy();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mapView.onLowMemory();
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {

        MapsInitializer.initialize(this.getActivity());
//



// Updates the location and zoom of the MapView
        CameraUpdate cameraUpdate = CameraUpdateFactory.newLatLngZoom(new LatLng(Double.parseDouble(mapy), Double.parseDouble(mapx)), 14);

        googleMap.animateCamera(cameraUpdate);

        googleMap.addMarker(new MarkerOptions()
                .position(new LatLng(Double.parseDouble(mapy), Double.parseDouble(mapx)))
                .title(title));

    }

    private void Parse_Data_Common() {

        try {
            URL url = new URL("http://api.visitkorea.or.kr/openapi/service/rest/KorService/detailCommon?ServiceKey="+MYKEY+"&contentId="+id+"&defaultYN=Y&firstImageYN=Y&addrinfoYN=Y&mapinfoYN=Y&overviewYN=Y&MobileOS=ETC&MobileApp=FOK"
            );
            XmlPullParserFactory parserCreator = XmlPullParserFactory.newInstance();
            XmlPullParser parser = parserCreator.newPullParser();

            parser.setInput(new InputStreamReader(url.openStream(), "UTF-8"));

            int parserEvent = parser.getEventType();
            System.out.println("파싱시작합니다.");

            while (parserEvent != XmlPullParser.END_DOCUMENT) {
                switch (parserEvent) {
                    case XmlPullParser.START_TAG://parser가 시작 태그를 만나면 실행
                        if (parser.getName().equals("mapx")) { // 주소
                            inmapx = true;
                        }
                        if (parser.getName().equals("mapy")) { // 주소
                            inmapy = true;
                        }
                        if (parser.getName().equals("message")) {
                            //오류시 메세지
                        }
                        break;

                    case XmlPullParser.TEXT://parser가 내용에 접근했을때
                        if (inmapx) {
                            mapx = parser.getText();
                            inmapx = false;
                        }

                        if (inmapy) {
                            mapy = parser.getText();
                            inmapy = false;
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

    } //공통정보 조회
}