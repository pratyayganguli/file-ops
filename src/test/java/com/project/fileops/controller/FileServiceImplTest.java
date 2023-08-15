package com.project.fileops.controller;

import com.project.fileops.common.data.EncryptedData;
import com.project.fileops.common.data.FileCreatorInput;
import com.project.fileops.common.data.FileReaderInput;
import com.project.fileops.controller.operations.decryptor.FileDecryptor;
import com.project.fileops.controller.operations.encryptor.AESKeyGenerator;
import com.project.fileops.controller.operations.encryptor.FileEncryptor;
import com.project.fileops.controller.operations.uploader.FileUploader;
import com.project.fileops.controller.operations.uploader.Uploader;
import org.junit.jupiter.api.Test;

import javax.crypto.SecretKey;
import java.util.UUID;

class FileServiceImplTest {

    /**
     * todo:
     * write a suite to generate random size files and upload them.
     * write the program in such a way that it will run for a specific amount of time.
     */

    private static final String DEFAULT_PATH = "src/external-resources/uploads";
    private static final String BUCKET_PATH = "src/external-resources/data";
    private static final String FILE_ID = "video-large.mp4";
    private static final String USER_ID = "pganguli5520@gmail.com";

    @Test
    void uploadTest(){
        Uploader uploader = new FileUploader();
        FileService fileService = new FileServiceImpl(uploader);
        FileReaderInput fileReaderInput = new FileReaderInput(FILE_ID, USER_ID, DEFAULT_PATH);
        EncryptedData encryptedData = getEncData();
        FileCreatorInput fileCreatorInput = new FileCreatorInput(FILE_ID, BUCKET_PATH, generateId(), encryptedData.getData());
        byte[] decryptedContent = genDecryptedBytes(encryptedData.getSecretKey(), encryptedData.getData());
        FileCreatorInput fileCreatorInput2 = new FileCreatorInput(FILE_ID, BUCKET_PATH, generateId(), decryptedContent);
        fileService.upload(fileReaderInput, fileCreatorInput);
        fileService.upload(fileReaderInput, fileCreatorInput2);

    }

    String generateId() {
        String prefix = UUID.randomUUID().toString();
        String suffix = UUID.randomUUID().toString();
        String userId = "-pganguli@gmail.com-";
        return prefix + userId + suffix;
    }

    EncryptedData getEncData(){
        AESKeyGenerator aesKeyGenerator = new AESKeyGenerator();
        FileEncryptor fileEncryptor = new FileEncryptor(aesKeyGenerator);
        FileReaderInput fileReaderInput = new FileReaderInput(FILE_ID, USER_ID, DEFAULT_PATH);
        Uploader uploader = new FileUploader();
        FileService fileService = new FileServiceImpl(uploader);
        byte[] contentInBytes = fileService.readBytes(fileReaderInput);
        return fileEncryptor.encrypt(contentInBytes);
    }

    byte [] genDecryptedBytes(SecretKey secretKey, byte[] encContent){
        FileDecryptor fileDecryptor = new FileDecryptor();
        return fileDecryptor.decrypt(secretKey, encContent);
    }
}