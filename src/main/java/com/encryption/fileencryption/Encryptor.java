package com.encryption.fileencryption;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


public class Encryptor {

    private static final byte ENCRYPTION_KEY = 0x5A;

    private static byte[] encryptDecrypt(byte[] data) {
        byte[] result = new byte[data.length];
        for (int i = 0; i < data.length; i++) {
            result[i] = (byte) (data[i] ^ ENCRYPTION_KEY);
        }
        return result;
    }

    Encryptor(){
        String filePath = "/Users/syrux/Desktop/Code/enc.pdf";
        String encryptedFilePath = "/Users/syrux/Desktop/Code/enc.pdf";

        try {
            byte[] fileContent = Files.readAllBytes(Paths.get(filePath));
            byte[] encryptedContent = encryptDecrypt(fileContent);

            // Write encrypted content to a new file
            Path outputPath = Paths.get(encryptedFilePath);
            Files.write(outputPath, encryptedContent);

            System.out.println("File encrypted successfully!");
        } catch (IOException e) {
            System.err.println("An error occurred: " + e.getMessage());
        }
    }
}
