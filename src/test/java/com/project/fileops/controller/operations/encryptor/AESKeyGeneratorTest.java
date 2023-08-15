package com.project.fileops.controller.operations.encryptor;

import org.junit.jupiter.api.Test;

import javax.crypto.SecretKey;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

import static org.junit.jupiter.api.Assertions.*;

class AESKeyGeneratorTest {
    private final AESKeyGenerator aesKeyGenerator = new AESKeyGenerator();

    @Test
    public void generateKey(){
        SecretKey secretKey = aesKeyGenerator.generateKey();
        byte[] byteArr = secretKey.getEncoded();
        var base64Key = Base64.getEncoder().encodeToString(byteArr);
        System.out.println(base64Key);
    }
}