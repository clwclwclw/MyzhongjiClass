package cn.edu.sdwu.android02.classroom.sn170507180230;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class CH14Activity1 extends AppCompatActivity {
    private MyOpenHelper myOpenHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_ch14_1);

        myOpenHelper=new MyOpenHelper(this);
        //以可写方式打开数据库(如果数据库不存在，自动创建数据库)
        SQLiteDatabase sqLiteDatabase=myOpenHelper.getWritableDatabase();

        //使用完毕，将数据库关闭
        sqLiteDatabase.close();
    }

    public  void insert(View view ){
        //以可写方式打开数据库(如果数据库不存在，自动创建数据库)
        SQLiteDatabase sqLiteDatabase=myOpenHelper.getWritableDatabase();
        try{
            //将插入的数据放置在ContentValues中
            //事务的处理
            sqLiteDatabase.beginTransaction();//开启事务
            ContentValues contentValues=new ContentValues();
            contentValues.put("stunema","Tom");
            contentValues.put("stutel","15165082221");
            sqLiteDatabase.insert("student",null,contentValues);
            sqLiteDatabase.setTransactionSuccessful();//当所有操作结束后调用，通过setTransactionSuccessful将数据保存在数据库里

        }catch (Exception e){
            Log.e(CH14Activity1.class.toString(),e.toString());
        }finally {
            sqLiteDatabase.endTransaction();//结束事务
            //使用完毕，将数据库关闭
            sqLiteDatabase.close();
        }
    }
    public void query(View view){
        SQLiteDatabase sqLiteDatabase=myOpenHelper.getWritableDatabase();
        try{
            Cursor cursor=sqLiteDatabase.rawQuery("select * from student where stuname=?",new String[Integer.parseInt("Tom")]);//原生的SQL语句
            while (cursor.moveToNext()){
                int id=cursor.getInt(cursor.getColumnIndex("id"));
                String stuname=cursor.getString(cursor.getColumnIndex("stuname"));
                String stutel=cursor.getString(cursor.getColumnIndex("stutel"));
                Log.i(CH14Activity1.class.toString(),"id:"+id+",stuname:"+stuname+",stutel:"+stutel);
            }
        }catch (Exception e){
            Log.e(CH14Activity1.class.toString(),e.toString());
        }finally {

            //使用完毕，将数据库关闭
            sqLiteDatabase.close();
        }
    }
    public void delete(View view){
        //以可写方式打开数据库(如果数据库不存在，自动创建数据库)
        SQLiteDatabase sqLiteDatabase=myOpenHelper.getWritableDatabase();
        try{
            //将插入的数据放置在ContentValues中
            //事务的处理
            sqLiteDatabase.beginTransaction();//开启事务

            sqLiteDatabase.delete("student","id=?",new String[]{"1"});
            sqLiteDatabase.setTransactionSuccessful();//当所有操作结束后调用，通过setTransactionSuccessful将数据保存在数据库里

        }catch (Exception e){
            Log.e(CH14Activity1.class.toString(),e.toString());
        }finally {
            sqLiteDatabase.endTransaction();//结束事务
            //使用完毕，将数据库关闭
            sqLiteDatabase.close();
        }
    }
    public void edit(View view){
        //以可写方式打开数据库(如果数据库不存在，自动创建数据库)
        SQLiteDatabase sqLiteDatabase=myOpenHelper.getWritableDatabase();
        try{
            //将插入的数据放置在ContentValues中
            //事务的处理
            sqLiteDatabase.beginTransaction();//开启事务

            ContentValues contentValues=new ContentValues();
            contentValues.put("stutel","15999999999");

            sqLiteDatabase.update("student",contentValues,"id=?",new String[]{"2"});
            sqLiteDatabase.setTransactionSuccessful();//当所有操作结束后调用，通过setTransactionSuccessful将数据保存在数据库里

        }catch (Exception e){
            Log.e(CH14Activity1.class.toString(),e.toString());
        }finally {
            sqLiteDatabase.endTransaction();//结束事务
            //使用完毕，将数据库关闭
            sqLiteDatabase.close();
        }
    }
}
