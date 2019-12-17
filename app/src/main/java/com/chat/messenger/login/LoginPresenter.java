package com.chat.messenger.login;

import com.chat.messenger.login.events.LoginEvent;

public interface LoginPresenter {
    void onDestroy();
    void onCreate();
    void checkForAuthenticatedUser();
    void validateLogin(String email, String password);
    void regiterNewUser(String email, String password);
    void onEventMainThread(LoginEvent loginEvent);
}
