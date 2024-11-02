package com.encryption.fileencryption;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


public class Decryptor {

    private static final byte ENCRYPTION_KEY = 0x5A;

    private static byte[] encryptDecrypt(byte[] data) {
        byte[] result = new byte[data.length];
        for (int i = 0; i < data.length; i++) {
            result[i] = (byte) (data[i] ^ ENCRYPTION_KEY);
        }
        return result;
    }

    Decryptor(){
        String encryptedPdfFilePath = "/Users/syrux/Desktop/Code/enc.pdf";
        String decryptedPdfFilePath = "/Users/syrux/Desktop/Code/enc.pdf";

        try {
            byte[] encryptedContent = Files.readAllBytes(Paths.get(encryptedPdfFilePath));
            byte[] decryptedContent = encryptDecrypt(encryptedContent);

            // Write the decrypted content back to a new PDF file
            Path outputPath = Paths.get(decryptedPdfFilePath);
            Files.write(outputPath, decryptedContent);

            System.out.println("PDF file decrypted successfully!");
        } catch (IOException e) {
            System.err.println("An error occurred: " + e.getMessage());
        }
    }

}
