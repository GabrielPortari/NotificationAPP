package com.example.notificationapp.model;

public class NotificationData {
    /*
    Estrutura de dados para salvar no firebase
    {
        to: "topicos / token"
        notification: {
            title: "titulo da notificacao"
            body: "mensagem da notificacao"
        }
    }
     */
    private String to;
    private Notification notification;

    public NotificationData() {
    }

    public NotificationData(String to, Notification notification) {
        this.to = to;
        this.notification = notification;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public Notification getNotification() {
        return notification;
    }

    public void setNotification(Notification notification) {
        this.notification = notification;
    }
}
