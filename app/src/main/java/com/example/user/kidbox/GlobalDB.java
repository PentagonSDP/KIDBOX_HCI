package com.example.user.kidbox;

import android.app.Application;
import android.content.Context;

/**
 * Created by hosneara on 11/22/17.
 */

public class GlobalDB extends Application {

    private SQLiteTodolist todolist;

    @Override
    public void onCreate() {
        super.onCreate();
        todolist = new SQLiteTodolist(getApplicationContext());
    }

    public SQLiteTodolist getDB() {
        return todolist;
    }
}
