package com.example.dxf.calculator;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

/**
 * Created by DXF on 2017/11/24.
 */

public class ProgrammerActivity extends Activity implements View.OnClickListener{

    Button main,programmer,temperature,chinese_number;
    Button pro_button;
    ImageView pro_imageView;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_programmer);
        pro_button = (Button)findViewById(R.id.pro_button);
        pro_button.setOnClickListener(this);
        pro_imageView = (ImageView)findViewById(R.id.pro_imageView);
        pro_imageView.setImageResource(R.drawable.me);

    }


    public void onClick(View v){
        switch (v.getId()) {
            case R.id.pro_button:
                joinQQGroup("__TqDlL7bynjTKqI1BqbbLHqDWIEH_cs");
                break;
        }
    }

    /****************
     *
     * 发起添加群流程。群号：Hello🍁World(232112118) 的 key 为： __TqDlL7bynjTKqI1BqbbLHqDWIEH_cs
     * 调用 joinQQGroup(__TqDlL7bynjTKqI1BqbbLHqDWIEH_cs) 即可发起手Q客户端申请加群 Hello🍁World(232112118)
     *
     * @param key 由官网生成的key
     * @return 返回true表示呼起手Q成功，返回fals表示呼起失败
     ******************/
    public boolean joinQQGroup(String key) {
        Intent intent = new Intent();
        intent.setData(Uri.parse("mqqopensdkapi://bizAgent/qm/qr?url=http%3A%2F%2Fqm.qq.com%2Fcgi-bin%2Fqm%2Fqr%3Ffrom%3Dapp%26p%3Dandroid%26k%3D" + key));
        // 此Flag可根据具体产品需要自定义，如设置，则在加群界面按返回，返回手Q主界面，不设置，按返回会返回到呼起产品界面    //intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        try {
            startActivity(intent);
            return true;
        } catch (Exception e) {
            // 未安装手Q或安装的版本不支持
            return false;
        }
    }


}
