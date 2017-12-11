package com.example.dxf.calculator;

import android.app.Activity;
import android.content.Intent;
import android.graphics.PixelFormat;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;

/**
 * Created by DXF on 2017/11/28.
 */

public class LoadingActivity extends Activity {

    private static final int LOAD_DISPLAY_TIME = 2500;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().setFormat(PixelFormat.RGBA_8888);
        //RGBA_8888为android的一种32位颜色格式，R,G,B,A分别用八位表示，Android默认格式是PixelFormat.OPAQUE，
        //其是不带Alpha值的。设置之后可以看到图片的显示效果就和在PC上看到一样，不会出现带状的轮廓线了
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_DITHER);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_loading);

        new Handler().postDelayed(new Runnable() {
            public void run() {
                  /* Create an Intent that will start the Main WordPress Activity. */
                Intent mainIntent = new Intent(LoadingActivity.this, MainActivity.class);
                LoadingActivity.this.startActivity(mainIntent);
                LoadingActivity.this.finish();
            }
        }, LOAD_DISPLAY_TIME); //1500 for release

    }
}