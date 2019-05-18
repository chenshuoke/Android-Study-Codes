package com.example.lab_2_2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    private String[] data = {"移动应用开发技术","计算机组成原理","数据结构","操作系统","面向对象技术","逻辑设计"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //在MianActivity类的onCreate函数内部构造适配器
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                MainActivity.this,                  //context上下文
                android.R.layout.simple_list_item_1,        //子项布局id
                data);                                      //数据
        ListView listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(adapter);

        final TextView textView = (TextView) findViewById(R.id.textView);
        listView.setOnItemClickListener(new OnItemClickListener(){
            //list点击事件
            @Override
            public void onItemClick(AdapterView<?> p1, View p2, int p3, long p4)
            {
                // TODO: Implement this method
                textView.setText(data[p3]);
            }

        });

    }

}