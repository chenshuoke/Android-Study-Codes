package com.example.lab_2_2_2;

/**
 * Demo class
 *
 * @author chenshuoke
 * @date 2019/4
 */
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.LinkedList;

public class ItemAdapter extends BaseAdapter {

    //声明一个链表和Context对象
    private LinkedList<Item> mList;
    private Context mContext;
    public ItemAdapter(LinkedList<Item> mList,Context mContext){
        this.mList=mList;
        this.mContext=mContext;
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        //加载一个适配器界面
        convertView=LayoutInflater.from(mContext).inflate(R.layout.list_item,null);

        //实例化元件
        ImageView image = (ImageView) convertView.findViewById(R.id.image_1);
        TextView text1 = (TextView) convertView.findViewById(R.id.tv_1);
        TextView text2 = (TextView) convertView.findViewById(R.id.tv_2);

        //元件获取数据
        image.setImageResource(mList.get(position).getImage());
        text1.setText(mList.get(position).getFirst());
        text2.setText(mList.get(position).getSecond());

        // 为ListView设置隔行不同的背景颜色
        if (position % 2 == 0) {
            convertView.setBackgroundDrawable(convertView.getResources().getDrawable(
                    R.drawable.item_default_1));
        } else {
            convertView.setBackgroundDrawable(convertView.getResources().getDrawable(
                    R.drawable.item_default_2));
        }

        return convertView;
    }
}