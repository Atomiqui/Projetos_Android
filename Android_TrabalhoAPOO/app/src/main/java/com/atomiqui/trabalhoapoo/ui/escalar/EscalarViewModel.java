package com.atomiqui.trabalhoapoo.ui.escalar;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class EscalarViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public EscalarViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is gallery fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}