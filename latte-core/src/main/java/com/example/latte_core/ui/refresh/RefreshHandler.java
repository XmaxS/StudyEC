package com.example.latte_core.ui.refresh;

import android.provider.ContactsContract;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.latte_core.app.Latte;
import com.example.latte_core.net.RestClient;
import com.example.latte_core.net.callback.ISuccess;
import com.example.latte_core.ui.recycler.DataConverter;
import com.example.latte_core.ui.recycler.MultipleRecyclerAdapter;

public class RefreshHandler implements
        SwipeRefreshLayout.OnRefreshListener
        , BaseQuickAdapter.RequestLoadMoreListener {

    private final SwipeRefreshLayout REFRESH_LAYOUT;
    private final PagingBean BEAN;
    private final RecyclerView RECYCLERVIEW;
    private MultipleRecyclerAdapter mAdapter = null;
    private final DataConverter CONVERTER;

    public RefreshHandler(SwipeRefreshLayout REFRESH_LAYOUT,
                          RecyclerView RECYCLERVIEW,
                          DataConverter CONVERTER,
                          PagingBean BEAN) {
        this.REFRESH_LAYOUT = REFRESH_LAYOUT;
        this.BEAN = BEAN;
        this.RECYCLERVIEW = RECYCLERVIEW;
        this.CONVERTER = CONVERTER;
    }

    public static RefreshHandler create(SwipeRefreshLayout REFRESH_LAYOUT,
                                        RecyclerView RECYCLERVIEW,
                                        DataConverter CONVERTER){
        return new RefreshHandler(REFRESH_LAYOUT,RECYCLERVIEW,CONVERTER,new PagingBean());

    }

    private void refresh(){
        REFRESH_LAYOUT.setRefreshing(true);
        Latte.getHandler().postDelayed(new Runnable() {
            @Override
            public void run() {
//                在这里进行一些网络请求
                REFRESH_LAYOUT.setRefreshing(false);
            }
        },2000);
    }

    public void firstPage(String url){
        BEAN.setmDelayed(1000);
        RestClient.builder()
                .url(url)
                .success(new ISuccess() {
                    @Override
                    public void onSuccess(String response) {
                        final JSONObject object = JSON.parseObject(response);
                        BEAN.setmTotal(object.getInteger("total"))
                                .setmPageSize(object.getInteger("page_size"));
                        //设置Adapter
                        mAdapter = MultipleRecyclerAdapter.create(CONVERTER.setJsonData(response));
                        mAdapter.setOnLoadMoreListener(RefreshHandler.this,RECYCLERVIEW);
                        RECYCLERVIEW.setAdapter(mAdapter);
                        BEAN.addIndex();

                    }
                })
                .build()
                .get();

    }

    @Override
    public void onRefresh() {

    }

    @Override
    public void onLoadMoreRequested() {

    }
}
