package com.example.dxf.calculator;

import android.app.Activity;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;

/**
 * Created by DXF on 2017/11/24.
 */

public class MenuActivity extends Activity implements View.OnClickListener{

    Button main,programmer,temperature,chinese_number;
    SoundPool sp;
    int soundID_btnMore;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        main = (Button)findViewById(R.id.main);
        programmer = (Button)findViewById(R.id.programmer);
        temperature = (Button)findViewById(R.id.temperature);
        chinese_number = (Button)findViewById(R.id.chinese_number);

        sp = new SoundPool(25, AudioManager.STREAM_MUSIC,0);
        soundID_btnMore = sp.load(getApplicationContext(),R.raw.btn_bt_mouse_click,1);
        main.setOnClickListener(this);
        programmer.setOnClickListener(this);
        temperature.setOnClickListener(this);
        chinese_number.setOnClickListener(this);
    }


    public void onClick(View v){
        switch (v.getId()) {
            case R.id.main://btn0
                sp.play(soundID_btnMore,1F,1F,1,0,1);
                finish();
                break;

            case R.id.programmer://btn1
                sp.play(soundID_btnMore,1F,1F,1,0,1);
                Intent programmerIntent = new Intent(MenuActivity.this,ProgrammerActivity.class);
                programmerIntent.putExtra("title","程序员");
                startActivity(programmerIntent);
                break;

            case R.id.temperature://btn2
                sp.play(soundID_btnMore,1F,1F,1,0,1);
                Intent temperatureIntent = new Intent(MenuActivity.this,TemperatureActivity.class);
                temperatureIntent.putExtra("title","温度转换");
                startActivity(temperatureIntent);
                break;

            case R.id.chinese_number://btn3
                sp.play(soundID_btnMore,1F,1F,1,0,1);
                Intent chinese_numberIntent = new Intent(MenuActivity.this,Chinese_numberActivity.class);
                chinese_numberIntent.putExtra("title","大写数字");
                startActivity(chinese_numberIntent);
                break;
        }
    }

}
