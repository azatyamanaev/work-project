package ru.itis.aspects;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.itis.services.EmailSender;

@Aspect
@Component
@Slf4j
public class FileUploadAspect {

    @Autowired
    private EmailSender emailSender;

    @After(value = "execution(* ru.itis.services.FileLoadService.uploadFile(*))")
    public void after(JoinPoint joinPoint) {
        emailSender.sendLinkToUploadedFile();
    }
}
