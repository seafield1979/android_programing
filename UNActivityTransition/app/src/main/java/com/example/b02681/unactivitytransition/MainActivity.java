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


public class MainActivity extends ActionBarActivity {

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

    public void clickButton1(View v){
        startActivityForResult(
                new Intent(this,Activity1.class),
                1);
        // アニメーションの設定
        overridePendingTransition(R.anim.in_right, R.anim.out_left);
    }
    public void clickButton2(View v){
        startActivityForResult(
                new Intent(this,Activity2.class),
                2);
    }

    // 遷移先から戻ってくるとここに入る
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == RESULTCODE) {
            if (resultCode == RESULT_OK) {
            }
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
