package com.example.sourdoughchronicles;

import android.app.Application;
import android.content.ContentValues;
import android.content.Intent;
import android.content.RestrictionEntry;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import static android.content.Intent.getIntent;

public class BakeryApplication extends Application {

    private static final String DB_NAME = "db_bakery_menu";
    private static final int DB_VERSION = 3;
    public static final String TABLE_NAME = "INGREDIENTS";
    public static final String COL_ITEM_NAME = "ITEM_NAME";
    public static final String COL_ING_1 = "ING1";
    public static final String COL_ING_2 = "ING2";
    public static final String COL_ING_3 = "ING3";
    public static final String COL_ING_4 = "ING4";
    public static final String COL_AMT_1 = "AMT1";
    public static final String COL_AMT_2 = "AMT2";
    public static final String COL_AMT_3 = "AMT3";
    public static final String COL_AMT_4 = "AMT4";

    private SQLiteOpenHelper helper;
    private static final String DROP_TABLE = "DROP TABLE IF EXISTS "+ TABLE_NAME;

    @Override
    public void onCreate() {

        helper = new SQLiteOpenHelper(this,DB_NAME,null,DB_VERSION){
            @Override
            public void onCreate(SQLiteDatabase db) {

                String createTableStatement = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME + " (" + COL_ITEM_NAME + " TEXT, " +
                        COL_ING_1 + " TEXT, " + COL_ING_2 + " TEXT, " + COL_ING_3 + " TEXT, " +
                        " " + COL_ING_4 + " TEXT, " + COL_AMT_1 + " INTEGER, " +
                        COL_AMT_2 + " INTEGER, " + COL_AMT_3 + " INTEGER, " + COL_AMT_4 + " INTEGER )";

                try{
                    db.execSQL(createTableStatement);
                }
                catch (Exception e) {
                    Toast.makeText(BakeryApplication.this, "Error while creating the table", Toast.LENGTH_SHORT).show();
                }


            }

            @Override
            public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
                db.execSQL(DROP_TABLE);//Drops existing table
                onCreate(db);
            }
        };
        super.onCreate();
    }

    public void addBoule(){

        SQLiteDatabase db = helper.getWritableDatabase();

        db.execSQL("INSERT INTO INGREDIENTS (ITEM_NAME,ING1,ING2,ING3,ING4,AMT1,AMT2,AMT3,AMT4) VALUES ('Boule','Rye Flour'," +
                "'Wheat Flour','Ap Flour','Sourdough starter',25,51,356,92)");


    }
    public List<String> getBoule(){
        SQLiteDatabase db = helper.getReadableDatabase();
        List<String> bouleList = new ArrayList<>();
        Cursor cursor = db.rawQuery("SELECT * FROM INGREDIENTS WHERE ITEM_NAME = ?",new String []{"Boule"});

        cursor.moveToFirst();
        if (cursor!=null && cursor.getCount() > 0){
            if (cursor.moveToFirst()){
                do {
                    bouleList.add(cursor.getString(1));
                    bouleList.add(cursor.getString(2));
                    bouleList.add(cursor.getString(3));
                    bouleList.add(cursor.getString(4));
                    bouleList.add(String.valueOf(cursor.getInt(5)));
                    bouleList.add(String.valueOf(cursor.getInt(6)));
                    bouleList.add(String.valueOf(cursor.getInt(7)));
                    bouleList.add(String.valueOf(cursor.getInt(8)));

                }while (cursor.moveToNext());
            }
        }

        cursor.close();

        return bouleList;

    }

}
