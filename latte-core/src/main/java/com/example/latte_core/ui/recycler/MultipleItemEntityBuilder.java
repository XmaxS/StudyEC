package com.example.latte_core.ui.recycler;

import java.lang.reflect.Field;
import java.util.LinkedHashMap;
import java.util.WeakHashMap;

public class MultipleItemEntityBuilder {

    private static final LinkedHashMap<Object,Object> FIELD = new LinkedHashMap<>();

    public MultipleItemEntityBuilder() {
        //先清楚之前的数据
        FIELD.clear();
    }

    public final MultipleItemEntityBuilder setItemType(int itemType){
        FIELD.put(MultipleFields.ITEM_TYPE,itemType);
        return this;
    }

    public final MultipleItemEntityBuilder setField(Object key,Object value){
        FIELD.put(key,value);
        return this;
    }

    public final MultipleItemEntityBuilder setFields(WeakHashMap<?,?> map){
        FIELD.putAll(map);
        return this;
    }

    public final MultipleItemEntity build(){
        return new MultipleItemEntity(FIELD);
    }
}
