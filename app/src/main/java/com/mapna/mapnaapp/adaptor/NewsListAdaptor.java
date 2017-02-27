package com.mapna.mapnaapp.adaptor;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.mapna.mapnaapp.R;
import com.mapna.mapnaapp.customViews.customTextView;
import com.mapna.mapnaapp.models.News;

/**
 * Created by variani_h on 2/12/2017.
 */

public class NewsListAdaptor extends BaseAdapter {

    private Context mContext;
    private News[] NewsItemList;

    public NewsListAdaptor(Context mContext, News[] newsItemList) {
        this.mContext = mContext;
        NewsItemList = newsItemList;
    }

    @Override
    public int getCount() {
        return NewsItemList.length;
    }


    @Override
    public Object getItem(int position) {
        return NewsItemList[position];
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View rowView = LayoutInflater.from(mContext).inflate(R.layout.News_list_item, parent, false);

        customTextView title = (customTextView) rowView.findViewById(R.id.lblNews);
        title.setText(NewsItemList[position].getTitle());


        return rowView;
    }
}
