package com.weboniselab.meghana.android.assignment6.fragmentandroidassignment;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by webonise on 20/8/15.
 */
public class DatabaseOperations extends SQLiteOpenHelper{

    private static final int DB_VERSION=1;
    Context mcontext;

    public DatabaseOperations(Context context){
        super(context,Constants.DATABASE_NAME,null,DB_VERSION);
        mcontext=context;
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        db.execSQL(" CREATE TABLE " +Constants.TABLE_NAME+ " ( " +Constants.COLUMN_ID+ " INTEGER PRIMARY KEY AUTOINCREMENT , " +Constants.COLUMN_NAME+ " TEXT , " +Constants.COLUMN_AGE+ " INTEGER , "
                +Constants.COLUMN_HEIGHT+ " DOUBLE , " +Constants.COLUMN_WEIGHT+ " DOUBLE ) ");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void addDetailsToDatabase(PersonDetails details){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(Constants.COLUMN_NAME,details.getName());
        values.put(Constants.COLUMN_AGE,details.getAge());
        values.put(Constants.COLUMN_HEIGHT,details.getHeight());
        values.put(Constants.COLUMN_WEIGHT,details.getWeight());
        db.insert(Constants.TABLE_NAME, null, values);
        db.close();
    }

    public List<PersonDetails> getAllDetails(){
        List<PersonDetails> personDetailsList=new ArrayList<PersonDetails>();
        String getDetailsQuery="SELECT * FROM " +Constants.TABLE_NAME;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(getDetailsQuery, null);
        try {
            if (cursor.moveToFirst()) do {
                PersonDetails personDetails = new PersonDetails();
                personDetails.setName(cursor.getString(cursor.getColumnIndex(Constants.COLUMN_ID)));
                personDetails.setName(cursor.getString(cursor.getColumnIndex(Constants.COLUMN_NAME)));
                personDetails.setAge(Integer.parseInt(cursor.getString(cursor.getColumnIndex(Constants.COLUMN_AGE))));
                personDetails.setHeight(Double.parseDouble(cursor.getString(cursor.getColumnIndex(Constants.COLUMN_HEIGHT))));
                personDetails.setWeight(Double.parseDouble(cursor.getString(cursor.getColumnIndex(Constants.COLUMN_WEIGHT))));
                personDetailsList.add(personDetails);
            } while (cursor.moveToNext());
        }catch (Exception e){
            e.printStackTrace();
        }
        return personDetailsList;
    }

    public void delete(int id){
        SQLiteDatabase db=this.getWritableDatabase();
        String deleteQuery=" DELETE FROM " +Constants.TABLE_NAME+ " WHERE " +Constants.COLUMN_ID+ " = " +id;
        db.rawQuery(deleteQuery,null);
        db.close();
    }

}
