package com.example.notificationapp.api;

import com.example.notificationapp.model.NotificationData;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface NotificationService {
    @Headers({
            "Authorization:key=CHAVE-DO-SERVIDOR-AQUI",
            "Content-Type:application/json"
    })

    @POST("send")
    Call<NotificationData> saveNotification(@Body NotificationData notificationData);
}
