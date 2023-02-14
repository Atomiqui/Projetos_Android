package com.atomiqui.trabalhoapoo.ui.jogadores;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class JogadoresViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public JogadoresViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is slideshow fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}