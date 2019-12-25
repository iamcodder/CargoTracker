package com.patronusstudio.cargotracker.Interface;

import androidx.annotation.NonNull;

import com.patronusstudio.cargotracker.model.default_model;
import com.patronusstudio.cargotracker.model.personnel;

public interface modelSend {

    interface send{
        void send(@NonNull default_model model);
    }

    interface sendUser{
        void sendUser(personnel personel);

    }


}
