package com.project.fileops.controller.operations.encryptor;


import com.project.fileops.common.data.EncryptedData;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;

/**
 * created on: 08 12 2023
 * 11:02 am
 */

public class FileEncryptor implements Encryptor{
    private final AESKeyGenerator aesKeyGenerator;
    private static final Logger logger = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);

    public FileEncryptor(AESKeyGenerator aesKeyGenerator) {
        this.aesKeyGenerator = aesKeyGenerator;
    }

    @Override
    public EncryptedData encrypt(byte[] input) {
        try {

            SecretKey secretKey = aesKeyGenerator.generateKey();
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            byte [] data = cipher.doFinal(input);
            EncryptedData encryptedData = new EncryptedData(secretKey, data);
            logger.info("file encrypted");
            return encryptedData;
        }
        catch (Exception e){
            logger.error("encryption failure", e);
        }
        return null;
    }
}
