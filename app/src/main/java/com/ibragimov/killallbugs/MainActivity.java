package com.ibragimov.killallbugs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputLayout;

import java.util.Objects;

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
    @Override
    protected void onStop() {
        super.onStop();

        // save player name to settings
        TextInputLayout nameTextInput = (TextInputLayout)findViewById(R.id.nameInput);
        String playerName = String.valueOf(Objects.requireNonNull(nameTextInput.getEditText()).getText());
        SharedPreferences settings=getPreferences(0);
        SharedPreferences.Editor editor=settings.edit();
        editor.putString("playerName",playerName);

        // save bugs count to settings
        EditText bugsCountInput = (EditText)findViewById(R.id.editTextNumber);
        int bugsCoung = Integer.parseInt(String.valueOf(bugsCountInput.getText()));
        editor.putInt("bugsCount",bugsCoung);
        editor.apply();
    }
}