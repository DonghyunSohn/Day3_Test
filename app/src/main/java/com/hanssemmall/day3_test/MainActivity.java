package com.hanssemmall.day3_test;

import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.media.Image;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ScrollView;

public class MainActivity extends AppCompatActivity {

    Button btn01;
    Button btn02;
    ImageView imv01;
    ImageView imv02;
    ScrollView scv01;
    ScrollView scv02;
    BitmapDrawable bitmap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn01=(Button) findViewById(R.id.btn_up);
        btn02=(Button) findViewById(R.id.btn_down);
        imv01=(ImageView) findViewById(R.id.imageView01);
        imv02=(ImageView) findViewById(R.id.imageView02);
        scv01=(ScrollView)findViewById(R.id.scrollView01);
        scv02=(ScrollView)findViewById(R.id.scrollView02);
        scv01.setHorizontalFadingEdgeEnabled(true);
        scv02.setHorizontalFadingEdgeEnabled(true);

        Resources res=getResources();
        bitmap=(BitmapDrawable)res.getDrawable(R.drawable.djbridge);
        int bitmapWidth = bitmap.getIntrinsicWidth();
        int bitmapHeight = bitmap.getIntrinsicHeight();

        imv01.setImageDrawable(bitmap);
        imv01.getLayoutParams().width=bitmapWidth;
        imv01.getLayoutParams().height=bitmapHeight;

        imv02.setImageDrawable(bitmap);
        imv02.getLayoutParams().width=bitmapWidth;
        imv02.getLayoutParams().height=bitmapHeight;

        scv02.setVisibility(View.INVISIBLE);

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (v.getId() == R.id.btn_up) {
                    scv01.setVisibility(View.VISIBLE);
                    scv02.setVisibility(View.INVISIBLE);
                } else if (v.getId() == R.id.btn_down) {
                    scv01.setVisibility(View.INVISIBLE);
                    scv02.setVisibility(View.VISIBLE);
                }

            }
        };

        btn01.setOnClickListener(listener);
        btn02.setOnClickListener(listener);

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