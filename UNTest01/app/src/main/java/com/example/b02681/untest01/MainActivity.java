package com.example.b02681.untest01;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity {

    private final int WC = ViewGroup.LayoutParams.MATCH_PARENT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }


    // 画像を変更する
    public void clickImageButton(View view){
        // 画像を設定する
        ImageView image = new ImageView(this);
        image.setImageResource(R.drawable.image2);
        setContentView(image, new ViewGroup.LayoutParams(WC, WC));
    }

    // テキストを変更する
    public void clickButton1(View view) {
        TextView tv = (TextView) findViewById(R.id.textView1);
        tv.setText("hellooooo");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        switch (id) {
            case R.id.action_settings:
                return true;
            case R.id.action_menu1:
                Toast ts = Toast.makeText(this, "マイメニューが選択されました", Toast.LENGTH_LONG);
                ts.show();
                return true;
            case R.id.action_menu2:

                return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
