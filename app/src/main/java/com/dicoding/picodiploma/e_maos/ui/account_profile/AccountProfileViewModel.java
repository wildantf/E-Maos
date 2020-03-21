package com.dicoding.picodiploma.e_maos.ui.account_profile;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class AccountProfileViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public AccountProfileViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is account profile fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}