package com.example.newapplocation;

import com.example.newapplocation.core.di.UserScoped;

import dagger.Subcomponent;

@UserScoped
@Subcomponent(modules = {UserModule.class})
public interface UserComponent {
//    DashboardComponent plus(DashboardModule module);



}
