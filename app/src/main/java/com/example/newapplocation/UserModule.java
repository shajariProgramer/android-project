package com.example.newapplocation;

import com.example.newapplocation.core.di.UserScoped;
import com.example.newapplocation.data.entities.FinanceCycleEntity;
import com.example.newapplocation.data.entities.PersonEntity;

import dagger.Module;
import dagger.Provides;

@Module
public class UserModule {
    private final PersonEntity mPersonEntity;

    UserModule(PersonEntity userEntity) {
        mPersonEntity = userEntity;
    }

    @Provides
    @UserScoped
    PersonEntity ProvideUserEntity() {
        return mPersonEntity;
    }

//    @Provides
//    @UserScoped
//    FinanceCycleEntity provideCurrentFinanceCycle(FinanceCycleDataSource dataSource) {
//        return dataSource.getCurrentFinanceCycle();
//    }
}
