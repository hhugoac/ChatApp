package com.chat.messenger.login;

import android.content.Context;

public interface LoginRepository {
    void signUp(String email, String password);
    void signIn(String email, String password);
    void checkSession();
}
