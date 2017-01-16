package com.example.chc.mvp_demo.View.data.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.chc.mvp_demo.R;
import com.example.chc.mvp_demo.View.data.bean.Joke;

import java.util.List;
import java.util.zip.Inflater;

/**
 * Created by Administrator on 2017/1/16.
 */

public class MyAdapter extends BaseAdapter {
    public List<Joke> mlist;
    public Context context;
    public LayoutInflater inflater;

    public MyAdapter(List<Joke> mlist, Context context) {
        this.mlist = mlist;
        this.context = context;
        inflater= LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return mlist.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder vh=null;
        if(convertView==null){
            convertView=inflater.inflate(R.layout.item,null,false);
            vh=new ViewHolder(convertView);
            convertView.setTag(vh);
        }else{
            vh= (ViewHolder) convertView.getTag();
        }
        Joke jk=mlist.get(position);
        vh.tvContent.setText(jk.getContent());
        return convertView;
    }
    class ViewHolder{
        private TextView tvContent;

        public ViewHolder(View convertView) {
            tvContent= (TextView) convertView.findViewById(R.id.tvcontent);
        }
    }
}
