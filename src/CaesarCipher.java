public class CaesarCipher {

    private static final String alphabet = "abcdefghijklmnopqrstuvwxyz";

    public static String encrypt(String message, int key) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < message.length(); i++) {
            char aChar = message.charAt(i);
            int index = alphabet.indexOf(aChar);
            int newIndex = index + key;
            char charAt = alphabet.charAt(newIndex % 26);
            builder.append(charAt);
        }
        return builder.toString();
    }
    public String decrypt(String message, int key) {
        return null;
    }

    public static void main(String[] args) {
        String string = encrypt("abc", 3);
        System.out.println(string);
        String string2 = encrypt("bce", 80);
        System.out.println(string2);

    }
}
