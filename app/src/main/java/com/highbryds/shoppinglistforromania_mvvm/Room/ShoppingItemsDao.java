package com.highbryds.shoppinglistforromania_mvvm.Room;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface ShoppingItemsDao {

    @Insert
    void insertItem(ShoppingItem item);

    @Query("SELECT * from total_items")
    LiveData<List<ShoppingItem>> getallItems();

}
