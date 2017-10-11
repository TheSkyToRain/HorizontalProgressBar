package com.example.administrator.myapplication;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.administrator.myapplication.Views.HorizontalProgressBar;

public class MainActivity extends AppCompatActivity {
    private HorizontalProgressBar progressBar;
    private static final int MSG_UPDATE = 0X110;
    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            int progress = progressBar.getProgress();
            progressBar.setProgress(++progress);
            if (progress>=100){
                handler.removeMessages(MSG_UPDATE);
            }
            handler.sendEmptyMessageDelayed(MSG_UPDATE,100);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        progressBar = (HorizontalProgressBar) findViewById(R.id.progressbar);
        handler.sendEmptyMessage(MSG_UPDATE);
    }
}
