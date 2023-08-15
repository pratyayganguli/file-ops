package com.project.fileops.util.generators;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

/**
 * created on: 08 12 2023
 * 7:29 pm
 */

public class AESKeyGenerator implements Generator<SecretKey> {
    private static final Logger logger = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);
    @Override
    public SecretKey generate(int length) {
        try {
            KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
            keyGenerator.init(length);
            logger.info("aes key generated");
            return keyGenerator.generateKey();
        }
        catch (Exception e) {
            logger.error("key generation failed", e);
        }
        return null;
    }
}
