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

public class UpdateActivity extends AppCompatActivity {

    public String Sitem= "";
    EditText SelecTsend;
    EditText SelecTsend2;
    EditText phone;
    EditText From;
    EditText to;
    Button okybtn;
    RVAdapter myAdapter;
    int id,position;
    boolean Enable  =false;
    StringBuilder stringBuilder;
    public static final String enable="";
    List<Registeration> todoItemList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        SelecTsend=findViewById(R.id.selectedvalue);
        SelecTsend2=findViewById(R.id.selectedvalue2);
        phone=findViewById(R.id.phone);
        From=findViewById(R.id.from);
        to=findViewById(R.id.to);
//        SelecTsend.setText(Sitem);
        okybtn=findViewById(R.id.okybtn);
         id=getIntent().getIntExtra("id",0);
        position=getIntent().getIntExtra("position",0);
        okybtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//
                String Title=SelecTsend.getText().toString();
                String Des= SelecTsend2.getText().toString();
                String phonee=phone.getText().toString();
                String frome= From.getText().toString();
                String too=to.getText().toString();
                DBHelper listhelper=new DBHelper(UpdateActivity.this);

                listhelper.updateContact(id,Title,Des,phonee,frome,too);
                ArrayList<String> titles=listhelper.getAllTitles();
     //           Log.i("idcheck",titles.get(id+1));
               todoItemList.add(new Registeration(id,Title,Des,phonee,frome,too , true));
               myAdapter.notifyDataSetChanged();
//                Intent resultIntent = new Intent(UpdateActivity.this,ListActivity.class);
//                startActivity(resultIntent);
//                getIntent().putExtra("Title", titles.get(id-1));
//                setResult(Activity.RESULT_OK, resultIntent);
               finish();


            }
        });

    }
}