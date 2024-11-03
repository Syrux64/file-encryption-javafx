package com.encryption.fileencryption;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Encryptor {
    private final byte encryptionKey;
    private final String path;

    public Encryptor(String encryptionKey, String path) {
        byte[] key = encryptionKey.getBytes();
        this.encryptionKey = key[0];
        this.path = path;
    }


    private byte[] encryptDecrypt(byte[] data) {
        byte[] result = new byte[data.length];
        for (int i = 0; i < data.length; i++) {
            result[i] = (byte) (data[i] ^ encryptionKey);
        }
        return result;
    }

    public void encryptFile() {
        try {
            byte[] fileContent = Files.readAllBytes(Paths.get(path));
            byte[] encryptedContent = encryptDecrypt(fileContent);

            Path outputPath = Paths.get(path);
            Files.write(outputPath, encryptedContent);

            System.out.println("File encrypted successfully!");
        } catch (IOException e) {
            System.err.println("An error occurred: " + e.getMessage());
        }
    }
}
