package com.project.fileops.controller;

import com.project.fileops.common.data.FileCreatorInput;
import com.project.fileops.common.data.FileReaderInput;

public interface FileService {
    void upload(FileReaderInput fileReaderInput, FileCreatorInput fileCreatorInput);
    void download(String path, byte[] data);
    void delete();
    byte[] readBytes(FileReaderInput fileReaderInput);

}
