package com.highbryds.shoppinglistforromania_mvvm.Room;

import android.arch.persistence.room.Room;
import android.content.Context;

public class DbObject {
    private static AppDB ourInstance = null;

    private DbObject() {
    }

    public static AppDB getInstance(Context c) {
        if (ourInstance == null) {

            ourInstance = Room.databaseBuilder(c, AppDB.class, "userdb").build();

        }


        return ourInstance;
    }
}
