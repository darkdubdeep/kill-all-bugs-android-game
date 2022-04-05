package com.ibragimov.killallbugs;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;

public class MainActivity2 extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new Panel(this));
    }
    class Panel extends View {
        public Panel (Context context){
            super(context);
        }
        @Override
        public void onDraw(@NonNull Canvas c){
            Paint p=new Paint();
            p.setColor(Color.rgb(70, 130, 180));
            //Color.rgb(70, 130, 180)
//            p.setStyle(Paint.Style.FILL);
//            c.drawRect(50,50,150,150,p);
            SharedPreferences settings=getPreferences(0);
            int bugs;
            bugs=getResources().getInteger(R.integer.bugsCount);
            for(int l=0; l<=bugs; l++){
                Bitmap b= BitmapFactory.decodeResource(getResources(),
                        R.drawable.bug);
                c.drawBitmap(b, (float) (Math.random() * 1000), (float) (Math.random() * 1000),p);
            }
            CountDownTimer cdt = null;
            if(cdt == null) {
                cdt = new CountDownTimer(50000, 1000) {
                    public void onTick(long millisUntilFinished) {
                        invalidate(); //перерисоватьэкран
                    }

                    public void onFinish() {
                        this.start(); //по окончанию вызвать повторно
                    }
                };
                cdt.start();
            }
        }
    }
}