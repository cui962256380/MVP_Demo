package com.example.chc.mvp_demo.View.view;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Adapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.chc.mvp_demo.R;
import com.example.chc.mvp_demo.View.data.adapter.MyAdapter;
import com.example.chc.mvp_demo.View.data.bean.Joke;
import com.example.chc.mvp_demo.View.persenter.JokePersenter;

import java.io.IOException;
import java.util.List;

public class MainActivity extends AppCompatActivity implements  IView{
    private JokePersenter mJokepersenter = new JokePersenter(this);
    ListView lv;
    public MyAdapter myAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv= (ListView) findViewById(R.id.mList);
        try {
            mJokepersenter.bindItem();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public ListView getListView() {
        return lv;
    }

    @Override
    public Context getContext() {
        return this;
    }


}
