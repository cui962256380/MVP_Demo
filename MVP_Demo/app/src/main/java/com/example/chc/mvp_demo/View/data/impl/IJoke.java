package com.example.chc.mvp_demo.View.data.impl;

import com.example.chc.mvp_demo.View.data.bean.Joke;

import java.io.IOException;
import java.util.List;

/**
 * Created by Administrator on 2017/1/16.
 */

public  interface IJoke {
    void getJokeData(OnGetDataListener onGetDataListener) throws IOException;
}
