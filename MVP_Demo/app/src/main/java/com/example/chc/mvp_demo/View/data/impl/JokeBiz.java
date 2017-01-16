package com.example.chc.mvp_demo.View.data.impl;

import com.example.chc.mvp_demo.View.api.ApiKey;
import com.example.chc.mvp_demo.View.data.bean.Joke;
import com.example.chc.mvp_demo.View.data.bean.Result;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Created by Administrator on 2017/1/16.
 */

public class JokeBiz implements  IJoke{

    final  String URL="http://japi.juhe.cn/joke/content/list.from?key="+ApiKey.JOKEAPIKEY+"&page=1&pagesize=20&sort=asc&time=1418745237";


    @Override
    public void getJokeData(final OnGetDataListener monGetDataListener) throws IOException {
        new Thread(new Runnable(){
            @Override
            public void run() {
                List<Joke> mlist = null;
                OkHttpClient client = new OkHttpClient();
                Request request = new Request.Builder()
                        .url(URL)
                        .get()
                        .build();
                Response response = null;
                try {
                    response = client.newCall(request).execute();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                if (response.isSuccessful()) {
                    Gson gson = new Gson();
                    try {
                        String body=response.body().string().toString();
                        Result result   =gson.fromJson(body, Result.class);
                        mlist=result.result.data;
                        monGetDataListener.getSuccess(mlist);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else {
                    try {
                        throw new IOException("Unexpected code " + response);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

    }
}
