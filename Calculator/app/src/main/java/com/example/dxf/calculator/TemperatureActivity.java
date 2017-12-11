package com.example.dxf.calculator;

import android.app.Activity;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by DXF on 2017/11/24.
 */

public class TemperatureActivity extends Activity implements View.OnClickListener{

    private ImageButton btn0,btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btnAC,btnBack,btnVolume,btnAdd,btnSub,btnMul,btnDiv,btnEqual,btnPercent,btnDot,btnMore;
    private TextView tem_tv1,tem_tv2;
    SoundPool sp;
    float volume = 1f;
    int soundID_btnMore,soundID_btn0,soundID_btn1,soundID_btn2,soundID_btn3,soundID_btn4,soundID_btn5,soundID_btn6,soundID_btn7,soundID_btn8,soundID_btn9,
            soundID_btnAC,soundID_btnBack,soundID_btnVolume,soundID_btnEqual,soundID_btnDot,soundID_btnAdd;
    int stat =1;//判断正负
    String buf;
    int temperatureStat;
    double buffer;
    double tem0,tem1,tem2,tem3,tem4;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acitivty_temperature);
        Spinner spinner  = (Spinner) findViewById(R.id.spinner);

        sp = new SoundPool(25, AudioManager.STREAM_MUSIC,0);

        soundID_btnMore = sp.load(getApplicationContext(),R.raw.btn_bt_mouse_click,1);
        soundID_btn0 = sp.load(getApplicationContext(),R.raw.btn_0,1);
        soundID_btn1 = sp.load(getApplicationContext(),R.raw.btn_1,1);
        soundID_btn2 = sp.load(getApplicationContext(),R.raw.btn_2,1);
        soundID_btn3 = sp.load(getApplicationContext(),R.raw.btn_3,1);
        soundID_btn4 = sp.load(getApplicationContext(),R.raw.btn_4,1);
        soundID_btn5 = sp.load(getApplicationContext(),R.raw.btn_5,1);
        soundID_btn6 = sp.load(getApplicationContext(),R.raw.btn_6,1);
        soundID_btn7 = sp.load(getApplicationContext(),R.raw.btn_7,1);
        soundID_btn8 = sp.load(getApplicationContext(),R.raw.btn_8,1);
        soundID_btn9 = sp.load(getApplicationContext(),R.raw.btn_9,1);
        soundID_btnAC = sp.load(getApplicationContext(),R.raw.btn_invite,1);
        soundID_btnBack = sp.load(getApplicationContext(),R.raw.btn_dlg_notice,1);
        soundID_btnVolume = sp.load(getApplicationContext(),R.raw.btn_quest_alert,1);
        soundID_btnEqual = sp.load(getApplicationContext(),R.raw.btn_pvp_level_up,1);
        soundID_btnDot = sp.load(getApplicationContext(),R.raw.btn_rps_game,1);
        soundID_btnAdd = sp.load(getApplicationContext(),R.raw.btn_pick_up_item,1);

        tem_tv1 = (TextView)findViewById(R.id.tem_tv1);
        tem_tv2 = (TextView)findViewById(R.id.tem_tv2);

        ViewTreeObserver vto = tem_tv1.getViewTreeObserver();
        vto.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                tem_tv1.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                tem_tv1.setTextSize(TypedValue.COMPLEX_UNIT_PX,tem_tv1.getWidth()/720f*60);
                tem_tv2.setTextSize(TypedValue.COMPLEX_UNIT_PX,tem_tv1.getWidth()/720f*75);
            }
        });

        btn0 = (ImageButton)findViewById(R.id.tem_iBtn14);
        btn1 = (ImageButton)findViewById(R.id.tem_iBtn9);
        btn2 = (ImageButton)findViewById(R.id.tem_iBtn10);
        btn3 = (ImageButton)findViewById(R.id.tem_iBtn11);
        btn4 = (ImageButton)findViewById(R.id.tem_iBtn5);
        btn5 = (ImageButton)findViewById(R.id.tem_iBtn6);
        btn6 = (ImageButton)findViewById(R.id.tem_iBtn7);
        btn7 = (ImageButton)findViewById(R.id.tem_iBtn1);
        btn8 = (ImageButton)findViewById(R.id.tem_iBtn2);
        btn9 = (ImageButton)findViewById(R.id.tem_iBtn3);
        btnAC = (ImageButton)findViewById(R.id.tem_iBtn8);
        btnBack = (ImageButton)findViewById(R.id.tem_iBtn12);
        btnVolume = (ImageButton)findViewById(R.id.tem_iBtn4);
        btnEqual = (ImageButton)findViewById(R.id.tem_iBtn16);
        btnDot = (ImageButton)findViewById(R.id.tem_iBtn15);
        btnAdd = (ImageButton)findViewById(R.id.tem_iBtn13);
        btnMore = (ImageButton)findViewById(R.id.tem_btnMore);

        btn0.setImageResource(R.mipmap.i0);
        btn1.setImageResource(R.mipmap.i1);
        btn2.setImageResource(R.mipmap.i2);
        btn3.setImageResource(R.mipmap.i3);
        btn4.setImageResource(R.mipmap.i4);
        btn5.setImageResource(R.mipmap.i5);
        btn6.setImageResource(R.mipmap.i6);
        btn7.setImageResource(R.mipmap.i7);
        btn8.setImageResource(R.mipmap.i8);
        btn9.setImageResource(R.mipmap.i9);
        btnAC.setImageResource(R.mipmap.q3);
        btnBack.setImageResource(R.mipmap.q4);
        btnVolume.setImageResource(R.mipmap.q50);
        btnEqual.setImageResource(R.mipmap.q6);
        btnDot.setImageResource(R.mipmap.q7);
        btnAdd.setImageResource(R.mipmap.q17);
        btnMore.setImageResource(R.mipmap.menu);

        btn0.setOnClickListener(this);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
        btn7.setOnClickListener(this);
        btn8.setOnClickListener(this);
        btn9.setOnClickListener(this);
        btnAC.setOnClickListener(this);
        btnBack.setOnClickListener(this);
        btnVolume.setOnClickListener(this);
        btnEqual.setOnClickListener(this);
        btnDot.setOnClickListener(this);
        btnMore.setOnClickListener(this);
        btnAdd.setOnClickListener(this);

        buf = "";

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int pos, long id) {
                temperatureStat = pos ;
                think();
                refresh();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Another interface callback
            }
        });
    }


    public void onClick(View v){
        switch (v.getId()) {
            case R.id.tem_iBtn14://btn0
                sp.play(soundID_btn0,volume,volume,1,0,1);
                if(buf.length()>8){
                    //什么都不做
                }
                else if(buf=="")
                {
                    buf = buf + 0;
                }
                else if(buf=="0"){
                    buf = "0";
                }
                else {
                    buf =buf +0;
                }
                refresh();
                break;

            case R.id.tem_iBtn9://btn1
                sp.play(soundID_btn1,volume,volume,1,0,1);
                if(buf.length()>8){
                    //什么都不做
                }
                else if(buf=="")
                {
                    buf = buf + 1;
                }
                else if(buf=="0"){
                    buf = "1";
                }
                else {
                    buf =buf +1;
                }
                refresh();
                break;

            case R.id.tem_iBtn10://btn2
                sp.play(soundID_btn2,volume,volume,1,0,1);
                if(buf.length()>8){
                    //什么都不做
                }
                else if(buf=="")
                {
                    buf = buf + 2;
                }
                else if(buf=="0"){
                    buf = "2";
                }
                else {
                    buf =buf +2;
                }
                refresh();
                break;

            case R.id.tem_iBtn11://btn3
                sp.play(soundID_btn3,volume,volume,1,0,1);
                if(buf.length()>8){
                    //什么都不做
                }
                else if(buf=="")
                {
                    buf = buf + 3;
                }
                else if(buf=="0"){
                    buf = "3";
                }
                else {
                    buf =buf +3;
                }
                refresh();
                break;

            case R.id.tem_iBtn5://btn4
                sp.play(soundID_btn4,volume,volume,1,0,1);
                if(buf.length()>8){
                    //什么都不做
                }
                else if(buf=="")
                {
                    buf = buf + 4;
                }
                else if(buf=="0"){
                    buf = "4";
                }
                else {
                    buf =buf +4;
                }
                refresh();
                break;

            case R.id.tem_iBtn6://btn5
                sp.play(soundID_btn5,volume,volume,1,0,1);
                if(buf.length()>8){
                    //什么都不做
                }
                else if(buf=="")
                {
                    buf = buf + 5;
                }
                else if(buf=="0"){
                    buf = "5";
                }
                else {
                    buf =buf +5;
                }
                refresh();
                break;

            case R.id.tem_iBtn7://btn6
                sp.play(soundID_btn6,volume,volume,1,0,1);
                if(buf.length()>8){
                    //什么都不做
                }
                else if(buf=="")
                {
                    buf = buf + 6;
                }
                else if(buf=="0"){
                    buf = "6";
                }
                else {
                    buf =buf +6;
                }
                refresh();
                break;

            case R.id.tem_iBtn1://btn7
                sp.play(soundID_btn7,volume,volume,1,0,1);
                if(buf.length()>8){
                    //什么都不做
                }
                else if(buf=="")
                {
                    buf = buf + 7;
                }
                else if(buf=="0"){
                    buf = "7";
                }
                else {
                    buf =buf +7;
                }
                refresh();
                break;

            case R.id.tem_iBtn2://btn8
                sp.play(soundID_btn8,volume,volume,1,0,1);
                if(buf.length()>8){
                    //什么都不做
                }
                else if(buf=="")
                {
                    buf = buf + 8;
                }
                else if(buf=="0"){
                    buf = "8";
                }
                else {
                    buf =buf +8;
                }
                refresh();
                break;

            case R.id.tem_iBtn3://btn9
                sp.play(soundID_btn9,volume,volume,1,0,1);
                if(buf.length()>8){
                    //什么都不做
                }
                else if(buf=="")
                {
                    buf = buf + 9;
                }
                else if(buf=="0"){
                    buf = "9";
                }
                else {
                    buf =buf +9;
                }
                refresh();
                break;

            case R.id.tem_iBtn8://btnAC
                sp.play(soundID_btnAC,volume,volume,1,0,1);
                buf = "";
                refresh();
                break;

            case R.id.tem_iBtn12://btnBack
                sp.play(soundID_btnBack,volume,volume,1,0,1);
                if(buf.length()!=0)
                {
                    buf = buf.substring(0,buf.length()-1);
                }
                refresh();
                break;

            case R.id.tem_iBtn4://btnVolume
                if(volume==1f)
                {
                    volume = 0f;
                    btnVolume.setImageResource(R.mipmap.q5);
                }
                else {
                    sp.play(soundID_btnVolume,1f,1f,1,0,1);
                    btnVolume.setImageResource(R.mipmap.q50);
                    volume = 1f;
                }
                break;

            case R.id.tem_iBtn16://btnEqual
                sp.play(soundID_btnEqual,volume,volume,1,0,1);
                try{
                    think();
                }catch(Exception e){
                }
                break;

            case R.id.tem_iBtn15://btnDot
                sp.play(soundID_btnDot,volume,volume,1,0,1);
                if(buf.length()==0)
                {
                    buf = "0.";
                }
                else if(buf.indexOf(".")==-1)
                {buf = buf + ".";
                }
                refresh();
                break;

            case R.id.tem_btnMore://btnMore
                sp.play(soundID_btnMore,volume,volume,1,0,1);
                finish();
                break;

            case R.id.tem_iBtn13://btnAdd
                sp.play(soundID_btnAdd,volume,volume,1,0,1);
                if(buf.length()==0)
                {
                    buf="-";
                }
                else if(buf.indexOf("-")==-1)
                {
                    stat = -1;
                    buf = "-" + buf;
                }
                else {
                    stat = 1;
                    if(buf.length()!=0)
                    {
                        buf = buf.substring(1,buf.length());
                    }
                    else{
                        buf = "-";
                    }
                }
                refresh();
                break;
        }
    }

     public void refresh()
     {
         if(temperatureStat == 0){
             tem_tv2.setText(buf+" ℃");
         }
         else if(temperatureStat == 1){
             tem_tv2.setText(buf+" F");
         }
         else if(temperatureStat == 2){
             tem_tv2.setText(buf+" K");
         }
         else if(temperatureStat == 3){
             tem_tv2.setText(buf+" Ra");
         }
         else if(temperatureStat == 4){
             tem_tv2.setText(buf+" Re");
         }
         tem_tv1.setText("");
     }

    public void think()
    {
         if(buf!=""&&buf!="-"){
        buffer = Double.parseDouble(buf);
        if(temperatureStat == 0){
            tem0 = buffer;
            tem1 = tem0*1.8+32;
            tem2 = tem0+273.16;
            tem3 = tem0*1.8+32+459.67;
            tem4 = tem0*0.8;

            tem_tv1.setText(
                            "摄氏度："+String.format("%.2f", tem0)+" ℃"+"\n"+
                            "华氏度："+String.format("%.2f", tem1)+" F"+"\n"+
                            "开氏度："+String.format("%.2f", tem2)+" K"+"\n"+
                            "兰氏度："+String.format("%.2f", tem3)+" Ra"+"\n"+
                            "列氏度："+String.format("%.2f", tem4)+" Re"+"\n"

            );
        }
        else if(temperatureStat == 1){
            tem1 = buffer;
            tem0 = (tem1-32)/1.8;
            tem2 = tem0+273.16;
            tem3 = tem0*1.8+32+459.67;
            tem4 = tem0*0.8;

            tem_tv1.setText(
                            "摄氏度："+String.format("%.2f", tem0)+" ℃"+"\n"+
                            "华氏度："+String.format("%.2f", tem1)+" F"+"\n"+
                            "开氏度："+String.format("%.2f", tem2)+" K"+"\n"+
                            "兰氏度："+String.format("%.2f", tem3)+" Ra"+"\n"+
                            "列氏度："+String.format("%.2f", tem4)+" Re"+"\n"

            );
        }
        else if(temperatureStat == 2){
            tem2 = buffer;
            tem0 = tem2 - 273.16;
            tem1 = tem0*1.8+32;
            tem3 = tem0*1.8+32+459.67;
            tem4 = tem0*0.8;

            tem_tv1.setText(
                            "摄氏度："+String.format("%.2f", tem0)+" ℃"+"\n"+
                            "华氏度："+String.format("%.2f", tem1)+" F"+"\n"+
                            "开氏度："+String.format("%.2f", tem2)+" K"+"\n"+
                            "兰氏度："+String.format("%.2f", tem3)+" Ra"+"\n"+
                            "列氏度："+String.format("%.2f", tem4)+" Re"+"\n"

            );
        }
        else if(temperatureStat == 3){
            tem3 = buffer;
            tem0 = (tem3 - 32 - 459.67)/1.8;
            tem1 = tem0*1.8+32;
            tem2 = tem0+273.16;
            tem4 = tem0*0.8;

            tem_tv1.setText(
                            "摄氏度："+String.format("%.2f", tem0)+" ℃"+"\n"+
                            "华氏度："+String.format("%.2f", tem1)+" F"+"\n"+
                            "开氏度："+String.format("%.2f", tem2)+" K"+"\n"+
                            "兰氏度："+String.format("%.2f", tem3)+" Ra"+"\n"+
                            "列氏度："+String.format("%.2f", tem4)+" Re"+"\n"

            );
        }
        else if(temperatureStat == 4){
            tem4 = buffer;
            tem0 = tem4/0.8;
            tem1 = tem0*1.8+32;
            tem2 = tem0+273.16;
            tem3 = tem0*1.8+32+459.67;

            tem_tv1.setText(
                            "摄氏度："+String.format("%.2f", tem0)+" ℃"+"\n"+
                            "华氏度："+String.format("%.2f", tem1)+" F"+"\n"+
                            "开氏度："+String.format("%.2f", tem2)+" K"+"\n"+
                            "兰氏度："+String.format("%.2f", tem3)+" Ra"+"\n"+
                            "列氏度："+String.format("%.2f", tem4)+" Re"+"\n"

            );
        }
    }
    }
}
