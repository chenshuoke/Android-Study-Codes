package com.example.lab_2_3;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public Button btn_1;
    public Button btn_2;
    public Button btn_3;
    public Button btn_4;
    public Button btn_5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
    }

    private void initViews() {
        btn_1 = findViewById(R.id.btn_1);
        btn_2 = findViewById(R.id.btn_2);
        btn_3 = findViewById(R.id.btn_3);
        btn_4 = findViewById(R.id.btn_4);
        btn_5 = findViewById(R.id.btn_5);

        //确认对话框
        btn_1.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog dialog = new AlertDialog.Builder(MainActivity.this).create();//创建对话框
                dialog.setIcon(R.mipmap.ic_launcher);//设置对话框icon
                dialog.setTitle("删除对话框");//设置对话框标题
                dialog.setMessage("真的要删除该联系人吗？");//设置文字显示内容
                //分别设置三个button
                dialog.setButton(DialogInterface.BUTTON_POSITIVE,"是", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();//关闭对话框
                        Toast.makeText(MainActivity.this,"删除成功",Toast.LENGTH_SHORT).show();
                    }
                });
                dialog.setButton(DialogInterface.BUTTON_NEUTRAL,"查看详情", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) { }
                });
                dialog.setButton(DialogInterface.BUTTON_NEGATIVE, "否", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();//关闭对话框
                        Toast.makeText(MainActivity.this,"删除失败",Toast.LENGTH_SHORT).show();
                    }
                });
                dialog.show();//显示对话框
            }
        });

        //列表对话框
        btn_2.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v){
                //初始化字符串数组
                final String[] strArray = new String[]{"苹果","芒果","草莓","香蕉"};
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);//实例化builder
                builder.setIcon(R.mipmap.ic_launcher);//设置图标
                builder.setTitle("你喜欢哪种水果？");//设置标题
                //设置列表
                builder.setItems(strArray, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this,strArray[which],Toast.LENGTH_SHORT).show();
                    }
                });
                builder.create().show();//创建并显示对话框
            }
        });

        //单选对话框
        btn_3.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                //初始化字符串数组
                final String[] strArray = new String[]{"苹果","芒果","草莓","香蕉"};
                final AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);//实例化builder
                builder.setIcon(R.mipmap.ic_launcher);//设置图标
                builder.setTitle("你喜欢吃哪种水果？");//设置标题
                //设置单选列表
                builder.setSingleChoiceItems(strArray, 0, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                //创建对话框
                AlertDialog dialog = builder.create();

                //设置确定按钮
                dialog.setButton(DialogInterface.BUTTON_POSITIVE,"确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                //设置取消按钮
                dialog.setButton(DialogInterface.BUTTON_NEGATIVE,"取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                dialog.show();//显示对话框
            }
        });

        //多选对话框
        btn_4.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                //初始化字符串数组
                final String[] strArray = new String[]{"苹果","芒果","草莓","香蕉"};
                final AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);//实例化builder
                builder.setIcon(R.mipmap.ic_launcher);//设置图标
                builder.setTitle("你喜欢吃哪种水果？");//设置标题
                //设置多选列表
                builder.setMultiChoiceItems(strArray, new boolean[]{false, false, false, false}, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which, boolean isChecked) {

                    }
                });
                //创建对话框
                AlertDialog dialog = builder.create();
                //设置确定按钮
                dialog.setButton(DialogInterface.BUTTON_POSITIVE,"确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                //设置取消按钮
                dialog.setButton(DialogInterface.BUTTON_NEGATIVE, "取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                dialog.show();//显示对话框
            }
        });

        //自定义对话框
        btn_5.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

                //实例化布局
                View view = LayoutInflater.from(MainActivity.this).inflate(R.layout.login_dialog,null);
                //找到并对自定义布局中的控件进行操作的示例
                /*
                EditText et_1 = view.findViewById(R.id.et_1);
                EditText et_2 = view.findViewById(R.id.et_2);
                et_1.addTextChangedListener(new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                    }

                    @Override
                    public void onTextChanged(CharSequence s, int start, int before, int count) {
                    }

                    @Override
                    public void afterTextChanged(Editable s) {
                    }
                });
                */
                //创建对话框
                AlertDialog dialog = new AlertDialog.Builder(MainActivity.this).create();
                dialog.setIcon(R.mipmap.ic_launcher);//设置图标
                dialog.setTitle("用户登录");//设置标题
                dialog.setView(view);//添加布局
                //设置按键
                dialog.setButton(AlertDialog.BUTTON_POSITIVE, "登录", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                dialog.setButton(AlertDialog.BUTTON_NEGATIVE, "取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                dialog.show();

            }
        });

    }
}