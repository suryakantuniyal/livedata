package com.example.livedata;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

public class CustomViewModel extends AndroidViewModel {
    private MutableLiveData<Integer> liveData =
            new MutableLiveData<>();

    public CustomViewModel(@NonNull Application application) {
        super(application);
    }


        public MutableLiveData<Integer> getLiveData() {
            return liveData;
    }
}
