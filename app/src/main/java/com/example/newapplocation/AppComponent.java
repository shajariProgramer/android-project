package com.example.newapplocation;

import com.example.newapplocation.data.DataModule;
import com.example.newapplocation.data.api.ApiModule;
import com.example.newapplocation.domain.entities.DomainModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {AppModule.class, DataModule.class, DomainModule.class, ApiModule.class})
public interface AppComponent {
    UserComponent plus(UserModule module);

//    SignInComponent plus(SignInModule module);
//
//    LoginComponent plus(LoginModule module);
}
