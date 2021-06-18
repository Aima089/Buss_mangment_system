package com.uog.db_busmnagement;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ListActivity extends AppCompatActivity {
    Button btnClick;
    // TextView txtMsg;
    RecyclerView rvTodoList;
    RecyclerView.LayoutManager layoutManager;
    int selectedItemIndex = 0;
    List<Registeration> todoItemList = new ArrayList<>();
    RVAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        btnClick = findViewById(R.id.clk); // new
        // txtMsg = findViewById(R.id.text1);

        //String[] months= {"Jan","Feb","Mar","Apr","May","Jun"};


        //todoItemList.add(new TodoItem("Home work 3","Android programming assingment", true));
        //todoItemList.add(new TodoItem("Home work 4","Android programming assingment", false));
        //todoItemList.add(new TodoItem("Home work 5","Android programming assingment", true));
        //todoItemList.add(new TodoItem("Home work 6","Android programming assingment", true));
        //todoItemList.add(new TodoItem("Brush your teeth","Android programming assingment", true));
//        todoItemList.add(new TodoItem("Use Perfume","Android programming assingment", true));
        rvTodoList = findViewById(R.id.rvTodoList);



        //ArrayAdapter monthAdapter = new ArrayAdapter<String>(this,
        //        android.R.layout.simple_list_item_1, todoItemList );
        layoutManager =new LinearLayoutManager(this);
        rvTodoList.setLayoutManager(layoutManager);

        myAdapter = new RVAdapter(todoItemList);
        rvTodoList.setAdapter(myAdapter);

//        File dir = Environment.getExternalStorageDirectory();
//
//        File mydatadir = new File(dir,"/MyData");
//        if(!mydatadir.exists())
//        {
//            mydatadir.mkdir();
//        }
//
//        File mydatafile = new File(mydatadir,"myfile.txt");
//
//        //txtMsg.setText(mydatafile.getAbsolutePath());
//
//        FileInputStream fis = null;
//
//        try {
//
//            fis = new FileInputStream(mydatafile);
//
//            int byteCount = 0;
//
//            StringBuilder stringBuilder = new StringBuilder();
//
//
//            do {
//                byte[] buffer = new byte[1024];
//                byteCount = fis.read(buffer);
//                stringBuilder.append(new String(buffer));
//
//            }while(byteCount!=-1);
//
//            fis.close();
//
//            String strData = stringBuilder.toString();
//
//            String[] strItems = strData.split("\n");
//
//            for(String item: strItems) {
//                if(item.length() > 5) {
//                    //Log.i("STORAGE", item);
//                    todoItemList.add(new Registeration(item));
//                }
//            }
//            myAdapter.notifyDataSetChanged();
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

//        DBHelper dbhelper=new DBHelper(ListActivity.this);
//        DBHelper helper=new DBHelper(ListActivity.this);

        DBHelper listhelper=new DBHelper(ListActivity.this);
//        listhelper.insertContact(1,"Traveler1","employee","758187","gujrat","lahore");
        ArrayList<String> titles=listhelper.getAllTitles();
        ArrayList<String> Des=listhelper.getAllDes();
        ArrayList<String> phone=listhelper.getAllPHONE();
        ArrayList<String> from=listhelper.getAllFROM();
        ArrayList<String> to=listhelper.getAllTO();
        ArrayList<Integer> id=listhelper.getAllid();
//        Log.i("check",titles.get(0));
//        ArrayList<String> titles=dbhelper.getAllTitles();
//        ArrayList<String> Des=dbhelper.getAllDes();
//        //String str: titles
        for (int a=0; a<titles.size();a++)
        {
           todoItemList.add(new Registeration(id.get(a),titles.get(a),Des.get(a),phone.get(a),from.get(a),to.get(a),true));
        }
         myAdapter.notifyDataSetChanged();


        btnClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent abc = new Intent(ListActivity.this, FormActivity.class);
                //abc.putExtra("Month", months[selectedItemIndex]);
                startActivityForResult(abc, 786);
            }
        });

//        lvDays.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                //txtMsg.setText(months[position]);
//
//                selectedItemIndex = position;
//
//            }
//        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);


        if (requestCode == 786)
        {
            Toast.makeText(this,"result code="+resultCode, Toast.LENGTH_LONG).show();
            String returnValue1 = data.getStringExtra("Title");
            String returnValue2 = data.getStringExtra("Des");
            String returnValue3 = data.getStringExtra("Phone");
            String returnValue4 = data.getStringExtra("from");
            String returnValue5 = data.getStringExtra("to");
            int returnValue6 = data.getIntExtra("id",0);
            todoItemList.add(new Registeration(returnValue6,returnValue1,returnValue2,returnValue3,returnValue4,returnValue5, true));
            myAdapter.notifyDataSetChanged();
        }
    }


//    @Override
//    protected void onPause() {
//        super.onPause();
//        File dir = Environment.getExternalStorageDirectory();
//
//        File mydatadir = new File(dir,"/MyData");
//        if(!mydatadir.exists())
//        {
//            mydatadir.mkdir();
//        }
//
//        File mydatafile = new File(mydatadir,"myfile.txt");
//
//        txtMsg.setText(mydatafile.getAbsolutePath());
//
//        FileOutputStream fos = null;
//
//        try {
//
//            fos = new FileOutputStream(mydatafile);
//
//            //fos.write(mydatafile.getAbsolutePath().getBytes());
//
//            for(TodoItem item:  todoItemList)
//            {
//                fos.write(item.toString().getBytes());
//                fos.write(new String("\n").getBytes());
//            }
//
//            fos.close();
//
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

}