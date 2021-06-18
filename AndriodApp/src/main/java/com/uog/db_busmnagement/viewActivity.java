package com.uog.db_busmnagement;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class viewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);
        TextView namebtn;
        TextView seatbtn;
        TextView phonebtn;
        TextView frombtn;
        TextView TObtn;
        String name="";
        String seatno="";
        String phone="";
        String from="";
        String to="";

        namebtn=findViewById(R.id.NAME);
        seatbtn=findViewById(R.id.SEATNO);
        phonebtn=findViewById(R.id.PHONE);
        frombtn=findViewById(R.id.FROM);
        TObtn=findViewById(R.id.TO);
        name=getIntent().getStringExtra("name");
        seatno=getIntent().getStringExtra("seatno");
        phone=getIntent().getStringExtra("phone");
        from=getIntent().getStringExtra("from");
        to=getIntent().getStringExtra("to");
        namebtn.setText(name);
        seatbtn.setText(seatno);
        phonebtn.setText(phone);
        frombtn.setText(from);
        TObtn.setText(to);
    }
}