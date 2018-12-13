package com.highbryds.shoppinglistforromania_mvvm.Modules;

import android.content.Context;


import com.highbryds.shoppinglistforromania_mvvm.Room.DbRepository;
import com.highbryds.shoppinglistforromania_mvvm.Scopes.ActivityScope;

import dagger.Module;
import dagger.Provides;

@Module(includes = ContextModule.class)

public class DbRepoModule {



    @ActivityScope
    @Provides
    public DbRepository getRepository(Context c) {

        return new DbRepository(c);

    }
}
