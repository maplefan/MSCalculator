package com.example.dxf.calculator;

import android.app.Activity;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import java.math.BigDecimal;
/**
 * Created by DXF on 2017/11/24.
 */

public class Chinese_numberActivity extends Activity implements View.OnClickListener{

    Button main,programmer,temperature,chinese_number;
    SoundPool sp;
    private ImageButton btn0,btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btnAC,btnBack,btnVolume,btnEqual,btnDot,btnMore;
    private TextView chi_tv1,chi_tv2;
    String buf;
    float volume = 1f;
    int soundID_btnMore,soundID_btn0,soundID_btn1,soundID_btn2,soundID_btn3,soundID_btn4,soundID_btn5,soundID_btn6,soundID_btn7,soundID_btn8,soundID_btn9,
            soundID_btnAC,soundID_btnBack,soundID_btnVolume,soundID_btnEqual,soundID_btnDot;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chinese_number);


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

        chi_tv1 = (TextView)findViewById(R.id.chi_tv1);
        chi_tv2 = (TextView)findViewById(R.id.chi_tv2);

        ViewTreeObserver vto = chi_tv1.getViewTreeObserver();
        vto.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                chi_tv1.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                chi_tv1.setTextSize(TypedValue.COMPLEX_UNIT_PX,chi_tv1.getWidth()/720f*75);
                chi_tv2.setTextSize(TypedValue.COMPLEX_UNIT_PX,chi_tv1.getWidth()/720f*80);
            }
        });


        btn0 = (ImageButton)findViewById(R.id.chi_iBtn13);
        btn1 = (ImageButton)findViewById(R.id.chi_iBtn9);
        btn2 = (ImageButton)findViewById(R.id.chi_iBtn10);
        btn3 = (ImageButton)findViewById(R.id.chi_iBtn11);
        btn4 = (ImageButton)findViewById(R.id.chi_iBtn5);
        btn5 = (ImageButton)findViewById(R.id.chi_iBtn6);
        btn6 = (ImageButton)findViewById(R.id.chi_iBtn7);
        btn7 = (ImageButton)findViewById(R.id.chi_iBtn1);
        btn8 = (ImageButton)findViewById(R.id.chi_iBtn2);
        btn9 = (ImageButton)findViewById(R.id.chi_iBtn3);
        btnAC = (ImageButton)findViewById(R.id.chi_iBtn8);
        btnBack = (ImageButton)findViewById(R.id.chi_iBtn12);
        btnVolume = (ImageButton)findViewById(R.id.chi_iBtn4);
        btnEqual = (ImageButton)findViewById(R.id.chi_iBtn15);
        btnDot = (ImageButton)findViewById(R.id.chi_iBtn14);
        btnMore = (ImageButton)findViewById(R.id.chi_btnMore);

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

        buf = "";

    }


    public void onClick(View v){
        switch (v.getId()) {
            case R.id.chi_iBtn13://btn0
                sp.play(soundID_btn0,volume,volume,1,0,1);
                if((buf.indexOf(".")!=-1)&&(buf.indexOf(".")==buf.length()-3))
                {
                    break;
                }
                if(buf=="")
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

            case R.id.chi_iBtn9://btn1
                sp.play(soundID_btn1,volume,volume,1,0,1);
                if((buf.indexOf(".")!=-1)&&(buf.indexOf(".")==buf.length()-3))
                {
                    break;
                }
                if(buf=="")
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

            case R.id.chi_iBtn10://btn2
                sp.play(soundID_btn2,volume,volume,1,0,1);
                if((buf.indexOf(".")!=-1)&&(buf.indexOf(".")==buf.length()-3))
                {
                    break;
                }
                if(buf=="")
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

            case R.id.chi_iBtn11://btn3
                sp.play(soundID_btn3,volume,volume,1,0,1);
                if((buf.indexOf(".")!=-1)&&(buf.indexOf(".")==buf.length()-3))
                {
                    break;
                }
                if(buf=="")
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

            case R.id.chi_iBtn5://btn4
                sp.play(soundID_btn4,volume,volume,1,0,1);
                if((buf.indexOf(".")!=-1)&&(buf.indexOf(".")==buf.length()-3))
                {
                    break;
                }
                if(buf=="")
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

            case R.id.chi_iBtn6://btn5
                sp.play(soundID_btn5,volume,volume,1,0,1);
                if((buf.indexOf(".")!=-1)&&(buf.indexOf(".")==buf.length()-3))
                {
                    break;
                }
                if(buf=="")
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

            case R.id.chi_iBtn7://btn6
                sp.play(soundID_btn6,volume,volume,1,0,1);
                if((buf.indexOf(".")!=-1)&&(buf.indexOf(".")==buf.length()-3))
                {
                    break;
                }
                if(buf=="")
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

            case R.id.chi_iBtn1://btn7
                sp.play(soundID_btn7,volume,volume,1,0,1);
                if((buf.indexOf(".")!=-1)&&(buf.indexOf(".")==buf.length()-3))
                {
                    break;
                }
                if(buf=="")
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

            case R.id.chi_iBtn2://btn8
                sp.play(soundID_btn8,volume,volume,1,0,1);
                if((buf.indexOf(".")!=-1)&&(buf.indexOf(".")==buf.length()-3))
                {
                    break;
                }
                if(buf=="")
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

            case R.id.chi_iBtn3://btn9
                sp.play(soundID_btn9,volume,volume,1,0,1);
                if((buf.indexOf(".")!=-1)&&(buf.indexOf(".")==buf.length()-3))
                {
                    break;
                }
                if(buf=="")
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

            case R.id.chi_iBtn8://btnAC
                sp.play(soundID_btnAC,volume,volume,1,0,1);
                buf = "";
                refresh();
                break;

            case R.id.chi_iBtn12://btnBack
                sp.play(soundID_btnBack,volume,volume,1,0,1);
                if(buf.length()!=0)
                {
                    buf = buf.substring(0,buf.length()-1);
                }
                refresh();
                break;

            case R.id.chi_iBtn4://btnVolume

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

            case R.id.chi_iBtn15://btnEqual
                sp.play(soundID_btnEqual,volume,volume,1,0,1);
                if(Double.parseDouble(buf)>9999999999999.99)
                {
                    chi_tv1.setText("数值太大");
                }
                else if(buf.length()!=0){
                    think();
                }
                break;

            case R.id.chi_iBtn14://btnDot
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

            case R.id.chi_btnMore://btnMore
                sp.play(soundID_btnMore,volume,volume,1,0,1);
                finish();
                break;
        }
    }



    private static final String[] CN_UPPER_NUMBER = { "零", "一", "二", "三", "四",
            "五", "六", "七", "八", "九" };
    /**
     * 汉语中货币单位大写，这样的设计类似于占位符
     */
    private static final String[] CN_UPPER_MONETRAY_UNIT = { "分", "角", "元",
            "拾", "佰", "仟", "万", "拾", "佰", "仟", "亿", "拾", "佰", "仟", "兆", "拾",
            "佰", "仟" };
    /**
     * 特殊字符：整
     */
    private static final String CN_FULL = "整";
    /**
     * 特殊字符：负
     */
    private static final String CN_NEGATIVE = "负";
    /**
     * 金额的精度，默认值为2
     */
    private static final int MONEY_PRECISION = 2;
    /**
     * 特殊字符：零元整
     */
    private static final String CN_ZEOR_FULL = "零元" + CN_FULL;

    public static String number2CNMontrayUnit(BigDecimal numberOfMoney) {
        StringBuffer sb = new StringBuffer();
        // -1, 0, or 1 as the value of this BigDecimal is negative, zero, or
        // positive.
        int signum = numberOfMoney.signum();
        // 零元整的情况
        if (signum == 0) {
            return CN_ZEOR_FULL;
        }
        //这里会进行金额的四舍五入
        long number = numberOfMoney.movePointRight(MONEY_PRECISION)
                .setScale(0, 4).abs().longValue();
        // 得到小数点后两位值
        long scale = number % 100;
        int numUnit = 0;
        int numIndex = 0;
        boolean getZero = false;
        // 判断最后两位数，一共有四中情况：00 = 0, 01 = 1, 10, 11
        if (!(scale > 0)) {
            numIndex = 2;
            number = number / 100;
            getZero = true;
        }
        if ((scale > 0) && (!(scale % 10 > 0))) {
            numIndex = 1;
            number = number / 10;
            getZero = true;
        }
        int zeroSize = 0;
        while (true) {
            if (number <= 0) {
                break;
            }
            // 每次获取到最后一个数
            numUnit = (int) (number % 10);
            if (numUnit > 0) {
                if ((numIndex == 9) && (zeroSize >= 3)) {
                    sb.insert(0, CN_UPPER_MONETRAY_UNIT[6]);
                }
                if ((numIndex == 13) && (zeroSize >= 3)) {
                    sb.insert(0, CN_UPPER_MONETRAY_UNIT[10]);
                }
                sb.insert(0, CN_UPPER_MONETRAY_UNIT[numIndex]);
                sb.insert(0, CN_UPPER_NUMBER[numUnit]);
                getZero = false;
                zeroSize = 0;
            } else {
                ++zeroSize;
                if (!(getZero)) {
                    sb.insert(0, CN_UPPER_NUMBER[numUnit]);
                }
                if (numIndex == 2) {
                    if (number > 0) {
                        sb.insert(0, CN_UPPER_MONETRAY_UNIT[numIndex]);
                    }
                } else if (((numIndex - 2) % 4 == 0) && (number % 1000 > 0)) {
                    sb.insert(0, CN_UPPER_MONETRAY_UNIT[numIndex]);
                }
                getZero = true;
            }
            // 让number每次都去掉最后一个数
            number = number / 10;
            ++numIndex;
        }
        // 如果signum == -1，则说明输入的数字为负数，就在最前面追加特殊字符：负
        if (signum == -1) {
            sb.insert(0, CN_NEGATIVE);
        }
        // 输入的数字小数点后两位为"00"的情况，则要在最后追加特殊字符：整
        if (!(scale > 0)) {
            sb.append(CN_FULL);
        }
        return sb.toString();
    }

    public void refresh()
    {
        chi_tv2.setText(buf);
        chi_tv1.setText("");
    }

    public void think()
    {
        double money =Double.parseDouble(buf);
        BigDecimal numberOfMoney = new BigDecimal(money);
        String s = number2CNMontrayUnit(numberOfMoney);
        chi_tv1.setText(s);
    }
}
