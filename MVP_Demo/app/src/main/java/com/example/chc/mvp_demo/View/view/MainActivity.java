package com.example.chc.mvp_demo.View.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import com.example.chc.mvp_demo.R;
import com.example.chc.mvp_demo.View.data.bean.Joke;
import com.example.chc.mvp_demo.View.persenter.JokePersenter;

import java.io.IOException;
import java.util.List;

public class MainActivity extends AppCompatActivity implements  IView{
    private JokePersenter mJokepersenter = new JokePersenter(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        try {
            mJokepersenter.setData();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void setData(List<Joke> joke) {
        Toast.makeText(this,"Joke.size"+joke.size(),Toast.LENGTH_SHORT).show();
    }



}
