package com.ddona.l2011jetpack.vm;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class SampleViewModel extends ViewModel {
    private MutableLiveData<Integer> number = new MutableLiveData<>();

    public SampleViewModel() {
        number.postValue(0);
    }

    public LiveData<Integer> getNumber() {
        return number;
    }

    public void increaseNumber() {
        number.postValue(number.getValue() + 1);
    }
}
