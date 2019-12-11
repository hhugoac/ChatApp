package com.chat.messenger.login;

import android.util.Log;

import com.chat.messenger.domain.FirebaseHelper;

public class LoginRepositoryImpl implements LoginRepository {
    FirebaseHelper helper;

    public LoginRepositoryImpl() {
        this.helper = FirebaseHelper.getInstance();
    }

    @Override
    public void signUp(String email, String password) {
        Log.e("LoginRepositoryImpl", "signup");
    }

    @Override
    public void signIn(String email, String password) {
        Log.e("LoginRepositoryImpl", "signin");
    }

    @Override
    public void checkSession() {
        Log.e("LoginRepositoryImpl", "check session");
    }
}
