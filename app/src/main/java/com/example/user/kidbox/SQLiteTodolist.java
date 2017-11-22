package com.example.user.kidbox;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by hosneara on 11/21/17.
 */

public class SQLiteTodolist extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "TODOLIST";
    private static String DAILY_TABLE = "daily";
    private static String BONUS_TABLE = "bonus";

    private static final String KEY_ID = "id";
    private static final String TASK_NAME = "task_name";
    private static final String TASK_TYPE = "task_type";
    private static final String POINTS = "points";
    private static final String IS_DONE = "is_done";
    private static final String IMAGE_PATH = "image";

    private HashMap<String, Integer> map = new HashMap<>();


    public SQLiteTodolist(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public void setTableName(String tableName) {
        this.DAILY_TABLE = tableName;
        if (!map.containsKey(tableName))
            map.put(tableName, 0);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE_DAILY = "CREATE TABLE " + DAILY_TABLE + "("
                + KEY_ID + " INTEGER PRIMARY KEY," + TASK_NAME + " TEXT,"
                + TASK_TYPE + " INTEGER,"
                + POINTS + " INTEGER," + IS_DONE + " INTEGER," + IMAGE_PATH + " TEXT" + ")";

        String CREATE_TABLE_BONUS = "CREATE TABLE " + BONUS_TABLE + "("
                + KEY_ID + " INTEGER PRIMARY KEY," + TASK_NAME + " TEXT,"
                + TASK_TYPE + " INTEGER,"
                + POINTS + " INTEGER," + IS_DONE + " INTEGER," + IMAGE_PATH + " TEXT" + ")";

        db.execSQL(CREATE_TABLE_DAILY);
        db.execSQL(CREATE_TABLE_BONUS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + this.DAILY_TABLE);
        // Create tables again
        onCreate(db);
    }

    public void addTask(Tasks task) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(TASK_NAME, task.getTask_name()); // Tasks Name
        values.put(TASK_TYPE, task.getIsDaily());
        values.put(POINTS, task.getPoints()); // Tasks Phone Number
        values.put(IS_DONE, task.getIsDone());
        values.put(IMAGE_PATH, task.getImage_path());

        // Inserting Row
        db.insert(this.DAILY_TABLE, null, values);
        db.close(); // Closing database connection
    }

    public Tasks getTask(String taskName) {

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(DAILY_TABLE, new String[]{KEY_ID,
                        TASK_NAME, POINTS, IS_DONE, IMAGE_PATH}, TASK_NAME + "=?",
                new String[]{taskName}, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        Tasks task = new Tasks(cursor.getInt(0), cursor.getString(1), cursor.getInt(2),
                cursor.getInt(3),
                cursor.getInt(4), cursor.getString(5));
        // return contact
        return task;
    }

    public List<Tasks> getAllContacts() {
        List<Tasks> contactList = new ArrayList<Tasks>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + DAILY_TABLE;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Tasks contact = new Tasks();
                contact.setID(Integer.parseInt(cursor.getString(0)));
                contact.setTask_name(cursor.getString(1));
                contact.setIsDaily(cursor.getInt(2));
                contact.setPoints(cursor.getInt(3));
                contact.setIsDone(cursor.getInt(4));
                contact.setImage_path(cursor.getString(5));

                // Adding contact to list
                contactList.add(contact);
            } while (cursor.moveToNext());
        }
        return contactList;
    }



        // Updating single contact
    public int updateTaskList(Tasks contact) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(TASK_NAME, contact.getTask_name());
        values.put(TASK_TYPE, contact.getIsDaily());
        values.put(POINTS, contact.getPoints());
        values.put(IS_DONE, contact.getIsDone());
        values.put(IMAGE_PATH, contact.getImage_path());

        // updating row
        return db.update(this.DAILY_TABLE, values, KEY_ID + " = ?",
                new String[] { String.valueOf(contact.getID()) });
    }
    
    // Deleting single contact
    public void deleteContact(Tasks contact) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(this.DAILY_TABLE, KEY_ID + " = ?",
                new String[] { String.valueOf(contact.getID()) });
        db.close();
    }

}
