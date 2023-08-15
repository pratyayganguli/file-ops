package com.project.fileops.controller;

import com.project.fileops.common.data.EncryptedData;
import org.junit.jupiter.api.Test;

/**
 * created on: 08 15 2023
 * 12:38 pm
 */

public class FlowTest {
    private final FileUploadFlow fileUploadFlow = new FileUploadFlow();
    private final FileDownloadFlow fileDownloadFlowTest = new FileDownloadFlow();

    @Test
    void test(){
        EncryptedData encryptedData = fileUploadFlow.upload();
        fileDownloadFlowTest.download(encryptedData);
    }
}
