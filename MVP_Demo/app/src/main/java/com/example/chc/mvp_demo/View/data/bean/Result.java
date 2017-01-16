package com.example.chc.mvp_demo.View.data.bean;

import java.util.List;

/**
 * Created by Administrator on 2017/1/16.
 *
 */

public class Result {

    public int error_code;
    public String reason;
    public obj result;

    class obj {
        public List<Joke> data;
    }
}
