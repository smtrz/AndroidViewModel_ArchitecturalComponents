package com.highbryds.shoppinglistforromania_mvvm;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import com.highbryds.shoppinglistforromania_mvvm.Room.DbRepository;
import com.highbryds.shoppinglistforromania_mvvm.Room.ShoppingItem;

import java.util.List;

import javax.inject.Inject;

public class MainActivityViewModel extends AndroidViewModel {
    LiveData<List<ShoppingItem>> ListShoppingItems;

    @Inject
    DbRepository dbrepo;

    public MainActivityViewModel(Application application) {
        super(application);

        App.getApp().getAppLevelComponent().inject(this);
        //  dbrepo = DbRepository.getInstance(application);

    }


    LiveData<List<ShoppingItem>> getAllItems() {
        return dbrepo.getAllShoppingItems();

    }

    public void insert(ShoppingItem shopingitem) {
        dbrepo.insertItems(shopingitem);

    }

}
