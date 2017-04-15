package com.example.ahsan.procom.Helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

/**
 * Created by AHSAN on 4/15/2017.
 */

public class SQLiteHelper extends SQLiteOpenHelper {

    private static String DATABASENAME = "PROCOM";
    private static int DATABASEVERSION = 1;

    private static String KEY_COURSENAME = "coursename";
    private static String KEY_SEMESTERNAME = "semestername";
    private static String KEY_TEACHERNAME = "teachername";

    private static String KEY_TABLENAME1 = "courses";
    private static String KEY_TABLENAME2 = "teachers";

    String[] columnsTABLE1 = {KEY_COURSENAME,
            KEY_SEMESTERNAME
    };

    String[] columnsTABLE2 = {KEY_COURSENAME,
            KEY_TEACHERNAME
    };
    public SQLiteHelper(Context context) {
        super(context, DATABASENAME, null, DATABASEVERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
      String Create_TABLE  =  "CREATE TABLE " + KEY_TABLENAME1 + "("
              + KEY_SEMESTERNAME + " TEXT, " + KEY_COURSENAME + " TEXT)";

        db.execSQL(Create_TABLE);

        Create_TABLE = "CREATE TABLE " + KEY_TABLENAME2 + "("
                + KEY_COURSENAME + " TEXT, " + KEY_TEACHERNAME + " TEXT)";

        db.execSQL(Create_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + KEY_TABLENAME1);
        db.execSQL("DROP TABLE IF EXISTS " + KEY_TABLENAME2);

        onCreate(db);
    }


    public void insertCourse(String semesterName,String courseName){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(KEY_SEMESTERNAME,semesterName);
        values.put(KEY_COURSENAME,courseName);

        db.insert(KEY_TABLENAME1,null,values);

        db.close();
    }

    public void insertTeacher(String courseName,String teacherName){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(KEY_TEACHERNAME,teacherName);
        values.put(KEY_COURSENAME,courseName);

        db.insert(KEY_TABLENAME2,null,values);

        db.close();
    }


    public ArrayList<String> getCourses(String semesterName){
        String where = KEY_SEMESTERNAME + "=?";
        String[] whereargs = {semesterName};

        ArrayList<String> courses = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(KEY_TABLENAME1, columnsTABLE1, where, whereargs, null, null, null);

        if(cursor.moveToFirst()){
            do{
                courses.add(cursor.getString(cursor.getColumnIndex(KEY_COURSENAME)));
            }while (cursor.moveToNext());
        }
        cursor.close();
        return courses;
    }


    public ArrayList<String> getTeachers(String courseName){
        String where = KEY_COURSENAME + "=?";
        String[] whereargs = {courseName};

        ArrayList<String> teachers = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(KEY_TABLENAME2, columnsTABLE2, where, whereargs, null, null, null);

        if(cursor.moveToFirst()){
            do{
                teachers.add(cursor.getString(cursor.getColumnIndex(KEY_TEACHERNAME)));
            }while (cursor.moveToNext());
        }
        cursor.close();
        return teachers;
    }
}
