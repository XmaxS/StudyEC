package com.example.bluexmax.studyec;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;

import android.widget.Toast;
import butterknife.OnClick;
import com.example.latte_core.delegates.LatteDelegate;
import com.example.latte_core.net.RestClient;
import com.example.latte_core.net.callback.IError;
import com.example.latte_core.net.callback.IFailure;
import com.example.latte_core.net.callback.ISuccess;

//这个类好像没什么用了
public class ExampleDelegate extends LatteDelegate {

    @Override
    public Object setLayout() {
        return R.layout.delegate_example;
    }

    @OnClick(R.id.btn_test)
    void onClickTest() {
        testWX();

    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, @NonNull View rootView) {
//        testRestClient();
    }

    private void testWX() {
    }

    private void testRestClient(){
        RestClient.builder()
                .url("http://127.0.0.1/index")
                .loader(getContext())
                .success(new ISuccess() {
                    @Override
                    public void onSuccess(String response) {
                        Toast.makeText(getContext(),response,Toast.LENGTH_LONG).show();
                    }
                })
                .failure(new IFailure() {
                    @Override
                    public void onFailure() {

                    }
                })
                .error(new IError() {
                    @Override
                    public void onError(int code, String msg) {

                    }
                })
                .build()
                .get();
    }
}
