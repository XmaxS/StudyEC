package com.example.latte_core.net.callback;


public interface IRequest {

    //加载圈开始转
    void onRequestStart();

    //加载圈消失
    void onRequestEnd();
}
