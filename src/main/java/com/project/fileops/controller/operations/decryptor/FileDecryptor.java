package com.project.fileops.controller.operations.decryptor;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;

/**
 * created on: 08 14 2023
 * 9:06 am
 */

public class FileDecryptor implements Decryptor {
    private static final Logger logger = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);
    @Override
    public byte[] decrypt(SecretKey secretKey, byte[] content) {
        try {
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            logger.info("file decrypted");
            return cipher.doFinal(content);
        }
        catch (Exception e){
            logger.error("encryption failure", e);
        }
        return null;
    }
}
