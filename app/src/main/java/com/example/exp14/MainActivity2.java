package com.example.exp14;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    TextView t1,t2,t3,t4;
    @SuppressLint({"MissingInflatedId", "SetTextI18n"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Bundle bundle = getIntent().getExtras();
        if(bundle!=null)
        {
            String name = bundle.getString("name");
            String sub = bundle.getString("sub");
            String gen = bundle.getString("gen");
            String qua = bundle.getString("qua");

            t1 = findViewById(R.id.txt1);
            t2 = findViewById(R.id.txt2);
            t3 = findViewById(R.id.txt3);
            t4 = findViewById(R.id.txt4);

            t1.setText("Name :" + name);
            t2.setText("Subject :"+sub);
            t3.setText("Gender :"+gen);
            t4.setText("Qualification :"+qua);
        }
    }
}
