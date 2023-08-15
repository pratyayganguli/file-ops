package com.project.fileops.controller.operations.encryptor;

import com.project.fileops.common.data.EncryptedData;

/**
 * created on: 08 12 2023
 * 10:55 am
 */
public interface Encryptor {
    EncryptedData encrypt(byte[] input);
}
