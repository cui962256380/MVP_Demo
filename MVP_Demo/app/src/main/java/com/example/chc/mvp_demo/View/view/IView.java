package com.example.chc.mvp_demo.View.view;

import com.example.chc.mvp_demo.View.data.bean.Joke;

import java.util.List;

/**
 * Created by Administrator on 2017/1/16.
 */

public interface IView {
       void setData(List<Joke> joke);
}
