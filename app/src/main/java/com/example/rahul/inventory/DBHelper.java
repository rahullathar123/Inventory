package com.example.rahul.inventory;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

/**
 * Created by rahul on 2017-12-26.
 */

public class DBHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "inventory.db";
    private static final int DB_VERSION =1;


    public static final String TABLE_NAME = "inventories";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_QUANTITY = "quantity";
    public static final String COLUMN_RESTOCK = "restock";
    public static final String COLUMN_PRICE = "price";

    public DBHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String query = String.format("CREATE TABLE " + TABLE_NAME + "("
                +COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                +COLUMN_NAME+ " TEXT NOT NULL, "
                +COLUMN_QUANTITY+ " INTEGER NOT NULL, "
                +COLUMN_RESTOCK+ " INTEGER NOT NULL, "
                +COLUMN_PRICE+ " INTEGER NOT NULL)",
                TABLE_NAME, COLUMN_ID, COLUMN_NAME, COLUMN_QUANTITY, COLUMN_RESTOCK, COLUMN_PRICE);

                db.execSQL(query);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        String query = String.format("DROP TABLE IF EXISTS "+ TABLE_NAME);
        db.execSQL(query);
        onCreate(db);

    }

    public void insertNewData(String name,int quantity,int restock,int price){

        SQLiteDatabase db =this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME, name);
        values.put(COLUMN_QUANTITY,quantity);
        values.put(COLUMN_PRICE,price);
        values.put(COLUMN_RESTOCK,restock);
        db.insertWithOnConflict(TABLE_NAME,null,values,SQLiteDatabase.CONFLICT_REPLACE);

    }


    public void updateData(long id,String name,int quantity,int restock,int price){

        SQLiteDatabase db =this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME, name);
        values.put(COLUMN_QUANTITY,quantity);
        values.put(COLUMN_PRICE,price);
        values.put(COLUMN_RESTOCK,restock);

        db.update(TABLE_NAME,values,"id = ?",new String[]{id + ""});

    }


    public void deleteData(long id){

        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_NAME,"id = ?", new String[]{id + ""});
    }

    public ArrayList<Inventory> getAllData(){

        ArrayList<Inventory> inventoryArrayList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM "+ TABLE_NAME,null);
        while(cursor.moveToNext()){

            final long id =cursor.getLong(cursor.getColumnIndex(COLUMN_ID));
            final String name = cursor.getString(cursor.getColumnIndex(COLUMN_NAME));
            final int quantity = cursor.getInt(cursor.getColumnIndex(COLUMN_PRICE));
            final int restock = cursor.getInt(cursor.getColumnIndex(COLUMN_RESTOCK));
            final int price = cursor.getInt(cursor.getColumnIndex(COLUMN_PRICE));
            inventoryArrayList.add(new Inventory(id,quantity,restock,price,name));
        }

        cursor.close();
        db.close();
        return inventoryArrayList;

    }




































































}
