package com.project.fileops.controller;

import com.project.fileops.common.data.EncryptedData;
import com.project.fileops.common.data.FileCreatorInput;
import com.project.fileops.common.data.FileFormat;
import com.project.fileops.common.data.FileReaderInput;
import com.project.fileops.controller.operations.encryptor.AESKeyGenerator;
import com.project.fileops.controller.operations.encryptor.FileEncryptor;
import com.project.fileops.controller.operations.uploader.FileUploader;
import com.project.fileops.controller.operations.uploader.Uploader;
import com.project.fileops.controller.services.FileService;
import com.project.fileops.controller.services.FileServiceImpl;
import com.project.fileops.util.generators.EmailIdGenerator;
import com.project.fileops.util.generators.FileIdGenerator;
import com.project.fileops.util.generators.Generator;


class FileUploadFlow {
    private static final String DEFAULT_PATH = "src/external-resources/uploads";
    private static final String BUCKET_PATH = "src/external-resources/bucket";
    private static final String FILE_ID = "large-video.mp4";
    private static final int DEFAULT_LENGTH = 35;

    public EncryptedData upload(){
        Uploader uploader = new FileUploader();
        FileService fileService = new FileServiceImpl(uploader);
        FileReaderInput fileReaderInput = new FileReaderInput(FILE_ID, DEFAULT_PATH);
        EncryptedData encryptedData = getEncData();
        Generator<String> generator = new FileIdGenerator(FileFormat.MP4);
        String fileId = generator.generate(DEFAULT_LENGTH);
        FileCreatorInput fileCreatorInput = new FileCreatorInput(fileId, BUCKET_PATH, generateUserId(), encryptedData.getData());
        fileService.upload(fileReaderInput, fileCreatorInput);
        return encryptedData;
    }

    private String generateUserId() {
        Generator<String> generator = new EmailIdGenerator();
        return generator.generate(DEFAULT_LENGTH);
    }

    private EncryptedData getEncData(){
        AESKeyGenerator aesKeyGenerator = new AESKeyGenerator();
        FileEncryptor fileEncryptor = new FileEncryptor(aesKeyGenerator);
        FileReaderInput fileReaderInput = new FileReaderInput(FILE_ID, DEFAULT_PATH);
        Uploader uploader = new FileUploader();
        FileService fileService = new FileServiceImpl(uploader);
        byte[] contentInBytes = fileService.readBytes(fileReaderInput);
        return fileEncryptor.encrypt(contentInBytes);
    }
}