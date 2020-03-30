package ru.itis.services;

public interface EmailSender {
    void sendNotificationAboutRegistration(String login);
    void sendLinkToUploadedFile();
}
