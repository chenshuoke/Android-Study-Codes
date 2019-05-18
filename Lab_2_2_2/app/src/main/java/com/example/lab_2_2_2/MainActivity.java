package com.example.lab_2_2_2;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {

    private View oldView;
    private int oldPosition;
    private LinkedList<Item> mList=null;
    private  ListView listView;
    private Context mContext;
    private ItemAdapter adapter=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mContext=MainActivity.this;
        listView = findViewById(R.id.lv);
        mList = new LinkedList<>();//实例化LinkedList

        //R.mipmap.img即为图中所示图片（滑稽）

        mList.add(new Item(R.mipmap.img,"姓名","张三"));//增加数据到链表
        mList.add(new Item(R.mipmap.img,"性别","男"));
        mList.add(new Item(R.mipmap.img,"年龄","25"));
        mList.add(new Item(R.mipmap.img,"居住地","开封"));
        mList.add(new Item(R.mipmap.img,"邮箱","zhangsan@henu.edu.cn"));
        adapter = new ItemAdapter(mList,mContext);//设置适配器
        listView.setAdapter(adapter);//ListView设置适配器

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                try{
                    //第一行的颜色还原
                    if(oldPosition % 2 == 0) {
                        oldView.setBackgroundDrawable(view.getResources().getDrawable(
                                R.drawable.item_default_1));
                    }
                    else {
                        //第二行的颜色还原
                        oldView.setBackgroundDrawable(view.getResources().getDrawable(
                                R.drawable.item_default_2));
                    }
                }catch (Exception e){
                    //这里因为第一此点击之前不用还原
                    //Toast.makeText(MainActivity.this,"之前未选中元素",Toast.LENGTH_SHORT ).show();
                }
                view.setBackgroundResource(R.drawable.item_select);
                oldView = view;

                oldPosition = position;

            }
        });

    }

}