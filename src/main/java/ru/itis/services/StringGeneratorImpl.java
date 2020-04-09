package ru.itis.services;

import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class StringGeneratorImpl implements StringGenerator {

    @Override
    public String generateString() {
        String characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random random = new Random();
        char[] text = new char[62];
        for (int i = 0; i < text.length; i++) {
            text[i] = characters.charAt(random.nextInt(text.length));
        }
        return new String(text);
    }
}
