package com.project.fileops.common.data;

import javax.crypto.SecretKey;

/**
 * created on: 08 14 2023
 * 9:14 am
 */

public class EncryptedData {
    private SecretKey secretKey;
    private byte[] data;

    public EncryptedData(SecretKey secretKey, byte[] data) {
        this.secretKey = secretKey;
        this.data = data;
    }

    public SecretKey getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(SecretKey secretKey) {
        this.secretKey = secretKey;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }
}
