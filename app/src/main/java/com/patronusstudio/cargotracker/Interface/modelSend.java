package com.patronusstudio.cargotracker.Interface;

import androidx.annotation.NonNull;

import com.patronusstudio.cargotracker.model.cargoes;
import com.patronusstudio.cargotracker.model.default_model;
import com.patronusstudio.cargotracker.model.personnel;
import com.patronusstudio.cargotracker.model.responseUserSave;

import java.util.List;

public interface modelSend {

    interface send{
        void send(@NonNull default_model model);

        void errorMessage(String message);
    }

    interface sendUser{
        void sendUser(personnel personel);

        void errorMessage(String message);

        void sendList(List<cargoes> liste);

    }

    interface savePersonel{

        void isStatus(boolean isSuccess,String message);

    }

    interface updateStatus{
        void update(responseUserSave response);
    }


}
