package com.project.fileops.controller.operations.uploader;

import com.project.fileops.common.data.FileCreatorInput;
import com.project.fileops.common.data.FileReaderInput;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * created on: 08 12 2023
 * 11:02 am
 */

public class FileUploader implements Uploader{
    private static final Logger logger = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);
    @Override
    public byte[] read(FileReaderInput fileReaderInput) {
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
    public void save(FileCreatorInput fileCreatorInput) {
        try{
            String pathToFile = String.format("%s/%s/%s", fileCreatorInput.getPath(), fileCreatorInput.getUserId(), fileCreatorInput.getFileId());
            createDir(fileCreatorInput);
            OutputStream outputStream = new FileOutputStream(pathToFile);
            outputStream.write(fileCreatorInput.getContent());
            logger.info(fileCreatorInput.getFileId() + " uploaded");
            outputStream.close();
        }
        catch (Exception e){
            logger.error("Failure", e);
        }
    }

    private void createDir(FileCreatorInput fileCreatorInput){
        String pathToUser = String.format("%s/%s", fileCreatorInput.getPath(), fileCreatorInput.getUserId());
        try{
            Path path = Paths.get(pathToUser);
            if(!Files.exists(path)){
                Files.createDirectories(path);
                logger.info("user " + fileCreatorInput.getUserId() + " directory created");
                return;
            }
            logger.info("user " + fileCreatorInput.getUserId() + " directory exists");
        }
        catch (Exception e){
            logger.info("directory creation failed", e);
        }
    }
}
