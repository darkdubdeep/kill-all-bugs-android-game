package com.ibragimov.killallbugs;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
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
            p.setStyle(Paint.Style.FILL);
            c.drawRect(50,50,150,150,p);
        }
    }
}