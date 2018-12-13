package com.highbryds.shoppinglistforromania_mvvm.Room;

import android.arch.lifecycle.LiveData;
import android.content.Context;
import android.os.AsyncTask;

import java.util.List;

public class DbRepository {
    static DbRepository dbr = null;
    ShoppingItemsDao ShoppingItemsdao;
    LiveData<List<ShoppingItem>> ListShoppingItems;

    //            WeatherDao weatherDao, WeatherNetworkDataSource weatherNetworkDataSource,
//            AppExecutors executors) {
//        Log.d(LOG_TAG, "Getting the repository");
//        if (sInstance == null) {
//            synchronized (LOCK) {
//                sInstance = new SunshineRepository(weatherDao, weatherNetworkDataSource,
//                        executors);
//                Log.d(LOG_TAG, "Made new repository");
//            }
//        }
//        return sInstance;
//    }
    public DbRepository(Context application) {
        AppDB db = DbObject.getInstance(application);
        ShoppingItemsdao = db.shoppingDAO();
       // ListShoppingItems = ShoppingItemsdao.getallItems();

    }

    /*public synchronized static DbRepository getInstance(Context c) {
        if (dbr == null) {

            dbr = new DbRepository(c);

        }


        return dbr;


    }*/

    public LiveData<List<ShoppingItem>> getAllShoppingItems() {
        return ShoppingItemsdao.getallItems();

    }


    public void setListOfReceicve() {
        ListShoppingItems = ShoppingItemsdao.getallItems();


    }

    public void insertItems(ShoppingItem sms) {
        new insertAsyncTask(ShoppingItemsdao).execute(sms);
    }

    private static class insertAsyncTask extends AsyncTask<ShoppingItem, Void, Void> {

        private ShoppingItemsDao mAsyncTaskDao;

        insertAsyncTask(ShoppingItemsDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final ShoppingItem... params) {
            mAsyncTaskDao.insertItem(params[0]);
            return null;
        }
    }
}
