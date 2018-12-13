package com.highbryds.shoppinglistforromania_mvvm.Room;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "total_items")

public class ShoppingItem {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")

    public int id;

    public String getProductName() {
        return ProductName;
    }

    public void setProductName(String productName) {
        ProductName = productName;
    }

    @ColumnInfo(name = "ProductName")

    public String ProductName;
    @ColumnInfo(name = "CategoryName")

    public String CategoryName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategoryName() {
        return CategoryName;
    }

    public void setCategoryName(String categoryName) {
        CategoryName = categoryName;
    }
}
