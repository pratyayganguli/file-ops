package com.project.fileops.controller.operations.decryptor;

import javax.crypto.SecretKey;

/**
 * created on: 08 14 2023
 * 9:07 am
 */
public interface Decryptor {
    byte [] decrypt(SecretKey secretKey, byte[] content);
}
