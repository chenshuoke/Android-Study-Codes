package com.example.lab_2_3_2;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btn_1;
    Button btn_2;
    ProgressDialog progressdialog;
    ProgressDialog progressDialog;
    private int currentProgress = 0;
    private int add = 0;
    private final static int MAXVALUE = 100;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_1 = findViewById(R.id.btn_1);
        btn_2 = findViewById(R.id.btn_2);
        btn_1.setOnClickListener(this);
        btn_2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_1:
                progressdialog = new ProgressDialog(MainActivity.this);
                progressdialog.setTitle("提示");
                progressdialog .setMessage("这是一个圆型进度条对话框");
                progressdialog.setCancelable(true);
                progressdialog.setCanceledOnTouchOutside(false);
                progressdialog.show();
                break;
            case R.id.btn_2:

                progressDialog = new ProgressDialog(MainActivity.this);
                progressDialog.setMessage("这是一个长条型进度条对话框");
                //设置弹窗标题
                progressDialog.setTitle("提示");
                // 能够返回
                progressDialog.setCancelable(true);
                // 设置在点击Dialog外能否反回
                progressDialog.setCanceledOnTouchOutside(false);
                //设置进度条
                progressDialog.setMax(MAXVALUE);
                //progressDialog.setProgress(100);
                //设置进度条是否明确
                progressDialog.setIndeterminate(true);
                //设置进度条样式
                //ProgressDialog.STYLE_SPINNER 环形进度条
                //ProgressDialog.STYLE_HORIZONTAL 水平样式的进度条
                progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
                //这里设置的是是否显示进度,设为false才是显示的哦！
                progressDialog.setIndeterminate(false);
                progressDialog.show();
                //进度条的前进
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        // TODO Auto-generated method stub
                        while(currentProgress < MAXVALUE)
                        {
                            //这里的算法是决定进度条变化的,可以按需要写
                            currentProgress = 2 * usetime() ;
                            //把信息码发送给handle让更新界面
                            handler.sendEmptyMessage(123);
                        }
                    }
                }).start();
                break;
            default:
                Toast.makeText(MainActivity.this,"ERROR",Toast.LENGTH_SHORT).show();
                break;

        }
    }
    //这里设置一个耗时的方法:
    private int usetime() {
        add++;
        try{
            Thread.sleep(100);
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
        return add;
    }

    @SuppressLint("HandlerLeak")
    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            if (msg.what == 123) {
                progressDialog.setProgress(currentProgress);
            }
            if (currentProgress >= MAXVALUE) {
                progressDialog.dismiss();

                //currentProgress = 0;
            }
        }
    };
}