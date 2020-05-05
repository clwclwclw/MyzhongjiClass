package cn.edu.sdwu.android02.classroom.sn170507180230;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;
import android.content.Intent;
import android.widget.EditText;
import android.widget.Toast;
import android.util.Log;

public class CH10Activity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_ch10_2);
    }
    public  void send_broadcast(View view){
        //发送广播
        Intent intent=new Intent("com.inspur.broadcast");//指定频道
        intent.putExtra("key1","message");

        sendBroadcast(intent);//发送
    }

    public void CH10Activity1(View view){
        Intent intent=new Intent(this,CH10Activity1.class);
        EditText editText=(EditText)findViewById(R.id.ch10_2_et);
        intent.putExtra("text",editText.getText().toString());//设置传递的数据
        startActivity(intent);
    }
    public void startSubActivity(View view){
        //第一步以Sub-Activity的方式启动子Activity
        Intent intent=new Intent(this,CH10Activity3.class);
        startActivityForResult(intent,100);//发送


    }

    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        //3.在父Activity中获取返回值
        //requestCode用来区分从哪一个子activity返回的结果
        if (requestCode == 101) {
            if (requestCode == RESULT_OK) {
                String name = data.getStringExtra("name");
                Toast.makeText(this, name, Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "cancel", Toast.LENGTH_SHORT).show();
            }
        }else if(requestCode==102){
            if (requestCode == RESULT_OK) {

                String content = data.getStringExtra("name");
                Log.i(CH10Activity2.class.toString(),data.getData().toString());
                ContentResolver contentResolver=this.getContentResolver();
                Cursor cursor=contentResolver.query(data.getData(),null,null,null,null);
                while(cursor.moveToNext()){

                }
                Toast.makeText(this, content, Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "cancel", Toast.LENGTH_SHORT).show();
            }
        }
    }
    public void web(View view){
        Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse("http://baidu.com"));
        startActivity(intent);
    }
    public void contactsList(View view){
        Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse("content://contacts/people/"));
        startActivity(intent);
    }
    public void contactsDetail(View view){
        //查看联系人明细
        Intent intent=new Intent(Intent.ACTION_EDIT);
        intent.setData(Uri.parse("content://contacts/people/1"));
        startActivity(intent);
    }
    public void showMap(View view){
        //打开地图
        Intent intent=new Intent(Intent.ACTION_VIEW,Uri.parse("geo:50.123,7.1434"));
        startActivity(intent);
    }
    public void showPhoto(View view){
        //打开地图
        Intent intent=new Intent(Intent.ACTION_VIEW,Uri.parse("geo:50.123,7.1434"));
        startActivity(intent);
    }
    public void pickContact(View view){
        //
        Intent intent=new Intent(Intent.ACTION_PICK);//隐式启动
        intent.setData(ContactsContract.Contacts.CONTENT_FILTER_URI);
        startActivityForResult(intent,102);
    }


    public  void implictStart(View view){
    Intent intent= new Intent("com.inspur.action2");
        intent.setData(Uri.parse("abc://inspur.com"));
        startActivity(intent);
    }
}
