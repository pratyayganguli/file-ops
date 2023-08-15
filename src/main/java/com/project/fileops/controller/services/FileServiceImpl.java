package com.project.fileops.controller.services;

import com.project.fileops.common.data.FileCreatorInput;
import com.project.fileops.common.data.FileReaderInput;
import com.project.fileops.controller.operations.uploader.Uploader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;

public class FileServiceImpl implements FileService{
    private static final Logger logger = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);
    private final Uploader uploader;

    public FileServiceImpl(Uploader uploader) {
        this.uploader = uploader;
    }

    @Override
    public void upload(FileReaderInput fileReaderInput, FileCreatorInput fileCreatorInput) {
        fileCreatorInput.setContent(fileCreatorInput.getContent());
        uploader.save(fileCreatorInput);
    }

    @Override
    public void delete() {

    }

    @Override
    public byte[] readBytes(FileReaderInput fileReaderInput) {
        try{
            String pathToFile = String.format("%s/%s", fileReaderInput.getPath(), fileReaderInput.getFileId());
            FileInputStream fileInputStream = new FileInputStream(pathToFile);
            return fileInputStream.readAllBytes();
        }
        catch (Exception e){
            logger.error("Failure", e);
        }
        return null;
    }

    @Override
    public void download(String path, byte[] data) {
        try{
            OutputStream fileOutputStream = new FileOutputStream(path);
            fileOutputStream.write(data);
            logger.info("client is writing data " + path);
            fileOutputStream.close();
        }
        catch (Exception e){
            logger.error("file write failure", e);
        }
    }
}
