package com.uog.db_busmnagement;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.HashMap;

public class DBHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "TODO_DataBase.db";
    public static final String TODO_TABLE_NAME = "Todos";
    public static final String TODO_COLUMN_ID = "id";
    public static final String TODO_COLUMN_Title= "title";
    public static final String TODO_COLUMN_DESCRIPTION = "description";
    public static final String TODO_COLUMN_PHONE = "phone";
    public static final String TODO_COLUMN_FORM = "form";
    public static final String TODO_COLUMN_TOO = "too";
    private HashMap hp;

    public DBHelper(Context context) {
        super(context, DATABASE_NAME , null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // TODO Auto-generated method stub
        db.execSQL(
                "create table " + TODO_TABLE_NAME  +
                        " (id integer primary key, title text,description text,phone text,form text,too text  )"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // TODO Auto-generated method stub
        //READ HERE
        db.execSQL("DROP TABLE IF EXISTS " + TODO_TABLE_NAME);
        onCreate(db);
        //PUT
    }

    public boolean insertContact (int id,String title, String description,String phone,String form,String too) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("id", id);
        contentValues.put("title", title);
        contentValues.put("description", description);
        contentValues.put("phone", phone);
        contentValues.put("form", form);
        contentValues.put("too", too);
        db.insert(TODO_TABLE_NAME, null, contentValues);
        return true;
    }

    public Cursor getData(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from Todos where id="+id+"", null );
        return res;
    }

    public int numberOfRows(){
        SQLiteDatabase db = this.getReadableDatabase();
        int numRows = (int) DatabaseUtils.queryNumEntries(db, TODO_TABLE_NAME);
        return numRows;
    }

    public boolean updateContact (Integer id ,String title, String description,String phone,String form,String too) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("id", id);
        contentValues.put("title", title);
        contentValues.put("description", description);
        contentValues.put("phone", phone);
        contentValues.put("form", form);
        contentValues.put("too", too);
        db.update("Todos", contentValues, "id = ? ", new String[] { Integer.toString(id) } );
        return true;
    }

    public Integer deleteContact (Integer id) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete("Todos",
                "id = ? ",
                new String[] { Integer.toString(id) });
    }

    public ArrayList<String> getAllTitles() {
        ArrayList<String> array_list = new ArrayList<String>();

        //hp = new HashMap();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from Todos", null );
        res.moveToFirst();

        while(res.isAfterLast() == false){
            array_list.add(res.getString(res.getColumnIndex(TODO_COLUMN_Title)));
            res.moveToNext();
        }
        return array_list;
    }
    public ArrayList<String> getAllDes() {
        ArrayList<String> array_list_Des = new ArrayList<String>();

        //hp = new HashMap();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from Todos", null );
        res.moveToFirst();

        while(res.isAfterLast() == false){
            array_list_Des.add(res.getString(res.getColumnIndex(TODO_COLUMN_DESCRIPTION)));
            res.moveToNext();
        }
        return array_list_Des;
    }
    public ArrayList<String> getAllPHONE() {
        ArrayList<String> array_list_Phone = new ArrayList<String>();

        //hp = new HashMap();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from Todos", null );
        res.moveToFirst();

        while(res.isAfterLast() == false){
            array_list_Phone.add(res.getString(res.getColumnIndex(TODO_COLUMN_PHONE)));
            res.moveToNext();
        }
        return array_list_Phone;
    }
    public ArrayList<String> getAllFROM() {
        ArrayList<String> array_list_from = new ArrayList<String>();

        //hp = new HashMap();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from Todos", null );
        res.moveToFirst();

        while(res.isAfterLast() == false){
            array_list_from.add(res.getString(res.getColumnIndex(TODO_COLUMN_FORM)));
            res.moveToNext();
        }
        return array_list_from;
    }
    public ArrayList<String> getAllTO() {
        ArrayList<String> array_list_to = new ArrayList<String>();

        //hp = new HashMap();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from Todos", null );
        res.moveToFirst();

        while(res.isAfterLast() == false){
            array_list_to.add(res.getString(res.getColumnIndex(TODO_COLUMN_TOO)));
            res.moveToNext();
        }
        return array_list_to;
    }
    public ArrayList<Integer> getAllid() {
        ArrayList<Integer> array_list_id = new ArrayList<Integer>();

        //hp = new HashMap();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from Todos", null );
        res.moveToFirst();

        while(res.isAfterLast() == false){
            array_list_id.add(res.getInt(res.getColumnIndex(TODO_COLUMN_ID)));
            res.moveToNext();
        }
        return array_list_id;
    }
}


