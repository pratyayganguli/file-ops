package com.project.fileops.controller.operations.uploader;

import com.project.fileops.common.data.FileCreatorInput;
import com.project.fileops.common.data.FileReaderInput;

/**
 * created on: 08 12 2023
 * 10:54 am
 */
public interface Uploader {
    byte[] read(FileReaderInput fileReaderInput);
    void save(FileCreatorInput fileCreatorInput);
}
