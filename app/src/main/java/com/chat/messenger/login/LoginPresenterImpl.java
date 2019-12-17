package com.chat.messenger.login;

import android.util.Log;

import com.chat.messenger.lib.GreenRobotEventBus;
import com.chat.messenger.login.events.LoginEvent;
import com.chat.messenger.login.ui.LoginView;

import org.greenrobot.eventbus.Subscribe;

public class LoginPresenterImpl implements LoginPresenter {

    private GreenRobotEventBus eventBus;
    private LoginView loginView;
    private LoginInteractor loginInteractor;

    public LoginPresenterImpl(LoginView loginView) {
        this.loginView = loginView;
        this.loginInteractor = new LoginInteractorImpl();
        this.eventBus = GreenRobotEventBus.getInstance();
    }

    @Override
    public void onDestroy() {
        loginView = null;
        eventBus.unRegister(this);
    }

    @Override
    public void onCreate() {
        eventBus.register(this);
    }

    @Override
    public void checkForAuthenticatedUser() {
        if (loginView != null) {
            loginView.disableInputs();
            loginView.showProgress();
        }
        loginInteractor.checkSession();
    }

    @Override
    public void validateLogin(String email, String password) {
        if (loginView != null) {
            loginView.disableInputs();
            loginView.showProgress();
        }
        loginInteractor.doSignIn(email, password);
    }

    @Override
    public void regiterNewUser(String email, String password) {
        if (loginView != null) {
            loginView.disableInputs();
            loginView.showProgress();
        }
        loginInteractor.doSignUp(email, password);
    }

    @Override
    @Subscribe
    public void onEventMainThread(LoginEvent loginEvent) {
        switch (loginEvent.getEventType()) {
            case LoginEvent.onSignInSuccess:
                onSignInSuccess();
                break;

            case LoginEvent.onSignUpSuccess:
                onSignUpSuccess();
                break;

            case LoginEvent.onSignInError:
                onSignInError(loginEvent.getErrorMessage());
                break;

            case LoginEvent.onSignUpError:
                onSignUpError(loginEvent.getErrorMessage());
                break;
            case LoginEvent.onFailedToRecoverSession:
                onFailedToRecoverSession();
                break;
        }
    }

    private void onFailedToRecoverSession() {
        if (loginView != null) {
            loginView.hideProgress();
            loginView.enableInputs();
        }
        Log.e("LoginPresenterImpl", "onFailedToRecoverSession");
    }

    private void onSignInSuccess(){
        if (loginView != null) {
            loginView.navigateToMainScreen();
        }
    }

    private void onSignUpSuccess(){
        if (loginView != null) {
            loginView.newUserSuccess();
        }
    }

    private void onSignInError(String error){
        if (loginView != null) {
            loginView.hideProgress();
            loginView.enableInputs();
            loginView.loginError(error);
        }
    }

    private void onSignUpError(String error){
        if (loginView != null) {
            loginView.hideProgress();
            loginView.enableInputs();
            loginView.newUserError(error);
        }
    }
}
