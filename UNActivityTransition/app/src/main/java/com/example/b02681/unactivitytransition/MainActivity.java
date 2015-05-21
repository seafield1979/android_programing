/*
アクティビティ間のパラメータの受け渡しを行うサンプル

・アクティビティを起動する
    Intent intent = new Intent(this, Activity1.class);
    // intentに値を設定して遷移先のアクティビティにパラメータを渡す
    intent.putExtra( "name", "hamada" );

    // アクティビティを起動する, 第２匹数は起動元を識別するための値
    startActivityForResult(intent, RequestActivity1);

・アクティビティの戻り値を取得する
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        // requestCode 遷移先のアクティビティを起動するときに渡した値
        // resultCode 遷移先のアクティビティが閉じるときに設定した戻り値
        // data 遷移先のアクティビティで setResultの第２引数で設定したパラメータ
    }
 */

package com.example.b02681.unactivitytransition;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.app.Activity;


public class MainActivity extends ActionBarActivity {

    public static final int RequestActivity1 = 10;
    public static final int RequestActivity2 = 20;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    // Activity1 を起動
    public void clickButton1(View v){
        Intent intent = new Intent(this, Activity1.class);

        // intentへ添え字付で値を保持させる
        intent.putExtra( "name", "hamada" );

        startActivityForResult(intent, RequestActivity1);
    }

    // Activity2 を起動
    public void clickButton2(View v){
        Intent intent = new Intent(this, Activity2.class);

        // intentへ添え字付で値を保持させる
        intent.putExtra( "name", "matsumoto" );

        startActivityForResult(intent, RequestActivity2);
    }

    // 遷移先から戻ってくるとここに入る
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // 遷移先からの戻り値とデータを受け取る
        Log.v("MyApp", "" + requestCode);
        switch (requestCode) {
            case RequestActivity1:
                if (resultCode == Activity.RESULT_OK) {
                    Log.d("MyApp","requestCode:" + requestCode
                            + "\nresultCode:" + resultCode
                            + "\ndata:" + data.getStringExtra("key1"));
                }
                break;
            case RequestActivity2:
                if (resultCode == Activity.RESULT_OK) {
                    Log.d("MyApp","requestCode:" + requestCode
                            + "\nresultCode:" + resultCode
                            + "\ndata:" + data.getStringExtra("key2"));
                }
                break;
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            AlertDialog.Builder alertDialog=new AlertDialog.Builder(this);

            // ダイアログの設定
            alertDialog.setTitle("title");          //タイトル
            alertDialog.setMessage("massage");      //内容

            // OK
            alertDialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {

                public void onClick(DialogInterface dialog, int which) {
                    // TODO 自動生成されたメソッド・スタブ
                    Log.d("AlertDialog", "Positive which :" + which);
                }
            });
            // Cancel
            alertDialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {

                public void onClick(DialogInterface dialog, int which) {
                    // TODO 自動生成されたメソッド・スタブ
                    Log.d("AlertDialog", "Positive which :" + which);
                }
            });

            // ダイアログの作成と表示
            alertDialog.create();
            alertDialog.show();

            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
