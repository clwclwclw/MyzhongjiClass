package cn.edu.sdwu.android02.classroom.sn170507180230;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class CH10Activity1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(CH10Activity1.class.toString(),"onCreate");
    }


    @Override
    protected void onStart() {
        super.onStart();
        Log.i(CH10Activity1.class.toString(),"onStart");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(CH10Activity1.class.toString(),"onStop");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(CH10Activity1.class.toString(),"onPause");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(CH10Activity1.class.toString(),"onRestart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(CH10Activity1.class.toString(),"onDestroy");
    }
}
