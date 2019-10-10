package com.example.fok;

import android.graphics.Bitmap;

public class ListViewItem {
    private Bitmap iconDrawable ;
    private String titleStr ;
    private String descStr ;
    private String contentidStr;


    public void setIcon(Bitmap icon) {
        iconDrawable = icon ;
    }
    public void setTitle(String title) {
        titleStr = title ;
    }
    public void setDesc(String desc) {
        descStr = desc ;
    }
    public void setContentid(String contentid) { contentidStr = contentid ;
    }

    public Bitmap getIcon() {
        return this.iconDrawable ;
    }
    public String getTitle() {
        return this.titleStr ;
    }
    public String getDesc() {
        return this.descStr ;
    }
    public String getContentid() {
        return this.contentidStr ;
    }
}