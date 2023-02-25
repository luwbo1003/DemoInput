package com.example.information;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.TextView;

public class FormActivity extends AppCompatActivity {
    TextView tv_name, tv_phone, tv_gender, tv_cer, tv_age, tv_sport, tv_music;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

        tv_name = findViewById(R.id.tv_Name);
        tv_phone = findViewById(R.id.tv_Phone);
        tv_gender = findViewById(R.id.tv_Gender);
        tv_cer = findViewById(R.id.tv_Cer);
        tv_age = findViewById(R.id.tv_Age);
        tv_sport = findViewById(R.id.tv_Sport);
        tv_music = findViewById(R.id.tv_Music);
        Bundle extra = getIntent().getExtras();

        Info info = (Info) extra.getSerializable("keyinfo");
        tv_name.setText(info.name);
        tv_phone.setText(info.phone);
        tv_age.setText(info.age);
        tv_cer.setText(info.level);
        tv_music.setText(info.music);
        if(info.gender)
            tv_gender.setText("Nữ");
        else
            tv_gender.setText("Nam");
        if (info.sport)
            tv_sport.setText("Có");
        else
            tv_sport.setText("Không");
    }
}