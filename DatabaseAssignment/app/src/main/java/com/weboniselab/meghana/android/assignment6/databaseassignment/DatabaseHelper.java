package com.weboniselab.meghana.android.assignment6.databaseassignment;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by webonise on 13/8/15.
 */
public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME="userDetails";
    private final String TABLE_NAME="details";
    public final String COLUMN_NAME="name";
    public final String COLUMN_AGE="age";
    public final String COLUMN_HEIGHT="height";
    public final String COLUMN_WEIGHT="weight";
    private static final int DB_VERSION=1;
    Context mcontext;

    public DatabaseHelper(Context context){
        super(context,DATABASE_NAME,null,DB_VERSION);
        mcontext=context;
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        db.execSQL(" CREATE TABLE " +TABLE_NAME+ " ( " +COLUMN_NAME+ " TEXT , " +COLUMN_AGE+ " INTEGER , "
        +COLUMN_HEIGHT+ " DOUBLE , " +COLUMN_WEIGHT+ " DOUBLE ) ");
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){

    }

    public void addDetailsToDatabase(UserDetails details){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME,details.getName());
        values.put(COLUMN_AGE,details.getAge());
        values.put(COLUMN_HEIGHT,details.getHeight());
        values.put(COLUMN_WEIGHT,details.getWeight());
        db.insert(TABLE_NAME, null, values);
        db.close();
    }

    public List<UserDetails> getAllDetails(){
        List<UserDetails> userDetailsList=new ArrayList<UserDetails>();
        String getDetailsQuery="SELECT * FROM " +TABLE_NAME;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(getDetailsQuery, null);
        try {
            if (cursor.moveToFirst()) {
                do {
                    UserDetails userDetails = new UserDetails();
                    userDetails.setName(cursor.getString(cursor.getColumnIndex(COLUMN_NAME)));
                    userDetails.setAge(Integer.parseInt(cursor.getString(cursor.getColumnIndex(COLUMN_AGE))));
                    userDetails.setHeight(Double.parseDouble(cursor.getString(cursor.getColumnIndex(COLUMN_HEIGHT))));
                    userDetails.setWeight(Double.parseDouble(cursor.getString(cursor.getColumnIndex(COLUMN_WEIGHT))));
                    userDetailsList.add(userDetails);
                } while (cursor.moveToNext());
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return userDetailsList;
    }
}
