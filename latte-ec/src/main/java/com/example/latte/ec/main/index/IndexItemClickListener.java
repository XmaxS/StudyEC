package com.example.latte.ec.main.index;

import android.view.View;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.SimpleClickListener;
import com.example.latte.ec.detail.GoodsDetailDelegate;
import com.example.latte_core.delegates.LatteDelegate;

public class IndexItemClickListener extends SimpleClickListener {

    private final LatteDelegate DELEGATE;

    public IndexItemClickListener(LatteDelegate DELEGATE) {
        this.DELEGATE = DELEGATE;
    }

    public static SimpleClickListener create(LatteDelegate DELEGATE){
        return new IndexItemClickListener(DELEGATE);
    }

    //    一般实现这一个就够了
    @Override
    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
        final GoodsDetailDelegate delegate = GoodsDetailDelegate.create();
//        DELEGATE.start(delegate);
    }

    @Override
    public void onItemLongClick(BaseQuickAdapter adapter, View view, int position) {

    }

    @Override
    public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {

    }

    @Override
    public void onItemChildLongClick(BaseQuickAdapter adapter, View view, int position) {

    }
}
