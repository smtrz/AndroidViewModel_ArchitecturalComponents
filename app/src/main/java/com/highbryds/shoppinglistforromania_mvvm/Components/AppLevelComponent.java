package com.highbryds.shoppinglistforromania_mvvm.Components;

import android.content.Context;


import com.highbryds.shoppinglistforromania_mvvm.MainActivityViewModel;
import com.highbryds.shoppinglistforromania_mvvm.Modules.ContextModule;
import com.highbryds.shoppinglistforromania_mvvm.Modules.DbRepoModule;
import com.highbryds.shoppinglistforromania_mvvm.Room.DbRepository;
import com.highbryds.shoppinglistforromania_mvvm.Scopes.ActivityScope;

import dagger.Component;

@ActivityScope
@Component(modules = {ContextModule.class, DbRepoModule.class})
public interface AppLevelComponent {
    void inject(MainActivityViewModel ma);

    Context getContet();
    DbRepository getrepo();
}
