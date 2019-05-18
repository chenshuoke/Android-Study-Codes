package com.example.lab_2_4;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTabHost;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TextView;

public class MainActivity extends FragmentActivity {
    private int DEFAULT_BACKGROUND_COLOR = Color.rgb(243, 243, 243);
    //定义FragmentTabHost对象
    private FragmentTabHost fragmentTabHost;
    //定义一个布局填充器成员变量
    private LayoutInflater layoutInflater;
    //Tab选项卡的文字
    private String[] texts = {"主页", "线性布局", "相对布局", "表布局", "网格布局"};
    //定义数组来存放按钮图片
    private int[] imageButton = {R.drawable.tab_home_btn, R.drawable.tab_linear_btn, R.drawable.tab_relative_btn, R.drawable.tab_table_btn, R.drawable.tab_grid_btn};
    //定义数组来存放Fragment界面
    private Class[] fragmentArray = {FragmentHome.class, FragmentLinear.class, FragmentRelative.class, FragmentTable.class, FragmentGrid.class};

    @Override
    protected void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_main);

        layoutInflater = LayoutInflater.from(this);
        initView(); //自定义方法
    }

    private void initView() {
        //实例化tabhost
        fragmentTabHost = findViewById(android.R.id.tabhost);
        fragmentTabHost.setup(this, getSupportFragmentManager(), R.id.contentLayout);
        //去除分割线
        fragmentTabHost.getTabWidget().setDividerDrawable(null);

        int count = texts.length;
        for( int i = 0; i < count; i++) {
            //为每一个Tab按钮设置Tag，图标和文字
            //TabSpec是指每个Tab的标签，Indicator用来加载Tab的view。
            TabHost.TabSpec spec = fragmentTabHost.newTabSpec(texts[i]).setIndicator(getTabItemView(i));
            //将Tab按钮添加进Tab选项卡中
            fragmentTabHost.addTab(spec, fragmentArray[i], null);

            //设置背景(必须在addTab之后，由于需要子节点(底部菜单按钮)否则会出现空指针异常)
            //fragmentTabHost.getTabWidget().getChildAt(i).setBackgroundResource(R.drawable.home_btn_bg);
            fragmentTabHost.getTabWidget().getChildAt(i).setBackgroundColor(DEFAULT_BACKGROUND_COLOR);

            //增加Tabs的高度
            //tabHost.getTabWidget().getChildAt(i).getLayoutParams().height = (int) height;
        }
        //设置默认打开选择的fragment
        fragmentTabHost.setCurrentTabByTag(texts[0]);
    }

    //给每个Tab按钮设置图案和文字
    private View getTabItemView(int i) {
        //取得布局实例
        View view = layoutInflater.inflate(R.layout.tabcontent, null);
        //取得布局对象
        ImageView imageView = view.findViewById(R.id.image);
        TextView textView = view.findViewById(R.id.text);
        //设置图标
        imageView.setImageResource(imageButton[i]);
        //设置标题
        textView.setText(texts[i]);
        return view;
    }
}