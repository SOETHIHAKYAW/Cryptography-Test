package crypto;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import java.security.Key;

/**
 * @author soethihakyaw : 11/8/2023
 */
public class CryptoAES {

    public static void main(String[] args) throws Exception {
        // Generate a symmetric key (for example, AES)
        Key secretKey = generateAESKey();
        String charsetName = "UTF-8";

        // Text to be encrypted
        String originalText = "This is a secret message.";

        // Encrypt the text
        byte[] encryptedText = encryptText(secretKey, originalText);

        // Decrypt the text
        String decryptedText = decryptText(secretKey, encryptedText);

        // Display the results
        System.out.println("\nOriginal Text: " + originalText);
        byte[] originalTextSize = originalText.getBytes(charsetName);
        System.out.println("OriginalText Size : " + originalTextSize.length + " Bytes.\n");

        System.out.println("Encrypted Text: " + new String(encryptedText));
        System.out.println("EncryptedText Size : " + encryptedText.length + " Bytes.\n");

        System.out.println("Decrypted Text: " + decryptedText);
        byte[] decryptedTextSize = decryptedText.getBytes(charsetName);
        System.out.println("DecryptedText Size : " + decryptedTextSize.length + " Bytes.");

    }

    // Generate an AES key
    public static Key generateAESKey() throws Exception {
        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
        keyGenerator.init(128); // You can choose a different key size (e.g., 128, 192, or 256 bits)
        return keyGenerator.generateKey();
    }

    // Encrypt the text
    public static byte[] encryptText(Key key, String plaintext) throws Exception {
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, key);
        return cipher.doFinal(plaintext.getBytes());
    }

    // Decrypt the text
    public static String decryptText(Key key, byte[] ciphertext) throws Exception {
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.DECRYPT_MODE, key);
        byte[] decryptedBytes = cipher.doFinal(ciphertext);
        return new String(decryptedBytes);
    }
}
