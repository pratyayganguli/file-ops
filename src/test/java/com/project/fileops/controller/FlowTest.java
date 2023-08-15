package com.project.fileops.controller;

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
        var url = fileUploadFlow.getDownloadURL();
        System.out.println(url);
    }
}
