package com.example.stp.findjob;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DBHandeller extends SQLiteOpenHelper {
    private static final String LOGCAT = null;
    private static final int DATABASE_VERSION=1;
    private static final String DATABASE_NAME="com.example.stp.findjob.Jobs.db";

    public static final String TABLE_JOBS="jobs";
    public static final String COLUMN_ID="_id";
    public static final String COLUMN_TITLE="jobTitle";
    public static final String COLUMN_DESC="description";
    public static final String COLUMN_CATEGORY="category";
    //public static final String COLUMN_ICON="icon";

    public static final  String TABLE_CANDIDATE="candidates";
    public static final  String COLUMN_ID_CANDIDATE="_id";
    public static final  String COLUMN_NAME="name";
    public static final  String COLUMN_AGE="age";
    public static final  String COLUMN_GENDER="gender";
    public static final  String COLUMN_EMAIL="email";
    public static final  String COLUMN_QUALIFICATION="qualification";



    public DBHandeller(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
        Log.d(LOGCAT,"Created");
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        //create table jobs
        String query1= "CREATE TABLE "+ TABLE_JOBS + "(" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT ," +
                COLUMN_TITLE + " VARCHAR(30) ," +
                COLUMN_DESC + " VARCHAR(100) ," +
                COLUMN_CATEGORY + " VARCHAR(30) " +
                ");";
        db.execSQL(query1);
        Log.d(LOGCAT,"table-jobs Created");

        //create table candidate
        String query2= "CREATE TABLE "+ TABLE_CANDIDATE + "(" +
                COLUMN_ID_CANDIDATE + " INTEGER PRIMARY KEY AUTOINCREMENT ," +
                COLUMN_NAME + " VARCHAR(30) ," +
                COLUMN_AGE + " VARCHAR(100) ," +
                COLUMN_GENDER + " VARCHAR(30) ," +
                COLUMN_EMAIL + " VARCHAR(30) ," +
                COLUMN_QUALIFICATION + " VARCHAR(30) " +
                ");";

        db.execSQL(query2);
        Log.d(LOGCAT,"table- candidate Created");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(" DROP TABLE IF EXISTS " + TABLE_JOBS);
        db.execSQL(" DROP TABLE IF EXISTS " + TABLE_CANDIDATE);
        onCreate(db);
    }

    //add jobs to jobs table
    public void addJob(Jobs job){
        ContentValues values= new ContentValues();
        values.put(COLUMN_TITLE,job.get_jobTitle());
        values.put(COLUMN_DESC,job.get_description());
        values.put(COLUMN_CATEGORY,job.get_category());
        SQLiteDatabase db=getWritableDatabase();
        long result=db.insert(TABLE_JOBS,null,values);
        if(result==-1){
            Log.d(LOGCAT,"Records insertion failed!");
        }else {
            Log.d(LOGCAT,"Records inserted successfully");
        }
        db.close();
    }


    //delete jobs
//    public void delete(){
//        SQLiteDatabase db=getWritableDatabase();
//        String q1="DELETE FROM " + TABLE_CANDIDATE;
//        db.execSQL(q1);
//    }

    //print jobs
    public String printJobs(){
        String dbString="";
        SQLiteDatabase db=getWritableDatabase();
        String query="SELECT * FROM " + TABLE_JOBS + "WHERE 1";

        //cursor point to the result set
        Cursor c=db.rawQuery(query,null);
        //point to the first raw
        c.moveToFirst();

        while (!c.isAfterLast()){
            if(c.getString(c.getColumnIndex("jobTitle"))!=null){
                dbString +=c.getString(c.getColumnIndex("jobTitle"));
                dbString +=c.getString(c.getColumnIndex("description"));
                dbString +=c.getString(c.getColumnIndex("category"));
                dbString+="\n";
            }

        }
        db.close();
        return dbString;
    }

    //add candidates
    public boolean addCandidates(Candidate candidate){
        ContentValues values= new ContentValues();
        values.put(COLUMN_NAME,candidate.getName());
        values.put(COLUMN_AGE,candidate.getAge());
        values.put(COLUMN_EMAIL,candidate.getEmail());
        values.put(COLUMN_GENDER,candidate.getGender());
        values.put(COLUMN_QUALIFICATION,candidate.getQualifications());
        SQLiteDatabase db=getWritableDatabase();
        long result=db.insert(TABLE_CANDIDATE,null,values);
        db.close();
        if(result==-1){
            Log.d(LOGCAT,"Records insertion failed!");
            return false;

        }else {
            Log.d(LOGCAT,"Records inserted successfully");
            return true;

        }
    }

    //print candidates
    public Cursor printCandidates(){
        SQLiteDatabase db=getWritableDatabase();
        String query="SELECT * FROM " + TABLE_CANDIDATE + "WHERE 1";

        //cursor point to the result set
        Cursor c=db.rawQuery(query,null);
        db.close();
        return c;
    }
}
