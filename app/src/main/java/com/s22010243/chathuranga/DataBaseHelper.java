package com.s22010243.chathuranga;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DataBaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "student.db";
    public static final String TABLE = "Student_Table";
    public static final String COL_01 = "ID";
    public static final String COL_02 = "S_Number";
    public static final String COL_03 = "Password";

    public DataBaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 1);
        // Optional initialization line (not required)
        // SQLiteDatabase db = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE + " (" +
                COL_01 + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COL_02 + " TEXT, " +
                COL_03 + " TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE);
        onCreate(db);
    }

    public boolean insertData(String Snumber, String Password) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_02, Snumber);
        contentValues.put(COL_03, Password);

        long result = db.insert(TABLE, null, contentValues);
        return result != -1;
    }
}
