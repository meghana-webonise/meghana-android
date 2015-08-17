package com.weboniselab.meghana.android.assignment6.listviewassignment;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by webonise on 17/8/15.
 */
public class OpenHelperDatabase extends SQLiteOpenHelper {

    public static final String DATABASE_NAME="personDetails";
    public final String TABLE_NAME="details";
    public final String COLUMN_NAME="name";
    public final String COLUMN_AGE="age";
    public final String COLUMN_HEIGHT="height";
    public final String COLUMN_WEIGHT="weight";
    private static final int DB_VERSION=1;
    Context mcontext;

    public OpenHelperDatabase(Context context){
        super(context,DATABASE_NAME,null,DB_VERSION);
        mcontext=context;
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        db.execSQL(" CREATE TABLE " +TABLE_NAME+ " ( " +COLUMN_NAME+ " TEXT , " +COLUMN_AGE+ " INTEGER , "
                +COLUMN_HEIGHT+ " DOUBLE , " +COLUMN_WEIGHT+ " DOUBLE ) ");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void addDetailsToDatabase(PersonDetails details){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME,details.getName());
        values.put(COLUMN_AGE,details.getAge());
        values.put(COLUMN_HEIGHT,details.getHeight());
        values.put(COLUMN_WEIGHT,details.getWeight());
        db.insert(TABLE_NAME, null, values);
        db.close();
    }

    public List<PersonDetails> getAllDetails(){
        List<PersonDetails> personDetailsList=new ArrayList<PersonDetails>();
        String getDetailsQuery="SELECT * FROM " +TABLE_NAME;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(getDetailsQuery, null);
        try {
            if (cursor.moveToFirst()) do {
                PersonDetails personDetails = new PersonDetails();
                personDetails.setName(cursor.getString(cursor.getColumnIndex(COLUMN_NAME)));
                personDetails.setAge(Integer.parseInt(cursor.getString(cursor.getColumnIndex(COLUMN_AGE))));
                personDetails.setHeight(Double.parseDouble(cursor.getString(cursor.getColumnIndex(COLUMN_HEIGHT))));
                personDetails.setWeight(Double.parseDouble(cursor.getString(cursor.getColumnIndex(COLUMN_WEIGHT))));
                personDetailsList.add(personDetails);
            } while (cursor.moveToNext());
        }catch (Exception e){
            e.printStackTrace();
        }
        return personDetailsList;
    }

    public void delete(){
        SQLiteDatabase db=this.getWritableDatabase();
        db.execSQL("DELETE FROM "+TABLE_NAME+" WHERE "+COLUMN_NAME+"='");
        db.close();
    }
}
