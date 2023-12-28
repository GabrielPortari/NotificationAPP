package com.example.notificationapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.notificationapp.api.NotificationService;
import com.example.notificationapp.model.Notification;
import com.example.notificationapp.model.NotificationData;
import com.google.firebase.messaging.FirebaseMessaging;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private Retrofit retrofit;
    private String baseUrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /* Ativar tópicos de notificações */
        FirebaseMessaging.getInstance().subscribeToTopic("Topico1");
        /* Desativar tópicos */
        FirebaseMessaging.getInstance().unsubscribeFromTopic("Topico1");

        /* Enviando notificações com retrofit */
        baseUrl = "https://fcm.googleapis.com/fcm/";
        retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public void enviarNotificacao(View view){
        String to = "/topics/topicoInscrito";
        /*
        to = TOKEN DE OUTRO USUARIO
        to = TOPICOS INSCRITOS DE UM USUARIO
        ENFIM
         */
        //montar objeto de notificacao
        Notification notification = new Notification("Titulo", "Mensagem");
        NotificationData notificationData = new NotificationData(to, notification);

        NotificationService service = retrofit.create(NotificationService.class);
        Call<NotificationData> call = service.saveNotification(notificationData);
        call.enqueue(new Callback<NotificationData>() {
            @Override
            public void onResponse(Call<NotificationData> call, Response<NotificationData> response) {

            }

            @Override
            public void onFailure(Call<NotificationData> call, Throwable t) {

            }
        });
    }
}