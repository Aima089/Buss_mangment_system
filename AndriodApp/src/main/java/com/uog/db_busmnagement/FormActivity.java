package com.uog.db_busmnagement;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.List;

public class FormActivity extends AppCompatActivity {

    public String Sitem= "";
    EditText SelecTsend;
    EditText SelecTsend2;
    EditText phone;
    EditText From;
    EditText to;
    Button okybtn;
    //    String Title="aliya";
//    String Des="20";
    boolean Enable  =false;
    StringBuilder stringBuilder;
    public static final String enable="";
    List<Registeration> todoItemList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);
        SelecTsend=findViewById(R.id.selectedvalue);
        SelecTsend2=findViewById(R.id.selectedvalue2);
        phone=findViewById(R.id.phone);
        From=findViewById(R.id.from);
        to=findViewById(R.id.to);
//        SelecTsend.setText(Sitem);
        okybtn=findViewById(R.id.okybtn);


        okybtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//             Bundle bundle = new Bundle();
//             bundle.putString("name", name);
//             bundle.putString("age", age);
//             bundle.putBoolean("status", status);
//                setResult(Activity.RESULT_OK);
                String Title=SelecTsend.getText().toString();
                String Des= SelecTsend2.getText().toString();
                String phonee=phone.getText().toString();
                String frome= From.getText().toString();
                String too=to.getText().toString();
                DBHelper listhelper=new DBHelper(FormActivity.this);
                ArrayList<Integer> id=listhelper.getAllid();
                int Y=0;
                int x=id.size();
                if(x!=0) {
                    Y = id.get(x - 1);
                    Y=Y+1;
                }
                else {
                    Y=x+1;
                }
               listhelper.insertContact(Y,Title,Des,phonee,frome,too);
                Log.i("idcheck",String.valueOf(x));

                Intent resultIntent = new Intent();
// TODO Add extras or a data URI to this intent as appropriate.
                resultIntent.putExtra("Title", Title);
                resultIntent.putExtra("Des", Des);
                resultIntent.putExtra("Phone", phonee);
                resultIntent.putExtra("from", frome);
                resultIntent.putExtra("to", too);
                resultIntent.putExtra("id", Y);
                setResult(Activity.RESULT_OK, resultIntent);
                finish();
            }
        });

    }
}