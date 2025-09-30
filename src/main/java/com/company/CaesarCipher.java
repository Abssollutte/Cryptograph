package com.company;

public class CaesarCipher {

    private static final String alphabet = "abcdefghijklmnopqrstuvwxyz" + "ABCDEFGHIJKLMNOPQRSTUVWXYZ" +
            "абвгдеёжзийклмнопрстуфхцчшщъыьэюя" + "АБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ" +
            ".,\":!? +-*/\\@#$%^&(){}[];'|`~=_©«»—" + "0123456789";;

    public String encrypt(String message, int key) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < message.length(); i++) {
            char aChar = message.charAt(i);
            int index = alphabet.indexOf(aChar);
            if (index >=0) {
                int newIndex = (index + key) % alphabet.length();
                char charAt;
                if (newIndex < 0) {
                    charAt = alphabet.charAt(newIndex+alphabet.length());
                }
                else {
                    charAt = alphabet.charAt(newIndex);
                }
                builder.append(charAt);
            }

        }
        return builder.toString();
    }

    public String decrypt(String message, int key) {
        return encrypt(message, key * -1);
    }

    public int alphabetLength() {
        return alphabet.length();
    }


}
