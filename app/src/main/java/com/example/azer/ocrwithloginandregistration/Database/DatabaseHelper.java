package com.example.azer.ocrwithloginandregistration.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.azer.ocrwithloginandregistration.Model.User;

import java.util.ArrayList;

/**
 * Created by azeR on 11/6/2017.
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String TAG = DatabaseHelper.class.getName();


    // Database name and table name and version
    private static final String DATABASE_NAME = "userprofile";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_NAME = "user";


    // Column name

    private static final String KEY_ID = "id";
    private static final String KEY_CREATED_AT="created_at";
    private static final String KEY_NAME="name";
    private static final String KEY_EMAIL="email";
    private static final String KEY_PHONE="phone";
    private static final String KEY_DOB="dateofbirth";
    private static final String KEY_ADDRESS="address";


    //CREATE TABLE QUERY

    private static final String CREATE_TABLE_CONTACT = " CREATE TABLE " + TABLE_NAME + "(" + KEY_ID + " INTEGER PRIMARY KEY , " + KEY_NAME + " TEXT , "  + KEY_EMAIL + " TEXT , " + KEY_PHONE + " TEXT , " + KEY_DOB + " TEXT , " + KEY_ADDRESS + " TEXT " +  ")";


    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public DatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version, DatabaseErrorHandler errorHandler) {
        super(context, name, factory, version, errorHandler);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_CONTACT);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(" DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public void insertInfo(User person) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_ID, person.getId());
        values.put(KEY_NAME, person.getName());
        values.put(KEY_EMAIL,person.getEmail());
        values.put(KEY_PHONE,person.getPhoneno());
        values.put(KEY_DOB,person.getDateofbirth());
        values.put(KEY_ADDRESS,person.getAddress());
        db.insert(TABLE_NAME, null, values);

        db.close();
    }
    public ArrayList<User> getData(String email) {
        ArrayList<User> Userlist = new ArrayList<User>();
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.query(true,TABLE_NAME,null,"email=?", new String[]{email}, null, null, null, null);

        // looping through all rows and adding to list
        if (cursor.getCount()>0) {
            cursor.moveToFirst();
            for (int i = 0; i < cursor.getCount(); i++) {
                User u=new User();
                u.setId(cursor.getInt(cursor.getColumnIndex(KEY_ID)));
                u.setName(cursor.getString(cursor.getColumnIndex(KEY_NAME)));
                u.setEmail(cursor.getString(cursor.getColumnIndex(KEY_EMAIL)));
                u.setPhoneno(cursor.getString(cursor.getColumnIndex(KEY_PHONE)));
                u.setDateofbirth(cursor.getString(cursor.getColumnIndex(KEY_DOB)));
                u.setAddress(cursor.getString(cursor.getColumnIndex(KEY_ADDRESS)));
                Userlist.add(u);
                cursor.moveToNext();
            }
            cursor.close();
        }

        return Userlist;

    }

}

