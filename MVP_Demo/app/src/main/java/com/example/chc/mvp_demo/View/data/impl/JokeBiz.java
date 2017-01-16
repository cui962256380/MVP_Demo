package com.example.chc.mvp_demo.View.data.impl;

import com.example.chc.mvp_demo.View.api.ApiKey;
import com.example.chc.mvp_demo.View.data.bean.Joke;
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

    final  String URL="http://japi.juhe.cn/joke/content/list.from";


    @Override
    public void getJokeData(final OnGetDataListener monGetDataListener) throws IOException {
        new Thread(new Runnable(){
            @Override
            public void run() {
                List<Joke> mlist = null;
                OkHttpClient client = new OkHttpClient();
                RequestBody formBody = new FormBody.Builder()
                        .add("sort", "desc")//传入参数
                        .add("page", "1")//传入参数
                        .add("pagesize", "20")//传入参数
                        .add("time", "1418816972")
                        .add("key", ApiKey.JOKEAPIKEY)
                        .build();
                Request request = new Request.Builder()
                        .url(URL)
                        .post(formBody)
                        .build();
                Response response = null;
                try {
                    response = client.newCall(request).execute();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                if (response.isSuccessful()) {         Gson gson = new Gson();
                    Type founderListType = new TypeToken<ArrayList<Joke>>() { }.getType();
                    mlist= gson.fromJson(response.body().toString(), founderListType);
                    try {
                        monGetDataListener.getSuccess(null);
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
