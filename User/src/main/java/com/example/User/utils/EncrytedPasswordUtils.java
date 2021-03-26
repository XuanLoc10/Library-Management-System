package com.example.User.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class EncrytedPasswordUtils {

    // Encryte Password with BCryptPasswordEncoder
    public static String encrytePassword(String password) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder.encode(password);
    }

    public static boolean isMatched(String rawPassword, String encrtypedPassword) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder.matches(rawPassword, encrtypedPassword);
    }

    public static void main(String[] args) {
        String password = "123456";
        String encrytedPassword = encrytePassword(password);
        System.out.println("Encryted Password: " + encrytedPassword);
        String s = "$2a$10$la6nVcs.Z7bloVUz72FsWeXPj/cOI7kwtSpwfpClOX7cyO9z9Zf42";
        System.out.println("equals: " + isMatched(password, s));
    }
}
