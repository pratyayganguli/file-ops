package com.project.fileops.controller;

import com.project.fileops.common.data.EncryptedData;
import com.project.fileops.common.data.FileCreatorInput;
import com.project.fileops.common.data.FileFormat;
import com.project.fileops.controller.operations.decryptor.FileDecryptor;
import com.project.fileops.controller.operations.uploader.FileUploader;
import com.project.fileops.controller.operations.uploader.Uploader;
import com.project.fileops.controller.services.FileServiceImpl;
import com.project.fileops.util.generators.EmailIdGenerator;
import com.project.fileops.util.generators.FileIdGenerator;
import com.project.fileops.util.generators.Generator;

/**
 * created on: 08 15 2023
 * 12:23 pm
 */

public class FileDownloadFlow {
    private static final Generator<String> generator = new FileIdGenerator(FileFormat.MP4);
    private static final String FILE_ID = generator.generate(35);
    private static final Generator<String> userIdGenerator = new EmailIdGenerator();
    private static final String USER_ID = userIdGenerator.generate(35);
    private static final String DOWNLOAD_PATH = "src/external-resources/downloads";

    void download(EncryptedData encryptedData){
        byte [] data = decrypt(encryptedData);
        FileCreatorInput fileCreatorInput = new FileCreatorInput(FILE_ID, DOWNLOAD_PATH, USER_ID, data);
        Uploader uploader = new FileUploader();
        new FileServiceImpl(uploader).download(fileCreatorInput.getPath() + "/" + FILE_ID, fileCreatorInput.getContent());
    }

    private byte[] decrypt(EncryptedData encryptedData){
        FileDecryptor fileDecryptor = new FileDecryptor();
        return fileDecryptor.decrypt(encryptedData.getSecretKey(), encryptedData.getData());
    }
}
