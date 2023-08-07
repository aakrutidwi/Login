package com.unoveo.secureutils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Encryption {

    public String encrypt(String input) {
        System.out.println("input from encrypt method >>>>>>>>>>>>>>>>>>>>>> " + input);
        String encryptedPassword = null;
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(input.getBytes());
            byte[] digest = md.digest();

            StringBuilder sb = new StringBuilder();
            for (byte b : digest) {
                sb.append(String.format("%02x", b & 0xff));
            }

            encryptedPassword = sb.toString();
            System.out.println("Plain-text password: " + input);
            System.out.println(encryptedPassword);
            return encryptedPassword;
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}
