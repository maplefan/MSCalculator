package com.example.dxf.calculator;

import android.content.Intent;
import android.media.AudioManager;
import android.media.Image;
import android.media.SoundPool;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity  implements View.OnClickListener{

    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("native-lib");
    }

    float volume = 1f;
    SoundPool sp;
    private ImageButton btn0,btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btnAC,btnBack,btnVolume,btnAdd,btnSub,btnMul,btnDiv,btnEqual,btnPercent,btnDot,btnMore;
    int soundID_btn0,soundID_btn1,soundID_btn2,soundID_btn3,soundID_btn4,soundID_btn5,soundID_btn6,soundID_btn7,soundID_btn8,soundID_btn9,soundID_btnAC,soundID_btnBack,soundID_btnVolume,
            soundID_btnAdd,soundID_btnSub,soundID_btnMul,soundID_btnDiv,soundID_btnEqual,soundID_btnPercent,soundID_btnDot,soundID_btnMore;
    String buf,buffer;
    String bufStr1="",bufStr2="";
    TextView main_tv1,main_tv2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn0 = (ImageButton)findViewById(R.id.imageButton18);
        btn1 = (ImageButton)findViewById(R.id.imageButton13);
        btn2 = (ImageButton)findViewById(R.id.imageButton14);
        btn3 = (ImageButton)findViewById(R.id.imageButton15);
        btn4 = (ImageButton)findViewById(R.id.imageButton9);
        btn5 = (ImageButton)findViewById(R.id.imageButton10);
        btn6 = (ImageButton)findViewById(R.id.imageButton11);
        btn7 = (ImageButton)findViewById(R.id.imageButton5);
        btn8 = (ImageButton)findViewById(R.id.imageButton6);
        btn9 = (ImageButton)findViewById(R.id.imageButton7);
        btnAC = (ImageButton)findViewById(R.id.imageButton1);
        btnBack = (ImageButton)findViewById(R.id.imageButton2);
        btnVolume = (ImageButton)findViewById(R.id.imageButton3);
        btnAdd = (ImageButton)findViewById(R.id.imageButton4);
        btnSub = (ImageButton)findViewById(R.id.imageButton8);
        btnMul = (ImageButton)findViewById(R.id.imageButton12);
        btnDiv = (ImageButton)findViewById(R.id.imageButton16);
        btnEqual = (ImageButton)findViewById(R.id.imageButton20);
        btnPercent = (ImageButton)findViewById(R.id.imageButton17);
        btnDot = (ImageButton)findViewById(R.id.imageButton19);
        btnMore = (ImageButton)findViewById(R.id.btnMore);

        main_tv1 = (TextView)findViewById(R.id.main_tv1);
        main_tv2 = (TextView)findViewById(R.id.main_tv2);

        ViewTreeObserver vto = main_tv1.getViewTreeObserver();
        vto.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                main_tv1.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                main_tv1.setTextSize(TypedValue.COMPLEX_UNIT_PX,main_tv1.getWidth()/720f*90);
                main_tv2.setTextSize(TypedValue.COMPLEX_UNIT_PX,main_tv2.getWidth()/720f*75);
            }
        });

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
        btnAdd.setOnClickListener(this);
        btnSub.setOnClickListener(this);
        btnMul.setOnClickListener(this);
        btnDiv.setOnClickListener(this);
        btnEqual.setOnClickListener(this);
        btnPercent.setOnClickListener(this);
        btnDot.setOnClickListener(this);
        btnMore.setOnClickListener(this);

        sp = new SoundPool(25, AudioManager.STREAM_MUSIC,0);
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
        soundID_btnAdd = sp.load(getApplicationContext(),R.raw.btn_pick_up_item,1);
        soundID_btnSub = sp.load(getApplicationContext(),R.raw.btn_random_mission,1);
        soundID_btnMul = sp.load(getApplicationContext(),R.raw.btn_enchant_success,1);
        soundID_btnDiv = sp.load(getApplicationContext(),R.raw.btn_tab,1);
        soundID_btnEqual = sp.load(getApplicationContext(),R.raw.btn_pvp_level_up,1);
        soundID_btnPercent = sp.load(getApplicationContext(),R.raw.btn_scroll_up,1);
        soundID_btnDot = sp.load(getApplicationContext(),R.raw.btn_rps_game,1);
        soundID_btnMore = sp.load(getApplicationContext(),R.raw.btn_bt_mouse_click,1);

      buf = "";

    }

    public void onClick(View v){
        switch (v.getId()) {
            case R.id.imageButton18://btn0
                sp.play(soundID_btn0,volume,volume,1,0,1);
                if(buf=="")
                {
                    buf = "0";
                    refresh();
                }
                else if(buf!="0"){
                    buf = buf + 0;
                    refresh();
                }
                break;

            case R.id.imageButton13://btn1
                sp.play(soundID_btn1,volume,volume,1,0,1);
                if(buf=="")
                {
                    buf = "1";
                }
                else if(buf=="0"){
                    buf = "1";
                }
                else {
                    buf =buf +1;
                }
                refresh();
                break;

            case R.id.imageButton14://btn2
                sp.play(soundID_btn2,volume,volume,1,0,1);
                if(buf=="")
                {
                    buf = "2";
                }
                else if(buf=="0"){
                    buf = "2";
                }
                else {
                    buf =buf +2;
                }
                refresh();
                break;

            case R.id.imageButton15://btn3
                sp.play(soundID_btn3,volume,volume,1,0,1);
                if(buf=="")
                {
                    buf = "3";
                }
                else if(buf=="0"){
                    buf = "3";
                }
                else {
                    buf =buf +3;
                }
                refresh();
                break;

            case R.id.imageButton9://btn4
                sp.play(soundID_btn4,volume,volume,1,0,1);
                if(buf=="")
                {
                    buf = "4";
                }
                else if(buf=="0"){
                    buf = "4";
                }
                else {
                    buf =buf +4;
                }
                refresh();
                break;

            case R.id.imageButton10://btn5
                sp.play(soundID_btn5,volume,volume,1,0,1);
                if(buf=="")
                {
                    buf = "5";
                }
                else if(buf=="0"){
                    buf = "5";
                }
                else {
                    buf =buf +5;
                }
                refresh();
                break;

            case R.id.imageButton11://btn6
                sp.play(soundID_btn6,volume,volume,1,0,1);
                if(buf=="")
                {
                    buf = "6";
                }
                else if(buf=="0"){
                    buf = "6";
                }
                else {
                    buf =buf +6;
                }
                refresh();
                break;

            case R.id.imageButton5://btn7
                sp.play(soundID_btn7,volume,volume,1,0,1);
                if(buf=="")
                {
                    buf = "7";
                }
                else if(buf=="0"){
                    buf = "7";
                }
                else {
                    buf =buf +7;
                }
                refresh();
                break;

            case R.id.imageButton6://btn8
                sp.play(soundID_btn8,volume,volume,1,0,1);
                if(buf=="")
                {
                    buf = "8";
                }
                else if(buf=="0"){
                    buf = "8";
                }
                else {
                    buf =buf +8;
                }
                refresh();
                break;

            case R.id.imageButton7://btn9
                sp.play(soundID_btn9,volume,volume,1,0,1);
                if(buf=="")
                {
                    buf = "9";
                }
                else if(buf=="0"){
                    buf = "9";
                }
                else {
                    buf =buf +9;
                }
                refresh();
                break;

            case R.id.imageButton1://btnAC
                sp.play(soundID_btnAC,volume,volume,1,0,1);
                buf = "";
                refresh();
                main_tv2.setText("");
                break;

            case R.id.imageButton2://btnBack
                sp.play(soundID_btnBack,volume,volume,1,0,1);
                if(buf.length()!=0)
                {
                    buf = buf.substring(0,buf.length()-1);
                }
                refresh();
                break;

            case R.id.imageButton3://btnVolume
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

            case R.id.imageButton4://btnAdd
                sp.play(soundID_btnAdd,volume,volume,1,0,1);
                if((buf!="")&&(buf.charAt(buf.length()-1)>='0')&&(buf.charAt(buf.length()-1)<='9'))
                {
                    buf = buf+"+";
                    refresh();
                }
                break;

            case R.id.imageButton8://btnSub
                sp.play(soundID_btnSub,volume,volume,1,0,1);
                if(buf.length()==0)
                {
                    buf = buf+"-";
                    refresh();
                }
                else if((buf!="")&&(buf.charAt(buf.length()-1)>='0')&&(buf.charAt(buf.length()-1)<='9'))
                {
                    buf = buf+"-";
                    refresh();
                }
                break;

            case R.id.imageButton12://btnMul
                sp.play(soundID_btnMul,volume,volume,1,0,1);
                if((buf!="")&&(buf.charAt(buf.length()-1)>='0')&&(buf.charAt(buf.length()-1)<='9'))
                {
                    buf = buf+"*";
                    refresh();
                }
                break;

            case R.id.imageButton16://btnDiv
                sp.play(soundID_btnDiv,volume,volume,1,0,1);
                if((buf!="")&&(buf.charAt(buf.length()-1)>='0')&&(buf.charAt(buf.length()-1)<='9'))
                {
                    buf = buf+"/";
                    refresh();
                }
                break;

            case R.id.imageButton20://btnEqual
                sp.play(soundID_btnEqual,volume,volume,1,0,1);
                think();
                break;

            case R.id.imageButton17://btnPercent
                sp.play(soundID_btnPercent,volume,volume,1,0,1);

            {
             if((buf!="")&&(buf.charAt(buf.length()-1)>='0')&&(buf.charAt(buf.length()-1)<='9'))
                {
                    try{
                        buf = ""+Double.parseDouble(buf)/100;
                    }catch(Exception e){
                        for(int i=buf.length()-1;i>=0;i--)
                        {
                            if(buf.charAt(i)=='.'){
                                //什么也不做
                            }
                            else if(buf.charAt(i)=='-'&&buf.charAt(i-1)=='E'){
                                i--;
                                i--;
                            }
                            else if(buf.charAt(i)>'9'||buf.charAt(i)<'0'){
                                bufStr1 = buf.substring(0,i+1);
                                bufStr2 = buf.substring(i+1);
                                break;
                            }
                        }
                        if(bufStr2.length()!=0&&bufStr1.length()!=0)
                        {
                            bufStr2 = ""+Double.parseDouble(bufStr2)/100;
                            buf = bufStr1+bufStr2;
                        }
                        bufStr1 ="";
                        bufStr2="";
                    }

                }
                refresh();
                break;
            }

            case R.id.imageButton19://btnDot
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

            case R.id.btnMore://btnMore
                sp.play(soundID_btnMore,volume,volume,1,0,1);
                Intent menuIntent = new Intent(MainActivity.this,MenuActivity.class);
                menuIntent.putExtra("title","0");
                startActivity(menuIntent);
                break;

        }
    }



    public void refresh()
    {
        buffer = buf;
        buffer = buffer.replace('/','÷');
        buffer = buffer.replace('*','×');
        main_tv1.setText(buffer);
    }

     public void think(){
         String expression = buf;
         double result = Calculator.conversion(expression);

         if(buf.length()==1||buf.length()==0)
         {
             main_tv2.setText(buf);
         }
        else if(Double.isNaN(result)){
             main_tv2.setText("不能除以0");
         }
         else if(result==(int)result){
             main_tv2.setText(""+(int)result);
         }
         else {
            main_tv2.setText(""+result);
     }
     }

    public static boolean isNumeric(String str){
        for (int i = str.length();--i>=0;){
            if (!Character.isDigit(str.charAt(i))){
                return false;
            }
        }
        return true;
    }
    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    public native String stringFromJNI();
}
