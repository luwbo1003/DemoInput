package com.example.information;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.widget.AdapterView;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    String music;
    EditText ed_name, ed_phone;
    TextView showages;
    Switch switchGender;
    CheckBox checkSport;
    RadioGroup fav;
    Spinner cer;
    RadioButton rock,pop, rap;
    SeekBar ages;
    Button btn_res, btn_cancel;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ed_name = findViewById(R.id.ed_Name);
        ed_phone = findViewById(R.id.ed_Phone);
        switchGender = findViewById(R.id.switch_Gender);
       checkSport = findViewById(R.id.checkBox_Sport);
       cer = findViewById(R.id.spinner_Cer);
       rock = findViewById(R.id.raBtn_Rock);
       pop = findViewById(R.id.raBtn_Pop);
       rap = findViewById(R.id.raBtn_Rap);
       showages = findViewById(R.id.tv_Age);
       ages = findViewById(R.id.seekBar_Age);
       fav = findViewById(R.id.radioBtnGr);

        btn_res = findViewById(R.id.btn_Register);
        btn_cancel = findViewById(R.id.btn_Cancel);

        btn_res.setOnClickListener(hi);
        btn_cancel.setOnClickListener(hi);

        ArrayList<String> arr = new ArrayList<>();
        arr.add("Cao Đẳng");
        arr.add("Đại Học");
        arr.add("Cao Học");
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, arr);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        cer.setAdapter(arrayAdapter);
        cer.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String level = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        ages.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                showages.setText(String.valueOf(progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        fav.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch(checkedId){
                    case R.id.raBtn_Rock:
                        music = rock.getText().toString();
                        break;
                    case R.id.raBtn_Pop:
                        music = pop.getText().toString();
                        break;
                    case R.id.raBtn_Rap:
                        music = rap.getText().toString();
                        break;
                }
            }
        });
    }
    public View.OnClickListener hi = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if ( v.getId() == R.id.btn_Register){
                String name = ed_name.getText().toString();
                String phone = ed_phone.getText().toString();
                Boolean sex = switchGender.isChecked();
                String certi = cer.getSelectedItem().toString();
                String age = showages.getText().toString();
                Boolean Sport =checkSport.isChecked();
                Info info = new Info(name, phone, sex, certi, age, Sport, music);
                Intent intent = new Intent(getApplicationContext(), FormActivity.class);
                intent.putExtra("keyinfo", info);
                startActivity(intent);
            } else {
                ed_name.setText("");
                ed_phone.setText("");
                switchGender.setChecked(false);
                cer.setSelection(0);
                ages.setProgress(1);
                checkSport.setChecked(false);
                rock.setChecked(true);
            }

        }
    };


}