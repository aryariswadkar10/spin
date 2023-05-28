package com.example.exp14;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    EditText e1;
    CheckBox c1,c2,c3,c4;
    RadioButton rb;
    RadioGroup rg;
    Button b1;

    String[] subNames = {"FOC","AD","DM","IAE","DBM"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        e1 = findViewById(R.id.text);

        c1 = findViewById(R.id.cb1);
        c2 = findViewById(R.id.cb2);
        c3 = findViewById(R.id.cb3);
        c4 = findViewById(R.id.cb4);

        Spinner spin = findViewById(R.id.spin);
        rg = findViewById(R.id.rG);
        b1 = findViewById(R.id.button);

        spin.setOnItemSelectedListener(this);
        ArrayAdapter<String> aa = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item,subNames);
        aa.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spin.setAdapter(aa);

        b1.setOnClickListener(view -> {

            rb = findViewById(rg.getCheckedRadioButtonId());
            String name = e1.getText().toString();
            String sub = spin.getSelectedItem().toString();
            String gen = rb.getText().toString();
            String qua = "";

            if(c1.isChecked()){
                qua = qua +" " + c1.getText();
            }
            if(c2.isChecked()){
                qua = qua + ","+ c2.getText();
            }
            if(c3.isChecked()){
                qua = qua + ","+ c3.getText();
            }
            if(c4.isChecked()){
                qua = qua +","+  c4.getText();
            }
            String qua1 = qua;

            Bundle bundle = new Bundle();
            bundle.putString("name",name);
            bundle.putString("sub",sub);
            bundle.putString("gen",gen);
            bundle.putString("qua",qua1);

            Intent i = new Intent(MainActivity.this,MainActivity2.class);
            i.putExtras(bundle);
            startActivity(i);

        });

    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        Toast.makeText(this, subNames[i], Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
