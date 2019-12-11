package com.chat.messenger.login;

public interface LoginPresenter {
    void onDestroy();
    void checkForAuthenticatedUser();
    void validateLogin(String email, String password);
    void regiterNewUser(String email, String password);
}
