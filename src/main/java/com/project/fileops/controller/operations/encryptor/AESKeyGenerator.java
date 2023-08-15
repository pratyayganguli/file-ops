package com.project.fileops.controller.operations.encryptor;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

/**
 * created on: 08 12 2023
 * 7:29 pm
 */

public class AESKeyGenerator {
    private static final Logger logger = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);
    public SecretKey generateKey(){
        try {
            KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
            keyGenerator.init(256);
            return keyGenerator.generateKey();
        }
        catch (Exception e) {
            logger.error("key generation failed", e);
        }
        return null;
    }
}
