package com.example.latte_core.delegates.bottom;

import java.util.LinkedHashMap;


public final class ItemBuilder {

    //防止下方图标打开后乱序，所以使用Linked
    private final LinkedHashMap<BottomTabBean, BottomItemDelegate> ITEMS = new LinkedHashMap<>();

    //简单工厂模式
    static ItemBuilder builder() {
        return new ItemBuilder();
    }

    //一次加一个
    public final ItemBuilder addItem(BottomTabBean bean, BottomItemDelegate delegate) {
        ITEMS.put(bean, delegate);
        return this;
    }

    //一次性全加进来
    public final ItemBuilder addItems(LinkedHashMap<BottomTabBean, BottomItemDelegate> items) {
        ITEMS.putAll(items);
        return this;
    }

    public final LinkedHashMap<BottomTabBean, BottomItemDelegate> build() {
        return ITEMS;
    }
}
