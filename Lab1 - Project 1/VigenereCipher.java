// VigenereCipher class to handle encryption and decryption
class VigenereCipher {
    private static final String KEY = "TMU";

    public static String encrypt(String text) {
        StringBuilder result = new StringBuilder();
        text = text.toUpperCase();
        int keyIndex = 0;
        for (char c : text.toCharArray()) {
            if (Character.isLetter(c)) {
                result.append((char) ('A' + (c - 'A' + (KEY.charAt(keyIndex) - 'A')) % 26));
                keyIndex = (keyIndex + 1) % KEY.length();
            } else {
                result.append(c);
            }
        }
        return result.toString();
    }

    public static String decrypt(String text) {
        StringBuilder result = new StringBuilder();
        text = text.toUpperCase();
        int keyIndex = 0;
        for (char c : text.toCharArray()) {
            if (Character.isLetter(c)) {
                result.append((char) ('A' + (c - 'A' - (KEY.charAt(keyIndex) - 'A') + 26) % 26));
                keyIndex = (keyIndex + 1) % KEY.length();
            } else {
                result.append(c);
            }
        }
        return result.toString();
    }
}

