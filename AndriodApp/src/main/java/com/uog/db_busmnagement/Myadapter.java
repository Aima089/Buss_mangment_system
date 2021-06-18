package com.uog.db_busmnagement;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

public class Myadapter extends BaseAdapter {

    List<Registeration> todoItemList;

    public Myadapter(List<Registeration> itemList)
    {
        todoItemList = itemList;
    }

    @Override
    public int getCount() {
        return todoItemList.size();
    }

    @Override
    public Object getItem(int position) {
        return todoItemList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.listitem,parent ,false);

        ((TextView)view.findViewById(R.id.textView2)).setText(todoItemList.get(position).getTitle());
        view.findViewById(R.id.btnView).setEnabled(todoItemList.get(position).isEnable());
        Button viewbtn=(Button) view.findViewById(R.id.btnView);
        viewbtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Context context = parent.getContext();
                Intent i=new Intent(context,viewActivity.class);
                i.putExtra("name",todoItemList.get(position).getTitle());
                i.putExtra("seatno",todoItemList.get(position).getDescription());
                i.putExtra("phone",todoItemList.get(position).getPhone());
                i.putExtra("from",todoItemList.get(position).getFrom());
                i.putExtra("to",todoItemList.get(position).getTo());
                context.startActivity(i);

            }
        });
        Log.i("CUSTOM Adapter","Pos:"+position);

        return view;

    }
}

