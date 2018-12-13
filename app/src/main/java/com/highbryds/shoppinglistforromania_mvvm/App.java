package com.highbryds.shoppinglistforromania_mvvm;

import android.app.Application;

import com.highbryds.shoppinglistforromania_mvvm.Components.AppLevelComponent;
import com.highbryds.shoppinglistforromania_mvvm.Components.DaggerAppLevelComponent;
import com.highbryds.shoppinglistforromania_mvvm.Modules.ContextModule;
import com.highbryds.shoppinglistforromania_mvvm.Modules.DbRepoModule;


public class App extends Application {
    public static App app;
    public AppLevelComponent appComponent;


    public static App getApp() {
        return app;
    }


    public AppLevelComponent getAppLevelComponent() {
        return appComponent;
    }


    @Override
    public void onCreate() {
        super.onCreate();
        app = this;
// we only have to set constructor modules or context modules.
        appComponent = DaggerAppLevelComponent.builder()
                .contextModule(new ContextModule(this))
               .dbRepoModule(new DbRepoModule())

                .build();


    }


}
