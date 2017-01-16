package com.example.chc.mvp_demo.View.persenter;

import com.example.chc.mvp_demo.View.data.bean.Joke;
import com.example.chc.mvp_demo.View.data.impl.IJoke;
import com.example.chc.mvp_demo.View.data.impl.JokeBiz;
import com.example.chc.mvp_demo.View.data.impl.OnGetDataListener;
import com.example.chc.mvp_demo.View.view.IView;

import java.io.IOException;
import java.util.List;

/**
 * Created by Administrator on 2017/1/16.
 */

public class JokePersenter{

    public IJoke jokebiz;
    public IView iView;

    public JokePersenter(IView iView){
        this.iView=iView;
        this.jokebiz=new JokeBiz();
    }

   public void setData() throws IOException {
       jokebiz.getJokeData(new OnGetDataListener() {
            @Override
            public void getSuccess(List<Joke> mlist) throws IOException {
                iView.setData(mlist);
            }

            @Override
            public void getFailed() {

            }
        });
   }




}
