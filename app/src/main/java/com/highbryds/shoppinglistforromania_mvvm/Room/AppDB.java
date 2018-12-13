package com.highbryds.shoppinglistforromania_mvvm.Room;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

@Database(entities = {ShoppingItem.class}, version = 1,exportSchema = false)
public abstract class AppDB extends RoomDatabase {


    public abstract ShoppingItemsDao shoppingDAO();
}
