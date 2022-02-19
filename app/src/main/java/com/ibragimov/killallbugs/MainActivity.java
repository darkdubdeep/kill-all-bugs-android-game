package com.ibragimov.killallbugs;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView recordTextView = (TextView)findViewById(R.id.recordLabelValue);
        int recordScore;
        recordScore=getResources().getInteger(R.integer.record);
        recordTextView.setText(String.valueOf(recordScore));
    }
}