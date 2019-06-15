package com.example.latte_core.ui.recycler;

import java.util.ArrayList;

//数据转换的约束
public abstract class DataConverter {

    protected final ArrayList<MultipleItemEntity> ENTITIES = new ArrayList<>();

    private String mJsonData = null;

    public abstract ArrayList<MultipleItemEntity> convert();

    public DataConverter setJsonData(String json){
        this.mJsonData = json;
        return this;
    }

    protected String getmJsonData(){
        if (mJsonData == null || mJsonData.isEmpty()){
            throw new NullPointerException("Data is Null!");
        }
        return mJsonData;
    }
}
