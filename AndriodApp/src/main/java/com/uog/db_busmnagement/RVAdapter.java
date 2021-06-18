package com.uog.db_busmnagement;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RVAdapter extends RecyclerView.Adapter <RVAdapter.RVHolder>{
    Context context;
    List<Registeration> todoItemList;
    public RVAdapter(List<Registeration> todoItems) {
        todoItemList = todoItems;
    }

    @NonNull
    @Override
    public RVHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.listitem,parent ,false);
        context=parent.getContext();
        RVHolder rvholder=new RVHolder(view);
        return rvholder;
    }

    @Override
    public void onBindViewHolder(@NonNull RVHolder holder, int position) {
    holder.tvTitle.setText(todoItemList.get(position).getTitle());
    holder.btnView.setEnabled(todoItemList.get(position).isEnable());
        DBHelper helper=new DBHelper(context);
        holder.btnsee.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent i=new Intent(context,viewActivity.class);
                i.putExtra("name",todoItemList.get(position).getTitle());
                i.putExtra("seatno",todoItemList.get(position).getDescription());
                i.putExtra("phone",todoItemList.get(position).getPhone());
                i.putExtra("from",todoItemList.get(position).getFrom());
                i.putExtra("to",todoItemList.get(position).getTo());
                context.startActivity(i);
            }
        });
        holder.btnView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                String a = String.valueOf(todoItemList.get(position).getId());
                Toast.makeText(context,a,Toast.LENGTH_LONG).show();
                helper.deleteContact(todoItemList.get(position).getId());
                todoItemList.remove(position);
                notifyItemRemoved(position);
                notifyItemRangeChanged(position,todoItemList.size());
            }
        });

        holder.btnEdit.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
//                String title="";
                Intent intent=new Intent(context,UpdateActivity.class);
                intent.putExtra("id",todoItemList.get(position).getId());
                context.startActivity(intent);
//                title=intent.getStringExtra("Title");
//                holder.tvTitle.setText(title);
            }
        });
    }

    @Override
    public int getItemCount() {
        return todoItemList.size();
    }

    public static class RVHolder extends RecyclerView.ViewHolder
    {
       public TextView tvTitle;
       public ImageButton btnView;
        public ImageButton btnEdit;
        public ImageButton btnsee;
        public RVHolder(@NonNull View itemView) {
            super(itemView);
            tvTitle=((TextView)itemView.findViewById(R.id.textView2));
            btnView=(ImageButton) itemView.findViewById(R.id.btnView);
            btnEdit=(ImageButton) itemView.findViewById(R.id.btnedit);
            btnsee=(ImageButton) itemView.findViewById(R.id.btnsee);
        }
    }
}
