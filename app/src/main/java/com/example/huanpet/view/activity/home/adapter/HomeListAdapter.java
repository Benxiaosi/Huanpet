package com.example.huanpet.view.activity.home.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.huanpet.R;

import java.util.List;

/**
 * Created by leon on 2018/3/29.
 */

public class HomeListAdapter extends BaseAdapter {

    private List<String> nearList;
    private Context con;
    private ViewHolder holder;
    private int defItem;//声明默认选中的项

    public HomeListAdapter(List<String> nearList, Context con) {
        this.nearList = nearList;
        this.con = con;
    }

    @Override
    public int getCount() {
        return nearList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    /**
     * 适配器中添加这个方法
     */
    public void setDefSelect(int position) {
        this.defItem = position;
        notifyDataSetChanged();
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from( con ).inflate( R.layout.homenearby_item, null );
            holder = new ViewHolder();
            holder.title_homepage_nearBy = (TextView) convertView.findViewById( R.id.title_homepage_nearBy );
            convertView.setTag( holder );
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        //绑定数据

        holder.title_homepage_nearBy.setText( nearList.get( position ) );
        return convertView;
    }

//    @SuppressLint("ResourceAsColor")
//    public void setChick(int position) {
//        if (position == 0) {
//            holder.title_homepage_nearBy.setTextColor( R.color.colorAccent );
//
//            notifyDataSetChanged();
//        }
//
//    }

    class ViewHolder {
        TextView title_homepage_nearBy;
    }
}
