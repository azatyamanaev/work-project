package ru.itis.services;

import org.springframework.web.multipart.MultipartFile;

public interface FileLoadService {
    void uploadFile(MultipartFile multipartFile);
    void downloadFile(String filename);
}
