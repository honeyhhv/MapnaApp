package com.mapna.mapnaapp.adaptor;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.mapna.mapnaapp.R;
import com.mapna.mapnaapp.models.DrawerListItem;
import com.mapna.mapnaapp.customViews.customTextView;

import java.util.List;

/**
 * Created by variani_h on 11/16/2016.
 */

public class DrawerListAdapter extends BaseAdapter {
    private Context mContext;
    private List<DrawerListItem> drawerListItemList;

    public DrawerListAdapter(Context mContext, List<DrawerListItem> drawerListItemList) {
        this.mContext = mContext;
        this.drawerListItemList = drawerListItemList;
    }

    @Override
    public int getCount() {
        return drawerListItemList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View rowView = LayoutInflater.from(mContext).inflate(R.layout.drawer_list_item, parent, false);

        customTextView title = (customTextView) rowView.findViewById(R.id.title);
        ImageView icon = (ImageView) rowView.findViewById(R.id.icon);

        title.setText(drawerListItemList.get(position).getTitle());
        icon.setImageResource(drawerListItemList.get(position).getIcon());

        return rowView;
    }
}
