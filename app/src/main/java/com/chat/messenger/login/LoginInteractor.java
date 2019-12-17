package com.chat.messenger.login;

import android.content.Context;

public interface LoginInteractor {
    void checkSession();
    void doSignUp(String email, String password);
    void doSignIn(String email, String password);
}
