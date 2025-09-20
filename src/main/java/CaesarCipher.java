public class CaesarCipher {

    private static final String alphabet = "abcdefghijklmnopqrstuvwxyz" + "ABCDEFGHIJKLMNOPQRSTUVWXYZ" +
            "абвгдеёжзийклмнопрстуфхцчшщъыьэюя" + "АБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ" +
            ".,\":!? +-*/\\@#$%^&(){}[];'|`~=_©«»—" + "0123456789";

    public String encrypt(String message, int key) {
        StringBuilder builder = new StringBuilder();
       for (char aChar : message.toCharArray()) {
            int index = alphabet.indexOf(aChar);
            if (index >= 0) {
                int newIndex = (index + key) % alphabet.length();
                char charAt = alphabet.charAt(newIndex < 0 ? newIndex + alphabet.length() : newIndex);
                builder.append(charAt);
            }

        }
        return builder.toString();
    }
    public String decrypt(String message, int key) {
        return encrypt(message, -key);
    }


}
