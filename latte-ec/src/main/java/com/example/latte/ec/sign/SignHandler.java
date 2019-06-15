package com.example.latte.ec.sign;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.latte.ec.database.DatabaseManager;
import com.example.latte.ec.database.UserProfile;
import com.example.latte_core.app.AccountManager;


public class SignHandler {

    public static void onSignIn(String response, ISignListener signListener) {
        final JSONObject profileJson = JSON.parseObject(response).getJSONObject("data");
        final long userId = profileJson.getLong("userId");
        final String username = profileJson.getString("username");
        final String userpassword = profileJson.getString("userpassword");
        final String useremail = profileJson.getString("useremail");
        final String useraddress = profileJson.getString("useraddress");

        final UserProfile profile = new UserProfile(userId, username, userpassword, useremail, useraddress);
        DatabaseManager.getInstance().getDao().insert(profile);

        //已经注册并登录成功了
        AccountManager.setSignState(true);
        signListener.onSignInSuccess();
    }


    public static void onSignUp(String response, ISignListener signListener) {
        final JSONObject profileJson = JSON.parseObject(response);
        final long userId = profileJson.getLong("userId");
        final String username = profileJson.getString("username");
        final String userpassword = profileJson.getString("userpassword");
        final String useremail = profileJson.getString("useremail");
        final String useraddress = profileJson.getString("useraddress");

        final UserProfile profile = new UserProfile(userId, username, userpassword, useremail, useraddress);
        DatabaseManager.getInstance().getDao().insert(profile);

        //已经注册并登录成功了
        AccountManager.setSignState(true);
        signListener.onSignUpSuccess();
    }
}
