package com.encryption.fileencryption;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

// TO DO: CHANGE KEY TO STRING

public class Decryptor {
    private final byte decryptionKey;
    private final String path;

    public Decryptor(String decryptionKey, String path) {
        byte[] key = decryptionKey.getBytes();
        this.decryptionKey = key[0];
        this.path = path;
    }

    private byte[] decryptDecrypt(byte[] data) {
        byte[] result = new byte[data.length];
        for (int i = 0; i < data.length; i++) {
            result[i] = (byte) (data[i] ^ decryptionKey);
        }
        return result;
    }

    public void decryptFile() {
        try {
            byte[] encryptedContent = Files.readAllBytes(Paths.get(path));
            byte[] decryptedContent = decryptDecrypt(encryptedContent);

            // Write the decrypted content to a new file
            Path outputFilePath = Paths.get(path);
            Files.write(outputFilePath, decryptedContent);

            System.out.println("PDF file decrypted successfully!");
        } catch (IOException e) {
            System.err.println("An error occurred: " + e.getMessage());
        }
    }
}
