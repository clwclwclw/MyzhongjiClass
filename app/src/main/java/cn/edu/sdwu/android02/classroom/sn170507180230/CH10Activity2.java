package cn.edu.sdwu.android02.classroom.sn170507180230;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;
import android.content.Intent;

public class CH10Activity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_ch10_2);
    }
    public  void send_broadcast(View view){
        //发送广播
        Intent intent=new Intent("com.inspur.broadcast");//制定频道
        intent.putExtra("key1","message");

        sendBroadcast(intent);//发送
    }
}
