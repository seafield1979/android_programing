package com.example.b02681.unactivitytransition;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.content.Intent;
import android.util.Log;
import android.app.Activity;

public class Activity2 extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity2);

        // 起動元のActivityからの引数を取得する
        Intent intent = this.getIntent();
        String name = intent.getStringExtra("name");
        Log.d("MyApp", "name:" + name);
    }

    // 戻るボタンを押した
    public void clickGoBackButton(View v){
        // intentの作成
        Intent intent = new Intent();

        // intentへ添え字付で値を保持させる
        intent.putExtra( "key2", "result_val" );

        // 返却したい結果ステータスをセットする
        setResult( Activity.RESULT_OK, intent );

        // アクティビティを終了させる
        finish();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_activity2, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
