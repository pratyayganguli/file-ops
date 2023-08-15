package com.project.fileops.controller.operations.encryptor;

import com.project.fileops.util.generators.AESKeyGenerator;
import org.junit.jupiter.api.Test;

import javax.crypto.SecretKey;

import java.util.Base64;

class AESKeyGeneratorTest {
    private final AESKeyGenerator aesKeyGenerator = new AESKeyGenerator();
    @Test
    public void generateKey(){
        SecretKey secretKey = aesKeyGenerator.generate(256);
        byte[] byteArr = secretKey.getEncoded();
        var base64Key = Base64.getEncoder().encodeToString(byteArr);
        System.out.println(base64Key);
    }
}