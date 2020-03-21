package com.dicoding.picodiploma.e_maos.ui.borrowing_history;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class BorrowingHistoryViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public BorrowingHistoryViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is borrowing history fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}